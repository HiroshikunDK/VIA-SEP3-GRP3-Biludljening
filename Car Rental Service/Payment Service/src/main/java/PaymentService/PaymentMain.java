package PaymentService;

import Repository.PaymentRepository;
import Service.PaymentService;
import Shared.TransactionManager;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.hibernate.SessionFactory;
import Shared.HibernateUtility;

import java.io.IOException;

public class PaymentMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Initialiser Hibernate session factory
        SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

        // Initialiser PaymentRepository og PaymentService
        PaymentRepository paymentRepository = new PaymentRepository(new TransactionManager(sessionFactory));
        PaymentService paymentService = new PaymentService(
                paymentRepository,
                paymentRepository,
                paymentRepository
        );

        // Start gRPC-serveren og tilføj kun PaymentService
        Server server = ServerBuilder.forPort(5005)
                .addService(paymentService)
                .build()
                .start();

        System.out.println("PaymentService gRPC server started on port " + server.getPort());

        // Tilføj shutdown hook til at rydde op ved servernedlukning
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down PaymentService gRPC server...");
            server.shutdown();
            HibernateUtility.shutdown();
            System.out.println("Server shut down successfully.");
        }));

        // Vent på, at serveren afslutter
        server.awaitTermination();
    }
}
