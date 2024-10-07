using Car_Management_Service.Data;
using Car_Management_Service.Models;

namespace Car_Management_Service.DummyData
{
    public static class DatabaseSeeder
    {
        // Seeder databasen med dummy data
        public static void SeedDatabase(CarDatabase context)
        {
            // Sikre at databasen er lavet før seed
            context.Database.EnsureCreated();
            
            // Tjekker om Cars tabellen er tom før seed
            if (!context.Cars.Any())
            {
                // Tilføjer en liste af biler til Cars tabellen
                context.Cars.AddRange(
                    new Car
                    {
                        Name = "Toyota Corolla",
                        Model = "XSE",
                        Year = 2020,
                        Status = "Available"
                    },
                    new Car
                    {
                        Name = "Honda Civic",
                        Model = "LX",
                        Year = 2019,
                        Status = "Rented"
                    },
                    new Car
                    {
                        Name = "Ford Mustang",
                        Model = "GT",
                        Year = 2021,
                        Status = "Available"
                    },
                    new Car
                    {
                        Name = "Chevrolet Bolt",
                        Model = "EV",
                        Year = 2022,
                        Status = "Available"
                    }
                );
                // Gemmer ændringerne til databasen
                context.SaveChanges();
            }
        }
    }
}