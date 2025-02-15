package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "animals_types")
public class AnimalType {

    @Id
    @Column(name = "animal_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long animalTypeId;

    @Enumerated(EnumType.STRING)
    private Species type;

}

