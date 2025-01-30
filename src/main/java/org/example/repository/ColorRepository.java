package org.example.repository;

import org.example.entity.Color;
import org.example.repository.impl.AbstractHibernateRepository;
import org.hibernate.SessionFactory;

public class ColorRepository extends AbstractHibernateRepository<Color> {

    public ColorRepository(SessionFactory sessionFactory) {
        super(Color.class, sessionFactory);
    }
}

