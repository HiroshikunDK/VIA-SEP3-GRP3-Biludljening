using User_Service.Models;

namespace User_Service.Services
{
    // Interface for UserRepository, og definere de forskellige CRUD operatione
    public interface IUserRepository
    {
        // Henter en bruger vha. deres ID
        Task<User> GetUserByIdAsync(int id);
        // Henter en bruger vha. deres brugernavn
        Task<User> GetUserByUsernameAsync(string username);
        // Henter en liste af alle brugere
        Task<List<User>> GetAllUsersAsync();
        // Tilføjer en ny bruger til repository
        Task AddUserAsync(User user);
        // Opdaterere en eksisterende bruger i repository
        Task UpdateUserAsync(User user);
        // Sletter en bruger fra repository med deres ID
        Task DeleteUserAsync(int id);
    }
}