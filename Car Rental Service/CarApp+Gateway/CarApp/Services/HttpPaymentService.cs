using System.Text.Json;
using Shared.Dto;

namespace CarApp.Services;

public class HttpPaymentService : IPaymentService
{
    private HttpClient client;

    public HttpPaymentService(HttpClient client)
    {
        this.client = client;
    }

    public async Task<PaymentResponseDto?> createPaymentAsync(CreatePaymentRequestDto request)
    {
      HttpResponseMessage httpResponse =  await client.PostAsJsonAsync("api/Payment", request);
      string response = await httpResponse.Content.ReadAsStringAsync();

      if (!httpResponse.IsSuccessStatusCode)
      {
          throw new Exception($"Server Error: {httpResponse.StatusCode}. Content: {response}");
      }
      return JsonSerializer.Deserialize<PaymentResponseDto>(response, new JsonSerializerOptions
      {
          PropertyNameCaseInsensitive = true // Tillad case-insensitive match for JSON-felter
      })!;
      
    }
    public async Task<PaymentResponseDto?> GetPaymentByIdAsync(int id)
    {
       HttpResponseMessage httpResponse = await client.GetAsync($"api/Payment/{id}");
       string response = await httpResponse.Content.ReadAsStringAsync();

       if (!httpResponse.IsSuccessStatusCode)
       {
           throw new Exception($"Server Error: {httpResponse.StatusCode}. Content: {response}");
       }

       return JsonSerializer.Deserialize<PaymentResponseDto>(response,
           new JsonSerializerOptions
           {
               PropertyNameCaseInsensitive = true
           })!;
    }

    public async Task DeletePaymentByIdAsync(int id)
    {
       HttpResponseMessage httpResponse = await client.DeleteAsync($"api/Payment/{id}");
       string response = await httpResponse.Content.ReadAsStringAsync();

       if (!httpResponse.IsSuccessStatusCode)
       {
           throw new Exception($"Server Error: {httpResponse.StatusCode}. Content: {response}");
       }
    }

    public async Task UpdatePaymentAsync(int id, CreatePaymentRequestDto request)
    {
        HttpResponseMessage httpResponseMessage = await client.PutAsJsonAsync($"api/Payment/{id}", request);
        string response = await httpResponseMessage.Content.ReadAsStringAsync();
        if (!httpResponseMessage.IsSuccessStatusCode)
        {
            throw new Exception($"Server Error: {httpResponseMessage.StatusCode}. Content: {response}");
        }
    }
}