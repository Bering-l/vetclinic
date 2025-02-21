package org.example.services;

import org.example.entity.Address;
import org.example.entity.Breeder;
import org.example.entity.Owner;
import org.example.repository.OwnerRepository;

public class OwnerServices {

    private final OwnerRepository ownerRepository;

    public OwnerServices(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public Owner checkOwnerBeforeCreate(String telephone) {
        return ownerRepository.findOwnerByTelephone(telephone); // Возвращаем существующего владельца или null
    }


    public Owner createNewOwner(String ownerName, String surname, String telephone, Address address, Breeder breeder) {
        Owner newOwner = new Owner(ownerName, surname, telephone, address, breeder);
        ownerRepository.save(newOwner);
        return newOwner;
    }
}

