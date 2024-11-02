package Repository;

import Model.User;
import Persistence.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class UserRepository implements IUserRepository {
    private final Session session;

    public UserRepository() {
        this.session = HibernateUtility.getSessionFactory().openSession();
    }

    @Override
    public User addUser(User user) {
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(user);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("Error adding user", e);
        }
        return user;
    }

    @Override
    public Optional<User> getUserById(int id) {
        User user = session.get(User.class, id);
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        String hql = "FROM User u WHERE u.username = :username";
        User user = session.createQuery(hql, User.class)
                .setParameter("username", username)
                .uniqueResult();
        return Optional.ofNullable(user);
    }

    @Override
    public User updateUser(User user) {
        Transaction transaction = session.beginTransaction();
        try {
            session.merge(user);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("Error updating user", e);
        }
        return user;
    }

    @Override
    public boolean deleteUser(int id) {
        Transaction transaction = session.beginTransaction();
        try {
            User user = session.get(User.class, id);
            if (user != null) {
                session.remove(user);
                transaction.commit();
                return true;
            }
            transaction.rollback();
            return false;
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("Error deleting user", e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return session.createQuery("FROM User", User.class).list();
    }
}
