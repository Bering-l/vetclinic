package org.example.repository;

import org.example.entity.Animal;
import org.example.entity.MedicalRecord;
import org.example.repository.impl.AbstractHibernateRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class MedicalRecordRepository extends AbstractHibernateRepository<MedicalRecord> {

    public MedicalRecordRepository(SessionFactory sessionFactory) {
        super(MedicalRecord.class, sessionFactory);
    }

    public MedicalRecord findLastMedicalRecordByAnimal(Animal animal) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM MedicalRecord WHERE animal = :animal ORDER BY dateVisit DESC";
            Query<MedicalRecord> query = session.createQuery(hql, MedicalRecord.class);
            query.setParameter("animal", animal);
            query.setMaxResults(1); // Получаем только одну запись (последнюю)
            List<MedicalRecord> results = query.list();

            return results.isEmpty() ? null : results.get(0); // Возвращаем последнюю запись или null, если нет записей
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

