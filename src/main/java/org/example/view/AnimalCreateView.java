package org.example.view;

import org.example.entity.*;
import org.example.repository.AnimalTypeRepository;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class AnimalCreateView {
    private final Scanner scanner;
    private final SessionFactory sessionFactory;

    public AnimalCreateView(Scanner scanner, SessionFactory sessionFactory) {
        this.scanner = scanner;
        this.sessionFactory = sessionFactory;
    }

    public int indicateYear() {
        System.out.print("Введите год (например, 2025): ");
        return scanner.nextInt();
    }

    public int indicateMonth() {
        System.out.print("Введите месяц (1-12): ");
        return scanner.nextInt();
    }

    public int indicateDay() {
        System.out.print("Введите день (1-31): ");
        return scanner.nextInt();
    }

    public LocalDate validateDateOfBirth() {
        try {
            int year = indicateYear();
            int month = indicateMonth();
            int day = indicateDay();

            if (month < 1 || month > 12) {
                System.out.println("Некорректный месяц. Пожалуйста, введите значение от 1 до 12.");
            }

            if (day < 1 || day > 31) {
                System.out.println("Некорректный день. Пожалуйста, введите значение от 1 до 31.");
            }

            return LocalDate.of(year, month, day);

        } catch (Exception e) {
            System.out.println("Произошла ошибка при создании животного: " + e.getMessage());
            return null;
        }
    }

    public String promptOwnerTelephone() {
        System.out.print("Введите телефон владельца: ");
        return scanner.nextLine();
    }

    public Owner getNewOwnerDetails() {
        System.out.println("Владелец не найден. Пожалуйста, введите информацию для нового владельца.");

        System.out.print("Введите имя владельца: ");
        String ownerName = scanner.nextLine();

        System.out.print("Введите фамилию владельца: ");
        String surname = scanner.nextLine();

        System.out.print("Введите адрес владельца (улица, город, штат, почтовый индекс): ");
        Address address = new Address(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
                scanner.nextLine(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());

        scanner.nextLine();

        Breeder breeder = null;

        return new Owner(ownerName, surname, promptOwnerTelephone(), address, breeder);
    }

    public Animal getNewAnimalDetails(Owner owner) {
        System.out.print("Введите имя животного: ");
        String animalName = scanner.nextLine();

        System.out.print("Введите пол животного: ");
        String gender = scanner.nextLine();

        System.out.print("Введите описание животного: ");
        String description = scanner.nextLine();

        LocalDate dateOfBirth = validateDateOfBirth();

        AnimalType selectedAnimalType = selectAnimalType();

        return new Animal(new Breed(scanner.nextLine()), animalName, gender, dateOfBirth, description,
                selectedAnimalType, owner);
    }


    private AnimalType selectAnimalType() {
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

        return allAnimalTypes.get(typeIndex);
    }
}

