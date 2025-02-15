package org.example.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;;

@Getter
@Setter
@Entity
@Table(name = "breeders")
public class Breeder {

    @Id
    @Column(name = "breeder_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long breederId;

    @Column(name = "name_club", nullable = false, length = 100)
    private String nameClub;

    @Column(name = "rkf_number", unique = true)
    private Integer rkfNumber;

}
