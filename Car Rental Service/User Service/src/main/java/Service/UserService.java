package Service;

import Model.User;
import Repository.IAddUserRepository;
import Repository.IDeleteUserRepository;
import Repository.IRetrieveUserRepository;
import Repository.IUpdateUserRepository;
import Shared.PasswordHelper;
import Shared.TokenHelper;
import UserService.grpc.UserOuterClass;
import UserService.grpc.UserOuterClass.*;
import UserService.grpc.UserServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.Optional;

public class UserService extends UserServiceGrpc.UserServiceImplBase {
  private final AuthenticationService authenticationService;
  private final UserManagementService userManagementService;

  public UserService(AuthenticationService authenticationService, UserManagementService userManagementService) {
    this.authenticationService = authenticationService;
    this.userManagementService = userManagementService;
  }

  @Override
  public void registerUser(RegisterUserRequest request, StreamObserver<UserResponse> responseObserver) {
    try {
      UserResponse response = userManagementService.registerUser(
              request.getUsername(),
              request.getEmail(),
              request.getPassword(),
              request.getPhonenr(),
              request.getTitle(),
              request.getUserFirstname(),
              request.getUserLastname()
      );
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

  @Override
  public void loginUser(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
    try {
      LoginResponse response = authenticationService.login(request.getUsername(), request.getPassword());
      responseObserver.onNext(response);
    } catch (Exception e) {
      LoginResponse response = LoginResponse.newBuilder()
              .setToken("")
              .setRole("")
              .build();
      responseObserver.onNext(response);
    } finally {
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getUserById(UserRequest request, StreamObserver<UserResponse> responseObserver) {
    try {
      UserResponse response = userManagementService.getUserById(request.getId());
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

  @Override
  public void deleteUser(UserRequest request, StreamObserver<UserResponse> responseObserver) {
    try {
      UserResponse response = userManagementService.deleteUser(request.getId());
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

  @Override
  public void updateUser(UserOuterClass.User request, StreamObserver<UserResponse> responseObserver) {
    try {
      UserResponse response = userManagementService.updateUser(
              request.getId(),
              request.getUsername(),
              request.getEmail(),
              request.getPhonenr(),
              request.getTitle(),
              request.getUserFirstname(),
              request.getUserLastname()
      );
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
}
