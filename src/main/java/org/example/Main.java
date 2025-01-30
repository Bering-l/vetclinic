package org.example;

import org.example.config.HibernateUtil;
import org.example.repository.BreedRepository;
import org.example.repository.ColorRepository;
import org.example.services.BreedService;
import org.example.services.ColorService;
import org.hibernate.SessionFactory;


public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        BreedRepository breedRepository = new BreedRepository(sessionFactory);
        ColorRepository colorRepository = new ColorRepository(sessionFactory);
        ColorService colorService = new ColorService(colorRepository);
        BreedService breedServices = new BreedService(breedRepository, colorService);

        breedServices.addCatBreedsFromInput();
    }


}