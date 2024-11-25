package Persistence;

import Model.RideShareOffer;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface RideShareOfferDAOInterface {
    //CRUD functions
    RideShareOffer create(RideShareOffer id) throws SQLException;
    RideShareOffer create(String rideId, int availableSpaces, String status, String startDate, String startTime, String startLocation, String endDate, String endTime, String endLocation, float price, String customerId, String bookingRef) throws SQLException;
    RideShareOffer read(String id) throws SQLException;
    Collection<RideShareOffer> readAll() throws SQLException;
    void update(RideShareOffer id) throws SQLException;
    void delete(String id) throws SQLException;

    //Foreign Key Search
    Collection<RideShareOffer> ReadAllByCustomerId(String registrationNumber) throws SQLException;
    Collection<RideShareOffer> ReadAllByCarBookingRef(String registrationNumber) throws SQLException;
}
