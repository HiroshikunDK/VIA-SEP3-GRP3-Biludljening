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
        System.out.println("konstruktor");
        this.repository = repository;
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void createPayment(Payment.PaymentRequest paymentRequest, StreamObserver<Payment.PaymentResponse> responseObserver) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            // Opret betaling
            Model.Payment payment = new Model.Payment(
                    null,
                    paymentRequest.getCustomer(),
                    paymentRequest.getBookingType(),
                    paymentRequest.getBooking(),
                    paymentRequest.getStatus(),
                    paymentRequest.getCreditcardref() // Behold, hvis feltet stadig bruges i Payment
            );

            session.persist(payment); // Gem betaling direkte
            transaction.commit();

            Payment.PaymentResponse response = Payment.PaymentResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("Payment created successfully.")
                    .build();
            responseObserver.onNext(response);
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            Payment.PaymentResponse response = Payment.PaymentResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Failed to create payment: " + e.getMessage())
                    .build();
            responseObserver.onNext(response);
        } finally {
            responseObserver.onCompleted();
        }
    }


    /* @Override
    public void deletePayment(Payment.PaymentRequestById request, StreamObserver<Payment.PaymentResponse> responseObserver) {
        boolean success = false;
        String message;

        try {
            repository.deletePayment(request.getId());
            success = true;
            message = "Payment deleted successfully.";
        } catch (Exception e) {
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
      try{
          //Hent Alle payments via repository
          List<Model.Payment> payments = repository.getAllPayments();

          //opbyg en response
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
                  .setMessage("Payments retrieved succesfully!")
                  .build();
              responseBuilder.addPayments(response);
          }
          //Send response tilbage til klienten
          responseObserver.onNext(responseBuilder.build());
      }
      catch (Exception e) {
          e.printStackTrace();
          responseObserver.onNext(Payment.PaymentListResponse.newBuilder()
              .addPayments(Payment.PaymentResponse.newBuilder()
                  .setSuccess(false)
                  .setMessage("Failed to list payments: " + e.getMessage())
                  .build())
              .build());
      }
      finally
      {
          responseObserver.onCompleted();
      }
    }
*/
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
/*
    @Override
    public void updatePaymentStatus(Payment.PaymentStatusUpdateRequest request, StreamObserver<Payment.PaymentResponse> responseStreamObserver)
    {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction(); //Start ny transaktion

            //Henter den eksisterende payment udfra id
            Optional<Model.Payment> optionalPayment = repository.getPaymentById(request.getId());
            if (optionalPayment.isPresent()) {
                Model.Payment payment = optionalPayment.get();
                payment.setStatus(request.getStatus());
                //Gemmer ændringerne til db
                repository.updatePayment(payment);
                //Committer transaktionen
                transaction.commit();

                Payment.PaymentResponse response = Payment.PaymentResponse.newBuilder()
                    .setId(payment.getId())
                    .setCustomer(payment.getCustomer())
                    .setBookingType(payment.getBookingType())
                    .setBooking(payment.getBooking())
                    .setStatus(payment.getStatus())
                    .setCreditcardref(payment.getCreditcardref())
                    .setSuccess(true)
                    .setMessage("Payment status updated succesfully!")
                    .build();

                responseStreamObserver.onNext(response);
            }
            else{
                //Hvis betalingen ikke findes, smid fejlmeddelse
                Payment.PaymentResponse response = Payment.PaymentResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Payment not found")
                    .build();
                responseStreamObserver.onNext(response);
            }
        }
        catch (Exception e) {
            if (transaction != null) transaction.rollback();
            Payment.PaymentResponse response = Payment.PaymentResponse.newBuilder()
                .setSuccess(false)
                .setMessage("Failed to update payment status: " + e.getMessage())
                .build();
            responseStreamObserver.onNext(response);
        }
        finally
        {
            responseStreamObserver.onCompleted();
        }
    }
    @Override
    public void getPaymentById(Payment.PaymentRequestById request, StreamObserver<Payment.PaymentResponse> responseStreamObserver)
    {
        try
        {
            Optional<Model.Payment> payment = repository.getPaymentById(request.getId());
            if(payment.isPresent())
            {
                Model.Payment foundPayment = payment.get();
                Payment.PaymentResponse response = Payment.PaymentResponse.newBuilder()
                    .setId(foundPayment.getId())
                    .setCustomer(foundPayment.getCustomer())
                    .setBookingType(foundPayment.getBookingType())
                    .setBooking(foundPayment.getBooking())
                    .setStatus(foundPayment.getStatus())
                    .setCreditcardref(foundPayment.getCreditcardref())
                    .setSuccess(true)
                    .setMessage("Payment found succesfully")
                    .build();
                responseStreamObserver.onNext(response);
            }
            else {
                Payment.PaymentResponse response = Payment.PaymentResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Payment not found.")
                    .build();
                responseStreamObserver.onNext(response);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Payment.PaymentResponse response = Payment.PaymentResponse.newBuilder()
                .setSuccess(false)
                .setMessage("Failed to retrieve payment: " + e.getMessage())
                .build();
            responseStreamObserver.onNext(response);
        }
        finally
        {
            responseStreamObserver.onCompleted();
        }
    }
 */
}
