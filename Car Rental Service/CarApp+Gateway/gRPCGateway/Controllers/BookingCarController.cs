using System.Globalization;
using Microsoft.AspNetCore.Mvc;
using Shared.Dto;
using Google.Protobuf.WellKnownTypes;
using Shared.Dto.Booking;

namespace gRPC_Gateway.Controllers;

[ApiController]
[Route("api/[controller]")]
public class BookingCarController : ControllerBase
{
    private readonly BookingCarService.BookingCarServiceClient _bookingCarServiceClient;

    public BookingCarController(BookingCarService.BookingCarServiceClient bookingCarServiceClient)
    {
        _bookingCarServiceClient = bookingCarServiceClient;
    }

    // Add a booking
    [HttpPost]
    public async Task<IActionResult> AddBooking([FromBody] BookingDto bookingDto)
    {
        Console.WriteLine($"Received booking DTO: {System.Text.Json.JsonSerializer.Serialize(bookingDto)}");

        var grpcRequest = MapToGrpcRequest(bookingDto);

        var response = await _bookingCarServiceClient.AddBookingCarAsync(grpcRequest);

        if (response.Success)
        {
            return Ok(new { BookingId = response.Bookingnr, Message = response.Message });
        }
        else
        {
            return BadRequest(new { Message = response.Message });
        }
    }

    // Get a booking by ID
    [HttpGet("{id}")]
    public async Task<IActionResult> GetBookingById(int id)
    {
        var request = new BookingCarRequest { BookingNr = id };
        var response = await _bookingCarServiceClient.GetBookingCarByIDAsync(request);

        if (response.BookingCar != null)
        {
            return Ok(MapFromGrpcResponse(response.BookingCar));
        }
        else
        {
            return NotFound(new { Message = "Booking not found" });
        }
    }

    // List all bookings
    [HttpGet]
    public async Task<IActionResult> ListAllBookings()
    {
        var request = new Google.Protobuf.WellKnownTypes.Empty(); // Explicitly use namespace
        var response = await _bookingCarServiceClient.GetAllBookingCarsAsync(request);

        if (response.BookingCars.Any())
        {
            var bookings = response.BookingCars.Select(MapFromGrpcResponse).ToList();
            return Ok(bookings);
        }
        else
        {
            return NoContent();
        }
    }

    // Update a booking
    [HttpPut]
    public async Task<IActionResult> UpdateBooking([FromBody] BookingDto bookingDto)
    {
        if (bookingDto.BookingNr == null)
        {
            return BadRequest(new { Message = "BookingNr is required for updates." });
        }

        var grpcRequest = MapToGrpcRequest(bookingDto);
        grpcRequest.Bookingnr = bookingDto.BookingNr.Value;

        var response = await _bookingCarServiceClient.UpdateBookingCarAsync(grpcRequest);

        if (response.Success)
        {
            return Ok(response);
        }
        else
        {
            return BadRequest(new { Message = response.Message });
        }
    }

    // Delete a booking by ID
    [HttpDelete("{id}")]
    public async Task<IActionResult> DeleteBooking(int id)
    {
        var request = new BookingCarRequest { BookingNr = id };
        var response = await _bookingCarServiceClient.DeleteBookingCarAsync(request);

        if (response.Success)
        {
            return Ok(new { Message = "Booking deleted successfully" });
        }
        else
        {
            return BadRequest(new { Message = response.Message });
        }
    }

    // Helper Methods
    private BookingCar MapToGrpcRequest(BookingDto bookingDto)
    {
        return new BookingCar
        {
            Status = bookingDto.Status,
            Startdato = bookingDto.StartDate?.ToString("yyyy-MM-dd") ?? string.Empty,
            Starttime = bookingDto.StartTime?.ToString("HH:mm") ?? string.Empty,
            Enddate = bookingDto.EndDate?.ToString("yyyy-MM-dd") ?? string.Empty,
            Endtime = bookingDto.EndTime?.ToString("HH:mm") ?? string.Empty,
            Price = bookingDto.Price,
            Greenshare = bookingDto.GreenShare ? 1 : 0,
            Carid = bookingDto.CarId,
            Customerid = bookingDto.CustomerId
        };
    }

    private BookingDto MapFromGrpcResponse(BookingCar grpcBooking)
    {
        return new BookingDto
        {
            BookingNr = grpcBooking.Bookingnr,
            Status = grpcBooking.Status,
            StartDate = DateTime.TryParse(grpcBooking.Startdato, out var startDate) ? startDate : (DateTime?)null,
            StartTime = TimeOnly.TryParse(grpcBooking.Starttime, out var startTime) ? startTime : (TimeOnly?)null,
            EndDate = DateTime.TryParse(grpcBooking.Enddate, out var endDate) ? endDate : (DateTime?)null,
            EndTime = TimeOnly.TryParse(grpcBooking.Endtime, out var endTime) ? endTime : (TimeOnly?)null,
            Price = grpcBooking.Price,
            GreenShare = grpcBooking.Greenshare == 1,
            CarId = grpcBooking.Carid,
            CustomerId = grpcBooking.Customerid
        };
    }

}
