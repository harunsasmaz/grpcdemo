package com.grpcdemo.instrument.v1.server;

import com.grpcdemo.instrument.v1.interceptor.UnaryServerAuthInterceptor;
import com.grpcdemo.instrument.v1.interceptor.UnaryServerLogInterceptor;
import com.grpcdemo.instrument.v1.logger.LoggerFactory;
import com.grpcdemo.instrument.v1.service.InstrumentServiceImpl;
import io.grpc.Server;
import io.grpc.netty.NettyServerBuilder;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class.getName());
    private static final int port = 2222;

    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO: create a new service impl instance

        // TODO: create a new gRPC server and register service impl

        // TODO: add shutdown hook for graceful shutdown

        // TODO: await termination
    }
}
