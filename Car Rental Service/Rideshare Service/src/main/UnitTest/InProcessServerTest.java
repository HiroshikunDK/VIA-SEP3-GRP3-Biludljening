//Resource used for making the test Suite
//https://stackoverflow.com/questions/37552468/how-to-unit-test-grpc-java-server-implementation-functions

import Model.RideShareOffer;
import Repository.RideShareOfferHibernateImpl;
import Repository.RideShareRequestHibernateImpl;
import Repository.RideshareRepository;
import RideShareService.grpc.RideShareServiceGrpc;
import RideShareService.grpc.Rideshare;
import RideShareService.grpc.Rideshare.RideshareOffer;
import Service.RideshareService;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import io.grpc.inprocess.InProcessChannelBuilder;

import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.stub.StreamObserver;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;

//For this function to work
public class InProcessServerTest {
    private static final Logger logger = Logger.getLogger(InProcessServerTest.class.getName());
    //private final RideShareOfferHibernateImpl rso;

    private InProcessServer<RideshareService> inprocessServer;
    private ManagedChannel channel;
    private RideShareServiceGrpc.RideShareServiceBlockingStub blockingStub;
    private RideShareServiceGrpc.RideShareServiceStub asyncStub;

    public InProcessServerTest() {
        super();
    }

    @Before
    public void before() throws Exception {
        // Initialize the in-process server with the RideshareService implementation
        System.out.println("Initializing the InProcessServer...");

        inprocessServer = new InProcessServer<>(RideshareService.class); // Pass the implementation class here
        inprocessServer.start(); // Start the server

        // Delay to make sure the server has time to start
        Thread.sleep(500); // Sleep for 500ms to allow server to initialize
        System.out.println("In-process server started successfully");

        // Create a channel for testing
        channel = InProcessChannelBuilder.forName("test") // Use the same server name
                .directExecutor() // Use directExecutor for synchronous calls
                .build();

        // Ensure that channel was created
        if (channel == null) {
            System.out.println("Error: channel is null after initialization.");
        } else {
            System.out.println("Channel created successfully.");
        }

        // Create blocking and async stubs for testing the service
        blockingStub = RideShareServiceGrpc.newBlockingStub(channel);
        asyncStub = RideShareServiceGrpc.newStub(channel);

        // Ensure that stubs are created
        if (blockingStub == null || asyncStub == null) {
            System.out.println("Error: Stubs are not initialized properly.");
        } else {
            System.out.println("Stubs initialized successfully.");
        }
    }

