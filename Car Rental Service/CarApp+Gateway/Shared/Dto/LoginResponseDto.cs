namespace Shared.Dto;

public class LoginResponseDto {
    public string Token { get; set; }
    public string Role { get; set; }

    // Parameterless constructor (required for deserialization)
    public LoginResponseDto() { }

    // Optional: Constructor with parameters for convenience
    public LoginResponseDto(string token, string role) {
        Token = token;
        Role = role;
    }
}