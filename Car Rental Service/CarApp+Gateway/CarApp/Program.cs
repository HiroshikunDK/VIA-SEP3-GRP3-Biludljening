using Microsoft.AspNetCore.Builder;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using System;
using System.Net.Http;

var builder = WebApplication.CreateBuilder(args);

// Register Blazor Server services
builder.Services.AddServerSideBlazor(); // Includes PersistentComponentState
builder.Services.AddRazorPages(); // Adds Razor Pages support
builder.Services.AddSignalR(); // Adds SignalR for Blazor Server

// Add an HTTP client for API calls (adjust the URI if needed)
builder.Services.AddScoped(sp => new HttpClient { BaseAddress = new Uri("http://localhost:5002") });

var app = builder.Build();

// Configure the HTTP request pipeline
if (app.Environment.IsDevelopment())
{
    app.UseDeveloperExceptionPage();
}
else
{
    app.UseExceptionHandler("/Error");
    app.UseHsts();
}

app.UseHttpsRedirection();
app.UseStaticFiles();
app.UseRouting();

app.MapBlazorHub(); // Maps the Blazor Server hub
app.MapFallbackToPage("/_Host"); // Serves the main Blazor page

app.Run();