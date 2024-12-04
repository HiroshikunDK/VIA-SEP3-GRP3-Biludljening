using Microsoft.AspNetCore.Mvc;
using Shared.Dto;

namespace gRPC_Gateway.Controllers;

[ApiController]
[Route("api/rideshare")]
public class RideshareController : ControllerBase
{
    private readonly RideShareService.RideShareServiceClient _rideshareClient;

    public RideshareController(RideShareService.RideShareServiceClient rideshareClient)
    {
        _rideshareClient = rideshareClient;
    }

    [HttpPost("create")]
    public async Task<IActionResult> CreateRideShare([FromBody] CreateRideShareRequestTest request)
    {
        var response = await _rideshareClient.CreateRideShareAsync(request);
        return Ok(response);
    }



    [HttpPost("join")]
    public async Task<IActionResult> JoinRideShare([FromBody] JoinRideShareRequestDto request)
    {
        var grpcRequest = new JoinRideShareRequest
        {
            RideId = request.RideId,
            PassengerUsername = request.PassengerUsername
        };

        var response = await _rideshareClient.JoinRideShareAsync(grpcRequest);

        if (response.Success)
        {
            return Ok(new { Message = response.Message });
        }
        else
        {
            return BadRequest(new { Message = response.Message });
        }
    }


    [HttpGet("list/{carId}")]
    public async Task<IActionResult> ListRideShares(int carId)
    {
        var request = new ListRideSharesRequest { CarId = carId };
        var response = await _rideshareClient.ListRideSharesAsync(request);
        return Ok(response);
    }
}