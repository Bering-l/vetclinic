package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "pricelists")
public class Pricelist {

    @Id
    @Column(name = "pricelists_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pricelistsId;

    private BigDecimal price;

}

