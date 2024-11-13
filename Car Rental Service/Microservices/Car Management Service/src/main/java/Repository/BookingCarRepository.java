package Repository;

import Model.BookingCar;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class BookingCarRepository implements IBookingCarRepository {

  private final EntityManager entityManager;

  public BookingCarRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public List<BookingCar> getAllBookingCars() {
    String jpql = "SELECT b FROM BookingCar b";
    TypedQuery<BookingCar> query = entityManager.createQuery(jpql, BookingCar.class);
    return query.getResultList();
  }

  @Override
  public Optional<BookingCar> getBookingCarById(int bookingCarId) {
    BookingCar bookingCar = entityManager.find(BookingCar.class, bookingCarId);
    return bookingCar != null ? Optional.of(bookingCar) : Optional.empty();
  }

  @Override
  public BookingCar addBookingCar(BookingCar bookingCar) {
    EntityTransaction transaction = entityManager.getTransaction();
    try {
      transaction.begin();
      entityManager.persist(bookingCar);
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
      throw new RuntimeException("Error adding booking car", e);
    }
    return bookingCar;
  }

  @Override
  public BookingCar updateBookingCar(BookingCar bookingCar) {
    EntityTransaction transaction = entityManager.getTransaction();
    try {
      transaction.begin();
      BookingCar updatedBookingCar = entityManager.merge(bookingCar);
      transaction.commit();
      return updatedBookingCar;
    } catch (Exception e) {
      transaction.rollback();
      throw new RuntimeException("Error updating booking car", e);
    }
  }

  @Override
  public boolean deleteBookingCar(int bookingCarId) {
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
    }
  }
}
