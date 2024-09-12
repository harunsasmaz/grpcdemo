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
        Instrument instrument = request.getInstrument();

        // Validations similar to the Go version
        if (!instrument.isInitialized()) {
            responseObserver.onError(Status.INVALID_ARGUMENT
                    .withDescription("instrument is required")
                    .asRuntimeException());
            return;
        }

        if (instrument.getName().isEmpty()) {
            responseObserver.onError(Status.INVALID_ARGUMENT
                    .withDescription("instrument name is required")
                    .asRuntimeException());
            return;
        }

        if (instrument.getSymbol().isEmpty()) {
            responseObserver.onError(Status.INVALID_ARGUMENT
                    .withDescription("instrument symbol is required")
                    .asRuntimeException());
            return;
        }

        if (!instrument.hasTryPair() && !instrument.hasUsdPair() && !instrument.hasUsdtPair()) {
            responseObserver.onError(Status.INVALID_ARGUMENT
                    .withDescription("one trading pair is required")
                    .asRuntimeException());
            return;
        }

        String uid = UUID.randomUUID().toString();
        Instrument instrumentWithUid = instrument.toBuilder().setUid(uid).build();
        db.put(uid, instrumentWithUid);

        CreateResponse response = CreateResponse.newBuilder().setUid(uid).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void get(GetRequest request, StreamObserver<GetResponse> responseObserver) {
        String uid = request.getUid();

        if (uid.isEmpty()) {
            responseObserver.onError(Status.INVALID_ARGUMENT
                    .withDescription("instrument uid is required")
                    .asRuntimeException());
            return;
        }

        Instrument instrument = db.get(uid);
        if (instrument == null) {
            responseObserver.onError(Status.NOT_FOUND
                    .withDescription("instrument not found")
                    .asRuntimeException());
            return;
        }

        GetResponse response = GetResponse.newBuilder().setInstrument(instrument).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

