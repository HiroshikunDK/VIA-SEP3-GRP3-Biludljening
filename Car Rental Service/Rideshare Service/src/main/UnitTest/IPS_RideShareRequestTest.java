import Model.RideShareOffer;
import Model.RideShareRequest;
import RideShareService.grpc.RideShareServiceGrpc;
import RideShareService.grpc.Rideshare;
import RideShareService.grpc.Rideshare.RideShareResponse;
import RideShareService.grpc.Rideshare.RideshareRequest;
import Service.RideshareService;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import io.grpc.inprocess.InProcessChannelBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class IPS_RideShareRequestTest {

    private static final Logger logger = Logger.getLogger(IPS_RideShareRequestTest.class.getName());

    private InProcessServer<RideshareService> inprocessServer;
    private ManagedChannel channel;
    private RideShareServiceGrpc.RideShareServiceBlockingStub blockingStub;
    private RideShareServiceGrpc.RideShareServiceStub asyncStub;

    public IPS_RideShareRequestTest() {
        super();
    }

    @Before
    public void before() throws Exception {
        logger.info("Initializing the InProcessServer...");

        // Initialize the in-process server
        inprocessServer = new InProcessServer<>(RideshareService.class);
        inprocessServer.start();

        // Give some time for the server to start up
        Thread.sleep(500);

        logger.info("In-process server started successfully");

        // Set up the channel for testing
        channel = InProcessChannelBuilder.forName("test")
                .directExecutor()
                .build();

        // Create the blocking and async stubs
        blockingStub = RideShareServiceGrpc.newBlockingStub(channel);
        asyncStub = RideShareServiceGrpc.newStub(channel);

        if (blockingStub == null || asyncStub == null) {
            logger.severe("Error: Stubs are not initialized properly.");
        } else {
            logger.info("Stubs initialized successfully.");
        }
    }

    @After
    public void tearDown() throws Exception {
        try {
            logger.info("Tearing down the test...");

            if (channel != null) {
                // Delete any existing ride share request
                Rideshare.RideShareIDRequest rideShareIDRequest = Rideshare.RideShareIDRequest.newBuilder().setRideId("RIDE12345").build();
                RideShareResponse deleteResponse = blockingStub.deleteRideShareRequest(rideShareIDRequest);

                logger.info("Delete response: " + deleteResponse.getMessage());

                channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
                logger.info("Channel shut down successfully.");
            }

            if (inprocessServer != null) {
                inprocessServer.stop();
                logger.info("In-process server stopped successfully.");
            }
        } catch (Exception e) {
            logger.severe("Error during teardown: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testCreateRideShareRequest() {
        // Create a new RideShareRequest
        Rideshare.RideshareRequest request = Rideshare.RideshareRequest.newBuilder()
                .setRideId("RIDE12345")
                .setStatus("pending")
                .setStartdate("2024-12-01")
                .setStarttime("10:00:00")
                .setStartlocation("123 Main St, Cityville")
                .setEnddate("2024-12-01")
                .setEndtime("11:00:00")
                .setEndlocation("456 Elm St, Townville")
                .setCustomerid("USER1001")
                .build();

        // Send the request to create the ride share
        RideShareResponse response = blockingStub.createRideShareRequest(request);

        // Check the response
        assertNotNull(response);
        assertTrue(response.getSuccess());
        assertEquals("RideShareRequest created successfully", response.getMessage());
    }

    @Test
    public void testCreateRideShareAlreadyExistRequest() {
        // Create a new RideShareRequest
        Rideshare.RideshareRequest request = Rideshare.RideshareRequest.newBuilder()
                .setRideId("RIDE12345")
                .setStatus("pending")
                .setStartdate("2024-12-01")
                .setStarttime("10:00:00")
                .setStartlocation("123 Main St, Cityville")
                .setEnddate("2024-12-01")
                .setEndtime("11:00:00")
                .setEndlocation("456 Elm St, Townville")
                .setCustomerid("USER1001")
                .build();

        // Send the request to create the ride share
        RideShareResponse response = blockingStub.createRideShareRequest(request);
        response = blockingStub.createRideShareRequest(request);

        // Check the response
        assertNotNull(response);
        assertFalse(response.getSuccess());
        assertEquals("Error creating RideShareRequest: Error creating RideShareRequest", response.getMessage());
    }

    @Test
    public void testReadRideShareRequest() {
        // Create a new RideShareRequest
        Rideshare.RideshareRequest testObj = Rideshare.RideshareRequest.newBuilder()
                .setRideId("RIDE12345")
                .setStatus("pending")
                .setStartdate("2024-12-01")
                .setStarttime("10:00:00")
                .setStartlocation("123 Main St, Cityville")
                .setEnddate("2024-12-01")
                .setEndtime("11:00:00")
                .setEndlocation("456 Elm St, Townville")
                .setCustomerid("USER1001")
                .build();

        // Send the request to create the ride share
        blockingStub.createRideShareRequest(testObj);
        // Prepare the request
        Rideshare.RideShareIDRequest request = Rideshare.RideShareIDRequest.newBuilder().setRideId("RIDE12345").build();

        // Call ReadRideShareRequest
        RideshareRequest response = blockingStub.readRideShareRequest(request);

        // Validate the response
        assertNotNull(response);
        assertEquals("RIDE12345", response.getRideId());
        assertEquals("pending", response.getStatus());
    }

    @Test
    public void testReadAllRideShareRequests() throws InterruptedException {
        createTestRideShareRequests();
        // Send an empty request to fetch all ride share requests
        Empty emptyRequest = Empty.newBuilder().build();
        Thread.sleep(500);

        // Call ReadAllRideShareRequest
        Rideshare.RideShareRequestList response = blockingStub.readAllRideShareRequest(emptyRequest);

        // Validate the response
        assertNotNull(response);
        List<Rideshare.RideshareRequest> testList = response.getResultListList();
        List<String> resultList = new ArrayList<>(List.of("RIDE00001", "RIDE00002", "RIDE00003", "RIDE00004", "RIDE00005"));

        for(Rideshare.RideshareRequest item: testList ){
            System.out.println( "Assertion result "+ item.getRideId() + ": " + resultList.contains(item.getRideId()));
            assertTrue(resultList.contains(item.getRideId())); // Assert that the rideids exist in
        }

    }

    @Test
    public void testUpdateRideShareRequest() {
        // Prepare the updated RideShareRequest
        RideshareRequest updatedRequest = Rideshare.RideshareRequest.newBuilder()
                .setRideId("RIDE12345")
                .setStatus("confirmed")
                .setStartdate("2024-12-01")
                .setStarttime("10:00:00")
                .setStartlocation("123 Main St, Cityville")
                .setEnddate("2024-12-01")
                .setEndtime("11:00:00")
                .setEndlocation("456 Elm St, Townville")
                .setCustomerid("USER1001")
                .build();

        // Send the update request
        RideShareResponse response = blockingStub.updateRideShareRequest(updatedRequest);

        // Validate the response
        assertNotNull(response);
        assertTrue(response.getSuccess());
        assertEquals("RideShareRequest updated successfully", response.getMessage());
    }

    @Test
    public void testDeleteRideShareRequest() {
        // Prepare the RideShareIDRequest for deletion
        Rideshare.RideShareIDRequest request = Rideshare.RideShareIDRequest.newBuilder().setRideId("RIDE12345").build();

        // Call DeleteRideShareRequest
        RideShareResponse response = blockingStub.deleteRideShareRequest(request);

        // Validate the response
        assertNotNull(response);
        assertTrue(response.getSuccess());
        assertEquals("RideShareRequest deleted successfully", response.getMessage());
    }

    @Test
    public void testDeleteRideShareRequestWhenDoesntExist() {
        // Prepare the RideShareIDRequest for deletion
        Rideshare.RideShareIDRequest request = Rideshare.RideShareIDRequest.newBuilder().setRideId("RIDE0000").build();

        // Call DeleteRideShareRequest
        RideShareResponse response = blockingStub.deleteRideShareRequest(request);

        // Validate the response
        assertNotNull(response);
        System.out.println(response.getSuccess());
        assertFalse(response.getSuccess());
        System.out.println(response.getMessage());
        assertEquals("RideShareRequest deleted successfully", response.getMessage());
    }

    // Method to create 5 test RideshareRequest objects
    public List<Rideshare.RideshareRequest> createTestRideShareRequests() {
        List<Rideshare.RideshareRequest> testRequests = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            // Build each test object with unique data
            Rideshare.RideshareRequest request = Rideshare.RideshareRequest.newBuilder()
                    .setRideId("RIDE" + String.format("%05d", i))  // Unique Ride ID, e.g., RIDE00001, RIDE00002...
                    .setStatus(i % 2 == 0 ? "confirmed" : "pending")  // Alternate status between "confirmed" and "pending"
                    .setStartdate("2024-12-0" + i)  // Unique start date, e.g., 2024-12-01, 2024-12-02...
                    .setStarttime("10:0" + i + ":00")  // Unique start time, e.g., 10:01:00, 10:02:00...
                    .setStartlocation("Location " + i)  // Unique start location, e.g., Location 1, Location 2...
                    .setEnddate("2024-12-0" + i)  // Same end date for simplicity
                    .setEndtime("11:0" + i + ":00")  // Unique end time
                    .setEndlocation("End Location " + i)  // Unique end location
                    .setCustomerid("USER100" + i)  // Unique customer ID for each request
                    .build();

            // Add the request to the list
            testRequests.add(request);
        }

        return testRequests;
    }

    // Method to send the created requests using the blocking stub
    public void sendTestRideShareRequests(RideShareServiceGrpc.RideShareServiceBlockingStub blockingStub) {
        // Create the test objects
        List<Rideshare.RideshareRequest> testRequests = createTestRideShareRequests();

        // Iterate through each test request and send it to the gRPC service
        for (Rideshare.RideshareRequest request : testRequests) {
            // Send the request using the blocking stub
            Rideshare.RideShareResponse response = blockingStub.createRideShareRequest(request);

            // Log the response for each request
            System.out.println("Request for Ride ID " + request.getRideId() + ": " + response.getMessage());
        }
    }
}
