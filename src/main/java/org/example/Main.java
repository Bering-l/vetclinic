package org.example;


import org.example.config.HibernateUtil;
import org.example.controller.ConsoleController;
import org.example.repository.AnimalRepository;
import org.example.repository.MedicalRecordRepository;
import org.example.services.AnimalServices;
import org.example.services.MedicalRecordService;
import org.example.view.MedicalRecordView;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        MedicalRecordRepository medicalRecordRepository = new MedicalRecordRepository(sessionFactory);
        AnimalRepository animalRepository = new AnimalRepository(sessionFactory);
        MedicalRecordService medicalRecordService = new MedicalRecordService(medicalRecordRepository);
        AnimalServices animalServices = new AnimalServices(animalRepository);
        MedicalRecordView medicalRecordView = new MedicalRecordView(scanner);

        ConsoleController controller = new ConsoleController(animalServices, medicalRecordService, medicalRecordView);
        controller.addNewMedicalRecord();
    }


}