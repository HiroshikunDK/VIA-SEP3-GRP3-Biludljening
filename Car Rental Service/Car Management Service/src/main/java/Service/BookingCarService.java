package Service;

import CarManagementService.grpc.CarManagement;
import CarManagementService.grpc.BookingCarServiceGrpc;
import Model.BookingCar;
import Repository.BookingCarRepository;
import io.grpc.stub.StreamObserver;

import java.util.Optional;
import java.util.stream.Collectors;

public class BookingCarService extends BookingCarServiceGrpc.BookingCarServiceImplBase {
  private final BookingCarRepository bookingCarRepository;

  public BookingCarService(BookingCarRepository bookingCarRepository) {
    this.bookingCarRepository = bookingCarRepository;
  }

  @Override
  public void getAllBookingCars(CarManagement.Empty request, StreamObserver<CarManagement.BookingCarList> responseObserver) {
    CarManagement.BookingCarList.Builder builder = CarManagement.BookingCarList.newBuilder();
    builder.addAllBookingCars(bookingCarRepository.getAllBookingCars().stream()
        .map(this::convertToProtoBookingCar)
        .collect(Collectors.toList()));
    CarManagement.BookingCarList bookingCarList = builder.build();
    responseObserver.onNext(bookingCarList);
    responseObserver.onCompleted();
  }

  @Override
  public void getBookingCarByID(CarManagement.BookingCarRequest request, StreamObserver<CarManagement.BookingCarResponse> responseObserver) {
    Optional<BookingCar> bookingCarOptional = bookingCarRepository.getBookingCarById((request.getBookingNr()));
    CarManagement.BookingCarResponse response = bookingCarOptional.map(bookingCar ->
            CarManagement.BookingCarResponse.newBuilder()
                .setSuccess(true)
                .setMessage("Booking car found")
                .setBookingCar(convertToProtoBookingCar(bookingCar))
                .build())
        .orElse(CarManagement.BookingCarResponse.newBuilder()
            .setSuccess(false)
            .setMessage("Booking car not found")
            .build());

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void addBookingCar(CarManagement.BookingCar request, StreamObserver<CarManagement.BookingCarResponse> responseObserver) {
    try {
      if (request.getCustomerid() <= 0 || request.getCarid() <= 0) {
        throw new IllegalArgumentException("Invalid customer or car ID.");
      }

      BookingCar newBookingCar = new BookingCar(
              0,
              request.getStatus(),
              request.getStartdato(),
              request.getStarttime(),
              request.getEnddate(),
              request.getEndtime(),
              request.getPrice(),
              request.getGreenshare(),
              request.getCarid(),
              request.getCustomerid()
      );

      BookingCar savedBookingCar = bookingCarRepository.addBookingCar(newBookingCar);

      CarManagement.BookingCarResponse response = CarManagement.BookingCarResponse.newBuilder()
              .setSuccess(true)
              .setMessage("Booking car added successfully.")
              .setBookingnr(savedBookingCar.getBookingNr())
              .build();

      responseObserver.onNext(response);
    } catch (IllegalArgumentException e) {
      responseObserver.onNext(CarManagement.BookingCarResponse.newBuilder()
              .setSuccess(false)
              .setMessage("Validation error: " + e.getMessage())
              .build());
    } catch (Exception e) {
      e.printStackTrace();
      responseObserver.onNext(CarManagement.BookingCarResponse.newBuilder()
              .setSuccess(false)
              .setMessage("Failed to add booking car: " + e.getMessage())
              .build());
    } finally {
      responseObserver.onCompleted();
    }
  }



  @Override
  public void updateBookingCar(CarManagement.BookingCar request, StreamObserver<CarManagement.BookingCarResponse> responseObserver) {
    // Create an updated BookingCar instance using all fields from the request
    BookingCar updatedBookingCar = new BookingCar(
        request.getBookingnr(),
        request.getStatus(),
        request.getStartdato(),
        request.getStarttime(),
        request.getEnddate(),
        request.getEndtime(),
        request.getPrice(),
        request.getGreenshare(),
        request.getCarid(),
        request.getCustomerid()
    );

    // Call the repository to update the booking car in the database
    bookingCarRepository.updateBookingCar(updatedBookingCar);

    // Build and return a response
    CarManagement.BookingCarResponse response = CarManagement.BookingCarResponse.newBuilder()
        .setSuccess(true)
        .setMessage("Booking car updated successfully")
        .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void deleteBookingCar(CarManagement.BookingCarRequest request, StreamObserver<CarManagement.BookingCarResponse> responseObserver) {
    boolean success = bookingCarRepository.deleteBookingCar(request.getBookingNr());
    CarManagement.BookingCarResponse response = CarManagement.BookingCarResponse.newBuilder()
        .setSuccess(success)
        .setMessage(success ? "Booking car deleted successfully" : "Booking car not found")
        .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  // Convert a BookingCar entity to a BookingCar protobuf object
  private CarManagement.BookingCar convertToProtoBookingCar(BookingCar bookingCar) {
    return CarManagement.BookingCar.newBuilder()
        .setBookingnr(bookingCar.getBookingNr())
        .setStatus(bookingCar.getStatus())
        .setStartdato(bookingCar.getStartDate())
        .setStarttime(bookingCar.getStartTime())
        .setEnddate(bookingCar.getEndDate())
        .setEndtime(bookingCar.getEndTime())
        .setPrice(bookingCar.getPrice())
        .setGreenshare(bookingCar.getGreenShare())
        .setCarid(bookingCar.getCarId())
        .setCustomerid(bookingCar.getCustomerId())
        .build();
  }
}
