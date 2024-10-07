using CarManagementService;
using Grpc.Core;
using Microsoft.EntityFrameworkCore;
using GrpcCar = CarManagementService.Car;
using CarEntity = Car_Management_Service.Models.Car;

namespace Car_Management_Service.Services;

// gRPC service for at håndtere car entities.
// Giver metoder til at lave CRUD operationer via gRPC.
public class CarService : CarManagementService.CarService.CarServiceBase
{
    private readonly Data.CarDatabase _context;

    // Constructor
    public CarService(Data.CarDatabase context)
    {
        _context = context;
    }

    // Henter alle biler fra databasen og returner et gRPC respons
    public override async Task<CarList> GetAllCars(Empty request, ServerCallContext context)
    {
        var cars = await _context.Cars.ToListAsync();
        var carList = new CarList();
        
        // Mapper Car objekter til gRPC car objektet, og tilføjer dem til responslisten
        carList.Cars.AddRange(cars.Select(car => new GrpcCar
        {
            Id = car.Id,
            Name = car.Name,
            Model = car.Model,
            Year = car.Year,
            Status = car.Status
        }));

        return carList;
    }

    // Henter en specifik bil vha. dens ID og returnere et gRPC respons
    public override async Task<Car> GetCarByID(CarRequest request, ServerCallContext context)
    {
        Console.WriteLine($"Received GetCarByID request with ID: {request.Id}");
    
        var car = await _context.Cars.FindAsync(request.Id);
        if (car == null)
        {
            throw new RpcException(new Status(StatusCode.NotFound, "Car not found"));
        }

        return new Car
        {
            Id = car.Id,
            Name = car.Name,
            Model = car.Model,
            Year = car.Year,
            Status = car.Status
        };
    }

    // Tilføjer en ny bil til databasen via gRPC
    public override async Task<CarResponse> AddCar(GrpcCar request, ServerCallContext context)
    {
        var car = new CarEntity
        {
            Name = request.Name,
            Model = request.Model,
            Year = request.Year,
            Status = request.Status
        };

        _context.Cars.Add(car);
        await _context.SaveChangesAsync();

        return new CarResponse
        {
            Success = true,
            Message = "Car added successfully"
        };
    }

    // Opdatere en eksisterende bil i databasen via gRPC
    public override async Task<CarResponse> UpdateCar(GrpcCar request, ServerCallContext context)
    {
        var car = await _context.Cars.FindAsync(request.Id);
        if (car == null)
        {
            return new CarResponse
            {
                Success = false,
                Message = "Car not found"
            };
        }

        car.Name = request.Name;
        car.Model = request.Model;
        car.Year = request.Year;
        car.Status = request.Status;

        _context.Entry(car).State = EntityState.Modified;
        await _context.SaveChangesAsync();

        return new CarResponse
        {
            Success = true,
            Message = "Car updated successfully"
        };
    }

    // Sletter en bil fra databasen vha. dens ID via gRPC
    public override async Task<CarResponse> DeleteCar(CarRequest request, ServerCallContext context)
    {
        var car = await _context.Cars.FindAsync(request.Id);
        if (car == null)
        {
            return new CarResponse
            {
                Success = false,
                Message = "Car not found"
            };
        }

        _context.Cars.Remove(car);
        await _context.SaveChangesAsync();

        return new CarResponse
        {
            Success = true,
            Message = "Car deleted successfully"
        };
    }
}