using Microsoft.AspNetCore.Mvc;
using Shared.Dto;

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

    [HttpPost]
    public async Task<IActionResult> CreatePayment([FromBody] CreatePaymentRequestDto reqeust)
    {
        var grpcRequest = new PaymentRequest
        {
            Customer = reqeust.Customer,
            BookingType = reqeust.BookingType,
            Booking = reqeust.Booking,
            Status = reqeust.Status,
            Creditcardref = reqeust.CreditCardRef
        };
        var response = await _paymentClient.CreatePaymentAsync(grpcRequest);
        return Ok(response);
    }

    [HttpGet("{id}")]
    public async Task<IActionResult> GetPaymentById(int id)
    {
        var request = new PaymentRequestById { Id = id };
        var response = await _paymentClient.GetPaymentByIdAsync(request);
        return Ok(response);
    }

    [HttpPut("{id}/status")]
    public async Task<IActionResult> UpdatePaymentStatus(int id,[FromBody] PaymentStatusUpdateRequest request)
    {
        if (id != request.Id)
        {
            return BadRequest("Ids don't match");
        }

        try
        {
            var response = await _paymentClient.UpdatePaymentStatusAsync(request);
            if (!response.Success)
            {
                return StatusCode(500, "Failed to update payment status");
            }
           
            return Ok(response);

        }
        catch (Exception e)
        {
            return StatusCode(500, $"Internal Server Error: {e.Message}");
        }
    }
    
}