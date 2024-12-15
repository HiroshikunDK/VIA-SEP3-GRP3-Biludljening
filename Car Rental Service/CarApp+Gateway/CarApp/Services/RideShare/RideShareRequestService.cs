using Shared.Dto;
using Shared.Dto.RideShare;

namespace CarApp.Services.RideShare
{
    public class RideShareRequestService
    {
        private readonly HttpClient _httpClient;

        public RideShareRequestService(IHttpClientFactory httpClientFactory)
        {
            _httpClient = httpClientFactory.CreateClient("AuthorizedClient");
        }

        // Get all ride share requests
        public async Task<RideShareRequestDto[]> GetAllRideShareRequestsAsync()
        {
            try
            {
                var response = await _httpClient.GetFromJsonAsync<RideShareRequestDto[]>("api/ridesharerequest");
                return response;
            }
            catch (Exception ex)
            {
                // Handle errors (log, notify user, etc.)
                throw new ApplicationException(ex.Message, ex);
            }
        }

        // Get a ride share request by ID
        public async Task<RideShareRequestDto> GetRideShareRequestByIdAsync(string rideId)
        {
            try
            {
                var response = await _httpClient.GetFromJsonAsync<RideShareRequestDto>($"api/ridesharerequest/{rideId}");
                if (response == null)
                {
                    throw new KeyNotFoundException($"Ride share request with ID {rideId} not found.");
                }
                return response;
            }
            catch (Exception ex)
            {
                // Handle errors (log, notify user, etc.)
                throw new ApplicationException(ex.Message, ex);
            }
        }

        // Create a new ride share request
        public async Task<bool> CreateRideShareRequestAsync(RideShareRequestDto request)
        {
            try
            {
                var response = await _httpClient.PostAsJsonAsync("api/ridesharerequest", request);
                return response.IsSuccessStatusCode;
            }
            catch (Exception ex)
            {
                // Handle errors (log, notify user, etc.)
                throw new ApplicationException(ex.Message, ex);
            }
        }

        // Update an existing ride share request
        public async Task<bool> UpdateRideShareRequestAsync(RideShareRequestDto request)
        {
            try
            {
                var response = await _httpClient.PutAsJsonAsync("api/ridesharerequest", request);
                return response.IsSuccessStatusCode;
            }
            catch (Exception ex)
            {
                // Handle errors (log, notify user, etc.)
                throw new ApplicationException(ex.Message, ex);
            }
        }

        // Delete a ride share request by ID
        public async Task<bool> DeleteRideShareRequestAsync(string rideId)
        {
            try
            {
                var response = await _httpClient.DeleteAsync($"api/ridesharerequest/{rideId}");
                return response.IsSuccessStatusCode;
            }
            catch (Exception ex)
            {
                // Handle errors (log, notify user, etc.)
                throw new ApplicationException(ex.Message, ex);
            }
        }
    }
}