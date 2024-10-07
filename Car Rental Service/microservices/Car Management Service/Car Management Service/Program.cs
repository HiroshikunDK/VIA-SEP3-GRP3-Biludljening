using Car_Management_Service.Data;
using Car_Management_Service.DummyData;
using Microsoft.AspNetCore.Server.Kestrel.Core;
using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);

// Konfigurer Kestrel til at bruge HTTP2 - Krav til HTTPS
builder.WebHost.ConfigureKestrel(options =>
{
    // HTTP
    options.ListenLocalhost(5274, listenOptions =>
    {
        listenOptions.Protocols = HttpProtocols.Http2; 
    });

    // HTTPS
    options.ListenLocalhost(7035, listenOptions =>
    {
        listenOptions.UseHttps(); 
    });
});

// TIlføjer gRPC service
builder.Services.AddGrpc();

// Konfigurer database context til at bruge SQLite
// Bruger en connection string fra appsettings.json (defaultconnection)
builder.Services.AddDbContext<CarDatabase>(options =>
    options.UseSqlite(builder.Configuration.GetConnectionString("DefaultConnection")));

var app = builder.Build();

// Developer page til fejl
if (app.Environment.IsDevelopment())
{
    app.UseDeveloperExceptionPage();
}

// Seeder databasen med dummy data
SeedDatabase(app);

// Mapper gRPC service til applikationen
app.MapGrpcService<Car_Management_Service.Services.CarService>();

// Default route til root URL, for at give simpel information om servicen
app.MapGet("/", () => "Car Management Service: Use a gRPC client to interact with the service.");

// Vroom vroom - Den kører applikationen
app.Run();

// Database seed
void SeedDatabase(IHost app)
{
    using var scope = app.Services.CreateScope();
    var context = scope.ServiceProvider.GetRequiredService<CarDatabase>();
    DatabaseSeeder.SeedDatabase(context);
}