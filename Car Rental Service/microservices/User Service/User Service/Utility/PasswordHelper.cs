using System.Security.Cryptography;
using System.Text;

namespace User_Service.Helpers
{
    // En hjælper klasse til at håndtere password operationer
    public static class PasswordHelper
    {
        // Hasher et plain text password med SHA256 -- Kan udskiftes til BCrypt, der er bedre
        public static string HashPassword(string password)
        {
            return BCrypt.Net.BCrypt.HashPassword(password);
        }

        // Verificere at det givne password matcher med den gemte hash
        public static bool VerifyPassword(string password, string passwordHash)
        {
            // Sammenligner input password med det gemte hash password
            return BCrypt.Net.BCrypt.Verify(password, passwordHash);
        }
    }
}