using Microsoft.AspNetCore.Mvc;

namespace gRPC_Gateway.Controllers;

[ApiController]
[Route("api/payment")]
public class PaymentController : ControllerBase
{
    private readonly PaymentService.PaymentServiceClient _paymentClient;

    public PaymentController(PaymentService.PaymentServiceClient paymentClient)
    {
        _paymentClient = paymentClient;
    }

    [HttpPost("create")]
    public async Task<IActionResult> CreatePayment([FromBody] PaymentRequest request)
    {
        var response = await _paymentClient.CreatePaymentAsync(request);
        return Ok(response);
    }

    [HttpGet("{id}")]
    public async Task<IActionResult> GetPaymentById(int id)
    {
        var request = new PaymentRequestById { Id = id };
        var response = await _paymentClient.GetPaymentByIdAsync(request);
        return Ok(response);
    }

    [HttpPut("updateStatus")]
    public async Task<IActionResult> UpdatePaymentStatus([FromBody] PaymentStatusUpdateRequest request)
    {
        var response = await _paymentClient.UpdatePaymentStatusAsync(request);
        return Ok(response);
    }
}