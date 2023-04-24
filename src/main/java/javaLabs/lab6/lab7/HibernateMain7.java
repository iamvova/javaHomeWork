package javaLabs.lab6.lab7;

import javaLabs.lab6.entity.Device;
import javaLabs.lab6.entity.Phone;
import javaLabs.lab6.entity.SocialMedia;
import javaLabs.lab6.entity.Weather;
import javaLabs.lab6.HibernateUtil;
import org.hibernate.Session;

import java.util.Arrays;
import java.util.HashSet;

public class HibernateMain7 {

    //General:
    //    Implement OneToOne, OneToMany, ManyToMany relations in your models from previous task. (add some additional tables if need)
    //    Test it by CRUD.
    public static void main(String[] args) {
        Weather weather = new Weather("14:46:00", 40.5);

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        // One to One
        weather.setPhone(new Phone("+389086253819"));
        Long id = (Long) session.save( weather);

        System.out.println("One to One " + session.get(Weather.class, id));
        //One to Many

        weather.setDevices(new HashSet<>(Arrays.asList(new Device("iPhone"), new Device("Mac"))));
        session.saveOrUpdate(weather);
        weather.getDevices().forEach(session::save);
        System.out.println("One to Many " + session.get(Weather.class, id));

        //Many to Many
        Weather weather1 = new Weather();
        SocialMedia inst = new SocialMedia("inst");
        SocialMedia telegram = new SocialMedia("telegram");

        Long id1 = (Long) session.save(weather1);
        session.save(telegram);
        session.save(inst);

        weather.setSocialMedia(Arrays.asList(inst));
        weather1.setSocialMedia(Arrays.asList(inst, telegram));

        session.saveOrUpdate(telegram);
        session.saveOrUpdate(inst);

        System.out.println("Many to Many " + session.get(Weather.class, id));
        System.out.println("Many to Many " + session.get(Weather.class, id1));

        session.getTransaction().commit();
        session.close();
        System.exit(0);
    }

}
