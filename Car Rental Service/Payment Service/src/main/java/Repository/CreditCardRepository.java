 package Repository;

import Model.CreditCard;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CreditCardRepository implements ICreditCardRepository {

    private final SessionFactory sessionFactory;

    public CreditCardRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCreditcard(CreditCard creditcard) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(creditcard);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error adding credit card", e);
        }
    }

    @Override
    public CreditCard getCreditcardById(long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(CreditCard.class, id);
        } catch (Exception e) {
            System.out.println("Error finding credit card: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<CreditCard> getallCreditcards() {
        try (Session session = sessionFactory.openSession()) {
            Query<CreditCard> query = session.createQuery("FROM CreditCard", CreditCard.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving all credit cards", e);
        }
    }

    @Override
    public void deleteCreditcard(long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            CreditCard creditcard = session.get(CreditCard.class, id);
            if (creditcard != null) {
                session.delete(creditcard);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error deleting credit card", e);
        }
    }

    @Override
    public void updateCreditcard(CreditCard creditcard) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(creditcard);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error updating credit card", e);
        }
    }
}

