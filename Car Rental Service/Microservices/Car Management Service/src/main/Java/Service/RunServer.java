package Service;

import Persistence.DataBaseHelper;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class RunServer
{
  public static void main(String[] args)
      throws IOException, InterruptedException
  {
    DataBaseHelper dataBaseHelper = new DataBaseHelper();
    CarService carService = new CarService(dataBaseHelper);
    io.grpc.Server server1 = ServerBuilder
        .forPort(9090)
        .addService(carService)
        .build();

    server1.start();
    System.out.println("Server running");

    server1.awaitTermination();
  }
}
