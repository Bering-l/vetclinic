package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("breeders")
public class Breeder extends Owner {
    @Column(name = "rkf_number", unique = true)
    private Integer rkfNumber;
}
