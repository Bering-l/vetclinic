package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "identifications")
public class Identification {

    @Id
    @Column(name = "identification_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identificationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @Column(name = "date_of_microchipping")
    private Date dateOfMicrochipping;

    @Column(name = "location_microchip")
    private String locationMicrochip;

    @Column(name = "tattoo_number")
    private Integer tattooNumber;

    @Column(name = "date_of_tattooing")
    private Date dateOfTattooing;

    @Column(name = "pedigree_number")
    private Integer pedigreeNumber;

}

