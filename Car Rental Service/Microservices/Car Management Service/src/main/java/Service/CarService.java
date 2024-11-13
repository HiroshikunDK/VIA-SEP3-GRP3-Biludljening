package Service;

import CarManagementService.grpc.CarManagement;
import CarManagementService.grpc.CarServiceGrpc;
import Model.Car;
import Repository.CarRepository;
import io.grpc.stub.StreamObserver;

import java.util.Optional;
import java.util.stream.Collectors;

public class CarService extends CarServiceGrpc.CarServiceImplBase {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void getAllCars(CarManagement.Empty request, StreamObserver<CarManagement.CarList> responseObserver) {
        CarManagement.CarList.Builder builder = CarManagement.CarList.newBuilder();
        builder.addAllCars(carRepository.getAllCars().stream()
                .map(this::convertToProtoCar)
                .collect(Collectors.toList()));
        CarManagement.CarList carList = builder
                .build();
        responseObserver.onNext(carList);
        responseObserver.onCompleted();
    }

    @Override
    public void getCarByID(CarManagement.CarRequest request, StreamObserver<CarManagement.CarResponse> responseObserver) {
        Optional<Car> carOptional = carRepository.getCarById(Integer.parseInt(request.getCarId()));
        CarManagement.CarResponse response = carOptional.map(car -> CarManagement.CarResponse.newBuilder()
                        .setSuccess(true)
                        .setMessage("Car found")
                        .setCar(convertToProtoCar(car))
                        .build())
                .orElse(CarManagement.CarResponse.newBuilder()
                        .setSuccess(false)
                        .setMessage("Car not found")
                        .build());

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void addCar(CarManagement.Car request, StreamObserver<CarManagement.CarResponse> responseObserver) {
        // Create a new Car instance using all fields from the request
        Car newCar = new Car(
            0,
            request.getVin(),
            request.getYearproduced(),
            request.getManufactor(),
            request.getModel(),
            request.getColor(),
            request.getAltname(),
            request.getSeats(),
            request.getCarrange(),
            request.getLocationhubref()
        );

        // Add business logic to save 'newCar' to the database, e.g., using Hibernate
        carRepository.addCar(newCar);

        // Build and return a response
        CarManagement.CarResponse response = CarManagement.CarResponse.newBuilder()
            .setSuccess(true)
            .setMessage("Car added successfully.")
            .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void updateCar(CarManagement.Car request, StreamObserver<CarManagement.CarResponse> responseObserver) {
        // Create an updated Car instance using all fields from the request
        Car updatedCar = new Car(
            request.getCarId(),
            request.getVin(),
            request.getYearproduced(),
            request.getManufactor(),
            request.getModel(),
            request.getColor(),
            request.getAltname(),
            request.getSeats(),
            request.getCarrange(),
            request.getLocationhubref()
        );

        // Call the repository to update the car in the database
        carRepository.updateCar(updatedCar);

        // Build and return a response
        CarManagement.CarResponse response = CarManagement.CarResponse.newBuilder()
            .setSuccess(true)
            .setMessage("Car updated successfully")
            .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void deleteCar(CarManagement.CarRequest request, StreamObserver<CarManagement.CarResponse> responseObserver) {
        boolean success = carRepository.deleteCar(Integer.parseInt(request.getCarId()));
        CarManagement.CarResponse response = CarManagement.CarResponse.newBuilder()
                .setSuccess(success)
                .setMessage(success ? "Car deleted successfully" : "Car not found")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private CarManagement.Car convertToProtoCar(Car car) {
        return CarManagement.Car.newBuilder()
                .setCarId(car.getCarId())
                .setModel(car.getModel())
                .setColor(car.getColor())
                .setSeats(car.getSeats())
                .build();

    }
}
