package Model;

import jakarta.persistence.*;

@Entity
@Table(name = "location_hub")
public class LocationHub {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String locationName;
  private String address;
  private String city;
  private String country;
  private String email;
  private String phoneNr;
  private int carCapacity;

  // Default constructor
  public LocationHub() {}

  // Parameterized constructor
  public LocationHub(int locationHubId, String locationName, String address, String city, String country,
      String email, String phoneNr, int carCapacity) {
    this.locationName = locationName;
    this.address = address;
    this.city = city;
    this.country = country;
    this.email = email;
    this.phoneNr = phoneNr;
    this.carCapacity = carCapacity;
    this.id = locationHubId;
  }

  // Getters and Setters

  public int getId() {
    return id;
  }

  public String getLocationName() {
    return locationName;
  }

  public void setLocationName(String locationName) {
    this.locationName = locationName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNr() {
    return phoneNr;
  }

  public void setPhoneNr(String phoneNr) {
    this.phoneNr = phoneNr;
  }

  public int getCarCapacity() {
    return carCapacity;
  }

  public void setCarCapacity(int carCapacity) {
    this.carCapacity = carCapacity;
  }
}
