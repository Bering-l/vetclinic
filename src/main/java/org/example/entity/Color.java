package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "colors")
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long colorId;

    @Column(name = "color_name", nullable = false)
    private String colorName;

    @ManyToMany(mappedBy = "colors")
    private Set<Breed> breeds = new HashSet<>();
}
