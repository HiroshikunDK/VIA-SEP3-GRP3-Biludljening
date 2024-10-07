using Car_Management_Service.Data;
using Car_Management_Service.Models;
using Car_Management_Service.Services;
using Microsoft.AspNetCore.Mvc;

namespace Car_Management_Service.Controllers
{
    // Sætter route for controlleren til 'api/car'
    [Route("api/[controller]")]
    // Indikere det er en API controller
    [ApiController]
    public class CarController : ControllerBase
    {
        // repository til at håndtere bil data operationer
        private readonly CarRepository _carService;

        // Constructor
        public CarController(CarRepository carService)
        {
            _carService = carService;
        }

        // Henter alle biler fra repository
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Car>>> GetCars()
        {
            var cars = await _carService.GetAllCarsAsync();
            return Ok(cars);
        }
        
        // Henter en specifik bil vha. ID
        [HttpGet("{id}")]
        public async Task<ActionResult<Car>> GetCarById(int id)
        {
            var car = await _carService.GetCarByIdAsync(id);
            if (car == null)
            {
                return NotFound();
            }

            return Ok(car);
        }

        // Tilføjer en ny bil til repository
        [HttpPost]
        public async Task<ActionResult<Car>> AddCar(Car car)
        {
            await _carService.AddCarAsync(car);
            return CreatedAtAction(nameof(GetCarById), new { id = car.Id }, car);
        }

        // Opdaterer en nuværende bil i repository
        [HttpPut("{id}")]
        public async Task<IActionResult> UpdateCar(int id, Car car)
        {
            if (id != car.Id)
            {
                return BadRequest();
            }
            
            await _carService.UpdateCarAsync(car);
            return NoContent();
        }

        // Sletter en bil vha. dens ID fra repository
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteCar(int id)
        {
            await _carService.DeleteCarAsync(id);
            return NoContent();
        }
    }
}