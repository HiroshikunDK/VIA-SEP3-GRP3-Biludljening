package CarManagementService.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * BookingCarService
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.56.0)",
    comments = "Source: CarManagement.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BookingCarServiceGrpc {

  private BookingCarServiceGrpc() {}

  public static final String SERVICE_NAME = "BookingCarService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.Empty,
      CarManagementService.grpc.CarManagement.BookingCarList> getGetAllBookingCarsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllBookingCars",
      requestType = CarManagementService.grpc.CarManagement.Empty.class,
      responseType = CarManagementService.grpc.CarManagement.BookingCarList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.Empty,
      CarManagementService.grpc.CarManagement.BookingCarList> getGetAllBookingCarsMethod() {
    io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.Empty, CarManagementService.grpc.CarManagement.BookingCarList> getGetAllBookingCarsMethod;
    if ((getGetAllBookingCarsMethod = BookingCarServiceGrpc.getGetAllBookingCarsMethod) == null) {
      synchronized (BookingCarServiceGrpc.class) {
        if ((getGetAllBookingCarsMethod = BookingCarServiceGrpc.getGetAllBookingCarsMethod) == null) {
          BookingCarServiceGrpc.getGetAllBookingCarsMethod = getGetAllBookingCarsMethod =
              io.grpc.MethodDescriptor.<CarManagementService.grpc.CarManagement.Empty, CarManagementService.grpc.CarManagement.BookingCarList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllBookingCars"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CarManagementService.grpc.CarManagement.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CarManagementService.grpc.CarManagement.BookingCarList.getDefaultInstance()))
              .setSchemaDescriptor(new BookingCarServiceMethodDescriptorSupplier("GetAllBookingCars"))
              .build();
        }
      }
    }
    return getGetAllBookingCarsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.BookingCarRequest,
      CarManagementService.grpc.CarManagement.BookingCarResponse> getGetBookingCarByIDMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBookingCarByID",
      requestType = CarManagementService.grpc.CarManagement.BookingCarRequest.class,
      responseType = CarManagementService.grpc.CarManagement.BookingCarResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.BookingCarRequest,
      CarManagementService.grpc.CarManagement.BookingCarResponse> getGetBookingCarByIDMethod() {
    io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.BookingCarRequest, CarManagementService.grpc.CarManagement.BookingCarResponse> getGetBookingCarByIDMethod;
    if ((getGetBookingCarByIDMethod = BookingCarServiceGrpc.getGetBookingCarByIDMethod) == null) {
      synchronized (BookingCarServiceGrpc.class) {
        if ((getGetBookingCarByIDMethod = BookingCarServiceGrpc.getGetBookingCarByIDMethod) == null) {
          BookingCarServiceGrpc.getGetBookingCarByIDMethod = getGetBookingCarByIDMethod =
              io.grpc.MethodDescriptor.<CarManagementService.grpc.CarManagement.BookingCarRequest, CarManagementService.grpc.CarManagement.BookingCarResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBookingCarByID"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CarManagementService.grpc.CarManagement.BookingCarRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CarManagementService.grpc.CarManagement.BookingCarResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BookingCarServiceMethodDescriptorSupplier("GetBookingCarByID"))
              .build();
        }
      }
    }
    return getGetBookingCarByIDMethod;
  }

  private static volatile io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.BookingCar,
      CarManagementService.grpc.CarManagement.BookingCarResponse> getAddBookingCarMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddBookingCar",
      requestType = CarManagementService.grpc.CarManagement.BookingCar.class,
      responseType = CarManagementService.grpc.CarManagement.BookingCarResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.BookingCar,
      CarManagementService.grpc.CarManagement.BookingCarResponse> getAddBookingCarMethod() {
    io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.BookingCar, CarManagementService.grpc.CarManagement.BookingCarResponse> getAddBookingCarMethod;
    if ((getAddBookingCarMethod = BookingCarServiceGrpc.getAddBookingCarMethod) == null) {
      synchronized (BookingCarServiceGrpc.class) {
        if ((getAddBookingCarMethod = BookingCarServiceGrpc.getAddBookingCarMethod) == null) {
          BookingCarServiceGrpc.getAddBookingCarMethod = getAddBookingCarMethod =
              io.grpc.MethodDescriptor.<CarManagementService.grpc.CarManagement.BookingCar, CarManagementService.grpc.CarManagement.BookingCarResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddBookingCar"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CarManagementService.grpc.CarManagement.BookingCar.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CarManagementService.grpc.CarManagement.BookingCarResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BookingCarServiceMethodDescriptorSupplier("AddBookingCar"))
              .build();
        }
      }
    }
    return getAddBookingCarMethod;
  }

  private static volatile io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.BookingCar,
      CarManagementService.grpc.CarManagement.BookingCarResponse> getUpdateBookingCarMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBookingCar",
      requestType = CarManagementService.grpc.CarManagement.BookingCar.class,
      responseType = CarManagementService.grpc.CarManagement.BookingCarResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.BookingCar,
      CarManagementService.grpc.CarManagement.BookingCarResponse> getUpdateBookingCarMethod() {
    io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.BookingCar, CarManagementService.grpc.CarManagement.BookingCarResponse> getUpdateBookingCarMethod;
    if ((getUpdateBookingCarMethod = BookingCarServiceGrpc.getUpdateBookingCarMethod) == null) {
      synchronized (BookingCarServiceGrpc.class) {
        if ((getUpdateBookingCarMethod = BookingCarServiceGrpc.getUpdateBookingCarMethod) == null) {
          BookingCarServiceGrpc.getUpdateBookingCarMethod = getUpdateBookingCarMethod =
              io.grpc.MethodDescriptor.<CarManagementService.grpc.CarManagement.BookingCar, CarManagementService.grpc.CarManagement.BookingCarResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateBookingCar"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CarManagementService.grpc.CarManagement.BookingCar.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CarManagementService.grpc.CarManagement.BookingCarResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BookingCarServiceMethodDescriptorSupplier("UpdateBookingCar"))
              .build();
        }
      }
    }
    return getUpdateBookingCarMethod;
  }

  private static volatile io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.BookingCarRequest,
      CarManagementService.grpc.CarManagement.BookingCarResponse> getDeleteBookingCarMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBookingCar",
      requestType = CarManagementService.grpc.CarManagement.BookingCarRequest.class,
      responseType = CarManagementService.grpc.CarManagement.BookingCarResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.BookingCarRequest,
      CarManagementService.grpc.CarManagement.BookingCarResponse> getDeleteBookingCarMethod() {
    io.grpc.MethodDescriptor<CarManagementService.grpc.CarManagement.BookingCarRequest, CarManagementService.grpc.CarManagement.BookingCarResponse> getDeleteBookingCarMethod;
    if ((getDeleteBookingCarMethod = BookingCarServiceGrpc.getDeleteBookingCarMethod) == null) {
      synchronized (BookingCarServiceGrpc.class) {
        if ((getDeleteBookingCarMethod = BookingCarServiceGrpc.getDeleteBookingCarMethod) == null) {
          BookingCarServiceGrpc.getDeleteBookingCarMethod = getDeleteBookingCarMethod =
              io.grpc.MethodDescriptor.<CarManagementService.grpc.CarManagement.BookingCarRequest, CarManagementService.grpc.CarManagement.BookingCarResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBookingCar"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CarManagementService.grpc.CarManagement.BookingCarRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CarManagementService.grpc.CarManagement.BookingCarResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BookingCarServiceMethodDescriptorSupplier("DeleteBookingCar"))
              .build();
        }
      }
    }
    return getDeleteBookingCarMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BookingCarServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BookingCarServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BookingCarServiceStub>() {
        @java.lang.Override
        public BookingCarServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BookingCarServiceStub(channel, callOptions);
        }
      };
    return BookingCarServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BookingCarServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BookingCarServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BookingCarServiceBlockingStub>() {
        @java.lang.Override
        public BookingCarServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BookingCarServiceBlockingStub(channel, callOptions);
        }
      };
    return BookingCarServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BookingCarServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BookingCarServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BookingCarServiceFutureStub>() {
        @java.lang.Override
        public BookingCarServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BookingCarServiceFutureStub(channel, callOptions);
        }
      };
    return BookingCarServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * BookingCarService
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void getAllBookingCars(CarManagementService.grpc.CarManagement.Empty request,
        io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.BookingCarList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllBookingCarsMethod(), responseObserver);
    }

    /**
     */
    default void getBookingCarByID(CarManagementService.grpc.CarManagement.BookingCarRequest request,
        io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.BookingCarResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBookingCarByIDMethod(), responseObserver);
    }

    /**
     */
    default void addBookingCar(CarManagementService.grpc.CarManagement.BookingCar request,
        io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.BookingCarResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddBookingCarMethod(), responseObserver);
    }

    /**
     */
    default void updateBookingCar(CarManagementService.grpc.CarManagement.BookingCar request,
        io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.BookingCarResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateBookingCarMethod(), responseObserver);
    }

    /**
     */
    default void deleteBookingCar(CarManagementService.grpc.CarManagement.BookingCarRequest request,
        io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.BookingCarResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteBookingCarMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service BookingCarService.
   * <pre>
   * BookingCarService
   * </pre>
   */
  public static abstract class BookingCarServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return BookingCarServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service BookingCarService.
   * <pre>
   * BookingCarService
   * </pre>
   */
  public static final class BookingCarServiceStub
      extends io.grpc.stub.AbstractAsyncStub<BookingCarServiceStub> {
    private BookingCarServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookingCarServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BookingCarServiceStub(channel, callOptions);
    }

    /**
     */
    public void getAllBookingCars(CarManagementService.grpc.CarManagement.Empty request,
        io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.BookingCarList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllBookingCarsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getBookingCarByID(CarManagementService.grpc.CarManagement.BookingCarRequest request,
        io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.BookingCarResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBookingCarByIDMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addBookingCar(CarManagementService.grpc.CarManagement.BookingCar request,
        io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.BookingCarResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddBookingCarMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateBookingCar(CarManagementService.grpc.CarManagement.BookingCar request,
        io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.BookingCarResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateBookingCarMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteBookingCar(CarManagementService.grpc.CarManagement.BookingCarRequest request,
        io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.BookingCarResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBookingCarMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service BookingCarService.
   * <pre>
   * BookingCarService
   * </pre>
   */
  public static final class BookingCarServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<BookingCarServiceBlockingStub> {
    private BookingCarServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookingCarServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BookingCarServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public CarManagementService.grpc.CarManagement.BookingCarList getAllBookingCars(CarManagementService.grpc.CarManagement.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllBookingCarsMethod(), getCallOptions(), request);
    }

    /**
     */
    public CarManagementService.grpc.CarManagement.BookingCarResponse getBookingCarByID(CarManagementService.grpc.CarManagement.BookingCarRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBookingCarByIDMethod(), getCallOptions(), request);
    }

    /**
     */
    public CarManagementService.grpc.CarManagement.BookingCarResponse addBookingCar(CarManagementService.grpc.CarManagement.BookingCar request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddBookingCarMethod(), getCallOptions(), request);
    }

    /**
     */
    public CarManagementService.grpc.CarManagement.BookingCarResponse updateBookingCar(CarManagementService.grpc.CarManagement.BookingCar request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBookingCarMethod(), getCallOptions(), request);
    }

    /**
     */
    public CarManagementService.grpc.CarManagement.BookingCarResponse deleteBookingCar(CarManagementService.grpc.CarManagement.BookingCarRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBookingCarMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service BookingCarService.
   * <pre>
   * BookingCarService
   * </pre>
   */
  public static final class BookingCarServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<BookingCarServiceFutureStub> {
    private BookingCarServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookingCarServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BookingCarServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CarManagementService.grpc.CarManagement.BookingCarList> getAllBookingCars(
        CarManagementService.grpc.CarManagement.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllBookingCarsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CarManagementService.grpc.CarManagement.BookingCarResponse> getBookingCarByID(
        CarManagementService.grpc.CarManagement.BookingCarRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBookingCarByIDMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CarManagementService.grpc.CarManagement.BookingCarResponse> addBookingCar(
        CarManagementService.grpc.CarManagement.BookingCar request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddBookingCarMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CarManagementService.grpc.CarManagement.BookingCarResponse> updateBookingCar(
        CarManagementService.grpc.CarManagement.BookingCar request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBookingCarMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CarManagementService.grpc.CarManagement.BookingCarResponse> deleteBookingCar(
        CarManagementService.grpc.CarManagement.BookingCarRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBookingCarMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ALL_BOOKING_CARS = 0;
  private static final int METHODID_GET_BOOKING_CAR_BY_ID = 1;
  private static final int METHODID_ADD_BOOKING_CAR = 2;
  private static final int METHODID_UPDATE_BOOKING_CAR = 3;
  private static final int METHODID_DELETE_BOOKING_CAR = 4;

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
        case METHODID_GET_ALL_BOOKING_CARS:
          serviceImpl.getAllBookingCars((CarManagementService.grpc.CarManagement.Empty) request,
              (io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.BookingCarList>) responseObserver);
          break;
        case METHODID_GET_BOOKING_CAR_BY_ID:
          serviceImpl.getBookingCarByID((CarManagementService.grpc.CarManagement.BookingCarRequest) request,
              (io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.BookingCarResponse>) responseObserver);
          break;
        case METHODID_ADD_BOOKING_CAR:
          serviceImpl.addBookingCar((CarManagementService.grpc.CarManagement.BookingCar) request,
              (io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.BookingCarResponse>) responseObserver);
          break;
        case METHODID_UPDATE_BOOKING_CAR:
          serviceImpl.updateBookingCar((CarManagementService.grpc.CarManagement.BookingCar) request,
              (io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.BookingCarResponse>) responseObserver);
          break;
        case METHODID_DELETE_BOOKING_CAR:
          serviceImpl.deleteBookingCar((CarManagementService.grpc.CarManagement.BookingCarRequest) request,
              (io.grpc.stub.StreamObserver<CarManagementService.grpc.CarManagement.BookingCarResponse>) responseObserver);
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
          getGetAllBookingCarsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              CarManagementService.grpc.CarManagement.Empty,
              CarManagementService.grpc.CarManagement.BookingCarList>(
                service, METHODID_GET_ALL_BOOKING_CARS)))
        .addMethod(
          getGetBookingCarByIDMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              CarManagementService.grpc.CarManagement.BookingCarRequest,
              CarManagementService.grpc.CarManagement.BookingCarResponse>(
                service, METHODID_GET_BOOKING_CAR_BY_ID)))
        .addMethod(
          getAddBookingCarMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              CarManagementService.grpc.CarManagement.BookingCar,
              CarManagementService.grpc.CarManagement.BookingCarResponse>(
                service, METHODID_ADD_BOOKING_CAR)))
        .addMethod(
          getUpdateBookingCarMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              CarManagementService.grpc.CarManagement.BookingCar,
              CarManagementService.grpc.CarManagement.BookingCarResponse>(
                service, METHODID_UPDATE_BOOKING_CAR)))
        .addMethod(
          getDeleteBookingCarMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              CarManagementService.grpc.CarManagement.BookingCarRequest,
              CarManagementService.grpc.CarManagement.BookingCarResponse>(
                service, METHODID_DELETE_BOOKING_CAR)))
        .build();
  }

  private static abstract class BookingCarServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BookingCarServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return CarManagementService.grpc.CarManagement.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BookingCarService");
    }
  }

  private static final class BookingCarServiceFileDescriptorSupplier
      extends BookingCarServiceBaseDescriptorSupplier {
    BookingCarServiceFileDescriptorSupplier() {}
  }

  private static final class BookingCarServiceMethodDescriptorSupplier
      extends BookingCarServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BookingCarServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BookingCarServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BookingCarServiceFileDescriptorSupplier())
              .addMethod(getGetAllBookingCarsMethod())
              .addMethod(getGetBookingCarByIDMethod())
              .addMethod(getAddBookingCarMethod())
              .addMethod(getUpdateBookingCarMethod())
              .addMethod(getDeleteBookingCarMethod())
              .build();
        }
      }
    }
    return result;
  }
}
