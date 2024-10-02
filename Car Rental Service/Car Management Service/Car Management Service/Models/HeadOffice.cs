using System;

namespace Car_Management_Service.Models;

public class HeadOffice
{
    public List<LocationHub> Locations{ 
        get{ return Locations; }
        set
        {
            Locations = value;
        }    
    }
    public List<Customer> Customers{ 
        get{ return Customers; }
        set
        {
            Customers = value;
        }    
    }
    public List<Employee> Employees{ 
        get{ return Employees; }
        set
        {
            Employees = value;
        }    
    }

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
}
