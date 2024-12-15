/*
using Moq;
using Xunit;
using gRPC_Gateway.Controllers.RideShare;
using Microsoft.AspNetCore.Mvc;
using Grpc.Core;
using System;
using System.Threading.Tasks;



namespace gRPC_Gateway.Tests
{
    public class RideShareOfferControllerTests
    {
        private readonly Mock<RideShareService.RideShareServiceClient> _mockRideShareServiceClient;
        private readonly RideShareOfferController _controller;

        public RideShareOfferControllerTests()
        {
            _mockRideShareServiceClient = new Mock<RideShareService.RideShareServiceClient>();
            _controller = new RideShareOfferController(_mockRideShareServiceClient.Object);
        }

        // Example Test for CreateRideShareOffer
        [Fact]
        public async Task CreateRideShareOffer_ValidRequest_ReturnsOk()
        {
            // Arrange
            var request = new RideshareOffer
            {
                Availablespaces = 3,
                Price = 100.0
            };
            var response = new RideShareResponse { Success = true, Message = "Offer created" };
            _mockRideShareServiceClient.Setup(client => client.CreateRideShareOfferAsync(It.IsAny<RideshareOffer>()));
                                       ReturnsAsync(response);

            // Act
            var result = await _controller.CreateRideShareOffer(request);

            // Assert
            var actionResult = Assert.IsType<OkObjectResult>(result);
            var returnValue = Assert.IsType<RideShareResponse>(actionResult.Value);
            Assert.True(returnValue.Success);
            Assert.Equal("Offer created", returnValue.Message);
        }

        // Test for CreateRideShareOffer when AvailableSpace is invalid
        [Fact]
        public async Task CreateRideShareOffer_InvalidAvailableSpace_Returns406()
        {
            // Arrange
            var request = new RideshareOffer
            {
                Availablespaces = 0, // Invalid available space
                Price = 100.0
            };

            // Act
            var result = await _controller.CreateRideShareOffer(request);

            // Assert
            var actionResult = Assert.IsType<ObjectResult>(result);
            Assert.Equal(406, actionResult.StatusCode);
            Assert.Equal("Available space is an invalid value", actionResult.Value);
        }

        // Test for CreateRideShareOffer when Price is invalid
        [Fact]
        public async Task CreateRideShareOffer_InvalidPrice_Returns406()
        {
            // Arrange
            var request = new RideshareOffer
            {
                Availablespaces = 5,
                Price = -1.0 // Invalid price
            };

            // Act
            var result = await _controller.CreateRideShareOffer(request);

            // Assert
            var actionResult = Assert.IsType<ObjectResult>(result);
            Assert.Equal(406, actionResult.StatusCode);
            Assert.Equal("Price is an invalid value", actionResult.Value);
        }

        [Fact]
        public async Task CreateRideShareOffer_ReturnsInternalServerError_WhenRpcExceptionOccurs()
        {
            // Arrange
            var request = new RideshareOffer { Availablespaces = 10, Price = 100.0f };

            // Mock RpcException for CreateRideShareOfferAsync
            _mockRideShareServiceClient.Setup(client => client.CreateRideShareOfferAsync(It.IsAny<RideshareOffer>()))
                .ThrowsAsync(new RpcException(new Status(StatusCode.Internal, "Test RpcException")));

            // Act
            var result = await _controller.CreateRideShareOffer(request);

            // Assert
            var actionResult = Assert.IsType<ObjectResult>(result);
            Assert.Equal(500, actionResult.StatusCode);
            Assert.Equal("Internal server error: Test RpcException", actionResult.Value);
        }

        // Test for GetRideShareOfferById (Valid ID)
        [Fact]
        public async Task GetRideShareOfferById_ValidId_ReturnsOk()
        {
            // Arrange
            var rideId = "123";
            var request = new RideShareIDRequest { RideId = rideId };
            var response = new RideshareOffer { RideId = rideId, Availablespaces = 5, Price = 100.0 };

            _mockRideShareServiceClient.Setup(client => client.ReadRideShareOfferAsync(It.IsAny<RideShareIDRequest>()))
                                       .ReturnsAsync(response);

            // Act
            var result = await _controller.GetRideShareOfferById(rideId);

            // Assert
            var actionResult = Assert.IsType<OkObjectResult>(result);
            var returnValue = Assert.IsType<RideshareOffer>(actionResult.Value);
            Assert.Equal(rideId, returnValue.RideId);
        }

        // Test for GetRideShareOfferById (Not Found)
        [Fact]
        public async Task GetRideShareOfferById_NotFound_ReturnsNotFound()
        {
            // Arrange
            var rideId = "123";
            var request = new RideShareIDRequest { RideId = rideId };

            _mockRideShareServiceClient.Setup(client => client.ReadRideShareOfferAsync(It.IsAny<RideShareIDRequest>()))
                                       .ReturnsAsync((RideshareOffer)); // Return null for not found

            // Act
            var result = await _controller.GetRideShareOfferById(rideId);

            // Assert
            var actionResult = Assert.IsType<NotFoundObjectResult>(result);
            Assert.Equal($"Ride offer with ID {rideId} not found.", actionResult.Value);
        }

        // Test for DeleteRideShareOffer (Successful Deletion)
        [Fact]
        public async Task DeleteRideShareOffer_Success_ReturnsOk()
        {
            // Arrange
            var rideId = "123";
            var request = new RideShareIDRequest { RideId = rideId };
            var response = new RideShareResponse { Success = true, Message = "Offer deleted" };

            _mockRideShareServiceClient.Setup(client => client.DeleteRideShareOfferAsync(It.IsAny<RideShareIDRequest>()))
                                       .ReturnsAsync(response);

            // Act
            var result = await _controller.DeleteRideShareOffer(rideId);

            // Assert
            var actionResult = Assert.IsType<OkObjectResult>(result);
            var returnValue = Assert.IsType<RideShareResponse>(actionResult.Value);
            Assert.True(returnValue.Success);
            Assert.Equal("Offer deleted", returnValue.Message);
        }

        // Test for DeleteRideShareOffer (Failure)
        [Fact]
        public async Task DeleteRideShareOffer_Failure_Returns406()
        {
            // Arrange
            var rideId = "123";
            var request = new RideShareIDRequest { RideId = rideId };
            var response = new RideShareResponse { Success = false, Message = "Failed to delete offer" };

            _mockRideShareServiceClient.Setup(client => client.DeleteRideShareOfferAsync(It.IsAny<RideShareIDRequest>()))
                                       .ReturnsAsync(response);

            // Act
            var result = await _controller.DeleteRideShareOffer(rideId);

            // Assert
            var actionResult = Assert.IsType<ObjectResult>(result);
            Assert.Equal(406, actionResult.StatusCode);
            Assert.Equal("Failed to delete offer", actionResult.Value);
        }
    }
}
*/