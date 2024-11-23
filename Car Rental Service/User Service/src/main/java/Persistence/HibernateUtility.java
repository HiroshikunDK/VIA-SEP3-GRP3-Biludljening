package Persistence;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

  private static final SessionFactory sessionFactory = buildSessionFactory();

  private static SessionFactory buildSessionFactory() {
    try {
      return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    } catch (Exception e) {
      e.printStackTrace();
      throw new ExceptionInInitializerError("Initial SessionFactory creation failed.");
    }
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }

  // Provide EntityManager
  public static EntityManager getEntityManager() {
    Session session = sessionFactory.openSession();
    return session.getEntityManagerFactory().createEntityManager();
  }

  public static void shutdown() {
    getSessionFactory().close();
  }
}
