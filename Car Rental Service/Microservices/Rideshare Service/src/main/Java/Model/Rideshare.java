package Model;

import java.util.ArrayList;
import java.util.List;

public class Rideshare {
    private int rideId;
    private int carId;
    private String driverUsername;
    private int availableSeats;
    private List<String> passengers;

    // Constructor
    public Rideshare(int rideId, int carId, String driverUsername, int availableSeats) {
        this.rideId = rideId;
        this.carId = carId;
        this.driverUsername = driverUsername;
        this.availableSeats = availableSeats;
        this.passengers = new ArrayList<>();
    }

    // Getters
    public int getRideId() {
        return rideId;
    }

    public int getCarId() {
        return carId;
    }

    public String getDriverUsername() {
        return driverUsername;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public List<String> getPassengers() {
        return new ArrayList<>(passengers);  // Return a copy to avoid external modification
    }

    // Setters
    public void setRideId(int rideId) {
        this.rideId = rideId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public void setDriverUsername(String driverUsername) {
        this.driverUsername = driverUsername;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    // Add a passenger to the ride
    public void addPassenger(String passengerUsername) {
        if (availableSeats > 0) {
            passengers.add(passengerUsername);
            availableSeats--;
        }
    }
}
