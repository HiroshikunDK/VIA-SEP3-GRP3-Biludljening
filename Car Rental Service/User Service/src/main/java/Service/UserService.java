package Service;

import Model.User;
import Shared.PasswordHelper;
import Shared.TokenHelper;
import Repository.IUserRepository;
import UserService.grpc.UserOuterClass;
import UserService.grpc.UserOuterClass.*;
import UserService.grpc.UserServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.Optional;

public class UserService extends UserServiceGrpc.UserServiceImplBase {
  private final IUserRepository userRepository;

  public UserService(IUserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void registerUser(RegisterUserRequest request, StreamObserver<UserResponse> responseObserver) {
    String hashedPassword = PasswordHelper.hashPassword(request.getPassword());

    if (userRepository.getUserByUsername(request.getUsername()).isPresent()) {
      UserResponse response = UserResponse.newBuilder()
              .setSuccess(false)
              .setMessage("Username already exists.")
              .build();
      responseObserver.onNext(response);
      responseObserver.onCompleted();
      return;
    }

    User newUser = new User(
            request.getUsername(),
            request.getEmail(),
            hashedPassword,
            request.getPhonenr(),
            request.getTitle(),
            request.getUserFirstname(),
            request.getUserLastname(),
            "Customer" // Default role
    );

    userRepository.addUser(newUser);

    UserResponse response = UserResponse.newBuilder()
            .setSuccess(true)
            .setMessage("User registered successfully.")
            .setUser(convertToProtoUser(newUser))
            .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void loginUser(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
    Optional<User> userOptional = userRepository.getUserByUsername(request.getUsername());

    if (userOptional.isPresent() && PasswordHelper.checkPassword(request.getPassword(), userOptional.get().getPassword())) {
      User user = userOptional.get();

      String token = TokenHelper.generateToken(user.getUsername(), user.getRole(), user.getId());

      LoginResponse response = LoginResponse.newBuilder()
              .setToken(token)
              .setRole(user.getRole())
              .build();
      responseObserver.onNext(response);
    } else {
      LoginResponse response = LoginResponse.newBuilder()
              .setToken("")
              .build();
      responseObserver.onNext(response);
    }

    responseObserver.onCompleted();
  }

  @Override
  public void getUserById(UserRequest request, StreamObserver<UserResponse> responseObserver) {
    Optional<User> userOptional = userRepository.getUserById(request.getId());

    UserResponse response = userOptional.map(user -> UserResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("User found.")
                    .setUser(convertToProtoUser(user)) // Konverter bruger til protoformat
                    .build())
            .orElse(UserResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("User not found.")
                    .build());

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }



  private UserOuterClass.User convertToProtoUser(User user) {
    return UserOuterClass.User.newBuilder()
            .setId(user.getId())
            .setUsername(user.getUsername())
            .setEmail(user.getEmail())
            .setRole(user.getRole())
            .setUserFirstname(user.getUserFirstname())
            .setUserLastname(user.getUserLastname())
            .setTitle(user.getTitle())
            .setPhonenr(user.getPhonenr())
            .build();
  }
  @Override
  public void deleteUser(UserRequest request, StreamObserver<UserResponse> responseObserver) {
    try {
      boolean success = userRepository.deleteUserById(request.getId());
      UserResponse response = UserResponse.newBuilder()
          .setSuccess(success)
          .setMessage(success ? "User deleted successfully." : "User not found.")
          .build();

      responseObserver.onNext(response);
    } catch (Exception e) {
      UserResponse response = UserResponse.newBuilder()
          .setSuccess(false)
          .setMessage("An error occurred: " + e.getMessage())
          .build();
      responseObserver.onNext(response);
    } finally {
      responseObserver.onCompleted();
    }
  }

  @Override public void updateUser(UserOuterClass.User request,
      StreamObserver<UserResponse> responseObserver)
  {
    try {
      // Find den eksisterende bruger baseret på ID
      Optional<User> existingUserOptional = userRepository.getUserByUsername(request.getUsername());

      if (existingUserOptional.isPresent()) {
        User existingUser = existingUserOptional.get();

        // Opdater de nødvendige felter
        existingUser.setUsername(request.getUsername());
        existingUser.setEmail(request.getEmail());
        existingUser.setUserFirstname(request.getUserFirstname());
        existingUser.setUserLastname(request.getUserLastname());
        existingUser.setTitle(request.getTitle());
        existingUser.setPhonenr(request.getPhonenr());

        // Gem ændringerne
        Optional<User> updatedUser = userRepository.updateUser(existingUser);

        UserResponse response = UserResponse.newBuilder()
            .setSuccess(true)
            .setMessage("User updated successfully.")
            .setUser(convertToProtoUser(updatedUser.get())) // Konverter til ProtoUser
            .build();
        responseObserver.onNext(response);
      } else {
        // Hvis brugeren ikke findes
        UserResponse response = UserResponse.newBuilder()
            .setSuccess(false)
            .setMessage("User not found.")
            .build();
        responseObserver.onNext(response);
      }
    } catch (Exception e) {
      // Håndter fejl
      UserResponse response = UserResponse.newBuilder()
          .setSuccess(false)
          .setMessage("An error occurred: " + e.getMessage())
          .build();
      responseObserver.onNext(response);
    } finally {
      responseObserver.onCompleted();
    }
  }





}
