using Grpc.Core;
using User_Service.Services;
using User_Service.Helpers;
using UserManagementService;
using User = User_Service.Models.User;

public class UserService : UserManagementService.UserService.UserServiceBase
{
    private readonly IUserRepository _userRepository;

    public UserService(IUserRepository userRepository)
    {
        _userRepository = userRepository;
    }

    public override async Task<UserResponse> RegisterUser(UserRequest request, ServerCallContext context)
    {
        var existingUser = await _userRepository.GetUserByIdAsync(request.Id);
        if (existingUser != null)
        {
            throw new RpcException(new Status(StatusCode.AlreadyExists, "User with this ID already exists"));
        }

        var newUser = new User
        {
            Id = request.Id, 
            Username = "defaultUsername", 
            Email = "default@example.com",
            Password = PasswordHelper.HashPassword("defaultPassword"), 
            Role = "User"
        };

        await _userRepository.AddUserAsync(newUser);

        return new UserResponse { Success = true, Message = "User registered successfully" };
    }


    public override async Task<LoginResponse> LoginUser(LoginRequest request, ServerCallContext context)
    {
        var user = await _userRepository.GetUserByUsernameAsync(request.Username);
        if (user == null || !PasswordHelper.VerifyPassword(request.Password, user.Password))
        {
            throw new RpcException(new Status(StatusCode.Unauthenticated, "Invalid username or password"));
        }

        var token = JwtTokenHelper.GenerateJwtToken(user);
        return new LoginResponse { Token = token };
    }

}