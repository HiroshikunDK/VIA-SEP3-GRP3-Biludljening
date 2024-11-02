package Service;
import io.grpc.stub.StreamObserver;

import Model.Customer;
import customerservice.CustomerOuterClass;
import databasehelper.Databasehelper;

import java.util.List;

public class CustomerService extends customerservice.CustomerServiceGrpc.CustomerServiceImplBase
{
  private final Databasehelper dbHelper;

  public CustomerService(Databasehelper dbHelper)
  {
    this.dbHelper = dbHelper;
  }

  @Override
  public void createCustomer(CustomerOuterClass.Customer request, StreamObserver<CustomerOuterClass.CustomerResponse> responseObserver) {
    // Create a new Customer object from the gRPC request
    Customer customer = new Customer(
        request.getCustomerId(),
        request.getFirstName(),
        request.getLastName(),
        request.getUsername(),
        request.getPassword(),
        request.getEmail(),
        request.getPhonenr()
    );

    // Attempt to add the customer to the database
    boolean success = dbHelper.addCustomer(customer);

    // Prepare the response
    CustomerOuterClass.CustomerResponse.Builder responseBuilder = CustomerOuterClass.CustomerResponse.newBuilder()
        .setSuccess(success);

    if (success) {
      responseBuilder.setMessage("Customer created successfully.")
          .setCustomer(request);
    } else {
      responseBuilder.setMessage("Failed to create customer.");
    }

    // Send the response
    responseObserver.onNext(responseBuilder.build());
    responseObserver.onCompleted();
  }

  @Override
  public void listCustomers(CustomerOuterClass.empty request, StreamObserver<CustomerOuterClass.CustomerList> responseObserver) {
    // Get all customers from the database
    List<Customer> customers = dbHelper.getAllCustomers();

    // Create a builder for the CustomerList response
    CustomerOuterClass.CustomerList.Builder responseBuilder = CustomerOuterClass.CustomerList.newBuilder();

    // Iterate through the customers and add them to the response
    for (Customer customer : customers) {
      CustomerOuterClass.Customer customerResponse = CustomerOuterClass.Customer.newBuilder()
          .setCustomerId(customer.getCustomer_id())
          .setFirstName(customer.getFirst_name())
          .setLastName(customer.getLast_name())
          .setUsername(customer.getUsername())
          .setPassword(customer.getPassword()) // Consider removing this for security reasons
          .setEmail(customer.getEmail())
          .setPhonenr(customer.getPhonenr())
          .build();

      responseBuilder.addCustomers(customerResponse);
    }

    // Send the response back to the client
    responseObserver.onNext(responseBuilder.build());
    responseObserver.onCompleted();
  }
  }