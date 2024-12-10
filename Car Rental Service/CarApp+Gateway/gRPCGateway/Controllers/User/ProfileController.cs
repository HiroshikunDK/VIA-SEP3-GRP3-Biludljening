using Microsoft.AspNetCore.Mvc;
using Shared.Dto;
using Userservice;

namespace gRPC_Gateway.Controllers.User;

[ApiController]
[Route("api/users/me")]
public class ProfileController : ControllerBase
{
    private readonly UserService.UserServiceClient _userClient;

    public ProfileController(UserService.UserServiceClient userClient)
    {
        _userClient = userClient;
    }

    [HttpGet]
    public async Task<IActionResult> GetCurrentUserProfile()
    {
        try
        {
            var userIdClaim = User.Claims.FirstOrDefault(c => c.Type == "id");

            if (userIdClaim == null || !int.TryParse(userIdClaim.Value, out int userId))
            {
                return Unauthorized(new { Message = "User ID claim is missing or invalid." });
            }

            var grpcRequest = new UserRequest { Id = userId };
            var grpcResponse = await _userClient.GetUserByIdAsync(grpcRequest);

            if (!grpcResponse.Success)
            {
                return NotFound(new { Message = "User not found." });
            }

            var userDto = new UpdateUserDto
            {
                UserFirstname = grpcResponse.User.UserFirstname,
                UserLastname = grpcResponse.User.UserLastname,
                Title = grpcResponse.User.Title,
                Email = grpcResponse.User.Email,
                Phonenr = grpcResponse.User.Phonenr,
                Username = grpcResponse.User.Username
            };

            return Ok(userDto);
        }
        catch (Exception ex)
        {
            return StatusCode(500, new { Message = "An unexpected error occurred.", Details = ex.Message });
        }
    }

    [HttpPut]
    public async Task<IActionResult> UpdateCurrentUserProfile([FromBody] UpdateUserDto request)
    {
        try
        {
            var username = User.Identity?.Name;

            if (username != request.Username)
            {
                return Forbid("You are not authorized to update this profile.");
            }

            var grpcRequest = new Userservice.User
            {
                UserFirstname = request.UserFirstname,
                UserLastname = request.UserLastname,
                Title = request.Title,
                Email = request.Email,
                Phonenr = request.Phonenr,
                Username = username,
                Password = string.IsNullOrWhiteSpace(request.Password) ? null : request.Password
            };

            var grpcResponse = await _userClient.UpdateUserAsync(grpcRequest);

            if (grpcResponse.Success)
            {
                return Ok(new { Message = grpcResponse.Message });
            }

            return BadRequest(new { Message = grpcResponse.Message });
        }
        catch (Exception ex)
        {
            return StatusCode(500, new { Message = "An unexpected error occurred.", Details = ex.Message });
        }
    }
}