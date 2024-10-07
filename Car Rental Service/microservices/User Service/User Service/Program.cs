using Microsoft.EntityFrameworkCore;
using User_Service;
using User_Service.Data;
using User_Service.Repositories.Interfaces;
using User_Service.Services;

var builder = WebApplication.CreateBuilder(args);

// Tilføjer gRPC service
builder.Services.AddGrpc();

// Konfigurer database context til at bruge SQLite
// Bruger en connection string fra appsettings.json (defaultconnection)
builder.Services.AddDbContext<UserDatabase>(options =>
    options.UseSqlite(builder.Configuration.GetConnectionString("DefaultConnection")));

// Registrer UserRepository 
builder.Services.AddScoped<IUserRepository, UserRepository>();

var app = builder.Build();

// Grim developer page til fejl
if (app.Environment.IsDevelopment())
{
    app.UseDeveloperExceptionPage();
}

// Seeder databasen med dummy data
SeedDatabase(app);

// Mapper gPRC service til applikationen
app.MapGrpcService<UserService>();

// Default route til Root URL, for at give simpel information om service
app.MapGet("/", () => "User Service: Use a gRPC client to interact with the service.");

// Vroom vroom - den kører applikationen
app.Run();

// Database Seed
void SeedDatabase(IHost app)
{
    using var scope = app.Services.CreateScope();
    var context = scope.ServiceProvider.GetRequiredService<UserDatabase>();
    DatabaseSeeder.SeedDatabase(context);
}