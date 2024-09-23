package com.grpcdemo.instrument.v1.interceptor;

import io.grpc.*;

public class StreamServerAuthInterceptor implements ServerInterceptor {

    

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
            ServerCall<ReqT, RespT> call,
            Metadata headers,
            ServerCallHandler<ReqT, RespT> next) 
    {

    }
}
