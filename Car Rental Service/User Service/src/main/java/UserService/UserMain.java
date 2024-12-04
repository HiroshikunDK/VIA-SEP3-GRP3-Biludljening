package UserService;

import Repository.UserRepository;
import Service.UserService;
import Persistence.HibernateUtility;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import jakarta.persistence.EntityManager;
import java.io.IOException;

public class UserMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Get EntityManager from HibernateUtility
        EntityManager entityManager = HibernateUtility.getEntityManager();

        // Create UserRepository with EntityManager
        UserRepository userRepository = new UserRepository(entityManager);

        // Create UserService with UserRepository
        UserService userService = new UserService(userRepository);

        // Start the gRPC server
        Server server = ServerBuilder.forPort(5006)
                .addService(userService)
                .build()
                .start();

        System.out.println("UserService gRPC server started on port " + server.getPort());

        // Add a shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down UserService gRPC server...");
            server.shutdown();
            HibernateUtility.shutdown();
            System.out.println("Server shut down successfully.");
        }));

        server.awaitTermination();
    }
}
