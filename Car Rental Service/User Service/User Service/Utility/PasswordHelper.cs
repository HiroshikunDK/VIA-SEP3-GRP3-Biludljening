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
            using (var sha256 = SHA256.Create())
            {
                // Beregner hash metoden for password
                var hashedBytes = sha256.ComputeHash(Encoding.UTF8.GetBytes(password));
                
                // Konverterer hashen til en hexadecimal streng
                return BitConverter.ToString(hashedBytes).Replace("-", "").ToLower();
            }
        }

        // Verificere at det givne password matcher med den gemte hash
        public static bool VerifyPassword(string password, string passwordHash)
        {
            // Sammenligner input password med det gemte hash password
            var hashedPassword = HashPassword(password);
            return hashedPassword == passwordHash;
        }
    }
}