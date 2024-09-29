using User_Service.Data;
using User_Service.Models;

namespace User_Service
{
    public static class DatabaseSeeder
    {
        public static void SeedDatabase(UserDatabase context)
        {
            context.Database.EnsureCreated();
            
            if (!context.Users.Any())
            {
                context.Users.AddRange(
                    new User
                    {
                        Username = "Alexander",
                        Email = "Alexander@gmail.com",
                        Password = Helpers.PasswordHelper.HashPassword("password123"),
                        Role = "User"
                    },
                    new User
                    {
                        Username = "Alex",
                        Email = "Alex@gmail.com",
                        Password = Helpers.PasswordHelper.HashPassword("password456"),
                        Role = "Admin"
                    }
                );
                context.SaveChanges();
            }
        }
    }
}