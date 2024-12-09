using Shared.Dto;

namespace CarApp.Services.User
{
    public interface IUserProfileService
    {
        Task<UpdateUserDto> GetUserProfileAsync();
        Task UpdateUserProfileAsync(UpdateUserDto userProfile);
    }
}