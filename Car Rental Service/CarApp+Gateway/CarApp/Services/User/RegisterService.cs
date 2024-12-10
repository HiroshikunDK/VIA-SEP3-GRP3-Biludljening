using Microsoft.JSInterop;
using Shared.Dto.Authentication;

namespace CarApp.Services.User;

public class RegisterService : IRegisterService
{
    private readonly HttpClient _httpClient;
    private readonly IJSRuntime _jsRuntime;

    public RegisterService(IHttpClientFactory httpClientFactory, IJSRuntime jsRuntime)
    {
        _httpClient = httpClientFactory.CreateClient("AuthorizedClient");
        _jsRuntime = jsRuntime;
    }

    public async Task RegisterAsync(RegisterUserRequestDto registerModel)
    {
        // Retrieve anti-forgery token
        var token = await _jsRuntime.InvokeAsync<string>("getAntiForgeryToken");

        if (string.IsNullOrEmpty(token))
        {
            throw new Exception("Failed to retrieve anti-forgery token.");
        }

        // Create and send the request to the updated endpoint
        var requestMessage = new HttpRequestMessage(HttpMethod.Post, "api/users") // Updated endpoint
        {
            Content = JsonContent.Create(registerModel)
        };
        requestMessage.Headers.Add("X-CSRF-TOKEN", token);

        var response = await _httpClient.SendAsync(requestMessage);

        if (!response.IsSuccessStatusCode)
        {
            var errorResponse = await response.Content.ReadAsStringAsync();
            throw new Exception($"Registration failed: {errorResponse}");
        }
    }
}