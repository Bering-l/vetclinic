package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "identifications")
public class Identification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identificationId;

    @ManyToOne
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal; // Связь с сущностью Animal

    @Column(name = "date_of_microchipping")
    private Date dateOfMicrochipping;

    @Column(name = "location_microchip", length = 120)
    private String locationMicrochip;

    @Column(name = "tattoo_number")
    private Integer tattooNumber;

    @Column(name = "date_of_tattooing")
    private Date dateOfTattooing;

    @Column(name = "pedigree_number")
    private Integer pedigreeNumber;
}
