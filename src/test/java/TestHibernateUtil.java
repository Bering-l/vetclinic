import org.example.config.HibernateUtil;
import org.hibernate.SessionFactory;

public class TestHibernateUtil {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        if (sessionFactory != null) {
            System.out.println("SessionFactory успешно инициализирован!");
        } else {
            System.out.println("Ошибка: SessionFactory равен null.");
        }
    }
}

