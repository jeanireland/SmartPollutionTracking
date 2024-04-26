package org.example.common;

import org.example.SolarRadiation;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: SolarRadiation.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SolarRadiationServiceGrpc {

  private SolarRadiationServiceGrpc() {}

  public static final String SERVICE_NAME = "SolarRadiationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<SolarRadiation.SolarRadiationRequest,
      SolarRadiation.SolarRadiationResponse> getGetSolarRadiationLevelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSolarRadiationLevel",
      requestType = SolarRadiation.SolarRadiationRequest.class,
      responseType = SolarRadiation.SolarRadiationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<SolarRadiation.SolarRadiationRequest,
      SolarRadiation.SolarRadiationResponse> getGetSolarRadiationLevelMethod() {
    io.grpc.MethodDescriptor<SolarRadiation.SolarRadiationRequest, SolarRadiation.SolarRadiationResponse> getGetSolarRadiationLevelMethod;
    if ((getGetSolarRadiationLevelMethod = SolarRadiationServiceGrpc.getGetSolarRadiationLevelMethod) == null) {
      synchronized (SolarRadiationServiceGrpc.class) {
        if ((getGetSolarRadiationLevelMethod = SolarRadiationServiceGrpc.getGetSolarRadiationLevelMethod) == null) {
          SolarRadiationServiceGrpc.getGetSolarRadiationLevelMethod = getGetSolarRadiationLevelMethod =
              io.grpc.MethodDescriptor.<SolarRadiation.SolarRadiationRequest, SolarRadiation.SolarRadiationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSolarRadiationLevel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SolarRadiation.SolarRadiationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SolarRadiation.SolarRadiationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SolarRadiationServiceMethodDescriptorSupplier("GetSolarRadiationLevel"))
              .build();
        }
      }
    }
    return getGetSolarRadiationLevelMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SolarRadiationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SolarRadiationServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SolarRadiationServiceStub>() {
        @Override
        public SolarRadiationServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SolarRadiationServiceStub(channel, callOptions);
        }
      };
    return SolarRadiationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SolarRadiationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SolarRadiationServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SolarRadiationServiceBlockingStub>() {
        @Override
        public SolarRadiationServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SolarRadiationServiceBlockingStub(channel, callOptions);
        }
      };
    return SolarRadiationServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SolarRadiationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SolarRadiationServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SolarRadiationServiceFutureStub>() {
        @Override
        public SolarRadiationServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SolarRadiationServiceFutureStub(channel, callOptions);
        }
      };
    return SolarRadiationServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getSolarRadiationLevel(SolarRadiation.SolarRadiationRequest request,
                                        io.grpc.stub.StreamObserver<SolarRadiation.SolarRadiationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSolarRadiationLevelMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SolarRadiationService.
   */
  public static abstract class SolarRadiationServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return SolarRadiationServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SolarRadiationService.
   */
  public static final class SolarRadiationServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SolarRadiationServiceStub> {
    private SolarRadiationServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected SolarRadiationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SolarRadiationServiceStub(channel, callOptions);
    }

    /**
     */
    public void getSolarRadiationLevel(SolarRadiation.SolarRadiationRequest request,
                                       io.grpc.stub.StreamObserver<SolarRadiation.SolarRadiationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSolarRadiationLevelMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SolarRadiationService.
   */
  public static final class SolarRadiationServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SolarRadiationServiceBlockingStub> {
    private SolarRadiationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected SolarRadiationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SolarRadiationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public SolarRadiation.SolarRadiationResponse getSolarRadiationLevel(SolarRadiation.SolarRadiationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSolarRadiationLevelMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SolarRadiationService.
   */
  public static final class SolarRadiationServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SolarRadiationServiceFutureStub> {
    private SolarRadiationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected SolarRadiationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SolarRadiationServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<SolarRadiation.SolarRadiationResponse> getSolarRadiationLevel(
        SolarRadiation.SolarRadiationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSolarRadiationLevelMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_SOLAR_RADIATION_LEVEL = 0;

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
        case METHODID_GET_SOLAR_RADIATION_LEVEL:
          serviceImpl.getSolarRadiationLevel((SolarRadiation.SolarRadiationRequest) request,
              (io.grpc.stub.StreamObserver<SolarRadiation.SolarRadiationResponse>) responseObserver);
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
          getGetSolarRadiationLevelMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              SolarRadiation.SolarRadiationRequest,
              SolarRadiation.SolarRadiationResponse>(
                service, METHODID_GET_SOLAR_RADIATION_LEVEL)))
        .build();
  }

  private static abstract class SolarRadiationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SolarRadiationServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return SolarRadiation.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SolarRadiationService");
    }
  }

  private static final class SolarRadiationServiceFileDescriptorSupplier
      extends SolarRadiationServiceBaseDescriptorSupplier {
    SolarRadiationServiceFileDescriptorSupplier() {}
  }

  private static final class SolarRadiationServiceMethodDescriptorSupplier
      extends SolarRadiationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SolarRadiationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SolarRadiationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SolarRadiationServiceFileDescriptorSupplier())
              .addMethod(getGetSolarRadiationLevelMethod())
              .build();
        }
      }
    }
    return result;
  }
}
