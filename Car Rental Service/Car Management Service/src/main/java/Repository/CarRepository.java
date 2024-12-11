package Repository;

import Model.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class CarRepository implements ICarRepository {
    private final EntityManagerFactory entityManagerFactory;

    public CarRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<Car> getAllCars() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String jpql = "SELECT c FROM Car c";
            TypedQuery<Car> query = entityManager.createQuery(jpql, Car.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Optional<Car> getCarById(int carId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Car car = entityManager.find(Car.class, carId);
            return car != null ? Optional.of(car) : Optional.empty();
        } finally {
            entityManager.close();
        }
    }
    @Override
    public List<Car> getCarByAltName(String altName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String jpql = "SELECT c FROM Car c WHERE c.altName LIKE :altName";
            return entityManager.createQuery(jpql, Car.class)
                .setParameter("altName", "%" + altName + "%")
                .getResultList();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Car addCar(Car car) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(car);
            transaction.commit();
            return car;
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("Error adding car", e);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Car updateCar(Car car) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Car updatedCar = entityManager.merge(car);
            transaction.commit();
            return updatedCar;
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("Error updating car", e);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean deleteCar(int carId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
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
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Car> getAvailableCarsByLocation(int locationId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String jpql = "SELECT c FROM Car c WHERE c.locationHubRef = :locationId";
            TypedQuery<Car> query = entityManager.createQuery(jpql, Car.class);
            query.setParameter("locationId", locationId);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    @Override public List<Car> getCarByModel(String model)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String jpql = "SELECT c FROM Car c WHERE c.model LIKE :model";
            return entityManager.createQuery(jpql, Car.class)
                .setParameter("model", "%" + model + "%")
                .getResultList();
        } finally {
            entityManager.close();
        }
    }
}
