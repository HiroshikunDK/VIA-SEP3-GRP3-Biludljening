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
        var request = new Google.Protobuf.WellKnownTypes.Empty();
        var response = await _carServiceClient.getAllCarsAsync(request);
        
        var cars = response.Cars.ToList(); // turning into a list for filtering

        if (cars.Any())
        {
            return Ok(response.Cars);
        }
        else
        {
            return NoContent();
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
}