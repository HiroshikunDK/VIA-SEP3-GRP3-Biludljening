namespace Shared.Dto;

public class AddCarRequestDto
{
    public int CarId { get; set; }
    public string Model { get; set; }
    public string Color { get; set; }
    public int Seats { get; set; }
}