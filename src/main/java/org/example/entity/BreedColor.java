package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "breed_colors")
public class BreedColor {

    @Id
    @Column(name = "breed_id")
    private Long breedId;

    @Id
    @Column(name = "color_id")
    private Long colorId;

}

