package com.grpcdemo.instrument.v1.interceptor;

import com.grpcdemo.instrument.v1.logger.LoggerFactory;
import io.grpc.*;
import java.util.logging.Logger;

public class UnaryServerLogInterceptor implements ServerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(UnaryServerLogInterceptor.class.getName());

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call,
                                                                 Metadata headers,
                                                                 ServerCallHandler<ReqT, RespT> next) {
        return new ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT>(next.startCall(call, headers)) {
            private final long start = System.currentTimeMillis();

            @Override
            public void onComplete() {
                long took = System.currentTimeMillis() - start;
                logger.info(String.format("method: %s, took: %d ms%n", call.getMethodDescriptor().getFullMethodName(), took));
                super.onComplete();
            }

            @Override
            public void onMessage(ReqT message) {
                logger.info(String.format("request: %s", message));
                super.onMessage(message);
            }
        };
    }
}
