using Shared.Dto;

namespace CarApp.Services.User;

public interface IRegisterService
{
    Task RegisterAsync(RegisterUserRequestDto registerModel);
}