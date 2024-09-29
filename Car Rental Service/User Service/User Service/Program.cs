using Microsoft.EntityFrameworkCore;
using User_Service;
using User_Service.Data;
using User_Service.Services;

var builder = WebApplication.CreateBuilder(args);

builder.Services.AddGrpc();

builder.Services.AddDbContext<UserDatabase>(options =>
    options.UseSqlite(builder.Configuration.GetConnectionString("DefaultConnection")));

builder.Services.AddScoped<IUserRepository, UserRepository>();

var app = builder.Build();

if (app.Environment.IsDevelopment())
{
    app.UseDeveloperExceptionPage();
}

SeedDatabase(app);

app.MapGrpcService<UserService>();

app.MapGet("/", () => "User Service: Use a gRPC client to interact with the service.");

app.Run();

void SeedDatabase(IHost app)
{
    using var scope = app.Services.CreateScope();
    var context = scope.ServiceProvider.GetRequiredService<UserDatabase>();
    DatabaseSeeder.SeedDatabase(context);
}