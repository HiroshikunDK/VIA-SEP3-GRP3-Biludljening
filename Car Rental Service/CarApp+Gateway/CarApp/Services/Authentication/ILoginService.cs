using Shared.Dto;

namespace CarApp.Services.User
{
    public interface ILoginService
    {
        Task<string> LoginAsync(LoginRequestDto loginModel);
    }
}