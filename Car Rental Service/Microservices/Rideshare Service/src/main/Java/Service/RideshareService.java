package Service;

import Repository.RideshareRepository;
import RideShareService.grpc.RideShareServiceGrpc;
import RideShareService.grpc.Rideshare;
import io.grpc.stub.StreamObserver;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RideshareService extends RideShareServiceGrpc.RideShareServiceImplBase {
    private final RideshareRepository rideshareRepository;

    public RideshareService(RideshareRepository rideshareRepository) {
        this.rideshareRepository = rideshareRepository;
    }

    @Override
    public void createRideShare(Rideshare.CreateRideShareRequest request, StreamObserver<Rideshare.RideShareResponse> responseObserver) {
        Model.Rideshare rideshare = new Model.Rideshare(request.getCarId(), request.getDriverUsername(), request.getAvailableSeats());
        rideshareRepository.createRideshare(rideshare);

        Rideshare.RideShareResponse response = Rideshare.RideShareResponse.newBuilder()
                .setSuccess(true)
                .setMessage("Rideshare created successfully")
                .setRideShare(convertToProtoRideshare(rideshare))
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void joinRideShare(Rideshare.JoinRideShareRequest request, StreamObserver<Rideshare.RideShareResponse> responseObserver) {
        Optional<Model.Rideshare> rideshareOptional = rideshareRepository.getRideshareById(request.getRideId());

        Rideshare.RideShareResponse response;
        if (rideshareOptional.isPresent()) {
            Model.Rideshare rideshare = rideshareOptional.get();
            if (rideshare.getAvailableSeats() > 0) {
                rideshare.addPassenger(request.getPassengerUsername());
                rideshareRepository.addPassenger(rideshare.getRideId(), request.getPassengerUsername());
                response = Rideshare.RideShareResponse.newBuilder()
                        .setSuccess(true)
                        .setMessage("Joined Rideshare successfully")
                        .setRideShare(convertToProtoRideshare(rideshare))
                        .build();
            } else {
                response = Rideshare.RideShareResponse.newBuilder()
                        .setSuccess(false)
                        .setMessage("No available seats")
                        .build();
            }
        } else {
            response = Rideshare.RideShareResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Rideshare not found")
                    .build();
        }

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void listRideShares(Rideshare.ListRideSharesRequest request, StreamObserver<Rideshare.RideShareListResponse> responseObserver) {
        List<Model.Rideshare> rideshares = rideshareRepository.listRideshares(request.getCarId());
        Rideshare.RideShareListResponse response = Rideshare.RideShareListResponse.newBuilder()
                .addAllRideShares(rideshares.stream()
                        .map(this::convertToProtoRideshare)
                        .collect(Collectors.toList()))
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private Rideshare.RideShare convertToProtoRideshare(Model.Rideshare rideshare) {
        return Rideshare.RideShare.newBuilder()
                .setRideId(rideshare.getRideId())
                .setCarId(rideshare.getCarId())
                .setDriverUsername(rideshare.getDriverUsername())
                .setAvailableSeats(rideshare.getAvailableSeats())
                .addAllPassengers(rideshare.getPassengers())
                .build();
    }
}
