package Service;

import CarManagementService.grpc.CarManagement;
import CarManagementService.grpc.LocationHubServiceGrpc;
import Model.Car;
import Model.LocationHub;
import Repository.LocationsHubRepository;
import io.grpc.stub.StreamObserver;

import java.util.Optional;
import java.util.stream.Collectors;

public class LocationHubService extends LocationHubServiceGrpc.LocationHubServiceImplBase
{
  private final LocationsHubRepository locationsHubRepository;

  public LocationHubService(LocationsHubRepository locationsHubRepository)
  {
    this.locationsHubRepository = locationsHubRepository;
  }

  @Override public void getAllLocationHubs(CarManagement.Empty request,
      StreamObserver<CarManagement.LocationHubList> responseObserver)
  {
    CarManagement.LocationHubList.Builder builder = CarManagement.LocationHubList.newBuilder();
    builder.addAllLocationhub(locationsHubRepository.getAllLocationHubs().stream().map(this::convertToProtoLocationHub).collect(
        Collectors.toList()));
    CarManagement.LocationHubList locationHubList = builder.build();
    responseObserver.onNext(locationHubList);
    responseObserver.onCompleted();
  }


  @Override public void getLocationHubByID (CarManagement.LocationHubRequest request, StreamObserver<CarManagement.LocationHubResponse> responseObserver)
  {
    Optional<LocationHub> locationHubOptional = locationsHubRepository.getLocationHubById(request.getId());
    CarManagement.LocationHubResponse response = locationHubOptional.map(locattion -> CarManagement.LocationHubResponse.newBuilder().setSuccess(true).setMessage("LocationHub found").setLocationHub(convertToProtoLocationHub(locattion)).build()).orElse(CarManagement.LocationHubResponse.newBuilder().setSuccess(false).setMessage("LocationHub not found").build());

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }


  @Override public void addLocationHub(CarManagement.LocationHub request, StreamObserver<CarManagement.LocationHubResponse> responseObserver)
  {
    LocationHub newLocationHub = new LocationHub(
        0, request.getLocationname(),
        request.getAddress(),
        request.getCity(),
        request.getCountry(),
        request.getEmail(),
        request.getPhonenr(),
        request.getCarcapacity()
    );

    locationsHubRepository.addLocationHub(newLocationHub);

    CarManagement.LocationHubResponse response = CarManagement.LocationHubResponse.newBuilder().setSuccess(true).setMessage("LocationHub added").build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override public void updateLocationHub(CarManagement.LocationHub request,
      StreamObserver<CarManagement.LocationHubResponse> responseObserver)
  {
    LocationHub updatedHub = new LocationHub(
        request.getId(),
        request.getLocationname(),
        request.getAddress(),
        request.getCity(),
        request.getCountry(),
        request.getEmail(),
        request.getPhonenr(),
        request.getCarcapacity()
    );

    locationsHubRepository.updateLocationHub(updatedHub);

    CarManagement.LocationHubResponse response = CarManagement.LocationHubResponse.newBuilder().setSuccess(true).setMessage("LocationHub updated").build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override public void deleteLocationHub(CarManagement.LocationHubRequest request,
      StreamObserver<CarManagement.LocationHubResponse> responseObserver)
  {
    boolean success = locationsHubRepository.deleteLocationHub(request.getId());
    CarManagement.LocationHubResponse response = CarManagement.LocationHubResponse.newBuilder().setSuccess(true).setMessage("LocationHub deleted").build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }



  private CarManagement.LocationHub convertToProtoLocationHub(LocationHub locationHub) {
    return CarManagement.LocationHub.newBuilder()
        .setId(locationHub.getId())
        .setLocationname(locationHub.getLocationName())
        .setAddress(locationHub.getAddress())
        .setCity(locationHub.getCity())
        .setCountry(locationHub.getCountry())
        .setEmail(locationHub.getEmail())
        .setPhonenr(locationHub.getPhoneNr())
        .setCarcapacity(locationHub.getCarCapacity())
        .build();
  }


}
