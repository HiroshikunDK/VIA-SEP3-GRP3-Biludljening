import PaymentService.grpc.*;
import PaymentService.grpc.Payment.PaymentRequest;
import PaymentService.grpc.Payment.*;
import PaymentService.grpc.PaymentServiceGrpc;
import Service.PaymentService;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.stub.StreamObserver;
import io.grpc.ManagedChannel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.mockito.Mockito.*;

public class IPS_PaymentServiceTest {

    private InProcessServer<PaymentService> inprocessServer;
    private ManagedChannel channel;
    private PaymentServiceGrpc.PaymentServiceBlockingStub blockingStub;
    private PaymentServiceGrpc.PaymentServiceStub asyncStub;
    private StreamObserver<Payment.PaymentResponse> paymentResponseStreamObserver;
    private StreamObserver<Payment.PaymentListResponse> paymentListResponseStreamObserver;

    @Before
    public void before() throws Exception {
        // Initialize the in-process server with the PaymentService implementation
        System.out.println("Initializing the InProcessServer...");
        inprocessServer = new InProcessServer<>(PaymentService.class); // Pass the implementation class here
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
        blockingStub = PaymentServiceGrpc.newBlockingStub(channel);
        asyncStub = PaymentServiceGrpc.newStub(channel);

        // Ensure that stubs are created
        if (blockingStub == null || asyncStub == null) {
            System.out.println("Error: Stubs are not initialized properly.");
        } else {
            System.out.println("Stubs initialized successfully.");
        }

        // Mock StreamObservers for testing
        paymentResponseStreamObserver = mock(StreamObserver.class);
        paymentListResponseStreamObserver = mock(StreamObserver.class);
    }

    @After
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
    public void testCreatePayment() {
        // Prepare test data
        Payment.PaymentRequest request = Payment.PaymentRequest.newBuilder()
                .setCustomer(1)
                .setBookingType(2)
                .setBooking(123)
                .setStatus("Paid")
                .setCreditcardref(456)
                .build();

        // Simulate the gRPC service method
        PaymentResponse response =blockingStub.createPayment(request);

        Assert.assertTrue(response.getSuccess());
        Assert.assertEquals("Payment created successfully.", response.getMessage());

    }

    @Test
    public void testGetPaymentById() {
        // Prepare test data
        PaymentRequestById requestById = PaymentRequestById.newBuilder()
                .setId(1)
                .build();

        // Simulate the gRPC service method
        PaymentResponse response = blockingStub.getPaymentById(requestById);

        Assert.assertTrue(response.getSuccess());
        Assert.assertEquals("Payment retrieved successfully.", response.getMessage());
    }

    @Test
    public void testUpdatePaymentStatus() {
        // Prepare test data
        PaymentStatusUpdateRequest request = PaymentStatusUpdateRequest.newBuilder()
                .setId(1)
                .setStatus("Completed")
                .build();


        // Simulate the gRPC service method
        PaymentResponse response = blockingStub.updatePaymentStatus(request);

        Assert.assertTrue(response.getSuccess());
        Assert.assertEquals("Payment status updated successfully.", response.getMessage());
    }


    /*
    @Test
    public void testDeletePayment() {
        // Prepare test data
        PaymentRequestById request = PaymentRequestById.newBuilder()
                .setId(1)
                .build();

        // Simulate the gRPC service method
        PaymentResponse response = blockingStub.deletePayment(request);

        // Verify the response
        Assert.assertNotNull(response);
        Assert.assertEquals("Payment deleted successfully.", response.getMessage());
    }*/

    @Test
    public void testListPaymentsByCustomer() {
        // Prepare test data
        PaymentListByCustomerRequest request = PaymentListByCustomerRequest.newBuilder()
                .setCustomerId(1)
                .build();

        // Simulate the gRPC service method
       PaymentListResponse response =  blockingStub.listPaymentsByCustomer(request);

       // Verify the response
       Assert.assertNotNull(response);
       Assert.assertFalse(response.getPaymentsList().isEmpty());
        Assert.assertEquals("",response.getMessage());

    }
}
