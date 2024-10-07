using Microsoft.EntityFrameworkCore;
using Car_Management_Service.Models;

namespace Car_Management_Service.Data;

// Database context. Giver adgang til database tabeller
public class CarDatabase : DbContext
{
    // Constructor
    public CarDatabase(DbContextOptions<CarDatabase> options) : base(options) {}
    
    // CRUD metoder for Car
    public DbSet<Car> Cars { get; set; }
}