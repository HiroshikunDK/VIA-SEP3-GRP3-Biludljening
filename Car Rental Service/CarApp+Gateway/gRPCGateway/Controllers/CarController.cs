using Google.Protobuf.WellKnownTypes;
using Microsoft.AspNetCore.Mvc;
using Shared.Dto;

[ApiController]
[Route("api/[controller]")]
public class CarController : ControllerBase
{
    private readonly CarService.CarServiceClient _carServiceClient;

    public CarController(CarService.CarServiceClient carServiceClient)
    {
        _carServiceClient = carServiceClient;
    }

    [HttpPost("add")]
    public async Task<IActionResult> AddCar([FromBody] AddCarRequestDto carDto)
    {
        var addCarRequest = new Car
        {
            CarId = carDto.CarId,
            Model = carDto.Model,
            Color = carDto.Color,
            Seats = carDto.Seats
        };

        var response = await _carServiceClient.addCarAsync(addCarRequest);

        if (response.Success)
        {
            return Ok(new { Message = response.Message });
        }
        else
        {
            return BadRequest(new { Message = response.Message });
        }
    }

    [HttpGet("{id}")]
    public async Task<IActionResult> GetCarById(string id)
    {
        var request = new CarRequest { CarId = id };
        var response = await _carServiceClient.getCarByIDAsync(request);
        return Ok(response);
    }

    [HttpGet("list")]
    public async Task<IActionResult> ListAllCars()
    {
        var request = new Google.Protobuf.WellKnownTypes.Empty();
        var response = await _carServiceClient.getAllCarsAsync(request);

        return Ok(response.Cars);
    }


    [HttpPut("update")]
    public async Task<IActionResult> UpdateCar([FromBody] Car request)
    {
        var response = await _carServiceClient.updateCarAsync(request);
        return Ok(response);
    }

    [HttpDelete("{id}")]
    public async Task<IActionResult> DeleteCar(string id)
    {
        var request = new CarRequest { CarId = id };
        var response = await _carServiceClient.deleteCarAsync(request);
        return Ok(response);
    }
}