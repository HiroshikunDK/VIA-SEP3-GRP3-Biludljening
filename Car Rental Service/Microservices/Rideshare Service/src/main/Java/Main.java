import Service.RideShareService;

import static io.grpc.ServerBuilder.forPort;
public static void main(String[] args) throws Exception {
    RideShareService rsService = new RideShareService();
    io.grpc.Server server = forPort(9090)
            .addService(rsService)
            .build();
    server.start();
    System.out.println("Server running");

    server.awaitTermination();
}