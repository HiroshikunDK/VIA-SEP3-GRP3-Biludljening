import Repository.PaymentRepository;
import Service.PaymentService;
import Persistance.HibernateUtility;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.hibernate.SessionFactory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

        PaymentRepository paymentRepository = new PaymentRepository(sessionFactory);
        PaymentService paymentService = new PaymentService(paymentRepository, sessionFactory);

        Server server = ServerBuilder.forPort(5005)
                .addService(paymentService)
                .build()
                .start();

        System.out.println("PaymentService gRPC server started on port " + server.getPort());

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down PaymentService gRPC server...");
            server.shutdown();
            HibernateUtility.shutdown();
            System.out.println("Server shut down successfully.");
        }));

        server.awaitTermination();
    }
}
