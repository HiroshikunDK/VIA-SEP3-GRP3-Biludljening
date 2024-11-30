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
        try
        {
            var grpcRequest = new RegisterUserRequest
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

            if (response.Success)
            {
                return Ok(new { response.Message });
            }
            else
            {
                return BadRequest(new { response.Message });
            }
        }
        catch (Exception ex)
        {
            return StatusCode(500, new { Message = "An unexpected error occurred.", Details = ex.Message });
        }
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

    
    [HttpPut("updateUser")]
    public async Task<IActionResult> UpdateUser([FromBody] User request)
    {
        try
        {
            var grpcResponse = await _userClient.UpdateUserAsync(new User()
            {
                UserFirstname = request.UserFirstname,
                UserLastname = request.UserLastname,
                Title = request.Title,
                Email = request.Email,
                Phonenr = request.Phonenr,
                Username = request.Username,
                Password = request.Password,
            });

            if (grpcResponse.Success)
            {
                return Ok(new { Message = grpcResponse.Message });
            }
            else
            {
                return BadRequest(new { Message = grpcResponse.Message });
            }
        }
        catch (Exception ex)
        {
            return StatusCode(500, new { Message = "An unexpected error occurred.", Details = ex.Message });
        }
    }

    
    [HttpDelete("{id}")]
    [Authorize(Roles = "Admin")]
    public async Task<IActionResult> DeleteUser(int id)
    {
        var request = new UserRequest { Id = id };
    
        var response = await _userClient.DeleteUserAsync(request);

        if (response == null)
        {
            return BadRequest("Failed to delete user.");
        }

        return Ok(response);
    }


    
    
}
