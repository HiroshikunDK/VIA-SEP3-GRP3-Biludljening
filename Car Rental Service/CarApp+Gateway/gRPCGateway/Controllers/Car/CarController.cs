using Grpc.Core;
using Microsoft.AspNetCore.Mvc;
using Shared.Dto.Car;


namespace gRPC_Gateway.Controllers;

[ApiController]
[Route("api/[controller]")]
public class CarController : ControllerBase
{
    private readonly CarService.CarServiceClient _carServiceClient;
    private readonly BookingCarService.BookingCarServiceClient _bookingCarServiceClient;

    public CarController(CarService.CarServiceClient carServiceClient, BookingCarService.BookingCarServiceClient bookingCarServiceClient)
    {
        _carServiceClient = carServiceClient;
        _bookingCarServiceClient = bookingCarServiceClient;
    }

    [HttpPost]
    public async Task<IActionResult> AddCar([FromBody] AddCarRequestDto carDto)
    {
        try
        {
            var addCarRequest = new Car
            {
                Vin = carDto.Vin,
                Yearproduced = carDto.YearProduced,
                Manufactor = carDto.Manufacturer,
                Model = carDto.Model,   
                Color = carDto.Color,
                Altname = carDto.AltName,
                Seats = carDto.Seats,
                Carrange = carDto.CarRange,
                Locationhubref = carDto.LocationHubRef
            };

            var response = await _carServiceClient.addCarAsync(addCarRequest);
        
            return Ok(response);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, new {Message = "An unexpected error occured", Details = e.Message});
        }
        
    }

    [HttpGet("{id}")]
    public async Task<IActionResult> GetCarById(int id)
    {
        var request = new CarRequest { CarId = id.ToString() };
        var response = await _carServiceClient.getCarByIDAsync(request);
        return Ok(response);
    }

    [HttpGet]
    public async Task<IActionResult> ListAllCars()
    {
        try
        {
            var metadata = new Metadata();
            if (Request.Headers.ContainsKey("Authorization"))
            {
                metadata.Add("Authorization", Request.Headers["Authorization"]);
            }

            var response = await _carServiceClient.getAllCarsAsync(
                new Google.Protobuf.WellKnownTypes.Empty(),
                metadata,
                null,
                CancellationToken.None
            );

            // Fetch all bookings
            var bookingResponse = await _bookingCarServiceClient.GetAllBookingCarsAsync(new Google.Protobuf.WellKnownTypes.Empty());            var bookedCars = bookingResponse.BookingCars
                .Where(b => b.Status == "Ongoing" || b.Status == "Pending")
                .Select(b => b.Carid)
                .ToHashSet();

            // Mark cars as available or rented
            var carsWithAvailability = response.Cars.Select(car => new
            {
                car.CarId,
                car.Manufactor,
                car.Model,
                car.Vin,
                car.Color,
                car.Seats,
                car.Carrange,
                car.Locationhubref,
                IsAvailable = !bookedCars.Contains(car.CarId)
            });

            return Ok(carsWithAvailability);
        }
        catch (RpcException rpcEx) when (rpcEx.StatusCode == Grpc.Core.StatusCode.Unauthenticated)
        {
            return Unauthorized(new { Message = "Invalid or missing token." });
        }
        catch (Exception ex)
        {
            return StatusCode(500, new { Message = "An unexpected error occurred.", Details = ex.Message });
        }
    }


    [HttpPut]
    public async Task<IActionResult> UpdateCar([FromBody] AddCarRequestDto carDto)
    {
        var updateCarRequest = new Car
        {
            Vin = carDto.Vin,
            Yearproduced = carDto.YearProduced,
            Manufactor = carDto.Manufacturer,
            Model = carDto.Model,   
            Color = carDto.Color,
            Altname = carDto.AltName,
            Seats = carDto.Seats,
            Carrange = carDto.CarRange,
            Locationhubref = carDto.LocationHubRef
        }; 
        var response = await _carServiceClient.updateCarAsync(updateCarRequest);
        if (response.Success)
        {
            return Ok(response);
        }
        else
        {
            return BadRequest(response);
        }
        
    }

    [HttpDelete("{id}")]
    public async Task<IActionResult> DeleteCar(int id)
    {
        var request = new CarRequest { CarId = id.ToString() };
        var response = await _carServiceClient.deleteCarAsync(request);
        if (response.Success)
        {
            return Ok(response);
        }
        else
        {
            return BadRequest(response);
        }
    }
    
    [HttpGet("available/{locationId}")]
    public async Task<IActionResult> GetAvailableCars(int locationId)
    {
        var request = new LocationHubRequest { Id = locationId };
        var response = await _carServiceClient.getAvailableCarsByLocationAsync(request);
        return Ok(response.Cars);
    }
    [HttpGet("altname/{altName}")]
    public async Task<IActionResult> GetCarsByAltName(string altName)
    {
        try
        {
            // Create the gRPC request
            var request = new AltnameRequest { AltName = altName };

            // Call the gRPC service
            var response = await _carServiceClient.getCarByALtnameAsync(request);

            // Check if any cars were found
            if (response.Cars.Count == 0)
            {
                return NotFound(new { Message = $"No cars found with the alternative name: {altName}" });
            }

            // Return the list of cars
            return Ok(response.Cars);
        }
        catch (RpcException rpcEx) when (rpcEx.StatusCode == Grpc.Core.StatusCode.NotFound)
        {
            return NotFound(new { Message = $"No cars found with the alternative name: {altName}" });
        }
        catch (Exception ex)
        {
            return StatusCode(500, new { Message = "An unexpected error occurred.", Details = ex.Message });
        }
    }
   
    [HttpGet("model/{model}")]
    public async Task<IActionResult> GetCarsBymodel(string model)
    {
        try
        {
            // Create the gRPC request
            var request = new CarModelRequest { Model = model };

            // Call the gRPC service
            var response =  _carServiceClient.getCarByModel(request);

            // Check if any cars were found
            if (response.Cars.Count == 0)
            {
                return NotFound(new { Message = $"No cars found with the alternative name: {model}" });
            }

            // Return the list of cars
            return Ok(response.Cars);
        }
        catch (RpcException rpcEx) when (rpcEx.StatusCode == Grpc.Core.StatusCode.NotFound)
        {
            return NotFound(new { Message = $"No cars found with the alternative name: {model}" });
        }
        catch (Exception ex)
        {
            return StatusCode(500, new { Message = "An unexpected error occurred.", Details = ex.Message });
        }
    }
    

}