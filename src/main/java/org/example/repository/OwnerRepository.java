package org.example.repository;


import org.example.entity.Owner;
import org.example.repository.impl.AbstractHibernateRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class OwnerRepository extends AbstractHibernateRepository<Owner> {

    public OwnerRepository(SessionFactory sessionFactory) {
        super(Owner.class, sessionFactory);
    }

    public Owner findOwnerByTelephone(String telephone) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Owner WHERE telephone = :telephone";
            Query<Owner> query = session.createQuery(hql, Owner.class);
            query.setParameter("telephone", telephone);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
