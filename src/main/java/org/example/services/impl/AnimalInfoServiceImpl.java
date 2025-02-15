package org.example.services.impl;

import org.example.entity.*;
import org.example.repository.AnimalRepository;
import org.example.services.AnimalInfoService;
import org.example.services.BreedService;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.Scanner;


public class AnimalInfoServiceImpl implements AnimalInfoService {
    private final AnimalRepository animalRepository;
    private final BreedService breedService;

    public AnimalInfoServiceImpl(AnimalRepository animalRepository, BreedService breedService) {
        this.animalRepository = animalRepository;
        this.breedService = breedService;
    }


    @Override
    public Owner addOwner(String ownerName, String surname, String telephone, Address address) {
        Transaction transaction = null;
        return null;
    }

    @Override
    public Animal addAnimal(String animalName, Long breedId, String gender,
                            String description, LocalDate dateOfBirth, Species species) {

        return null;
    }

    public void addAnimalFromInput() {
        Scanner scanner = new Scanner(System.in);
        String continueInput = ""; //вынести в view - собираем данные созданный объект, либо создаваться новый

        do {
            System.out.print("Введите имя животного: ");
            String animalName = scanner.nextLine();

            System.out.print("Введите название породы: ");
            String breedName = scanner.nextLine();

            Breed breed = breedService.getBreedByName(breedName);
            if (breed == null) {
                breedService.addCatBreedsFromInput();
            }

            System.out.print("Введите пол (M/F): ");
            String gender = scanner.nextLine().toLowerCase();

            if (!gender.equals("M") && !gender.equals("F")) {
                System.out.println("Некорректный ввод пола. Пожалуйста, введите 'm' или 'f'.");
                continue;
            }

            System.out.print("Введите описание: ");
            String description = scanner.nextLine();

            System.out.print("Введите дату рождения (YYYY-MM-DD): ");
            LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());

            System.out.print("Введите вид животного: ");
            String speciesInput = scanner.nextLine();
            Species species = Species.valueOf(speciesInput.toUpperCase());

            assert breed != null;
            Animal animal = addAnimal(animalName, breed.getBreedId(), gender, description, dateOfBirth, species);

            if (animal != null) {
                System.out.println("Животное " + animalName + " успешно добавлено.");
            } else {
                System.out.println("Ошибка при добавлении животного.");
            }

            System.out.print("Хотите добавить еще одно животное? (да/нет): ");
            continueInput = scanner.nextLine().trim().toLowerCase();
        } while (continueInput.equals("да"));

        scanner.close();
    }

}
