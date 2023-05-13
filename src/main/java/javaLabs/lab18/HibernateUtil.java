package javaLabs.lab18;

import javaLabs.lab18.entity.MantisUser;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create properties for Hibernate configuration
            Properties hibernateProps = new Properties();
            hibernateProps.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            hibernateProps.put(Environment.URL, "jdbc:mysql://localhost:3306/bugtracker");
            hibernateProps.put(Environment.USER, "root");

            hibernateProps.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

            hibernateProps.put(Environment.SHOW_SQL, "true");
            hibernateProps.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");


            Configuration configuration = new Configuration();
            configuration.setProperties(hibernateProps);

            configuration.addAnnotatedClass(MantisUser.class);


            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            return configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

