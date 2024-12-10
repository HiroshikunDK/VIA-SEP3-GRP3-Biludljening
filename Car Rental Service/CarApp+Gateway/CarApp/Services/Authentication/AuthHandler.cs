using System.Net.Http.Headers;
using Microsoft.JSInterop;

namespace CarApp.Services.Authentication;

public class AuthHandler : DelegatingHandler
{
    private readonly IJSRuntime _jsRuntime;

    public AuthHandler(IJSRuntime jsRuntime)
    {
        _jsRuntime = jsRuntime;
    }

    protected override async Task<HttpResponseMessage> SendAsync(HttpRequestMessage request, CancellationToken cancellationToken)
    {
        string token = null;

        if (_jsRuntime is IJSInProcessRuntime jsInProcessRuntime)
        {
            token = jsInProcessRuntime.Invoke<string>("localStorage.getItem", "authToken");
        }
        else if (!_jsRuntime.IsJSInteropRestricted())
        {
            token = await _jsRuntime.InvokeAsync<string>("localStorage.getItem", "authToken");
        }

        if (!string.IsNullOrEmpty(token))
        {
            request.Headers.Authorization = new AuthenticationHeaderValue("Bearer", token);
        }

        return await base.SendAsync(request, cancellationToken);
    }
}

public static class JSInteropExtensions
{
    public static bool IsJSInteropRestricted(this IJSRuntime jsRuntime)
    {
        // Checks if the JS runtime is restricted (e.g., during static rendering)
        try
        {
            return jsRuntime is not IJSInProcessRuntime;
        }
        catch
        {
            return true; // Assume restricted if the check fails
        }
    }
}