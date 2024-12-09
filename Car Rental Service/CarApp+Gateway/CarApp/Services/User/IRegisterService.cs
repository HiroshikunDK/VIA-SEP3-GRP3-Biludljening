using Shared.Dto;
using Shared.Dto.Authentication;

namespace CarApp.Services.User;

public interface IRegisterService
{
    Task RegisterAsync(RegisterUserRequestDto registerModel);
}