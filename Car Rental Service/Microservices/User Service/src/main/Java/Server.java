import Service.CustomerService;
import Service.UserService;
import databasehelper.Databasehelper;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class Server
{
  public static void main(String[] args) throws IOException, InterruptedException
  {
    Databasehelper db = new Databasehelper();
    CustomerService customerService = new CustomerService(db);
    UserService userService = new UserService(db);

    io.grpc.Server server = ServerBuilder.forPort(4004)
        .addService(customerService)
        .addService(userService)
        .build();

    server.start();
    System.out.println("Server running..");

    server.awaitTermination();
  }
}
