import Repository.RideshareRepository;
import Service.RideshareService;
import Persistence.DatabaseHelper;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        DatabaseHelper dbHelper = new DatabaseHelper();
        RideshareRepository rideshareRepository = new RideshareRepository(dbHelper);

        RideshareService rideshareService = new RideshareService(rideshareRepository);

        Server server = ServerBuilder.forPort(5007)
                .addService(rideshareService)
                .build()
                .start();

        System.out.println("RideshareService gRPC server started on port " + server.getPort());

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down RideshareService gRPC server...");
            server.shutdown();
            System.out.println("Server shut down successfully.");
        }));

        server.awaitTermination();
    }
}
