package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "procedures")
public class Procedure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long proceduresId;

    @ManyToOne
    @JoinColumn(name = "pricelist_id")
    private PriceList priceList; // Связь с сущностью PriceList

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;
}
