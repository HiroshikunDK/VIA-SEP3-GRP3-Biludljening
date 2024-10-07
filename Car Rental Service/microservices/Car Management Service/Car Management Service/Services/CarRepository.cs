using Car_Management_Service.Data;
using Car_Management_Service.Models;
using Microsoft.EntityFrameworkCore;

namespace Car_Management_Service.Services;

// Repository klasse for at udføre CRUD metoder på Car. 
// Integrere med CarDatabase context for at håndtere bil data
public class CarRepository
{
    private readonly CarDatabase _context;

    // Constructor
    public CarRepository(CarDatabase context)
    {
        _context = context;
    }

    // Asynkront henter alle biler fra databasen
    public async Task<List<Car>> GetAllCarsAsync()
    {
        return await _context.Cars.ToListAsync();
    }

    // Asynkront henter en bil vha. dens ID fra databasen
    public async Task<Car> GetCarByIdAsync(int id)
    {
        return await _context.Cars.FindAsync(id);
    }

    // Asynkront tilføjer en ny bil til databasen
    public async Task AddCarAsync(Car car)
    {
        _context.Cars.Add(car);
        await _context.SaveChangesAsync();
    }

    // Asynkront opdaterer en allerede eksisterende bil i databasen
    public async Task UpdateCarAsync(Car car)
    {
        _context.Entry(car).State = EntityState.Modified;
        if (car != null)
        {
            _context.Cars.Update(car);
            await _context.SaveChangesAsync();
        }
    }

    // Asynkont sletter en bil fra databasen vha. dens ID
    public async Task DeleteCarAsync(int id)
    {
        var car = await _context.Cars.FindAsync(id);
        if (car != null)
        {
            _context.Cars.Remove(car);
            await _context.SaveChangesAsync();
        }
    }
}