package Service;

import PaymentService.grpc.Payment;
import PaymentService.grpc.PaymentServiceGrpc;
import Repository.PaymentRepository;
import Shared.HibernateUtility;
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
        Payment.PaymentResponse response;

        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // Validate input
            if (paymentRequest.getCustomer() <= 0 || paymentRequest.getBooking() <= 0 || paymentRequest.getStatus().isEmpty()) {
                throw new IllegalArgumentException("Missing or invalid required fields in the payment request.");
            }

            // Create and persist payment
            Model.Payment payment = new Model.Payment(
                    paymentRequest.getCustomer(),
                    paymentRequest.getBookingType(),
                    paymentRequest.getBooking(),
                    paymentRequest.getStatus(),
                    paymentRequest.getCreditcardref()
            );
            session.persist(payment);

            // Flush and refresh to ensure ID is generated and loaded
            session.flush();
            session.refresh(payment);

            // Commit transaction
            transaction.commit();

            // Build success response with the now-populated payment ID
            response = Payment.PaymentResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("Payment created successfully.")
                    .setId(payment.getId())
                    .build();
        } catch (IllegalArgumentException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            response = Payment.PaymentResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Validation error: " + e.getMessage())
                    .build();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            response = Payment.PaymentResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Failed to create payment: " + e.getMessage())
                    .build();
        }

        responseObserver.onNext(response);
        responseObserver.onCompleted();
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

    @Override
    public void getPaymentById(Payment.PaymentRequestById request, StreamObserver<Payment.PaymentResponse> responseObserver) {
        try (Session session = sessionFactory.openSession()) {
            // Retrieve payment from the database
            Model.Payment payment = session.get(Model.Payment.class, request.getId());

            if (payment == null) {
                // If payment is not found, return an error response
                responseObserver.onNext(Payment.PaymentResponse.newBuilder()
                        .setSuccess(false)
                        .setMessage("Payment not found.")
                        .build());
            } else {
                // If payment is found, return the details
                Payment.PaymentResponse response = Payment.PaymentResponse.newBuilder()
                        .setSuccess(true)
                        .setMessage("Payment retrieved successfully.")
                        .setId(payment.getId())
                        .setCustomer(payment.getCustomer())
                        .setBookingType(payment.getBookingType())
                        .setBooking(payment.getBooking())
                        .setStatus(payment.getStatus())
                        .setCreditcardref(payment.getCreditcardref())
                        .build();

                responseObserver.onNext(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseObserver.onNext(Payment.PaymentResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Failed to retrieve payment: " + e.getMessage())
                    .build());
        } finally {
            responseObserver.onCompleted();
        }
    }
}
