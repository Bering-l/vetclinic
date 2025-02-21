package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@Entity
@Table(name = "animals")
@NoArgsConstructor
public class Animal {

    @Id
    @Column(name = "animal_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long animalId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "breed_id")
    private Breed breed;

    @Column(name = "animal_name", nullable = false)
    private String animalName;

    @Column(nullable = false, length = 1)
    private String gender;

    private String description;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_type_id")
    private AnimalType animalType;

    public Animal(Breed breed, String animalName, String gender, LocalDate dateOfBirth,
                  String description, AnimalType animalType, Owner owner) {
        this.breed = breed;
        this.animalName = animalName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.description = description;
        this.animalType = animalType;
        this.owner = owner;
    }
}

