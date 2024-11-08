namespace Shared.Dto
{
    public class LoginResponseDto
    {
        public string Token { get; set; }
        public string Role { get; set; }
        public bool Success { get; set; }
        public string Message { get; set; }
    }
}