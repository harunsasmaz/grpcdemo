package com.grpcdemo.instrument.v1.server;

import com.grpcdemo.instrument.v1.interceptor.StreamServerAuthInterceptor;
import com.grpcdemo.instrument.v1.interceptor.StreamServerLogInterceptor;
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
        InstrumentServiceImpl service = new InstrumentServiceImpl();

        Server server = NettyServerBuilder.forPort(port)
                .keepAliveTime(2, TimeUnit.HOURS)
                .keepAliveTimeout(30, TimeUnit.SECONDS)
                .maxInboundMessageSize(1000)
                .intercept(new UnaryServerLogInterceptor())
                .intercept(new UnaryServerAuthInterceptor())
                .intercept(new StreamServerLogInterceptor())
                .intercept(new StreamServerAuthInterceptor())
                .addService(service)
                .build()
                .start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            logger.info("Shutting down server...");
            server.shutdown();
            try {
                if (!server.awaitTermination(30, TimeUnit.SECONDS)) {
                    logger.warning("Server did not terminate in the specified timeout.");
                }
            } catch (InterruptedException e) {
                logger.warning("Interrupted while shutting down: " + e.getMessage());
            }
            logger.info("Server stopped");
        }));

        logger.info("Server is running on port " + port);
        server.awaitTermination();
    }
}
