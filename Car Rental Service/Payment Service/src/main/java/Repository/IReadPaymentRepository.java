package Repository;

import Model.Payment;

import java.util.List;
import java.util.Optional;

public interface IReadPaymentRepository {
    List<Payment> getAllPayments();
    Optional<Payment> getPaymentById(long id);
}

