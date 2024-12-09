package Service;

import PaymentService.grpc.Payment;
import PaymentService.grpc.PaymentServiceGrpc;
import Repository.ICreatePaymentRepository;
import Repository.IReadPaymentRepository;
import Repository.IUpdatePaymentRepository;
import io.grpc.stub.StreamObserver;

import java.util.List;
import java.util.Optional;

public class PaymentService extends PaymentServiceGrpc.PaymentServiceImplBase {
    private final ICreatePaymentRepository createPaymentRepository;
    private final IReadPaymentRepository readPaymentRepository;
    private final IUpdatePaymentRepository updatePaymentRepository;

    public PaymentService(ICreatePaymentRepository createPaymentRepository,
                          IReadPaymentRepository readPaymentRepository,
                          IUpdatePaymentRepository updatePaymentRepository) {
        this.createPaymentRepository = createPaymentRepository;
        this.readPaymentRepository = readPaymentRepository;
        this.updatePaymentRepository = updatePaymentRepository;
    }

    @Override
    public void createPayment(Payment.PaymentRequest paymentRequest, StreamObserver<Payment.PaymentResponse> responseObserver) {
        try {
            // Inline validation logic
            if (paymentRequest.getCustomer() <= 0) {
                throw new IllegalArgumentException("Customer ID must be greater than zero.");
            }

            if (paymentRequest.getBooking() <= 0) {
                throw new IllegalArgumentException("Booking ID must be greater than zero.");
            }

            if (paymentRequest.getStatus() == null || paymentRequest.getStatus().isEmpty()) {
                throw new IllegalArgumentException("Status cannot be null or empty.");
            }

            if (paymentRequest.getCreditcardref() <= 0) {
                throw new IllegalArgumentException("Credit card reference must be greater than zero.");
            }

            // Map gRPC request to entity
            Model.Payment payment = new Model.Payment(
                    paymentRequest.getCustomer(),
                    paymentRequest.getBookingType(),
                    paymentRequest.getBooking(),
                    paymentRequest.getStatus(),
                    paymentRequest.getCreditcardref()
            );

            // Persist the payment
            boolean success = createPaymentRepository.createPayment(payment);

            // Build response
            Payment.PaymentResponse response = Payment.PaymentResponse.newBuilder()
                    .setSuccess(success)
                    .setMessage(success ? "Payment created successfully." : "Failed to create payment.")
                    .setId(payment.getId())
                    .build();

            responseObserver.onNext(response);
        } catch (IllegalArgumentException e) {
            responseObserver.onNext(Payment.PaymentResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Validation error: " + e.getMessage())
                    .build());
        } catch (Exception e) {
            responseObserver.onNext(Payment.PaymentResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Failed to create payment: " + e.getMessage())
                    .build());
        } finally {
            responseObserver.onCompleted();
        }
    }

    @Override
    public void listPaymentsByCustomer(Payment.PaymentListByCustomerRequest request, StreamObserver<Payment.PaymentListResponse> responseObserver) {
        try {
            List<Model.Payment> payments = readPaymentRepository.getAllPayments();

            Payment.PaymentListResponse.Builder responseBuilder = Payment.PaymentListResponse.newBuilder();
            for (Model.Payment payment : payments) {
                responseBuilder.addPayments(Payment.PaymentResponse.newBuilder()
                        .setId(payment.getId())
                        .setCustomer(payment.getCustomer())
                        .setBookingType(payment.getBookingType())
                        .setBooking(payment.getBooking())
                        .setStatus(payment.getStatus())
                        .setCreditcardref(payment.getCreditcardref())
                        .setSuccess(true)
                        .setMessage("Payments retrieved successfully.")
                        .build());
            }

            responseObserver.onNext(responseBuilder.build());
        } catch (Exception e) {
            responseObserver.onNext(Payment.PaymentListResponse.newBuilder()
                    .addPayments(Payment.PaymentResponse.newBuilder()
                            .setSuccess(false)
                            .setMessage("Failed to list payments: " + e.getMessage())
                            .build())
                    .build());
        } finally {
            responseObserver.onCompleted();
        }
    }

    @Override
    public void updatePaymentStatus(Payment.PaymentStatusUpdateRequest request, StreamObserver<Payment.PaymentResponse> responseObserver) {
        try {
            // Inline validation logic
            if (request.getId() <= 0) {
                throw new IllegalArgumentException("Payment ID must be greater than zero.");
            }

            if (request.getStatus() == null || request.getStatus().isEmpty()) {
                throw new IllegalArgumentException("Status cannot be null or empty.");
            }

            // Retrieve and update payment
            Optional<Model.Payment> paymentOptional = readPaymentRepository.getPaymentById(request.getId());
            if (paymentOptional.isPresent()) {
                Model.Payment payment = paymentOptional.get();
                payment.setStatus(request.getStatus());
                updatePaymentRepository.updatePayment(payment);

                responseObserver.onNext(Payment.PaymentResponse.newBuilder()
                        .setSuccess(true)
                        .setMessage("Payment status updated successfully.")
                        .build());
            } else {
                responseObserver.onNext(Payment.PaymentResponse.newBuilder()
                        .setSuccess(false)
                        .setMessage("Payment not found.")
                        .build());
            }
        } catch (IllegalArgumentException e) {
            responseObserver.onNext(Payment.PaymentResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Validation error: " + e.getMessage())
                    .build());
        } catch (Exception e) {
            responseObserver.onNext(Payment.PaymentResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Failed to update payment status: " + e.getMessage())
                    .build());
        } finally {
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getPaymentById(Payment.PaymentRequestById request, StreamObserver<Payment.PaymentResponse> responseObserver) {
        try {
            Optional<Model.Payment> paymentOptional = readPaymentRepository.getPaymentById(request.getId());
            if (paymentOptional.isPresent()) {
                Model.Payment payment = paymentOptional.get();

                responseObserver.onNext(Payment.PaymentResponse.newBuilder()
                        .setSuccess(true)
                        .setMessage("Payment retrieved successfully.")
                        .setId(payment.getId())
                        .setCustomer(payment.getCustomer())
                        .setBookingType(payment.getBookingType())
                        .setBooking(payment.getBooking())
                        .setStatus(payment.getStatus())
                        .setCreditcardref(payment.getCreditcardref())
                        .build());
            } else {
                responseObserver.onNext(Payment.PaymentResponse.newBuilder()
                        .setSuccess(false)
                        .setMessage("Payment not found.")
                        .build());
            }
        } catch (Exception e) {
            responseObserver.onNext(Payment.PaymentResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Failed to retrieve payment: " + e.getMessage())
                    .build());
        } finally {
            responseObserver.onCompleted();
        }
    }
}
