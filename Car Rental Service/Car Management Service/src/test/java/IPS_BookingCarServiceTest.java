import CarManagementService.grpc.CarManagement;
import CarManagementService.grpc.BookingCarServiceGrpc;
import Service.BookingCarService;
import Model.BookingCar;
import Repository.BookingCarRepository;
import io.grpc.ManagedChannel;
import io.grpc.inprocess.InProcessChannelBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class IPS_BookingCarServiceTest {

    private InProcessServer<BookingCarService> inprocessServer;
    private ManagedChannel channel;
    private BookingCarServiceGrpc.BookingCarServiceBlockingStub blockingStub;
    private BookingCarServiceGrpc.BookingCarServiceStub asyncStub;
    private BookingCarRepository bookingCarRepository;

    @Before
    public void before() throws Exception {
        System.out.println("Initializing the InProcessServer...");

        // Initialize the in-process server with the BookingCarService implementation
        inprocessServer = new InProcessServer<>(BookingCarService.class);
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

        blockingStub = BookingCarServiceGrpc.newBlockingStub(channel);
        asyncStub = BookingCarServiceGrpc.newStub(channel);

        System.out.println("Channel and stubs created successfully.");
    }

    @After
    public void tearDown() throws Exception {
        try {
            System.out.println("Tearing down the test...");
            inprocessServer.stop();
            System.out.println("In-process server stopped successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Error during teardown: " + e.getMessage());
        }
    }

    @Test
    public void testGetAllBookingCars() {
        try {
            // Mock the repository to return a list of booking cars
            BookingCar mockBookingCar = new BookingCar(1, "status", "2024-12-01", "08:30", "2024-12-01", "09:00", 100.50, 2, 1, 123);

            // Call the getAllBookingCars method using the blockingStub
            CarManagement.BookingCarList response = blockingStub.getAllBookingCars(CarManagement.Empty.newBuilder().build());

            // Assert the response
            assertNotNull(response);
            assertTrue(response.getBookingCarsCount() > 0); // Assuming the repository has booking cars

            System.out.println("Response: " + response.getBookingCarsList());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception thrown while testing getAllBookingCars: " + e.getMessage());
        }
    }

    @Test
    public void testGetBookingCarByID_Success() {
        try {
            int testBookingNr = 1;

            CarManagement.BookingCarRequest request = CarManagement.BookingCarRequest.newBuilder().setBookingNr(testBookingNr).build();
            CarManagement.BookingCarResponse response = blockingStub.getBookingCarByID(request);

            // Assert the response
            assertNotNull(response);
            assertTrue(response.getSuccess());
            assertEquals("Booking car found", response.getMessage());

            System.out.println("Response: " + response.getBookingCar());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception thrown while testing getBookingCarByID: " + e.getMessage());
        }
    }

    @Test
    public void testGetBookingCarByID_Failure() {
        try {
            int testBookingNr = 1;

            CarManagement.BookingCarRequest request = CarManagement.BookingCarRequest.newBuilder().setBookingNr(testBookingNr).build();
            CarManagement.BookingCarResponse response = blockingStub.getBookingCarByID(request);

            // Assert the response
            assertNotNull(response);
            assertFalse(response.getSuccess());
            assertEquals("Booking car not found", response.getMessage());

            System.out.println("Response: " + response.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception thrown while testing getBookingCarByID: " + e.getMessage());
        }
    }

    @Test
    public void testAddBookingCar_Success() {
        try {
            // Prepare the BookingCar data for the test
            CarManagement.BookingCar request = CarManagement.BookingCar.newBuilder()
                    .setBookingnr(1)
                    .setStatus("status")
                    .setStartdato("2024-12-01")
                    .setStarttime("08:30")
                    .setEnddate("2024-12-01")
                    .setEndtime("09:00")
                    .setPrice(100.50)
                    .setGreenshare(2)
                    .setCarid(1)
                    .setCustomerid(123)
                    .build();

            // Mock repository to return a saved booking car
            BookingCar mockBookingCar = new BookingCar(1, "status", "2024-12-01", "08:30", "2024-12-01", "09:00", 100.50, 2, 1, 123);

            // Call the addBookingCar method using the blockingStub
            CarManagement.BookingCarResponse response = blockingStub.addBookingCar(request);

            // Assert the response
            assertNotNull(response);
            assertTrue(response.getSuccess());
            assertEquals("Booking car added successfully.", response.getMessage());

            System.out.println("Booking car added successfully: " + response.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception thrown while testing addBookingCar: " + e.getMessage());
        }
    }

    @Test
    public void testUpdateBookingCar() {
        try {
            // Prepare the updated BookingCar data for the test
            CarManagement.BookingCar request = CarManagement.BookingCar.newBuilder()
                    .setBookingnr(1)
                    .setStatus("updated status")
                    .setStartdato("2024-12-01")
                    .setStarttime("08:30")
                    .setEnddate("2024-12-01")
                    .setEndtime("09:00")
                    .setPrice(150.50)
                    .setGreenshare(2)
                    .setCarid(1)
                    .setCustomerid(123)
                    .build();

            // Call the updateBookingCar method using the blockingStub
            CarManagement.BookingCarResponse response = blockingStub.updateBookingCar(request);

            // Assert the response
            assertNotNull(response);
            assertTrue(response.getSuccess());
            assertEquals("Booking car updated successfully", response.getMessage());

            System.out.println("Booking car updated successfully: " + response.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception thrown while testing updateBookingCar: " + e.getMessage());
        }
    }

    @Test
    public void testDeleteBookingCar() {
        try {
            int testBookingNr = 1;

            CarManagement.BookingCarRequest request = CarManagement.BookingCarRequest.newBuilder().setBookingNr(testBookingNr).build();
            CarManagement.BookingCarResponse response = blockingStub.deleteBookingCar(request);

            // Assert the response
            assertNotNull(response);
            assertTrue(response.getSuccess());
            assertEquals("Booking car deleted successfully", response.getMessage());

            System.out.println("Booking car deleted successfully: " + response.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception thrown while testing deleteBookingCar: " + e.getMessage());
        }
    }
}

