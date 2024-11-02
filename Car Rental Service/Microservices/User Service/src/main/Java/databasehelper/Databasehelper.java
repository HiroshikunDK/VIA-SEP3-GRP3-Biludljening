package databasehelper;

import Model.Customer;
import Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Databasehelper
{//"C:\Users\adres\IdeaProjects\VIA-SEP3-GRP3-Biludljening\Car Rental Service\Z_DatabaseUtility\UserServiceDBLite\UserServiceDBV2.db"
  //private static final String URL ="jdbc:sqlite:Car Rental Service/Z_DatabaseUtility/UserServiceDBLite/UserServiceDBV2.db";
  //private static final String URL ="jdbc:sqlite:Car Rental Service/Z_DatabaseUtility/UserServiceDBLite/UserServiceDB.db";
  private static final String URL = "jdbc:sqlite:C:/Users/adres/IdeaProjects/VIA-SEP3-GRP3-Biludljening/Car Rental Service/Z_DatabaseUtility/UserServiceDBLite/UserServiceDBV2.db";

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

  // CREATE - Adds a new user
  public boolean addUser(User user) {
    String query = "INSERT INTO user (userid, userFirstname, userLastname, title, email, phonenr, username, password, userpermissions) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
    try (Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {
      statement.setInt(1,user.getId());
      statement.setString(2, user.getUserFirstname());
      statement.setString(3, user.getUserLastname());
      statement.setString(4, user.getTitle());
      statement.setString(5, user.getEmail());
      statement.setInt(6, user.getPhonenr());
      statement.setString(7, user.getUsername());
      statement.setString(8, user.getPassword());
      statement.setString(9, user.getUserpermission());

      return statement.executeUpdate() > 0;

    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  // READ - Gets a single user by ID
  public User getUserById(int id) {
    String query = "SELECT * FROM user WHERE userid = ?";
    try (Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {

      statement.setInt(1, id);
      ResultSet resultSet = statement.executeQuery();

      if (resultSet.next()) {
         User user = new User(
            resultSet.getInt("userid"),
            resultSet.getString("userFirstname"),
            resultSet.getString("userLastname"),
            resultSet.getString("title"),
            resultSet.getString("email"),
            resultSet.getInt("phonenr"),
            resultSet.getString("username"),
            resultSet.getString("password"),
            resultSet.getString("userpermissions")
        );
      return user;
      }


    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  // READ - Gets all users
  public List<User> getAllUsers() {
    List<User> users = new ArrayList<>();
    String query = "SELECT * FROM user";

    try (Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)) {

      while (resultSet.next()) {
        User user = new User(
            resultSet.getInt("userid"),
            resultSet.getString("userFirstname"),
            resultSet.getString("userLastname"),
            resultSet.getString("title"),
            resultSet.getString("email"),
            resultSet.getInt("phonenr"),
            resultSet.getString("username"),
            resultSet.getString("password"),
            resultSet.getString("userpermissions")
        );
        users.add(user);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return users;
  }

  // UPDATE - Updates an existing user's details
  public boolean updateUser(User user) {
    String query = "UPDATE user SET userFirstname = ?, userLastname = ?, title = ?, email = ?, phonenr = ?, username = ?, password = ?, userpermission = ? WHERE id = ?";
    try (Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {

      statement.setString(1, user.getUserFirstname());
      statement.setString(2, user.getUserLastname());
      statement.setString(3, user.getTitle());
      statement.setString(4, user.getEmail());
      statement.setInt(5, user.getPhonenr());
      statement.setString(6, user.getUsername());
      statement.setString(7, user.getPassword());
      statement.setString(8, user.getUserpermission());
      statement.setInt(9, user.getId());

      return statement.executeUpdate() > 0;

    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  // DELETE - Deletes a user by ID
  public boolean deleteUser(int id) {
    String query = "DELETE FROM user WHERE userid = ?";
    try (Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {

      statement.setInt(1, id);
      return statement.executeUpdate() > 0;

    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }
  // CREATE - Adds a new customer
  public boolean addCustomer(Customer customer) {
    String query = "INSERT INTO customer (customer_id, crs_name, crs_lastname, username, password, email, phonenr) VALUES (?, ?, ?, ?, ?, ?,?)";
    try (Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {

      statement.setInt(1,customer.getCustomer_id());
      statement.setString(2, customer.getFirst_name());
      statement.setString(3, customer.getLast_name());
      statement.setString(4, customer.getUsername());
      statement.setString(5, customer.getPassword());
      statement.setString(6, customer.getEmail());
      statement.setString(7, customer.getPhonenr());

      return statement.executeUpdate() > 0;

    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  // READ - Gets a single customer by ID
  public Customer getCustomerById(int customer_id) {
    String query = "SELECT * FROM customer WHERE customer_id = ?";
    try (Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {

      statement.setInt(1, customer_id);
      ResultSet resultSet = statement.executeQuery();

      if (resultSet.next()) {
        return new Customer(
            resultSet.getInt("customer_id"),
            resultSet.getString("first_name"),
            resultSet.getString("last_name"),
            resultSet.getString("username"),
            resultSet.getString("password"),
            resultSet.getString("email"),
            resultSet.getString("phonenr")
        );
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  // READ - Gets all customers
  public List<Customer> getAllCustomers() {
    List<Customer> customers = new ArrayList<>();
    String query = "SELECT * FROM customer";

    try (Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)) {

      while (resultSet.next()) {
        Customer customer = new Customer(
            resultSet.getInt("customer_id"),
            resultSet.getString("crs_name"),
            resultSet.getString("crs_lastname"),
            resultSet.getString("username"),
            resultSet.getString("password"),
            resultSet.getString("email"),
            resultSet.getString("phonenr")
        );
        customers.add(customer);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return customers;
  }

  // UPDATE - Updates an existing customer's details
  public boolean updateCustomer(Customer customer) {
    String query = "UPDATE customer SET first_name = ?, last_name = ?, username = ?, password = ?, email = ?, phonenr = ? WHERE customer_id = ?";
    try (Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {

      statement.setString(1, customer.getFirst_name());
      statement.setString(2, customer.getLast_name());
      statement.setString(3, customer.getUsername());
      statement.setString(4, customer.getPassword());
      statement.setString(5, customer.getEmail());
      statement.setString(6, customer.getPhonenr());
      statement.setInt(7, customer.getCustomer_id());

      return statement.executeUpdate() > 0;

    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  // DELETE - Deletes a customer by ID
  public boolean deleteCustomer(int customer_id) {
    String query = "DELETE FROM customer WHERE customer_id = ?";
    try (Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {

      statement.setInt(1, customer_id);
      return statement.executeUpdate() > 0;

    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }
}