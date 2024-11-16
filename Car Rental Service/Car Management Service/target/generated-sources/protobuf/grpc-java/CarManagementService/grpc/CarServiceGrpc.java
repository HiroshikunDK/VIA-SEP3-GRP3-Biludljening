package CarManagementService.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * CarService
 * </pre>
 */
@jakarta.annotation.Generated(
    value = "by gRPC proto compiler (version 1.56.0)",
    comments = "Source: CarManagement.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CarServiceGrpc {

  private CarServiceGrpc() {}

  public static final String SERVICE_NAME = "CarService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.Empty,
      CarManagementService.grpc.CarManagement.CarList> getGetAllCarsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllCars",
      requestType = CarManagementService.grpc.CarManagement.Empty.class,
      responseType = CarManagementService.grpc.CarManagement.CarList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.Empty,
      CarManagementService.grpc.CarManagement.CarList> getGetAllCarsMethod() {
    io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.Empty, CarManagementService.grpc.CarManagement.CarList> getGetAllCarsMethod;
    if ((getGetAllCarsMethod = CarServiceGrpc.getGetAllCarsMethod) == null) {
      synchronized (CarServiceGrpc.class) {
        if ((getGetAllCarsMethod = CarServiceGrpc.getGetAllCarsMethod) == null) {
          CarServiceGrpc.getGetAllCarsMethod = getGetAllCarsMethod =
              io.grpc.MethodDescriptor.<CarManagementService.grpc.CarManagement.Empty, CarManagementService.grpc.CarManagement.CarList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllCars"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CarManagementService.grpc.CarManagement.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CarManagementService.grpc.CarManagement.CarList.getDefaultInstance()))
              .setSchemaDescriptor(new CarServiceMethodDescriptorSupplier("getAllCars"))
              .build();
        }
      }
    }
    return getGetAllCarsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.CarRequest,
      CarManagementService.grpc.CarManagement.CarResponse> getGetCarByIDMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCarByID",
      requestType = CarManagementService.grpc.CarManagement.CarRequest.class,
      responseType = CarManagementService.grpc.CarManagement.CarResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.CarRequest,
      CarManagementService.grpc.CarManagement.CarResponse> getGetCarByIDMethod() {
    io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.CarRequest, CarManagementService.grpc.CarManagement.CarResponse> getGetCarByIDMethod;
    if ((getGetCarByIDMethod = CarServiceGrpc.getGetCarByIDMethod) == null) {
      synchronized (CarServiceGrpc.class) {
        if ((getGetCarByIDMethod = CarServiceGrpc.getGetCarByIDMethod) == null) {
          CarServiceGrpc.getGetCarByIDMethod = getGetCarByIDMethod =
              io.grpc.MethodDescriptor.<CarManagementService.grpc.CarManagement.CarRequest, CarManagementService.grpc.CarManagement.CarResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getCarByID"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CarManagementService.grpc.CarManagement.CarRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CarManagementService.grpc.CarManagement.CarResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CarServiceMethodDescriptorSupplier("getCarByID"))
              .build();
        }
      }
    }
    return getGetCarByIDMethod;
  }

  private static volatile io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.Car,
      CarManagementService.grpc.CarManagement.CarResponse> getAddCarMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addCar",
      requestType = CarManagementService.grpc.CarManagement.Car.class,
      responseType = CarManagementService.grpc.CarManagement.CarResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.Car,
      CarManagementService.grpc.CarManagement.CarResponse> getAddCarMethod() {
    io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.Car, CarManagementService.grpc.CarManagement.CarResponse> getAddCarMethod;
    if ((getAddCarMethod = CarServiceGrpc.getAddCarMethod) == null) {
      synchronized (CarServiceGrpc.class) {
        if ((getAddCarMethod = CarServiceGrpc.getAddCarMethod) == null) {
          CarServiceGrpc.getAddCarMethod = getAddCarMethod =
              io.grpc.MethodDescriptor.<CarManagementService.grpc.CarManagement.Car, CarManagementService.grpc.CarManagement.CarResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addCar"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CarManagementService.grpc.CarManagement.Car.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CarManagementService.grpc.CarManagement.CarResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CarServiceMethodDescriptorSupplier("addCar"))
              .build();
        }
      }
    }
    return getAddCarMethod;
  }

  private static volatile io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.Car,
      CarManagementService.grpc.CarManagement.CarResponse> getUpdateCarMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateCar",
      requestType = CarManagementService.grpc.CarManagement.Car.class,
      responseType = CarManagementService.grpc.CarManagement.CarResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.Car,
      CarManagementService.grpc.CarManagement.CarResponse> getUpdateCarMethod() {
    io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.Car, CarManagementService.grpc.CarManagement.CarResponse> getUpdateCarMethod;
    if ((getUpdateCarMethod = CarServiceGrpc.getUpdateCarMethod) == null) {
      synchronized (CarServiceGrpc.class) {
        if ((getUpdateCarMethod = CarServiceGrpc.getUpdateCarMethod) == null) {
          CarServiceGrpc.getUpdateCarMethod = getUpdateCarMethod =
              io.grpc.MethodDescriptor.<CarManagementService.grpc.CarManagement.Car, CarManagementService.grpc.CarManagement.CarResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateCar"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CarManagementService.grpc.CarManagement.Car.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CarManagementService.grpc.CarManagement.CarResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CarServiceMethodDescriptorSupplier("updateCar"))
              .build();
        }
      }
    }
    return getUpdateCarMethod;
  }

  private static volatile io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.CarRequest,
      CarManagementService.grpc.CarManagement.CarResponse> getDeleteCarMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteCar",
      requestType = CarManagementService.grpc.CarManagement.CarRequest.class,
      responseType = CarManagementService.grpc.CarManagement.CarResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.CarRequest,
      CarManagementService.grpc.CarManagement.CarResponse> getDeleteCarMethod() {
    io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.CarRequest, CarManagementService.grpc.CarManagement.CarResponse> getDeleteCarMethod;
    if ((getDeleteCarMethod = CarServiceGrpc.getDeleteCarMethod) == null) {
      synchronized (CarServiceGrpc.class) {
        if ((getDeleteCarMethod = CarServiceGrpc.getDeleteCarMethod) == null) {
          CarServiceGrpc.getDeleteCarMethod = getDeleteCarMethod =
              io.grpc.MethodDescriptor.<CarManagementService.grpc.CarManagement.CarRequest, CarManagementService.grpc.CarManagement.CarResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteCar"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CarManagementService.grpc.CarManagement.CarRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CarManagementService.grpc.CarManagement.CarResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CarServiceMethodDescriptorSupplier("deleteCar"))
              .build();
        }
      }
    }
    return getDeleteCarMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CarServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CarServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CarServiceStub>() {
        @java.lang.Override
        public CarServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CarServiceStub(channel, callOptions);
        }
      };
    return CarServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CarServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CarServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CarServiceBlockingStub>() {
        @java.lang.Override
        public CarServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CarServiceBlockingStub(channel, callOptions);
        }
      };
    return CarServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CarServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CarServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CarServiceFutureStub>() {
        @java.lang.Override
        public CarServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CarServiceFutureStub(channel, callOptions);
        }
      };
    return CarServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * CarService
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void getAllCars(CarManagementService.grpc.CarManagement.Empty request,
        io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.CarList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllCarsMethod(), responseObserver);
    }

    /**
     */
    default void getCarByID(CarManagementService.grpc.CarManagement.CarRequest request,
        io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.CarResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCarByIDMethod(), responseObserver);
    }

    /**
     */
    default void addCar(CarManagementService.grpc.CarManagement.Car request,
        io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.CarResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddCarMethod(), responseObserver);
    }

    /**
     */
    default void updateCar(CarManagementService.grpc.CarManagement.Car request,
        io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.CarResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCarMethod(), responseObserver);
    }

    /**
     */
    default void deleteCar(CarManagementService.grpc.CarManagement.CarRequest request,
        io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.CarResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteCarMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CarService.
   * <pre>
   * CarService
   * </pre>
   */
  public static abstract class CarServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CarServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CarService.
   * <pre>
   * CarService
   * </pre>
   */
  public static final class CarServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CarServiceStub> {
    private CarServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CarServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CarServiceStub(channel, callOptions);
    }

    /**
     */
    public void getAllCars(CarManagementService.grpc.CarManagement.Empty request,
        io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.CarList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllCarsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCarByID(CarManagementService.grpc.CarManagement.CarRequest request,
        io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.CarResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCarByIDMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addCar(CarManagementService.grpc.CarManagement.Car request,
        io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.CarResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddCarMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateCar(CarManagementService.grpc.CarManagement.Car request,
        io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.CarResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCarMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteCar(CarManagementService.grpc.CarManagement.CarRequest request,
        io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.CarResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCarMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CarService.
   * <pre>
   * CarService
   * </pre>
   */
  public static final class CarServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CarServiceBlockingStub> {
    private CarServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CarServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CarServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public CarManagementService.grpc.CarManagement.CarList getAllCars(CarManagementService.grpc.CarManagement.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllCarsMethod(), getCallOptions(), request);
    }

    /**
     */
    public CarManagementService.grpc.CarManagement.CarResponse getCarByID(CarManagementService.grpc.CarManagement.CarRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCarByIDMethod(), getCallOptions(), request);
    }

    /**
     */
    public CarManagementService.grpc.CarManagement.CarResponse addCar(CarManagementService.grpc.CarManagement.Car request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddCarMethod(), getCallOptions(), request);
    }

    /**
     */
    public CarManagementService.grpc.CarManagement.CarResponse updateCar(CarManagementService.grpc.CarManagement.Car request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCarMethod(), getCallOptions(), request);
    }

    /**
     */
    public CarManagementService.grpc.CarManagement.CarResponse deleteCar(CarManagementService.grpc.CarManagement.CarRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCarMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CarService.
   * <pre>
   * CarService
   * </pre>
   */
  public static final class CarServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CarServiceFutureStub> {
    private CarServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CarServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CarServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CarManagementService.grpc.CarManagement.CarList> getAllCars(
        CarManagementService.grpc.CarManagement.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllCarsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CarManagementService.grpc.CarManagement.CarResponse> getCarByID(
        CarManagementService.grpc.CarManagement.CarRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCarByIDMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CarManagementService.grpc.CarManagement.CarResponse> addCar(
        CarManagementService.grpc.CarManagement.Car request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddCarMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CarManagementService.grpc.CarManagement.CarResponse> updateCar(
        CarManagementService.grpc.CarManagement.Car request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCarMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CarManagementService.grpc.CarManagement.CarResponse> deleteCar(
        CarManagementService.grpc.CarManagement.CarRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCarMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ALL_CARS = 0;
  private static final int METHODID_GET_CAR_BY_ID = 1;
  private static final int METHODID_ADD_CAR = 2;
  private static final int METHODID_UPDATE_CAR = 3;
  private static final int METHODID_DELETE_CAR = 4;

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
        case METHODID_GET_ALL_CARS:
          serviceImpl.getAllCars((CarManagementService.grpc.CarManagement.Empty) request,
              (io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.CarList>) responseObserver);
          break;
        case METHODID_GET_CAR_BY_ID:
          serviceImpl.getCarByID((CarManagementService.grpc.CarManagement.CarRequest) request,
              (io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.CarResponse>) responseObserver);
          break;
        case METHODID_ADD_CAR:
          serviceImpl.addCar((CarManagementService.grpc.CarManagement.Car) request,
              (io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.CarResponse>) responseObserver);
          break;
        case METHODID_UPDATE_CAR:
          serviceImpl.updateCar((CarManagementService.grpc.CarManagement.Car) request,
              (io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.CarResponse>) responseObserver);
          break;
        case METHODID_DELETE_CAR:
          serviceImpl.deleteCar((CarManagementService.grpc.CarManagement.CarRequest) request,
              (io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.CarResponse>) responseObserver);
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
          getGetAllCarsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              CarManagementService.grpc.CarManagement.Empty,
              CarManagementService.grpc.CarManagement.CarList>(
                service, METHODID_GET_ALL_CARS)))
        .addMethod(
          getGetCarByIDMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              CarManagementService.grpc.CarManagement.CarRequest,
              CarManagementService.grpc.CarManagement.CarResponse>(
                service, METHODID_GET_CAR_BY_ID)))
        .addMethod(
          getAddCarMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              CarManagementService.grpc.CarManagement.Car,
              CarManagementService.grpc.CarManagement.CarResponse>(
                service, METHODID_ADD_CAR)))
        .addMethod(
          getUpdateCarMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              CarManagementService.grpc.CarManagement.Car,
              CarManagementService.grpc.CarManagement.CarResponse>(
                service, METHODID_UPDATE_CAR)))
        .addMethod(
          getDeleteCarMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              CarManagementService.grpc.CarManagement.CarRequest,
              CarManagementService.grpc.CarManagement.CarResponse>(
                service, METHODID_DELETE_CAR)))
        .build();
  }

  private static abstract class CarServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CarServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return CarManagementService.grpc.CarManagement.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CarService");
    }
  }

  private static final class CarServiceFileDescriptorSupplier
      extends CarServiceBaseDescriptorSupplier {
    CarServiceFileDescriptorSupplier() {}
  }

  private static final class CarServiceMethodDescriptorSupplier
      extends CarServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CarServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CarServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CarServiceFileDescriptorSupplier())
              .addMethod(getGetAllCarsMethod())
              .addMethod(getGetCarByIDMethod())
              .addMethod(getAddCarMethod())
              .addMethod(getUpdateCarMethod())
              .addMethod(getDeleteCarMethod())
              .build();
        }
      }
    }
    return result;
  }
}
