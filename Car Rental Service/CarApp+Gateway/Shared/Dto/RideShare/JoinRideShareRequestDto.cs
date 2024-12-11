namespace Shared.Dto.RideShare
{
    public class JoinRideShareRequestDto
    {
        public int RideId { get; set; } // Matches the RideId in the gRPC message
        public string PassengerUsername { get; set; } // Matches the PassengerUsername in the gRPC message
    }
}