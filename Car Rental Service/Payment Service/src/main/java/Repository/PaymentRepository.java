package Repository;

import Model.Payment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class PaymentRepository implements IPaymentRepository {
  private final SessionFactory sessionFactory;

  public PaymentRepository(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public Boolean createPayment(Payment payment) {
    Transaction transaction = null;
    try (Session session = sessionFactory.openSession()) {
      transaction = session.beginTransaction();
      session.persist(payment);
      transaction.commit();
      return true;
    } catch (Exception e) {
      if (transaction != null) transaction.rollback();
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public List<Payment> getAllPayments() {
    try (Session session = sessionFactory.openSession()) {
      return session.createQuery("FROM Payment", Payment.class).list();
    } catch (Exception e) {
      e.printStackTrace();
      return List.of();
    }
  }

  @Override
  public Optional<Payment> getPaymentById(long id) {
    try (Session session = sessionFactory.openSession()) {
      Payment payment = session.get(Payment.class, id);
      return Optional.ofNullable(payment);
    }
  }

  public List<Payment> getPaymentsByCustomer(long customerId) {
    try (Session session = sessionFactory.openSession()) {
      String hql = "FROM Payment WHERE customer = :customerId";
      return session.createQuery(hql, Payment.class)
              .setParameter("customerId", customerId)
              .list();
    } catch (Exception e) {
      e.printStackTrace();
      return List.of();
    }
  }


  @Override
  public void updatePayment(Payment payment) {
    Transaction transaction = null;
    try (Session session = sessionFactory.openSession()) {
      transaction = session.beginTransaction();
      session.merge(payment);
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) transaction.rollback();
      e.printStackTrace();
    }
  }

  @Override
  public void deletePayment(long id) {
    Transaction transaction = null;
    try (Session session = sessionFactory.openSession()) {
      transaction = session.beginTransaction();
      Payment payment = session.get(Payment.class, id);
      if (payment != null) {
        session.remove(payment);
      }
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) transaction.rollback();
      e.printStackTrace();
    }
  }
}
