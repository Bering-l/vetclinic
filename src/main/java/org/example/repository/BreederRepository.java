package org.example.repository;

import org.example.entity.Breeder;
import org.example.repository.impl.AbstractHibernateRepository;
import org.hibernate.SessionFactory;

public class BreederRepository extends AbstractHibernateRepository<Breeder> {

    public BreederRepository(SessionFactory sessionFactory) {
        super(Breeder.class, sessionFactory);
    }
}
