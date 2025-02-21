package org.example.view;

import java.time.LocalDate;
import java.util.Scanner;

public class AnimalCreateView {
    private final Scanner scanner;

    public AnimalCreateView(Scanner scanner) {
        this.scanner = scanner;
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
}

