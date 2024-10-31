package Repository;

import Model.Payment;
import Persistance.Databasehelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class PaymentRepository implements IPaymentRepository
{

  private  Databasehelper databasehelper;
  public PaymentRepository()
  {
    databasehelper = new Databasehelper();
  }

  @Override public Boolean createPayment(Payment payment)
  {
    String query = "INSERT INTO payment (customer, bookingType, booking, status, creditcardref) VALUES (?, ?, ?, ?, ?)";
    try (Connection connection = databasehelper.getConnection()) {
    PreparedStatement statement = connection.prepareStatement(query);

      statement.setLong(1, payment.getCustomer());
      statement.setInt(2, payment.getBookingType());
      statement.setLong(3, payment.getBooking());
      statement.setString(4, payment.getStatus());
      statement.setLong(5, payment.getCreditcardref());
      return statement.executeUpdate()>0;
    }
    catch (SQLException e)
    {
     e.printStackTrace();
      return false;
    }
  }

  @Override public List<Payment> getAllPayments()
  {
    List<Payment> payments = new ArrayList<>();
    String query = "SELECT * FROM payment";

    try (Connection connection = databasehelper.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(query);
      ResultSet resultSet = statement.executeQuery();

      while(resultSet.next())
      {
        Payment payment = new Payment(resultSet.getLong("id"),resultSet.getLong("customer"),
            resultSet.getInt("bookingType"),resultSet.getLong("booking"),
            resultSet.getString("status"),
            resultSet.getLong("creditcardref"));
        payments.add(payment);
      }
    }
    catch (SQLException e)
    {
      throw new RuntimeException(e.getMessage());
    }
    return payments;
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
