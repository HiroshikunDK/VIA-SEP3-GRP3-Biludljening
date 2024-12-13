package Service;

import Model.User;
import Repository.IRetrieveUserRepository;
import Shared.PasswordHelper;
import Shared.TokenHelper;
import UserService.grpc.UserOuterClass.LoginResponse;
import java.util.Optional;

public class AuthenticationService {
    private final IRetrieveUserRepository retrieveUserRepository;
    private final PasswordHelper passwordHelper;
    private final TokenHelper tokenHelper;

    public AuthenticationService(IRetrieveUserRepository retrieveUserRepository, PasswordHelper passwordHelper, TokenHelper tokenHelper) {
        this.retrieveUserRepository = retrieveUserRepository;
        this.passwordHelper = passwordHelper;
        this.tokenHelper = tokenHelper;
    }

    public LoginResponse login(String username, String password) {
        Optional<User> userOptional = retrieveUserRepository.getUserByUsername(username);

        if (userOptional.isPresent() && passwordHelper.checkPassword(password, userOptional.get().getPassword())) {
            User user = userOptional.get();
            String token = tokenHelper.generateToken(user.getUsername(), user.getRole(), user.getId());

            return LoginResponse.newBuilder()
                    .setToken(token)
                    .setRole(user.getRole())
                    .build();
        }

        return LoginResponse.newBuilder().setToken("").setRole("").build();
    }
}
