package payment.paymentservice.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.56.0)",
    comments = "Source: payment.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PaymentServiceGrpc {

  private PaymentServiceGrpc() {}

  public static final String SERVICE_NAME = "PaymentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<payment.paymentservice.grpc.PaymentServiceProto.PaymentRequest,
      payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse> getCreatePaymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePayment",
      requestType = payment.paymentservice.grpc.PaymentServiceProto.PaymentRequest.class,
      responseType = payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<payment.paymentservice.grpc.PaymentServiceProto.PaymentRequest,
      payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse> getCreatePaymentMethod() {
    io.grpc.MethodDescriptor<payment.paymentservice.grpc.PaymentServiceProto.PaymentRequest, payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse> getCreatePaymentMethod;
    if ((getCreatePaymentMethod = PaymentServiceGrpc.getCreatePaymentMethod) == null) {
      synchronized (PaymentServiceGrpc.class) {
        if ((getCreatePaymentMethod = PaymentServiceGrpc.getCreatePaymentMethod) == null) {
          PaymentServiceGrpc.getCreatePaymentMethod = getCreatePaymentMethod =
              io.grpc.MethodDescriptor.<payment.paymentservice.grpc.PaymentServiceProto.PaymentRequest, payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePayment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  payment.paymentservice.grpc.PaymentServiceProto.PaymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PaymentServiceMethodDescriptorSupplier("CreatePayment"))
              .build();
        }
      }
    }
    return getCreatePaymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<payment.paymentservice.grpc.PaymentServiceProto.PaymentRequestById,
      payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse> getGetPaymentByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPaymentById",
      requestType = payment.paymentservice.grpc.PaymentServiceProto.PaymentRequestById.class,
      responseType = payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<payment.paymentservice.grpc.PaymentServiceProto.PaymentRequestById,
      payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse> getGetPaymentByIdMethod() {
    io.grpc.MethodDescriptor<payment.paymentservice.grpc.PaymentServiceProto.PaymentRequestById, payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse> getGetPaymentByIdMethod;
    if ((getGetPaymentByIdMethod = PaymentServiceGrpc.getGetPaymentByIdMethod) == null) {
      synchronized (PaymentServiceGrpc.class) {
        if ((getGetPaymentByIdMethod = PaymentServiceGrpc.getGetPaymentByIdMethod) == null) {
          PaymentServiceGrpc.getGetPaymentByIdMethod = getGetPaymentByIdMethod =
              io.grpc.MethodDescriptor.<payment.paymentservice.grpc.PaymentServiceProto.PaymentRequestById, payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPaymentById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  payment.paymentservice.grpc.PaymentServiceProto.PaymentRequestById.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PaymentServiceMethodDescriptorSupplier("GetPaymentById"))
              .build();
        }
      }
    }
    return getGetPaymentByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<payment.paymentservice.grpc.PaymentServiceProto.PaymentStatusUpdateRequest,
      payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse> getUpdatePaymentStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePaymentStatus",
      requestType = payment.paymentservice.grpc.PaymentServiceProto.PaymentStatusUpdateRequest.class,
      responseType = payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<payment.paymentservice.grpc.PaymentServiceProto.PaymentStatusUpdateRequest,
      payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse> getUpdatePaymentStatusMethod() {
    io.grpc.MethodDescriptor<payment.paymentservice.grpc.PaymentServiceProto.PaymentStatusUpdateRequest, payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse> getUpdatePaymentStatusMethod;
    if ((getUpdatePaymentStatusMethod = PaymentServiceGrpc.getUpdatePaymentStatusMethod) == null) {
      synchronized (PaymentServiceGrpc.class) {
        if ((getUpdatePaymentStatusMethod = PaymentServiceGrpc.getUpdatePaymentStatusMethod) == null) {
          PaymentServiceGrpc.getUpdatePaymentStatusMethod = getUpdatePaymentStatusMethod =
              io.grpc.MethodDescriptor.<payment.paymentservice.grpc.PaymentServiceProto.PaymentStatusUpdateRequest, payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdatePaymentStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  payment.paymentservice.grpc.PaymentServiceProto.PaymentStatusUpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PaymentServiceMethodDescriptorSupplier("UpdatePaymentStatus"))
              .build();
        }
      }
    }
    return getUpdatePaymentStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<payment.paymentservice.grpc.PaymentServiceProto.Empty,
      payment.paymentservice.grpc.PaymentServiceProto.PaymentListResponse> getListPaymentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPayments",
      requestType = payment.paymentservice.grpc.PaymentServiceProto.Empty.class,
      responseType = payment.paymentservice.grpc.PaymentServiceProto.PaymentListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<payment.paymentservice.grpc.PaymentServiceProto.Empty,
      payment.paymentservice.grpc.PaymentServiceProto.PaymentListResponse> getListPaymentsMethod() {
    io.grpc.MethodDescriptor<payment.paymentservice.grpc.PaymentServiceProto.Empty, payment.paymentservice.grpc.PaymentServiceProto.PaymentListResponse> getListPaymentsMethod;
    if ((getListPaymentsMethod = PaymentServiceGrpc.getListPaymentsMethod) == null) {
      synchronized (PaymentServiceGrpc.class) {
        if ((getListPaymentsMethod = PaymentServiceGrpc.getListPaymentsMethod) == null) {
          PaymentServiceGrpc.getListPaymentsMethod = getListPaymentsMethod =
              io.grpc.MethodDescriptor.<payment.paymentservice.grpc.PaymentServiceProto.Empty, payment.paymentservice.grpc.PaymentServiceProto.PaymentListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPayments"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  payment.paymentservice.grpc.PaymentServiceProto.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  payment.paymentservice.grpc.PaymentServiceProto.PaymentListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PaymentServiceMethodDescriptorSupplier("ListPayments"))
              .build();
        }
      }
    }
    return getListPaymentsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PaymentServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PaymentServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PaymentServiceStub>() {
        @java.lang.Override
        public PaymentServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PaymentServiceStub(channel, callOptions);
        }
      };
    return PaymentServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PaymentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PaymentServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PaymentServiceBlockingStub>() {
        @java.lang.Override
        public PaymentServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PaymentServiceBlockingStub(channel, callOptions);
        }
      };
    return PaymentServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PaymentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PaymentServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PaymentServiceFutureStub>() {
        @java.lang.Override
        public PaymentServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PaymentServiceFutureStub(channel, callOptions);
        }
      };
    return PaymentServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void createPayment(payment.paymentservice.grpc.PaymentServiceProto.PaymentRequest request,
        io.grpc.stub.StreamObserver<payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreatePaymentMethod(), responseObserver);
    }

    /**
     */
    default void getPaymentById(payment.paymentservice.grpc.PaymentServiceProto.PaymentRequestById request,
        io.grpc.stub.StreamObserver<payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPaymentByIdMethod(), responseObserver);
    }

    /**
     */
    default void updatePaymentStatus(payment.paymentservice.grpc.PaymentServiceProto.PaymentStatusUpdateRequest request,
        io.grpc.stub.StreamObserver<payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdatePaymentStatusMethod(), responseObserver);
    }

    /**
     */
    default void listPayments(payment.paymentservice.grpc.PaymentServiceProto.Empty request,
        io.grpc.stub.StreamObserver<payment.paymentservice.grpc.PaymentServiceProto.PaymentListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListPaymentsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service PaymentService.
   */
  public static abstract class PaymentServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return PaymentServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service PaymentService.
   */
  public static final class PaymentServiceStub
      extends io.grpc.stub.AbstractAsyncStub<PaymentServiceStub> {
    private PaymentServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PaymentServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PaymentServiceStub(channel, callOptions);
    }

    /**
     */
    public void createPayment(payment.paymentservice.grpc.PaymentServiceProto.PaymentRequest request,
        io.grpc.stub.StreamObserver<payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePaymentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getPaymentById(payment.paymentservice.grpc.PaymentServiceProto.PaymentRequestById request,
        io.grpc.stub.StreamObserver<payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPaymentByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updatePaymentStatus(payment.paymentservice.grpc.PaymentServiceProto.PaymentStatusUpdateRequest request,
        io.grpc.stub.StreamObserver<payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePaymentStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listPayments(payment.paymentservice.grpc.PaymentServiceProto.Empty request,
        io.grpc.stub.StreamObserver<payment.paymentservice.grpc.PaymentServiceProto.PaymentListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPaymentsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service PaymentService.
   */
  public static final class PaymentServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PaymentServiceBlockingStub> {
    private PaymentServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PaymentServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PaymentServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse createPayment(payment.paymentservice.grpc.PaymentServiceProto.PaymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePaymentMethod(), getCallOptions(), request);
    }

    /**
     */
    public payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse getPaymentById(payment.paymentservice.grpc.PaymentServiceProto.PaymentRequestById request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPaymentByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse updatePaymentStatus(payment.paymentservice.grpc.PaymentServiceProto.PaymentStatusUpdateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePaymentStatusMethod(), getCallOptions(), request);
    }

    /**
     */
    public payment.paymentservice.grpc.PaymentServiceProto.PaymentListResponse listPayments(payment.paymentservice.grpc.PaymentServiceProto.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPaymentsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service PaymentService.
   */
  public static final class PaymentServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<PaymentServiceFutureStub> {
    private PaymentServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PaymentServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PaymentServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse> createPayment(
        payment.paymentservice.grpc.PaymentServiceProto.PaymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePaymentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse> getPaymentById(
        payment.paymentservice.grpc.PaymentServiceProto.PaymentRequestById request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPaymentByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse> updatePaymentStatus(
        payment.paymentservice.grpc.PaymentServiceProto.PaymentStatusUpdateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePaymentStatusMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<payment.paymentservice.grpc.PaymentServiceProto.PaymentListResponse> listPayments(
        payment.paymentservice.grpc.PaymentServiceProto.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPaymentsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_PAYMENT = 0;
  private static final int METHODID_GET_PAYMENT_BY_ID = 1;
  private static final int METHODID_UPDATE_PAYMENT_STATUS = 2;
  private static final int METHODID_LIST_PAYMENTS = 3;

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
        case METHODID_CREATE_PAYMENT:
          serviceImpl.createPayment((payment.paymentservice.grpc.PaymentServiceProto.PaymentRequest) request,
              (io.grpc.stub.StreamObserver<payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse>) responseObserver);
          break;
        case METHODID_GET_PAYMENT_BY_ID:
          serviceImpl.getPaymentById((payment.paymentservice.grpc.PaymentServiceProto.PaymentRequestById) request,
              (io.grpc.stub.StreamObserver<payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse>) responseObserver);
          break;
        case METHODID_UPDATE_PAYMENT_STATUS:
          serviceImpl.updatePaymentStatus((payment.paymentservice.grpc.PaymentServiceProto.PaymentStatusUpdateRequest) request,
              (io.grpc.stub.StreamObserver<payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse>) responseObserver);
          break;
        case METHODID_LIST_PAYMENTS:
          serviceImpl.listPayments((payment.paymentservice.grpc.PaymentServiceProto.Empty) request,
              (io.grpc.stub.StreamObserver<payment.paymentservice.grpc.PaymentServiceProto.PaymentListResponse>) responseObserver);
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
          getCreatePaymentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              payment.paymentservice.grpc.PaymentServiceProto.PaymentRequest,
              payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse>(
                service, METHODID_CREATE_PAYMENT)))
        .addMethod(
          getGetPaymentByIdMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              payment.paymentservice.grpc.PaymentServiceProto.PaymentRequestById,
              payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse>(
                service, METHODID_GET_PAYMENT_BY_ID)))
        .addMethod(
          getUpdatePaymentStatusMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              payment.paymentservice.grpc.PaymentServiceProto.PaymentStatusUpdateRequest,
              payment.paymentservice.grpc.PaymentServiceProto.PaymentResponse>(
                service, METHODID_UPDATE_PAYMENT_STATUS)))
        .addMethod(
          getListPaymentsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              payment.paymentservice.grpc.PaymentServiceProto.Empty,
              payment.paymentservice.grpc.PaymentServiceProto.PaymentListResponse>(
                service, METHODID_LIST_PAYMENTS)))
        .build();
  }

  private static abstract class PaymentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PaymentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return payment.paymentservice.grpc.PaymentServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PaymentService");
    }
  }

  private static final class PaymentServiceFileDescriptorSupplier
      extends PaymentServiceBaseDescriptorSupplier {
    PaymentServiceFileDescriptorSupplier() {}
  }

  private static final class PaymentServiceMethodDescriptorSupplier
      extends PaymentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PaymentServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (PaymentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PaymentServiceFileDescriptorSupplier())
              .addMethod(getCreatePaymentMethod())
              .addMethod(getGetPaymentByIdMethod())
              .addMethod(getUpdatePaymentStatusMethod())
              .addMethod(getListPaymentsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
