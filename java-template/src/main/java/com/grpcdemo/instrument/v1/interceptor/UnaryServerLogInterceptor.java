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
            // TODO: get current time

            @Override
            public void onComplete() {
                // TODO: log method and response time
            }

            @Override
            public void onMessage(ReqT message) {
                // TODO: log request
            }
        };
    }
}
