namespace Shared.Dto;

public class PaymentDto
{
    public int BookingId { get; set; }
    public int CustomerId { get; set; }
    public string? CreditCardNumber { get; set; } 
    public string? ExpirationDate { get; set; } 
    public int CreditCardRef { get; set; }
    public string? Status { get; set; }
}
