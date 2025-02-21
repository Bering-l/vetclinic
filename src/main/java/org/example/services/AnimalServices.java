package org.example.services;

import org.example.entity.Animal;
import org.example.entity.AnimalType;
import org.example.entity.Breed;
import org.example.entity.Owner;
import org.example.repository.AnimalRepository;

import java.time.LocalDate;


public class AnimalServices {
    private final AnimalRepository animalRepository;


    public AnimalServices(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal findAnimalForManipulate(Long id) {
        return animalRepository.findById(id);
    }

    public void createNewAnimal(Breed breed, String animalName, String gender, LocalDate dateOfBirth,
                                String description, AnimalType animalType, Owner owner) {
        Animal animal = new Animal(breed, animalName, gender,dateOfBirth, description, animalType, owner);
        animalRepository.save(animal);
    }

}
