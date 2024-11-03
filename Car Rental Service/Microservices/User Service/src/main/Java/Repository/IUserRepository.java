package Repository;

import Model.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    User addUser(User user);
    Optional<User> getUserById(int id);
    Optional<User> getUserByUsername(String username);
    User updateUser(User user);
    boolean deleteUser(int id);
    List<User> getAllUsers();
}
