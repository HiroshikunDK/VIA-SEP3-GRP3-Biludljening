using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Userservice;

namespace gRPC_Gateway.Controllers.Auth;

[ApiController]
[Route("api/auth")]
public class AuthenticationController : ControllerBase
{
    private readonly UserService.UserServiceClient _userClient;

    public AuthenticationController(UserService.UserServiceClient userClient)
    {
        _userClient = userClient;
    }

    [HttpPost]
    [AllowAnonymous]
    public async Task<IActionResult> LoginUser([FromBody] LoginRequest request)
    {
        try
        {
            var response = await _userClient.LoginUserAsync(request);
            if (!string.IsNullOrEmpty(response.Token))
            {
                return Ok(response.Token);
            }
            return BadRequest(new { Message = "Invalid username or password." });
        }
        catch (Exception ex)
        {
            return StatusCode(500, new { Message = "An unexpected error occurred.", Details = ex.Message });
        }
    }
}