package RideShareService.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.56.0)",
    comments = "Source: Rideshare.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RideShareServiceGrpc {

  private RideShareServiceGrpc() {}

  public static final String SERVICE_NAME = "RideShareService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.CreateRideShareRequest,
      RideShareService.grpc.Rideshare.RideShareResponse> getCreateRideShareMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRideShare",
      requestType = RideShareService.grpc.Rideshare.CreateRideShareRequest.class,
      responseType = RideShareService.grpc.Rideshare.RideShareResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.CreateRideShareRequest,
      RideShareService.grpc.Rideshare.RideShareResponse> getCreateRideShareMethod() {
    io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.CreateRideShareRequest, RideShareService.grpc.Rideshare.RideShareResponse> getCreateRideShareMethod;
    if ((getCreateRideShareMethod = RideShareServiceGrpc.getCreateRideShareMethod) == null) {
      synchronized (RideShareServiceGrpc.class) {
        if ((getCreateRideShareMethod = RideShareServiceGrpc.getCreateRideShareMethod) == null) {
          RideShareServiceGrpc.getCreateRideShareMethod = getCreateRideShareMethod =
              io.grpc.MethodDescriptor.<RideShareService.grpc.Rideshare.CreateRideShareRequest, RideShareService.grpc.Rideshare.RideShareResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRideShare"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.CreateRideShareRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.RideShareResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RideShareServiceMethodDescriptorSupplier("CreateRideShare"))
              .build();
        }
      }
    }
    return getCreateRideShareMethod;
  }

  private static volatile io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.JoinRideShareRequest,
      RideShareService.grpc.Rideshare.RideShareResponse> getJoinRideShareMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "JoinRideShare",
      requestType = RideShareService.grpc.Rideshare.JoinRideShareRequest.class,
      responseType = RideShareService.grpc.Rideshare.RideShareResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.JoinRideShareRequest,
      RideShareService.grpc.Rideshare.RideShareResponse> getJoinRideShareMethod() {
    io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.JoinRideShareRequest, RideShareService.grpc.Rideshare.RideShareResponse> getJoinRideShareMethod;
    if ((getJoinRideShareMethod = RideShareServiceGrpc.getJoinRideShareMethod) == null) {
      synchronized (RideShareServiceGrpc.class) {
        if ((getJoinRideShareMethod = RideShareServiceGrpc.getJoinRideShareMethod) == null) {
          RideShareServiceGrpc.getJoinRideShareMethod = getJoinRideShareMethod =
              io.grpc.MethodDescriptor.<RideShareService.grpc.Rideshare.JoinRideShareRequest, RideShareService.grpc.Rideshare.RideShareResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "JoinRideShare"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.JoinRideShareRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.RideShareResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RideShareServiceMethodDescriptorSupplier("JoinRideShare"))
              .build();
        }
      }
    }
    return getJoinRideShareMethod;
  }

  private static volatile io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.ListRideSharesRequest,
      RideShareService.grpc.Rideshare.RideShareListResponse> getListRideSharesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRideShares",
      requestType = RideShareService.grpc.Rideshare.ListRideSharesRequest.class,
      responseType = RideShareService.grpc.Rideshare.RideShareListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.ListRideSharesRequest,
      RideShareService.grpc.Rideshare.RideShareListResponse> getListRideSharesMethod() {
    io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.ListRideSharesRequest, RideShareService.grpc.Rideshare.RideShareListResponse> getListRideSharesMethod;
    if ((getListRideSharesMethod = RideShareServiceGrpc.getListRideSharesMethod) == null) {
      synchronized (RideShareServiceGrpc.class) {
        if ((getListRideSharesMethod = RideShareServiceGrpc.getListRideSharesMethod) == null) {
          RideShareServiceGrpc.getListRideSharesMethod = getListRideSharesMethod =
              io.grpc.MethodDescriptor.<RideShareService.grpc.Rideshare.ListRideSharesRequest, RideShareService.grpc.Rideshare.RideShareListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRideShares"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.ListRideSharesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.RideShareListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RideShareServiceMethodDescriptorSupplier("ListRideShares"))
              .build();
        }
      }
    }
    return getListRideSharesMethod;
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
   */
  public interface AsyncService {

    /**
     */
    default void createRideShare(RideShareService.grpc.Rideshare.CreateRideShareRequest request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateRideShareMethod(), responseObserver);
    }

    /**
     */
    default void joinRideShare(RideShareService.grpc.Rideshare.JoinRideShareRequest request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getJoinRideShareMethod(), responseObserver);
    }

    /**
     */
    default void listRideShares(RideShareService.grpc.Rideshare.ListRideSharesRequest request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListRideSharesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service RideShareService.
   */
  public static abstract class RideShareServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return RideShareServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service RideShareService.
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
     */
    public void createRideShare(RideShareService.grpc.Rideshare.CreateRideShareRequest request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRideShareMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void joinRideShare(RideShareService.grpc.Rideshare.JoinRideShareRequest request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getJoinRideShareMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listRideShares(RideShareService.grpc.Rideshare.ListRideSharesRequest request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRideSharesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service RideShareService.
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
     */
    public RideShareService.grpc.Rideshare.RideShareResponse createRideShare(RideShareService.grpc.Rideshare.CreateRideShareRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRideShareMethod(), getCallOptions(), request);
    }

    /**
     */
    public RideShareService.grpc.Rideshare.RideShareResponse joinRideShare(RideShareService.grpc.Rideshare.JoinRideShareRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getJoinRideShareMethod(), getCallOptions(), request);
    }

    /**
     */
    public RideShareService.grpc.Rideshare.RideShareListResponse listRideShares(RideShareService.grpc.Rideshare.ListRideSharesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRideSharesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service RideShareService.
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
     */
    public com.google.common.util.concurrent.ListenableFuture<RideShareService.grpc.Rideshare.RideShareResponse> createRideShare(
        RideShareService.grpc.Rideshare.CreateRideShareRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRideShareMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<RideShareService.grpc.Rideshare.RideShareResponse> joinRideShare(
        RideShareService.grpc.Rideshare.JoinRideShareRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getJoinRideShareMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<RideShareService.grpc.Rideshare.RideShareListResponse> listRideShares(
        RideShareService.grpc.Rideshare.ListRideSharesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRideSharesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_RIDE_SHARE = 0;
  private static final int METHODID_JOIN_RIDE_SHARE = 1;
  private static final int METHODID_LIST_RIDE_SHARES = 2;

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
        case METHODID_CREATE_RIDE_SHARE:
          serviceImpl.createRideShare((RideShareService.grpc.Rideshare.CreateRideShareRequest) request,
              (io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareResponse>) responseObserver);
          break;
        case METHODID_JOIN_RIDE_SHARE:
          serviceImpl.joinRideShare((RideShareService.grpc.Rideshare.JoinRideShareRequest) request,
              (io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareResponse>) responseObserver);
          break;
        case METHODID_LIST_RIDE_SHARES:
          serviceImpl.listRideShares((RideShareService.grpc.Rideshare.ListRideSharesRequest) request,
              (io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareListResponse>) responseObserver);
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
          getCreateRideShareMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              RideShareService.grpc.Rideshare.CreateRideShareRequest,
              RideShareService.grpc.Rideshare.RideShareResponse>(
                service, METHODID_CREATE_RIDE_SHARE)))
        .addMethod(
          getJoinRideShareMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              RideShareService.grpc.Rideshare.JoinRideShareRequest,
              RideShareService.grpc.Rideshare.RideShareResponse>(
                service, METHODID_JOIN_RIDE_SHARE)))
        .addMethod(
          getListRideSharesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              RideShareService.grpc.Rideshare.ListRideSharesRequest,
              RideShareService.grpc.Rideshare.RideShareListResponse>(
                service, METHODID_LIST_RIDE_SHARES)))
        .build();
  }

  private static abstract class RideShareServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RideShareServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return RideShareService.grpc.Rideshare.getDescriptor();
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
              .addMethod(getCreateRideShareMethod())
              .addMethod(getJoinRideShareMethod())
              .addMethod(getListRideSharesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
