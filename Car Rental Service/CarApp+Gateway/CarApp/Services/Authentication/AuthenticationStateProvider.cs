using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using Microsoft.AspNetCore.Components.Authorization;
using Microsoft.JSInterop;

namespace CarApp.Services.Authentication;

public class CustomAuthenticationStateProvider : AuthenticationStateProvider
{
    private readonly IJSRuntime _jsRuntime;

    public CustomAuthenticationStateProvider(IJSRuntime jsRuntime)
    {
        _jsRuntime = jsRuntime;
    }

    public override async Task<AuthenticationState> GetAuthenticationStateAsync()
    {
        var token = await _jsRuntime.InvokeAsync<string>("localStorage.getItem", "authToken");
        Console.WriteLine($"Token retrieved in AuthenticationStateProvider: {token}");

        if (string.IsNullOrEmpty(token))
        {
            Console.WriteLine("No token found or token is empty.");
            return new AuthenticationState(new ClaimsPrincipal(new ClaimsIdentity()));
        }

        try
        {
            var jwt = new JwtSecurityTokenHandler().ReadJwtToken(token);
            var claims = jwt.Claims;
            var identity = new ClaimsIdentity(claims, "jwt");
            var user = new ClaimsPrincipal(identity);

            Console.WriteLine("Authentication state updated with token.");
            return new AuthenticationState(user);
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error processing token: {ex.Message}");
            return new AuthenticationState(new ClaimsPrincipal(new ClaimsIdentity()));
        }
    }
    

    public void NotifyAuthenticationStateChanged(Task<AuthenticationState> authStateTask)
    {
        NotifyAuthenticationStateChanged(authStateTask);
    }
}

// Token wrapper class for deserialization
public class TokenWrapper
{
    public string Token { get; set; }
    public string Role { get; set; }
}
