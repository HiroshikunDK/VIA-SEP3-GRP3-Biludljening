package Model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rideshares")
public class Rideshare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rideId;

    private int carId;
    private String driverUsername;
    private int availableSeats;

    @ElementCollection
    @CollectionTable(name = "passengers", joinColumns = @JoinColumn(name = "ride_id"))
    @Column(name = "passenger_username")
    private List<String> passengers = new ArrayList<>();

    public Rideshare() {}

    public Rideshare(int carId, String driverUsername, int availableSeats) {
        this.carId = carId;
        this.driverUsername = driverUsername;
        this.availableSeats = availableSeats;
    }

    // Getters and Setters
    public int getRideId() { return rideId; }
    public void setRideId(int rideId) { this.rideId = rideId; }

    public int getCarId() { return carId; }
    public void setCarId(int carId) { this.carId = carId; }

    public String getDriverUsername() { return driverUsername; }
    public void setDriverUsername(String driverUsername) { this.driverUsername = driverUsername; }

    public int getAvailableSeats() { return availableSeats; }
    public void setAvailableSeats(int availableSeats) { this.availableSeats = availableSeats; }

    public List<String> getPassengers() { return passengers; }
    public void setPassengers(List<String> passengers) { this.passengers = passengers; }

    public void addPassenger(String passengerUsername) {
        if (availableSeats > 0) {
            passengers.add(passengerUsername);
            availableSeats--;
        }
    }
}
