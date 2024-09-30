using Microsoft.EntityFrameworkCore;
using User_Service.Data;
using User_Service.Models;

namespace User_Service.Services 
{
    // Repository klasse for at udføre CRUD operationer på User.
    // Integrere med UserDatabase context for at håndtere brugerdata.
    public class UserRepository : IUserRepository
    {
        private readonly UserDatabase _context;
        
        // Constructor
        public UserRepository(UserDatabase context)
        {
            _context = context;
        }

        // Asynkont henter en bruger vha. dens ID fra databasen
        public async Task<User> GetUserByIdAsync(int id)
        {
            return await _context.Users.FindAsync(id);
        }

        // Asynkront henter en bruger vha. et brugernavn fra databasen
        public async Task<User> GetUserByUsernameAsync(string username)
        {
            return await _context.Users.FirstOrDefaultAsync(u => u.Username == username);
        }

        // Asynkront henter alle bruger fra databasen
        public async Task<List<User>> GetAllUsersAsync()
        {
            return await _context.Users.ToListAsync();
        }

        // Asynkront tilføjer en bruger til databasen
        public async Task AddUserAsync(User user)
        {
            _context.Users.Add(user);
            await _context.SaveChangesAsync();
        }

        // Asynkront opdatere en eksisterende bruger fra databasen
        public async Task UpdateUserAsync(User user)
        {
            _context.Entry(user).State = EntityState.Modified;
            await _context.SaveChangesAsync();
        }

        // Asynkront sletter en eksisterende bruger fra databasen
        public async Task DeleteUserAsync(int id)
        {
            var user = await _context.Users.FindAsync(id);
            if (user != null)
            {
                _context.Users.Remove(user);
                await _context.SaveChangesAsync();
            }
        }
    }
}