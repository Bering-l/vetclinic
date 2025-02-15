package org.example.services;

import org.example.entity.*;

import java.time.LocalDate;


public interface AnimalInfoService {
    Owner addOwner(String ownerName, String surname, String telephone, Address address);
    Animal addAnimal(String animalName, Long breedId, String gender,
                     String description, LocalDate dateOfBirth, Species species);
}
