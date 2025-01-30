package org.example.repository;

import org.example.entity.MedicalRecord;
import org.example.repository.impl.AbstractHibernateRepository;
import org.hibernate.SessionFactory;

public class MedicalRecordRepository extends AbstractHibernateRepository<MedicalRecord> {

    public MedicalRecordRepository(SessionFactory sessionFactory) {
        super(MedicalRecord.class, sessionFactory);
    }
}

