package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "pricelists")
public class PriceList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pricelistId;

    @Column(name = "procedure_name", nullable = false)
    private String procedureName;

    @Column(name = "price")
    private Double price;
}
