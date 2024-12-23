﻿namespace Shared.Dto.Payment;

public class PaymentDto
{
    public int BookingId { get; set; }
    public int CustomerId { get; set; }
    public string? ExpirationDate { get; set; } 
    public long CreditCardRef { get; set; }
    public string? Status { get; set; }
}
