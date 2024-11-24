using Microsoft.AspNetCore.Mvc;
using Shared.Dto;
using Microsoft.AspNetCore.Authorization;
using Userservice;

namespace gRPC_Gateway.Controllers;

[ApiController]
[Route("api/user")]
public class UserController : ControllerBase
{
    private readonly UserService.UserServiceClient _userClient;

    public UserController(UserService.UserServiceClient userClient)
    {
        _userClient = userClient;
    }

    [HttpPost("register")]
    [AllowAnonymous]
    public async Task<IActionResult> RegisterUser([FromBody] RegisterUserRequestDto request)
    {
        // Brug den korrekte protokollbesked
        var grpcRequest = new RegisterUserRequest()
        {
            UserFirstname = request.UserFirstname,
            UserLastname = request.UserLastname,
            Title = request.Title,
            Email = request.Email,
            Phonenr = request.Phonenr,
            Username = request.Username,
            Password = request.Password,
            Role = "Customer"
        };

        var response = await _userClient.RegisterUserAsync(grpcRequest);

        return Ok(new { response.Message, response.Success });
    }



    [HttpPost("login")]
    [AllowAnonymous] 
    public async Task<IActionResult> LoginUser([FromBody] LoginRequest request)
    {
        var response = await _userClient.LoginUserAsync(request);
        return Ok(response);
    }

    [HttpGet("{id}")]
    public async Task<IActionResult> GetUserById(int id)
    {
        var request = new UserRequest { Id = id };
        var response = await _userClient.GetUserByIdAsync(request);
        return Ok(response);
    }

    /*
    [HttpPut("update")]
    [Authorize(Roles = "Admin")] 
    public async Task<IActionResult> UpdateUser([FromBody] User request)
    {
        var response = await _userClient.UpdateUserAsync(request);
        return Ok(response);
    }

    [HttpDelete("{id}")]
    [Authorize(Roles = "Admin")] 
    public async Task<IActionResult> DeleteUser(int id)
    {
        var request = new UserRequest { Id = id };
        var response = await _userClient.DeleteUserAsync(request);
        return Ok(response);
    }
    */
}
