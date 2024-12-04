package Service;

import PaymentService.grpc.Payment;
import PaymentService.grpc.PaymentServiceGrpc;
import Repository.PaymentRepository;
import io.grpc.stub.StreamObserver;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;
import java.util.Optional;


public class PaymentService extends PaymentServiceGrpc.PaymentServiceImplBase {
    private final PaymentRepository repository;
    private final SessionFactory sessionFactory;


    public PaymentService(PaymentRepository repository, SessionFactory sessionFactory) {
        this.repository = repository;
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void createPayment(Payment.PaymentRequest paymentRequest, StreamObserver<Payment.PaymentResponse> responseObserver) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            // Start a transaction
            transaction = session.beginTransaction();

            // Validate the incoming request
            if (paymentRequest.getCustomer() <= 0 || paymentRequest.getBooking() <= 0 || paymentRequest.getStatus().isEmpty()) {
                throw new IllegalArgumentException("Missing or invalid required fields in the payment request.");
            }

            // Create a Payment object
            Model.Payment payment = new Model.Payment(
                    null, // ID will be auto-generated
                    paymentRequest.getCustomer(),
                    paymentRequest.getBookingType(),
                    paymentRequest.getBooking(),
                    paymentRequest.getStatus(),
                    paymentRequest.getCreditcardref()
            );

            // Save the payment to the database
            session.persist(payment);

            // Commit the transaction
            transaction.commit();

            // Build a success response
            Payment.PaymentResponse response = Payment.PaymentResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("Payment created successfully.")
                    .setId(payment.getId()) // Include the payment ID in the response
                    .build();
            responseObserver.onNext(response);
        } catch (IllegalArgumentException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            responseObserver.onNext(Payment.PaymentResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Validation error: " + e.getMessage())
                    .build());
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
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
            List<Model.Payment> payments = repository.getPaymentsByCustomer(request.getCustomerId());

            Payment.PaymentListResponse.Builder responseBuilder = Payment.PaymentListResponse.newBuilder();
            for (Model.Payment payment : payments) {
                Payment.PaymentResponse response = Payment.PaymentResponse.newBuilder()
                        .setId(payment.getId())
                        .setCustomer(payment.getCustomer())
                        .setBookingType(payment.getBookingType())
                        .setBooking(payment.getBooking())
                        .setStatus(payment.getStatus())
                        .setCreditcardref(payment.getCreditcardref())
                        .setSuccess(true)
                        .setMessage("Payments retrieved successfully!")
                        .build();
                responseBuilder.addPayments(response);
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
        Optional<Model.Payment> paymentOptional = repository.getPaymentById(request.getId());
        if (paymentOptional.isPresent()) {
            Model.Payment payment = paymentOptional.get();
            payment.setStatus(request.getStatus());
            repository.updatePayment(payment);
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
        responseObserver.onCompleted();
    }

}
