package com.grpcdemo.instrument.v1.interceptor;

import com.grpcdemo.instrument.v1.logger.LoggerFactory;
import io.grpc.*;
import java.util.logging.Logger;

public class StreamClientLogInterceptor implements ClientInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(StreamClientLogInterceptor.class.getName());

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> method,
                                                               CallOptions callOptions,
                                                               Channel next) {
        return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {
            private final long startTime = System.currentTimeMillis();

            @Override
            public void start(Listener<RespT> responseListener, Metadata headers) {
                

                super.start(new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(responseListener) {
                    @Override
                    public void onClose(Status status, Metadata trailers) {
                        
                    }
                }, headers);
            }

            @Override
            public void sendMessage(ReqT message) {
                
            }

            @Override
            public void halfClose() {
               
            }

            @Override
            public void cancel(String message, Throwable cause) {
                
            }
        };
    }
}
