using Car_Management_Service.Data;
using Car_Management_Service.DummyData;
using Microsoft.AspNetCore.Server.Kestrel.Core;
using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);

builder.WebHost.ConfigureKestrel(options =>
{
    options.ListenLocalhost(5274, listenOptions =>
    {
        listenOptions.Protocols = HttpProtocols.Http2; 
    });

    options.ListenLocalhost(7035, listenOptions =>
    {
        listenOptions.UseHttps(); 
    });
});

builder.Services.AddGrpc();

builder.Services.AddDbContext<CarDatabase>(options =>
    options.UseSqlite(builder.Configuration.GetConnectionString("DefaultConnection")));

var app = builder.Build();

if (app.Environment.IsDevelopment())
{
    app.UseDeveloperExceptionPage();
}

SeedDatabase(app);

app.MapGrpcService<Car_Management_Service.Services.CarService>();

app.MapGet("/", () => "Car Management Service: Use a gRPC client to interact with the service.");

app.Run();

void SeedDatabase(IHost app)
{
    using var scope = app.Services.CreateScope();
    var context = scope.ServiceProvider.GetRequiredService<CarDatabase>();
    DatabaseSeeder.SeedDatabase(context);
}