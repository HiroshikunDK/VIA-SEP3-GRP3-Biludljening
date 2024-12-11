using Microsoft.AspNetCore.Antiforgery;
using Microsoft.AspNetCore.Mvc;

namespace gRPC_Gateway.Controllers.Auth
{
    [Route("api/antiforgery")]
    [ApiController]
    public class AntiforgeryController : ControllerBase
    {
        private readonly IAntiforgery _antiforgery;

        public AntiforgeryController(IAntiforgery antiforgery)
        {
            _antiforgery = antiforgery;
        }

        [HttpGet("token")]
        public IActionResult GetAntiForgeryToken()
        {
            var tokens = _antiforgery.GetAndStoreTokens(HttpContext);
            Response.Headers.Add("X-CSRF-TOKEN", tokens.RequestToken); 
            return Ok(tokens.RequestToken);
        }
    }
}