package Service;

import UserService.grpc.UserOuterClass;
import UserService.grpc.UserServiceGrpc;
import UserService.grpc.UserOuterClass.UserRequest;
import UserService.grpc.UserOuterClass.UserResponse;
import UserService.grpc.UserOuterClass.LoginRequest;
import UserService.grpc.UserOuterClass.LoginResponse;
import UserService.grpc.UserOuterClass.UserList;
import UserService.grpc.UserOuterClass.Empty;
import Repository.IUserRepository;
import Model.User;
import io.grpc.stub.StreamObserver;

import java.util.Optional;
import java.util.stream.Collectors;

public class UserService extends UserServiceGrpc.UserServiceImplBase {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(UserOuterClass.User request, StreamObserver<UserResponse> responseObserver) {
        // Convert from proto User to model User
        User newUser = new User(0, request.getUsername(), request.getEmail(), request.getRole(), request.getPassword());
        userRepository.addUser(newUser);

        // Convert model User back to proto User
        UserResponse response = UserResponse.newBuilder()
                .setSuccess(true)
                .setMessage("User registered successfully")
                .setUser(convertToProtoUser(newUser))
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void loginUser(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
      
    }

    @Override
    public void getUserById(UserRequest request, StreamObserver<UserResponse> responseObserver) {
       
    }

    @Override
    public void updateUser(UserOuterClass.User request, StreamObserver<UserResponse> responseObserver) {
      
    }

    @Override
    public void deleteUser(UserRequest request, StreamObserver<UserResponse> responseObserver) {
       
    }

    @Override
    public void listUsers(Empty request, StreamObserver<UserList> responseObserver) {
        UserList userList = UserList.newBuilder()
                .addAllUsers(userRepository.getAllUsers().stream()
                        .map(this::convertToProtoUser)
                        .collect(Collectors.toList()))
                .build();

        responseObserver.onNext(userList);
        responseObserver.onCompleted();
    }

    private UserOuterClass.User convertToProtoUser(User user) {
        return UserOuterClass.User.newBuilder()
                .setId(user.getId())
                .setUsername(user.getUsername())
                .setEmail(user.getEmail())
                .setRole(user.getRole())
                .setPassword(user.getPassword())
                .build();
    }
}
