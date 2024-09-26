using Microsoft.EntityFrameworkCore;
using Car_Management_Service.Models;

namespace Car_Management_Service.Data;

public class CarManagementDbContext : DbContext
{
    public CarManagementDbContext(DbContextOptions<CarManagementDbContext> options) : base(options) {}
    
    public DbSet<Car> Cars { get; set; }
}