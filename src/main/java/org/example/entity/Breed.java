package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "breeds",  uniqueConstraints = @UniqueConstraint(columnNames = {"breed_name"}))
public class Breed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long breedId;

    @Column(name = "breed_name", nullable = false)
    private String breedName;

    @ManyToMany
    @JoinTable(
            name = "breed_colors",
            joinColumns = @JoinColumn(name = "breed_id"),
            inverseJoinColumns = @JoinColumn(name = "color_id")
    )
    private Set<Color> colors = new HashSet<>();

    public Breed(String breedName, Set<Color> colors) {
        this.breedName = breedName;
        this.colors = colors;
    }

    public Breed() {
    }

    @Override
    public String toString() {
        return "Breed{" +
                "breedId=" + breedId +
                ", breedName='" + breedName + '\'' +
                ", color='" + getColors() + '\'' +
                '}';
    }
}
