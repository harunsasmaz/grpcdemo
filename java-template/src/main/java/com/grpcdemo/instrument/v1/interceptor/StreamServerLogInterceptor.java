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
                        
                    }

                    @Override
                    public void close(Status status, Metadata trailers) {
                        
                    }
                }, headers)) {

            @Override
            public void onMessage(ReqT message) {
                
            }

            @Override
            public void onComplete() {
                
            }

            @Override
            public void onCancel() {
                
            }
        };
    }
}
