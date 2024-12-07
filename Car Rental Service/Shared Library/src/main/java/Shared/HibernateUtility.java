package Shared;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
  private static final SessionFactory sessionFactory = buildSessionFactory();
  private static final EntityManagerFactory entityManagerFactory = sessionFactory.unwrap(EntityManagerFactory.class);

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

  public static EntityManagerFactory getEntityManagerFactory() {
    return entityManagerFactory;
  }

  public static void shutdown() {
    sessionFactory.close();
  }
}
