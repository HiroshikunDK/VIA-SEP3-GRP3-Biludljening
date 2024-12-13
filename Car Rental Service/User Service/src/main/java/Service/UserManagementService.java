package Service;

import Model.User;
import Repository.IAddUserRepository;
import Repository.IDeleteUserRepository;
import Repository.IRetrieveUserRepository;
import Repository.IUpdateUserRepository;
import Shared.PasswordHelper;
import UserService.grpc.UserOuterClass;
import UserService.grpc.UserOuterClass.UserResponse;
import java.util.Optional;

public class UserManagementService {
    private final IAddUserRepository addUserRepository;
    private final IRetrieveUserRepository retrieveUserRepository;
    private final IDeleteUserRepository deleteUserRepository;
    private final IUpdateUserRepository updateUserRepository;

    public UserManagementService(IAddUserRepository addUserRepository,
                                 IRetrieveUserRepository retrieveUserRepository,
                                 IDeleteUserRepository deleteUserRepository,
                                 IUpdateUserRepository updateUserRepository) {
        this.addUserRepository = addUserRepository;
        this.retrieveUserRepository = retrieveUserRepository;
        this.deleteUserRepository = deleteUserRepository;
        this.updateUserRepository = updateUserRepository;
    }

    public UserResponse registerUser(String username, String email, String password, int phonenr, String title, String userFirstname, String userLastname) {
        if (retrieveUserRepository.getUserByUsername(username).isPresent()) {
            return UserResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Username already exists.")
                    .build();
        }

        User newUser = new User(username, email, PasswordHelper.hashPassword(password), phonenr, title, userFirstname, userLastname, "Customer");
        addUserRepository.addUser(newUser);

        return UserResponse.newBuilder()
                .setSuccess(true)
                .setMessage("User registered successfully.")
                .build();
    }

    public UserResponse getUserById(int userId) {
        Optional<User> userOptional = retrieveUserRepository.getUserById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // Map the domain User object to the gRPC User message
            UserOuterClass.User grpcUser = UserOuterClass.User.newBuilder()
                    .setId(user.getId())
                    .setUsername(user.getUsername())
                    .setEmail(user.getEmail())
                    .setPhonenr(user.getPhonenr())
                    .setTitle(user.getTitle())
                    .setUserFirstname(user.getUserFirstname())
                    .setUserLastname(user.getUserLastname())
                    .setRole(user.getRole())
                    .build();

            return UserResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("User found.")
                    .setUser(grpcUser) // Include the User in the response
                    .build();
        }

        return UserResponse.newBuilder()
                .setSuccess(false)
                .setMessage("User not found.")
                .build();
    }


    public UserResponse deleteUser(int userId) {
        boolean success = deleteUserRepository.deleteUserById(userId);
        return UserResponse.newBuilder()
                .setSuccess(success)
                .setMessage(success ? "User deleted successfully." : "User not found.")
                .build();
    }

    public UserResponse updateUser(int userId, String username, String email, int phonenr, String title, String userFirstname, String userLastname) {
        Optional<User> userOptional = retrieveUserRepository.getUserById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setUsername(username);
            user.setEmail(email);
            user.setPhonenr(phonenr);
            user.setTitle(title);
            user.setUserFirstname(userFirstname);
            user.setUserLastname(userLastname);

            updateUserRepository.updateUser(user);

            return UserResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("User updated successfully.")
                    .build();
        }

        return UserResponse.newBuilder()
                .setSuccess(false)
                .setMessage("User not found.")
                .build();
    }
}
