package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "vaccinations")
public class Vaccination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vaccinationId;

    @ManyToOne
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal; // Связь с сущностью Animal

    @Column(name = "vaccination_type", length = 160)
    private String vaccinationType;

    @Column(name = "vaccine_used", length = 50)
    private String vaccineUsed;

    @Column(name = "batch_number", length = 50)
    private String batchNumber;

    @Column(name = "vaccination_date")
    private Date vaccinationDate;

    @Column(name = "valid_until")
    private Date validUntil;
}
