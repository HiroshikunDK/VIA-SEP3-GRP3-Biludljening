using Car_Management_Service.Models;
public class Lent : Status
    {
        public override void Handle(Booking booking)
        {
            booking.Status = new Complete();
        }
    }