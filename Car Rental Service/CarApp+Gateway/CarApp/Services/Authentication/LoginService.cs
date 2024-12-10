using Microsoft.JSInterop;
using Shared.Dto.Authentication;

namespace CarApp.Services.Authentication
{
    public class LoginService : ILoginService
    {
        private readonly IHttpClientFactory _httpClientFactory;
        private readonly IJSRuntime _jsRuntime;

        public LoginService(IHttpClientFactory httpClientFactory, IJSRuntime jsRuntime)
        {
            _httpClientFactory = httpClientFactory;
            _jsRuntime = jsRuntime;
        }

        public async Task<string> LoginAsync(LoginRequestDto loginModel)
        {
            var client = _httpClientFactory.CreateClient("AuthorizedClient");

            // Updated endpoint for login
            var response = await client.PostAsJsonAsync("api/auth/login", loginModel);

            if (response.IsSuccessStatusCode)
            {
                var token = await response.Content.ReadAsStringAsync();
                Console.WriteLine($"Token received: {token}");
        
                // Store the token in local storage
                await _jsRuntime.InvokeVoidAsync("localStorage.setItem", "authToken", token);

                // Verify the token is stored
                var storedToken = await _jsRuntime.InvokeAsync<string>("localStorage.getItem", "authToken");
                Console.WriteLine($"Token stored in localStorage: {storedToken}");

                return token;
            }

            var errorResponse = await response.Content.ReadAsStringAsync();
            throw new Exception($"Login failed: {errorResponse}");
        }
    }
}