package Model;

public class Car {
   private int carId;
    private String vin;
    private int yearProduced;
    private String manufacturer;
    private String model;
    private String color;
    private String altName;
    private int seats;
    private int carRange;
    private int locationHubRef;

  public Car(int carId, String vin, int yearProduced, String manufacturer,
      String model, String color, String altName, int seats, int carRange,
      int locationHubRef)
  {
    this.carId = carId;
    this.vin = vin;
    this.yearProduced = yearProduced;
    this.manufacturer = manufacturer;
    this.model = model;
    this.color = color;
    this.altName = altName;
    this.seats = seats;
    this.carRange = carRange;
    this.locationHubRef = locationHubRef;
  }

  // Getters and Setters
    public int getCarId() {
      return carId;
    }

    public void setCarId(int carId) {
      this.carId = carId;
    }

    public String getVin() {
      return vin;
    }

    public void setVin(String vin) {
      this.vin = vin;
    }

    public int getYearProduced() {
      return yearProduced;
    }

    public void setYearProduced(int yearProduced) {
      this.yearProduced = yearProduced;
    }

    public String getManufacturer() {
      return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
      this.manufacturer = manufacturer;
    }

    public String getModel() {
      return model;
    }

    public void setModel(String model) {
      this.model = model;
    }

    public String getColor() {
      return color;
    }

    public void setColor(String color) {
      this.color = color;
    }

    public String getAltName() {
      return altName;
    }

    public void setAltName(String altName) {
      this.altName = altName;
    }

    public int getSeats() {
      return seats;
    }

    public void setSeats(int seats) {
      this.seats = seats;
    }

    public int getCarRange() {
      return carRange;
    }

    public void setCarRange(int carRange) {
      this.carRange = carRange;
    }

    public int getLocationHubRef() {
      return locationHubRef;
    }

    public void setLocationHubRef(int locationHubRef) {
      this.locationHubRef = locationHubRef;
    }
  }


