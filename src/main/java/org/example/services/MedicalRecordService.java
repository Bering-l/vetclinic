package org.example.services;

import org.example.entity.Animal;
import org.example.entity.MedicalRecord;
import org.example.repository.MedicalRecordRepository;

public class MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;

    public MedicalRecordService(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }

    public void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordRepository.save(medicalRecord);
    }

    public MedicalRecord findLastMedicalRecordByAnimal(Animal animal) {
        return medicalRecordRepository.findLastMedicalRecordByAnimal(animal);
    }
}
