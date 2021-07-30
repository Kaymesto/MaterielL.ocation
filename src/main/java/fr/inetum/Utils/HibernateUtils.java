package fr.inetum.Utils;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static final SessionFactory sessionFactory;

    // Create a SessionFactory with the hibernate.cfg.xml file
    static {
        try {
            // Recovery of the configuration
            Configuration configuration = new Configuration().configure();
            //Instanciation of the sessionFactory
            sessionFactory = configuration.buildSessionFactory();
        } catch (HibernateException ex) {
            throw new RuntimeException("Probleme de configuration : " + ex.getMessage(), ex);
        }
    }
    // Recover the Hibernate session
    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }

    // Close the Hibernate session
    public static void closeSession(){
        Session session = sessionFactory.getCurrentSession();
        if (session != null){
            session.close();
        }
    }
}