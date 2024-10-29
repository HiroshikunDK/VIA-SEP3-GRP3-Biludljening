using Microsoft.EntityFrameworkCore;
using User_Service;
using User_Service.Database;
using UserManagementService;
var builder = WebApplication.CreateBuilder(args);

// Tilføjer gRPC-service til applikationen
builder.Services.AddGrpc();

// Konfigurerer databasekonteksten til at bruge PostgreSQL med den rigtige forbindelsesstreng
builder.Services.AddDbContext<UserDbContext>(options =>
    options.UseNpgsql(builder.Configuration.GetConnectionString("DefaultConnection"))); // Brug UseNpgsql til PostgreSQL

var app = builder.Build();

// Aktiverer udvikler-fejlside til debugging (valgfrit)
if (app.Environment.IsDevelopment())
{
    app.UseDeveloperExceptionPage();
}

// Mapper gRPC-servicen til applikationen
app.MapGrpcService<UserServiceImp>();

// Test af databaseforbindelse ved start af applikationen
using (var scope = app.Services.CreateScope())
{
    var dbContext = scope.ServiceProvider.GetRequiredService<UserDbContext>();

    try
    {
        // Forsøger at hente brugere fra databasen
        var users = dbContext.users.ToList();
        Console.WriteLine("Databaseforbindelse er aktiv, og data blev hentet.");
    }
    catch (Exception ex)
    {
        Console.WriteLine($"Fejl ved forbindelse til databasen: {ex.Message}");
    }
}

// Standardrute, der viser simpel information om servicen
app.MapGet("/", () => "User Service: Brug en gRPC-klient til at interagere med servicen.");

// Starter applikationen
app.Run();
