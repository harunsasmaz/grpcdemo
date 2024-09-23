package com.grpcdemo.instrument.v1.interceptor;

import io.grpc.*;

public class StreamServerAuthInterceptor implements ServerInterceptor {

    private static final Metadata.Key<String> SENDER_NAME_KEY =
            Metadata.Key.of("x-sender-name", Metadata.ASCII_STRING_MARSHALLER);
    private static final String AUTHORIZED_SENDER = "midascrypto";

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
            ServerCall<ReqT, RespT> call,
            Metadata headers,
            ServerCallHandler<ReqT, RespT> next) 
    {
        
    }
}
