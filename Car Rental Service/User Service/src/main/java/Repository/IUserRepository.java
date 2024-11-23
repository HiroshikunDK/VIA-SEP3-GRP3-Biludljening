package Repository;

import Model.User;

import java.util.Optional;

public interface IUserRepository {
  User addUser(User user);

  Optional<User> getUserById(int id); // Updated method signature

  Optional<User> getUserByUsername(String username);
}
