package org.example.common;

import org.example.AirQualityIndex;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: AirQualityIndex.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AirQualityServiceGrpc {

  private AirQualityServiceGrpc() {}

  public static final String SERVICE_NAME = "AirQualityService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<AirQualityIndex.AirQualityRequest,
      AirQualityIndex.AirQualityResponse> getGetAirQualityIndexMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAirQualityIndex",
      requestType = AirQualityIndex.AirQualityRequest.class,
      responseType = AirQualityIndex.AirQualityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<AirQualityIndex.AirQualityRequest,
      AirQualityIndex.AirQualityResponse> getGetAirQualityIndexMethod() {
    io.grpc.MethodDescriptor<AirQualityIndex.AirQualityRequest, AirQualityIndex.AirQualityResponse> getGetAirQualityIndexMethod;
    if ((getGetAirQualityIndexMethod = AirQualityServiceGrpc.getGetAirQualityIndexMethod) == null) {
      synchronized (AirQualityServiceGrpc.class) {
        if ((getGetAirQualityIndexMethod = AirQualityServiceGrpc.getGetAirQualityIndexMethod) == null) {
          AirQualityServiceGrpc.getGetAirQualityIndexMethod = getGetAirQualityIndexMethod =
              io.grpc.MethodDescriptor.<AirQualityIndex.AirQualityRequest, AirQualityIndex.AirQualityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAirQualityIndex"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  AirQualityIndex.AirQualityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  AirQualityIndex.AirQualityResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AirQualityServiceMethodDescriptorSupplier("GetAirQualityIndex"))
              .build();
        }
      }
    }
    return getGetAirQualityIndexMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AirQualityServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AirQualityServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AirQualityServiceStub>() {
        @Override
        public AirQualityServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AirQualityServiceStub(channel, callOptions);
        }
      };
    return AirQualityServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AirQualityServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AirQualityServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AirQualityServiceBlockingStub>() {
        @Override
        public AirQualityServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AirQualityServiceBlockingStub(channel, callOptions);
        }
      };
    return AirQualityServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AirQualityServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AirQualityServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AirQualityServiceFutureStub>() {
        @Override
        public AirQualityServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AirQualityServiceFutureStub(channel, callOptions);
        }
      };
    return AirQualityServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getAirQualityIndex(AirQualityIndex.AirQualityRequest request,
                                    io.grpc.stub.StreamObserver<AirQualityIndex.AirQualityResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAirQualityIndexMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AirQualityService.
   */
  public static abstract class AirQualityServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return AirQualityServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AirQualityService.
   */
  public static final class AirQualityServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AirQualityServiceStub> {
    private AirQualityServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected AirQualityServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AirQualityServiceStub(channel, callOptions);
    }

    /**
     */
    public void getAirQualityIndex(AirQualityIndex.AirQualityRequest request,
                                   io.grpc.stub.StreamObserver<AirQualityIndex.AirQualityResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAirQualityIndexMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AirQualityService.
   */
  public static final class AirQualityServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AirQualityServiceBlockingStub> {
    private AirQualityServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected AirQualityServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AirQualityServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public AirQualityIndex.AirQualityResponse getAirQualityIndex(AirQualityIndex.AirQualityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAirQualityIndexMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AirQualityService.
   */
  public static final class AirQualityServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AirQualityServiceFutureStub> {
    private AirQualityServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected AirQualityServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AirQualityServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<AirQualityIndex.AirQualityResponse> getAirQualityIndex(
        AirQualityIndex.AirQualityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAirQualityIndexMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_AIR_QUALITY_INDEX = 0;

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

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_AIR_QUALITY_INDEX:
          serviceImpl.getAirQualityIndex((AirQualityIndex.AirQualityRequest) request,
              (io.grpc.stub.StreamObserver<AirQualityIndex.AirQualityResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
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
          getGetAirQualityIndexMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              AirQualityIndex.AirQualityRequest,
              AirQualityIndex.AirQualityResponse>(
                service, METHODID_GET_AIR_QUALITY_INDEX)))
        .build();
  }

  private static abstract class AirQualityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AirQualityServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return AirQualityIndex.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AirQualityService");
    }
  }

  private static final class AirQualityServiceFileDescriptorSupplier
      extends AirQualityServiceBaseDescriptorSupplier {
    AirQualityServiceFileDescriptorSupplier() {}
  }

  private static final class AirQualityServiceMethodDescriptorSupplier
      extends AirQualityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AirQualityServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AirQualityServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AirQualityServiceFileDescriptorSupplier())
              .addMethod(getGetAirQualityIndexMethod())
              .build();
        }
      }
    }
    return result;
  }
}
