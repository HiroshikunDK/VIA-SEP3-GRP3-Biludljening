namespace Shared.Dto.RideShare;

public class CreateRideshareRequestDto
{
    public int CarId { get; set; }
    public string DriverUsername { get; set; }
    public int AvailableSeats { get; set; }
}