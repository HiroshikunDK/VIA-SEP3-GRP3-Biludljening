using Shared.Dto;

namespace CarApp.Services;

public interface IPaymentService
{
    Task<PaymentResponseDto?> createPaymentAsync(CreatePaymentRequestDto request);
    Task<PaymentResponseDto?> GetPaymentByIdAsync(int id);
}
