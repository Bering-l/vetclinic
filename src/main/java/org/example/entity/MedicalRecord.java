package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "medical_records")
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicalRecordId;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal; // Связь с сущностью Animal

    @Column(name = "complaints")
    private String complaints;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "weight", precision = 6, scale = 2)
    private BigDecimal weight;

    @Column(name = "is_reproducible", nullable = false)
    private Boolean isReproducible;
}