package Service;

import PaymentService.grpc.Payment;
import PaymentService.grpc.PaymentServiceGrpc;
import Repository.PaymentRepository;
import io.grpc.stub.StreamObserver;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

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
            transaction = session.beginTransaction();

            Model.Payment payment = new Model.Payment(
                    null,
                    paymentRequest.getCustomer(),
                    paymentRequest.getBookingType(),
                    paymentRequest.getBooking(),
                    paymentRequest.getStatus(),
                    paymentRequest.getCreditcardref()
            );

            repository.createPayment(payment);
            transaction.commit();

            Payment.PaymentResponse response = Payment.PaymentResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("Payment created successfully.")
                    .build();
            responseObserver.onNext(response);
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            Payment.PaymentResponse response = Payment.PaymentResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Failed to create payment: " + e.getMessage())
                    .build();
            responseObserver.onNext(response);
        } finally {
            responseObserver.onCompleted();
        }
    }

    @Override
    public void deletePayment(Payment.PaymentRequestById request, StreamObserver<Payment.PaymentResponse> responseObserver) {
        Transaction transaction = null;
        boolean success = false;
        String message;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            Model.Payment payment = session.get(Model.Payment.class, request.getId());

            if (payment != null) {
                session.remove(payment);
                transaction.commit();
                success = true;
                message = "Payment deleted successfully.";
            } else {
                message = "Payment not found.";
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            message = "Failed to delete payment: " + e.getMessage();
            e.printStackTrace();
        }

        Payment.PaymentResponse response = Payment.PaymentResponse.newBuilder()
                .setSuccess(success)
                .setMessage(message)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void listPayments(Payment.Empty request, StreamObserver<Payment.PaymentListResponse> responseObserver) {
        try (Session session = sessionFactory.openSession()) {
            List<Model.Payment> payments = session.createQuery("FROM Payment", Model.Payment.class).list();

            Payment.PaymentListResponse.Builder responseBuilder = Payment.PaymentListResponse.newBuilder();

            for (Model.Payment payment : payments) {
                Payment.PaymentResponse paymentResponse = Payment.PaymentResponse.newBuilder()
                        .setId(payment.getId())
                        .setCustomer(payment.getCustomer())
                        .setBookingType(payment.getBookingType())
                        .setBooking(payment.getBooking())
                        .setStatus(payment.getStatus())
                        .setCreditcardref(payment.getCreditcardref())
                        .setSuccess(true)
                        .setMessage("Payment retrieved successfully.")
                        .build();
                responseBuilder.addPayments(paymentResponse);
            }

            responseObserver.onNext(responseBuilder.build());
        } catch (Exception e) {
            e.printStackTrace();
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

}
