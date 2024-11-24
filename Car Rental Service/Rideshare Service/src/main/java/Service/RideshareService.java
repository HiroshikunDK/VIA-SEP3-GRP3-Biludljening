package Service;

import Model.RideShareOffer;
import Model.RideShareRequest;
import Repository.RideShareOfferHibernateImpl;
import Repository.RideShareRequestHibernateImpl;
import Repository.RideshareRepository;
import RideShareService.grpc.RideShareServiceGrpc;
import RideShareService.grpc.Rideshare;
import io.grpc.stub.StreamObserver;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RideshareService extends RideShareServiceGrpc.RideShareServiceImplBase {
    private final RideshareRepository rideshareRepository;
    private final RideShareOfferHibernateImpl rideShareOfferHibernate;
    private final RideShareRequestHibernateImpl rideShareRequestHibernate;

    public RideshareService(RideshareRepository rideshareRepository,
                            RideShareOfferHibernateImpl rideShareOfferHibernate,
                            RideShareRequestHibernateImpl rideShareRequestHibernate) {
        this.rideshareRepository = rideshareRepository;
        this.rideShareOfferHibernate = rideShareOfferHibernate;
        this.rideShareRequestHibernate = rideShareRequestHibernate;
    }

    @Override
    public void createRideShare(Rideshare.CreateRideShareRequestTest request, StreamObserver<Rideshare.RideShareResponse> responseObserver) {
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

    @Override
    public void createRideShareOffer(Rideshare.RideshareOffer request, StreamObserver<Rideshare.RideShareResponse> responseObserver) {
        try {
            // Convert the gRPC RideshareOffer request into the domain model
            RideShareOffer offer = new RideShareOffer(
                    request.getRideId(),
                    request.getAvailablespaces(),
                    request.getStatus(),
                    request.getStartdate(),
                    request.getStarttime(),
                    request.getStartlocation(),
                    request.getEnddate(),
                    request.getEndtime(),
                    request.getEndlocation(),
                    request.getPrice(),
                    request.getCustomerid(),
                    request.getBookingref()
            );

            // Call the repository to create the RideShareOffer
            rideShareOfferHibernate.create(offer);

            // Send the success response
            Rideshare.RideShareResponse response = Rideshare.RideShareResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("RideShareOffer created successfully")
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            // Handle errors and send failure response
            Rideshare.RideShareResponse response = Rideshare.RideShareResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Error creating RideShareOffer: " + e.getMessage())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void readRideShareOffer(Rideshare.RideShareIDRequest request, StreamObserver<Rideshare.RideshareOffer> responseObserver) {
        try {
            // Retrieve the RideShareOffer from the repository using the provided rideId
            RideShareOffer offer = rideShareOfferHibernate.read(request.getRideId());

            // If offer is found, return it as a protobuf message
            if (offer != null) {
                Rideshare.RideshareOffer response = convertToProtoRideShareOffer(offer);
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            } else {
                // If the offer is not found, send an error response
                Rideshare.RideshareOffer response = Rideshare.RideshareOffer.newBuilder()
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        } catch (Exception e) {
            // Handle any errors and send failure response
            Rideshare.RideshareOffer response = Rideshare.RideshareOffer.newBuilder()
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void readAllRideShareOffer(com.google.protobuf.Empty request, StreamObserver<Rideshare.RideshareOfferList> responseObserver) {
        try {
            // Fetch all RideShareOffers from the repository
            List<RideShareOffer> offers = rideShareOfferHibernate.readAll();

            // Map the collection of RideShareOffer domain objects to a list of protobuf messages
            Rideshare.RideshareOfferList.Builder responseBuilder = Rideshare.RideshareOfferList.newBuilder();
            for (RideShareOffer offer : offers) {
                Rideshare.RideshareOffer offerProto = convertToProtoRideShareOffer(offer);
                responseBuilder.addResultList(offerProto);
            }

            // Build the response and send it back
            Rideshare.RideshareOfferList response = responseBuilder.build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            // Handle any errors and send failure response
            Rideshare.RideshareOfferList response = Rideshare.RideshareOfferList.newBuilder()
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void updateRideShareOffer(Rideshare.RideshareOffer request, StreamObserver<Rideshare.RideShareResponse> responseObserver) {
        try {
            // Fetch the existing RideShareOffer from the repository using the provided rideId
            RideShareOffer offer = rideShareOfferHibernate.read(request.getRideId());

            if (offer != null) {
                // Update the offer details with the new information from the request
                offer.setAvailableSpaces(request.getAvailablespaces());
                offer.setStatus(request.getStatus());
                offer.setStartDate(request.getStartdate());
                offer.setStartTime(request.getStarttime());
                offer.setStartLocation(request.getStartlocation());
                offer.setEndDate(request.getEnddate());
                offer.setEndTime(request.getEndtime());
                offer.setEndLocation(request.getEndlocation());
                offer.setPrice(request.getPrice());
                offer.setCustomerId(request.getCustomerid());
                offer.setBookingRef(request.getBookingref());

                // Save the updated offer back to the repository
                rideShareOfferHibernate.update(offer);

                // Send a success response
                Rideshare.RideShareResponse response = Rideshare.RideShareResponse.newBuilder()
                        .setSuccess(true)
                        .setMessage("RideShareOffer updated successfully")
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            } else {
                // If the offer does not exist, send an error message
                Rideshare.RideShareResponse response = Rideshare.RideShareResponse.newBuilder()
                        .setSuccess(false)
                        .setMessage("RideShareOffer not found for rideId: " + request.getRideId())
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        } catch (Exception e) {
            // Handle any errors and send a failure response
            Rideshare.RideShareResponse response = Rideshare.RideShareResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Error updating RideShareOffer: " + e.getMessage())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void deleteRideShareOffer(Rideshare.RideShareIDRequest request, StreamObserver<Rideshare.RideShareResponse> responseObserver) {
        try {
            // Fetch the RideShareOffer from the repository using the provided rideId
            RideShareOffer offer = rideShareOfferHibernate.read(request.getRideId());

            if (offer != null) {
                // Delete the offer from the repository
                rideShareOfferHibernate.delete(request.getRideId());

                // Send a success response
                Rideshare.RideShareResponse response = Rideshare.RideShareResponse.newBuilder()
                        .setSuccess(true)
                        .setMessage("RideShareOffer deleted successfully")
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            } else {
                // If the offer does not exist, send an error message
                Rideshare.RideShareResponse response = Rideshare.RideShareResponse.newBuilder()
                        .setSuccess(false)
                        .setMessage("RideShareOffer not found for rideId: " + request.getRideId())
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        } catch (Exception e) {
            // Handle any errors and send a failure response
            Rideshare.RideShareResponse response = Rideshare.RideShareResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Error deleting RideShareOffer: " + e.getMessage())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void createRideShareRequest(Rideshare.RideshareRequest request, StreamObserver<Rideshare.RideShareResponse> responseObserver) {
        try {
            // Create a new RideShareRequest domain object from the request
            RideShareRequest rideShareRequest = new RideShareRequest(
                    request.getRideId(),
                    request.getStatus(),
                    request.getStartdate(),
                    request.getStarttime(),
                    request.getStartlocation(),
                    request.getEnddate(),
                    request.getEndtime(),
                    request.getEndlocation(),
                    request.getPrice(),
                    request.getCustomerid(),
                    request.getBookingref()
            );

            // Save the new RideShareRequest to the repository
            rideShareRequestHibernate.create(rideShareRequest);

            // Send a success response
            Rideshare.RideShareResponse response = Rideshare.RideShareResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("RideShareRequest created successfully")
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            // Handle any errors and send a failure response
            Rideshare.RideShareResponse response = Rideshare.RideShareResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Error creating RideShareRequest: " + e.getMessage())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void readRideShareRequest(Rideshare.RideShareIDRequest request, StreamObserver<Rideshare.RideshareRequest> responseObserver) {
        try {
            // Fetch the RideShareRequest from the repository
            RideShareRequest requestRecord = rideShareRequestHibernate.read(request.getRideId());

            if (requestRecord != null) {
                // Convert the requestRecord to a protobuf message
                Rideshare.RideshareRequest response = convertToProtoRideShareRequest(requestRecord);
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            } else {
                // If not found, send an error message
                Rideshare.RideshareRequest response = Rideshare.RideshareRequest.newBuilder()
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        } catch (Exception e) {
            // Handle any errors and send a failure response
            Rideshare.RideshareRequest response = Rideshare.RideshareRequest.newBuilder()
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void readAllRideShareRequest(com.google.protobuf.Empty request, StreamObserver<Rideshare.RideShareRequestList> responseObserver) {
        try {
            // Fetch all RideShareRequests from the repository
            List<RideShareRequest> requests = rideShareRequestHibernate.readAll();

            // Map the collection of RideShareRequest domain objects to protobuf messages
            Rideshare.RideShareRequestList.Builder responseBuilder = Rideshare.RideShareRequestList.newBuilder();
            for (RideShareRequest requestRecord : requests) {
                responseBuilder.addResultList(convertToProtoRideShareRequest(requestRecord));
            }

            // Send the list of requests
            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            // Handle any errors and send a failure response
            Rideshare.RideShareRequestList response = Rideshare.RideShareRequestList.newBuilder()
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void updateRideShareRequest(Rideshare.RideshareRequest request, StreamObserver<Rideshare.RideShareResponse> responseObserver) {
        try {
            // Convert the protobuf request to a domain object (RideShareRequest)
            RideShareRequest rideShareRequest = new RideShareRequest(
                    request.getRideId(),
                    request.getStatus(),
                    request.getStartdate(),
                    request.getStarttime(),
                    request.getStartlocation(),
                    request.getEnddate(),
                    request.getEndtime(),
                    request.getEndlocation(),
                    request.getPrice(),
                    request.getCustomerid(),
                    request.getBookingref()
            );

            // Update the request in the repository
            rideShareRequestHibernate.update(rideShareRequest);

            // Prepare the response
            Rideshare.RideShareResponse response = Rideshare.RideShareResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("RideShareRequest updated successfully")
                    .build();

            // Send the response
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            // Handle any errors and send a failure response
            Rideshare.RideShareResponse response = Rideshare.RideShareResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Error updating RideShareRequest: " + e.getMessage())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void deleteRideShareRequest(Rideshare.RideShareIDRequest request, StreamObserver<Rideshare.RideShareResponse> responseObserver) {
        try {
            // Delete the RideShareRequest from the repository using the provided rideId
            rideShareRequestHibernate.delete(request.getRideId());

            // Prepare the response
            Rideshare.RideShareResponse response = Rideshare.RideShareResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("RideShareRequest deleted successfully")
                    .build();

            // Send the response
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            // Handle any errors and send a failure response
            Rideshare.RideShareResponse response = Rideshare.RideShareResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Error deleting RideShareRequest: " + e.getMessage())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getClosestRideShareRequest(Rideshare.RideshareRequest request, StreamObserver<Rideshare.RideshareOfferList> responseObserver) {
        try {
            //TODO: Implement business logic for determining which offer are closest
            List<RideShareOffer> closestOffers = rideShareOfferHibernate.readAll();

            // Convert the list of RideShareRequests to protobuf format
            Rideshare.RideshareOfferList.Builder responseBuilder = Rideshare.RideshareOfferList.newBuilder();
            for (RideShareOffer rideShareOffer : closestOffers) {
                responseBuilder.addResultList(convertToProtoRideShareOffer(rideShareOffer)); // Assuming you have a function for this conversion
            }

            // Send the response
            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            // Handle any errors and send a failure response
            Rideshare.RideshareOfferList response = Rideshare.RideshareOfferList.newBuilder()
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getAllRideShareOffersByUserID(Rideshare.RideShareIDRequest request, StreamObserver<Rideshare.RideshareOfferList> responseObserver) {
        try {
            // Retrieve all RideShareOffers for the given userId (customerId)
            List<RideShareOffer> offers = rideShareOfferHibernate.ReadAllByCustomerId(request.getRideId());

            // Convert the list of RideShareOffers to protobuf format
            Rideshare.RideshareOfferList.Builder responseBuilder = Rideshare.RideshareOfferList.newBuilder();
            for (RideShareOffer offer : offers) {
                responseBuilder.addResultList(convertToProtoRideShareOffer(offer)); // Assuming you have a conversion function
            }

            // Send the response
            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            // Handle any errors and send a failure response
            Rideshare.RideshareOfferList response = Rideshare.RideshareOfferList.newBuilder()
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getAllRideShareRequestsByUserID(Rideshare.RideShareIDRequest request, StreamObserver<Rideshare.RideShareRequestList> responseObserver) {
        try {
            // Retrieve all RideShareRequests for the given userId (customerId)
            List<RideShareRequest> requests = rideShareRequestHibernate.ReadAllByCustomerId(request.getRideId());

            // Convert the list of RideShareRequests to protobuf format
            Rideshare.RideShareRequestList.Builder responseBuilder = Rideshare.RideShareRequestList.newBuilder();
            for (RideShareRequest requestRecord : requests) {
                responseBuilder.addResultList(convertToProtoRideShareRequest(requestRecord)); // Assuming you have a conversion function
            }

            // Send the response
            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            // Handle any errors and send a failure response
            Rideshare.RideShareRequestList response = Rideshare.RideShareRequestList.newBuilder()
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getAllRideShareOffersByBookingID(Rideshare.RideShareIDRequest request, StreamObserver<Rideshare.RideshareOfferList> responseObserver) {
        try {
            // Retrieve all RideShareOffers for the given booking ID - getRideId() returns booking ID
            List<RideShareOffer> offers = rideShareOfferHibernate.ReadAllByCarBookingRef(request.getRideId());

            // Convert the list of RideShareOffers to protobuf format
            Rideshare.RideshareOfferList.Builder responseBuilder = Rideshare.RideshareOfferList.newBuilder();
            for (RideShareOffer offer : offers) {
                responseBuilder.addResultList(convertToProtoRideShareOffer(offer)); // Assuming you have a conversion function
            }

            // Send the response
            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            // Handle any errors and send a failure response
            Rideshare.RideshareOfferList response = Rideshare.RideshareOfferList.newBuilder()
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }


    @Override
    public void getAllRideShareRequestsByRideOfferID(Rideshare.RideShareIDRequest request, StreamObserver<Rideshare.RideShareRequestList> responseObserver) {

        try{
            // Query the database for all RideShareRequests where getRideId() returns bookingref in booking table
            List<RideShareRequest> rideShareRequests = rideShareRequestHibernate.ReadAllByRideShareRequest(request.getRideId());

            // Convert the collection of RideShareRequest domain objects to their protobuf counterparts
            Rideshare.RideShareRequestList.Builder responseBuilder = Rideshare.RideShareRequestList.newBuilder();

            for (RideShareRequest rideShareRequest : rideShareRequests) {
                // Convert each RideShareRequest to its protobuf representation
                responseBuilder.addResultList(convertToProtoRideShareRequest(rideShareRequest));
            }

            // Build the final response object
            Rideshare.RideShareRequestList response = responseBuilder.build();

            // Send the response to the client
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e){
            //TODO: should be refactored into a log file
            System.out.println(e.getMessage());
        }
    }
    //Utility function for building model to proto message
    private Rideshare.RideshareOffer convertToProtoRideShareOffer(RideShareOffer offer) {
        return Rideshare.RideshareOffer.newBuilder()
                .setRideId(offer.getRideId())
                .setAvailablespaces(offer.getAvailableSpaces())
                .setStatus(offer.getStatus())
                .setStartdate(offer.getStartDate())
                .setStarttime(offer.getStartTime())
                .setStartlocation(offer.getStartLocation())
                .setEnddate(offer.getEndDate())
                .setEndtime(offer.getEndTime())
                .setEndlocation(offer.getEndLocation())
                .setPrice(offer.getPrice())
                .setCustomerid(offer.getCustomerId())
                .setBookingref(offer.getBookingRef())
                .build();
    }

    private Rideshare.RideshareRequest convertToProtoRideShareRequest(RideShareRequest request) {
        return Rideshare.RideshareRequest.newBuilder()
                .setRideId(request.getRideId())
                .setStatus(request.getStatus())
                .setStartdate(request.getStartDate())
                .setStarttime(request.getStartTime())
                .setStartlocation(request.getStartLocation())
                .setEnddate(request.getEndDate())
                .setEndtime(request.getEndTime())
                .setEndlocation(request.getEndLocation())
                .setPrice(request.getPrice())
                .setCustomerid(request.getCustomerId())
                .setBookingref(request.getBookingRef())
                .build();
    }


}
