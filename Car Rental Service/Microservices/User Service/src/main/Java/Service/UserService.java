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
        Optional<User> userOptional = userRepository.getUserByUsername(request.getUsername());

        LoginResponse response;
        if (userOptional.isPresent() && userOptional.get().getPassword().equals(request.getPassword())) {
            response = LoginResponse.newBuilder()
                    .setToken("dummy-token-for-" + request.getUsername())
                    .build();
        } else {
            response = LoginResponse.newBuilder().setToken("").build();
        }

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getUserById(UserRequest request, StreamObserver<UserResponse> responseObserver) {
        Optional<User> userOptional = userRepository.getUserById(request.getId());

        UserResponse response = userOptional.map(user -> UserResponse.newBuilder()
                        .setSuccess(true)
                        .setMessage("User found")
                        .setUser(convertToProtoUser(user))
                        .build())
                .orElse(UserResponse.newBuilder()
                        .setSuccess(false)
                        .setMessage("User not found")
                        .build());

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void updateUser(UserOuterClass.User request, StreamObserver<UserResponse> responseObserver) {
        User updatedUser = new User(request.getId(), request.getUsername(), request.getEmail(), request.getRole(), request.getPassword());
        userRepository.updateUser(updatedUser);

        UserResponse response = UserResponse.newBuilder()
                .setSuccess(true)
                .setMessage("User updated successfully")
                .setUser(convertToProtoUser(updatedUser))
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteUser(UserRequest request, StreamObserver<UserResponse> responseObserver) {
        boolean success = userRepository.deleteUser(request.getId());

        UserResponse response = UserResponse.newBuilder()
                .setSuccess(success)
                .setMessage(success ? "User deleted successfully" : "User not found")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
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
