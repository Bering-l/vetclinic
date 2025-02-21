package org.example.repository;

import org.example.entity.AnimalType;
import org.example.repository.impl.AbstractHibernateRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AnimalTypeRepository extends AbstractHibernateRepository<AnimalType> {

    public AnimalTypeRepository(SessionFactory sessionFactory) {
        super(AnimalType.class, sessionFactory);
    }


    public List<AnimalType> getAllAnimalTypes() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from AnimalType", AnimalType.class).list();
        }
    }

}
