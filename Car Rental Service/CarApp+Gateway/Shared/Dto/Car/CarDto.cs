namespace Shared.Dto.Car;

public class CarDto
{
    public int CarId { get; set; }
    public string Vin { get; set; }
    public int YearProduced { get; set; }
    public string Manufacturer { get; set; }
    public string Model { get; set; }
    public string Color { get; set; }
    public string AltName { get; set; }
    public int Seats { get; set; }
    public int CarRange { get; set; }
    public int LocationHubRef { get; set; }
}