package Repository;

import Model.Payment;
import Shared.TransactionManager;

import java.util.List;
import java.util.Optional;

public class PaymentRepository implements
        ICreatePaymentRepository,
        IReadPaymentRepository,
        IUpdatePaymentRepository,
        IDeletePaymentRepository {
  private final TransactionManager transactionManager;

  public PaymentRepository(TransactionManager transactionManager) {
    this.transactionManager = transactionManager;
  }

  @Override
  public Boolean createPayment(Payment payment) {
    return transactionManager.execute(session -> {
      session.persist(payment);
      return true;
    });
  }

  @Override
  public List<Payment> getAllPayments() {
    return transactionManager.execute(session ->
            session.createQuery("FROM Payment", Payment.class).list()
    );
  }

  @Override
  public Optional<Payment> getPaymentById(long id) {
    return transactionManager.execute(session ->
            Optional.ofNullable(session.get(Payment.class, id))
    );
  }

  @Override
  public void updatePayment(Payment payment) {
    transactionManager.execute(session -> {
      session.merge(payment);
      return null; // Void return
    });
  }

  @Override
  public void deletePayment(long id) {
    transactionManager.execute(session -> {
      Payment payment = session.get(Payment.class, id);
      if (payment != null) {
        session.remove(payment);
      }
      return null; // Void return
    });
  }
}
