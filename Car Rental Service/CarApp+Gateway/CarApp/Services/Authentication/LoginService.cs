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
            
            var response = await client.PostAsJsonAsync("api/auth", loginModel);

            if (response.IsSuccessStatusCode)
            {
                var token = await response.Content.ReadAsStringAsync();
                
                await _jsRuntime.InvokeVoidAsync("localStorage.setItem", "authToken", token);

                return token;
            }

            var errorResponse = await response.Content.ReadAsStringAsync();
            throw new Exception($"Login failed: {errorResponse}");
        }
    }
}


