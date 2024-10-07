using Microsoft.EntityFrameworkCore;
using User_Service.Models;

namespace User_Service.Data
{
    // Database context. Giver adgang til database tabeller
    public class UserDatabase : DbContext
    {
        // Constructor
        public UserDatabase(DbContextOptions<UserDatabase> options) : base(options) {}

        // CRUD operationer for User
        public DbSet<User> Users { get; set; }
    }
}