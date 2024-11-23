package Repository;

import Model.Payment;

import java.util.List;
import java.util.Optional;

public interface IPaymentRepository {
  Boolean createPayment(Payment payment);
  List<Payment> getAllPayments();
  Optional<Payment> getPaymentById(long id); //Optional indikere at værdien kan være null
  void updatePayment(Payment payment);
  void deletePayment(long id);
}