package Repository;

import Model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.Optional;

public class UserRepository implements IUserRepository {
  private final EntityManager entityManager;

  public UserRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public User addUser(User user) {
    try {
      entityManager.getTransaction().begin();
      entityManager.persist(user); // Persist bruges her for at oprette nye poster
      entityManager.getTransaction().commit();
      return user;
    } catch (Exception e) {
      if (entityManager.getTransaction().isActive()) {
        entityManager.getTransaction().rollback();
      }
      throw new RuntimeException("Error adding user", e);
    }
  }

  @Override
  public Optional<User> getUserById(int id) {
    try {
      User user = entityManager.find(User.class, id); // Brug kun id
      return Optional.ofNullable(user);
    } catch (Exception e) {
      throw new RuntimeException("Error retrieving user by ID", e);
    }
  }


  @Override
  public Optional<User> getUserByUsername(String username) {
    try {
      // Ret HQL-forespørgslen til at bruge den nye struktur
      String jpql = "SELECT u FROM User u WHERE u.username = :username";
      TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
      query.setParameter("username", username);

      // Returner første resultat som Optional
      return query.getResultList().stream().findFirst();
    } catch (Exception e) {
      throw new RuntimeException("Error retrieving user by username", e);
    }
  }
}
