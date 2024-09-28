using Car_Management_Service.Data;
using Car_Management_Service.Models;
using Microsoft.EntityFrameworkCore;

namespace Car_Management_Service.Services;

public class CarRepository
{
    private readonly CarDatabase _context;

    public CarRepository(CarDatabase context)
    {
        _context = context;
    }

    public async Task<List<Car>> GetAllCarsAsync()
    {
        return await _context.Cars.ToListAsync();
    }

    public async Task<Car> GetCarByIdAsync(int id)
    {
        return await _context.Cars.FindAsync(id);
    }

    public async Task AddCarAsync(Car car)
    {
        _context.Cars.Add(car);
        await _context.SaveChangesAsync();
    }

    public async Task UpdateCarAsync(Car car)
    {
        _context.Entry(car).State = EntityState.Modified;
        if (car != null)
        {
            _context.Cars.Update(car);
            await _context.SaveChangesAsync();
        }
    }

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