package Service;

import PaymentService.grpc.Payment;
import PaymentService.grpc.PaymentServiceGrpc;
import Repository.PaymentRepository;
import io.grpc.stub.StreamObserver;

public class PaymentService extends PaymentServiceGrpc.PaymentServiceImplBase
{
 private PaymentRepository repository;

 public PaymentService(PaymentRepository repository)
 {
   this.repository = repository;
 }
 @Override public void createPayment(Payment.PaymentRequest paymentRequest, StreamObserver<Payment.PaymentResponse> responseObserver)
 {
   Model.Payment payment = new Model.Payment(paymentRequest.getId(),paymentRequest.getCustomer(),paymentRequest.getBookingType(),
       paymentRequest.getBooking(),
       paymentRequest.getStatus(),
       paymentRequest.getCreditcardref());
   repository.createPayment(payment);
   responseObserver.onNext(Payment.PaymentResponse.newBuilder().build());
   responseObserver.onCompleted();
 }
}
