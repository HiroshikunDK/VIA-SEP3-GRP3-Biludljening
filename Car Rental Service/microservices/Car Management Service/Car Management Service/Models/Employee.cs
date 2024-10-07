using System;

namespace Car_Management_Service.Models;

public class Employee
{
    public int employeeNr;
    public string userName;
    public string password;
    public string firstName;
    public string lastName;
    public string email;
    public char[] phoneNr;

    public int EmployeeNr{
        get { return EmployeeNr; }
        set
        {
            EmployeeNr = value;
        }    
    }
    public string UserName{
        get { return UserName; }
        set
        {
            UserName = value;
        }    
    }
    public string Password{
        get { return Password; }
        set
        {
            Password = value;
        }    
    }
    public string FirstName{
        get { return FirstName; }
        set
        {
            FirstName = value;
        }    
    }
    public string LastName{
        get { return LastName; }
        set
        {
            LastName = value;
        }    
    }
    public string Email{
        get { return Email; }
        set
        {
            Email = value;
        }    
    }

    public char[] PhoneNr{
        get { return PhoneNr; }
        set
        {
            PhoneNr = value;
        }    
    }
}
