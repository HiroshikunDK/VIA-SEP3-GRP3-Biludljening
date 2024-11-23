package PaymentService.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.56.0)",
    comments = "Source: Payment.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CreditCardServiceGrpc {

  private CreditCardServiceGrpc() {}

  public static final String SERVICE_NAME = "CreditCardService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<PaymentService.grpc.Payment.CreditcardRequest,
      PaymentService.grpc.Payment.CreditcardResponse> getCreateCreditcardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCreditcard",
      requestType = PaymentService.grpc.Payment.CreditcardRequest.class,
      responseType = PaymentService.grpc.Payment.CreditcardResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<PaymentService.grpc.Payment.CreditcardRequest,
      PaymentService.grpc.Payment.CreditcardResponse> getCreateCreditcardMethod() {
    io.grpc.MethodDescriptor<PaymentService.grpc.Payment.CreditcardRequest, PaymentService.grpc.Payment.CreditcardResponse> getCreateCreditcardMethod;
    if ((getCreateCreditcardMethod = CreditCardServiceGrpc.getCreateCreditcardMethod) == null) {
      synchronized (CreditCardServiceGrpc.class) {
        if ((getCreateCreditcardMethod = CreditCardServiceGrpc.getCreateCreditcardMethod) == null) {
          CreditCardServiceGrpc.getCreateCreditcardMethod = getCreateCreditcardMethod =
              io.grpc.MethodDescriptor.<PaymentService.grpc.Payment.CreditcardRequest, PaymentService.grpc.Payment.CreditcardResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCreditcard"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  PaymentService.grpc.Payment.CreditcardRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  PaymentService.grpc.Payment.CreditcardResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CreditCardServiceMethodDescriptorSupplier("CreateCreditcard"))
              .build();
        }
      }
    }
    return getCreateCreditcardMethod;
  }

  private static volatile io.grpc.MethodDescriptor<PaymentService.grpc.Payment.CreditcardRequestById,
      PaymentService.grpc.Payment.CreditcardResponse> getGetCreditcardByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCreditcardById",
      requestType = PaymentService.grpc.Payment.CreditcardRequestById.class,
      responseType = PaymentService.grpc.Payment.CreditcardResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<PaymentService.grpc.Payment.CreditcardRequestById,
      PaymentService.grpc.Payment.CreditcardResponse> getGetCreditcardByIdMethod() {
    io.grpc.MethodDescriptor<PaymentService.grpc.Payment.CreditcardRequestById, PaymentService.grpc.Payment.CreditcardResponse> getGetCreditcardByIdMethod;
    if ((getGetCreditcardByIdMethod = CreditCardServiceGrpc.getGetCreditcardByIdMethod) == null) {
      synchronized (CreditCardServiceGrpc.class) {
        if ((getGetCreditcardByIdMethod = CreditCardServiceGrpc.getGetCreditcardByIdMethod) == null) {
          CreditCardServiceGrpc.getGetCreditcardByIdMethod = getGetCreditcardByIdMethod =
              io.grpc.MethodDescriptor.<PaymentService.grpc.Payment.CreditcardRequestById, PaymentService.grpc.Payment.CreditcardResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCreditcardById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  PaymentService.grpc.Payment.CreditcardRequestById.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  PaymentService.grpc.Payment.CreditcardResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CreditCardServiceMethodDescriptorSupplier("GetCreditcardById"))
              .build();
        }
      }
    }
    return getGetCreditcardByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<PaymentService.grpc.Payment.Empty,
      PaymentService.grpc.Payment.CreditcardListResponse> getGetAllCreditcardsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllCreditcards",
      requestType = PaymentService.grpc.Payment.Empty.class,
      responseType = PaymentService.grpc.Payment.CreditcardListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<PaymentService.grpc.Payment.Empty,
      PaymentService.grpc.Payment.CreditcardListResponse> getGetAllCreditcardsMethod() {
    io.grpc.MethodDescriptor<PaymentService.grpc.Payment.Empty, PaymentService.grpc.Payment.CreditcardListResponse> getGetAllCreditcardsMethod;
    if ((getGetAllCreditcardsMethod = CreditCardServiceGrpc.getGetAllCreditcardsMethod) == null) {
      synchronized (CreditCardServiceGrpc.class) {
        if ((getGetAllCreditcardsMethod = CreditCardServiceGrpc.getGetAllCreditcardsMethod) == null) {
          CreditCardServiceGrpc.getGetAllCreditcardsMethod = getGetAllCreditcardsMethod =
              io.grpc.MethodDescriptor.<PaymentService.grpc.Payment.Empty, PaymentService.grpc.Payment.CreditcardListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllCreditcards"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  PaymentService.grpc.Payment.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  PaymentService.grpc.Payment.CreditcardListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CreditCardServiceMethodDescriptorSupplier("GetAllCreditcards"))
              .build();
        }
      }
    }
    return getGetAllCreditcardsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<PaymentService.grpc.Payment.CreditcardRequestById,
      PaymentService.grpc.Payment.CreditcardResponse> getDeleteCreditcardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCreditcard",
      requestType = PaymentService.grpc.Payment.CreditcardRequestById.class,
      responseType = PaymentService.grpc.Payment.CreditcardResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<PaymentService.grpc.Payment.CreditcardRequestById,
      PaymentService.grpc.Payment.CreditcardResponse> getDeleteCreditcardMethod() {
    io.grpc.MethodDescriptor<PaymentService.grpc.Payment.CreditcardRequestById, PaymentService.grpc.Payment.CreditcardResponse> getDeleteCreditcardMethod;
    if ((getDeleteCreditcardMethod = CreditCardServiceGrpc.getDeleteCreditcardMethod) == null) {
      synchronized (CreditCardServiceGrpc.class) {
        if ((getDeleteCreditcardMethod = CreditCardServiceGrpc.getDeleteCreditcardMethod) == null) {
          CreditCardServiceGrpc.getDeleteCreditcardMethod = getDeleteCreditcardMethod =
              io.grpc.MethodDescriptor.<PaymentService.grpc.Payment.CreditcardRequestById, PaymentService.grpc.Payment.CreditcardResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCreditcard"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  PaymentService.grpc.Payment.CreditcardRequestById.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  PaymentService.grpc.Payment.CreditcardResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CreditCardServiceMethodDescriptorSupplier("DeleteCreditcard"))
              .build();
        }
      }
    }
    return getDeleteCreditcardMethod;
  }

  private static volatile io.grpc.MethodDescriptor<PaymentService.grpc.Payment.CreditcardRequest,
      PaymentService.grpc.Payment.CreditcardResponse> getUpdateCreditcardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCreditcard",
      requestType = PaymentService.grpc.Payment.CreditcardRequest.class,
      responseType = PaymentService.grpc.Payment.CreditcardResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<PaymentService.grpc.Payment.CreditcardRequest,
      PaymentService.grpc.Payment.CreditcardResponse> getUpdateCreditcardMethod() {
    io.grpc.MethodDescriptor<PaymentService.grpc.Payment.CreditcardRequest, PaymentService.grpc.Payment.CreditcardResponse> getUpdateCreditcardMethod;
    if ((getUpdateCreditcardMethod = CreditCardServiceGrpc.getUpdateCreditcardMethod) == null) {
      synchronized (CreditCardServiceGrpc.class) {
        if ((getUpdateCreditcardMethod = CreditCardServiceGrpc.getUpdateCreditcardMethod) == null) {
          CreditCardServiceGrpc.getUpdateCreditcardMethod = getUpdateCreditcardMethod =
              io.grpc.MethodDescriptor.<PaymentService.grpc.Payment.CreditcardRequest, PaymentService.grpc.Payment.CreditcardResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCreditcard"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  PaymentService.grpc.Payment.CreditcardRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  PaymentService.grpc.Payment.CreditcardResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CreditCardServiceMethodDescriptorSupplier("UpdateCreditcard"))
              .build();
        }
      }
    }
    return getUpdateCreditcardMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CreditCardServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CreditCardServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CreditCardServiceStub>() {
        @java.lang.Override
        public CreditCardServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CreditCardServiceStub(channel, callOptions);
        }
      };
    return CreditCardServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CreditCardServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CreditCardServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CreditCardServiceBlockingStub>() {
        @java.lang.Override
        public CreditCardServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CreditCardServiceBlockingStub(channel, callOptions);
        }
      };
    return CreditCardServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CreditCardServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CreditCardServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CreditCardServiceFutureStub>() {
        @java.lang.Override
        public CreditCardServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CreditCardServiceFutureStub(channel, callOptions);
        }
      };
    return CreditCardServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void createCreditcard(PaymentService.grpc.Payment.CreditcardRequest request,
        io.grpc.stub.StreamObserver<PaymentService.grpc.Payment.CreditcardResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateCreditcardMethod(), responseObserver);
    }

    /**
     */
    default void getCreditcardById(PaymentService.grpc.Payment.CreditcardRequestById request,
        io.grpc.stub.StreamObserver<PaymentService.grpc.Payment.CreditcardResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCreditcardByIdMethod(), responseObserver);
    }

    /**
     */
    default void getAllCreditcards(PaymentService.grpc.Payment.Empty request,
        io.grpc.stub.StreamObserver<PaymentService.grpc.Payment.CreditcardListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllCreditcardsMethod(), responseObserver);
    }

    /**
     */
    default void deleteCreditcard(PaymentService.grpc.Payment.CreditcardRequestById request,
        io.grpc.stub.StreamObserver<PaymentService.grpc.Payment.CreditcardResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteCreditcardMethod(), responseObserver);
    }

    /**
     */
    default void updateCreditcard(PaymentService.grpc.Payment.CreditcardRequest request,
        io.grpc.stub.StreamObserver<PaymentService.grpc.Payment.CreditcardResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCreditcardMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CreditCardService.
   */
  public static abstract class CreditCardServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CreditCardServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CreditCardService.
   */
  public static final class CreditCardServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CreditCardServiceStub> {
    private CreditCardServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CreditCardServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CreditCardServiceStub(channel, callOptions);
    }

    /**
     */
    public void createCreditcard(PaymentService.grpc.Payment.CreditcardRequest request,
        io.grpc.stub.StreamObserver<PaymentService.grpc.Payment.CreditcardResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCreditcardMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCreditcardById(PaymentService.grpc.Payment.CreditcardRequestById request,
        io.grpc.stub.StreamObserver<PaymentService.grpc.Payment.CreditcardResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCreditcardByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllCreditcards(PaymentService.grpc.Payment.Empty request,
        io.grpc.stub.StreamObserver<PaymentService.grpc.Payment.CreditcardListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllCreditcardsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteCreditcard(PaymentService.grpc.Payment.CreditcardRequestById request,
        io.grpc.stub.StreamObserver<PaymentService.grpc.Payment.CreditcardResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCreditcardMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateCreditcard(PaymentService.grpc.Payment.CreditcardRequest request,
        io.grpc.stub.StreamObserver<PaymentService.grpc.Payment.CreditcardResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCreditcardMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CreditCardService.
   */
  public static final class CreditCardServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CreditCardServiceBlockingStub> {
    private CreditCardServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CreditCardServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CreditCardServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public PaymentService.grpc.Payment.CreditcardResponse createCreditcard(PaymentService.grpc.Payment.CreditcardRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCreditcardMethod(), getCallOptions(), request);
    }

    /**
     */
    public PaymentService.grpc.Payment.CreditcardResponse getCreditcardById(PaymentService.grpc.Payment.CreditcardRequestById request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCreditcardByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public PaymentService.grpc.Payment.CreditcardListResponse getAllCreditcards(PaymentService.grpc.Payment.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllCreditcardsMethod(), getCallOptions(), request);
    }

    /**
     */
    public PaymentService.grpc.Payment.CreditcardResponse deleteCreditcard(PaymentService.grpc.Payment.CreditcardRequestById request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCreditcardMethod(), getCallOptions(), request);
    }

    /**
     */
    public PaymentService.grpc.Payment.CreditcardResponse updateCreditcard(PaymentService.grpc.Payment.CreditcardRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCreditcardMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CreditCardService.
   */
  public static final class CreditCardServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CreditCardServiceFutureStub> {
    private CreditCardServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CreditCardServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CreditCardServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<PaymentService.grpc.Payment.CreditcardResponse> createCreditcard(
        PaymentService.grpc.Payment.CreditcardRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCreditcardMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<PaymentService.grpc.Payment.CreditcardResponse> getCreditcardById(
        PaymentService.grpc.Payment.CreditcardRequestById request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCreditcardByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<PaymentService.grpc.Payment.CreditcardListResponse> getAllCreditcards(
        PaymentService.grpc.Payment.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllCreditcardsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<PaymentService.grpc.Payment.CreditcardResponse> deleteCreditcard(
        PaymentService.grpc.Payment.CreditcardRequestById request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCreditcardMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<PaymentService.grpc.Payment.CreditcardResponse> updateCreditcard(
        PaymentService.grpc.Payment.CreditcardRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCreditcardMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CREDITCARD = 0;
  private static final int METHODID_GET_CREDITCARD_BY_ID = 1;
  private static final int METHODID_GET_ALL_CREDITCARDS = 2;
  private static final int METHODID_DELETE_CREDITCARD = 3;
  private static final int METHODID_UPDATE_CREDITCARD = 4;

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
        case METHODID_CREATE_CREDITCARD:
          serviceImpl.createCreditcard((PaymentService.grpc.Payment.CreditcardRequest) request,
              (io.grpc.stub.StreamObserver<PaymentService.grpc.Payment.CreditcardResponse>) responseObserver);
          break;
        case METHODID_GET_CREDITCARD_BY_ID:
          serviceImpl.getCreditcardById((PaymentService.grpc.Payment.CreditcardRequestById) request,
              (io.grpc.stub.StreamObserver<PaymentService.grpc.Payment.CreditcardResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_CREDITCARDS:
          serviceImpl.getAllCreditcards((PaymentService.grpc.Payment.Empty) request,
              (io.grpc.stub.StreamObserver<PaymentService.grpc.Payment.CreditcardListResponse>) responseObserver);
          break;
        case METHODID_DELETE_CREDITCARD:
          serviceImpl.deleteCreditcard((PaymentService.grpc.Payment.CreditcardRequestById) request,
              (io.grpc.stub.StreamObserver<PaymentService.grpc.Payment.CreditcardResponse>) responseObserver);
          break;
        case METHODID_UPDATE_CREDITCARD:
          serviceImpl.updateCreditcard((PaymentService.grpc.Payment.CreditcardRequest) request,
              (io.grpc.stub.StreamObserver<PaymentService.grpc.Payment.CreditcardResponse>) responseObserver);
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
          getCreateCreditcardMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              PaymentService.grpc.Payment.CreditcardRequest,
              PaymentService.grpc.Payment.CreditcardResponse>(
                service, METHODID_CREATE_CREDITCARD)))
        .addMethod(
          getGetCreditcardByIdMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              PaymentService.grpc.Payment.CreditcardRequestById,
              PaymentService.grpc.Payment.CreditcardResponse>(
                service, METHODID_GET_CREDITCARD_BY_ID)))
        .addMethod(
          getGetAllCreditcardsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              PaymentService.grpc.Payment.Empty,
              PaymentService.grpc.Payment.CreditcardListResponse>(
                service, METHODID_GET_ALL_CREDITCARDS)))
        .addMethod(
          getDeleteCreditcardMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              PaymentService.grpc.Payment.CreditcardRequestById,
              PaymentService.grpc.Payment.CreditcardResponse>(
                service, METHODID_DELETE_CREDITCARD)))
        .addMethod(
          getUpdateCreditcardMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              PaymentService.grpc.Payment.CreditcardRequest,
              PaymentService.grpc.Payment.CreditcardResponse>(
                service, METHODID_UPDATE_CREDITCARD)))
        .build();
  }

  private static abstract class CreditCardServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CreditCardServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return PaymentService.grpc.Payment.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CreditCardService");
    }
  }

  private static final class CreditCardServiceFileDescriptorSupplier
      extends CreditCardServiceBaseDescriptorSupplier {
    CreditCardServiceFileDescriptorSupplier() {}
  }

  private static final class CreditCardServiceMethodDescriptorSupplier
      extends CreditCardServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CreditCardServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CreditCardServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CreditCardServiceFileDescriptorSupplier())
              .addMethod(getCreateCreditcardMethod())
              .addMethod(getGetCreditcardByIdMethod())
              .addMethod(getGetAllCreditcardsMethod())
              .addMethod(getDeleteCreditcardMethod())
              .addMethod(getUpdateCreditcardMethod())
              .build();
        }
      }
    }
    return result;
  }
}
