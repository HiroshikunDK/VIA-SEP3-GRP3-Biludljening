namespace Shared.Dto.Payment;

public class PaymentResponseDto
{
    public long Id { get; set; }
    public long Customer  { get; set; }
    public int BookingType { get; set; }
    public int Booking { get; set; }
    public string Status { get; set; }
    public long CreditCardRef { get; set; }
    public decimal Price { get; set; } 
}