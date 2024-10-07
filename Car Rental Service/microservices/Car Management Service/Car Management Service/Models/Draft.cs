using Car_Management_Service.Models;

public class Draft : Status
    {
        public override void Handle(Booking booking)
        {
            booking.Status = new Reserved();
        }
    }