package javaLabs.lab18;
import javaLabs.lab18.entity.MantisUser;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import static javaLabs.lab18.HibernateUtil.getSessionFactory;


public class HibernateMain {
    static Session session = getSessionFactory().getCurrentSession();
    static Integer REPORTER_LEVEL=25;
    static Integer ADMIN_LEVEL=90;
    static Integer DEV_LEVEL=55;
    public static void main(String[] args) throws NoSuchAlgorithmException {

        session.beginTransaction();
        printAllUsers();
        System.exit(0);

        createUserWithLevel(REPORTER_LEVEL);
        createUserWithLevel(REPORTER_LEVEL);
        createUserWithLevel(REPORTER_LEVEL);

        createUserWithLevel(DEV_LEVEL);
        createUserWithLevel(DEV_LEVEL);
        createUserWithLevel(DEV_LEVEL);

        printAllUsers();

        session.getTransaction().commit();
        session.close();
        System.exit(0);
    }

    private static void createUserWithLevel(Integer level) throws NoSuchAlgorithmException {
        Integer id= new Random().nextInt(999999);
        MantisUser mantisUser=new MantisUser();
        mantisUser.setUsername(UUID.randomUUID().toString().substring(0,10));
        StringBuilder sb = new StringBuilder();
        String password = "root";
        for (byte b : MessageDigest.getInstance("MD5").digest(password.getBytes())) {
            sb.append(String.format("%02x", b));
        }
        mantisUser.setPassword(sb.toString());
        mantisUser.setId(id+0L);
        mantisUser.setAccessLevel(level);
        mantisUser.setDateCreated(0L);
        mantisUser.setEmail("qwe@qwe.qwe");
        mantisUser.setLostPasswordRequestCount(0);
        mantisUser.setFailedLoginCount(0);
        mantisUser.setLoginCount(0);
        mantisUser.setRealname("administrator");
        mantisUser.setProtectedUser(0);
        mantisUser.setLastVisit(0L);
        mantisUser.setEnabled(1);
        mantisUser.setCookieString(UUID.randomUUID().toString());
        session.save(mantisUser);
    }

    private static void printAllUsers() {

        Query query = session.createQuery("FROM "+MantisUser.class.getName());
        List<MantisUser> results = query.list();
        results.forEach(mu->{
            System.out.println(mu.getUsername()+"\troot\t"+mu.getAccessLevel());
        });
        System.out.println("results "+results);
    }

}