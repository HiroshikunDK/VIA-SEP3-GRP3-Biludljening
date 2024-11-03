package RideshareService;

import Repository.RideshareRepository;
import Service.RideshareService;
import RideShareService.grpc.RideShareServiceGrpc;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class Main {
    public static void main(String[] args) throws Exception {
        // Configure Hibernate SessionFactory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        RideshareRepository rideshareRepository = new RideshareRepository(sessionFactory);
        RideshareService rideshareService = new RideshareService(rideshareRepository);

        // gRPC server setup
        Server server = ServerBuilder.forPort(5008)
                .addService(rideshareService)
                .build()
                .start();

        System.out.println("RideShareService gRPC server started on port " + server.getPort());

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down RideShareService gRPC server...");
            server.shutdown();
            sessionFactory.close();
            System.out.println("Server shut down successfully.");
        }));

        server.awaitTermination();
    }
}
