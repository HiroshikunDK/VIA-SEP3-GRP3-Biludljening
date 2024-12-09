package Repository;

import Model.User;

import java.util.Optional;

public interface IUpdateUserRepository {
    Optional<User> updateUser(User user);
}
