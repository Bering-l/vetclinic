package org.example.controller;

import org.example.entity.*;
import org.example.repository.AnimalTypeRepository;
import org.example.services.AnimalServices;
import org.example.services.MedicalRecordService;
import org.example.services.OwnerServices;
import org.example.view.AnimalCreateView;
import org.example.view.MedicalRecordView;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class ConsoleController {
    private final AnimalServices animalServices;
    private final MedicalRecordService medicalRecordService;
    private final MedicalRecordView medicalRecordView;
    private final AnimalCreateView animalCreateView;
    private final OwnerServices ownerServices;
    private final SessionFactory sessionFactory;


    public ConsoleController(AnimalServices animalService, MedicalRecordService medicalRecordService,
                             MedicalRecordView medicalRecordView, AnimalCreateView animalCreateView,
                             OwnerServices ownerServices, SessionFactory sessionFactory) {
        this.animalServices = animalService;
        this.medicalRecordService = medicalRecordService;
        this.medicalRecordView = medicalRecordView;
        this.animalCreateView = animalCreateView;
        this.ownerServices = ownerServices;
        this.sessionFactory = sessionFactory;
    }

    public void addNewMedicalRecord() {
        Long animalId = medicalRecordView.promptForAnimalId();
        Animal animal = animalServices.findAnimalForManipulate(animalId);
        if (animal != null) {
            MedicalRecord medicalRecord = getMedicalRecordFromInput(animal);
            medicalRecordService.addMedicalRecord(medicalRecord);
            medicalRecordView.displayMedicalRecordAdded(animalId);
        } else {
            medicalRecordView.displayAnimalNotFound(animalId);
        }
    }

    private MedicalRecord getMedicalRecordFromInput(Animal animal) {
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setAnimal(animal);

        medicalRecord.setComplaints(medicalRecordView.promptForComplaints());
        medicalRecord.setDateVisit(new Date());
        medicalRecord.setDiagnosis(medicalRecordView.promptForDiagnosis());
        medicalRecord.setDoctorSurname("Тестовый");

        MedicalRecord lastMedicalRecord = medicalRecordService.findLastMedicalRecordByAnimal(animal);
        if (lastMedicalRecord != null) {
            medicalRecord.setIsReproducible(lastMedicalRecord.getIsReproducible());
            medicalRecord.setWeight(lastMedicalRecord.getWeight());
        } else {
            medicalRecord.setIsReproducible(true);
        }

        return medicalRecord;
    }

    public void createAnimal(Scanner scanner) {
        System.out.print("Введите телефон владельца: ");
        String telephone = scanner.nextLine();

        Owner owner = ownerServices.checkOwnerBeforeCreate(telephone);

        if (owner == null) {
            System.out.println("Владелец не найден. Пожалуйста, введите информацию для нового владельца.");

            System.out.print("Введите имя владельца: ");
            String ownerName = scanner.nextLine();

            System.out.print("Введите фамилию владельца: ");
            String surname = scanner.nextLine();

            System.out.print("Введите адрес владельца: ");
            Address address = new Address(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
                    scanner.nextLine(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt()); // Создайте объект Address по вашему усмотрению

            Breeder breeder = null;

            owner = ownerServices.createNewOwner(ownerName, surname, telephone, address, breeder);
        }

        System.out.print("Введите имя животного: ");
        String animalName = scanner.nextLine();

        System.out.print("Введите пол животного: ");
        String gender = scanner.nextLine();

        System.out.print("Введите описание животного: ");
        String description = scanner.nextLine();

        LocalDate dateOfBirth = animalCreateView.validateDateOfBirth();


        AnimalTypeRepository animalTypeRepository = new AnimalTypeRepository(sessionFactory);
        List<AnimalType> allAnimalTypes = animalTypeRepository.getAllAnimalTypes();

        System.out.println("Выберите тип животного (введите номер): ");
        for (int i = 0; i < allAnimalTypes.size(); i++) {
            System.out.println(i + ": " + allAnimalTypes.get(i).getType());
        }

        int typeIndex;
        while (true) {
            try {
                typeIndex = Integer.parseInt(scanner.nextLine());
                if (typeIndex < 0 || typeIndex >= allAnimalTypes.size()) {
                    throw new IndexOutOfBoundsException("Некорректный индекс. Попробуйте снова.");
                }
                break;
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }

        AnimalType selectedAnimalType = allAnimalTypes.get(typeIndex);

        animalServices.createNewAnimal(new Breed(scanner.nextLine()), animalName, gender, dateOfBirth, description,
                selectedAnimalType, owner);

        System.out.println("Животное успешно создано.");
    }

}
