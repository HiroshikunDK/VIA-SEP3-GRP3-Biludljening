namespace Shared.Dto.Payment;

public class PaymentCreationResponseDto
{
    public int? PaymentId { get; set; }
    public string? Message { get; set; }
    public List<string>? Errors { get; set; }
}