namespace Shared.Dto.Car;

public class AddCarRequestDto
{
    public string Vin { get; set; }
    public int YearProduced { get; set; }
    public string Manufacturer { get; set; }
    public string Model { get; set; }
    public string Color { get; set; }
    public string AltName { get; set; }
    public int Seats { get; set; }
    public int CarRange { get; set; }
    public int LocationHubRef { get; set; }

    // Default constructor
    public AddCarRequestDto() { }

    // Parameterized constructor
    public AddCarRequestDto(string vin, int yearProduced, string manufacturer, string model, string color,
        string altName, int seats, int carRange, int locationHubRef)
    {
        Vin = vin;
        YearProduced = yearProduced;
        Manufacturer = manufacturer;
        Model = model;
        Color = color;
        AltName = altName;
        Seats = seats;
        CarRange = carRange;
        LocationHubRef = locationHubRef;
    }
}
