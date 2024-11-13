package Repository;

import Model.BookingCar;

import java.util.List;
import java.util.Optional;

public interface IBookingCarRepository {
  List<BookingCar> getAllBookingCars();
  Optional<BookingCar> getBookingCarById(int bookingCarId);
  BookingCar addBookingCar(BookingCar bookingCar);
  BookingCar updateBookingCar(BookingCar bookingCar);
  boolean deleteBookingCar(int bookingCarId);
}
