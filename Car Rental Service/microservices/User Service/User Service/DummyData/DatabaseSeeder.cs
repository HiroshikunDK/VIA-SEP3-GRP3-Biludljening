using User_Service.Data;
using User_Service.Models;

namespace User_Service
{
    public static class DatabaseSeeder
    {
        // Seeder databasen med dummy data
        public static void SeedDatabase(UserDatabase context)
        {
            // Sikre at databasen er lavet før seed
            context.Database.EnsureCreated();
            
            // Tjekker om User tabellen er tom før seed
            if (!context.Users.Any())
            {
                // Tilføjer en liste af brugere til Users tabellen
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
                // Gemmer ændringerne til databasen
                context.SaveChanges();
            }
        }
    }
}