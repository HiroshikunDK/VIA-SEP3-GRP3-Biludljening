package payment.paymentservice.Controller;

import payment.paymentservice.Model.Payment;
import payment.paymentservice.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<Payment> createPayment(@RequestParam String userId, @RequestParam String carId, @RequestParam double amount) {
        Payment payment = paymentService.createPayment(userId, carId, amount);
        return ResponseEntity.ok(payment);
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        Optional<Payment> payment = paymentService.getPaymentById(id);
        return payment.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<String> updatePaymentStatus(@PathVariable Long id, @RequestParam String status) {
        paymentService.updatePaymentStatus(id, status);
        return ResponseEntity.ok("Payment status updated successfully.");
    }
}
