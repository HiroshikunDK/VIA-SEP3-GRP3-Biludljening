import Persistance.Databasehelper;
import Repository.CreditcardRepository;
import Repository.PaymentRepository;
import Service.CreditcardService;
import Service.PaymentService;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class Main {
  public static void main(String[] args)
      throws IOException, InterruptedException
  {
    PaymentRepository pr = new PaymentRepository();
    CreditcardRepository cr = new CreditcardRepository();
    PaymentService paymentService = new PaymentService(pr);
    CreditcardService creditcardService = new CreditcardService(cr);

    io.grpc.Server server = ServerBuilder.forPort(5005)
        .addService(paymentService)
        .addService(creditcardService)
        .build();
    server.start();
    System.out.println("Server running..");

    server.awaitTermination();
  }
}
