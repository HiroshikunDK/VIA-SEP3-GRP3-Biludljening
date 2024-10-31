package Service;

import CarManagementService.grpc.CarManagement;
import CarManagementService.grpc.CarServiceGrpc;
import Persistence.DataBaseHelper;
import io.grpc.stub.StreamObserver;
import Model.Car;

public class CarService extends CarServiceGrpc.CarServiceImplBase
{

  private final DataBaseHelper dataBaseHelper;

  public CarService(DataBaseHelper dataBaseHelper)
  {
    this.dataBaseHelper = dataBaseHelper;
  }

  @Override public void addCar(CarManagement.Car request, StreamObserver<CarManagement.CarResponse> responseObserver)
  {
    System.out.println(request.getVin());
    System.out.println(request.getCarId());
    // Make a new car object
    Car car = new Car(request.getCarId(), request.getVin(), request.getYearproduced(),
        request.getManufactor(), request.getModel(), request.getColor(), request.getAltname(),
        request.getSeats(), request.getCarrange(), request.getLocationhubref());

    dataBaseHelper.registerCar(car);
    responseObserver.onNext(CarManagement.CarResponse.newBuilder().build());
    responseObserver.onCompleted();
  }

  public void getAllCars(StreamObserver<CarManagement.CarResponse> responseObserver)
  {

  }


}
