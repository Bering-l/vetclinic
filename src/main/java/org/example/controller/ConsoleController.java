package org.example.controller;

import org.example.entity.Animal;
import org.example.entity.MedicalRecord;
import org.example.services.AnimalServices;
import org.example.services.MedicalRecordService;
import org.example.view.MedicalRecordView;

import java.util.Date;


public class ConsoleController {
    private final AnimalServices animalService;
    private final MedicalRecordService medicalRecordService;
    private final MedicalRecordView medicalRecordView;


    public ConsoleController(AnimalServices animalService, MedicalRecordService medicalRecordService,
                             MedicalRecordView medicalRecordView) {
        this.animalService = animalService;
        this.medicalRecordService = medicalRecordService;
        this.medicalRecordView = medicalRecordView;
    }

    public void addNewMedicalRecord() {
        Long animalId = medicalRecordView.promptForAnimalId();
        Animal animal = animalService.findAnimalForManipulate(animalId);
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
}
