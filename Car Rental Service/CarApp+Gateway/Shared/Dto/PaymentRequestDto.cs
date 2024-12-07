namespace Shared.Dto
{
    public class PaymentRequestDto
    {
        public int Customer { get; set; } // Maps to int64
        public int BookingType { get; set; } // Maps to int32
        public int Booking { get; set; } // Maps to int64
        public string Status { get; set; } // Maps to string
        public int CreditCardRef { get; set; } // Maps to int64
    }
}