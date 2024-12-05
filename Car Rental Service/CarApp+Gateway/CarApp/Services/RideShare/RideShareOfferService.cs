using System.Net.Http;
using System.Net.Http.Json;
using System.Threading.Tasks;
using Shared.Dto;

namespace CarApp.Services.RideShareOffer
{
    public class RideShareOfferService
    {
        private readonly HttpClient _httpClient;

        RideShareOfferService(HttpClient httpClient)
        {
            _httpClient = httpClient;
        }

        // Get all ride share offers
        public async Task<RideShareOfferDto[]> GetAllRideShareOffersAsync()
        {
            try
            {
                var response = await _httpClient.GetFromJsonAsync<RideShareOfferDto[]>("api/rideshareoffer");
                return response;
            }
            catch (Exception ex)
            {
                // Handle errors (log, notify user, etc.)
                throw new ApplicationException("An error occurred while fetching ride share offers.", ex);
            }
        }

        // Get a ride share offer by ID
        public async Task<RideShareOfferDto> GetRideShareOfferByIdAsync(string rideId)
        {
            try
            {
                var response = await _httpClient.GetFromJsonAsync<RideShareOfferDto>($"api/rideshareoffer/{rideId}");
                if (response == null)
                {
                    throw new KeyNotFoundException($"Ride share offer with ID {rideId} not found.");
                }
                return response;
            }
            catch (Exception ex)
            {
                // Handle errors (log, notify user, etc.)
                throw new ApplicationException($"An error occurred while fetching ride share offer with ID {rideId}.", ex);
            }
        }

        // Create a new ride share offer
        public async Task<bool> CreateRideShareOfferAsync(RideShareOfferDto offer)
        {
            try
            {
                var response = await _httpClient.PostAsJsonAsync("api/rideshareoffer", offer);
                return response.IsSuccessStatusCode;
            }
            catch (Exception ex)
            {
                // Handle errors (log, notify user, etc.)
                throw new ApplicationException("An error occurred while creating the ride share offer.", ex);
            }
        }

        // Update an existing ride share offer
        public async Task<bool> UpdateRideShareOfferAsync(RideShareOfferDto offer)
        {
            try
            {
                var response = await _httpClient.PutAsJsonAsync("api/rideshareoffer", offer);
                return response.IsSuccessStatusCode;
            }
            catch (Exception ex)
            {
                // Handle errors (log, notify user, etc.)
                throw new ApplicationException("An error occurred while updating the ride share offer.", ex);
            }
        }

        // Delete a ride share offer by ID
        public async Task<bool> DeleteRideShareOfferAsync(string rideId)
        {
            try
            {
                var response = await _httpClient.DeleteAsync($"api/rideshareoffer/{rideId}");
                return response.IsSuccessStatusCode;
            }
            catch (Exception ex)
            {
                // Handle errors (log, notify user, etc.)
                throw new ApplicationException($"An error occurred while deleting the ride share offer with ID {rideId}.", ex);
            }
        }
    }
}