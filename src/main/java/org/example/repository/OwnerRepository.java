package org.example.repository;

import org.example.entity.Owner;
import org.example.repository.impl.AbstractHibernateRepository;
import org.hibernate.SessionFactory;

public class OwnerRepository extends AbstractHibernateRepository<Owner> {

    public OwnerRepository(SessionFactory sessionFactory) {
        super(Owner.class, sessionFactory);
    }
}
