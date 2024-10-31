package Persistence;

import Model.Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseHelper implements Database
{
  //private static final String URL ="jdbc:sqlite:Car Rental Service/Z_DatabaseUtility/CarManagementServiceDBLite/CarManagementServiceDBV2.db";
  private static final String URL ="jdbc:sqlite:/Users/apogultekin/Library/CloudStorage/OneDrive-ViaUC/Skole_/3 semester/SEP3/Code2/Car Rental Service/Z_DatabaseUtility/CarManagementServiceDBLite/CarManagementServiceDBV2.db";

  public Connection getConnection() {
    try {
      return DriverManager.getConnection(URL);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }

  }
  public Connection getConnection(String connectionstring) {
    try {
      return DriverManager.getConnection(connectionstring);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }

  }

  public boolean registerCar(Car car)
  {
    String query = "INSERT INTO car (car_id, vin, yearproduced, manufactor, model, color, altname, seats, car_range, localhubref) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
    try (Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {

      statement.setInt(1, car.getCarId());
      statement.setString(2, car.getVin());
      statement.setInt(3, car.getYearProduced());
      statement.setString(4, car.getManufacturer());
      statement.setString(5, car.getModel());
      statement.setString(6, car.getColor());
      statement.setString(7, car.getAltName());
      statement.setInt(8, car.getSeats());
      statement.setInt(9, car.getCarRange());
      statement.setInt(10, car.getLocationHubRef());


      return statement.executeUpdate() > 0;

    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }
}
