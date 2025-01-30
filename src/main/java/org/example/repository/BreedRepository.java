package org.example.repository;

import org.example.config.HibernateUtil;
import org.example.entity.Breed;
import org.example.repository.impl.AbstractHibernateRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BreedRepository extends AbstractHibernateRepository<Breed> {

    public BreedRepository(SessionFactory sessionFactory) {
        super(Breed.class, sessionFactory);
    }

    public Breed findByName(String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Breed WHERE breedName = :name", Breed.class)
                    .setParameter("name", name)
                    .uniqueResult();
        }
    }
}
