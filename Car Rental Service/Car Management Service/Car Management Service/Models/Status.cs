using Car_Management_Service.Models;

/// The 'State' abstract class
public abstract class Status
    {
        public abstract void Handle(Booking context);
    }