package CarManagementService;

import Repository.BookingCarRepository;
import Repository.LocationsHubRepository;
import Service.BookingCarService;
import Service.LocationHubService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import Service.CarService;
import Repository.CarRepository;
import Persistence.HibernateUtility;

import jakarta.persistence.EntityManager;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        // Initialize EntityManager from Hibernate Utility
        EntityManager entityManager = HibernateUtility.getSessionFactory().createEntityManager();
        CarRepository carRepository = new CarRepository(entityManager);
        BookingCarRepository bookingCarRepository = new BookingCarRepository(entityManager);
        LocationsHubRepository locationsHubRepository = new LocationsHubRepository(entityManager);

        // Initialize CarService
        CarService carService = new CarService(carRepository);
        BookingCarService bookingCarService = new BookingCarService(bookingCarRepository);
        LocationHubService locationHubService = new LocationHubService(locationsHubRepository);

        // Start gRPC server
        Server server = ServerBuilder.forPort(5004)
                .addService(carService).addService(bookingCarService).addService(locationHubService)
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
