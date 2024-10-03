using System;

namespace Car_Management_Service.Models;

public class Vehicle
{
    public int Id { get; set; }
    public char[] VIN { get; set; }
    public int Seats { get; set; }
    public string Model { get; set; }
    public string Color { get; set; }
    public int Year { get; set; }
    public string LicensePlate { get; set; }
    public int Kilometer { get; set; }
    public double Fuel {get; set;} 

}
