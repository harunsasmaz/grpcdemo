package com.grpcdemo.instrument.v1.interceptor;

import com.grpcdemo.instrument.v1.logger.LoggerFactory;
import io.grpc.*;
import java.util.logging.Logger;

public class StreamServerLogInterceptor implements ServerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(StreamServerLogInterceptor.class.getName());

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call,
                                                                 Metadata headers,
                                                                 ServerCallHandler<ReqT, RespT> next) {
        return new ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT>(next.startCall(
                new ForwardingServerCall.SimpleForwardingServerCall<ReqT, RespT>(call) {
                    private final long start = System.currentTimeMillis();

                    @Override
                    public void sendMessage(RespT message) {
                        logger.info(String.format("sending response: %s", message));
                        super.sendMessage(message);
                    }

                    @Override
                    public void close(Status status, Metadata trailers) {
                        long took = System.currentTimeMillis() - start;
                        logger.info(String.format("method: %s, status: %s, took: %d ms%n",
                                call.getMethodDescriptor().getFullMethodName(), status, took));
                        super.close(status, trailers);
                    }
                }, headers)) {

            @Override
            public void onMessage(ReqT message) {
                logger.info(String.format("received request: %s", message));
                super.onMessage(message);
            }

            @Override
            public void onComplete() {
                logger.info("stream completed");
                super.onComplete();
            }

            @Override
            public void onCancel() {
                logger.warning("stream cancelled");
                super.onCancel();
            }
        };
    }
}
