using System;

namespace Car_Management_Service.Models;

public class LocationHub
{
    public string Address{
        get { return Address; }
        set
        {
            Address = value;
        }    
    }
    public string City{
        get { return City; }
        set
        {
            City = value;
        }    
    }
    public int CityCode{
        get { return CityCode; }
        set
        {
            CityCode = value;
        }    
    }
    public char[] PhoneNr{
        get { return PhoneNr; }
        set
        {
            PhoneNr = value;
        }    
    }
    public string Email{
        get { return Email; }
        set
        {
            Email = value;
        }    
    }

    public List<Booking> Bookings{
        get { return Bookings; }
        set
        {
            Bookings = value;
        }    
    }
    public List<Vehicle> Vehicles{
        get { return Vehicles; }
        set
        {
            Vehicles = value;
        }    
    }   

}
