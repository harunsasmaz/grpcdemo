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
            // TODO: get current time

            @Override
            public void start(Listener<RespT> responseListener, Metadata headers) {
                // TODO: log method and headers

                super.start(new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(responseListener) {
                    @Override
                    public void onClose(Status status, Metadata trailers) {
                        // TODO: log response and response time
                    }
                }, headers);
            }

            @Override
            public void sendMessage(ReqT message) {
                // TODO: log request
            }
        };
    }
}
