// <auto-generated>
//     Generated by the protocol buffer compiler.  DO NOT EDIT!
//     source: Proto/car.proto
// </auto-generated>
#pragma warning disable 0414, 1591, 8981, 0612
#region Designer generated code

using grpc = global::Grpc.Core;

namespace CarManagementService {
  public static partial class CarService
  {
    static readonly string __ServiceName = "CarService";

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
    static readonly grpc::Marshaller<global::CarManagementService.Empty> __Marshaller_Empty = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::CarManagementService.Empty.Parser));
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Marshaller<global::CarManagementService.CarList> __Marshaller_CarList = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::CarManagementService.CarList.Parser));
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Marshaller<global::CarManagementService.CarRequest> __Marshaller_CarRequest = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::CarManagementService.CarRequest.Parser));
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Marshaller<global::CarManagementService.Car> __Marshaller_Car = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::CarManagementService.Car.Parser));
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Marshaller<global::CarManagementService.CarResponse> __Marshaller_CarResponse = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::CarManagementService.CarResponse.Parser));

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Method<global::CarManagementService.Empty, global::CarManagementService.CarList> __Method_GetAllCars = new grpc::Method<global::CarManagementService.Empty, global::CarManagementService.CarList>(
        grpc::MethodType.Unary,
        __ServiceName,
        "GetAllCars",
        __Marshaller_Empty,
        __Marshaller_CarList);

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Method<global::CarManagementService.CarRequest, global::CarManagementService.Car> __Method_GetCarByID = new grpc::Method<global::CarManagementService.CarRequest, global::CarManagementService.Car>(
        grpc::MethodType.Unary,
        __ServiceName,
        "GetCarByID",
        __Marshaller_CarRequest,
        __Marshaller_Car);

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Method<global::CarManagementService.Car, global::CarManagementService.CarResponse> __Method_AddCar = new grpc::Method<global::CarManagementService.Car, global::CarManagementService.CarResponse>(
        grpc::MethodType.Unary,
        __ServiceName,
        "AddCar",
        __Marshaller_Car,
        __Marshaller_CarResponse);

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Method<global::CarManagementService.Car, global::CarManagementService.CarResponse> __Method_UpdateCar = new grpc::Method<global::CarManagementService.Car, global::CarManagementService.CarResponse>(
        grpc::MethodType.Unary,
        __ServiceName,
        "UpdateCar",
        __Marshaller_Car,
        __Marshaller_CarResponse);

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Method<global::CarManagementService.CarRequest, global::CarManagementService.CarResponse> __Method_DeleteCar = new grpc::Method<global::CarManagementService.CarRequest, global::CarManagementService.CarResponse>(
        grpc::MethodType.Unary,
        __ServiceName,
        "DeleteCar",
        __Marshaller_CarRequest,
        __Marshaller_CarResponse);

    /// <summary>Service descriptor</summary>
    public static global::Google.Protobuf.Reflection.ServiceDescriptor Descriptor
    {
      get { return global::CarManagementService.CarReflection.Descriptor.Services[0]; }
    }

    /// <summary>Base class for server-side implementations of CarService</summary>
    [grpc::BindServiceMethod(typeof(CarService), "BindService")]
    public abstract partial class CarServiceBase
    {
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::System.Threading.Tasks.Task<global::CarManagementService.CarList> GetAllCars(global::CarManagementService.Empty request, grpc::ServerCallContext context)
      {
        throw new grpc::RpcException(new grpc::Status(grpc::StatusCode.Unimplemented, ""));
      }

      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::System.Threading.Tasks.Task<global::CarManagementService.Car> GetCarByID(global::CarManagementService.CarRequest request, grpc::ServerCallContext context)
      {
        throw new grpc::RpcException(new grpc::Status(grpc::StatusCode.Unimplemented, ""));
      }

      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::System.Threading.Tasks.Task<global::CarManagementService.CarResponse> AddCar(global::CarManagementService.Car request, grpc::ServerCallContext context)
      {
        throw new grpc::RpcException(new grpc::Status(grpc::StatusCode.Unimplemented, ""));
      }

      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::System.Threading.Tasks.Task<global::CarManagementService.CarResponse> UpdateCar(global::CarManagementService.Car request, grpc::ServerCallContext context)
      {
        throw new grpc::RpcException(new grpc::Status(grpc::StatusCode.Unimplemented, ""));
      }

      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::System.Threading.Tasks.Task<global::CarManagementService.CarResponse> DeleteCar(global::CarManagementService.CarRequest request, grpc::ServerCallContext context)
      {
        throw new grpc::RpcException(new grpc::Status(grpc::StatusCode.Unimplemented, ""));
      }

    }

    /// <summary>Creates service definition that can be registered with a server</summary>
    /// <param name="serviceImpl">An object implementing the server-side handling logic.</param>
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public static grpc::ServerServiceDefinition BindService(CarServiceBase serviceImpl)
    {
      return grpc::ServerServiceDefinition.CreateBuilder()
          .AddMethod(__Method_GetAllCars, serviceImpl.GetAllCars)
          .AddMethod(__Method_GetCarByID, serviceImpl.GetCarByID)
          .AddMethod(__Method_AddCar, serviceImpl.AddCar)
          .AddMethod(__Method_UpdateCar, serviceImpl.UpdateCar)
          .AddMethod(__Method_DeleteCar, serviceImpl.DeleteCar).Build();
    }

    /// <summary>Register service method with a service binder with or without implementation. Useful when customizing the service binding logic.
    /// Note: this method is part of an experimental API that can change or be removed without any prior notice.</summary>
    /// <param name="serviceBinder">Service methods will be bound by calling <c>AddMethod</c> on this object.</param>
    /// <param name="serviceImpl">An object implementing the server-side handling logic.</param>
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public static void BindService(grpc::ServiceBinderBase serviceBinder, CarServiceBase serviceImpl)
    {
      serviceBinder.AddMethod(__Method_GetAllCars, serviceImpl == null ? null : new grpc::UnaryServerMethod<global::CarManagementService.Empty, global::CarManagementService.CarList>(serviceImpl.GetAllCars));
      serviceBinder.AddMethod(__Method_GetCarByID, serviceImpl == null ? null : new grpc::UnaryServerMethod<global::CarManagementService.CarRequest, global::CarManagementService.Car>(serviceImpl.GetCarByID));
      serviceBinder.AddMethod(__Method_AddCar, serviceImpl == null ? null : new grpc::UnaryServerMethod<global::CarManagementService.Car, global::CarManagementService.CarResponse>(serviceImpl.AddCar));
      serviceBinder.AddMethod(__Method_UpdateCar, serviceImpl == null ? null : new grpc::UnaryServerMethod<global::CarManagementService.Car, global::CarManagementService.CarResponse>(serviceImpl.UpdateCar));
      serviceBinder.AddMethod(__Method_DeleteCar, serviceImpl == null ? null : new grpc::UnaryServerMethod<global::CarManagementService.CarRequest, global::CarManagementService.CarResponse>(serviceImpl.DeleteCar));
    }

  }
}
#endregion
