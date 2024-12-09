using Shared.Dto;
using Shared.Dto.Payment;

namespace CarApp.Services.Payment;

public interface IPaymentService
{
    Task<PaymentCreationResponseDto?> CreatePaymentAsync(PaymentDto payment);
    Task<PaymentResponseDto?> GetPaymentByIdAsync(int id);
}