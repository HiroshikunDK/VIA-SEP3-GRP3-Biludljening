using Grpc.Core;
using Microsoft.AspNetCore.Mvc;
using Shared.Dto;
using Shared.Dto.Car;

namespace gRPC_Gateway.Controllers;

[ApiController]
[Route("api/[controller]")]
public class CarController : ControllerBase
{
    private readonly CarService.CarServiceClient _carServiceClient;

    public CarController(CarService.CarServiceClient carServiceClient)
    {
        _carServiceClient = carServiceClient;
    }

    [HttpPost]
    public async Task<IActionResult> AddCar([FromBody] AddCarRequestDto carDto)
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

    [HttpGet("{id}")]
    public async Task<IActionResult> GetCarById(int id)
    {
        var request = new CarRequest { CarId = id };
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

            return Ok(response.Cars);
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
        return Ok(response);
    }

    [HttpDelete("{id}")]
    public async Task<IActionResult> DeleteCar(int id)
    {
        var request = new CarRequest { CarId = id };
        var response = await _carServiceClient.deleteCarAsync(request);
        return Ok(response);
    }
    
    [HttpGet("available/{locationId}")]
    public async Task<IActionResult> GetAvailableCars(int locationId)
    {
        var request = new LocationHubRequest { Id = locationId };
        var response = await _carServiceClient.getAvailableCarsByLocationAsync(request);
        return Ok(response.Cars);
    }

}