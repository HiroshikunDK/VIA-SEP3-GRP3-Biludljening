using Grpc.Core;
using Microsoft.AspNetCore.Mvc;

namespace gRPC_Gateway.Controllers
{
    [ApiController]
    [Route("api/rideshareoffer")]
    public class RideShareOfferController : ControllerBase
    {
        private readonly RideShareService.RideShareServiceClient _rideShareClient;

        private RideShareOfferController(RideShareService.RideShareServiceClient rideShareClient)
        {
            _rideShareClient = rideShareClient;
        }

        [HttpPost("")]
        public async Task<IActionResult> CreateRideShareOffer([FromBody] RideshareOffer request)
        {
            try
            {
                if (request.Availablespaces < 1 || request.Availablespaces > 50)
                {
                    return StatusCode(406, "Available space is an invalid value");    
                }
                if (request.Price<0.00 || request.Price > 9999.99)
                {
                    return StatusCode(406, "Price is an invalid value");    
                }
                /*
                TODO: Date and Time exception handling should be implemented
                */
                // Validate date and time here, as mentioned in the TODO
                if (string.IsNullOrEmpty(request.Startdate) || 
                    string.IsNullOrEmpty(request.Starttime) || 
                    string.IsNullOrEmpty(request.Enddate) || 
                    string.IsNullOrEmpty(request.Endtime))
                {
                    return StatusCode(406, "Null input detected in temporal values in request");
                }

                
                var response = await _rideShareClient.CreateRideShareOfferAsync(request);
                if (!response.Success)
                {
                    throw new Exception(response.Message);
                }
                return Ok(response);
            }
            catch (RpcException rpcEx)
            {
                // Handle gRPC-specific errors
                Console.WriteLine($"gRPC Error: {rpcEx.Status.Detail}");
                return StatusCode((int)rpcEx.StatusCode, rpcEx.Status.Detail);
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
                //406 not acceptable: In this case, the format requested by the client cannot be issued by the server. The content type is available in the server response.
                return StatusCode(406,e.Message);
            }
            
        }

        [HttpGet("/{rideId}")]
        public async Task<IActionResult> GetRideShareOfferById(string rideId)
        {
            try
            {
                var request = new RideShareIDRequest { RideId = rideId };
                var response = await _rideShareClient.ReadRideShareOfferAsync(request);
                
                if (response == null || string.IsNullOrEmpty(response.RideId))
                {
                    return NotFound($"Ride offer with ID {rideId} not found.");
                }

                return Ok(response);
            }
            catch (RpcException rpcEx)
            {
                // Handle gRPC-specific errors
                return StatusCode((int)rpcEx.StatusCode, rpcEx.Status.Detail);
            }
            catch (Exception ex)
            {
                // Handle generic exceptions
                return StatusCode(500, "Internal server error: " + ex.Message);
            }
        }

        [HttpGet("")]
        public async Task<IActionResult> GetAllRideShareOffers()
        {
            try
            {
                var response = await _rideShareClient.ReadAllRideShareOfferAsync(new Google.Protobuf.WellKnownTypes.Empty());
                return Ok(response);
            }
            catch (RpcException rpcEx)
            {
                // Handle gRPC-specific errors
                return StatusCode((int)rpcEx.StatusCode, rpcEx.Status.Detail);
            }
            catch (Exception ex)
            {
                // Handle generic exceptions
                return StatusCode(500, "Internal server error: " + ex.Message);
            }
        }

        [HttpPut("")]
        public async Task<IActionResult> UpdateRideShareOffer([FromBody] RideshareOffer request)
        {
            try
            {
                var response = await _rideShareClient.UpdateRideShareOfferAsync(request);

                if (!response.Success)
                {
                    throw new Exception(response.Message);
                }

                return Ok(response);
            }
            catch (RpcException rpcEx)
            {
                // Handle gRPC-specific errors
                return StatusCode((int)rpcEx.StatusCode, rpcEx.Status.Detail);
            }
            catch (Exception ex)
            {
                // Handle generic exceptions
                return StatusCode(500, "Internal server error: " + ex.Message);
            }
        }

        [HttpDelete("/{rideId}")]
        public async Task<IActionResult> DeleteRideShareOffer(string rideId)
        {
            try
            {
                var request = new RideShareIDRequest { RideId = rideId };
                var response = await _rideShareClient.DeleteRideShareOfferAsync(request);

                if (!response.Success)
                {
                    return StatusCode(406, response.Message);
                }

                return Ok(response);
            }
            catch (RpcException rpcEx)
            {
                // Handle gRPC-specific errors
                return StatusCode((int)rpcEx.StatusCode, rpcEx.Status.Detail);
            }
            catch (Exception ex)
            {
                // Handle generic exceptions
                return StatusCode(500, "Internal server error: " + ex.Message);
            }
        }
        
        // Controller method for GetClosestRideShareRequest
        [HttpGet("/Closest")]
        public async Task<IActionResult> GetClosestRideShareRequest([FromBody] RideshareRequest request)
        {
            try
            {
                var response = await _rideShareClient.GetClosestRideShareRequestAsync(request);
                return Ok(response);
            }
            catch (RpcException rpcEx)
            {
                // Handle gRPC-specific errors
                return StatusCode((int)rpcEx.StatusCode, rpcEx.Status.Detail);
            }
            catch (Exception ex)
            {
                // Handle generic exceptions
                return StatusCode(500, "Internal server error: " + ex.Message);
            }
        }
        
        // Controller method for GetAllRideShareOffersByUserID
        [HttpGet("/ByUserId/{userId}")]
        public async Task<IActionResult> GetAllRideShareOffersByUserId(string userId)
        {
            try
            {
                var request = new RideShareIDRequest { RideId = userId };
                var response = await _rideShareClient.GetAllRideShareOffersByUserIDAsync(request);
                return Ok(response);
            }
            catch (RpcException rpcEx)
            {
                // Handle gRPC-specific errors
                return StatusCode((int)rpcEx.StatusCode, rpcEx.Status.Detail);
            }
            catch (Exception ex)
            {
                // Handle generic exceptions
                return StatusCode(500, "Internal server error: " + ex.Message);
            }
        }

        // Controller method for GetAllRideShareOffersByBookingID
        [HttpGet("/ByBookingId/{bookingId}")]
        public async Task<IActionResult> GetAllRideShareOffersByBookingId(string bookingId)
        {
            try
            {
                var request = new RideShareIDRequest { RideId = bookingId };
                var response = await _rideShareClient.GetAllRideShareOffersByBookingIDAsync(request);
                return Ok(response);
            }
            catch (RpcException rpcEx)
            {
                // Handle gRPC-specific errors
                return StatusCode((int)rpcEx.StatusCode, rpcEx.Status.Detail);
            }
            catch (Exception ex)
            {
                // Handle generic exceptions
                return StatusCode(500, "Internal server error: " + ex.Message);
            }
        }
        
    }
}