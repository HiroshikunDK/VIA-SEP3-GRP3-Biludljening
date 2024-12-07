using System.Text;
using Grpc.Core;
using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.IdentityModel.Tokens;
using Userservice;

var builder = WebApplication.CreateBuilder(args);

builder.Services.AddCors(options =>
{
    options.AddDefaultPolicy(policy =>
    {
        policy.WithOrigins("http://localhost:5125")
            .AllowAnyHeader()
            .AllowAnyMethod()
            .AllowCredentials();
    });
});

builder.Services.AddGrpcClient<RideShareService.RideShareServiceClient>(options =>
{
    options.Address = new Uri("http://localhost:5008");
});

builder.Services.AddGrpcClient<UserService.UserServiceClient>(options =>
{
    options.Address = new Uri("http://localhost:5006");
});

builder.Services.AddGrpcClient<PaymentService.PaymentServiceClient>(options =>
{
    options.Address = new Uri("http://localhost:5005");
});

builder.Services.AddGrpcClient<CarService.CarServiceClient>(options =>
{
    options.Address = new Uri("http://localhost:5004");
});

builder.Services.AddGrpcClient<BookingCarService.BookingCarServiceClient>(options =>
{
    options.Address = new Uri("http://localhost:5004");
});

builder.Services.AddControllers();

var base64EncodedKey = "RGVuRXJIZW1tZWxpZw=="; // Base64 of "DenErHemmelig"
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
            IssuerSigningKey = new SymmetricSecurityKey(decodedKey) // Use decoded key bytes
        };
    });

Console.WriteLine($"Decoded Key: {BitConverter.ToString(decodedKey)}");

builder.Services.AddAntiforgery(options =>
{
    options.HeaderName = "X-CSRF-TOKEN"; 
});

var app = builder.Build();

if (app.Environment.IsDevelopment())
{
    app.UseDeveloperExceptionPage();
}

app.UseCors();
app.UseRouting();

app.UseAuthentication();
app.UseAuthorization();

app.UseEndpoints(endpoints =>
{
    endpoints.MapControllers();
});

app.Use(async (context, next) =>
{
    if (context.Request.Headers.ContainsKey("Authorization"))
    {
        Console.WriteLine($"Authorization Header in Broker: {context.Request.Headers["Authorization"]}");
    }
    else
    {
        Console.WriteLine("Authorization Header Missing in Broker");
    }

    await next();
});


app.Run();