using Shared.Dto;

namespace CarApp.Services.User
{
    public class UserProfileService : IUserProfileService
    {
        private readonly HttpClient _httpClient;

        public UserProfileService(IHttpClientFactory httpClientFactory)
        {
            _httpClient = httpClientFactory.CreateClient("AuthorizedClient");
        }

        public async Task<UpdateUserDto> GetUserProfileAsync()
        {
            // Updated endpoint to align with UserController changes
            var response = await _httpClient.GetAsync("api/users/me");

            if (response.IsSuccessStatusCode)
            {
                return await response.Content.ReadFromJsonAsync<UpdateUserDto>();
            }

            throw new Exception($"Failed to retrieve profile: {response.StatusCode} {await response.Content.ReadAsStringAsync()}");
        }

        public async Task UpdateUserProfileAsync(UpdateUserDto userProfile)
        {
            // Updated endpoint to align with UserController changes
            var response = await _httpClient.PutAsJsonAsync("api/users/me", userProfile);

            if (!response.IsSuccessStatusCode)
            {
                var error = await response.Content.ReadAsStringAsync();
                throw new Exception($"Failed to update profile: {error}");
            }
        }
    }
}