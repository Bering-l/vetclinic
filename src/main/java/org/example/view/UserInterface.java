package org.example.view;

import org.example.entity.Animal;
import org.example.entity.MedicalRecord;

import java.util.Scanner;

public class UserInterface {
    private static final Scanner scanner = new Scanner(System.in);

    private MedicalRecord getMedicalRecordFromInput(Animal animal) {
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setAnimal(animal);

        System.out.println("Введите жалобы:");
        String complaints = scanner.nextLine();
        medicalRecord.setComplaints(complaints);

        System.out.println("Введите диагноз:");
        String diagnosis = scanner.nextLine();
        medicalRecord.setDiagnosis(diagnosis);

        return medicalRecord;
    }
}
