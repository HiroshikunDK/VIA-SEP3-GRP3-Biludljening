using Car_Management_Service.Models;

public class Reserved : Status
    {
        public override void Handle(Booking booking)
        {
            booking.Status = new Lent();
        }
    }