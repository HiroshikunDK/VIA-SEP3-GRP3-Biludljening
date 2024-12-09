namespace Shared.Dto;

public class RideShareRequestDto
{
        public string RideId { get; set; } // CRS_ID
        public string Status { get; set; } // only for internal use?
        public string StartDate { get; set; } // DATE as string in YYYY-MM-DD format
        public string StartTime { get; set; } // TIME as string in HH:MM:SS format
        public string StartLocation { get; set; } // CRS_ADDRESS
        public float Latitude { get; set; } // Geographical latitude
        public float Longitude { get; set; } // Geographical longitude
        public string EndDate { get; set; } // DATE as string in YYYY-MM-DD format
        public string EndTime { get; set; } // TIME as string in HH:MM:SS format
        public string EndLocation { get; set; } // CRS_ADDRESS
        public float Price { get; set; } // CRS_CURRENCY (customer price)
        public string CustomerId { get; set; } // CRS_ID (Reference to Usertable)
        public string BookingRef { get; set; } // CRS_ID (reference to RideshareOffer)
}