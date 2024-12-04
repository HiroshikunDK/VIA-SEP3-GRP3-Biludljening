package Repository;

import Model.Car;

import java.util.List;
import java.util.Optional;

public interface ICarRepository {
    List<Car> getAllCars();
    Optional<Car> getCarById(int carId);
    Car addCar(Car car);
    Car updateCar(Car car);
    boolean deleteCar(int carId);
    List<Car> getAvailableCarsByLocation(int locationId);
}
