using Microsoft.AspNetCore.Mvc;

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
    public async Task<IActionResult> JoinRideShare([FromBody] JoinRideShareRequest request)
    {
        var response = await _rideshareClient.JoinRideShareAsync(request);
        return Ok(response);
    }

    [HttpGet("list/{carId}")]
    public async Task<IActionResult> ListRideShares(int carId)
    {
        var request = new ListRideSharesRequest { CarId = carId };
        var response = await _rideshareClient.ListRideSharesAsync(request);
        return Ok(response);
    }
}