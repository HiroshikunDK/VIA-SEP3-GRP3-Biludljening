package Repository;

import Model.BookingCar;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class BookingCarRepository implements IBookingCarRepository {
  private final EntityManagerFactory entityManagerFactory;

  public BookingCarRepository(EntityManagerFactory entityManagerFactory) {
    this.entityManagerFactory = entityManagerFactory;
  }

  @Override
  public List<BookingCar> getAllBookingCars() {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    try {
      String jpql = "SELECT b FROM BookingCar b";
      TypedQuery<BookingCar> query = entityManager.createQuery(jpql, BookingCar.class);
      return query.getResultList();
    } finally {
      entityManager.close();
    }
  }

  @Override
  public Optional<BookingCar> getBookingCarById(int bookingCarId) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    try {
      BookingCar bookingCar = entityManager.find(BookingCar.class, bookingCarId);
      return bookingCar != null ? Optional.of(bookingCar) : Optional.empty();
    } finally {
      entityManager.close();
    }
  }

  @Override
  public BookingCar addBookingCar(BookingCar bookingCar) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    try {
      transaction.begin();
      entityManager.persist(bookingCar);
      transaction.commit();
      return bookingCar;
    } catch (Exception e) {
      transaction.rollback();
      throw new RuntimeException("Error adding booking car", e);
    } finally {
      entityManager.close();
    }
  }

  @Override
  public BookingCar updateBookingCar(BookingCar bookingCar) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    try {
      transaction.begin();
      BookingCar updatedBookingCar = entityManager.merge(bookingCar);
      transaction.commit();
      return updatedBookingCar;
    } catch (Exception e) {
      transaction.rollback();
      throw new RuntimeException("Error updating booking car", e);
    } finally {
      entityManager.close();
    }
  }

  @Override
  public boolean deleteBookingCar(int bookingCarId) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    try {
      transaction.begin();
      BookingCar bookingCar = entityManager.find(BookingCar.class, bookingCarId);
      if (bookingCar != null) {
        entityManager.remove(bookingCar);
        transaction.commit();
        return true;
      }
      transaction.rollback();
      return false;
    } catch (Exception e) {
      transaction.rollback();
      throw new RuntimeException("Error deleting booking car", e);
    } finally {
      entityManager.close();
    }
  }
}
