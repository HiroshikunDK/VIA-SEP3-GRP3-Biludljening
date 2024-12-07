package CarManagementService;

import Repository.BookingCarRepository;
import Repository.LocationsHubRepository;
import Service.BookingCarService;
import Service.LocationHubService;
import Shared.HibernateUtility;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import Service.CarService;
import Repository.CarRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.io.IOException;

public class CarMain {

    public static void main(String[] args) throws IOException, InterruptedException {
        // Initialize EntityManager from Hibernate Utility
        EntityManagerFactory entityManagerFactory = HibernateUtility.getEntityManagerFactory();

        // Pass the EntityManagerFactory to the repositories
        CarRepository carRepository = new CarRepository(entityManagerFactory);
        BookingCarRepository bookingCarRepository = new BookingCarRepository(entityManagerFactory);
        LocationsHubRepository locationsHubRepository = new LocationsHubRepository(entityManagerFactory);

        // Initialize CarService
        CarService carService = new CarService(carRepository);
        BookingCarService bookingCarService = new BookingCarService(bookingCarRepository);
        LocationHubService locationHubService = new LocationHubService(locationsHubRepository);

        // Start gRPC server with TokenValidation interceptor
        Server server = ServerBuilder.forPort(5004)
                .addService(carService)
                .addService(bookingCarService)
                .addService(locationHubService)
                .build()
                .start();

        System.out.println("gRPC server started on port 5004");

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
