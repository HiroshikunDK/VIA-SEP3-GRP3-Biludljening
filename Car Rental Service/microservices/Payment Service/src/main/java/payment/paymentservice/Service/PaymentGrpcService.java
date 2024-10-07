package payment.paymentservice.Service;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import payment.paymentservice.grpc.PaymentServiceProto;
import payment.paymentservice.grpc.PaymentServiceGrpc;
import payment.paymentservice.Model.Payment;
import payment.paymentservice.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

@GrpcService
public class PaymentGrpcService extends PaymentServiceGrpc.PaymentServiceImplBase {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public void createPayment(PaymentServiceProto.PaymentRequest request, StreamObserver<PaymentServiceProto.PaymentResponse> responseObserver) {
        Payment payment = new Payment(
                request.getUserId(),
                request.getCarId(),
                request.getAmount(),
                LocalDateTime.now(),
                "Pending"
        );
        Payment savedPayment = paymentRepository.save(payment);

        PaymentServiceProto.PaymentResponse response = PaymentServiceProto.PaymentResponse.newBuilder()
                .setId(savedPayment.getId())
                .setUserId(savedPayment.getUserId())
                .setCarId(savedPayment.getCarId())
                .setAmount(savedPayment.getAmount())
                .setPaymentDate(savedPayment.getPaymentDate().toString())
                .setPaymentStatus(savedPayment.getPaymentStatus())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getPaymentById(PaymentServiceProto.PaymentRequestById request, StreamObserver<PaymentServiceProto.PaymentResponse> responseObserver) {
        Optional<Payment> payment = paymentRepository.findById(request.getId());

        if (payment.isPresent()) {
            PaymentServiceProto.PaymentResponse response = PaymentServiceProto.PaymentResponse.newBuilder()
                    .setId(payment.get().getId())
                    .setUserId(payment.get().getUserId())
                    .setCarId(payment.get().getCarId())
                    .setAmount(payment.get().getAmount())
                    .setPaymentDate(payment.get().getPaymentDate().toString())
                    .setPaymentStatus(payment.get().getPaymentStatus())
                    .build();
            responseObserver.onNext(response);
        } else {
            responseObserver.onError(new Exception("Payment not found with ID: " + request.getId()));
        }

        responseObserver.onCompleted();
    }
}
