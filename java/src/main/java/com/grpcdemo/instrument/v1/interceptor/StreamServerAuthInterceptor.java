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
        // Bypass authentication for specific methods
        if (call.getMethodDescriptor().getFullMethodName().equals("instrumentv1.InstrumentService/Get")) {
            return next.startCall(call, headers);
        }

        // Retrieve the "x-sender-name" from metadata
        String senderName = headers.get(SENDER_NAME_KEY);
        if (senderName == null || !AUTHORIZED_SENDER.equals(senderName)) {
            call.close(Status.UNAUTHENTICATED.withDescription("unauthorized"), headers);
            return new ServerCall.Listener<ReqT>() {};
        }

        // Proceed to the stream handler if authentication is valid
        return next.startCall(call, headers);
    }
}
