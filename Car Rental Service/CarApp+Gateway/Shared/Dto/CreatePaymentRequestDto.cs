public class CreatePaymentRequestDto
{
    public int BookingId { get; set; }
    public string CreditCardNumber { get; set; } = string.Empty; // Add this property
    public string ExpirationDate { get; set; } = string.Empty; // Add this property
    public int CustomerId { get; set; }
}