using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;
using Microsoft.IdentityModel.Tokens;
using User_Service.Models;

namespace User_Service.Helpers
{
    // Hjælper klasse for at genere JWT Tokens - bruges til at identificere brugere
    public static class JwtTokenHelper
    {
        // Secret key til at genere tokens (Burde være gemt sikkert, men lokalt projekt, nobody cares)
        private static readonly string SecretKey = "SEP3GREENCAR"; 
        private static readonly byte[] Key = Encoding.ASCII.GetBytes(SecretKey);

        // Generer en JWT token for en specifik bruger
        public static string GenerateJwtToken(User user)
        {
            var tokenHandler = new JwtSecurityTokenHandler();
            
            // Definere tokens krav, hvornår den udløber, og signeringsoplysninger 
            var tokenDescriptor = new SecurityTokenDescriptor
            {
                Subject = new ClaimsIdentity(new[]
                {
                    
                    // Tilføjer en bruger som krav
                    new Claim(ClaimTypes.Name, user.Username),
                    
                    // Tilføjer en rolle som krav
                    new Claim(ClaimTypes.Role, user.Role)
                }),
                
                // Sætter hvornår token udløber
                Expires = DateTime.UtcNow.AddHours(1),
                SigningCredentials = new SigningCredentials(new SymmetricSecurityKey(Key), SecurityAlgorithms.HmacSha256Signature)
            };
            
            // Opretter og returnere en JWT token
            var token = tokenHandler.CreateToken(tokenDescriptor);
            return tokenHandler.WriteToken(token);
        }
    }
}