package payment.paymentservice.Repository;

import payment.paymentservice.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByUserId(String userId);
    List<Payment> findByCarId(String carId);
}
