namespace Shared.Dto.RideShare;

public class RideShareDto
{
    public int RideId { get; set; }
    public int CarId { get; set; }
    public string DriverUsername { get; set; }
    public int AvailableSeats { get; set; }
    public List<string> Passengers { get; set; }
}