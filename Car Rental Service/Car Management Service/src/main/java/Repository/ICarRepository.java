package Repository;

import Model.Car;

import java.util.List;
import java.util.Optional;

public interface ICarRepository {
    List<Car> getAllCars();
    List<Car> getCarByAltName(String altName);
    Optional<Car> getCarById(int carId);
    Car addCar(Car car);
    Car updateCar(Car car);
    boolean deleteCar(int carId);
    List<Car> getAvailableCarsByLocation(int locationId);
    List<Car> getCarByModel(String model);
}
