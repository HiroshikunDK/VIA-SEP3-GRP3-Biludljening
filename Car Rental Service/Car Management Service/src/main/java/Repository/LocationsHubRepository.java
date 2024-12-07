package Repository;

import Model.LocationHub;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class LocationsHubRepository implements ILocationHubRepository {

  private final EntityManagerFactory entityManagerFactory;

  public LocationsHubRepository(EntityManagerFactory entityManagerFactory) {
    this.entityManagerFactory = entityManagerFactory;
  }

  private EntityManager getEntityManager() {
    return entityManagerFactory.createEntityManager();
  }

  @Override
  public List<LocationHub> getAllLocationHubs() {
    EntityManager entityManager = getEntityManager();
    try {
      String jpql = "SELECT l FROM LocationHub l";
      TypedQuery<LocationHub> query = entityManager.createQuery(jpql, LocationHub.class);
      return query.getResultList();
    } finally {
      entityManager.close();
    }
  }

  @Override
  public Optional<LocationHub> getLocationHubById(int locationHubId) {
    EntityManager entityManager = getEntityManager();
    try {
      LocationHub locationHub = entityManager.find(LocationHub.class, locationHubId);
      return locationHub != null ? Optional.of(locationHub) : Optional.empty();
    } finally {
      entityManager.close();
    }
  }

  @Override
  public LocationHub addLocationHub(LocationHub locationHub) {
    EntityManager entityManager = getEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    try {
      transaction.begin();
      entityManager.persist(locationHub);
      transaction.commit();
      return locationHub;
    } catch (Exception e) {
      if (transaction.isActive()) {
        transaction.rollback();
      }
      throw new RuntimeException("Error adding location hub", e);
    } finally {
      entityManager.close();
    }
  }

  @Override
  public LocationHub updateLocationHub(LocationHub locationHub) {
    EntityManager entityManager = getEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    try {
      transaction.begin();
      LocationHub updatedLocationHub = entityManager.merge(locationHub);
      transaction.commit();
      return updatedLocationHub;
    } catch (Exception e) {
      if (transaction.isActive()) {
        transaction.rollback();
      }
      throw new RuntimeException("Error updating location hub", e);
    } finally {
      entityManager.close();
    }
  }

  @Override
  public boolean deleteLocationHub(int locationHubId) {
    EntityManager entityManager = getEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    try {
      transaction.begin();
      LocationHub locationHub = entityManager.find(LocationHub.class, locationHubId);
      if (locationHub != null) {
        entityManager.remove(locationHub);
        transaction.commit();
        return true;
      }
      transaction.rollback();
      return false;
    } catch (Exception e) {
      if (transaction.isActive()) {
        transaction.rollback();
      }
      throw new RuntimeException("Error deleting location hub", e);
    } finally {
      entityManager.close();
    }
  }
}
