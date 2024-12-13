package CarManagementService;

import Repository.BookingCarRepository;
import Repository.LocationsHubRepository;
import Service.BookingCarService;
import Service.LocationHubService;
import Shared.HibernateUtility;
import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import Service.CarService;
import Repository.CarRepository;

import jakarta.persistence.EntityManagerFactory;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class CarMain {

    public static void main(String[] args) throws Exception {
        // Initialize EntityManager from Hibernate Utility
        EntityManagerFactory entityManagerFactory = HibernateUtility.getEntityManagerFactory();

        // Pass the EntityManagerFactory to the repositories
        CarRepository carRepository = new CarRepository(entityManagerFactory);
        BookingCarRepository bookingCarRepository = new BookingCarRepository(entityManagerFactory);
        LocationsHubRepository locationsHubRepository = new LocationsHubRepository(entityManagerFactory);

        // Initialize Services
        CarService carService = new CarService(carRepository);
        BookingCarService bookingCarService = new BookingCarService(bookingCarRepository);
        LocationHubService locationHubService = new LocationHubService(locationsHubRepository);

        // Load TLS certificate and key
        ClassLoader classLoader = CarMain.class.getClassLoader();
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
        Server server = NettyServerBuilder.forPort(5004)
                .useTransportSecurity(certFile, keyFile) // Enable HTTPS
                .addService(carService)
                .addService(bookingCarService)
                .addService(locationHubService)
                .build()
                .start();

        System.out.println("gRPC server started with HTTPS on port 5004");

        // Add shutdown hook to gracefully shut down server
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down gRPC server...");
            server.shutdown();
            System.out.println("Server shut down successfully.");
        }));

        // Keep server running
        server.awaitTermination();

        // Close Hibernate session on shutdown
        HibernateUtility.shutdown();
    }
}
