package UserService;

import Repository.UserRepository;
import Service.AuthenticationService;
import Service.UserManagementService;
import Service.UserService;
import Shared.HibernateUtility;
import Shared.PasswordHelper;
import Shared.TokenHelper;

import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import jakarta.persistence.EntityManager;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

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

        // Load certificate and key using ClassLoader for relative path
        ClassLoader classLoader = UserMain.class.getClassLoader();
        URL certUrl = classLoader.getResource("server.crt");
        URL keyUrl = classLoader.getResource("server.key");

        if (certUrl == null || keyUrl == null) {
            throw new RuntimeException("Certificate or Key file not found in resources.");
        }

        String certPath = URLDecoder.decode(certUrl.getFile(), StandardCharsets.UTF_8);
        String keyPath = URLDecoder.decode(keyUrl.getFile(), StandardCharsets.UTF_8);

        File certFile = new File(certPath);
        File keyFile = new File(keyPath);


        // Start the gRPC server with TLS
        Server server = NettyServerBuilder.forPort(5006)
                .useTransportSecurity(certFile, keyFile) // Enable TLS
                .addService(userService)
                .build()
                .start();

        System.out.println("UserService gRPC server started with HTTPS on port " + server.getPort());

        // Add a shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down UserService gRPC server...");
            server.shutdown();
            HibernateUtility.shutdown();
            System.out.println("Server shut down successfully.");
        }));

        // Keep the server running
        server.awaitTermination();
    }
}
