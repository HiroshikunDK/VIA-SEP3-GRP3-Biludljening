using Shared.Dto;

namespace CarApp.Services;

public interface IPaymentService
{
    Task<PaymentResponseDto?> CreatePaymentAsync(PaymentDto payment);
    Task<PaymentResponseDto?> GetPaymentByIdAsync(int id);
}