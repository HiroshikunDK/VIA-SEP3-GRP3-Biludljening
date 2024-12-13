package PaymentService;

import Repository.PaymentRepository;
import Service.PaymentService;
import Shared.TransactionManager;
import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import org.hibernate.SessionFactory;
import Shared.HibernateUtility;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class PaymentMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Initialize Hibernate session factory
        SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

        // Initialize PaymentRepository and PaymentService
        PaymentRepository paymentRepository = new PaymentRepository(new TransactionManager(sessionFactory));
        PaymentService paymentService = new PaymentService(
                paymentRepository,
                paymentRepository,
                paymentRepository
        );

        // Load TLS certificate and key
        ClassLoader classLoader = PaymentMain.class.getClassLoader();
        URL certUrl = classLoader.getResource("server.crt");
        URL keyUrl = classLoader.getResource("server.key");

        if (certUrl == null || keyUrl == null) {
            throw new RuntimeException("Certificate or Key file not found in resources.");
        }

        String certPath = URLDecoder.decode(certUrl.getFile(), StandardCharsets.UTF_8);
        String keyPath = URLDecoder.decode(keyUrl.getFile(), StandardCharsets.UTF_8);

        File certFile = new File(certPath);
        File keyFile = new File(keyPath);

        // Start gRPC server with HTTPS
        Server server = NettyServerBuilder.forPort(5005)
                .useTransportSecurity(certFile, keyFile) // Enable HTTPS
                .addService(paymentService)
                .build()
                .start();

        System.out.println("PaymentService gRPC server started with HTTPS on port " + server.getPort());

        // Add shutdown hook for cleanup on server shutdown
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down PaymentService gRPC server...");
            server.shutdown();
            HibernateUtility.shutdown();
            System.out.println("Server shut down successfully.");
        }));

        // Wait for the server to terminate
        server.awaitTermination();
    }
}
