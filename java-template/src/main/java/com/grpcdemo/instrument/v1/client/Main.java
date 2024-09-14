package com.grpcdemo.instrument.v1.client;

import com.google.type.DateTime;
import com.grpcdemo.instrument.v1.interceptor.UnaryClientLogInterceptor;
import com.grpcdemo.instrument.v1.proto.instrument.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.stub.MetadataUtils;
import io.grpc.StatusRuntimeException;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String serverUrl = "0.0.0.0:2222";
        String envServerUrl = System.getenv("SERVER_URL");
        if (envServerUrl != null) {
            serverUrl = envServerUrl;
        }

        // TODO: create a new grpc connection and client

        // TODO: create a new metadata with auth header

        // TODO: create a new CreateInstrumentRequest

        // TODO: send CreateInstrument gRPC request

        // TODO: create a new GetInstrumentRequest

        // TODO: send GetInstrument gRPC request and log response

        // TODO: shutdown gRPC channel on termination
    }
}
