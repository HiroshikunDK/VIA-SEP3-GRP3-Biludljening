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

            var result = new PaymentCreationResponseDto();

            if (!response.IsSuccessStatusCode)
            {
                // Try to parse error details from the response content
                var errorResponse = JsonSerializer.Deserialize<PaymentCreationResponseDto>(responseContent, new JsonSerializerOptions
                {
                    PropertyNameCaseInsensitive = true
                });

                if (errorResponse != null && errorResponse.Errors != null)
                {
                    result.Errors = errorResponse.Errors;
                    result.Message = errorResponse.Message ?? "Validation failed.";
                }
                else
                {
                    result.Errors = new List<string> { $"Server Error: {response.StatusCode}. Content: {responseContent}" };
                }

                return result; // Return the result with errors
            }

            // Deserialize success response
            result = JsonSerializer.Deserialize<PaymentCreationResponseDto>(responseContent, new JsonSerializerOptions
            {
                PropertyNameCaseInsensitive = true
            });

            Console.WriteLine($"Deserialized Payment Response: {JsonSerializer.Serialize(result)}");
            return result;
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error in CreatePaymentAsync: {ex.Message}");
            return new PaymentCreationResponseDto
            {
                Errors = new List<string> { $"An unexpected error occurred: {ex.Message}" }
            };
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