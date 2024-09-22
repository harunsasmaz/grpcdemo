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
                logger.info(String.format("method: %s, headers: %s%n", method.getFullMethodName(), headers));
                super.start(new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(responseListener) {
                    @Override
                    public void onClose(Status status, Metadata trailers) {
                        long took = System.currentTimeMillis() - startTime;
                        logger.info(String.format("stream closed, trailers: %s, status: %s, took: %d ms%n", trailers, status, took));
                        super.onClose(status, trailers);
                    }
                }, headers);
            }

            @Override
            public void sendMessage(ReqT message) {
                logger.info(String.format("sending message: %s", message));
                super.sendMessage(message);
            }

            @Override
            public void halfClose() {
                logger.info("client finished sending messages");
                super.halfClose();
            }

            @Override
            public void cancel(String message, Throwable cause) {
                logger.warning(String.format("stream cancelled: %s, cause: %s", message, cause));
                super.cancel(message, cause);
            }
        };
    }
}
