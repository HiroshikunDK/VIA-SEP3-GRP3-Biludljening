namespace Shared.Dto;

public class UpdateUserDto
{
    public string UserFirstname { get; set; }
    public string UserLastname { get; set; }
    public string Title { get; set; }
    public string Email { get; set; }
    public int Phonenr { get; set; }
    public string Username { get; set; }
    public string Password { get; set; }
}