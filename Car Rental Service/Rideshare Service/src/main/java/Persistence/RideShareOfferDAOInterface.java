package Persistence;

import Model.RideShareOffer;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface RideShareOfferDAOInterface {
    //CRUD functions
    RideShareOffer create(RideShareOffer rideShareOffer) throws SQLException;
    RideShareOffer create(int rideId, int availableSpaces, String status, String startDate, String startTime, String startLocation, String endDate, String endTime, String endLocation, float price, int customerId, int bookingRef) throws SQLException;
    RideShareOffer read(int id) throws SQLException;
    Collection<RideShareOffer> readAll() throws SQLException;
    void update(RideShareOffer offer) throws SQLException;
    void delete(int id) throws SQLException;

    //Foreign Key Search
    Collection<RideShareOffer> ReadAllByCustomerId(int customerId) throws SQLException;
    Collection<RideShareOffer> ReadAllByCarBookingRef(int bookingRef) throws SQLException;
}
