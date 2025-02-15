package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "breeds")
public class Breed {

    @Id
    @Column(name = "breed_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long breedId;

    @Column(name = "breed_name", nullable = false)
    private String breedName;

    @Override
    public String toString() {
        return "Breed{" +
                "breedId=" + breedId +
                ", breedName='" + breedName + '\'' +
                '}';
    }
}

