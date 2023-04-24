package javaLabs.lab6;

import javaLabs.lab6.entity.Device;
import javaLabs.lab6.entity.Phone;
import javaLabs.lab6.entity.SocialMedia;
import javaLabs.lab6.entity.Weather;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static SessionFactory buildSessionFactory() {
        try {// Create properties for Hibernate configuration
            Properties hibernateProps = new Properties();

            hibernateProps.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            hibernateProps.put(Environment.URL, "jdbc:mysql://localhost:3306/itstep");
            hibernateProps.put(Environment.USER, "vova");
            hibernateProps.put(Environment.PASS, "1234");

            hibernateProps.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

            hibernateProps.put(Environment.SHOW_SQL, "true");
            hibernateProps.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            hibernateProps.put(Environment.HBM2DDL_AUTO, "create");



            // Build the configuration object and register entity classes
            Configuration configuration = new Configuration();
            configuration.setProperties(hibernateProps);

            configuration.addAnnotatedClass(Weather.class);
            configuration.addAnnotatedClass(Phone.class);
            configuration.addAnnotatedClass(Device.class);
            configuration.addAnnotatedClass(SocialMedia.class);

            // Build the ServiceRegistry and create the SessionFactory
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            return configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }}
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}


