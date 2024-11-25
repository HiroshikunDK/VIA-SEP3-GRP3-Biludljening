package Persistence;

import Model.RideShareRequest;
import java.sql.SQLException;
import java.util.Collection;

public interface RideShareRequestDAOInterface {
    RideShareRequest create(RideShareRequest request) throws SQLException;
    RideShareRequest create(String rideId, String status, String startDate, String startTime, String startLocation, String endDate, String endTime, String endLocation, float price, String customerId, String bookingRef) throws SQLException;
    Collection<RideShareRequest> readAll() throws SQLException;
    void update(RideShareRequest request) throws SQLException;
    void delete(String registrationNumber) throws SQLException;
    RideShareRequest read(String registrationNumber) throws SQLException;

    Collection<RideShareRequest> ReadAllByCustomerId(String customerId) throws SQLException;
    Collection<RideShareRequest> ReadAllByRideShareRequest(String carBookingRef) throws SQLException;
}
