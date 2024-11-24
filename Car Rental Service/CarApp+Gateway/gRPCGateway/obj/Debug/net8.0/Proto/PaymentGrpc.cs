// <auto-generated>
//     Generated by the protocol buffer compiler.  DO NOT EDIT!
//     source: Proto/Payment.proto
// </auto-generated>
#pragma warning disable 0414, 1591, 8981
#region Designer generated code

using grpc = global::Grpc.Core;

public static partial class PaymentService
{
  static readonly string __ServiceName = "PaymentService";

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static void __Helper_SerializeMessage(global::Google.Protobuf.IMessage message, grpc::SerializationContext context)
  {
    #if !GRPC_DISABLE_PROTOBUF_BUFFER_SERIALIZATION
    if (message is global::Google.Protobuf.IBufferMessage)
    {
      context.SetPayloadLength(message.CalculateSize());
      global::Google.Protobuf.MessageExtensions.WriteTo(message, context.GetBufferWriter());
      context.Complete();
      return;
    }
    #endif
    context.Complete(global::Google.Protobuf.MessageExtensions.ToByteArray(message));
  }

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static class __Helper_MessageCache<T>
  {
    public static readonly bool IsBufferMessage = global::System.Reflection.IntrospectionExtensions.GetTypeInfo(typeof(global::Google.Protobuf.IBufferMessage)).IsAssignableFrom(typeof(T));
  }

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static T __Helper_DeserializeMessage<T>(grpc::DeserializationContext context, global::Google.Protobuf.MessageParser<T> parser) where T : global::Google.Protobuf.IMessage<T>
  {
    #if !GRPC_DISABLE_PROTOBUF_BUFFER_SERIALIZATION
    if (__Helper_MessageCache<T>.IsBufferMessage)
    {
      return parser.ParseFrom(context.PayloadAsReadOnlySequence());
    }
    #endif
    return parser.ParseFrom(context.PayloadAsNewBuffer());
  }

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Marshaller<global::PaymentRequest> __Marshaller_PaymentRequest = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::PaymentRequest.Parser));
  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Marshaller<global::PaymentResponse> __Marshaller_PaymentResponse = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::PaymentResponse.Parser));
  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Marshaller<global::PaymentRequestById> __Marshaller_PaymentRequestById = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::PaymentRequestById.Parser));
  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Marshaller<global::PaymentStatusUpdateRequest> __Marshaller_PaymentStatusUpdateRequest = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::PaymentStatusUpdateRequest.Parser));
  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Marshaller<global::Empty> __Marshaller_Empty = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::Empty.Parser));
  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Marshaller<global::PaymentListResponse> __Marshaller_PaymentListResponse = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::PaymentListResponse.Parser));
  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Marshaller<global::PaymentListByCustomerRequest> __Marshaller_PaymentListByCustomerRequest = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::PaymentListByCustomerRequest.Parser));

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Method<global::PaymentRequest, global::PaymentResponse> __Method_CreatePayment = new grpc::Method<global::PaymentRequest, global::PaymentResponse>(
      grpc::MethodType.Unary,
      __ServiceName,
      "CreatePayment",
      __Marshaller_PaymentRequest,
      __Marshaller_PaymentResponse);

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Method<global::PaymentRequestById, global::PaymentResponse> __Method_GetPaymentById = new grpc::Method<global::PaymentRequestById, global::PaymentResponse>(
      grpc::MethodType.Unary,
      __ServiceName,
      "GetPaymentById",
      __Marshaller_PaymentRequestById,
      __Marshaller_PaymentResponse);

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Method<global::PaymentStatusUpdateRequest, global::PaymentResponse> __Method_UpdatePaymentStatus = new grpc::Method<global::PaymentStatusUpdateRequest, global::PaymentResponse>(
      grpc::MethodType.Unary,
      __ServiceName,
      "UpdatePaymentStatus",
      __Marshaller_PaymentStatusUpdateRequest,
      __Marshaller_PaymentResponse);

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Method<global::Empty, global::PaymentListResponse> __Method_ListPayments = new grpc::Method<global::Empty, global::PaymentListResponse>(
      grpc::MethodType.Unary,
      __ServiceName,
      "ListPayments",
      __Marshaller_Empty,
      __Marshaller_PaymentListResponse);

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Method<global::PaymentRequestById, global::PaymentResponse> __Method_DeletePayment = new grpc::Method<global::PaymentRequestById, global::PaymentResponse>(
      grpc::MethodType.Unary,
      __ServiceName,
      "DeletePayment",
      __Marshaller_PaymentRequestById,
      __Marshaller_PaymentResponse);

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Method<global::PaymentListByCustomerRequest, global::PaymentListResponse> __Method_ListPaymentsByCustomer = new grpc::Method<global::PaymentListByCustomerRequest, global::PaymentListResponse>(
      grpc::MethodType.Unary,
      __ServiceName,
      "ListPaymentsByCustomer",
      __Marshaller_PaymentListByCustomerRequest,
      __Marshaller_PaymentListResponse);

  /// <summary>Service descriptor</summary>
  public static global::Google.Protobuf.Reflection.ServiceDescriptor Descriptor
  {
    get { return global::PaymentReflection.Descriptor.Services[0]; }
  }

  /// <summary>Client for PaymentService</summary>
  public partial class PaymentServiceClient : grpc::ClientBase<PaymentServiceClient>
  {
    /// <summary>Creates a new client for PaymentService</summary>
    /// <param name="channel">The channel to use to make remote calls.</param>
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public PaymentServiceClient(grpc::ChannelBase channel) : base(channel)
    {
    }
    /// <summary>Creates a new client for PaymentService that uses a custom <c>CallInvoker</c>.</summary>
    /// <param name="callInvoker">The callInvoker to use to make remote calls.</param>
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public PaymentServiceClient(grpc::CallInvoker callInvoker) : base(callInvoker)
    {
    }
    /// <summary>Protected parameterless constructor to allow creation of test doubles.</summary>
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    protected PaymentServiceClient() : base()
    {
    }
    /// <summary>Protected constructor to allow creation of configured clients.</summary>
    /// <param name="configuration">The client configuration.</param>
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    protected PaymentServiceClient(ClientBaseConfiguration configuration) : base(configuration)
    {
    }

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::PaymentResponse CreatePayment(global::PaymentRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return CreatePayment(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::PaymentResponse CreatePayment(global::PaymentRequest request, grpc::CallOptions options)
    {
      return CallInvoker.BlockingUnaryCall(__Method_CreatePayment, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::PaymentResponse> CreatePaymentAsync(global::PaymentRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return CreatePaymentAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::PaymentResponse> CreatePaymentAsync(global::PaymentRequest request, grpc::CallOptions options)
    {
      return CallInvoker.AsyncUnaryCall(__Method_CreatePayment, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::PaymentResponse GetPaymentById(global::PaymentRequestById request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return GetPaymentById(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::PaymentResponse GetPaymentById(global::PaymentRequestById request, grpc::CallOptions options)
    {
      return CallInvoker.BlockingUnaryCall(__Method_GetPaymentById, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::PaymentResponse> GetPaymentByIdAsync(global::PaymentRequestById request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return GetPaymentByIdAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::PaymentResponse> GetPaymentByIdAsync(global::PaymentRequestById request, grpc::CallOptions options)
    {
      return CallInvoker.AsyncUnaryCall(__Method_GetPaymentById, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::PaymentResponse UpdatePaymentStatus(global::PaymentStatusUpdateRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return UpdatePaymentStatus(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::PaymentResponse UpdatePaymentStatus(global::PaymentStatusUpdateRequest request, grpc::CallOptions options)
    {
      return CallInvoker.BlockingUnaryCall(__Method_UpdatePaymentStatus, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::PaymentResponse> UpdatePaymentStatusAsync(global::PaymentStatusUpdateRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return UpdatePaymentStatusAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::PaymentResponse> UpdatePaymentStatusAsync(global::PaymentStatusUpdateRequest request, grpc::CallOptions options)
    {
      return CallInvoker.AsyncUnaryCall(__Method_UpdatePaymentStatus, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::PaymentListResponse ListPayments(global::Empty request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return ListPayments(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::PaymentListResponse ListPayments(global::Empty request, grpc::CallOptions options)
    {
      return CallInvoker.BlockingUnaryCall(__Method_ListPayments, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::PaymentListResponse> ListPaymentsAsync(global::Empty request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return ListPaymentsAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::PaymentListResponse> ListPaymentsAsync(global::Empty request, grpc::CallOptions options)
    {
      return CallInvoker.AsyncUnaryCall(__Method_ListPayments, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::PaymentResponse DeletePayment(global::PaymentRequestById request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return DeletePayment(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::PaymentResponse DeletePayment(global::PaymentRequestById request, grpc::CallOptions options)
    {
      return CallInvoker.BlockingUnaryCall(__Method_DeletePayment, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::PaymentResponse> DeletePaymentAsync(global::PaymentRequestById request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return DeletePaymentAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::PaymentResponse> DeletePaymentAsync(global::PaymentRequestById request, grpc::CallOptions options)
    {
      return CallInvoker.AsyncUnaryCall(__Method_DeletePayment, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::PaymentListResponse ListPaymentsByCustomer(global::PaymentListByCustomerRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return ListPaymentsByCustomer(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::PaymentListResponse ListPaymentsByCustomer(global::PaymentListByCustomerRequest request, grpc::CallOptions options)
    {
      return CallInvoker.BlockingUnaryCall(__Method_ListPaymentsByCustomer, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::PaymentListResponse> ListPaymentsByCustomerAsync(global::PaymentListByCustomerRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return ListPaymentsByCustomerAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::PaymentListResponse> ListPaymentsByCustomerAsync(global::PaymentListByCustomerRequest request, grpc::CallOptions options)
    {
      return CallInvoker.AsyncUnaryCall(__Method_ListPaymentsByCustomer, null, options, request);
    }
    /// <summary>Creates a new instance of client from given <c>ClientBaseConfiguration</c>.</summary>
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    protected override PaymentServiceClient NewInstance(ClientBaseConfiguration configuration)
    {
      return new PaymentServiceClient(configuration);
    }
  }

}
public static partial class CreditCardService
{
  static readonly string __ServiceName = "CreditCardService";

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static void __Helper_SerializeMessage(global::Google.Protobuf.IMessage message, grpc::SerializationContext context)
  {
    #if !GRPC_DISABLE_PROTOBUF_BUFFER_SERIALIZATION
    if (message is global::Google.Protobuf.IBufferMessage)
    {
      context.SetPayloadLength(message.CalculateSize());
      global::Google.Protobuf.MessageExtensions.WriteTo(message, context.GetBufferWriter());
      context.Complete();
      return;
    }
    #endif
    context.Complete(global::Google.Protobuf.MessageExtensions.ToByteArray(message));
  }

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static class __Helper_MessageCache<T>
  {
    public static readonly bool IsBufferMessage = global::System.Reflection.IntrospectionExtensions.GetTypeInfo(typeof(global::Google.Protobuf.IBufferMessage)).IsAssignableFrom(typeof(T));
  }

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static T __Helper_DeserializeMessage<T>(grpc::DeserializationContext context, global::Google.Protobuf.MessageParser<T> parser) where T : global::Google.Protobuf.IMessage<T>
  {
    #if !GRPC_DISABLE_PROTOBUF_BUFFER_SERIALIZATION
    if (__Helper_MessageCache<T>.IsBufferMessage)
    {
      return parser.ParseFrom(context.PayloadAsReadOnlySequence());
    }
    #endif
    return parser.ParseFrom(context.PayloadAsNewBuffer());
  }

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Marshaller<global::CreditcardRequest> __Marshaller_CreditcardRequest = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::CreditcardRequest.Parser));
  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Marshaller<global::CreditcardResponse> __Marshaller_CreditcardResponse = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::CreditcardResponse.Parser));
  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Marshaller<global::CreditcardRequestById> __Marshaller_CreditcardRequestById = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::CreditcardRequestById.Parser));
  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Marshaller<global::Empty> __Marshaller_Empty = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::Empty.Parser));
  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Marshaller<global::CreditcardListResponse> __Marshaller_CreditcardListResponse = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::CreditcardListResponse.Parser));

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Method<global::CreditcardRequest, global::CreditcardResponse> __Method_CreateCreditcard = new grpc::Method<global::CreditcardRequest, global::CreditcardResponse>(
      grpc::MethodType.Unary,
      __ServiceName,
      "CreateCreditcard",
      __Marshaller_CreditcardRequest,
      __Marshaller_CreditcardResponse);

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Method<global::CreditcardRequestById, global::CreditcardResponse> __Method_GetCreditcardById = new grpc::Method<global::CreditcardRequestById, global::CreditcardResponse>(
      grpc::MethodType.Unary,
      __ServiceName,
      "GetCreditcardById",
      __Marshaller_CreditcardRequestById,
      __Marshaller_CreditcardResponse);

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Method<global::Empty, global::CreditcardListResponse> __Method_GetAllCreditcards = new grpc::Method<global::Empty, global::CreditcardListResponse>(
      grpc::MethodType.Unary,
      __ServiceName,
      "GetAllCreditcards",
      __Marshaller_Empty,
      __Marshaller_CreditcardListResponse);

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Method<global::CreditcardRequestById, global::CreditcardResponse> __Method_DeleteCreditcard = new grpc::Method<global::CreditcardRequestById, global::CreditcardResponse>(
      grpc::MethodType.Unary,
      __ServiceName,
      "DeleteCreditcard",
      __Marshaller_CreditcardRequestById,
      __Marshaller_CreditcardResponse);

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Method<global::CreditcardRequest, global::CreditcardResponse> __Method_UpdateCreditcard = new grpc::Method<global::CreditcardRequest, global::CreditcardResponse>(
      grpc::MethodType.Unary,
      __ServiceName,
      "UpdateCreditcard",
      __Marshaller_CreditcardRequest,
      __Marshaller_CreditcardResponse);

  /// <summary>Service descriptor</summary>
  public static global::Google.Protobuf.Reflection.ServiceDescriptor Descriptor
  {
    get { return global::PaymentReflection.Descriptor.Services[1]; }
  }

  /// <summary>Client for CreditCardService</summary>
  public partial class CreditCardServiceClient : grpc::ClientBase<CreditCardServiceClient>
  {
    /// <summary>Creates a new client for CreditCardService</summary>
    /// <param name="channel">The channel to use to make remote calls.</param>
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public CreditCardServiceClient(grpc::ChannelBase channel) : base(channel)
    {
    }
    /// <summary>Creates a new client for CreditCardService that uses a custom <c>CallInvoker</c>.</summary>
    /// <param name="callInvoker">The callInvoker to use to make remote calls.</param>
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public CreditCardServiceClient(grpc::CallInvoker callInvoker) : base(callInvoker)
    {
    }
    /// <summary>Protected parameterless constructor to allow creation of test doubles.</summary>
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    protected CreditCardServiceClient() : base()
    {
    }
    /// <summary>Protected constructor to allow creation of configured clients.</summary>
    /// <param name="configuration">The client configuration.</param>
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    protected CreditCardServiceClient(ClientBaseConfiguration configuration) : base(configuration)
    {
    }

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::CreditcardResponse CreateCreditcard(global::CreditcardRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return CreateCreditcard(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::CreditcardResponse CreateCreditcard(global::CreditcardRequest request, grpc::CallOptions options)
    {
      return CallInvoker.BlockingUnaryCall(__Method_CreateCreditcard, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::CreditcardResponse> CreateCreditcardAsync(global::CreditcardRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return CreateCreditcardAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::CreditcardResponse> CreateCreditcardAsync(global::CreditcardRequest request, grpc::CallOptions options)
    {
      return CallInvoker.AsyncUnaryCall(__Method_CreateCreditcard, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::CreditcardResponse GetCreditcardById(global::CreditcardRequestById request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return GetCreditcardById(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::CreditcardResponse GetCreditcardById(global::CreditcardRequestById request, grpc::CallOptions options)
    {
      return CallInvoker.BlockingUnaryCall(__Method_GetCreditcardById, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::CreditcardResponse> GetCreditcardByIdAsync(global::CreditcardRequestById request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return GetCreditcardByIdAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::CreditcardResponse> GetCreditcardByIdAsync(global::CreditcardRequestById request, grpc::CallOptions options)
    {
      return CallInvoker.AsyncUnaryCall(__Method_GetCreditcardById, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::CreditcardListResponse GetAllCreditcards(global::Empty request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return GetAllCreditcards(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::CreditcardListResponse GetAllCreditcards(global::Empty request, grpc::CallOptions options)
    {
      return CallInvoker.BlockingUnaryCall(__Method_GetAllCreditcards, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::CreditcardListResponse> GetAllCreditcardsAsync(global::Empty request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return GetAllCreditcardsAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::CreditcardListResponse> GetAllCreditcardsAsync(global::Empty request, grpc::CallOptions options)
    {
      return CallInvoker.AsyncUnaryCall(__Method_GetAllCreditcards, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::CreditcardResponse DeleteCreditcard(global::CreditcardRequestById request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return DeleteCreditcard(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::CreditcardResponse DeleteCreditcard(global::CreditcardRequestById request, grpc::CallOptions options)
    {
      return CallInvoker.BlockingUnaryCall(__Method_DeleteCreditcard, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::CreditcardResponse> DeleteCreditcardAsync(global::CreditcardRequestById request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return DeleteCreditcardAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::CreditcardResponse> DeleteCreditcardAsync(global::CreditcardRequestById request, grpc::CallOptions options)
    {
      return CallInvoker.AsyncUnaryCall(__Method_DeleteCreditcard, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::CreditcardResponse UpdateCreditcard(global::CreditcardRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return UpdateCreditcard(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::CreditcardResponse UpdateCreditcard(global::CreditcardRequest request, grpc::CallOptions options)
    {
      return CallInvoker.BlockingUnaryCall(__Method_UpdateCreditcard, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::CreditcardResponse> UpdateCreditcardAsync(global::CreditcardRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return UpdateCreditcardAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::CreditcardResponse> UpdateCreditcardAsync(global::CreditcardRequest request, grpc::CallOptions options)
    {
      return CallInvoker.AsyncUnaryCall(__Method_UpdateCreditcard, null, options, request);
    }
    /// <summary>Creates a new instance of client from given <c>ClientBaseConfiguration</c>.</summary>
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    protected override CreditCardServiceClient NewInstance(ClientBaseConfiguration configuration)
    {
      return new CreditCardServiceClient(configuration);
    }
  }

}
#endregion
