package Repository;

import Model.User;

import java.util.Optional;

public interface IRetrieveUserRepository {
    Optional<User> getUserById(int id);
    Optional<User> getUserByUsername(String username);
}
