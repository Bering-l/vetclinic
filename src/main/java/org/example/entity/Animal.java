package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long animalId;

    @ManyToOne
    @JoinColumn(name = "breed_id")
    private Breed breed; // Связь с сущностью Breed

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private Species type;

    @Column(name = "animal_name", nullable = false)
    private String animalName;

    @Column(name = "gender", nullable = false, length = 1)
    private String gender;

    @Column(name = "description")
    private String description;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;
}
