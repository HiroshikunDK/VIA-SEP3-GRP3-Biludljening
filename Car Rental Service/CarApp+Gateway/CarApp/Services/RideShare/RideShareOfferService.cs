using System.Net.Http;
using System.Net.Http.Json;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Components;
using Shared.Dto;

namespace CarApp.Services.RideShareOffer
{
    public class RideShareOfferService
    {
        private readonly HttpClient _httpClient;
        private readonly NavigationManager _navigationManager;

        public RideShareOfferService(HttpClient httpClient,  NavigationManager navigationManager)
        {
            _httpClient = httpClient;
            _navigationManager = navigationManager;
        }


        public void RedirectToCreateRideShareOffer()
        {
            _navigationManager.NavigateTo("");
        }

        // Get all RideShareOffers
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

        // Get a Ride ShareOffer by ID
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
                throw new ApplicationException(ex.Message, ex);
            }
        }

        // Create a new Ride ShareOffer
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
                throw new ApplicationException(ex.Message, ex);
            }
        }

        // Update an existing RideShareOffer
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
                throw new ApplicationException(ex.Message, ex);
            }
        }

        // Delete a RideShareOffer by ID
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
                throw new ApplicationException(ex.Message, ex);
            }
        }
    }
}