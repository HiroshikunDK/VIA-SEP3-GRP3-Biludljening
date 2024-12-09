namespace Shared.Dto;

public class BookingDto
{
    public int? BookingNr { get; set; } // Nullable for creation
    public int CarId { get; set; }
    public DateTime? StartDate { get; set; }
    public TimeOnly? StartTime { get; set; }
    public DateTime? EndDate { get; set; }
    public TimeOnly? EndTime { get; set; }
    public double Price { get; set; }
    public bool GreenShare { get; set; }
    public int CustomerId { get; set; }
    public string Status { get; set; } = "Pending";
}