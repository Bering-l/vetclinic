package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "medical_records")
@NoArgsConstructor
public class MedicalRecord {

    @Id
    @Column(name = "medical_record_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicalRecordId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id")
    private Animal animal;

    private String complaints;
    private String diagnosis;
    private BigDecimal weight;

    @Column(name = "is_reproducible")
    private Boolean isReproducible;

    @Column(name = "date_visit")
    private Date dateVisit;

    @Column(name = "doctor_Surname")
    private String doctorSurname;

    public MedicalRecord(String complaints, String diagnosis, BigDecimal weight,
                         Boolean isReproducible, String doctorSurname, Date dateVisit) {
        this.complaints = complaints;
        this.diagnosis = diagnosis;
        this.weight = weight;
        this.isReproducible = isReproducible;
        this.doctorSurname = doctorSurname;
        this.dateVisit = dateVisit;
    }


}
