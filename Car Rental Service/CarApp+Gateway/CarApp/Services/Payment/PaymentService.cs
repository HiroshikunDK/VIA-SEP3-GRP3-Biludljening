using System.Text.Json;
using Shared.Dto;
using Shared.Dto.Payment;

namespace CarApp.Services.Payment;

public class PaymentService : IPaymentService
{
    private readonly HttpClient _client;

    public PaymentService(IHttpClientFactory httpClientFactory)
    {
        _client = httpClientFactory.CreateClient("AuthorizedClient");
    }

    public async Task<PaymentCreationResponseDto?> CreatePaymentAsync(PaymentDto payment)
    {
        try
        {
            Console.WriteLine($"Sending Payment Request: {JsonSerializer.Serialize(payment)}");
            HttpResponseMessage response = await _client.PostAsJsonAsync("api/payment", payment);

            string responseContent = await response.Content.ReadAsStringAsync();
            Console.WriteLine($"API Response Content: {responseContent}");

            if (!response.IsSuccessStatusCode)
            {
                throw new Exception($"Server Error: {response.StatusCode}. Content: {responseContent}");
            }

            var result = JsonSerializer.Deserialize<PaymentCreationResponseDto>(responseContent, new JsonSerializerOptions
            {
                PropertyNameCaseInsensitive = true
            });

            Console.WriteLine($"Deserialized Payment Response: {JsonSerializer.Serialize(result)}");
            return result;
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error in CreatePaymentAsync: {ex.Message}");
            throw;
        }
    }


    public async Task<PaymentResponseDto?> GetPaymentByIdAsync(int id)
    {
        HttpResponseMessage response = await _client.GetAsync($"api/payment/{id}");
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