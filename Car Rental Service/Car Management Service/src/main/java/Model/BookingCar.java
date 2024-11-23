package Model;

import jakarta.persistence.*;

@Entity
@Table(name = "booking_cars")
public class BookingCar {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int bookingNr;

  private String status;
  private String startDate;
  private String startTime;
  private String endDate;
  private String endTime;
  private String price;
  private int greenShare;
  private int carId;
  private int customerId;

  // Default constructor
  public BookingCar() {}

  // Parameterized constructor
  public BookingCar(int bookingNr, String status, String startDate, String startTime,
      String endDate, String endTime, String price, int greenShare,
      int carId, int customerId) {
    this.bookingNr = bookingNr;
    this.status = status;
    this.startDate = startDate;
    this.startTime = startTime;
    this.endDate = endDate;
    this.endTime = endTime;
    this.price = price;
    this.greenShare = greenShare;
    this.carId = carId;
    this.customerId = customerId;
  }

  // Getters and setters for each field

  public int getBookingNr() {
    return bookingNr;
  }

  public void setBookingNr(int bookingNr) {
    this.bookingNr = bookingNr;
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

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public int getGreenShare() {
    return greenShare;
  }

  public void setGreenShare(int greenShare) {
    this.greenShare = greenShare;
  }

  public int getCarId() {
    return carId;
  }

  public void setCarId(int carId) {
    this.carId = carId;
  }

  public int getCustomerId() {
    return customerId;
  }

  public void setCustomerId(int customerId) {
    this.customerId = customerId;
  }
}
