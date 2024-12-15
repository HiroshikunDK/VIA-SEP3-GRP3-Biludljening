import CarManagementService.grpc.CarManagement;
import CarManagementService.grpc.CarServiceGrpc;
import Service.CarService;
import io.grpc.ManagedChannel;
import io.grpc.inprocess.InProcessChannelBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IPS_CarServiceTest {

    private InProcessServer<CarService> inprocessServer;
    private ManagedChannel channel;
    private CarServiceGrpc.CarServiceBlockingStub blockingStub;
    private CarServiceGrpc.CarServiceStub asyncStub;

    @Before
    public void before() throws Exception {
        System.out.println("Initializing the InProcessServer...");

        // Initialize the in-process server with the CarService implementation
        inprocessServer = new InProcessServer<>(CarService.class);
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

        blockingStub = CarServiceGrpc.newBlockingStub(channel);
        asyncStub = CarServiceGrpc.newStub(channel);

        System.out.println("Channel and stubs created successfully.");
    }

    @After
    public void tearDown() throws Exception {
        try {
            System.out.println("Tearing down the test...");

            // Cleanup any resources if necessary (e.g., delete test records from DB)
            // Here you can delete any test cars or perform other cleanup operations if needed.

            inprocessServer.stop();
            System.out.println("In-process server stopped successfully.");
        } catch (Exception e) {
            System.err.println("Error during teardown: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testGetAllCars() {
        try {
            // Call the getAllCars method using the blockingStub
            CarManagement.CarList response = blockingStub.getAllCars(CarManagement.Empty.newBuilder().build());

            // Assert the response
            assertNotNull(response);
            assertTrue(response.getCarsCount() > 0); // Assuming there are cars in the repository

            System.out.println("Response: " + response.getCarsList());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception thrown while testing getAllCars: " + e.getMessage());
        }
    }

    @Test
    public void testGetCarByID() {
        String testCarId = "12345";
        try {
            // Assuming the car exists in the repository
            CarManagement.CarRequest request = CarManagement.CarRequest.newBuilder().setCarId(testCarId).build();
            CarManagement.CarResponse response = blockingStub.getCarByID(request);

            // Assert the response
            assertNotNull(response);
            assertTrue(response.getSuccess());
            assertEquals("Car found", response.getMessage());

            System.out.println("Response: " + response.getCar());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception thrown while testing getCarByID: " + e.getMessage());
        }
    }

    @Test
    public void testAddCar() {
        try {
            // Prepare the Car data for the test
            CarManagement.Car car = CarManagement.Car.newBuilder()
                    .setVin("1HGCM82633A123456")
                    .setYearproduced(2024)
                    .setManufactor("Honda")
                    .setModel("Civic")
                    .setColor("Red")
                    .setAltname("Honda Civic 2024")
                    .setSeats(5)
                    .setCarrange(300)
                    .setLocationhubref(1)
                    .build();

            // Call the addCar method using the blockingStub
            CarManagement.CarResponse response = blockingStub.addCar(car);

            // Assert the response
            assertNotNull(response);
            assertTrue(response.getSuccess());
            assertEquals("Car added successfully.", response.getMessage());

            System.out.println("Car added successfully: " + response.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception thrown while testing addCar: " + e.getMessage());
        }
    }

    @Test
    public void testDeleteCar() {
        String testCarId = "12345";
        try {
            // Prepare a request to delete the car
            CarManagement.CarRequest request = CarManagement.CarRequest.newBuilder().setCarId(testCarId).build();

            // Call the deleteCar method using the blockingStub
            CarManagement.CarResponse response = blockingStub.deleteCar(request);

            // Assert the response
            assertNotNull(response);
            assertTrue(response.getSuccess());
            assertEquals("Car deleted successfully", response.getMessage());

            System.out.println("Car deleted successfully: " + response.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception thrown while testing deleteCar: " + e.getMessage());
        }
    }
}
