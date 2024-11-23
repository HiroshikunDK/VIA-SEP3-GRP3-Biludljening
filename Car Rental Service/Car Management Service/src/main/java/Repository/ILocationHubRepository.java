package Repository;

import Model.LocationHub;

import java.util.List;
import java.util.Optional;

public interface ILocationHubRepository
{
  List<LocationHub> getAllLocationHubs();
  Optional<LocationHub> getLocationHubById(int locationHubId);
  LocationHub addLocationHub(LocationHub locationHub);
  LocationHub updateLocationHub(LocationHub locationHub);
  boolean deleteLocationHub(int locationHubId);

}
