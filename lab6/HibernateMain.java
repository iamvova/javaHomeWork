package javaHomeWork.lab6;

import javaHomeWork.lab6.entity.Weather;
import org.hibernate.Session;

import static javaHomeWork.lab6.HibernateUtil.getSessionFactory;

public class HibernateMain {

    //General:
    //Install MySQL server
    //Make at least two tables (Entities from previous task or any additional if need)
    //Make models for those Entities (from Task_5)
    //Setup Hibernate for those Entities and local DB
    //Check basic CRUD (create, read, update, delete the BD records using Hibernate)
    //Generate few rows into all tabled
    public static void main(String[] args) {
        Weather weather = new Weather("14:46:00", 40.5);

        Session session = getSessionFactory().getCurrentSession();

        session.beginTransaction();
        //Create
        Long id = (Long) session.save(weather);

        //Read
        Weather weatherRead = session.get(Weather.class, id);

        //Update
        Weather weatherUpdate = weatherRead;
        weatherUpdate.setTime("15.00.00");
        session.saveOrUpdate(weatherUpdate);
        //Delete

        session.delete(weather);

        System.out.println("weatherRead" + weatherRead);
        session.getTransaction().commit();
        session.close();

        System.exit(0);

    }
}
