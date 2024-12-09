using Grpc.Core;
using Microsoft.AspNetCore.Mvc;

namespace gRPC_Gateway.Controllers.RideShare
{
    [ApiController]
    [Route("api/rideshare/requests")]
    public class RideShareRequestController : ControllerBase
    {
        private readonly RideShareService.RideShareServiceClient _rideShareClient;

        public RideShareRequestController(RideShareService.RideShareServiceClient rideShareClient)
        {
            _rideShareClient = rideShareClient;
        }

        [HttpPost("")]
        public async Task<IActionResult> CreateRideShareRequest([FromBody] RideshareRequest request)
        {
            try
            {
                if (request == null)
                {
                    return BadRequest("Request body cannot be null.");
                }

                if (request.Price < 0.00 || request.Price > 9999.99)
                {
                    return StatusCode(406, "Price is an invalid value.");
                }

                var response = await _rideShareClient.CreateRideShareRequestAsync(request);

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
        public async Task<IActionResult> GetRideShareRequestById(string rideId)
        {
            try
            {
                var request = new RideShareIDRequest { RideId = rideId };
                var response = await _rideShareClient.ReadRideShareRequestAsync(request);

                if (response == null || string.IsNullOrEmpty(response.RideId))
                {
                    return NotFound($"Ride share request with ID {rideId} not found.");
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
        public async Task<IActionResult> GetAllRideShareRequests()
        {
            try
            {
                var response = await _rideShareClient.ReadAllRideShareRequestAsync(new Google.Protobuf.WellKnownTypes.Empty());
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
        public async Task<IActionResult> UpdateRideShareRequest([FromBody] RideshareRequest request)
        {
            try
            {
                if (request == null)
                {
                    return BadRequest("Request body cannot be null.");
                }

                var response = await _rideShareClient.UpdateRideShareRequestAsync(request);

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
        public async Task<IActionResult> DeleteRideShareRequest(string rideId)
        {
            try
            {
                var request = new RideShareIDRequest { RideId = rideId };
                var response = await _rideShareClient.DeleteRideShareRequestAsync(request);

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
