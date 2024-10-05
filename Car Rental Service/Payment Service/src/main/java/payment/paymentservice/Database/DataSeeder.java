package payment.paymentservice.Database;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import payment.paymentservice.Model.Payment;
import payment.paymentservice.Repository.PaymentRepository;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedDatabase(PaymentRepository paymentRepository) {
        return args -> {

            Payment payment1 = new Payment(1, "Test1", 100.50);
            Payment payment2 = new Payment(2, "Test2", 150.50);


            paymentRepository.save(payment1);
            paymentRepository.save(payment2);

            System.out.println("Dummy data has been seeded.");
        };
    }
}
