package PaymentService;

import Repository.CreditCardRepository;
import Repository.PaymentRepository;
import Service.CreditCardService;
import Service.PaymentService;
import Persistance.HibernateUtility;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.hibernate.SessionFactory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
        // EntityManager entityManager = sessionFactory.createEntityManager();

        PaymentRepository paymentRepository = new PaymentRepository(sessionFactory);
        PaymentService paymentService = new PaymentService(paymentRepository, sessionFactory);

        CreditCardRepository creditCardRepository = new CreditCardRepository(sessionFactory);
        CreditCardService creditCardService = new CreditCardService(sessionFactory, creditCardRepository);



        Server server = ServerBuilder.forPort(5005)
                .addService(paymentService)
                .addService(creditCardService)
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
