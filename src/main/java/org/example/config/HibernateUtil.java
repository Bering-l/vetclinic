package org.example.config;

import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.schema.Action;


public class HibernateUtil {
    @Getter
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static final Logger LOGGER = LogManager.getLogger(HibernateUtil.class);

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration()
                    .addAnnotatedClass(Address.class)
                    .addAnnotatedClass(Animal.class)
                    .addAnnotatedClass(AnimalType.class)
                    .addAnnotatedClass(Breed.class)
                    .addAnnotatedClass(BreedColor.class)
                    .addAnnotatedClass(Breeder.class)
                    .addAnnotatedClass(Color.class)
                    .addAnnotatedClass(Identification.class)
                    .addAnnotatedClass(MedicalRecord.class)
                    .addAnnotatedClass(Owner.class)
                    .addAnnotatedClass(Pricelist.class)
                    .addAnnotatedClass(Procedure.class)
                    .addAnnotatedClass(TypeProcedure.class)
                    .addAnnotatedClass(Vaccination.class)
                    .setProperty(AvailableSettings.JAKARTA_JDBC_URL, "jdbc:postgresql://localhost:5432/clinic")
                    .setProperty(AvailableSettings.JAKARTA_JDBC_USER, "midori")
                    .setProperty(AvailableSettings.JAKARTA_JDBC_PASSWORD, "")

                    .setProperty(AvailableSettings.JAKARTA_HBM2DDL_DATABASE_ACTION,
                            Action.UPDATE)
                    .setProperty(AvailableSettings.SHOW_SQL, true)
                    .setProperty(AvailableSettings.FORMAT_SQL, true)
                    .setProperty(AvailableSettings.HIGHLIGHT_SQL, true)
                    .buildSessionFactory();
        } catch (ExceptionInInitializerError e) {
            assert LOGGER != null;
            LOGGER.info("Ошибка при создании SessionFactory: ", e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
