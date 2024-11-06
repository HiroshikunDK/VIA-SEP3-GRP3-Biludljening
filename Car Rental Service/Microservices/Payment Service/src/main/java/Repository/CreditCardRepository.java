package Repository;

import Model.CreditCard;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CreditCardRepository implements ICreditCardRepository {

    private final EntityManager entityManager;

    public CreditCardRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addCreditcard(CreditCard creditcard) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(creditcard);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("Error adding credit card", e);
        }
    }

    @Override
    public List<CreditCard> getallCreditcards() {
        String jpql = "SELECT c FROM CreditCard c";
        TypedQuery<CreditCard> query = entityManager.createQuery(jpql, CreditCard.class);
        return query.getResultList();
    }
}
