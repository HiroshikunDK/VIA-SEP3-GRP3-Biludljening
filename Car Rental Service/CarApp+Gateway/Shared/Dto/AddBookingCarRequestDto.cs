namespace Shared.Dto;

public class AddBookingCarRequestDto
{
        
        public string Status { get; set; }
        public string Startdato { get; set; }
        public string Starttime { get; set; }
        public string Enddate { get; set; }
        public string Endtime { get; set; }
        public string Price { get; set; }
        public int Greenshare { get; set; }
        public int Carid { get; set; }
        public int Customerid { get; set; }

}