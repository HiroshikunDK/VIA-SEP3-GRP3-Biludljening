using Grpc.Core;
using Microsoft.AspNetCore.Mvc;

namespace gRPC_Gateway.Controllers
{
    [ApiController]
    [Route("api/ridesharerequest")]
    public class RideShareRequestController : ControllerBase
    {
        private readonly RideShareService.RideShareServiceClient _rideShareClient;

        private RideShareRequestController(RideShareService.RideShareServiceClient rideShareClient)
        {
            _rideShareClient = rideShareClient;
        }

        [HttpPost("")]
        public async Task<IActionResult> CreateRideShareRequest([FromBody] RideshareRequest request)
        {
            try
            {
                // Exception handling for member data validation
                // TODO: Maybe delete this as controller might be interpreting this as null at compile time and always throw exception 
                if (request == null)
                {
                    return BadRequest("Request body cannot be null.");
                }
                
                // Price validation (if relevant for request)
                if (request.Price < 0.00 || request.Price > 9999.99)
                {
                    return StatusCode(406, "Price is an invalid value.");
                }


                // Example: Validate Date and Time if these fields are present
                if (string.IsNullOrEmpty(request.Startdate) || 
                    string.IsNullOrEmpty(request.Starttime) || 
                    string.IsNullOrEmpty(request.Enddate) || 
                    string.IsNullOrEmpty(request.Endtime))
                {
                    return StatusCode(406, "Null input detected in temporal values in request.");
                }

                // Make the gRPC call
                var response = await _rideShareClient.CreateRideShareRequestAsync(request);
                
                // Check for response failure
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
                // Handle generic exceptions
                Console.WriteLine(e.Message);
                return StatusCode(500, "Internal server error: " + e.Message);
            }
        }

        [HttpGet("/{rideId}")]
        public async Task<IActionResult> GetRideShareRequestById(string rideId)
        {
            try
            {
                var request = new RideShareIDRequest { RideId = rideId };
                var response = await _rideShareClient.ReadRideShareRequestAsync(request);
                
                //No input validation as the server should hold valid data 
                if (response == null || string.IsNullOrEmpty(response.RideId))
                {
                    return NotFound($"Ride share request with ID {rideId} not found.");
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
        public async Task<IActionResult> GetAllRideShareRequests()
        {
            try
            {
                var response = await _rideShareClient.ReadAllRideShareRequestAsync(new Google.Protobuf.WellKnownTypes.Empty());
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
        public async Task<IActionResult> UpdateRideShareRequest([FromBody] RideshareRequest request)
        {
            try
            {
                // Exception handling for member data validation
                if (request == null)
                {
                    return BadRequest("Request body cannot be null.");
                }

                // Example validation for price
                if (request.Price < 0.00 || request.Price > 9999.99)
                {
                    return StatusCode(406, "Price is an invalid value.");
                }
                // 
                /* TODO: Add authorization handling for changing the price -  can only be done by admin 
                if (request.Price < 0.00 || request.Price > 9999.99)
                {
                    return StatusCode(406, "Price is an invalid value.");
                }*/

                // Add additional validation for request data members here
                if (string.IsNullOrEmpty(request.Startdate) || 
                    string.IsNullOrEmpty(request.Starttime) || 
                    string.IsNullOrEmpty(request.Enddate) || 
                    string.IsNullOrEmpty(request.Endtime))
                {
                    return StatusCode(406, "Null input detected in temporal values in request.");
                }

                var response = await _rideShareClient.UpdateRideShareRequestAsync(request);
                
                // Check if the response indicates failure
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
