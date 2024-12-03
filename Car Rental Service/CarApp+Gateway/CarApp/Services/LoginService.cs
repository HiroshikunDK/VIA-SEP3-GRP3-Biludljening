using Microsoft.JSInterop;
using Shared.Dto;

namespace CarApp.Services;

public class LoginService
{
    private readonly HttpClient _httpClient;
    private readonly IJSRuntime _jsRuntime;

    public LoginService(IHttpClientFactory httpClientFactory, IJSRuntime jsRuntime)
    {
        _httpClient = httpClientFactory.CreateClient("AuthorizedClient");
        _jsRuntime = jsRuntime;
    }

    public async Task<string> LoginAsync(LoginRequestDto loginModel)
    {
        // Retrieve anti-forgery token
        var antiForgeryToken = await _jsRuntime.InvokeAsync<string>("getAntiForgeryToken");

        if (string.IsNullOrEmpty(antiForgeryToken))
        {
            throw new Exception("Failed to retrieve anti-forgery token.");
        }

        // Set CSRF token header
        _httpClient.DefaultRequestHeaders.Add("X-CSRF-TOKEN", antiForgeryToken);

        // Send the POST request
        var response = await _httpClient.PostAsJsonAsync("api/user/login", loginModel);

        if (response.IsSuccessStatusCode)
        {
            var result = await response.Content.ReadFromJsonAsync<LoginResponseDto>();
            if (result != null && !string.IsNullOrEmpty(result.Token))
            {
                // Save the token in local storage
                await _jsRuntime.InvokeVoidAsync("localStorage.setItem", "authToken", result.Token);
                return result.Token;
            }
            throw new Exception("Invalid login response.");
        }

        var error = await response.Content.ReadAsStringAsync();
        throw new Exception($"Login failed: {error}");
    }
}