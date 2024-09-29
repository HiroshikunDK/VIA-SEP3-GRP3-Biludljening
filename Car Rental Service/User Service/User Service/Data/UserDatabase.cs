using Microsoft.EntityFrameworkCore;
using User_Service.Models;

namespace User_Service.Data
{
    public class UserDatabase : DbContext
    {
        public UserDatabase(DbContextOptions<UserDatabase> options) : base(options) {}

        public DbSet<User> Users { get; set; }
    }
}