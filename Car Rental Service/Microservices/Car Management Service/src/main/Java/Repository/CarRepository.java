package Repository;

import Model.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class CarRepository implements ICarRepository {
    private final EntityManager entityManager;

    public CarRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Car> getAllCars() {
        String jpql = "SELECT c FROM Car c";
        TypedQuery<Car> query = entityManager.createQuery(jpql, Car.class);
        return query.getResultList();
    }

    @Override
    public Optional<Car> getCarById(int carId) {
        Car car = entityManager.find(Car.class, carId);
        return car != null ? Optional.of(car) : Optional.empty();
    }

    @Override
    public Car addCar(Car car) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(car);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("Error adding car", e);
        }
        return car;
    }

    @Override
    public Car updateCar(Car car) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Car updatedCar = entityManager.merge(car);
            transaction.commit();
            return updatedCar;
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("Error updating car", e);
        }
    }

    @Override
    public boolean deleteCar(int carId) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Car car = entityManager.find(Car.class, carId);
            if (car != null) {
                entityManager.remove(car);
                transaction.commit();
                return true;
            }
            transaction.rollback();
            return false;
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("Error deleting car", e);
        }
    }
}
