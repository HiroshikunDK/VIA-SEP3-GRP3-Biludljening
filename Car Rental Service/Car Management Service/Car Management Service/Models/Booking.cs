using System;

namespace Car_Management_Service.Models;

public class Booking
{

    //State Design pattern
    Status status;
    DateTime bookingStartTime;
    DateTime bookingEndTime;
    bool rideSharing;
    Double Price;


    // Constructor
    public Booking(Status status)
    {
        this.status = status;
    }
    
    // Gets or sets the state
    // Use reverse of the  
    public Status Status
    {
        get { return Status; }
        set
        {
            Status = value;
            Console.WriteLine("State: " + Status.GetType().Name);
        }
    }

    public DateTime BookingStartTime
    {
        get{return BookingStartTime;}
        set { 
            
            //If BookingStartTime is before the current time
            if(DateTime.Now > BookingStartTime){
                throw new ArgumentException("Warning Start Booking time is before the currentTime ");
            }

            //if end time is before start time 
            if(bookingEndTime < BookingStartTime){
                throw new ArgumentException("Error: Booking end time is before start time ");
            }
            BookingStartTime = value; 
        }
    }

    public DateTime BookingEndTime
    {
        get{return BookingEndTime;}
        set {
            //if current 
            if(DateTime.Now > BookingEndTime){
                throw new ArgumentException("Warning end Booking time is before the currentTime ");
            }

            //if end time is before start time 
            if(bookingEndTime < BookingStartTime){
                throw new ArgumentException("Error: Booking end time is before start time");
            } 
            BookingEndTime = value; 
        }
    }

    //Functions
    public void Request()
    {
        Status.Handle(this);
    }

}
