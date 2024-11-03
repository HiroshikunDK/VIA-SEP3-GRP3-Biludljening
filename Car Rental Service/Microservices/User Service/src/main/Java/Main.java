import Repository.UserRepository;
import Service.UserService;
import Persistence.HibernateUtility;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);

        Server server = ServerBuilder.forPort(5006)
                .addService(userService)
                .build()
                .start();

        System.out.println("UserService gRPC server started on port " + server.getPort());

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down UserService gRPC server...");
            server.shutdown();
            HibernateUtility.shutdown();
            System.out.println("Server shut down successfully.");
        }));

        server.awaitTermination();
    }
}
