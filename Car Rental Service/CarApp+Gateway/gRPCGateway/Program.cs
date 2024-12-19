using System.Text;
using Grpc.Core;
using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.IdentityModel.Tokens;
using Microsoft.OpenApi.Models;
using Userservice;

var builder = WebApplication.CreateBuilder(args);

builder.Services.AddCors(options =>
{
    options.AddDefaultPolicy(policy =>
    {
        policy.WithOrigins("https://localhost:7280")
            .AllowAnyHeader()
            .AllowAnyMethod()
            .AllowCredentials();
    });
});

builder.Services.AddGrpcClient<RideShareService.RideShareServiceClient>(options =>
{
    options.Address = new Uri("https://localhost:5008");
});
builder.Services.AddGrpcClient<UserService.UserServiceClient>(options =>
{
    options.Address = new Uri("https://localhost:5006");
});
builder.Services.AddGrpcClient<PaymentService.PaymentServiceClient>(options =>
{
    options.Address = new Uri("https://localhost:5005");
});
builder.Services.AddGrpcClient<CarService.CarServiceClient>(options =>
{
    options.Address = new Uri("https://localhost:5004");
});
builder.Services.AddGrpcClient<BookingCarService.BookingCarServiceClient>(options =>
{
    options.Address = new Uri("https://localhost:5004");
});

// Add Controllers
builder.Services.AddControllers();

// Add Swagger
builder.Services.AddSwaggerGen(c =>
{
    c.SwaggerDoc("v1", new OpenApiInfo
    {
        Title = "gRPC Gateway API",
        Version = "v1",
        Description = "API for gRPC Gateway",
    });
});

// JWT Authentication Configuration
var base64EncodedKey = "RGVuRXJIZW1tZWxpZw=="; 
var decodedKey = Convert.FromBase64String(base64EncodedKey);

builder.Services.AddAuthentication(JwtBearerDefaults.AuthenticationScheme)
    .AddJwtBearer(options =>
    {
        options.TokenValidationParameters = new TokenValidationParameters
        {
            ValidateIssuer = false,
            ValidateAudience = false,
            ValidateLifetime = true,
            ValidateIssuerSigningKey = true,
            IssuerSigningKey = new SymmetricSecurityKey(decodedKey),
            NameClaimType = "sub", 
            RoleClaimType = "role" 
        };
    });

// CSRF Configuration
builder.Services.AddAntiforgery(options =>
{
    options.HeaderName = "X-CSRF-TOKEN"; 
});

var app = builder.Build();

if (app.Environment.IsDevelopment())
{
    app.UseDeveloperExceptionPage();
    // Enable Swagger in Development Environment
    app.UseSwagger();
    app.UseSwaggerUI(options =>
    {
        options.SwaggerEndpoint("/swagger/v1/swagger.json", "gRPC Gateway API v1");
    });
}

app.UseCors();
app.UseRouting();

app.UseAuthentication();
app.UseAuthorization();

app.UseEndpoints(endpoints =>
{
    endpoints.MapControllers();
});

app.Run();
