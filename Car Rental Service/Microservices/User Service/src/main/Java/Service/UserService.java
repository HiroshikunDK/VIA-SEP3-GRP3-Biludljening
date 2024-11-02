

package Service;

import Model.User;
import databasehelper.Databasehelper;
import io.grpc.stub.StreamObserver;
import userservice.UserOuterClass;
import userservice.UserServiceGrpc;

import java.util.List;

public class UserService extends UserServiceGrpc.UserServiceImplBase
{
  private final Databasehelper dbHelper;

  public UserService(Databasehelper dbHelper) {
    this.dbHelper = dbHelper;
  }

  @Override
  public void registerUser(UserOuterClass.User request, StreamObserver<UserOuterClass.UserResponse> responseObserver) {
    // Create a User object from the gRPC request
    User newUser = new User(
       request.getId(),
        request.getUserFirstname(),
        request.getUserLastname(),
        request.getTitle(),
        request.getEmail(),
        request.getPhonenr(),
        request.getUsername(),
        request.getPassword(),
        request.getUserpermission()
    );

    // Attempt to add the user to the database
    boolean success = dbHelper.addUser(newUser);

    // Prepare the response
    UserOuterClass.UserResponse.Builder responseBuilder = UserOuterClass.UserResponse.newBuilder()
        .setSuccess(success);

    if (success) {
      responseBuilder.setMessage("User registered successfully.")
          .setUser(request);
    } else {
      responseBuilder.setMessage("Failed to register user.");
    }

    // Send the response
    responseObserver.onNext(responseBuilder.build());
    responseObserver.onCompleted();
  }



  @Override
  public void getUserById(UserOuterClass.UserRequest request, StreamObserver<UserOuterClass.UserResponse> responseObserver) {
    // Fetch user by ID
    User user = dbHelper.getUserById(request.getId());

    UserOuterClass.UserResponse.Builder responseBuilder = UserOuterClass.UserResponse.newBuilder()
        .setSuccess(user != null);

    if (user != null) {
      responseBuilder.setMessage("User found.").getUser().getUserFirstname();
    } else {
      responseBuilder.setMessage("User not found.");
    }

    responseObserver.onNext(responseBuilder.build());
    responseObserver.onCompleted();
  }

  @Override public void updateUser(User request, StreamObserver<UserOuterClass.UserResponse> responseObserver) {
    // Update user information
    boolean success = dbHelper.updateUser(request);

    UserOuterClass.UserResponse.Builder responseBuilder = UserOuterClass.UserResponse.newBuilder()
        .setSuccess(success);

    if (success) {
      responseBuilder.setMessage("User updated successfully.");
    } else {
      responseBuilder.setMessage("Failed to update user.");
    }

    responseObserver.onNext(responseBuilder.build());
    responseObserver.onCompleted();
  }

  @Override
  public void deleteUser(UserOuterClass.UserRequest request, StreamObserver<UserOuterClass.UserResponse> responseObserver) {
    // Delete user by ID
    boolean success = dbHelper.deleteUser(request.getId());

    UserOuterClass.UserResponse.Builder responseBuilder = UserOuterClass.UserResponse.newBuilder()
        .setSuccess(success);

    if (success) {
      responseBuilder.setMessage("User deleted successfully.");
    } else {
      responseBuilder.setMessage("Failed to delete user.");
    }

    responseObserver.onNext(responseBuilder.build());
    responseObserver.onCompleted();
  }

  @Override
  public void listUsers(UserOuterClass.empty request, StreamObserver<UserOuterClass.UserList> responseObserver) {
    // Get all users from the database
    List<User> users = dbHelper.getAllUsers();

    // Use the generated UserList builder
    UserOuterClass.UserList.Builder responseBuilder = UserOuterClass.UserList.newBuilder();

    // Iterate through the users and add them to the response
    for (User user : users) {
      // Create a new User object using the generated protobuf class
      UserOuterClass.User userResponse = UserOuterClass.User.newBuilder()
          .setId(user.getId())
          .setUserFirstname(user.getUserFirstname())
          .setUserLastname(user.getUserLastname())
          .setTitle(user.getTitle())
          .setEmail(user.getEmail())
          .setPhonenr(user.getPhonenr())
          .setUsername(user.getUsername())
          .setPassword(user.getPassword()) // Consider removing this for security reasons
          .setUserpermission(user.getUserpermission())
          .build();

      // Add the user to the response builder
      responseBuilder.addUsers(userResponse);
    }

    // Send the response back to the client
    responseObserver.onNext(responseBuilder.build());
    responseObserver.onCompleted();
  }
}


