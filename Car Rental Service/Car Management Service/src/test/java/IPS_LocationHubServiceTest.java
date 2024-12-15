import CarManagementService.grpc.CarManagement;
import CarManagementService.grpc.LocationHubServiceGrpc;
import Service.LocationHubService;
import io.grpc.ManagedChannel;
import io.grpc.inprocess.InProcessChannelBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IPS_LocationHubServiceTest {

    private InProcessServer<LocationHubService> inprocessServer;
    private ManagedChannel channel;
    private LocationHubServiceGrpc.LocationHubServiceBlockingStub blockingStub;
    private LocationHubServiceGrpc.LocationHubServiceStub asyncStub;

    @Before
    public void before() throws Exception {
        System.out.println("Initializing the InProcessServer...");

        // Initialize the in-process server with the LocationHubService implementation
        inprocessServer = new InProcessServer<>(LocationHubService.class);
        inprocessServer.start();

        Thread.sleep(500); // Allow time for server startup
        System.out.println("In-process server started successfully");

        channel = InProcessChannelBuilder.forName("Test")
                .directExecutor()
                .build();

        // Ensure that channel was created
        if (channel == null) {
            System.out.println("Error: channel is null after initialization.");
        } else {
            System.out.println("Channel created successfully.");
        }

        blockingStub = LocationHubServiceGrpc.newBlockingStub(channel);
        asyncStub = LocationHubServiceGrpc.newStub(channel);

        System.out.println("Channel and stubs created successfully.");
    }

    @After
    public void tearDown() throws Exception {
        try {
            System.out.println("Tearing down the test...");

            // Cleanup any resources if necessary (e.g., delete test records from DB)

            inprocessServer.stop();
            System.out.println("In-process server stopped successfully.");
        } catch (Exception e) {
            System.err.println("Error during teardown: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testGetAllLocationHubs() {
        try {
            // Call the getAllLocationHubs method using the blockingStub
            CarManagement.LocationHubList response = blockingStub.getAllLocationHubs(CarManagement.Empty.newBuilder().build());

            // Assert the response
            assertNotNull(response);
            assertTrue(response.getLocationhubCount() > 0); // Assuming there are location hubs in the repository

            System.out.println("Response: " + response.getLocationhubList());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception thrown while testing getAllLocationHubs: " + e.getMessage());
        }
    }

    @Test
    public void testGetLocationHubByID() {
        int testLocationHubId = 12345; // Use an existing or valid ID in your repository
        try {
            // Prepare the request for a specific LocationHub
            CarManagement.LocationHubRequest request = CarManagement.LocationHubRequest.newBuilder()
                    .setId(testLocationHubId)
                    .build();

            // Call the getLocationHubByID method using the blockingStub
            CarManagement.LocationHubResponse response = blockingStub.getLocationHubByID(request);

            // Assert the response
            assertNotNull(response);
            assertTrue(response.getSuccess());
            assertEquals("LocationHub found", response.getMessage());

            System.out.println("Response: " + response.getLocationHub());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception thrown while testing getLocationHubByID: " + e.getMessage());
        }
    }

    @Test
    public void testAddLocationHub() {
        try {
            // Prepare the LocationHub data for the test
            CarManagement.LocationHub locationHub = CarManagement.LocationHub.newBuilder()
                    .setLocationname("Test Location Hub")
                    .setAddress("123 Test Street")
                    .setCity("Test City")
                    .setCountry("Test Country")
                    .setEmail("test@example.com")
                    .setPhonenr("1234567890")
                    .setCarcapacity(50)
                    .build();

            // Call the addLocationHub method using the blockingStub
            CarManagement.LocationHubResponse response = blockingStub.addLocationHub(locationHub);

            // Assert the response
            assertNotNull(response);
            assertTrue(response.getSuccess());
            assertEquals("LocationHub added", response.getMessage());

            System.out.println("LocationHub added successfully: " + response.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception thrown while testing addLocationHub: " + e.getMessage());
        }
    }

    @Test
    public void testUpdateLocationHub() {
        int testLocationHubId = 12345; // Use an existing or valid ID in your repository
        try {
            // Prepare the LocationHub data for the test
            CarManagement.LocationHub locationHub = CarManagement.LocationHub.newBuilder()
                    .setId(testLocationHubId)
                    .setLocationname("Updated Location Hub")
                    .setAddress("456 Updated Street")
                    .setCity("Updated City")
                    .setCountry("Updated Country")
                    .setEmail("updated@example.com")
                    .setPhonenr("0987654321")
                    .setCarcapacity(75)
                    .build();

            // Call the updateLocationHub method using the blockingStub
            CarManagement.LocationHubResponse response = blockingStub.updateLocationHub(locationHub);

            // Assert the response
            assertNotNull(response);
            assertTrue(response.getSuccess());
            assertEquals("LocationHub updated", response.getMessage());

            System.out.println("LocationHub updated successfully: " + response.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception thrown while testing updateLocationHub: " + e.getMessage());
        }
    }

    @Test
    public void testDeleteLocationHub() {
        int testLocationHubId = 12345; // Use an existing or valid ID in your repository
        try {
            // Prepare the request to delete the LocationHub
            CarManagement.LocationHubRequest request = CarManagement.LocationHubRequest.newBuilder()
                    .setId(testLocationHubId)
                    .build();

            // Call the deleteLocationHub method using the blockingStub
            CarManagement.LocationHubResponse response = blockingStub.deleteLocationHub(request);

            // Assert the response
            assertNotNull(response);
            assertTrue(response.getSuccess());
            assertEquals("LocationHub deleted", response.getMessage());

            System.out.println("LocationHub deleted successfully: " + response.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception thrown while testing deleteLocationHub: " + e.getMessage());
        }
    }
}
