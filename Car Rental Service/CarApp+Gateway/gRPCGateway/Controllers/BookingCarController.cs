using Google.Protobuf.WellKnownTypes;
using Microsoft.AspNetCore.Mvc;
using Shared.Dto;

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
    public async Task<IActionResult> AddBooking([FromBody] AddBookingCarRequestDto bookingDto)
    {
        Console.WriteLine($"Received booking DTO: {System.Text.Json.JsonSerializer.Serialize(bookingDto)}");

        var addBookingRequest = new BookingCar
        {
            Status = bookingDto.Status,
            Startdato = bookingDto.Startdato,
            Starttime = bookingDto.Starttime,
            Enddate = bookingDto.Enddate,
            Endtime = bookingDto.Endtime,
            Price = bookingDto.Price,
            Greenshare = bookingDto.Greenshare,
            Carid = bookingDto.Carid,
            Customerid = bookingDto.Customerid
        };

        var response = await _bookingCarServiceClient.AddBookingCarAsync(addBookingRequest);
    
        if (response.Success)
        {
            return Ok(response);
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
        if (response != null)
        {
            return Ok(response); // Return booking details if found
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
        var request = new Google.Protobuf.WellKnownTypes.Empty();
        var response = await _bookingCarServiceClient.GetAllBookingCarsAsync(request);
        
        if (response.BookingCars.Any()) // If there are any bookings, return them
        {
            return Ok(response.BookingCars);
        }
        else
        {
            return NoContent(); // No bookings found
        }
    }

    // Update a booking
    [HttpPut]
    public async Task<IActionResult> UpdateBooking([FromBody] AddBookingCarRequestDto bookingDto)
    {
        var updateBookingRequest = new BookingCar
        {
            Status = bookingDto.Status,
            Startdato = bookingDto.Startdato,
            Starttime = bookingDto.Starttime,
            Enddate = bookingDto.Enddate,
            Endtime = bookingDto.Endtime,
            Price = bookingDto.Price,
            Greenshare = bookingDto.Greenshare,
            Carid = bookingDto.Carid,
            Customerid = bookingDto.Customerid
        };

        var response = await _bookingCarServiceClient.UpdateBookingCarAsync(updateBookingRequest);
        if (response.Success)
        {
            return Ok(response); // Return updated booking details
        }
        else
        {
            return BadRequest(new { Message = response.Message }); // Error response
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
            return Ok(new { Message = "Booking deleted successfully" }); // Success message
        }
        else
        {
            return BadRequest(new { Message = response.Message }); // Error message if deletion fails
        }
    }
    
    [HttpPost("create")]
    public async Task<IActionResult> CreateBooking([FromBody] BookingDto bookingDto)
    {
        if (bookingDto == null)
        {
            return BadRequest(new { Message = "Invalid booking request." });
        }

        var grpcRequest = new BookingCar
        {
            Status = bookingDto.Status,
            Startdato = bookingDto.StartDate.HasValue ? bookingDto.StartDate.Value.ToString("yyyy-MM-dd") : string.Empty,
            Starttime = bookingDto.StartTime.HasValue ? bookingDto.StartTime.Value.ToString("HH:mm") : string.Empty,
            Enddate = bookingDto.EndDate.HasValue ? bookingDto.EndDate.Value.ToString("yyyy-MM-dd") : string.Empty,
            Endtime = bookingDto.EndTime.HasValue ? bookingDto.EndTime.Value.ToString("HH:mm") : string.Empty,
            Price = bookingDto.Price.ToString("F2"),
            Greenshare = bookingDto.GreenShare ? 1 : 0,
            Carid = bookingDto.CarId,
            Customerid = bookingDto.CustomerId
        };

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
}
