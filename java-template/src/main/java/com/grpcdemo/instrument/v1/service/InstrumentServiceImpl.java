package com.grpcdemo.instrument.v1.service;

import com.grpcdemo.instrument.v1.proto.instrument.*;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class InstrumentServiceImpl extends InstrumentServiceGrpc.InstrumentServiceImplBase {

    private final Map<String, Instrument> db = new HashMap<>();

    @Override
    public void create(CreateRequest request, StreamObserver<CreateResponse> responseObserver) {
        // TODO: check if request is valid

        // TODO: save created instrument to db

        // TODO: return response
    }

    @Override
    public void get(GetRequest request, StreamObserver<GetResponse> responseObserver) {
        // TODO: check if request is valid

        // TODO: check if requested instrument exists in db

        // TODO: return response
    }
}

