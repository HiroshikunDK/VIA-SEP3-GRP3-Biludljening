using Microsoft.EntityFrameworkCore;

namespace User_Service.Database;

// UserDbContext arver fra DbContext-klassen, som er en del af Entity Framework Core.
// DbContext fungerer som en session med databasen, som giver dig mulighed for at forespørge og gemme data.
public class UserDbContext : DbContext
{
    // UserDbContext-konstruktøren modtager DbContextOptions som parameter.
    // 'options' indeholder konfigurationsindstillinger for DbContext (f.eks. databaseforbindelse).
    // Base(options) sender 'options' videre til DbContext-basen, så de konfigurationer kan bruges.
    public UserDbContext(DbContextOptions<UserDbContext> options) : base(options) { }

    // DbSet<User> repræsenterer tabellen "Users" i databasen, hvor hver User-objekt vil svare til en række.
    // 'Users' kan bruges til at forespørge og ændre data i "Users"-tabellen.
    public DbSet<User> users { get; set; }
    
    
   
}