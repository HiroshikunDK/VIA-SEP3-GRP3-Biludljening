package UserService;

import Repository.UserRepository;
import Service.AuthenticationService;
import Service.UserManagementService;
import Service.UserService;
import Shared.HibernateUtility;
import Shared.PasswordHelper;
import Shared.TokenHelper;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import jakarta.persistence.EntityManager;
import java.io.IOException;

public class UserMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Get EntityManagerFactory from HibernateUtility
        var entityManagerFactory = HibernateUtility.getEntityManagerFactory();

        // Create an EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Create UserRepository with EntityManager
        UserRepository userRepository = new UserRepository(entityManager);

        // Create AuthenticationService with required dependencies
        AuthenticationService authenticationService = new AuthenticationService(
                userRepository, // IRetrieveUserRepository
                new PasswordHelper(),
                new TokenHelper()
        );

        // Create UserManagementService with required dependencies
        UserManagementService userManagementService = new UserManagementService(
                userRepository, // IAddUserRepository
                userRepository, // IRetrieveUserRepository
                userRepository, // IDeleteUserRepository
                userRepository  // IUpdateUserRepository
        );

        // Create UserService with AuthenticationService and UserManagementService
        UserService userService = new UserService(authenticationService, userManagementService);

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
