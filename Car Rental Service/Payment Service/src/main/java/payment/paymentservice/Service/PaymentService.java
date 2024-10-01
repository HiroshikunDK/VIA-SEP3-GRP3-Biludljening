package payment.paymentservice.Service;

import payment.paymentservice.Model.Payment;
import payment.paymentservice.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment createPayment(String userId, String carId, double amount) {
        Payment payment = new Payment(userId, carId, amount, LocalDateTime.now(), "Pending");
        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public List<Payment> getPaymentsByUserId(String userId) {
        return paymentRepository.findByUserId(userId);
    }

    public void updatePaymentStatus(Long id, String status) {
        Optional<Payment> payment = paymentRepository.findById(id);
        if (payment.isPresent()) {
            Payment existingPayment = payment.get();
            existingPayment.setPaymentStatus(status);
            paymentRepository.save(existingPayment);
        }
    }
}
