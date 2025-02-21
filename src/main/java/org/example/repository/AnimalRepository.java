package org.example.repository;

import org.example.entity.Animal;
import org.example.repository.impl.AbstractHibernateRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;


public class AnimalRepository extends AbstractHibernateRepository<Animal> {

    public AnimalRepository(SessionFactory sessionFactory) {
        super(Animal.class, sessionFactory);
    }

    public List<Animal> findAllAnimalsByOwnerId(Long id) {
        try(Session session = sessionFactory.openSession()) {
            String hql = "FROM Animal a WHERE a.owner.id = :ownerId";
            Query<Animal> query = session.createQuery(hql, Animal.class);
            query.setParameter("ownerId", id);
            return query.list();
        }
    }

}
