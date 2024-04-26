package org.example.common;

import org.example.PHLevelMeter;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: PHLevelMeter.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class pHLevelMeterGrpc {

  private pHLevelMeterGrpc() {}

  public static final String SERVICE_NAME = "pHLevelMeter";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<PHLevelMeter.PhLevelRequest,
      PHLevelMeter.PhLevelResponse> getGetPhLevelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPhLevel",
      requestType = PHLevelMeter.PhLevelRequest.class,
      responseType = PHLevelMeter.PhLevelResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<PHLevelMeter.PhLevelRequest,
      PHLevelMeter.PhLevelResponse> getGetPhLevelMethod() {
    io.grpc.MethodDescriptor<PHLevelMeter.PhLevelRequest, PHLevelMeter.PhLevelResponse> getGetPhLevelMethod;
    if ((getGetPhLevelMethod = pHLevelMeterGrpc.getGetPhLevelMethod) == null) {
      synchronized (pHLevelMeterGrpc.class) {
        if ((getGetPhLevelMethod = pHLevelMeterGrpc.getGetPhLevelMethod) == null) {
          pHLevelMeterGrpc.getGetPhLevelMethod = getGetPhLevelMethod =
              io.grpc.MethodDescriptor.<PHLevelMeter.PhLevelRequest, PHLevelMeter.PhLevelResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPhLevel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  PHLevelMeter.PhLevelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  PHLevelMeter.PhLevelResponse.getDefaultInstance()))
              .setSchemaDescriptor(new pHLevelMeterMethodDescriptorSupplier("GetPhLevel"))
              .build();
        }
      }
    }
    return getGetPhLevelMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static pHLevelMeterStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<pHLevelMeterStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<pHLevelMeterStub>() {
        @Override
        public pHLevelMeterStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new pHLevelMeterStub(channel, callOptions);
        }
      };
    return pHLevelMeterStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static pHLevelMeterBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<pHLevelMeterBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<pHLevelMeterBlockingStub>() {
        @Override
        public pHLevelMeterBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new pHLevelMeterBlockingStub(channel, callOptions);
        }
      };
    return pHLevelMeterBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static pHLevelMeterFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<pHLevelMeterFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<pHLevelMeterFutureStub>() {
        @Override
        public pHLevelMeterFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new pHLevelMeterFutureStub(channel, callOptions);
        }
      };
    return pHLevelMeterFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * Sends a request to get the current pH level at a specific location
     * </pre>
     */
    default void getPhLevel(PHLevelMeter.PhLevelRequest request,
                            io.grpc.stub.StreamObserver<PHLevelMeter.PhLevelResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPhLevelMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service pHLevelMeter.
   */
  public static abstract class pHLevelMeterImplBase
      implements io.grpc.BindableService, AsyncService {

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return pHLevelMeterGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service pHLevelMeter.
   */
  public static final class pHLevelMeterStub
      extends io.grpc.stub.AbstractAsyncStub<pHLevelMeterStub> {
    private pHLevelMeterStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected pHLevelMeterStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new pHLevelMeterStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a request to get the current pH level at a specific location
     * </pre>
     */
    public void getPhLevel(PHLevelMeter.PhLevelRequest request,
                           io.grpc.stub.StreamObserver<PHLevelMeter.PhLevelResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPhLevelMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service pHLevelMeter.
   */
  public static final class pHLevelMeterBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<pHLevelMeterBlockingStub> {
    private pHLevelMeterBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected pHLevelMeterBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new pHLevelMeterBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a request to get the current pH level at a specific location
     * </pre>
     */
    public PHLevelMeter.PhLevelResponse getPhLevel(PHLevelMeter.PhLevelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPhLevelMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service pHLevelMeter.
   */
  public static final class pHLevelMeterFutureStub
      extends io.grpc.stub.AbstractFutureStub<pHLevelMeterFutureStub> {
    private pHLevelMeterFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected pHLevelMeterFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new pHLevelMeterFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a request to get the current pH level at a specific location
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<PHLevelMeter.PhLevelResponse> getPhLevel(
        PHLevelMeter.PhLevelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPhLevelMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PH_LEVEL = 0;

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
        case METHODID_GET_PH_LEVEL:
          serviceImpl.getPhLevel((PHLevelMeter.PhLevelRequest) request,
              (io.grpc.stub.StreamObserver<PHLevelMeter.PhLevelResponse>) responseObserver);
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
          getGetPhLevelMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              PHLevelMeter.PhLevelRequest,
              PHLevelMeter.PhLevelResponse>(
                service, METHODID_GET_PH_LEVEL)))
        .build();
  }

  private static abstract class pHLevelMeterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    pHLevelMeterBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return PHLevelMeter.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("pHLevelMeter");
    }
  }

  private static final class pHLevelMeterFileDescriptorSupplier
      extends pHLevelMeterBaseDescriptorSupplier {
    pHLevelMeterFileDescriptorSupplier() {}
  }

  private static final class pHLevelMeterMethodDescriptorSupplier
      extends pHLevelMeterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    pHLevelMeterMethodDescriptorSupplier(String methodName) {
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
      synchronized (pHLevelMeterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new pHLevelMeterFileDescriptorSupplier())
              .addMethod(getGetPhLevelMethod())
              .build();
        }
      }
    }
    return result;
  }
}
