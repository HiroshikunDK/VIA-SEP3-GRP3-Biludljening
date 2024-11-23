package CarManagementService.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * LocationHubService
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.56.0)",
    comments = "Source: CarManagement.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LocationHubServiceGrpc {

  private LocationHubServiceGrpc() {}

  public static final String SERVICE_NAME = "LocationHubService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.Empty,
      CarManagementService.grpc.CarManagement.LocationHubList> getGetAllLocationHubsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllLocationHubs",
      requestType = CarManagementService.grpc.CarManagement.Empty.class,
      responseType = CarManagementService.grpc.CarManagement.LocationHubList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.Empty,
      CarManagementService.grpc.CarManagement.LocationHubList> getGetAllLocationHubsMethod() {
    io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.Empty, CarManagementService.grpc.CarManagement.LocationHubList> getGetAllLocationHubsMethod;
    if ((getGetAllLocationHubsMethod = LocationHubServiceGrpc.getGetAllLocationHubsMethod) == null) {
      synchronized (LocationHubServiceGrpc.class) {
        if ((getGetAllLocationHubsMethod = LocationHubServiceGrpc.getGetAllLocationHubsMethod) == null) {
          LocationHubServiceGrpc.getGetAllLocationHubsMethod = getGetAllLocationHubsMethod =
              io.grpc.MethodDescriptor.<CarManagementService.grpc.CarManagement.Empty, CarManagementService.grpc.CarManagement.LocationHubList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllLocationHubs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CarManagementService.grpc.CarManagement.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CarManagementService.grpc.CarManagement.LocationHubList.getDefaultInstance()))
              .setSchemaDescriptor(new LocationHubServiceMethodDescriptorSupplier("GetAllLocationHubs"))
              .build();
        }
      }
    }
    return getGetAllLocationHubsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.LocationHubRequest,
      CarManagementService.grpc.CarManagement.LocationHubResponse> getGetLocationHubByIDMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLocationHubByID",
      requestType = CarManagementService.grpc.CarManagement.LocationHubRequest.class,
      responseType = CarManagementService.grpc.CarManagement.LocationHubResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.LocationHubRequest,
      CarManagementService.grpc.CarManagement.LocationHubResponse> getGetLocationHubByIDMethod() {
    io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.LocationHubRequest, CarManagementService.grpc.CarManagement.LocationHubResponse> getGetLocationHubByIDMethod;
    if ((getGetLocationHubByIDMethod = LocationHubServiceGrpc.getGetLocationHubByIDMethod) == null) {
      synchronized (LocationHubServiceGrpc.class) {
        if ((getGetLocationHubByIDMethod = LocationHubServiceGrpc.getGetLocationHubByIDMethod) == null) {
          LocationHubServiceGrpc.getGetLocationHubByIDMethod = getGetLocationHubByIDMethod =
              io.grpc.MethodDescriptor.<CarManagementService.grpc.CarManagement.LocationHubRequest, CarManagementService.grpc.CarManagement.LocationHubResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLocationHubByID"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CarManagementService.grpc.CarManagement.LocationHubRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CarManagementService.grpc.CarManagement.LocationHubResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LocationHubServiceMethodDescriptorSupplier("GetLocationHubByID"))
              .build();
        }
      }
    }
    return getGetLocationHubByIDMethod;
  }

  private static volatile io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.LocationHub,
      CarManagementService.grpc.CarManagement.LocationHubResponse> getAddLocationHubMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddLocationHub",
      requestType = CarManagementService.grpc.CarManagement.LocationHub.class,
      responseType = CarManagementService.grpc.CarManagement.LocationHubResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.LocationHub,
      CarManagementService.grpc.CarManagement.LocationHubResponse> getAddLocationHubMethod() {
    io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.LocationHub, CarManagementService.grpc.CarManagement.LocationHubResponse> getAddLocationHubMethod;
    if ((getAddLocationHubMethod = LocationHubServiceGrpc.getAddLocationHubMethod) == null) {
      synchronized (LocationHubServiceGrpc.class) {
        if ((getAddLocationHubMethod = LocationHubServiceGrpc.getAddLocationHubMethod) == null) {
          LocationHubServiceGrpc.getAddLocationHubMethod = getAddLocationHubMethod =
              io.grpc.MethodDescriptor.<CarManagementService.grpc.CarManagement.LocationHub, CarManagementService.grpc.CarManagement.LocationHubResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddLocationHub"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CarManagementService.grpc.CarManagement.LocationHub.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CarManagementService.grpc.CarManagement.LocationHubResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LocationHubServiceMethodDescriptorSupplier("AddLocationHub"))
              .build();
        }
      }
    }
    return getAddLocationHubMethod;
  }

  private static volatile io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.LocationHub,
      CarManagementService.grpc.CarManagement.LocationHubResponse> getUpdateLocationHubMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateLocationHub",
      requestType = CarManagementService.grpc.CarManagement.LocationHub.class,
      responseType = CarManagementService.grpc.CarManagement.LocationHubResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.LocationHub,
      CarManagementService.grpc.CarManagement.LocationHubResponse> getUpdateLocationHubMethod() {
    io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.LocationHub, CarManagementService.grpc.CarManagement.LocationHubResponse> getUpdateLocationHubMethod;
    if ((getUpdateLocationHubMethod = LocationHubServiceGrpc.getUpdateLocationHubMethod) == null) {
      synchronized (LocationHubServiceGrpc.class) {
        if ((getUpdateLocationHubMethod = LocationHubServiceGrpc.getUpdateLocationHubMethod) == null) {
          LocationHubServiceGrpc.getUpdateLocationHubMethod = getUpdateLocationHubMethod =
              io.grpc.MethodDescriptor.<CarManagementService.grpc.CarManagement.LocationHub, CarManagementService.grpc.CarManagement.LocationHubResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateLocationHub"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CarManagementService.grpc.CarManagement.LocationHub.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CarManagementService.grpc.CarManagement.LocationHubResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LocationHubServiceMethodDescriptorSupplier("UpdateLocationHub"))
              .build();
        }
      }
    }
    return getUpdateLocationHubMethod;
  }

  private static volatile io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.LocationHubRequest,
      CarManagementService.grpc.CarManagement.LocationHubResponse> getDeleteLocationHubMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteLocationHub",
      requestType = CarManagementService.grpc.CarManagement.LocationHubRequest.class,
      responseType = CarManagementService.grpc.CarManagement.LocationHubResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.LocationHubRequest,
      CarManagementService.grpc.CarManagement.LocationHubResponse> getDeleteLocationHubMethod() {
    io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.LocationHubRequest, CarManagementService.grpc.CarManagement.LocationHubResponse> getDeleteLocationHubMethod;
    if ((getDeleteLocationHubMethod = LocationHubServiceGrpc.getDeleteLocationHubMethod) == null) {
      synchronized (LocationHubServiceGrpc.class) {
        if ((getDeleteLocationHubMethod = LocationHubServiceGrpc.getDeleteLocationHubMethod) == null) {
          LocationHubServiceGrpc.getDeleteLocationHubMethod = getDeleteLocationHubMethod =
              io.grpc.MethodDescriptor.<CarManagementService.grpc.CarManagement.LocationHubRequest, CarManagementService.grpc.CarManagement.LocationHubResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteLocationHub"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CarManagementService.grpc.CarManagement.LocationHubRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CarManagementService.grpc.CarManagement.LocationHubResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LocationHubServiceMethodDescriptorSupplier("DeleteLocationHub"))
              .build();
        }
      }
    }
    return getDeleteLocationHubMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LocationHubServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LocationHubServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LocationHubServiceStub>() {
        @java.lang.Override
        public LocationHubServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LocationHubServiceStub(channel, callOptions);
        }
      };
    return LocationHubServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LocationHubServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LocationHubServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LocationHubServiceBlockingStub>() {
        @java.lang.Override
        public LocationHubServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LocationHubServiceBlockingStub(channel, callOptions);
        }
      };
    return LocationHubServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LocationHubServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LocationHubServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LocationHubServiceFutureStub>() {
        @java.lang.Override
        public LocationHubServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LocationHubServiceFutureStub(channel, callOptions);
        }
      };
    return LocationHubServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * LocationHubService
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void getAllLocationHubs(CarManagementService.grpc.CarManagement.Empty request,
        io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.LocationHubList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllLocationHubsMethod(), responseObserver);
    }

    /**
     */
    default void getLocationHubByID(CarManagementService.grpc.CarManagement.LocationHubRequest request,
        io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.LocationHubResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetLocationHubByIDMethod(), responseObserver);
    }

    /**
     */
    default void addLocationHub(CarManagementService.grpc.CarManagement.LocationHub request,
        io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.LocationHubResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddLocationHubMethod(), responseObserver);
    }

    /**
     */
    default void updateLocationHub(CarManagementService.grpc.CarManagement.LocationHub request,
        io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.LocationHubResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateLocationHubMethod(), responseObserver);
    }

    /**
     */
    default void deleteLocationHub(CarManagementService.grpc.CarManagement.LocationHubRequest request,
        io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.LocationHubResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteLocationHubMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service LocationHubService.
   * <pre>
   * LocationHubService
   * </pre>
   */
  public static abstract class LocationHubServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return LocationHubServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service LocationHubService.
   * <pre>
   * LocationHubService
   * </pre>
   */
  public static final class LocationHubServiceStub
      extends io.grpc.stub.AbstractAsyncStub<LocationHubServiceStub> {
    private LocationHubServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LocationHubServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LocationHubServiceStub(channel, callOptions);
    }

    /**
     */
    public void getAllLocationHubs(CarManagementService.grpc.CarManagement.Empty request,
        io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.LocationHubList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllLocationHubsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getLocationHubByID(CarManagementService.grpc.CarManagement.LocationHubRequest request,
        io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.LocationHubResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLocationHubByIDMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addLocationHub(CarManagementService.grpc.CarManagement.LocationHub request,
        io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.LocationHubResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddLocationHubMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateLocationHub(CarManagementService.grpc.CarManagement.LocationHub request,
        io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.LocationHubResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateLocationHubMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteLocationHub(CarManagementService.grpc.CarManagement.LocationHubRequest request,
        io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.LocationHubResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteLocationHubMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service LocationHubService.
   * <pre>
   * LocationHubService
   * </pre>
   */
  public static final class LocationHubServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LocationHubServiceBlockingStub> {
    private LocationHubServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LocationHubServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LocationHubServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public CarManagementService.grpc.CarManagement.LocationHubList getAllLocationHubs(CarManagementService.grpc.CarManagement.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllLocationHubsMethod(), getCallOptions(), request);
    }

    /**
     */
    public CarManagementService.grpc.CarManagement.LocationHubResponse getLocationHubByID(CarManagementService.grpc.CarManagement.LocationHubRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLocationHubByIDMethod(), getCallOptions(), request);
    }

    /**
     */
    public CarManagementService.grpc.CarManagement.LocationHubResponse addLocationHub(CarManagementService.grpc.CarManagement.LocationHub request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddLocationHubMethod(), getCallOptions(), request);
    }

    /**
     */
    public CarManagementService.grpc.CarManagement.LocationHubResponse updateLocationHub(CarManagementService.grpc.CarManagement.LocationHub request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateLocationHubMethod(), getCallOptions(), request);
    }

    /**
     */
    public CarManagementService.grpc.CarManagement.LocationHubResponse deleteLocationHub(CarManagementService.grpc.CarManagement.LocationHubRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteLocationHubMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service LocationHubService.
   * <pre>
   * LocationHubService
   * </pre>
   */
  public static final class LocationHubServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<LocationHubServiceFutureStub> {
    private LocationHubServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LocationHubServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LocationHubServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CarManagementService.grpc.CarManagement.LocationHubList> getAllLocationHubs(
        CarManagementService.grpc.CarManagement.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllLocationHubsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CarManagementService.grpc.CarManagement.LocationHubResponse> getLocationHubByID(
        CarManagementService.grpc.CarManagement.LocationHubRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLocationHubByIDMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CarManagementService.grpc.CarManagement.LocationHubResponse> addLocationHub(
        CarManagementService.grpc.CarManagement.LocationHub request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddLocationHubMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CarManagementService.grpc.CarManagement.LocationHubResponse> updateLocationHub(
        CarManagementService.grpc.CarManagement.LocationHub request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateLocationHubMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CarManagementService.grpc.CarManagement.LocationHubResponse> deleteLocationHub(
        CarManagementService.grpc.CarManagement.LocationHubRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteLocationHubMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ALL_LOCATION_HUBS = 0;
  private static final int METHODID_GET_LOCATION_HUB_BY_ID = 1;
  private static final int METHODID_ADD_LOCATION_HUB = 2;
  private static final int METHODID_UPDATE_LOCATION_HUB = 3;
  private static final int METHODID_DELETE_LOCATION_HUB = 4;

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
        case METHODID_GET_ALL_LOCATION_HUBS:
          serviceImpl.getAllLocationHubs((CarManagementService.grpc.CarManagement.Empty) request,
              (io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.LocationHubList>) responseObserver);
          break;
        case METHODID_GET_LOCATION_HUB_BY_ID:
          serviceImpl.getLocationHubByID((CarManagementService.grpc.CarManagement.LocationHubRequest) request,
              (io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.LocationHubResponse>) responseObserver);
          break;
        case METHODID_ADD_LOCATION_HUB:
          serviceImpl.addLocationHub((CarManagementService.grpc.CarManagement.LocationHub) request,
              (io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.LocationHubResponse>) responseObserver);
          break;
        case METHODID_UPDATE_LOCATION_HUB:
          serviceImpl.updateLocationHub((CarManagementService.grpc.CarManagement.LocationHub) request,
              (io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.LocationHubResponse>) responseObserver);
          break;
        case METHODID_DELETE_LOCATION_HUB:
          serviceImpl.deleteLocationHub((CarManagementService.grpc.CarManagement.LocationHubRequest) request,
              (io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.LocationHubResponse>) responseObserver);
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
          getGetAllLocationHubsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              CarManagementService.grpc.CarManagement.Empty,
              CarManagementService.grpc.CarManagement.LocationHubList>(
                service, METHODID_GET_ALL_LOCATION_HUBS)))
        .addMethod(
          getGetLocationHubByIDMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              CarManagementService.grpc.CarManagement.LocationHubRequest,
              CarManagementService.grpc.CarManagement.LocationHubResponse>(
                service, METHODID_GET_LOCATION_HUB_BY_ID)))
        .addMethod(
          getAddLocationHubMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              CarManagementService.grpc.CarManagement.LocationHub,
              CarManagementService.grpc.CarManagement.LocationHubResponse>(
                service, METHODID_ADD_LOCATION_HUB)))
        .addMethod(
          getUpdateLocationHubMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              CarManagementService.grpc.CarManagement.LocationHub,
              CarManagementService.grpc.CarManagement.LocationHubResponse>(
                service, METHODID_UPDATE_LOCATION_HUB)))
        .addMethod(
          getDeleteLocationHubMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              CarManagementService.grpc.CarManagement.LocationHubRequest,
              CarManagementService.grpc.CarManagement.LocationHubResponse>(
                service, METHODID_DELETE_LOCATION_HUB)))
        .build();
  }

  private static abstract class LocationHubServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LocationHubServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return CarManagementService.grpc.CarManagement.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LocationHubService");
    }
  }

  private static final class LocationHubServiceFileDescriptorSupplier
      extends LocationHubServiceBaseDescriptorSupplier {
    LocationHubServiceFileDescriptorSupplier() {}
  }

  private static final class LocationHubServiceMethodDescriptorSupplier
      extends LocationHubServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LocationHubServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (LocationHubServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LocationHubServiceFileDescriptorSupplier())
              .addMethod(getGetAllLocationHubsMethod())
              .addMethod(getGetLocationHubByIDMethod())
              .addMethod(getAddLocationHubMethod())
              .addMethod(getUpdateLocationHubMethod())
              .addMethod(getDeleteLocationHubMethod())
              .build();
        }
      }
    }
    return result;
  }
}