    @AfterEach
    public void tearDown() throws Exception {
        try {
            System.out.println("Tearing down the test...");

            // Check if channel is null before calling shutdown
            if (channel != null) {
                channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
                System.out.println("Channel shut down successfully.");
            } else {
                System.out.println("Warning: Channel is null, skipping shutdown.");
            }

            // Check if inprocessServer is null before stopping it
            if (inprocessServer != null) {
                inprocessServer.stop();
                System.out.println("In-process server stopped successfully.");
            } else {
                System.out.println("Warning: In-process server is null, skipping shutdown.");
            }

        } catch (Exception e) {
            System.err.println("Error during teardown: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testRideShareOffer() throws InterruptedException {

        //Delete if the object exist in
        String testId = "RIDE12345";
        Rideshare.RideShareIDRequest rideShareIDRequest = Rideshare.RideShareIDRequest.newBuilder().setRideId(testId).build();
        Rideshare.RideShareResponse deleteResponse = blockingStub.deleteRideShareOffer(rideShareIDRequest);
        System.out.println("Delete response is: " + deleteResponse.getMessage());


        // Example test: Create a RideShareOffer request
        Rideshare.RideshareOffer request = Rideshare.RideshareOffer.newBuilder()
                .setRideId(testId)
                .setAvailablespaces(3)
                .setStatus("partially booked")
                .setStartdate("2024-12-01")
                .setStarttime("08:30:00")
                .setStartlocation("123 Main St, Cityville")
                .setEnddate("2024-12-01")
                .setEndtime("09:00:00")
                .setEndlocation("456 Elm St, Townville")
                .setPrice(15.50f)
                .setCustomerid("USER1001")
                .setBookingref("BOOK1234")
                .build();

        // Call the service method using the blockingStub
        Rideshare.RideShareResponse response = blockingStub.createRideShareOffer(request);

        System.out.println(response.getSuccess() + response.getMessage());
        // Assert the response
        assertNotNull(response);
        assertTrue(response.getSuccess());
    }


    private RideShareOffer convertToRideShareOffer(RideshareOffer offerProto) {
        System.out.println("convertToRideShareOffer");
        return new RideShareOffer(
                offerProto.getRideId(),
                offerProto.getAvailablespaces(),
                offerProto.getStatus(),
                offerProto.getStartdate(),
                offerProto.getStarttime(),
                offerProto.getStartlocation(),
                offerProto.getEnddate(),
                offerProto.getEndtime(),
                offerProto.getEndlocation(),
                offerProto.getPrice(),
                offerProto.getCustomerid(),
                offerProto.getBookingref()
        );
    }

    public List<RideshareOffer> makeTestObjectsRideShareOffers() {
        System.out.println("makeTestObjectsRideShareOffers");
        List<RideshareOffer> rideshareOffers = new ArrayList<>();

        // Adding 10 RideshareOffer examples using gRPC generated setters
        RideshareOffer offer1 = RideshareOffer.newBuilder()
                .setRideId("RIDE12345")
                .setAvailablespaces(3)
                .setStatus("partially booked")
                .setStartdate("2024-12-01")
                .setStarttime("08:30:00")
                .setStartlocation("123 Main St, Cityville")
                .setEnddate("2024-12-01")
                .setEndtime("09:00:00")
                .setEndlocation("456 Elm St, Townville")
                .setPrice(15.50f)
                .setCustomerid("USER1001")
                .setBookingref("BOOK1234")
                .build();
        rideshareOffers.add(offer1);

        RideshareOffer offer2 = RideshareOffer.newBuilder()
                .setRideId("RIDE12346")
                .setAvailablespaces(1)
                .setStatus("full")
                .setStartdate("2024-12-01")
                .setStarttime("09:00:00")
                .setStartlocation("789 Oak St, Cityville")
                .setEnddate("2024-12-01")
                .setEndtime("09:30:00")
                .setEndlocation("101 Pine St, Village")
                .setPrice(12.00f)
                .setCustomerid("USER1002")
                .setBookingref("BOOK1235")
                .build();
        rideshareOffers.add(offer2);

        RideshareOffer offer3 = RideshareOffer.newBuilder()
                .setRideId("RIDE12347")
                .setAvailablespaces(2)
                .setStatus("partially booked")
                .setStartdate("2024-12-02")
                .setStarttime("10:00:00")
                .setStartlocation("321 Maple Ave, Cityville")
                .setEnddate("2024-12-02")
                .setEndtime("10:30:00")
                .setEndlocation("654 Birch Rd, Townsville")
                .setPrice(10.25f)
                .setCustomerid("USER1003")
                .setBookingref("BOOK1236")
                .build();
        rideshareOffers.add(offer3);

        RideshareOffer offer4 = RideshareOffer.newBuilder()
                .setRideId("RIDE12348")
                .setAvailablespaces(0)
                .setStatus("full")
                .setStartdate("2024-12-02")
                .setStarttime("15:30:00")
                .setStartlocation("222 Cedar Ln, Cityville")
                .setEnddate("2024-12-02")
                .setEndtime("16:00:00")
                .setEndlocation("555 Willow St, Greenfield")
                .setPrice(20.00f)
                .setCustomerid("USER1004")
                .setBookingref("BOOK1237")
                .build();
        rideshareOffers.add(offer4);

        RideshareOffer offer5 = RideshareOffer.newBuilder()
                .setRideId("RIDE12349")
                .setAvailablespaces(4)
                .setStatus("partially booked")
                .setStartdate("2024-12-03")
                .setStarttime("07:45:00")
                .setStartlocation("123 Birch Ave, Downtown")
                .setEnddate("2024-12-03")
                .setEndtime("08:15:00")
                .setEndlocation("789 Maple Rd, Suburbia")
                .setPrice(8.75f)
                .setCustomerid("USER1005")
                .setBookingref("BOOK1238")
                .build();
        rideshareOffers.add(offer5);

        RideshareOffer offer6 = RideshareOffer.newBuilder()
                .setRideId("RIDE12350")
                .setAvailablespaces(5)
                .setStatus("partially booked")
                .setStartdate("2024-12-04")
                .setStarttime("11:00:00")
                .setStartlocation("567 Oak Ave, Uptown")
                .setEnddate("2024-12-04")
                .setEndtime("11:45:00")
                .setEndlocation("432 Pine St, Downtown")
                .setPrice(13.00f)
                .setCustomerid("USER1006")
                .setBookingref("BOOK1239")
                .build();
        rideshareOffers.add(offer6);

        RideshareOffer offer7 = RideshareOffer.newBuilder()
                .setRideId("RIDE12351")
                .setAvailablespaces(3)
                .setStatus("cancelled")
                .setStartdate("2024-12-05")
                .setStarttime("18:00:00")
                .setStartlocation("890 Cedar Ave, City Center")
                .setEnddate("2024-12-05")
                .setEndtime("18:30:00")
                .setEndlocation("345 Willow St, Lakeside")
                .setPrice(10.00f)
                .setCustomerid("USER1007")
                .setBookingref("BOOK1240")
                .build();
        rideshareOffers.add(offer7);

        RideshareOffer offer8 = RideshareOffer.newBuilder()
                .setRideId("RIDE12352")
                .setAvailablespaces(2)
                .setStatus("partially booked")
                .setStartdate("2024-12-06")
                .setStarttime("13:00:00")
                .setStartlocation("100 Pine Blvd, Seaside")
                .setEnddate("2024-12-06")
                .setEndtime("13:30:00")
                .setEndlocation("200 Oak Dr, Riverside")
                .setPrice(18.50f)
                .setCustomerid("USER1008")
                .setBookingref("BOOK1241")
                .build();
        rideshareOffers.add(offer8);

        RideshareOffer offer9 = RideshareOffer.newBuilder()
                .setRideId("RIDE12353")
                .setAvailablespaces(6)
                .setStatus("partially booked")
                .setStartdate("2024-12-07")
                .setStarttime("14:30:00")
                .setStartlocation("600 Maple St, Hilltop")
                .setEnddate("2024-12-07")
                .setEndtime("15:00:00")
                .setEndlocation("800 Elm Ave, Valleyview")
                .setPrice(22.00f)
                .setCustomerid("USER1009")
                .setBookingref("BOOK1242")
                .build();
        rideshareOffers.add(offer9);

        RideshareOffer offer10 = RideshareOffer.newBuilder()
                .setRideId("RIDE12354")
                .setAvailablespaces(0)
                .setStatus("full")
                .setStartdate("2024-12-07")
                .setStarttime("17:00:00")
                .setStartlocation("50 Willow Way, Oldtown")
                .setEnddate("2024-12-07")
                .setEndtime("17:45:00")
                .setEndlocation("150 Birch Ln, Newtown")
                .setPrice(25.00f)
                .setCustomerid("USER1010")
                .setBookingref("BOOK1243")
                .build();
        rideshareOffers.add(offer10);

        return rideshareOffers;
    }

}
