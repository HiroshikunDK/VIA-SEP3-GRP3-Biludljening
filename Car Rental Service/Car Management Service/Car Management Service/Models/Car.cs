namespace Car_Management_Service.Models;

public class Car
{
    public int Id { get; set; }
    public string Name { get; set; }
    public string Model { get; set; }
    public int Year { get; set; }
    public string Status {get; set;} // Indikation til om bilen er "Available eller Rented"
}
