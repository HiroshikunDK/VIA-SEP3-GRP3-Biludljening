package Repository;

import Model.Creditcard;
import Persistance.Databasehelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreditcardRepository implements ICreditcardRepository {

  private final Databasehelper databasehelper;

  public CreditcardRepository() {
    this.databasehelper = new Databasehelper();
  }

  @Override
  public void addCreditcard(Creditcard creditcard) {
    String query = "INSERT INTO creditcard (creditcard_id, creditcardnr, cc_name, cc_lastname, customerid) VALUES (?, ?, ?, ?, ?)";

    try (Connection connection = databasehelper.getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {

      statement.setLong(1, creditcard.getCreditcard_id());
      statement.setString(2, creditcard.getCreditcardnr());
      statement.setString(3, creditcard.getCc_name());
      statement.setString(4, creditcard.getCc_lastname());
      statement.setLong(5, creditcard.getCustomerid());

      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();

    }
  }

  @Override
  public List<Creditcard> getallCreditcards() {
    List<Creditcard> creditcards = new ArrayList<>();
    String query = "SELECT * FROM creditcard";

    try (Connection connection = databasehelper.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery()) {

      while (resultSet.next()) {
        Creditcard creditcard = new Creditcard();
        creditcard.setCreditcard_id(resultSet.getLong("creditcard_id"));
        creditcard.setCreditcardnr(resultSet.getString("creditcardnr"));
        creditcard.setCc_name(resultSet.getString("cc_name"));
        creditcard.setCc_lastname(resultSet.getString("cc_lastname"));
        creditcard.setCustomerid(resultSet.getLong("customerid"));

        creditcards.add(creditcard);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      // Log or handle exception as needed
    }
    return creditcards;
  }
}
