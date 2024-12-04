namespace Shared.Dto;

public class AddCarResponseDTO
{
    public bool Success { get; set; }
    public string Message { get; set; }
    public object? Car { get; set; } // This can be a specific CarDto if needed
}