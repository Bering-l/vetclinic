package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "addresses")
public class Address {

    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @Column(name = "region", nullable = false)
    private String region;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "city")
    private String city;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "house", nullable = false)
    private Integer house;

    @Column(name = "building")
    private Integer building;

    @Column(name = "flat")
    private Integer flat;
}

