package org.example.view;

import java.util.Scanner;

public class MedicalRecordView {

    private final Scanner scanner;


    public MedicalRecordView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayAnimalNotFound(Long animalId) {
        System.out.println("Животное с ID " + animalId + " не найдено. Пожалуйста, введите другой ID.");
    }

    public void displayMedicalRecordAdded(Long animalId) {
        System.out.println("Медицинская запись добавлена для животного с ID: " + animalId);
    }

    public Long promptForAnimalId() {
        System.out.println("Введите ID животного:");
        return scanner.nextLong();
    }

    public String promptForComplaints() {
        scanner.skip(".*\\n");
        System.out.println("Введите жалобы:");
        return scanner.nextLine();
    }

    public String promptForDiagnosis() {
        scanner.skip(".*\\n");
        System.out.println("Введите диагноз:");
        return scanner.nextLine();
    }

}

