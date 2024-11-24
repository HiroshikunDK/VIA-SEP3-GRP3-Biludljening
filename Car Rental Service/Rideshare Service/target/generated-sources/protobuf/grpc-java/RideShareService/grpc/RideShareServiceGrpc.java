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
  private static volatile io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.CreateRideShareRequestTest,
      RideShareService.grpc.Rideshare.RideShareResponse> getCreateRideShareMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRideShare",
      requestType = RideShareService.grpc.Rideshare.CreateRideShareRequestTest.class,
      responseType = RideShareService.grpc.Rideshare.RideShareResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.CreateRideShareRequestTest,
      RideShareService.grpc.Rideshare.RideShareResponse> getCreateRideShareMethod() {
    io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.CreateRideShareRequestTest, RideShareService.grpc.Rideshare.RideShareResponse> getCreateRideShareMethod;
    if ((getCreateRideShareMethod = RideShareServiceGrpc.getCreateRideShareMethod) == null) {
      synchronized (RideShareServiceGrpc.class) {
        if ((getCreateRideShareMethod = RideShareServiceGrpc.getCreateRideShareMethod) == null) {
          RideShareServiceGrpc.getCreateRideShareMethod = getCreateRideShareMethod =
              io.grpc.MethodDescriptor.<RideShareService.grpc.Rideshare.CreateRideShareRequestTest, RideShareService.grpc.Rideshare.RideShareResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRideShare"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.CreateRideShareRequestTest.getDefaultInstance()))
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

  private static volatile io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideshareOffer,
      RideShareService.grpc.Rideshare.RideShareResponse> getCreateRideShareOfferMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRideShareOffer",
      requestType = RideShareService.grpc.Rideshare.RideshareOffer.class,
      responseType = RideShareService.grpc.Rideshare.RideShareResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideshareOffer,
      RideShareService.grpc.Rideshare.RideShareResponse> getCreateRideShareOfferMethod() {
    io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideshareOffer, RideShareService.grpc.Rideshare.RideShareResponse> getCreateRideShareOfferMethod;
    if ((getCreateRideShareOfferMethod = RideShareServiceGrpc.getCreateRideShareOfferMethod) == null) {
      synchronized (RideShareServiceGrpc.class) {
        if ((getCreateRideShareOfferMethod = RideShareServiceGrpc.getCreateRideShareOfferMethod) == null) {
          RideShareServiceGrpc.getCreateRideShareOfferMethod = getCreateRideShareOfferMethod =
              io.grpc.MethodDescriptor.<RideShareService.grpc.Rideshare.RideshareOffer, RideShareService.grpc.Rideshare.RideShareResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRideShareOffer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.RideshareOffer.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.RideShareResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RideShareServiceMethodDescriptorSupplier("CreateRideShareOffer"))
              .build();
        }
      }
    }
    return getCreateRideShareOfferMethod;
  }

  private static volatile io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideShareIDRequest,
      RideShareService.grpc.Rideshare.RideshareOffer> getReadRideShareOfferMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadRideShareOffer",
      requestType = RideShareService.grpc.Rideshare.RideShareIDRequest.class,
      responseType = RideShareService.grpc.Rideshare.RideshareOffer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideShareIDRequest,
      RideShareService.grpc.Rideshare.RideshareOffer> getReadRideShareOfferMethod() {
    io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideShareIDRequest, RideShareService.grpc.Rideshare.RideshareOffer> getReadRideShareOfferMethod;
    if ((getReadRideShareOfferMethod = RideShareServiceGrpc.getReadRideShareOfferMethod) == null) {
      synchronized (RideShareServiceGrpc.class) {
        if ((getReadRideShareOfferMethod = RideShareServiceGrpc.getReadRideShareOfferMethod) == null) {
          RideShareServiceGrpc.getReadRideShareOfferMethod = getReadRideShareOfferMethod =
              io.grpc.MethodDescriptor.<RideShareService.grpc.Rideshare.RideShareIDRequest, RideShareService.grpc.Rideshare.RideshareOffer>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReadRideShareOffer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.RideShareIDRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.RideshareOffer.getDefaultInstance()))
              .setSchemaDescriptor(new RideShareServiceMethodDescriptorSupplier("ReadRideShareOffer"))
              .build();
        }
      }
    }
    return getReadRideShareOfferMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      RideShareService.grpc.Rideshare.RideshareOfferList> getReadAllRideShareOfferMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadAllRideShareOffer",
      requestType = com.google.protobuf.Empty.class,
      responseType = RideShareService.grpc.Rideshare.RideshareOfferList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      RideShareService.grpc.Rideshare.RideshareOfferList> getReadAllRideShareOfferMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, RideShareService.grpc.Rideshare.RideshareOfferList> getReadAllRideShareOfferMethod;
    if ((getReadAllRideShareOfferMethod = RideShareServiceGrpc.getReadAllRideShareOfferMethod) == null) {
      synchronized (RideShareServiceGrpc.class) {
        if ((getReadAllRideShareOfferMethod = RideShareServiceGrpc.getReadAllRideShareOfferMethod) == null) {
          RideShareServiceGrpc.getReadAllRideShareOfferMethod = getReadAllRideShareOfferMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, RideShareService.grpc.Rideshare.RideshareOfferList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReadAllRideShareOffer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.RideshareOfferList.getDefaultInstance()))
              .setSchemaDescriptor(new RideShareServiceMethodDescriptorSupplier("ReadAllRideShareOffer"))
              .build();
        }
      }
    }
    return getReadAllRideShareOfferMethod;
  }

  private static volatile io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideshareOffer,
      RideShareService.grpc.Rideshare.RideShareResponse> getUpdateRideShareOfferMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRideShareOffer",
      requestType = RideShareService.grpc.Rideshare.RideshareOffer.class,
      responseType = RideShareService.grpc.Rideshare.RideShareResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideshareOffer,
      RideShareService.grpc.Rideshare.RideShareResponse> getUpdateRideShareOfferMethod() {
    io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideshareOffer, RideShareService.grpc.Rideshare.RideShareResponse> getUpdateRideShareOfferMethod;
    if ((getUpdateRideShareOfferMethod = RideShareServiceGrpc.getUpdateRideShareOfferMethod) == null) {
      synchronized (RideShareServiceGrpc.class) {
        if ((getUpdateRideShareOfferMethod = RideShareServiceGrpc.getUpdateRideShareOfferMethod) == null) {
          RideShareServiceGrpc.getUpdateRideShareOfferMethod = getUpdateRideShareOfferMethod =
              io.grpc.MethodDescriptor.<RideShareService.grpc.Rideshare.RideshareOffer, RideShareService.grpc.Rideshare.RideShareResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateRideShareOffer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.RideshareOffer.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.RideShareResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RideShareServiceMethodDescriptorSupplier("UpdateRideShareOffer"))
              .build();
        }
      }
    }
    return getUpdateRideShareOfferMethod;
  }

  private static volatile io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideShareIDRequest,
      RideShareService.grpc.Rideshare.RideShareResponse> getDeleteRideShareOfferMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRideShareOffer",
      requestType = RideShareService.grpc.Rideshare.RideShareIDRequest.class,
      responseType = RideShareService.grpc.Rideshare.RideShareResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideShareIDRequest,
      RideShareService.grpc.Rideshare.RideShareResponse> getDeleteRideShareOfferMethod() {
    io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideShareIDRequest, RideShareService.grpc.Rideshare.RideShareResponse> getDeleteRideShareOfferMethod;
    if ((getDeleteRideShareOfferMethod = RideShareServiceGrpc.getDeleteRideShareOfferMethod) == null) {
      synchronized (RideShareServiceGrpc.class) {
        if ((getDeleteRideShareOfferMethod = RideShareServiceGrpc.getDeleteRideShareOfferMethod) == null) {
          RideShareServiceGrpc.getDeleteRideShareOfferMethod = getDeleteRideShareOfferMethod =
              io.grpc.MethodDescriptor.<RideShareService.grpc.Rideshare.RideShareIDRequest, RideShareService.grpc.Rideshare.RideShareResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRideShareOffer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.RideShareIDRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.RideShareResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RideShareServiceMethodDescriptorSupplier("DeleteRideShareOffer"))
              .build();
        }
      }
    }
    return getDeleteRideShareOfferMethod;
  }

  private static volatile io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideshareRequest,
      RideShareService.grpc.Rideshare.RideShareResponse> getCreateRideShareRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRideShareRequest",
      requestType = RideShareService.grpc.Rideshare.RideshareRequest.class,
      responseType = RideShareService.grpc.Rideshare.RideShareResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideshareRequest,
      RideShareService.grpc.Rideshare.RideShareResponse> getCreateRideShareRequestMethod() {
    io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideshareRequest, RideShareService.grpc.Rideshare.RideShareResponse> getCreateRideShareRequestMethod;
    if ((getCreateRideShareRequestMethod = RideShareServiceGrpc.getCreateRideShareRequestMethod) == null) {
      synchronized (RideShareServiceGrpc.class) {
        if ((getCreateRideShareRequestMethod = RideShareServiceGrpc.getCreateRideShareRequestMethod) == null) {
          RideShareServiceGrpc.getCreateRideShareRequestMethod = getCreateRideShareRequestMethod =
              io.grpc.MethodDescriptor.<RideShareService.grpc.Rideshare.RideshareRequest, RideShareService.grpc.Rideshare.RideShareResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRideShareRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.RideshareRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.RideShareResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RideShareServiceMethodDescriptorSupplier("CreateRideShareRequest"))
              .build();
        }
      }
    }
    return getCreateRideShareRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideShareIDRequest,
      RideShareService.grpc.Rideshare.RideshareRequest> getReadRideShareRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadRideShareRequest",
      requestType = RideShareService.grpc.Rideshare.RideShareIDRequest.class,
      responseType = RideShareService.grpc.Rideshare.RideshareRequest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideShareIDRequest,
      RideShareService.grpc.Rideshare.RideshareRequest> getReadRideShareRequestMethod() {
    io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideShareIDRequest, RideShareService.grpc.Rideshare.RideshareRequest> getReadRideShareRequestMethod;
    if ((getReadRideShareRequestMethod = RideShareServiceGrpc.getReadRideShareRequestMethod) == null) {
      synchronized (RideShareServiceGrpc.class) {
        if ((getReadRideShareRequestMethod = RideShareServiceGrpc.getReadRideShareRequestMethod) == null) {
          RideShareServiceGrpc.getReadRideShareRequestMethod = getReadRideShareRequestMethod =
              io.grpc.MethodDescriptor.<RideShareService.grpc.Rideshare.RideShareIDRequest, RideShareService.grpc.Rideshare.RideshareRequest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReadRideShareRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.RideShareIDRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.RideshareRequest.getDefaultInstance()))
              .setSchemaDescriptor(new RideShareServiceMethodDescriptorSupplier("ReadRideShareRequest"))
              .build();
        }
      }
    }
    return getReadRideShareRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      RideShareService.grpc.Rideshare.RideShareRequestList> getReadAllRideShareRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadAllRideShareRequest",
      requestType = com.google.protobuf.Empty.class,
      responseType = RideShareService.grpc.Rideshare.RideShareRequestList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      RideShareService.grpc.Rideshare.RideShareRequestList> getReadAllRideShareRequestMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, RideShareService.grpc.Rideshare.RideShareRequestList> getReadAllRideShareRequestMethod;
    if ((getReadAllRideShareRequestMethod = RideShareServiceGrpc.getReadAllRideShareRequestMethod) == null) {
      synchronized (RideShareServiceGrpc.class) {
        if ((getReadAllRideShareRequestMethod = RideShareServiceGrpc.getReadAllRideShareRequestMethod) == null) {
          RideShareServiceGrpc.getReadAllRideShareRequestMethod = getReadAllRideShareRequestMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, RideShareService.grpc.Rideshare.RideShareRequestList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReadAllRideShareRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.RideShareRequestList.getDefaultInstance()))
              .setSchemaDescriptor(new RideShareServiceMethodDescriptorSupplier("ReadAllRideShareRequest"))
              .build();
        }
      }
    }
    return getReadAllRideShareRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideshareRequest,
      RideShareService.grpc.Rideshare.RideShareResponse> getUpdateRideShareRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRideShareRequest",
      requestType = RideShareService.grpc.Rideshare.RideshareRequest.class,
      responseType = RideShareService.grpc.Rideshare.RideShareResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideshareRequest,
      RideShareService.grpc.Rideshare.RideShareResponse> getUpdateRideShareRequestMethod() {
    io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideshareRequest, RideShareService.grpc.Rideshare.RideShareResponse> getUpdateRideShareRequestMethod;
    if ((getUpdateRideShareRequestMethod = RideShareServiceGrpc.getUpdateRideShareRequestMethod) == null) {
      synchronized (RideShareServiceGrpc.class) {
        if ((getUpdateRideShareRequestMethod = RideShareServiceGrpc.getUpdateRideShareRequestMethod) == null) {
          RideShareServiceGrpc.getUpdateRideShareRequestMethod = getUpdateRideShareRequestMethod =
              io.grpc.MethodDescriptor.<RideShareService.grpc.Rideshare.RideshareRequest, RideShareService.grpc.Rideshare.RideShareResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateRideShareRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.RideshareRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.RideShareResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RideShareServiceMethodDescriptorSupplier("UpdateRideShareRequest"))
              .build();
        }
      }
    }
    return getUpdateRideShareRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideShareIDRequest,
      RideShareService.grpc.Rideshare.RideShareResponse> getDeleteRideShareRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRideShareRequest",
      requestType = RideShareService.grpc.Rideshare.RideShareIDRequest.class,
      responseType = RideShareService.grpc.Rideshare.RideShareResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideShareIDRequest,
      RideShareService.grpc.Rideshare.RideShareResponse> getDeleteRideShareRequestMethod() {
    io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideShareIDRequest, RideShareService.grpc.Rideshare.RideShareResponse> getDeleteRideShareRequestMethod;
    if ((getDeleteRideShareRequestMethod = RideShareServiceGrpc.getDeleteRideShareRequestMethod) == null) {
      synchronized (RideShareServiceGrpc.class) {
        if ((getDeleteRideShareRequestMethod = RideShareServiceGrpc.getDeleteRideShareRequestMethod) == null) {
          RideShareServiceGrpc.getDeleteRideShareRequestMethod = getDeleteRideShareRequestMethod =
              io.grpc.MethodDescriptor.<RideShareService.grpc.Rideshare.RideShareIDRequest, RideShareService.grpc.Rideshare.RideShareResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRideShareRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.RideShareIDRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.RideShareResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RideShareServiceMethodDescriptorSupplier("DeleteRideShareRequest"))
              .build();
        }
      }
    }
    return getDeleteRideShareRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideshareRequest,
      RideShareService.grpc.Rideshare.RideshareOfferList> getGetClosestRideShareRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetClosestRideShareRequest",
      requestType = RideShareService.grpc.Rideshare.RideshareRequest.class,
      responseType = RideShareService.grpc.Rideshare.RideshareOfferList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideshareRequest,
      RideShareService.grpc.Rideshare.RideshareOfferList> getGetClosestRideShareRequestMethod() {
    io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideshareRequest, RideShareService.grpc.Rideshare.RideshareOfferList> getGetClosestRideShareRequestMethod;
    if ((getGetClosestRideShareRequestMethod = RideShareServiceGrpc.getGetClosestRideShareRequestMethod) == null) {
      synchronized (RideShareServiceGrpc.class) {
        if ((getGetClosestRideShareRequestMethod = RideShareServiceGrpc.getGetClosestRideShareRequestMethod) == null) {
          RideShareServiceGrpc.getGetClosestRideShareRequestMethod = getGetClosestRideShareRequestMethod =
              io.grpc.MethodDescriptor.<RideShareService.grpc.Rideshare.RideshareRequest, RideShareService.grpc.Rideshare.RideshareOfferList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetClosestRideShareRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.RideshareRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.RideshareOfferList.getDefaultInstance()))
              .setSchemaDescriptor(new RideShareServiceMethodDescriptorSupplier("GetClosestRideShareRequest"))
              .build();
        }
      }
    }
    return getGetClosestRideShareRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideShareIDRequest,
      RideShareService.grpc.Rideshare.RideshareOfferList> getGetAllRideShareOffersByUserIDMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllRideShareOffersByUserID",
      requestType = RideShareService.grpc.Rideshare.RideShareIDRequest.class,
      responseType = RideShareService.grpc.Rideshare.RideshareOfferList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideShareIDRequest,
      RideShareService.grpc.Rideshare.RideshareOfferList> getGetAllRideShareOffersByUserIDMethod() {
    io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideShareIDRequest, RideShareService.grpc.Rideshare.RideshareOfferList> getGetAllRideShareOffersByUserIDMethod;
    if ((getGetAllRideShareOffersByUserIDMethod = RideShareServiceGrpc.getGetAllRideShareOffersByUserIDMethod) == null) {
      synchronized (RideShareServiceGrpc.class) {
        if ((getGetAllRideShareOffersByUserIDMethod = RideShareServiceGrpc.getGetAllRideShareOffersByUserIDMethod) == null) {
          RideShareServiceGrpc.getGetAllRideShareOffersByUserIDMethod = getGetAllRideShareOffersByUserIDMethod =
              io.grpc.MethodDescriptor.<RideShareService.grpc.Rideshare.RideShareIDRequest, RideShareService.grpc.Rideshare.RideshareOfferList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllRideShareOffersByUserID"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.RideShareIDRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.RideshareOfferList.getDefaultInstance()))
              .setSchemaDescriptor(new RideShareServiceMethodDescriptorSupplier("GetAllRideShareOffersByUserID"))
              .build();
        }
      }
    }
    return getGetAllRideShareOffersByUserIDMethod;
  }

  private static volatile io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideShareIDRequest,
      RideShareService.grpc.Rideshare.RideShareRequestList> getGetAllRideShareRequestsByUserIDMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllRideShareRequestsByUserID",
      requestType = RideShareService.grpc.Rideshare.RideShareIDRequest.class,
      responseType = RideShareService.grpc.Rideshare.RideShareRequestList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideShareIDRequest,
      RideShareService.grpc.Rideshare.RideShareRequestList> getGetAllRideShareRequestsByUserIDMethod() {
    io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideShareIDRequest, RideShareService.grpc.Rideshare.RideShareRequestList> getGetAllRideShareRequestsByUserIDMethod;
    if ((getGetAllRideShareRequestsByUserIDMethod = RideShareServiceGrpc.getGetAllRideShareRequestsByUserIDMethod) == null) {
      synchronized (RideShareServiceGrpc.class) {
        if ((getGetAllRideShareRequestsByUserIDMethod = RideShareServiceGrpc.getGetAllRideShareRequestsByUserIDMethod) == null) {
          RideShareServiceGrpc.getGetAllRideShareRequestsByUserIDMethod = getGetAllRideShareRequestsByUserIDMethod =
              io.grpc.MethodDescriptor.<RideShareService.grpc.Rideshare.RideShareIDRequest, RideShareService.grpc.Rideshare.RideShareRequestList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllRideShareRequestsByUserID"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.RideShareIDRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.RideShareRequestList.getDefaultInstance()))
              .setSchemaDescriptor(new RideShareServiceMethodDescriptorSupplier("GetAllRideShareRequestsByUserID"))
              .build();
        }
      }
    }
    return getGetAllRideShareRequestsByUserIDMethod;
  }

  private static volatile io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideShareIDRequest,
      RideShareService.grpc.Rideshare.RideshareOfferList> getGetAllRideShareOffersByBookingIDMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllRideShareOffersByBookingID",
      requestType = RideShareService.grpc.Rideshare.RideShareIDRequest.class,
      responseType = RideShareService.grpc.Rideshare.RideshareOfferList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideShareIDRequest,
      RideShareService.grpc.Rideshare.RideshareOfferList> getGetAllRideShareOffersByBookingIDMethod() {
    io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideShareIDRequest, RideShareService.grpc.Rideshare.RideshareOfferList> getGetAllRideShareOffersByBookingIDMethod;
    if ((getGetAllRideShareOffersByBookingIDMethod = RideShareServiceGrpc.getGetAllRideShareOffersByBookingIDMethod) == null) {
      synchronized (RideShareServiceGrpc.class) {
        if ((getGetAllRideShareOffersByBookingIDMethod = RideShareServiceGrpc.getGetAllRideShareOffersByBookingIDMethod) == null) {
          RideShareServiceGrpc.getGetAllRideShareOffersByBookingIDMethod = getGetAllRideShareOffersByBookingIDMethod =
              io.grpc.MethodDescriptor.<RideShareService.grpc.Rideshare.RideShareIDRequest, RideShareService.grpc.Rideshare.RideshareOfferList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllRideShareOffersByBookingID"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.RideShareIDRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.RideshareOfferList.getDefaultInstance()))
              .setSchemaDescriptor(new RideShareServiceMethodDescriptorSupplier("GetAllRideShareOffersByBookingID"))
              .build();
        }
      }
    }
    return getGetAllRideShareOffersByBookingIDMethod;
  }

  private static volatile io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideShareIDRequest,
      RideShareService.grpc.Rideshare.RideShareRequestList> getGetAllRideShareRequestsByRideOfferIDMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllRideShareRequestsByRideOfferID",
      requestType = RideShareService.grpc.Rideshare.RideShareIDRequest.class,
      responseType = RideShareService.grpc.Rideshare.RideShareRequestList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideShareIDRequest,
      RideShareService.grpc.Rideshare.RideShareRequestList> getGetAllRideShareRequestsByRideOfferIDMethod() {
    io.grpc.MethodDescriptor<RideShareService.grpc.Rideshare.RideShareIDRequest, RideShareService.grpc.Rideshare.RideShareRequestList> getGetAllRideShareRequestsByRideOfferIDMethod;
    if ((getGetAllRideShareRequestsByRideOfferIDMethod = RideShareServiceGrpc.getGetAllRideShareRequestsByRideOfferIDMethod) == null) {
      synchronized (RideShareServiceGrpc.class) {
        if ((getGetAllRideShareRequestsByRideOfferIDMethod = RideShareServiceGrpc.getGetAllRideShareRequestsByRideOfferIDMethod) == null) {
          RideShareServiceGrpc.getGetAllRideShareRequestsByRideOfferIDMethod = getGetAllRideShareRequestsByRideOfferIDMethod =
              io.grpc.MethodDescriptor.<RideShareService.grpc.Rideshare.RideShareIDRequest, RideShareService.grpc.Rideshare.RideShareRequestList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllRideShareRequestsByRideOfferID"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.RideShareIDRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RideShareService.grpc.Rideshare.RideShareRequestList.getDefaultInstance()))
              .setSchemaDescriptor(new RideShareServiceMethodDescriptorSupplier("GetAllRideShareRequestsByRideOfferID"))
              .build();
        }
      }
    }
    return getGetAllRideShareRequestsByRideOfferIDMethod;
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
    default void createRideShare(RideShareService.grpc.Rideshare.CreateRideShareRequestTest request,
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

    /**
     * <pre>
     *RideShareOffer CRUD functions
     * </pre>
     */
    default void createRideShareOffer(RideShareService.grpc.Rideshare.RideshareOffer request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateRideShareOfferMethod(), responseObserver);
    }

    /**
     */
    default void readRideShareOffer(RideShareService.grpc.Rideshare.RideShareIDRequest request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideshareOffer> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReadRideShareOfferMethod(), responseObserver);
    }

    /**
     */
    default void readAllRideShareOffer(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideshareOfferList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReadAllRideShareOfferMethod(), responseObserver);
    }

    /**
     */
    default void updateRideShareOffer(RideShareService.grpc.Rideshare.RideshareOffer request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateRideShareOfferMethod(), responseObserver);
    }

    /**
     */
    default void deleteRideShareOffer(RideShareService.grpc.Rideshare.RideShareIDRequest request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteRideShareOfferMethod(), responseObserver);
    }

    /**
     * <pre>
     *RideShareRequest CRUD functions
     * </pre>
     */
    default void createRideShareRequest(RideShareService.grpc.Rideshare.RideshareRequest request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateRideShareRequestMethod(), responseObserver);
    }

    /**
     */
    default void readRideShareRequest(RideShareService.grpc.Rideshare.RideShareIDRequest request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideshareRequest> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReadRideShareRequestMethod(), responseObserver);
    }

    /**
     */
    default void readAllRideShareRequest(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareRequestList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReadAllRideShareRequestMethod(), responseObserver);
    }

    /**
     */
    default void updateRideShareRequest(RideShareService.grpc.Rideshare.RideshareRequest request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateRideShareRequestMethod(), responseObserver);
    }

    /**
     */
    default void deleteRideShareRequest(RideShareService.grpc.Rideshare.RideShareIDRequest request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteRideShareRequestMethod(), responseObserver);
    }

    /**
     * <pre>
     *Functions for better search in
     * </pre>
     */
    default void getClosestRideShareRequest(RideShareService.grpc.Rideshare.RideshareRequest request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideshareOfferList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetClosestRideShareRequestMethod(), responseObserver);
    }

    /**
     */
    default void getAllRideShareOffersByUserID(RideShareService.grpc.Rideshare.RideShareIDRequest request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideshareOfferList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllRideShareOffersByUserIDMethod(), responseObserver);
    }

    /**
     */
    default void getAllRideShareRequestsByUserID(RideShareService.grpc.Rideshare.RideShareIDRequest request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareRequestList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllRideShareRequestsByUserIDMethod(), responseObserver);
    }

    /**
     */
    default void getAllRideShareOffersByBookingID(RideShareService.grpc.Rideshare.RideShareIDRequest request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideshareOfferList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllRideShareOffersByBookingIDMethod(), responseObserver);
    }

    /**
     */
    default void getAllRideShareRequestsByRideOfferID(RideShareService.grpc.Rideshare.RideShareIDRequest request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareRequestList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllRideShareRequestsByRideOfferIDMethod(), responseObserver);
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
    public void createRideShare(RideShareService.grpc.Rideshare.CreateRideShareRequestTest request,
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

    /**
     * <pre>
     *RideShareOffer CRUD functions
     * </pre>
     */
    public void createRideShareOffer(RideShareService.grpc.Rideshare.RideshareOffer request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRideShareOfferMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readRideShareOffer(RideShareService.grpc.Rideshare.RideShareIDRequest request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideshareOffer> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReadRideShareOfferMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readAllRideShareOffer(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideshareOfferList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReadAllRideShareOfferMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateRideShareOffer(RideShareService.grpc.Rideshare.RideshareOffer request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateRideShareOfferMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteRideShareOffer(RideShareService.grpc.Rideshare.RideShareIDRequest request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRideShareOfferMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *RideShareRequest CRUD functions
     * </pre>
     */
    public void createRideShareRequest(RideShareService.grpc.Rideshare.RideshareRequest request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRideShareRequestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readRideShareRequest(RideShareService.grpc.Rideshare.RideShareIDRequest request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideshareRequest> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReadRideShareRequestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readAllRideShareRequest(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareRequestList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReadAllRideShareRequestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateRideShareRequest(RideShareService.grpc.Rideshare.RideshareRequest request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateRideShareRequestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteRideShareRequest(RideShareService.grpc.Rideshare.RideShareIDRequest request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRideShareRequestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Functions for better search in
     * </pre>
     */
    public void getClosestRideShareRequest(RideShareService.grpc.Rideshare.RideshareRequest request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideshareOfferList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetClosestRideShareRequestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllRideShareOffersByUserID(RideShareService.grpc.Rideshare.RideShareIDRequest request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideshareOfferList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllRideShareOffersByUserIDMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllRideShareRequestsByUserID(RideShareService.grpc.Rideshare.RideShareIDRequest request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareRequestList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllRideShareRequestsByUserIDMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllRideShareOffersByBookingID(RideShareService.grpc.Rideshare.RideShareIDRequest request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideshareOfferList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllRideShareOffersByBookingIDMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllRideShareRequestsByRideOfferID(RideShareService.grpc.Rideshare.RideShareIDRequest request,
        io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareRequestList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllRideShareRequestsByRideOfferIDMethod(), getCallOptions()), request, responseObserver);
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
    public RideShareService.grpc.Rideshare.RideShareResponse createRideShare(RideShareService.grpc.Rideshare.CreateRideShareRequestTest request) {
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

    /**
     * <pre>
     *RideShareOffer CRUD functions
     * </pre>
     */
    public RideShareService.grpc.Rideshare.RideShareResponse createRideShareOffer(RideShareService.grpc.Rideshare.RideshareOffer request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRideShareOfferMethod(), getCallOptions(), request);
    }

    /**
     */
    public RideShareService.grpc.Rideshare.RideshareOffer readRideShareOffer(RideShareService.grpc.Rideshare.RideShareIDRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReadRideShareOfferMethod(), getCallOptions(), request);
    }

    /**
     */
    public RideShareService.grpc.Rideshare.RideshareOfferList readAllRideShareOffer(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReadAllRideShareOfferMethod(), getCallOptions(), request);
    }

    /**
     */
    public RideShareService.grpc.Rideshare.RideShareResponse updateRideShareOffer(RideShareService.grpc.Rideshare.RideshareOffer request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRideShareOfferMethod(), getCallOptions(), request);
    }

    /**
     */
    public RideShareService.grpc.Rideshare.RideShareResponse deleteRideShareOffer(RideShareService.grpc.Rideshare.RideShareIDRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRideShareOfferMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *RideShareRequest CRUD functions
     * </pre>
     */
    public RideShareService.grpc.Rideshare.RideShareResponse createRideShareRequest(RideShareService.grpc.Rideshare.RideshareRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRideShareRequestMethod(), getCallOptions(), request);
    }

    /**
     */
    public RideShareService.grpc.Rideshare.RideshareRequest readRideShareRequest(RideShareService.grpc.Rideshare.RideShareIDRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReadRideShareRequestMethod(), getCallOptions(), request);
    }

    /**
     */
    public RideShareService.grpc.Rideshare.RideShareRequestList readAllRideShareRequest(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReadAllRideShareRequestMethod(), getCallOptions(), request);
    }

    /**
     */
    public RideShareService.grpc.Rideshare.RideShareResponse updateRideShareRequest(RideShareService.grpc.Rideshare.RideshareRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRideShareRequestMethod(), getCallOptions(), request);
    }

    /**
     */
    public RideShareService.grpc.Rideshare.RideShareResponse deleteRideShareRequest(RideShareService.grpc.Rideshare.RideShareIDRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRideShareRequestMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Functions for better search in
     * </pre>
     */
    public RideShareService.grpc.Rideshare.RideshareOfferList getClosestRideShareRequest(RideShareService.grpc.Rideshare.RideshareRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetClosestRideShareRequestMethod(), getCallOptions(), request);
    }

    /**
     */
    public RideShareService.grpc.Rideshare.RideshareOfferList getAllRideShareOffersByUserID(RideShareService.grpc.Rideshare.RideShareIDRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllRideShareOffersByUserIDMethod(), getCallOptions(), request);
    }

    /**
     */
    public RideShareService.grpc.Rideshare.RideShareRequestList getAllRideShareRequestsByUserID(RideShareService.grpc.Rideshare.RideShareIDRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllRideShareRequestsByUserIDMethod(), getCallOptions(), request);
    }

    /**
     */
    public RideShareService.grpc.Rideshare.RideshareOfferList getAllRideShareOffersByBookingID(RideShareService.grpc.Rideshare.RideShareIDRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllRideShareOffersByBookingIDMethod(), getCallOptions(), request);
    }

    /**
     */
    public RideShareService.grpc.Rideshare.RideShareRequestList getAllRideShareRequestsByRideOfferID(RideShareService.grpc.Rideshare.RideShareIDRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllRideShareRequestsByRideOfferIDMethod(), getCallOptions(), request);
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
        RideShareService.grpc.Rideshare.CreateRideShareRequestTest request) {
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

    /**
     * <pre>
     *RideShareOffer CRUD functions
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<RideShareService.grpc.Rideshare.RideShareResponse> createRideShareOffer(
        RideShareService.grpc.Rideshare.RideshareOffer request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRideShareOfferMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<RideShareService.grpc.Rideshare.RideshareOffer> readRideShareOffer(
        RideShareService.grpc.Rideshare.RideShareIDRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReadRideShareOfferMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<RideShareService.grpc.Rideshare.RideshareOfferList> readAllRideShareOffer(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReadAllRideShareOfferMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<RideShareService.grpc.Rideshare.RideShareResponse> updateRideShareOffer(
        RideShareService.grpc.Rideshare.RideshareOffer request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateRideShareOfferMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<RideShareService.grpc.Rideshare.RideShareResponse> deleteRideShareOffer(
        RideShareService.grpc.Rideshare.RideShareIDRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRideShareOfferMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *RideShareRequest CRUD functions
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<RideShareService.grpc.Rideshare.RideShareResponse> createRideShareRequest(
        RideShareService.grpc.Rideshare.RideshareRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRideShareRequestMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<RideShareService.grpc.Rideshare.RideshareRequest> readRideShareRequest(
        RideShareService.grpc.Rideshare.RideShareIDRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReadRideShareRequestMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<RideShareService.grpc.Rideshare.RideShareRequestList> readAllRideShareRequest(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReadAllRideShareRequestMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<RideShareService.grpc.Rideshare.RideShareResponse> updateRideShareRequest(
        RideShareService.grpc.Rideshare.RideshareRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateRideShareRequestMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<RideShareService.grpc.Rideshare.RideShareResponse> deleteRideShareRequest(
        RideShareService.grpc.Rideshare.RideShareIDRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRideShareRequestMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *Functions for better search in
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<RideShareService.grpc.Rideshare.RideshareOfferList> getClosestRideShareRequest(
        RideShareService.grpc.Rideshare.RideshareRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetClosestRideShareRequestMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<RideShareService.grpc.Rideshare.RideshareOfferList> getAllRideShareOffersByUserID(
        RideShareService.grpc.Rideshare.RideShareIDRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllRideShareOffersByUserIDMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<RideShareService.grpc.Rideshare.RideShareRequestList> getAllRideShareRequestsByUserID(
        RideShareService.grpc.Rideshare.RideShareIDRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllRideShareRequestsByUserIDMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<RideShareService.grpc.Rideshare.RideshareOfferList> getAllRideShareOffersByBookingID(
        RideShareService.grpc.Rideshare.RideShareIDRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllRideShareOffersByBookingIDMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<RideShareService.grpc.Rideshare.RideShareRequestList> getAllRideShareRequestsByRideOfferID(
        RideShareService.grpc.Rideshare.RideShareIDRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllRideShareRequestsByRideOfferIDMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_RIDE_SHARE = 0;
  private static final int METHODID_JOIN_RIDE_SHARE = 1;
  private static final int METHODID_LIST_RIDE_SHARES = 2;
  private static final int METHODID_CREATE_RIDE_SHARE_OFFER = 3;
  private static final int METHODID_READ_RIDE_SHARE_OFFER = 4;
  private static final int METHODID_READ_ALL_RIDE_SHARE_OFFER = 5;
  private static final int METHODID_UPDATE_RIDE_SHARE_OFFER = 6;
  private static final int METHODID_DELETE_RIDE_SHARE_OFFER = 7;
  private static final int METHODID_CREATE_RIDE_SHARE_REQUEST = 8;
  private static final int METHODID_READ_RIDE_SHARE_REQUEST = 9;
  private static final int METHODID_READ_ALL_RIDE_SHARE_REQUEST = 10;
  private static final int METHODID_UPDATE_RIDE_SHARE_REQUEST = 11;
  private static final int METHODID_DELETE_RIDE_SHARE_REQUEST = 12;
  private static final int METHODID_GET_CLOSEST_RIDE_SHARE_REQUEST = 13;
  private static final int METHODID_GET_ALL_RIDE_SHARE_OFFERS_BY_USER_ID = 14;
  private static final int METHODID_GET_ALL_RIDE_SHARE_REQUESTS_BY_USER_ID = 15;
  private static final int METHODID_GET_ALL_RIDE_SHARE_OFFERS_BY_BOOKING_ID = 16;
  private static final int METHODID_GET_ALL_RIDE_SHARE_REQUESTS_BY_RIDE_OFFER_ID = 17;

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
          serviceImpl.createRideShare((RideShareService.grpc.Rideshare.CreateRideShareRequestTest) request,
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
        case METHODID_CREATE_RIDE_SHARE_OFFER:
          serviceImpl.createRideShareOffer((RideShareService.grpc.Rideshare.RideshareOffer) request,
              (io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareResponse>) responseObserver);
          break;
        case METHODID_READ_RIDE_SHARE_OFFER:
          serviceImpl.readRideShareOffer((RideShareService.grpc.Rideshare.RideShareIDRequest) request,
              (io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideshareOffer>) responseObserver);
          break;
        case METHODID_READ_ALL_RIDE_SHARE_OFFER:
          serviceImpl.readAllRideShareOffer((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideshareOfferList>) responseObserver);
          break;
        case METHODID_UPDATE_RIDE_SHARE_OFFER:
          serviceImpl.updateRideShareOffer((RideShareService.grpc.Rideshare.RideshareOffer) request,
              (io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareResponse>) responseObserver);
          break;
        case METHODID_DELETE_RIDE_SHARE_OFFER:
          serviceImpl.deleteRideShareOffer((RideShareService.grpc.Rideshare.RideShareIDRequest) request,
              (io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareResponse>) responseObserver);
          break;
        case METHODID_CREATE_RIDE_SHARE_REQUEST:
          serviceImpl.createRideShareRequest((RideShareService.grpc.Rideshare.RideshareRequest) request,
              (io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareResponse>) responseObserver);
          break;
        case METHODID_READ_RIDE_SHARE_REQUEST:
          serviceImpl.readRideShareRequest((RideShareService.grpc.Rideshare.RideShareIDRequest) request,
              (io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideshareRequest>) responseObserver);
          break;
        case METHODID_READ_ALL_RIDE_SHARE_REQUEST:
          serviceImpl.readAllRideShareRequest((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareRequestList>) responseObserver);
          break;
        case METHODID_UPDATE_RIDE_SHARE_REQUEST:
          serviceImpl.updateRideShareRequest((RideShareService.grpc.Rideshare.RideshareRequest) request,
              (io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareResponse>) responseObserver);
          break;
        case METHODID_DELETE_RIDE_SHARE_REQUEST:
          serviceImpl.deleteRideShareRequest((RideShareService.grpc.Rideshare.RideShareIDRequest) request,
              (io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareResponse>) responseObserver);
          break;
        case METHODID_GET_CLOSEST_RIDE_SHARE_REQUEST:
          serviceImpl.getClosestRideShareRequest((RideShareService.grpc.Rideshare.RideshareRequest) request,
              (io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideshareOfferList>) responseObserver);
          break;
        case METHODID_GET_ALL_RIDE_SHARE_OFFERS_BY_USER_ID:
          serviceImpl.getAllRideShareOffersByUserID((RideShareService.grpc.Rideshare.RideShareIDRequest) request,
              (io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideshareOfferList>) responseObserver);
          break;
        case METHODID_GET_ALL_RIDE_SHARE_REQUESTS_BY_USER_ID:
          serviceImpl.getAllRideShareRequestsByUserID((RideShareService.grpc.Rideshare.RideShareIDRequest) request,
              (io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareRequestList>) responseObserver);
          break;
        case METHODID_GET_ALL_RIDE_SHARE_OFFERS_BY_BOOKING_ID:
          serviceImpl.getAllRideShareOffersByBookingID((RideShareService.grpc.Rideshare.RideShareIDRequest) request,
              (io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideshareOfferList>) responseObserver);
          break;
        case METHODID_GET_ALL_RIDE_SHARE_REQUESTS_BY_RIDE_OFFER_ID:
          serviceImpl.getAllRideShareRequestsByRideOfferID((RideShareService.grpc.Rideshare.RideShareIDRequest) request,
              (io.grpc.stub.StreamObserver<RideShareService.grpc.Rideshare.RideShareRequestList>) responseObserver);
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
              RideShareService.grpc.Rideshare.CreateRideShareRequestTest,
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
        .addMethod(
          getCreateRideShareOfferMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              RideShareService.grpc.Rideshare.RideshareOffer,
              RideShareService.grpc.Rideshare.RideShareResponse>(
                service, METHODID_CREATE_RIDE_SHARE_OFFER)))
        .addMethod(
          getReadRideShareOfferMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              RideShareService.grpc.Rideshare.RideShareIDRequest,
              RideShareService.grpc.Rideshare.RideshareOffer>(
                service, METHODID_READ_RIDE_SHARE_OFFER)))
        .addMethod(
          getReadAllRideShareOfferMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              RideShareService.grpc.Rideshare.RideshareOfferList>(
                service, METHODID_READ_ALL_RIDE_SHARE_OFFER)))
        .addMethod(
          getUpdateRideShareOfferMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              RideShareService.grpc.Rideshare.RideshareOffer,
              RideShareService.grpc.Rideshare.RideShareResponse>(
                service, METHODID_UPDATE_RIDE_SHARE_OFFER)))
        .addMethod(
          getDeleteRideShareOfferMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              RideShareService.grpc.Rideshare.RideShareIDRequest,
              RideShareService.grpc.Rideshare.RideShareResponse>(
                service, METHODID_DELETE_RIDE_SHARE_OFFER)))
        .addMethod(
          getCreateRideShareRequestMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              RideShareService.grpc.Rideshare.RideshareRequest,
              RideShareService.grpc.Rideshare.RideShareResponse>(
                service, METHODID_CREATE_RIDE_SHARE_REQUEST)))
        .addMethod(
          getReadRideShareRequestMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              RideShareService.grpc.Rideshare.RideShareIDRequest,
              RideShareService.grpc.Rideshare.RideshareRequest>(
                service, METHODID_READ_RIDE_SHARE_REQUEST)))
        .addMethod(
          getReadAllRideShareRequestMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              RideShareService.grpc.Rideshare.RideShareRequestList>(
                service, METHODID_READ_ALL_RIDE_SHARE_REQUEST)))
        .addMethod(
          getUpdateRideShareRequestMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              RideShareService.grpc.Rideshare.RideshareRequest,
              RideShareService.grpc.Rideshare.RideShareResponse>(
                service, METHODID_UPDATE_RIDE_SHARE_REQUEST)))
        .addMethod(
          getDeleteRideShareRequestMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              RideShareService.grpc.Rideshare.RideShareIDRequest,
              RideShareService.grpc.Rideshare.RideShareResponse>(
                service, METHODID_DELETE_RIDE_SHARE_REQUEST)))
        .addMethod(
          getGetClosestRideShareRequestMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              RideShareService.grpc.Rideshare.RideshareRequest,
              RideShareService.grpc.Rideshare.RideshareOfferList>(
                service, METHODID_GET_CLOSEST_RIDE_SHARE_REQUEST)))
        .addMethod(
          getGetAllRideShareOffersByUserIDMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              RideShareService.grpc.Rideshare.RideShareIDRequest,
              RideShareService.grpc.Rideshare.RideshareOfferList>(
                service, METHODID_GET_ALL_RIDE_SHARE_OFFERS_BY_USER_ID)))
        .addMethod(
          getGetAllRideShareRequestsByUserIDMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              RideShareService.grpc.Rideshare.RideShareIDRequest,
              RideShareService.grpc.Rideshare.RideShareRequestList>(
                service, METHODID_GET_ALL_RIDE_SHARE_REQUESTS_BY_USER_ID)))
        .addMethod(
          getGetAllRideShareOffersByBookingIDMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              RideShareService.grpc.Rideshare.RideShareIDRequest,
              RideShareService.grpc.Rideshare.RideshareOfferList>(
                service, METHODID_GET_ALL_RIDE_SHARE_OFFERS_BY_BOOKING_ID)))
        .addMethod(
          getGetAllRideShareRequestsByRideOfferIDMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              RideShareService.grpc.Rideshare.RideShareIDRequest,
              RideShareService.grpc.Rideshare.RideShareRequestList>(
                service, METHODID_GET_ALL_RIDE_SHARE_REQUESTS_BY_RIDE_OFFER_ID)))
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
              .addMethod(getCreateRideShareOfferMethod())
              .addMethod(getReadRideShareOfferMethod())
              .addMethod(getReadAllRideShareOfferMethod())
              .addMethod(getUpdateRideShareOfferMethod())
              .addMethod(getDeleteRideShareOfferMethod())
              .addMethod(getCreateRideShareRequestMethod())
              .addMethod(getReadRideShareRequestMethod())
              .addMethod(getReadAllRideShareRequestMethod())
              .addMethod(getUpdateRideShareRequestMethod())
              .addMethod(getDeleteRideShareRequestMethod())
              .addMethod(getGetClosestRideShareRequestMethod())
              .addMethod(getGetAllRideShareOffersByUserIDMethod())
              .addMethod(getGetAllRideShareRequestsByUserIDMethod())
              .addMethod(getGetAllRideShareOffersByBookingIDMethod())
              .addMethod(getGetAllRideShareRequestsByRideOfferIDMethod())
              .build();
        }
      }
    }
    return result;
  }
}
