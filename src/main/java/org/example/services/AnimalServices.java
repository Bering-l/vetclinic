package org.example.services;

import org.example.entity.Animal;
import org.example.entity.AnimalType;
import org.example.entity.Breed;
import org.example.entity.Owner;
import org.example.repository.AnimalRepository;
import org.example.repository.OwnerRepository;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;


public class AnimalServices {
    private final AnimalRepository animalRepository;
    private final OwnerRepository ownerRepository;

    public AnimalServices(AnimalRepository animalRepository, OwnerRepository ownerRepository) {
        this.animalRepository = animalRepository;
        this.ownerRepository = ownerRepository;
    }

    public Animal findAnimalForManipulate(Long id) {
        return animalRepository.findById(id);
    }

    public void createNewAnimal(Breed breed, String animalName, String gender, LocalDate dateOfBirth,
                                String description, AnimalType animalType, Owner owner) {
        Animal animal = new Animal(breed, animalName, gender,dateOfBirth, description, animalType, owner);
        animalRepository.save(animal);
    }

    public List<Animal> findAnimalsByOwnerTelephone(String telephone) {
        Owner owner = ownerRepository.findOwnerByTelephone(telephone);

        if (owner != null) {
            Long id = owner.getOwnerId();
            return animalRepository.findAllAnimalsByOwnerId(id);
        } else {
            System.out.println("Владельца с указанным номером нет в базе");
            return Collections.emptyList();
        }
    }

}
