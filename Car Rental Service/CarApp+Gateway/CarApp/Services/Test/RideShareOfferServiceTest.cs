/*
using Moq;
using System.Net.Http;
using System.Threading.Tasks;
using Xunit;
using CarApp.Services.RideShare;
using Microsoft.AspNetCore.Components;
using Shared.Dto;
using System.Collections.Generic;
using System.Net;
using Shared.Dto.RideShare;

namespace CarApp.Services.Test
{
    public class RideShareOfferServiceTest
    {
        private readonly Mock<HttpClient> _mockHttpClient;
        private readonly Mock<NavigationManager> _mockNavigationManager;
        private readonly RideShareOfferService _rideShareService;

        RideShareOfferServiceTests()
        {
            _mockHttpClient = new Mock<HttpClient>();
            _mockNavigationManager = new Mock<NavigationManager>();
            _rideShareService = new RideShareOfferService(_mockHttpClient.Object);
        }

        [Fact]
        public async Task GetAllRideShareOffersAsync_ReturnsCorrectData()
        {
            // Arrange
            var expectedResponse = new RideShareOfferDto[]
            {
                new RideShareOfferDto { RideId = "1", Price = 100 },
                new RideShareOfferDto { RideId = "2", Price = 150 }
            };

            _mockHttpClient.Setup(client => client.GetFromJsonAsync<RideShareOfferDto[]>("api/rideshareoffer"))
                .ReturnsAsync(expectedResponse);

            // Act
            var result = await _rideShareService.GetAllRideShareOffersAsync();

            // Assert
            Assert.NotNull(result);
            Assert.Equal(2, result.Length);
            Assert.Equal("1", result[0].RideId);
        }

        [Fact]
        public async Task GetRideShareOfferByIdAsync_ReturnsCorrectData()
        {
            // Arrange
            var rideId = "1";
            var expectedResponse = new RideShareOfferDto { RideId = "1", Price = 100 };

            _mockHttpClient.Setup(client => client.GetFromJsonAsync<RideShareOfferDto>($"api/rideshareoffer/{rideId}"))
                .ReturnsAsync(expectedResponse);

            // Act
            var result = await _rideShareService.GetRideShareOfferByIdAsync(rideId);

            // Assert
            Assert.NotNull(result);
            Assert.Equal("1", result.RideId);
        }

        [Fact]
        public async Task GetRideShareOfferByIdAsync_ThrowsKeyNotFoundException_WhenNotFound()
        {
            // Arrange
            var rideId = "1";
            _mockHttpClient.Setup(client => client.GetFromJsonAsync<RideShareOfferDto>($"api/rideshareoffer/{rideId}"))
                .ReturnsAsync((RideShareOfferDto)null);

            // Act & Assert
            var exception = await Assert.ThrowsAsync<KeyNotFoundException>(() => _rideShareService.GetRideShareOfferByIdAsync(rideId));
            Assert.Equal($"Ride share offer with ID {rideId} not found.", exception.Message);
        }

        [Fact]
        public async Task CreateRideShareOfferAsync_ReturnsTrue_WhenSuccess()
        {
            // Arrange
            var newOffer = new RideShareOfferDto { RideId = "3", Price = 200 };
            var mockResponse = new HttpResponseMessage(HttpStatusCode.OK)
            {
                Content = new StringContent("{}")
            };

            _mockHttpClient.Setup(client => client.PostAsJsonAsync("api/rideshareoffer", newOffer))
                .ReturnsAsync(mockResponse);

            // Act
            var result = await _rideShareService.CreateRideShareOfferAsync(newOffer);

            // Assert
            Assert.True(result);
        }

        [Fact]
        public async Task UpdateRideShareOfferAsync_ReturnsFalse_WhenFailure()
        {
            // Arrange
            var updatedOffer = new RideShareOfferDto { RideId = "3", Price = 200 };
            var mockResponse = new HttpResponseMessage(HttpStatusCode.BadRequest)
            {
                Content = new StringContent("{\"error\": \"Invalid data\"}")
            };

            _mockHttpClient.Setup(client => client.PutAsJsonAsync("api/rideshareoffer", updatedOffer))
                .ReturnsAsync(mockResponse);

            // Act
            var result = await _rideShareService.UpdateRideShareOfferAsync(updatedOffer);

            // Assert
            Assert.False(result);
        }

        [Fact]
        public async Task DeleteRideShareOfferAsync_ReturnsTrue_WhenSuccess()
        {
            // Arrange
            var rideId = "3";
            var mockResponse = new HttpResponseMessage(HttpStatusCode.OK)
            {
                Content = new StringContent("{}")
            };

            _mockHttpClient.Setup(client => client.DeleteAsync($"api/rideshareoffer/{rideId}"))
                .ReturnsAsync(mockResponse);

            // Act
            var result = await _rideShareService.DeleteRideShareOfferAsync(rideId);

            // Assert
            Assert.True(result);
        }

        [Fact]
        public async Task RedirectToCreateRideShareOffer_ShouldNavigateCorrectly()
        {
            // Arrange
            var bookingId = "booking123";
            var userId = "user456";

            // Act
            _rideShareService.RedirectToCreateRideShareOffer(bookingId, userId, _mockNavigationManager.Object);

            // Assert
            _mockNavigationManager.Verify(nav => nav.NavigateTo($"/CreateRideShareOffer?bookingId={bookingId}&userId={userId}"), Times.Once);
        }
    }
}*/
