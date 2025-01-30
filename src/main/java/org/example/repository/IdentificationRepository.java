package org.example.repository;

import org.example.entity.Identification;
import org.example.repository.impl.AbstractHibernateRepository;
import org.hibernate.SessionFactory;

public class IdentificationRepository extends AbstractHibernateRepository<Identification> {

    public IdentificationRepository(SessionFactory sessionFactory) {
        super(Identification.class, sessionFactory);
    }
}
