package RideshareService;

import Repository.RideShareOfferHibernateImpl;
import Repository.RideShareRequestHibernateImpl;
import Repository.RideshareRepository;
import Service.RideshareService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class RideShareMain {
    public static void main(String[] args) throws Exception {
        // Configure Hibernate SessionFactory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // Custom implementation
        RideshareRepository rideshareRepository = new RideshareRepository(sessionFactory);
        RideShareOfferHibernateImpl rideShareOfferHibernate = new RideShareOfferHibernateImpl(sessionFactory);
        RideShareRequestHibernateImpl rideShareRequestHibernate = new RideShareRequestHibernateImpl(sessionFactory);

        RideshareService rideshareService = new RideshareService(
                rideshareRepository, rideShareOfferHibernate, rideShareRequestHibernate);

        // Load TLS certificate and key using ClassLoader
        // Load certificate and key using ClassLoader for relative path
        ClassLoader classLoader = RideShareMain.class.getClassLoader();
        URL certUrl = classLoader.getResource("server.crt");
        URL keyUrl = classLoader.getResource("server.key");

        if (certUrl == null || keyUrl == null) {
            throw new RuntimeException("Certificate or Key file not found in resources.");
        }

        String certPath = URLDecoder.decode(certUrl.getFile(), StandardCharsets.UTF_8);
        String keyPath = URLDecoder.decode(keyUrl.getFile(), StandardCharsets.UTF_8);

        File certFile = new File(certPath);
        File keyFile = new File(keyPath);

        // gRPC server setup with TLS
        Server server = NettyServerBuilder.forPort(5008)
                .useTransportSecurity(certFile, keyFile)
                .addService(rideshareService)
                .build()
                .start();

        System.out.println("RideShareService gRPC server started with HTTPS on port " + server.getPort());

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down RideShareService gRPC server...");
            server.shutdown();
            sessionFactory.close();
            System.out.println("Server shut down successfully.");
        }));

        server.awaitTermination();
    }
}
