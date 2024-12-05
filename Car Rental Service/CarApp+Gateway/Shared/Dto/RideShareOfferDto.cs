namespace Shared.Dto;

public class RideShareOfferDto
{
    public string RideId { get; set; } // CRS_ID
    public int AvailableSpaces { get; set; } // SMALLINT
    public string Status { get; set; } // CRS_NAME (status: full, partially booked, or cancelled)
    public string StartDate { get; set; } // DATE as string in YYYY-MM-DD format
    public string StartTime { get; set; } // TIME as string in HH:MM:SS format
    public string StartLocation { get; set; } // CRS_ADDRESS
    public string EndDate { get; set; } // DATE as string in YYYY-MM-DD format
    public string EndTime { get; set; } // TIME as string in HH:MM:SS format
    public string EndLocation { get; set; } // CRS_ADDRESS
    public float Price { get; set; } // CRS_CURRENCY (published price)
    public string CustomerId { get; set; } // CRS_ID (Reference to Usertable)
    public string BookingRef { get; set; } // CRS_ID (reference to car booking table)
}
