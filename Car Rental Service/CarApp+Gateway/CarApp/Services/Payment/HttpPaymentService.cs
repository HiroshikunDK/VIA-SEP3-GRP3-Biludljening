using System.Text.Json;
using Shared.Dto;

namespace CarApp.Services;

public class HttpPaymentService : IPaymentService
{
    private readonly HttpClient _client;

    public HttpPaymentService(HttpClient client)
    {
        _client = client;
    }

    public async Task<PaymentResponseDto?> CreatePaymentAsync(PaymentDto payment)
    {
        HttpResponseMessage response = await _client.PostAsJsonAsync("api/Payment", payment);
        string responseContent = await response.Content.ReadAsStringAsync();

        if (!response.IsSuccessStatusCode)
        {
            throw new Exception($"Server Error: {response.StatusCode}. Content: {responseContent}");
        }

        return JsonSerializer.Deserialize<PaymentResponseDto>(responseContent, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        });
    }

    public async Task<PaymentResponseDto?> GetPaymentByIdAsync(int id)
    {
        HttpResponseMessage response = await _client.GetAsync($"api/Payment/{id}");
        string responseContent = await response.Content.ReadAsStringAsync();

        if (!response.IsSuccessStatusCode)
        {
            throw new Exception($"Server Error: {response.StatusCode}. Content: {responseContent}");
        }

        return JsonSerializer.Deserialize<PaymentResponseDto>(responseContent, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        });
    }
}