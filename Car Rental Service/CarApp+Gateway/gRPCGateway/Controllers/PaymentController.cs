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
    public async Task<IActionResult> CreatePayment([FromBody] PaymentRequestDto paymentRequest)
    {
        try
        {
            var grpcRequest = new PaymentRequest
            {
                Customer = paymentRequest.Customer,
                BookingType = paymentRequest.BookingType,
                Booking = paymentRequest.Booking,
                Status = paymentRequest.Status,
                Creditcardref = paymentRequest.CreditCardRef
            };

            var response = await _paymentClient.CreatePaymentAsync(grpcRequest);

            if (response.Success)
            {
                return Ok(new { PaymentId = response.Id, Message = response.Message });
            }
            else
            {
                return BadRequest(new { Message = response.Message });
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Payment creation failed: {ex.Message}");
            return StatusCode(500, new { Message = "Internal server error" });
        }
    }


    [HttpGet("{id}")]
    public async Task<IActionResult> GetPaymentById(long id)
    {
        var grpcRequest = new PaymentRequestById { Id = id };
        var response = await _paymentClient.GetPaymentByIdAsync(grpcRequest);

        if (response.Success)
        {
            return Ok(response);
        }
        else
        {
            return NotFound(new { Message = response.Message });
        }
    }

    [HttpPut("update-status")]
    public async Task<IActionResult> UpdatePaymentStatus([FromBody] PaymentStatusUpdateDto paymentStatusUpdate)
    {
        var grpcRequest = new PaymentStatusUpdateRequest
        {
            Id = paymentStatusUpdate.PaymentId,
            Status = paymentStatusUpdate.Status
        };

        var response = await _paymentClient.UpdatePaymentStatusAsync(grpcRequest);

        if (response.Success)
        {
            return Ok(new { Message = response.Message });
        }
        else
        {
            return BadRequest(new { Message = response.Message });
        }
    }

    [HttpGet("list/{customerId}")]
    public async Task<IActionResult> ListPaymentsByCustomer(long customerId)
    {
        var grpcRequest = new PaymentListByCustomerRequest { CustomerId = customerId };
        var response = await _paymentClient.ListPaymentsByCustomerAsync(grpcRequest);

        if (response.Payments.Any())
        {
            return Ok(response.Payments);
        }
        else
        {
            return NoContent();
        }
    }
}
