using Microsoft.AspNetCore.Mvc;
using Shared.Dto;
using Microsoft.AspNetCore.Authorization;

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
        // Set the role to "Customer" directly
        var grpcUser = new User()
        {
            Username = request.Username,
            Email = request.Email,
            Password = request.Password,
            Role = "Customer" 
        };
    
        var response = await _userClient.RegisterUserAsync(grpcUser);
    
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
    [Authorize(Roles = "Admin,Customer")]
    public async Task<IActionResult> GetUserById(int id)
    {
        var request = new UserRequest { Id = id };
        var response = await _userClient.GetUserByIdAsync(request);
        return Ok(response);
    }

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
}
