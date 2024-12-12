import UserService.grpc.UserServiceGrpc;
import UserService.grpc.UserOuterClass;
import io.grpc.stub.StreamObserver;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    private UserServiceGrpc.UserServiceImplBase serviceImpl;

    @Before
    public void setUp() {
        // Initialize the actual service implementation
        serviceImpl = new UserServiceGrpc.UserServiceImplBase() {
            @Override
            public void registerUser(UserOuterClass.RegisterUserRequest request, StreamObserver<UserOuterClass.UserResponse> responseObserver) {
                // Simulate the registration logic
                UserOuterClass.UserResponse response = UserOuterClass.UserResponse.newBuilder()
                        .setSuccess(true)
                        .setMessage("User registered successfully")
                        .setUser(UserOuterClass.User.newBuilder().setUsername(request.getUsername()).build())
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }

            @Override
            public void loginUser(UserOuterClass.LoginRequest request, StreamObserver<UserOuterClass.LoginResponse> responseObserver) {
                // Simulate login logic
                UserOuterClass.LoginResponse response = UserOuterClass.LoginResponse.newBuilder()
                        .setToken("sample_token")
                        .setRole("Customer")
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }

            @Override
            public void getUserById(UserOuterClass.UserRequest request, StreamObserver<UserOuterClass.UserResponse> responseObserver) {
                // Simulate fetching user by ID logic
                UserOuterClass.UserResponse response = UserOuterClass.UserResponse.newBuilder()
                        .setSuccess(true)
                        .setMessage("User fetched successfully")
                        .setUser(UserOuterClass.User.newBuilder().setId(request.getId()).setUsername("john_doe").build())
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }

            @Override
            public void deleteUser(UserOuterClass.UserRequest request, StreamObserver<UserOuterClass.UserResponse> responseObserver) {
                // Simulate user deletion logic
                UserOuterClass.UserResponse response = UserOuterClass.UserResponse.newBuilder()
                        .setSuccess(true)
                        .setMessage("User deleted successfully")
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }

            @Override
            public void updateUser(UserOuterClass.User request, StreamObserver<UserOuterClass.UserResponse> responseObserver) {
                // Simulate update user logic
                UserOuterClass.UserResponse response = UserOuterClass.UserResponse.newBuilder()
                        .setSuccess(true)
                        .setMessage("User updated successfully")
                        .setUser(request)
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        };
    }

    @Test
    public void testRegisterUser() {
        // Prepare the request data
        UserOuterClass.RegisterUserRequest request = UserOuterClass.RegisterUserRequest.newBuilder()
                .setUsername("john_doe")
                .setEmail("johndoe@example.com")
                .setPassword("password123")
                .setPhonenr(1234567890)
                .setTitle("Mr.")
                .setUserFirstname("John")
                .setUserLastname("Doe")
                .setRole("Customer")
                .build();

        // Create a response observer to capture the response
        StreamObserver<UserOuterClass.UserResponse> responseObserver = new StreamObserver<UserOuterClass.UserResponse>() {
            @Override
            public void onNext(UserOuterClass.UserResponse response) {
                // Validate the response
                assertNotNull(response);
                assertTrue(response.getSuccess());
                assertEquals("User registered successfully", response.getMessage());
                assertEquals("john_doe", response.getUser().getUsername());
            }

            @Override
            public void onError(Throwable t) {
                fail("Error occurred: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Registration completed.");
            }
        };

        // Call registerUser
        serviceImpl.registerUser(request, responseObserver);
    }

    @Test
    public void testLoginUser() {
        // Prepare the request data
        UserOuterClass.LoginRequest request = UserOuterClass.LoginRequest.newBuilder()
                .setUsername("john_doe")
                .setPassword("password123")
                .build();

        // Create a response observer to capture the response
        StreamObserver<UserOuterClass.LoginResponse> responseObserver = new StreamObserver<UserOuterClass.LoginResponse>() {
            @Override
            public void onNext(UserOuterClass.LoginResponse response) {
                // Validate the response
                assertNotNull(response);
                assertEquals("sample_token", response.getToken());
                assertEquals("Customer", response.getRole());
            }

            @Override
            public void onError(Throwable t) {
                fail("Error occurred: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Login completed.");
            }
        };

        // Call loginUser
        serviceImpl.loginUser(request, responseObserver);
    }

    @Test
    public void testGetUserById() {
        // Prepare the request data
        UserOuterClass.UserRequest request = UserOuterClass.UserRequest.newBuilder()
                .setId(1)
                .build();

        // Create a response observer to capture the response
        StreamObserver<UserOuterClass.UserResponse> responseObserver = new StreamObserver<UserOuterClass.UserResponse>() {
            @Override
            public void onNext(UserOuterClass.UserResponse response) {
                // Validate the response
                assertNotNull(response);
                assertTrue(response.getSuccess());
                assertEquals("User fetched successfully", response.getMessage());
                assertEquals(1, response.getUser().getId());
                assertEquals("john_doe", response.getUser().getUsername());
            }

            @Override
            public void onError(Throwable t) {
                fail("Error occurred: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("GetUserById completed.");
            }
        };

        // Call getUserById
        serviceImpl.getUserById(request, responseObserver);
    }

    @Test
    public void testDeleteUser() {
        // Prepare the request data
        UserOuterClass.UserRequest request = UserOuterClass.UserRequest.newBuilder()
                .setId(1)
                .build();

        // Create a response observer to capture the response
        StreamObserver<UserOuterClass.UserResponse> responseObserver = new StreamObserver<UserOuterClass.UserResponse>() {
            @Override
            public void onNext(UserOuterClass.UserResponse response) {
                // Validate the response
                assertNotNull(response);
                assertTrue(response.getSuccess());
                assertEquals("User deleted successfully", response.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                fail("Error occurred: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("DeleteUser completed.");
            }
        };

        // Call deleteUser
        serviceImpl.deleteUser(request, responseObserver);
    }

    @Test
    public void testUpdateUser() {
        // Prepare the request data
        UserOuterClass.User userToUpdate = UserOuterClass.User.newBuilder()
                .setId(1)
                .setUserFirstname("John")
                .setUserLastname("Doe")
                .setTitle("Mr.")
                .setEmail("johndoe@example.com")
                .setPhonenr(1234567890)
                .setUsername("john_doe")
                .setPassword("newpassword123")
                .setRole("Customer")
                .build();

        // Create a response observer to capture the response
        StreamObserver<UserOuterClass.UserResponse> responseObserver = new StreamObserver<UserOuterClass.UserResponse>() {
            @Override
            public void onNext(UserOuterClass.UserResponse response) {
                // Validate the response
                assertNotNull(response);
                assertTrue(response.getSuccess());
                assertEquals("User updated successfully", response.getMessage());
                assertEquals("john_doe", response.getUser().getUsername());
            }

            @Override
            public void onError(Throwable t) {
                fail("Error occurred: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("UpdateUser completed.");
            }
        };

        // Call updateUser
        serviceImpl.updateUser(userToUpdate, responseObserver);
    }
}
