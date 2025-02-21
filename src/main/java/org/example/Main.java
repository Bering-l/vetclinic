package org.example;


import org.example.config.HibernateUtil;
import org.example.controller.ConsoleController;
import org.example.repository.AnimalRepository;
import org.example.repository.MedicalRecordRepository;
import org.example.repository.OwnerRepository;
import org.example.services.AnimalServices;
import org.example.services.MedicalRecordService;
import org.example.services.OwnerServices;
import org.example.view.AnimalCreateView;
import org.example.view.MedicalRecordView;
import org.hibernate.SessionFactory;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

            ConsoleController controller = getConsoleController(sessionFactory, scanner);

            controller.createAnimal(scanner);
        } finally {
            HibernateUtil.shutdown();
        }

    }

    private static ConsoleController getConsoleController(SessionFactory sessionFactory, Scanner scanner) {
        MedicalRecordRepository medicalRecordRepository = new MedicalRecordRepository(sessionFactory);
        AnimalRepository animalRepository = new AnimalRepository(sessionFactory);
        OwnerRepository ownerRepository = new OwnerRepository(sessionFactory);

        MedicalRecordService medicalRecordService = new MedicalRecordService(medicalRecordRepository);
        AnimalServices animalServices = new AnimalServices(animalRepository, ownerRepository);
        OwnerServices ownerServices = new OwnerServices(ownerRepository);

        MedicalRecordView medicalRecordView = new MedicalRecordView(scanner);
        AnimalCreateView animalCreateView = new AnimalCreateView(scanner, sessionFactory);

        return new ConsoleController(animalServices, medicalRecordService, medicalRecordView,
                animalCreateView, ownerServices);
    }
}
