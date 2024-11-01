package RideShareService.grpcspringbootexample;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * GRPC functions offered by micro service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.56.0)",
    comments = "Source: Rideshare.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RideShareServiceGrpc {

  private RideShareServiceGrpc() {}

  public static final String SERVICE_NAME = "RideShareService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<RideShareService.grpcspringbootexample.OfferRideRequest,
      RideShareService.grpcspringbootexample.OfferRideResponse> getOfferRideMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OfferRide",
      requestType = RideShareService.grpcspringbootexample.OfferRideRequest.class,
      responseType = RideShareService.grpcspringbootexample.OfferRideResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<RideShareService.grpcspringbootexample.OfferRideRequest,
      RideShareService.grpcspringbootexample.OfferRideResponse> getOfferRideMethod() {
    io.grpc.MethodDescriptor<RideShareService.grpcspringbootexample.OfferRideRequest, RideShareService.grpcspringbootexample.OfferRideResponse> getOfferRideMethod;
    if ((getOfferRideMethod = RideShareServiceGrpc.getOfferRideMethod) == null) {
      synchronized (RideShareServiceGrpc.class) {
        if ((getOfferRideMethod = RideShareServiceGrpc.getOfferRideMethod) == null) {
          RideShareServiceGrpc.getOfferRideMethod = getOfferRideMethod =
              io.grpc.MethodDescriptor.<RideShareService.grpcspringbootexample.OfferRideRequest, RideShareService.grpcspringbootexample.OfferRideResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OfferRide"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpcspringbootexample.OfferRideRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpcspringbootexample.OfferRideResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RideShareServiceMethodDescriptorSupplier("OfferRide"))
              .build();
        }
      }
    }
    return getOfferRideMethod;
  }

  private static volatile io.grpc.MethodDescriptor<RideShareService.grpcspringbootexample.BookSeatRequest,
      RideShareService.grpcspringbootexample.BookSeatResponse> getBookSeatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BookSeat",
      requestType = RideShareService.grpcspringbootexample.BookSeatRequest.class,
      responseType = RideShareService.grpcspringbootexample.BookSeatResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<RideShareService.grpcspringbootexample.BookSeatRequest,
      RideShareService.grpcspringbootexample.BookSeatResponse> getBookSeatMethod() {
    io.grpc.MethodDescriptor<RideShareService.grpcspringbootexample.BookSeatRequest, RideShareService.grpcspringbootexample.BookSeatResponse> getBookSeatMethod;
    if ((getBookSeatMethod = RideShareServiceGrpc.getBookSeatMethod) == null) {
      synchronized (RideShareServiceGrpc.class) {
        if ((getBookSeatMethod = RideShareServiceGrpc.getBookSeatMethod) == null) {
          RideShareServiceGrpc.getBookSeatMethod = getBookSeatMethod =
              io.grpc.MethodDescriptor.<RideShareService.grpcspringbootexample.BookSeatRequest, RideShareService.grpcspringbootexample.BookSeatResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BookSeat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpcspringbootexample.BookSeatRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpcspringbootexample.BookSeatResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RideShareServiceMethodDescriptorSupplier("BookSeat"))
              .build();
        }
      }
    }
    return getBookSeatMethod;
  }

  private static volatile io.grpc.MethodDescriptor<RideShareService.grpcspringbootexample.TimePlace,
      RideShareService.grpcspringbootexample.AvailableRideshare> getGetClosestSuggestionsResultsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getClosestSuggestionsResults",
      requestType = RideShareService.grpcspringbootexample.TimePlace.class,
      responseType = RideShareService.grpcspringbootexample.AvailableRideshare.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<RideShareService.grpcspringbootexample.TimePlace,
      RideShareService.grpcspringbootexample.AvailableRideshare> getGetClosestSuggestionsResultsMethod() {
    io.grpc.MethodDescriptor<RideShareService.grpcspringbootexample.TimePlace, RideShareService.grpcspringbootexample.AvailableRideshare> getGetClosestSuggestionsResultsMethod;
    if ((getGetClosestSuggestionsResultsMethod = RideShareServiceGrpc.getGetClosestSuggestionsResultsMethod) == null) {
      synchronized (RideShareServiceGrpc.class) {
        if ((getGetClosestSuggestionsResultsMethod = RideShareServiceGrpc.getGetClosestSuggestionsResultsMethod) == null) {
          RideShareServiceGrpc.getGetClosestSuggestionsResultsMethod = getGetClosestSuggestionsResultsMethod =
              io.grpc.MethodDescriptor.<RideShareService.grpcspringbootexample.TimePlace, RideShareService.grpcspringbootexample.AvailableRideshare>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getClosestSuggestionsResults"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpcspringbootexample.TimePlace.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpcspringbootexample.AvailableRideshare.getDefaultInstance()))
              .setSchemaDescriptor(new RideShareServiceMethodDescriptorSupplier("getClosestSuggestionsResults"))
              .build();
        }
      }
    }
    return getGetClosestSuggestionsResultsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RideShareServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RideShareServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RideShareServiceStub>() {
        @java.lang.Override
        public RideShareServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RideShareServiceStub(channel, callOptions);
        }
      };
    return RideShareServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RideShareServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RideShareServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RideShareServiceBlockingStub>() {
        @java.lang.Override
        public RideShareServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RideShareServiceBlockingStub(channel, callOptions);
        }
      };
    return RideShareServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RideShareServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RideShareServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RideShareServiceFutureStub>() {
        @java.lang.Override
        public RideShareServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RideShareServiceFutureStub(channel, callOptions);
        }
      };
    return RideShareServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * GRPC functions offered by micro service
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     *Add Booking
     * </pre>
     */
    default void offerRide(RideShareService.grpcspringbootexample.OfferRideRequest request,
        io.grpc.stub.StreamObserver<RideShareService.grpcspringbootexample.OfferRideResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOfferRideMethod(), responseObserver);
    }

    /**
     */
    default void bookSeat(RideShareService.grpcspringbootexample.BookSeatRequest request,
        io.grpc.stub.StreamObserver<RideShareService.grpcspringbootexample.BookSeatResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBookSeatMethod(), responseObserver);
    }

    /**
     * <pre>
     *Pseudo get all function for now
     * </pre>
     */
    default void getClosestSuggestionsResults(RideShareService.grpcspringbootexample.TimePlace request,
        io.grpc.stub.StreamObserver<RideShareService.grpcspringbootexample.AvailableRideshare> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetClosestSuggestionsResultsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service RideShareService.
   * <pre>
   * GRPC functions offered by micro service
   * </pre>
   */
  public static abstract class RideShareServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return RideShareServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service RideShareService.
   * <pre>
   * GRPC functions offered by micro service
   * </pre>
   */
  public static final class RideShareServiceStub
      extends io.grpc.stub.AbstractAsyncStub<RideShareServiceStub> {
    private RideShareServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RideShareServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RideShareServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *Add Booking
     * </pre>
     */
    public void offerRide(RideShareService.grpcspringbootexample.OfferRideRequest request,
        io.grpc.stub.StreamObserver<RideShareService.grpcspringbootexample.OfferRideResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOfferRideMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bookSeat(RideShareService.grpcspringbootexample.BookSeatRequest request,
        io.grpc.stub.StreamObserver<RideShareService.grpcspringbootexample.BookSeatResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBookSeatMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Pseudo get all function for now
     * </pre>
     */
    public void getClosestSuggestionsResults(RideShareService.grpcspringbootexample.TimePlace request,
        io.grpc.stub.StreamObserver<RideShareService.grpcspringbootexample.AvailableRideshare> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetClosestSuggestionsResultsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service RideShareService.
   * <pre>
   * GRPC functions offered by micro service
   * </pre>
   */
  public static final class RideShareServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RideShareServiceBlockingStub> {
    private RideShareServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RideShareServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RideShareServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Add Booking
     * </pre>
     */
    public RideShareService.grpcspringbootexample.OfferRideResponse offerRide(RideShareService.grpcspringbootexample.OfferRideRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOfferRideMethod(), getCallOptions(), request);
    }

    /**
     */
    public RideShareService.grpcspringbootexample.BookSeatResponse bookSeat(RideShareService.grpcspringbootexample.BookSeatRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBookSeatMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Pseudo get all function for now
     * </pre>
     */
    public RideShareService.grpcspringbootexample.AvailableRideshare getClosestSuggestionsResults(RideShareService.grpcspringbootexample.TimePlace request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetClosestSuggestionsResultsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service RideShareService.
   * <pre>
   * GRPC functions offered by micro service
   * </pre>
   */
  public static final class RideShareServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<RideShareServiceFutureStub> {
    private RideShareServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RideShareServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RideShareServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *Add Booking
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<RideShareService.grpcspringbootexample.OfferRideResponse> offerRide(
        RideShareService.grpcspringbootexample.OfferRideRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOfferRideMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<RideShareService.grpcspringbootexample.BookSeatResponse> bookSeat(
        RideShareService.grpcspringbootexample.BookSeatRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBookSeatMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *Pseudo get all function for now
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<RideShareService.grpcspringbootexample.AvailableRideshare> getClosestSuggestionsResults(
        RideShareService.grpcspringbootexample.TimePlace request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetClosestSuggestionsResultsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_OFFER_RIDE = 0;
  private static final int METHODID_BOOK_SEAT = 1;
  private static final int METHODID_GET_CLOSEST_SUGGESTIONS_RESULTS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_OFFER_RIDE:
          serviceImpl.offerRide((RideShareService.grpcspringbootexample.OfferRideRequest) request,
              (io.grpc.stub.StreamObserver<RideShareService.grpcspringbootexample.OfferRideResponse>) responseObserver);
          break;
        case METHODID_BOOK_SEAT:
          serviceImpl.bookSeat((RideShareService.grpcspringbootexample.BookSeatRequest) request,
              (io.grpc.stub.StreamObserver<RideShareService.grpcspringbootexample.BookSeatResponse>) responseObserver);
          break;
        case METHODID_GET_CLOSEST_SUGGESTIONS_RESULTS:
          serviceImpl.getClosestSuggestionsResults((RideShareService.grpcspringbootexample.TimePlace) request,
              (io.grpc.stub.StreamObserver<RideShareService.grpcspringbootexample.AvailableRideshare>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getOfferRideMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              RideShareService.grpcspringbootexample.OfferRideRequest,
              RideShareService.grpcspringbootexample.OfferRideResponse>(
                service, METHODID_OFFER_RIDE)))
        .addMethod(
          getBookSeatMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              RideShareService.grpcspringbootexample.BookSeatRequest,
              RideShareService.grpcspringbootexample.BookSeatResponse>(
                service, METHODID_BOOK_SEAT)))
        .addMethod(
          getGetClosestSuggestionsResultsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              RideShareService.grpcspringbootexample.TimePlace,
              RideShareService.grpcspringbootexample.AvailableRideshare>(
                service, METHODID_GET_CLOSEST_SUGGESTIONS_RESULTS)))
        .build();
  }

  private static abstract class RideShareServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RideShareServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return RideShareService.grpcspringbootexample.Rideshare.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RideShareService");
    }
  }

  private static final class RideShareServiceFileDescriptorSupplier
      extends RideShareServiceBaseDescriptorSupplier {
    RideShareServiceFileDescriptorSupplier() {}
  }

  private static final class RideShareServiceMethodDescriptorSupplier
      extends RideShareServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RideShareServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RideShareServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RideShareServiceFileDescriptorSupplier())
              .addMethod(getOfferRideMethod())
              .addMethod(getBookSeatMethod())
              .addMethod(getGetClosestSuggestionsResultsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
