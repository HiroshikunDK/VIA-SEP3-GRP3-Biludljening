package Model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RideShareOffers")
public class RideShareOffer{

    @Id
    @Column(name = "ride_id")
    private int rideId;
    @Column(name = "available_spaces")
    private int availableSpaces;
    @Column(name = "status")
    private String status; //full, partially booked or cancelled
    @Column(name = "start_date")
    private String startDate; // DATE as string in YYYY-MM-DD format
    @Column(name = "start_time")
    private String startTime; // TIME as string in HH:MM:SS format
    @Column(name = "start_location")
    private String startLocation;
    @Column(name = "end_date")
    private String endDate; // DATE as string in YYYY-MM-DD format
    @Column(name = "end_time")
    private String endTime; // TIME as string in HH:MM:SS format
    @Column(name = "end_location")
    private String endLocation;
    @Column(name = "price")
    private float price;
    @Column(name = "customer_id")
    private int customerId; // Reference to User Table
    @Column(name = "booking_ref")
    private int bookingRef; //Reference to car booking table

    // Default constructor
    public RideShareOffer() {}

    // Constructor with parameters
    public RideShareOffer(int rideId, int availableSpaces, String status, String startDate,
                          String startTime, String startLocation, String endDate, String endTime,
                          String endLocation, float price, int  customerId, int bookingRef) {
        this.rideId = rideId;
        this.availableSpaces = availableSpaces;
        this.status = status;
        this.startDate = startDate;
        this.startTime = startTime;
        this.startLocation = startLocation;
        this.endDate = endDate;
        this.endTime = endTime;
        this.endLocation = endLocation;
        this.price = price;
        this.customerId = customerId;
        this.bookingRef = bookingRef;
    }

    // Getters and Setters
    public int getRideId() {
        return rideId;
    }

    public void setRideId(int rideId) {
        this.rideId = rideId;
    }

    public int getAvailableSpaces() {
        return availableSpaces;
    }

    public void setAvailableSpaces(int availableSpaces) {
        this.availableSpaces = availableSpaces;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getBookingRef() {
        return bookingRef;
    }

    public void setBookingRef(int bookingRef) {
        this.bookingRef = bookingRef;
    }

    @Override
    public String toString() {
        return "RideShareOffer{" +
                "rideId='" + rideId + '\'' +
                ", availableSpaces=" + availableSpaces +
                ", status='" + status + '\'' +
                ", startDate='" + startDate + '\'' +
                ", startTime='" + startTime + '\'' +
                ", startLocation='" + startLocation + '\'' +
                ", endDate='" + endDate + '\'' +
                ", endTime='" + endTime + '\'' +
                ", endLocation='" + endLocation + '\'' +
                ", price=" + price +
                ", customerId='" + customerId + '\'' +
                ", bookingRef='" + bookingRef + '\'' +
                '}';
    }
}

