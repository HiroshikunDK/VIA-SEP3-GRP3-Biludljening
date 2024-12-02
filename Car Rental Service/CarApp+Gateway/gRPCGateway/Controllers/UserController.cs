﻿using Microsoft.AspNetCore.Mvc;
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
    
    [HttpGet("profile")] 
public async Task<IActionResult> GetCurrentUserProfile()
{
    try
    {
        var username = User.Identity?.Name;

        var grpcRequest = new UserRequest { Username = username };
        var grpcResponse = await _userClient.GetUserByUsernameAsync(grpcRequest);

        if (!grpcResponse.Success)
        {
            return NotFound(new { Message = "User not found." });
        }

        var userDto = new UpdateUserDTO
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

[HttpPut("profile")]
public async Task<IActionResult> UpdateCurrentUserProfile([FromBody] UpdateUserDTO request)
{
    try
    {
        var username = User.Identity?.Name;

        // Ensure that the user can only update their own profile
        if (username != request.Username)
        {
            return Forbid("You are not authorized to update this profile.");
        }

        var grpcRequest = new User
        {
            UserFirstname = request.UserFirstname,
            UserLastname = request.UserLastname,
            Title = request.Title,
            Email = request.Email,
            Phonenr = request.Phonenr,
            Username = username,
            Password = string.IsNullOrWhiteSpace(request.Password)
                ? null
                : request.Password // Optional password update
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