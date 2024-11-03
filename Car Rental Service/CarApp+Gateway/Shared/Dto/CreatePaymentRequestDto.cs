namespace Shared.Dto
{
    public class CreatePaymentRequestDto
    {
        public long Customer { get; set; }
        public int BookingType { get; set; }
        public long Booking { get; set; }
        public string Status { get; set; }
        public long CreditCardRef { get; set; }
    }
}