package ua.zhdanova.hw20.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration().configure();
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            throw new RuntimeException("Can't initialize SessionFactory" + sessionFactory + e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
