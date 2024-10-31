package Service;

import PaymentService.grpc.Payment;
import PaymentService.grpc.PaymentServiceGrpc;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;

public class PaymentService extends PaymentServiceGrpc.PaymentServiceImplBase
{
  public void CreateCreditcard(Empty request, StreamObserver<Payment.CreditcardResponse> responseObserver)
  {
  }

  public void CreatePayment( Payment.PaymentRequest request, StreamObserver<Payment.PaymentResponse> responseObserver)
  {


  }
}
