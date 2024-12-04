namespace Shared.Dto
{
    public class PaymentRequestDto
    {
        public long Customer { get; set; } // Maps to int64
        public int BookingType { get; set; } // Maps to int32
        public long Booking { get; set; } // Maps to int64
        public string Status { get; set; } // Maps to string
        public long CreditCardRef { get; set; } // Maps to int64
    }
}