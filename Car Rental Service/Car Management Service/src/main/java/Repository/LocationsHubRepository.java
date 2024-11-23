package Repository;

import Model.LocationHub;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class LocationsHubRepository implements ILocationHubRepository
{

  public final EntityManager entityManager;

  public LocationsHubRepository(EntityManager entityManager)
  {
    this.entityManager = entityManager;
  }

  @Override public List<LocationHub> getAllLocationHubs()
  {
    String jpql = "SELECT l FROM LocationHub l";
    TypedQuery<LocationHub> query = entityManager.createQuery(jpql, LocationHub.class);
    return query.getResultList();
  }

  @Override public Optional<LocationHub> getLocationHubById(int locationHubId)
  {
    LocationHub locationHub = entityManager.find(LocationHub.class, locationHubId);
    return locationHub != null ? Optional.of(locationHub) : Optional.empty();
  }

  @Override public LocationHub addLocationHub(LocationHub locationHub)
  {
    EntityTransaction transaction = entityManager.getTransaction();
    try
    {
      transaction.begin();
      entityManager.persist(locationHub);
      transaction.commit();
    } catch (Exception e)
    {
      transaction.rollback();
      throw new RuntimeException("Error adding location hub", e);
    }
    return locationHub;
  }

  @Override public LocationHub updateLocationHub(LocationHub locationHub)
  {
    EntityTransaction transaction = entityManager.getTransaction();
    try
    {
      transaction.begin();
      LocationHub updatedLocationHub = entityManager.merge(locationHub);
      transaction.commit();
      return updatedLocationHub;
    } catch (Exception e)
    {
      transaction.rollback();
      throw new RuntimeException("Error updating location hub", e);
    }
  }

  @Override public boolean deleteLocationHub(int locationHubId)
  {
    EntityTransaction transaction = entityManager.getTransaction();
    try
    {
      transaction.begin();
      LocationHub locationHub = entityManager.find(LocationHub.class, locationHubId);
      if (locationHub != null)
      {
        entityManager.remove(locationHub);
        transaction.commit();
        return true;
      }
      transaction.rollback();
      return false;
    } catch (Exception e)
    {
      transaction.rollback();
      throw new RuntimeException("Error deleting location hub", e);
    }
  }
}
