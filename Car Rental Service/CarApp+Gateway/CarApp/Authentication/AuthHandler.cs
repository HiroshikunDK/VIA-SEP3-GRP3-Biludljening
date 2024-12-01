using System.Net.Http.Headers;
using Microsoft.JSInterop;

namespace CarApp.Authentication;

public class AuthHandler : DelegatingHandler
{
    private readonly IJSRuntime _jsRuntime;

    public AuthHandler(IJSRuntime jsRuntime)
    {
        _jsRuntime = jsRuntime;
    }

    protected override async Task<HttpResponseMessage> SendAsync(HttpRequestMessage request, CancellationToken cancellationToken)
    {
        if (_jsRuntime is IJSInProcessRuntime jsInProcessRuntime)
        {
            // When JS Runtime is available for immediate access
            var token = jsInProcessRuntime.Invoke<string>("localStorage.getItem", "authToken");

            if (!string.IsNullOrEmpty(token))
            {
                request.Headers.Authorization = new AuthenticationHeaderValue("Bearer", token);
            }
        }
        else
        {
            // Async fetch for scenarios like prerendering
            var token = await _jsRuntime.InvokeAsync<string>("localStorage.getItem", "authToken");
            if (!string.IsNullOrEmpty(token))
            {
                request.Headers.Authorization = new AuthenticationHeaderValue("Bearer", token);
            }
        }

        return await base.SendAsync(request, cancellationToken);
    }
}