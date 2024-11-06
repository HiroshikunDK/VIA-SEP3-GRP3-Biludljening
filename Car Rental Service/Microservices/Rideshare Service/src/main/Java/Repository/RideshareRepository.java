package Repository;

import Model.Rideshare;
import Persistence.DatabaseHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RideshareRepository implements IRideshareRepository {
    private final DatabaseHelper dbHelper;

    public RideshareRepository(DatabaseHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    @Override
    public Rideshare createRideshare(Rideshare rideshare) {
        String sql = "INSERT INTO rideshares (car_id, driver_username, available_seats) VALUES (?, ?, ?)";

        try (Connection conn = dbHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, rideshare.getCarId());
            pstmt.setString(2, rideshare.getDriverUsername());
            pstmt.setInt(3, rideshare.getAvailableSeats());
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    rideshare.setRideId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error creating Rideshare", e);
        }
        return rideshare;
    }

    @Override
    public Optional<Rideshare> getRideshareById(int rideId) {
        String sql = "SELECT * FROM rideshares WHERE ride_id = ?";

        try (Connection conn = dbHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, rideId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Rideshare rideshare = new Rideshare(
                            rs.getInt("ride_id"),
                            rs.getInt("car_id"),
                            rs.getString("driver_username"),
                            rs.getInt("available_seats"));
                    return Optional.of(rideshare);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving Rideshare by ID", e);
        }
        return Optional.empty();
    }

    @Override
    public List<Rideshare> listRideshares(int carId) {
        List<Rideshare> rideshares = new ArrayList<>();
        String sql = "SELECT * FROM rideshares WHERE car_id = ?";

        try (Connection conn = dbHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, carId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Rideshare rideshare = new Rideshare(
                            rs.getInt("ride_id"),
                            rs.getInt("car_id"),
                            rs.getString("driver_username"),
                            rs.getInt("available_seats"));
                    rideshares.add(rideshare);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error listing Rideshares", e);
        }
        return rideshares;
    }

    @Override
    public void addPassenger(int rideId, String passengerUsername) {
        String sql = "INSERT INTO passengers (ride_id, passenger_username) VALUES (?, ?)";

        try (Connection conn = dbHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, rideId);
            pstmt.setString(2, passengerUsername);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error adding passenger to Rideshare", e);
        }
    }
}
