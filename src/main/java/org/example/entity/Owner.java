package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "owner_is_breeders", discriminatorType = DiscriminatorType.STRING)
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ownerId;

    @Column(name = "animal_id")
    private Long animalId;

    @Column(name = "owner_name", nullable = false)
    private String ownerName;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "telephone", nullable = false)
    private String telephone;

    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "is_breeders", nullable = false)
    private Boolean isBreeders;
}
