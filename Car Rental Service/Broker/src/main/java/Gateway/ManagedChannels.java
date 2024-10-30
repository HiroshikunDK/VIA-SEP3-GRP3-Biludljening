package Gateway;

import carservice.CarManagementServiceGrpc;
import carservice.CarOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import payment.paymentservice.PaymentServiceGrpc;
import payment.paymentservice.PaymentServiceProto;
import rideshare.rideshareservice.grpc.RideShareServiceGrpc;
import rideshare.rideshareservice.grpc.RideShareServiceProto;
import userservice.User;
import userservice.UserServiceGrpc;

public class ManagedChannels {
    private final ManagedChannel paymentChannel;
    private final PaymentServiceGrpc.PaymentServiceBlockingStub paymentStub;

    private final ManagedChannel rideShareChannel;
    private final RideShareServiceGrpc.RideShareServiceBlockingStub rideShareStub;

    private final ManagedChannel carManagementChannel;
    private final CarManagementServiceGrpc.CarManagementServiceBlockingStub carManagementStub;

    private final ManagedChannel userChannel;
    private final UserServiceGrpc.UserServiceBlockingStub userStub;

    public ManagedChannels() {
        this.paymentChannel = ManagedChannelBuilder.forAddress("localhost", 5057)
                .usePlaintext()
                .build();
        this.paymentStub = PaymentServiceGrpc.newBlockingStub(paymentChannel);

        this.rideShareChannel = ManagedChannelBuilder.forAddress("localhost", 5058)
                .usePlaintext()
                .build();
        this.rideShareStub = RideShareServiceGrpc.newBlockingStub(rideShareChannel);

        this.carManagementChannel = ManagedChannelBuilder.forAddress("localhost", 5056)
                .usePlaintext()
                .build();
        this.carManagementStub = CarManagementServiceGrpc.newBlockingStub(carManagementChannel);

        this.userChannel = ManagedChannelBuilder.forAddress("localhost", 5055)
                .usePlaintext()
                .build();
        this.userStub = UserServiceGrpc.newBlockingStub(userChannel);
    }

    // Method to interact with Payment Service
    public void processPayment(String userId, String carId, double amount, String paymentMethod) {
        PaymentServiceProto.ProcessPaymentRequest request = PaymentServiceProto.ProcessPaymentRequest.newBuilder()
                .setUserId(userId)
                .setCarId(carId)
                .setAmount(amount)
                .setPaymentMethod(paymentMethod)
                .build();

        PaymentServiceProto.ProcessPaymentResponse response = paymentStub.processPayment(request);
        System.out.println("Payment Response: " + response.getMessage());
    }

    // Method to interact with RideShare Service
    public void offerRide(String carId, int seatsAvailable, String route) {
        RideShareServiceProto.OfferRideRequest request = RideShareServiceProto.OfferRideRequest.newBuilder()
                .setCarId(carId)
                .setSeatsAvailable(seatsAvailable)
                .setRoute(route)
                .build();

        RideShareServiceProto.OfferRideResponse response = rideShareStub.offerRide(request);
        System.out.println("RideShare Response: " + response.getMessage());
    }

    // Method to add a car to the Car Management Service
    public void addCar(String make, String model, String year, String location) {
        CarOuterClass.AddCarRequest request = CarOuterClass.AddCarRequest.newBuilder()
                .setMake(make)
                .setModel(model)
                .setYear(year)
                .setLocation(location)
                .build();

        CarOuterClass.AddCarResponse response = carManagementStub.addCar(request);
        System.out.println("Car Management Response: " + response.getMessage());
    }

    public void registerUser(String username, String password, String email) {
        User.RegisterUserRequest request = User.RegisterUserRequest.newBuilder()
                .setUsername(username)
                .setPassword(password)
                .setEmail(email)
                .build();

        User.RegisterUserResponse response = userStub.registerUser(request);
        System.out.println("User Registration Response: " + response.getMessage());
    }

    // Shut down all channels
    public void shutdown() {
        paymentChannel.shutdown();
        rideShareChannel.shutdown();
        carManagementChannel.shutdown();
        userChannel.shutdown();
    }

    public static void main(String[] args) {
        ManagedChannels brokerService = new ManagedChannels();

        // Test interactions
        brokerService.processPayment("user1", "car1", 150.0, "CreditCard");
        brokerService.offerRide("car1", 3, "City Center to Airport");
        brokerService.registerUser("john_doe", "securePassword", "john.doe@example.com");
        brokerService.addCar("Toyota", "Corolla", "2020", "Location A");

        brokerService.shutdown();
    }
}
