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


    public ConsoleController(AnimalServices animalService, MedicalRecordService medicalRecordService,
                             MedicalRecordView medicalRecordView, AnimalCreateView animalCreateView,
                             OwnerServices ownerServices) {
        this.animalServices = animalService;
        this.medicalRecordService = medicalRecordService;
        this.medicalRecordView = medicalRecordView;
        this.animalCreateView = animalCreateView;
        this.ownerServices = ownerServices;
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
        String telephone = animalCreateView.promptOwnerTelephone();
        Owner owner = ownerServices.checkOwnerBeforeCreate(telephone);

        if (owner == null) {
            owner = animalCreateView.getNewOwnerDetails();
        }

        Animal animal = animalCreateView.getNewAnimalDetails(owner);

        animalServices.createNewAnimal(animal.getBreed(), animal.getAnimalName(), animal.getGender(),
                animal.getDateOfBirth(), animal.getDescription(), animal.getAnimalType(), owner);

        System.out.println("Животное успешно создано.");
    }

}
