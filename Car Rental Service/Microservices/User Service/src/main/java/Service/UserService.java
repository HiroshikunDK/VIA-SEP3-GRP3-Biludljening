package Service;

import Model.User;
import Persistence.PasswordHelper;
import Persistence.TokenHelper;
import Repository.IUserRepository;
import UserService.grpc.UserOuterClass;
import UserService.grpc.UserOuterClass.*;
import UserService.grpc.UserServiceGrpc;
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
        String hashedPassword = PasswordHelper.hashPassword(request.getPassword());
        User newUser = new User(0, request.getUsername(), request.getEmail(), request.getRole(), hashedPassword);
        userRepository.addUser(newUser);

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
        if (userOptional.isPresent() &&
                PasswordHelper.checkPassword(request.getPassword(), userOptional.get().getPassword())) {

            User user = userOptional.get();

            String token = TokenHelper.generateToken(user.getUsername(), user.getRole());

            response = LoginResponse.newBuilder()
                    .setToken(token)
                    .setRole(user.getRole())
                    .build();
        } else {
            response = LoginResponse.newBuilder()
                    .setToken("")
                    .build();
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
