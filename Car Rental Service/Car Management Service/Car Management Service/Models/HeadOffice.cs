using System;

namespace Car_Management_Service.Models;

public class HeadOffice
{
    public string address;
    public string city;
    public int cityCode;
    public char[] phoneNr;
    public string email;

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
    public string PhoneNr{
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
