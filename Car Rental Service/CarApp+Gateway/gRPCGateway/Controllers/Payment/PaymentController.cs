using Microsoft.AspNetCore.Mvc;
using Shared.Dto;
using Shared.Dto.Payment;
using System.ComponentModel.DataAnnotations;

namespace gRPC_Gateway.Controllers.Payment;

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
    public async Task<IActionResult> CreatePayment([FromBody] PaymentDto paymentRequest)
    {
        // Validate credit card number and expiration date
        var validationErrors = ValidatePayment(paymentRequest);
        if (validationErrors.Any())
        {
            return BadRequest(new { Message = "Validation failed.", Errors = validationErrors });
        }

        try
        {
            // Create the gRPC request object from the PaymentDto
            var grpcRequest = new PaymentRequest
            {
                Customer = paymentRequest.CustomerId,
                Booking = paymentRequest.BookingId,
                Creditcardref = paymentRequest.CreditCardRef,
                Status = paymentRequest.Status ?? "Pending"
            };

            // Log the gRPC request for debugging
            Console.WriteLine($"gRPC Request: {System.Text.Json.JsonSerializer.Serialize(grpcRequest)}");

            // Call the gRPC service to create the payment
            var response = await _paymentClient.CreatePaymentAsync(grpcRequest);

            // Log the gRPC response for debugging
            Console.WriteLine($"gRPC Response: Success={response.Success}, Message={response.Message}, ID={response.Id}");

            // Handle the response from the gRPC service
            if (response.Success)
            {
                var dto = new PaymentCreationResponseDto
                {
                    PaymentId = (int)response.Id, // Map gRPC response ID
                    Message = response.Message
                };

                return Ok(dto);
            }
            else
            {
                return BadRequest(new { Message = response.Message });
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error in CreatePayment: {ex.Message}");
            return StatusCode(500, new { Message = $"Payment creation failed: {ex.Message}" });
        }
    }

    private List<string> ValidatePayment(PaymentDto paymentRequest)
    {
        var errors = new List<string>();

        // Validate credit card number
        if (paymentRequest.CreditCardRef.ToString().Length != 16)
        {
            errors.Add("Credit Card Number must be exactly 16 digits.");
        }

        // Validate expiration date format (MM/YY)
        var expirationDatePattern = @"^(0[1-9]|1[0-2])\/\d{2}$";
        if (string.IsNullOrEmpty(paymentRequest.ExpirationDate) ||
            !System.Text.RegularExpressions.Regex.IsMatch(paymentRequest.ExpirationDate, expirationDatePattern))
        {
            errors.Add("Expiration Date must be in MM/YY format.");
        }

        // Additional expiration date logic (e.g., must not be expired)
        if (DateTime.TryParseExact("01/" + paymentRequest.ExpirationDate, "dd/MM/yy", null, System.Globalization.DateTimeStyles.None, out var expiration))
        {
            if (expiration < DateTime.Now)
            {
                errors.Add("Expiration Date must be in the future.");
            }
        }
        else
        {
            errors.Add("Invalid Expiration Date.");
        }

        return errors;
    }

    [HttpGet("{id}")]
    public async Task<IActionResult> GetPaymentById(int id)
    {
        try
        {
            var request = new PaymentRequestById { Id = id };
            var response = await _paymentClient.GetPaymentByIdAsync(request);

            if (!response.Success)
            {
                return NotFound(new { Message = response.Message });
            }

            var paymentDto = new PaymentResponseDto
            {
                Id = response.Id,
                Customer = response.Customer,
                BookingType = response.BookingType,
                Booking = response.Booking,
                Status = response.Status,
                CreditCardRef = response.Creditcardref,
                Price = 0 // or set as needed
            };

            return Ok(paymentDto);
        }
        catch (Exception ex)
        {
            return StatusCode(500, new { Message = "An error occurred while retrieving the payment.", Details = ex.Message });
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
