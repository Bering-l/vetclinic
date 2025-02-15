package org.example.services;

import org.example.entity.Animal;
import org.example.repository.AnimalRepository;

public class AnimalServices {
    private final AnimalRepository animalRepository;

    public AnimalServices(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal findAnimalForManipulate(Long id) {
        return animalRepository.findById(id);
    }
}
