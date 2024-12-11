using Shared.Dto;
using Shared.Dto.Authentication;

namespace CarApp.Services.Authentication
{
    public interface ILoginService
    {
        Task<string> LoginAsync(LoginRequestDto loginModel);
    }
}