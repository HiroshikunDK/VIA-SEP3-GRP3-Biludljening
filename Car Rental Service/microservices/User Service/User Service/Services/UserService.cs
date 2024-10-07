using Grpc.Core;
using User_Service.Services;
using User_Service.Helpers;
using User_Service.Repositories.Interfaces;
using UserManagementService;
using User = User_Service.Models.User;

// gRPC Metoder til at håndtere User entities
// Giver metoder til at lave CRUD operationer via gRPC
public class UserService : UserManagementService.UserService.UserServiceBase
{
    private readonly IUserRepository _userRepository;

    // Constructor
    public UserService(IUserRepository userRepository)
    {
        _userRepository = userRepository;
    }

    // Registrer en ny bruger, og returnere et gRPC respons
    public override async Task<UserResponse> RegisterUser(UserRequest request, ServerCallContext context)
    {
        
        // Tjekker om en bruger med X ID allerede eksisterer
        var existingUser = await _userRepository.GetUserByIdAsync(request.Id);
        if (existingUser != null)
        {
            throw new RpcException(new Status(StatusCode.AlreadyExists, "User with this ID already exists"));
        }

        // Opretter en ny bruger med default værdier
        var newUser = new User
        {
            Id = request.Id, 
            Username = "defaultUsername", 
            Email = "default@example.com",
            Password = PasswordHelper.HashPassword("defaultPassword"), 
            Role = "User"
        };

        // Tilføjer den nye bruger til repository
        await _userRepository.AddUserAsync(newUser);

        // Returnerer en succesfuld registrerings respons
        return new UserResponse { Success = true, Message = "User registered successfully" };
    }


    // Håndterer Bruger login og returnere en JWT token hvis den er succesfuld
    public override async Task<LoginResponse> LoginUser(LoginRequest request, ServerCallContext context)
    {
        // Henter bruger vha. brugernavn
        var user = await _userRepository.GetUserByUsernameAsync(request.Username);
        // Verificere brugerens kodeord
        if (user == null || !PasswordHelper.VerifyPassword(request.Password, user.Password))
        {
            throw new RpcException(new Status(StatusCode.Unauthenticated, "Invalid username or password"));
        }

        // Generer en JWT token for at authenticere brugeren
        var token = JwtTokenHelper.GenerateJwtToken(user);
        
        // Returnere et login respons med JWT token
        return new LoginResponse { Token = token };
    }

}