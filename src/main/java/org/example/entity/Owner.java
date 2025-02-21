package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "owners")
@NoArgsConstructor
public class Owner {

    @Id
    @Column(name = "owner_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ownerId;

    @Column(name = "owner_name", nullable = false)
    private String ownerName;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String telephone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "breeder_id")
    private Breeder breeder;

    public Owner(String ownerName, String surname, String telephone, Address address, Breeder breeder) {
        this.ownerName = ownerName;
        this.surname = surname;
        this.telephone = telephone;
        this.address = address;
        this.breeder = breeder;
    }

}

