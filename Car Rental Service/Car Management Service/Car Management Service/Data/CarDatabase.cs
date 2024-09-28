using Microsoft.EntityFrameworkCore;
using Car_Management_Service.Models;

namespace Car_Management_Service.Data;

public class CarDatabase : DbContext
{
    public CarDatabase(DbContextOptions<CarDatabase> options) : base(options) {}
    
    public DbSet<Car> Cars { get; set; }
}