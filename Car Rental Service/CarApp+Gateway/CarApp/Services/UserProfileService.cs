﻿using Shared.Dto;

namespace CarApp.Services;

public class UserProfileService
{
    private readonly HttpClient _httpClient;

    public UserProfileService(IHttpClientFactory httpClientFactory)
    {
        _httpClient = httpClientFactory.CreateClient("AuthorizedClient");
    }

    public async Task<UpdateUserDTO> GetUserProfileAsync()
    {
        var response = await _httpClient.GetFromJsonAsync<UpdateUserDTO>("api/user/profile");
        if (response == null)
        {
            throw new Exception("Failed to fetch user profile.");
        }
        return response;
    }

    public async Task UpdateUserProfileAsync(UpdateUserDTO userProfile)
    {
        var response = await _httpClient.PutAsJsonAsync("api/user/profile", userProfile);
        if (!response.IsSuccessStatusCode)
        {
            var error = await response.Content.ReadAsStringAsync();
            throw new Exception($"Failed to update profile: {error}");
        }
    }
}