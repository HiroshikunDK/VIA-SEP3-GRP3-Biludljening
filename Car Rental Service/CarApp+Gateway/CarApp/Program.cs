using CarApp.Components;
using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.IdentityModel.Tokens;
using System.Text;
using CarApp.Services;
using CarApp.Services.Authentication;
using CarApp.Services.Payment;
using CarApp.Services.User;
using Microsoft.AspNetCore.Components.Authorization;

namespace CarApp;

public class Program
{
    public static void Main(string[] args)
    {
        var builder = WebApplication.CreateBuilder(args);
        
        builder.Services.AddRazorComponents()
            .AddInteractiveServerComponents();

        builder.Services.AddScoped<AuthenticationStateProvider, CustomAuthenticationStateProvider>();
        builder.Services.AddScoped<AuthHandler>();
        builder.Services.AddHttpClient("AuthorizedClient", client =>
        {
            client.BaseAddress = new Uri("https://localhost:7131");
        }).AddHttpMessageHandler<AuthHandler>();

        builder.Services.AddAuthorizationCore();
        builder.Services.AddScoped<LoginService>();
        builder.Services.AddScoped<RegisterService>();
        builder.Services.AddScoped<UserProfileService>();
        builder.Services.AddScoped<ILoginService, LoginService>();
        builder.Services.AddScoped<IRegisterService, RegisterService>();
        builder.Services.AddScoped<IUserProfileService, UserProfileService>();
        builder.Services.AddScoped<IPaymentService, PaymentService>();

        // Configure JWT Authentication
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
                    IssuerSigningKey = new SymmetricSecurityKey(decodedKey),
                    NameClaimType = "sub", 
                    RoleClaimType = "role" 
                };
            });

        Console.WriteLine($"Decoded Key: {BitConverter.ToString(decodedKey)}");


        builder.Services.AddAuthorization();
        
        
        builder.Services.AddAntiforgery(options =>
        {
            options.HeaderName = "X-CSRF-TOKEN"; 
        });

        var app = builder.Build();

        if (!app.Environment.IsDevelopment())
        {
            app.UseExceptionHandler("/Error");
            app.UseHsts();
        }

        app.UseHttpsRedirection();
        app.UseStaticFiles();

        app.UseRouting();         
        
        app.UseAuthentication();  
        app.UseAuthorization();   

        app.UseAntiforgery();
        
        app.MapRazorComponents<App>()
            .AddInteractiveServerRenderMode();

        app.Run();
    }
}
