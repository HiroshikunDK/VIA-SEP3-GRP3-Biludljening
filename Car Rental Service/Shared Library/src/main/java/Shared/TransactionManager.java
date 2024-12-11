package Shared;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.function.Function;

public class TransactionManager {
    private final SessionFactory sessionFactory;

    public TransactionManager(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public <T> T execute(Function<Session, T> operation) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            T result = operation.apply(session);
            transaction.commit();
            return result;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }
}
