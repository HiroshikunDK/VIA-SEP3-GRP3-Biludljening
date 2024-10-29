using Microsoft.EntityFrameworkCore;
using System.Threading.Tasks;
using Grpc.Core;
using User_Service.Database;
using UserManagementService;

public class UserServiceImp : UserService.UserServiceBase
{
    // Opretter en reference til UserDbContext, som bruges til databaseadgang
    private readonly UserDbContext _context;

    // Konstruktor, der initialiserer databasekonteksten
    public UserServiceImp(UserDbContext context)
    {
        _context = context;
    }

    // Override af ListUsers-metoden til at hente alle brugere asynkront
    public override async Task<UserList> ListUsers(Empty request, ServerCallContext context)
    {
        // Henter alle brugere fra databasen asynkront
        var users = await _context.users.ToListAsync();

        // Mapper databasebrugere til gRPC User-meddelelser
        var userList = new UserList();
        userList.Users.AddRange(users.Select(user => new User
        {
            Id = user.id,
            Username = user.userName,
            Email = user.email,
            Role = user.role
        }));

        return userList; // Returnerer den udfyldte UserList-svar
    }

    public override async Task<UserResponse> DeleteUser(UserRequest request, ServerCallContext context)
    {
        // Finder brugeren i databasen baseret på ID fra anmodningen
        var user = await _context.users.FindAsync(request.Id);
        
        // Hvis brugeren ikke findes, returnerer vi en fejlmeddelelse
        if (user == null)
        {
            return new UserResponse
            {
                Success = false,
                Message = "Bruger ikke fundet"
            };
        }
        // Fjerner brugeren fra databasen
        _context.users.Remove(user);
        await _context.SaveChangesAsync(); // Gemmer ændringer i databasen

        // Returnerer succesbesked
        return new UserResponse
        {
            Success = true,
            Message = "Bruger slettet succesfuldt"
        };
    }

    public override async Task<UserResponse> UpdateUser(User request, ServerCallContext context)
    {
        
       var user = _context.users.Find(request.Id);

       if (user == null)
       {
           return new UserResponse
           {
               Success = false,
               Message = "User not found"
           };
       }
      user.userName = request.Email;
      user.email = request.Email;
      user.role = request.Role;

      try
      {
          await _context.SaveChangesAsync();
          return new UserResponse
          {
              Success = true,
              Message = "User Updated"
          };
      }
      catch (Exception e)
      {
          return new UserResponse
          {
              Success = false,
              Message = $"Fejl under opdatering: {e.Message}"
          };
      }
      
    }

    /*
    public override async Task<UserResponse> GetUserById(UserRequest request, ServerCallContext context)
    {
        // Find the user by ID asynchronously
        var user = await _context.Users.FindAsync(request.Id);
    
        // Create a response variable
        var userResponse = new UserResponse();

        // Check if user exists
        if (user != null)
        {
            return new UserResponse
            {
                Success = true,
                Message = "Bruger  fundet",
                User = new User_Service.User
                {
                    userName = request.
                };
        }
        

       
    }

*/

    public override async Task<UserResponse> RegisterUser(User request, ServerCallContext context)
    {
        // gem koden i hash
        var hashedPassword = BCrypt.Net.BCrypt.HashPassword(request.Password);

        // oprettelse af ny yser
        var newUser = new User_Service.User
        {
            userName = request.Username,
            email = request.Email,
            role = request.Role,
            password = hashedPassword // Store the hashed password
        };

        // Add the new user to the database
        _context.users.Add(newUser);
        await _context.SaveChangesAsync();

        return new UserResponse
        {
            Success = true,
            Message = "Bruger registreret"
        };
    }

    public override async Task<LoginResponse> LoginUser(LoginRequest request, ServerCallContext context)
    {
        // Find  user med username
        var user = await _context.users.SingleOrDefaultAsync(u => u.userName == request.Username);
    
        // Check
        if (user != null && VerifyPassword(request.Password, user.password))
        {
            // oprettelse af token
            var token = GenerateToken(user); // Replace with actual token generation logic

            return new LoginResponse
            {
                Token = token
            };
        }

        // ikke fundet bruger
        return new LoginResponse
        {
            Token = null //  eller -  handle it according to your requirements
        };
    }

    private string GenerateToken(User_Service.User user)
    {
     return  "token";
    }

    private bool VerifyPassword(string enteredPassword, string storedPasswordHash)
    {
        // Brug en hashing-algoritme til at kontrollere, om den indtastede adgangskode matcher den gemte hash
        // Dette eksempel bruger fiktiv logik; tilpas til den hashing-algoritme, du bruger (f.eks. bcrypt, PBKDF2)
    
        // Hvis du bruger bcrypt:
        return BCrypt.Net.BCrypt.Verify(enteredPassword, storedPasswordHash);
    }
    
    

  
}
