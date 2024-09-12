package com.grpcdemo.instrument.v1.proto.instrument;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.66.0)",
    comments = "Source: instrument/v1/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class InstrumentServiceGrpc {

  private InstrumentServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "instrument.v1.InstrumentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.grpcdemo.instrument.v1.proto.instrument.CreateRequest,
      com.grpcdemo.instrument.v1.proto.instrument.CreateResponse> getCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Create",
      requestType = com.grpcdemo.instrument.v1.proto.instrument.CreateRequest.class,
      responseType = com.grpcdemo.instrument.v1.proto.instrument.CreateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpcdemo.instrument.v1.proto.instrument.CreateRequest,
      com.grpcdemo.instrument.v1.proto.instrument.CreateResponse> getCreateMethod() {
    io.grpc.MethodDescriptor<com.grpcdemo.instrument.v1.proto.instrument.CreateRequest, com.grpcdemo.instrument.v1.proto.instrument.CreateResponse> getCreateMethod;
    if ((getCreateMethod = InstrumentServiceGrpc.getCreateMethod) == null) {
      synchronized (InstrumentServiceGrpc.class) {
        if ((getCreateMethod = InstrumentServiceGrpc.getCreateMethod) == null) {
          InstrumentServiceGrpc.getCreateMethod = getCreateMethod =
              io.grpc.MethodDescriptor.<com.grpcdemo.instrument.v1.proto.instrument.CreateRequest, com.grpcdemo.instrument.v1.proto.instrument.CreateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Create"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcdemo.instrument.v1.proto.instrument.CreateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcdemo.instrument.v1.proto.instrument.CreateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InstrumentServiceMethodDescriptorSupplier("Create"))
              .build();
        }
      }
    }
    return getCreateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpcdemo.instrument.v1.proto.instrument.GetRequest,
      com.grpcdemo.instrument.v1.proto.instrument.GetResponse> getGetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Get",
      requestType = com.grpcdemo.instrument.v1.proto.instrument.GetRequest.class,
      responseType = com.grpcdemo.instrument.v1.proto.instrument.GetResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpcdemo.instrument.v1.proto.instrument.GetRequest,
      com.grpcdemo.instrument.v1.proto.instrument.GetResponse> getGetMethod() {
    io.grpc.MethodDescriptor<com.grpcdemo.instrument.v1.proto.instrument.GetRequest, com.grpcdemo.instrument.v1.proto.instrument.GetResponse> getGetMethod;
    if ((getGetMethod = InstrumentServiceGrpc.getGetMethod) == null) {
      synchronized (InstrumentServiceGrpc.class) {
        if ((getGetMethod = InstrumentServiceGrpc.getGetMethod) == null) {
          InstrumentServiceGrpc.getGetMethod = getGetMethod =
              io.grpc.MethodDescriptor.<com.grpcdemo.instrument.v1.proto.instrument.GetRequest, com.grpcdemo.instrument.v1.proto.instrument.GetResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Get"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcdemo.instrument.v1.proto.instrument.GetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcdemo.instrument.v1.proto.instrument.GetResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InstrumentServiceMethodDescriptorSupplier("Get"))
              .build();
        }
      }
    }
    return getGetMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static InstrumentServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InstrumentServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<InstrumentServiceStub>() {
        @java.lang.Override
        public InstrumentServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new InstrumentServiceStub(channel, callOptions);
        }
      };
    return InstrumentServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static InstrumentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InstrumentServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<InstrumentServiceBlockingStub>() {
        @java.lang.Override
        public InstrumentServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new InstrumentServiceBlockingStub(channel, callOptions);
        }
      };
    return InstrumentServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static InstrumentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InstrumentServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<InstrumentServiceFutureStub>() {
        @java.lang.Override
        public InstrumentServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new InstrumentServiceFutureStub(channel, callOptions);
        }
      };
    return InstrumentServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void create(com.grpcdemo.instrument.v1.proto.instrument.CreateRequest request,
        io.grpc.stub.StreamObserver<com.grpcdemo.instrument.v1.proto.instrument.CreateResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateMethod(), responseObserver);
    }

    /**
     */
    default void get(com.grpcdemo.instrument.v1.proto.instrument.GetRequest request,
        io.grpc.stub.StreamObserver<com.grpcdemo.instrument.v1.proto.instrument.GetResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service InstrumentService.
   */
  public static abstract class InstrumentServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return InstrumentServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service InstrumentService.
   */
  public static final class InstrumentServiceStub
      extends io.grpc.stub.AbstractAsyncStub<InstrumentServiceStub> {
    private InstrumentServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InstrumentServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InstrumentServiceStub(channel, callOptions);
    }

    /**
     */
    public void create(com.grpcdemo.instrument.v1.proto.instrument.CreateRequest request,
        io.grpc.stub.StreamObserver<com.grpcdemo.instrument.v1.proto.instrument.CreateResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void get(com.grpcdemo.instrument.v1.proto.instrument.GetRequest request,
        io.grpc.stub.StreamObserver<com.grpcdemo.instrument.v1.proto.instrument.GetResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service InstrumentService.
   */
  public static final class InstrumentServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<InstrumentServiceBlockingStub> {
    private InstrumentServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InstrumentServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InstrumentServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.grpcdemo.instrument.v1.proto.instrument.CreateResponse create(com.grpcdemo.instrument.v1.proto.instrument.CreateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpcdemo.instrument.v1.proto.instrument.GetResponse get(com.grpcdemo.instrument.v1.proto.instrument.GetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service InstrumentService.
   */
  public static final class InstrumentServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<InstrumentServiceFutureStub> {
    private InstrumentServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InstrumentServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InstrumentServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpcdemo.instrument.v1.proto.instrument.CreateResponse> create(
        com.grpcdemo.instrument.v1.proto.instrument.CreateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpcdemo.instrument.v1.proto.instrument.GetResponse> get(
        com.grpcdemo.instrument.v1.proto.instrument.GetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE = 0;
  private static final int METHODID_GET = 1;

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
        case METHODID_CREATE:
          serviceImpl.create((com.grpcdemo.instrument.v1.proto.instrument.CreateRequest) request,
              (io.grpc.stub.StreamObserver<com.grpcdemo.instrument.v1.proto.instrument.CreateResponse>) responseObserver);
          break;
        case METHODID_GET:
          serviceImpl.get((com.grpcdemo.instrument.v1.proto.instrument.GetRequest) request,
              (io.grpc.stub.StreamObserver<com.grpcdemo.instrument.v1.proto.instrument.GetResponse>) responseObserver);
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
          getCreateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.grpcdemo.instrument.v1.proto.instrument.CreateRequest,
              com.grpcdemo.instrument.v1.proto.instrument.CreateResponse>(
                service, METHODID_CREATE)))
        .addMethod(
          getGetMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.grpcdemo.instrument.v1.proto.instrument.GetRequest,
              com.grpcdemo.instrument.v1.proto.instrument.GetResponse>(
                service, METHODID_GET)))
        .build();
  }

  private static abstract class InstrumentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    InstrumentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.grpcdemo.instrument.v1.proto.instrument.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("InstrumentService");
    }
  }

  private static final class InstrumentServiceFileDescriptorSupplier
      extends InstrumentServiceBaseDescriptorSupplier {
    InstrumentServiceFileDescriptorSupplier() {}
  }

  private static final class InstrumentServiceMethodDescriptorSupplier
      extends InstrumentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    InstrumentServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (InstrumentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new InstrumentServiceFileDescriptorSupplier())
              .addMethod(getCreateMethod())
              .addMethod(getGetMethod())
              .build();
        }
      }
    }
    return result;
  }
}
