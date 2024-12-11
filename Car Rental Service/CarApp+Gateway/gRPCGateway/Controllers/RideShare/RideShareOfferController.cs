using Grpc.Core;
using Microsoft.AspNetCore.Mvc;

namespace gRPC_Gateway.Controllers.RideShare
{
    [ApiController]
    [Route("api/rideshare/offers")]
    public class RideShareOfferController : ControllerBase
    {
        private readonly RideShareService.RideShareServiceClient _rideShareClient;

        public RideShareOfferController(RideShareService.RideShareServiceClient rideShareClient)
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

                if (request.Price < 0.00 || request.Price > 9999.99)
                {
                    return StatusCode(406, "Price is an invalid value");
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
                return StatusCode((int)rpcEx.StatusCode, rpcEx.Status.Detail);
            }
            catch (Exception e)
            {
                return StatusCode(500, "Internal server error: " + e.Message);
            }
        }

        [HttpGet("{rideId}")]
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
                return StatusCode((int)rpcEx.StatusCode, rpcEx.Status.Detail);
            }
            catch (Exception ex)
            {
                return StatusCode(500, "Internal server error: " + ex.Message);
            }
        }

        [HttpGet("all")]
        public async Task<IActionResult> GetAllRideShareOffers()
        {
            try
            {
                var response = await _rideShareClient.ReadAllRideShareOfferAsync(new Google.Protobuf.WellKnownTypes.Empty());
                return Ok(response);
            }
            catch (RpcException rpcEx)
            {
                return StatusCode((int)rpcEx.StatusCode, rpcEx.Status.Detail);
            }
            catch (Exception ex)
            {
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
                return StatusCode((int)rpcEx.StatusCode, rpcEx.Status.Detail);
            }
            catch (Exception ex)
            {
                return StatusCode(500, "Internal server error: " + ex.Message);
            }
        }

        [HttpDelete("{rideId}")]
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
                return StatusCode((int)rpcEx.StatusCode, rpcEx.Status.Detail);
            }
            catch (Exception ex)
            {
                return StatusCode(500, "Internal server error: " + ex.Message);
            }
        }
    }
}
