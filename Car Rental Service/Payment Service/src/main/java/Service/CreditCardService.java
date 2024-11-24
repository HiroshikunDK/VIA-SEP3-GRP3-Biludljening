/* package Service;

import Model.CreditCard;
import PaymentService.grpc.CreditCardServiceGrpc;
import PaymentService.grpc.Payment;
import PaymentService.grpc.PaymentServiceGrpc;
import Repository.CreditCardRepository;
import io.grpc.stub.StreamObserver;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CreditCardService extends CreditCardServiceGrpc.CreditCardServiceImplBase
{
  private final SessionFactory sessionFactory;
  private final CreditCardRepository creditCardRepository;

  public CreditCardService(SessionFactory sessionFactory, CreditCardRepository creditCardRepository)
  {
    this.sessionFactory = sessionFactory;
    this.creditCardRepository = creditCardRepository;
  }
@Override
 public void createCreditcard(Payment.CreditcardRequest request, StreamObserver<Payment.CreditcardResponse> responseObserver)
  {
    Transaction transaction = null;
    try (Session session = sessionFactory.openSession())
    {
      //Starter ny transaktion
      transaction = session.beginTransaction();

      //Opretter et Creditcard objekt baseret på dataen fra requesten
      CreditCard creditCard = new CreditCard(null, request.getCreditcardnr(),
          request.getCcName(), request.getCcLastname(),
          request.getCustomerid());
      creditCardRepository.addCreditcard(creditCard);
      transaction.commit();
      Payment.CreditcardResponse response = Payment.CreditcardResponse.newBuilder()
          .setSuccess(true).setMessage("CreditCard added succesfully").build();
      responseObserver.onNext(response);
    }
    catch (Exception e)
    {
      if (transaction != null)
      {
        transaction.rollback();
      }
      Payment.CreditcardResponse response = Payment.CreditcardResponse.newBuilder()
          .setSuccess(false).setMessage("Failed to create creditcard").build();
      responseObserver.onNext(response);
    }
    finally
    {
      responseObserver.onCompleted();
    }
  }

  @Override public void getCreditcardById(Payment.CreditcardRequestById request,
      StreamObserver<Payment.CreditcardResponse> responseObserver)
  {
    try
    {
      // Henter kreditkortet baseret på ID fra requesten
      CreditCard creditCard = creditCardRepository.getCreditcardById(request.getCreditcardId());

      if (creditCard != null)
      {
        // hvis kreditkortet findes, oprettes en CreditcardResponse med relevante data
        Payment.CreditcardResponse response = Payment.CreditcardResponse.newBuilder()
            .setCreditcardId(creditCard.getCreditcard_id())
            .setCreditcardnr(creditCard.getCreditcardnr())
            .setCcName(creditCard.getCc_name())
            .setCcLastname(creditCard.getCc_lastname())
            .setCustomerid(creditCard.getCustomerid()).setSuccess(true)
            .setMessage("Credit card found").build();

        //Send responsen tilbage til klienten
        responseObserver.onNext(response);
      }
      else
      {
        // Hvis kreditkortet ikke findes, fejlmeddelse
        Payment.CreditcardResponse response = Payment.CreditcardResponse.newBuilder()
            .setMessage("Credit card not found").build();

        responseObserver.onNext(response);
      }

    }
    catch (Exception e)
    {
      // Håndter fejl
      Payment.CreditcardResponse response = Payment.CreditcardResponse.newBuilder()
          .setMessage("Failed to retrieve credit card: " + e.getMessage())
          .build();

      responseObserver.onNext(response);
    }
    finally
    {
      // Sørger for at fuldføre responsen
      responseObserver.onCompleted();
    }
  }

  @Override public void getAllCreditcards(Payment.Empty request, StreamObserver<Payment.CreditcardListResponse> responseObserver)
  {
    try
    {
      // Bruger repository til at hente alle kreditkort
      List<CreditCard> creditCards = creditCardRepository.getallCreditcards();

      Payment.CreditcardListResponse.Builder creditCardListBuilder = Payment.CreditcardListResponse.newBuilder();

      for (CreditCard creditCard : creditCards)
      {
        Payment.CreditcardResponse creditcardResponse = Payment.CreditcardResponse.newBuilder()
            .setCreditcardId(creditCard.getCreditcard_id())
            .setCreditcardnr(creditCard.getCreditcardnr())
            .setCcName(creditCard.getCc_name())
            .setCcLastname(creditCard.getCc_lastname())
            .setCustomerid(creditCard.getCustomerid())
            .setMessage("Creditcards retrieved successfully").build();
        // Tilføjer hver CreditcardResponse til listen
        creditCardListBuilder.addCreditcards(creditcardResponse);
      }
      // Send hele listen til klienten
      responseObserver.onNext(creditCardListBuilder.build());
    }
    catch (Exception e)
    {
      Payment.CreditcardListResponse response = Payment.CreditcardListResponse.newBuilder()
          .setMessage("Failed to list creditcards: " + e.getMessage()).build();
      responseObserver.onNext(response);
    }
    finally
    {
      // Sørger for at fuldføre responsen
      responseObserver.onCompleted();
    }
  }

  public void deleteCreditcard(Payment.CreditcardRequestById request,
      StreamObserver<Payment.CreditcardResponse> responseObserver)
  {
    boolean success = false;
    String message;
    try
    {
      creditCardRepository.deleteCreditcard(request.getCreditcardId());
      success = true;
      message = "Credit card deleted successfully";
    }
    catch (Exception e)
    {
      message = "Failed to delete credit card: " + e.getMessage();
      e.printStackTrace();
    }
    Payment.CreditcardResponse response = Payment.CreditcardResponse.newBuilder()
        .setSuccess(success).setMessage(message).build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
  @Override
  public void updateCreditcard(Payment.CreditcardRequest request, StreamObserver<Payment.CreditcardResponse> responseObserver)
  {
    Transaction transaction = null;
    try(Session session = sessionFactory.openSession())
    {
      transaction = session.beginTransaction();
      CreditCard existingCard = creditCardRepository.getCreditcardById(request.getCreditcardId());

      if(existingCard != null)
      {
        //Opdater eksisterende data
        existingCard.setCreditcard_id(request.getCreditcardId());
        existingCard.setCreditcardnr(request.getCreditcardnr());
        existingCard.setCc_name(request.getCcName());
        existingCard.setCc_lastname(request.getCcLastname());
        existingCard.setCustomerid(request.getCustomerid());

        //gem ændringerne i db
        creditCardRepository.updateCreditcard(existingCard);
        transaction.commit();

        //Lav response

        Payment.CreditcardResponse response = Payment.CreditcardResponse.newBuilder()
            .setCreditcardId(existingCard.getCreditcard_id())
            .setCreditcardnr(existingCard.getCreditcardnr())
            .setCcName(existingCard.getCc_name())
            .setCcLastname(existingCard.getCc_lastname())
            .setCustomerid(existingCard.getCustomerid())
            .setSuccess(true)
            .setMessage("Credit card updated successfully").build();

        //Send response til client
        responseObserver.onNext(response);
      }
      else {
        Payment.CreditcardResponse response = Payment.CreditcardResponse.newBuilder()
            .setSuccess(false)
            .setMessage("Credit card not found")
            .build();

        responseObserver.onNext(response);
      }
    }
    catch (Exception e)
    {
      if (transaction != null) {
        transaction.rollback();
      }
      // Send en fejlrespons tilbage til klienten
      Payment.CreditcardResponse response = Payment.CreditcardResponse.newBuilder()
          .setSuccess(false)
          .setMessage("Failed to update credit card: " + e.getMessage())
          .build();

      responseObserver.onNext(response);
    }
    finally {
      responseObserver.onCompleted();
    }

  }

}
*/