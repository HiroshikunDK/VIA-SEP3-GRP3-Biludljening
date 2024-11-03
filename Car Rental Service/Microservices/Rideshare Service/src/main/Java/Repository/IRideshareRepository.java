package Repository;

import Model.Rideshare;

import java.util.List;
import java.util.Optional;

public interface IRideshareRepository {
    Rideshare createRideshare(Rideshare rideshare);
    Optional<Rideshare> getRideshareById(int rideId);
    List<Rideshare> listRideshares(int carId);
    void addPassenger(int rideId, String passengerUsername);
}
