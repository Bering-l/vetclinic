package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "vaccinations")
public class Vaccination {

    @Id
    @Column(name = "vaccination_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vaccinationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @Column(name = "vaccination_type")
    private String vaccinationType;

    @Column(name = "vaccine_used")
    private String vaccineUsed;

    @Column(name = "batch_number")
    private String batchNumber;

    @Column(name = "vaccination_date")
    private Date vaccinationDate;

    @Column(name = "valid_until")
    private Date validUntil;

}
