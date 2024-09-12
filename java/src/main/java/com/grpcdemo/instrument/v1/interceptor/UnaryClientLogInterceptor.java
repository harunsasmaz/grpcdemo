package com.grpcdemo.instrument.v1.interceptor;

import com.grpcdemo.instrument.v1.logger.LoggerFactory;
import io.grpc.*;
import java.util.logging.Logger;

public class UnaryClientLogInterceptor implements ClientInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(UnaryClientLogInterceptor.class.getName());

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> method,
                                                               CallOptions callOptions,
                                                               Channel next) {
        return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {
            private final long startTime = System.currentTimeMillis();

            @Override
            public void start(Listener<RespT> responseListener, Metadata headers) {
                logger.info(String.format("method: %s, request: %s%n", method.getFullMethodName(), headers));
                super.start(new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(responseListener) {
                    @Override
                    public void onClose(Status status, Metadata trailers) {
                        long took = System.currentTimeMillis() - startTime;
                        logger.info(String.format("response: %s, error: %s, took: %d ms%n", trailers, status, took));
                        super.onClose(status, trailers);
                    }
                }, headers);
            }

            @Override
            public void sendMessage(ReqT message) {
                logger.info(String.format("request: %s", message));
                super.sendMessage(message);
            }
        };
    }
}
