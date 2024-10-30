package Repository;

import Model.Payment;
import Persistance.Databasehelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public class PaymentRepository implements IPaymentRepository
{

  private  Databasehelper databasehelper;
  public PaymentRepository()
  {
    databasehelper = new Databasehelper();
  }

  @Override public Payment createPayment(Payment payment)
  {
    String query = "INSERT INTO payment (customer, bookingType, booking, status, creditcardref) VALUES (?, ?, ?, ?, ?)";
    try (Connection connection = databasehelper.getConnection()) {
    PreparedStatement statement = connection.prepareStatement(query);

      statement.setLong(1, payment.getCustomer());
      statement.setInt(2, payment.getBookingType());
      statement.setLong(3, payment.getBooking());
      statement.setString(4, payment.getStatus());
      statement.setLong(5, payment.getCreditcardref());
      statement.executeUpdate();
    }
    catch (SQLException e)
    {
      throw new RuntimeException(e);
    };

    return payment;
  }

  @Override public List<Payment> getAllPayments()
  {
    return List.of();
  }

  @Override public Optional<Payment> getPaymentById(int id)
  {
    return Optional.empty();
  }

  @Override public void updatePayment(Payment payment)
  {

  }

  @Override public void deletePayment(int id)
  {

  }
}
