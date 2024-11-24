package Persistence;

import Model.RideShareRequest;
import java.sql.SQLException;
import java.util.Collection;

public interface RideShareRequestDAOInterface {
    RideShareRequest create(RideShareRequest request) throws SQLException;
    RideShareRequest create(int rideId, String status, String startDate, String startTime, String startLocation, String endDate, String endTime, String endLocation, float price, int customerId, int bookingRef) throws SQLException;
    Collection<RideShareRequest> readAll() throws SQLException;
    void update(RideShareRequest request) throws SQLException;
    void delete(int rideId) throws SQLException;
    RideShareRequest read(int rideId) throws SQLException;

    Collection<RideShareRequest> ReadAllByCustomerId(int customerId) throws SQLException;
    Collection<RideShareRequest> ReadAllByRideShareRequest(int carBookingRef) throws SQLException;
}
