package org.example.repository;

import org.example.entity.Animal;
import org.example.repository.impl.AbstractHibernateRepository;
import org.hibernate.SessionFactory;

public class AnimalRepository extends AbstractHibernateRepository<Animal> {

    public AnimalRepository(SessionFactory sessionFactory) {
        super(Animal.class, sessionFactory);
    }
}
