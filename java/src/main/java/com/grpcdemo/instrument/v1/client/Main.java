package com.grpcdemo.instrument.v1.client;

import com.grpcdemo.instrument.v1.interceptor.StreamClientLogInterceptor;
import com.grpcdemo.instrument.v1.interceptor.UnaryClientLogInterceptor;
import com.grpcdemo.instrument.v1.proto.instrument.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.stub.MetadataUtils;
import io.grpc.StatusRuntimeException;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String serverUrl = "0.0.0.0:2222";
        String envServerUrl = System.getenv("SERVER_URL");
        if (envServerUrl != null) {
            serverUrl = envServerUrl;
        }

        ManagedChannel channel = ManagedChannelBuilder.forTarget(serverUrl)
                .keepAliveTime(30, TimeUnit.SECONDS)
                .keepAliveTimeout(30, TimeUnit.SECONDS)
                .usePlaintext()
                .intercept(new UnaryClientLogInterceptor())
                .intercept(new StreamClientLogInterceptor())
                .build();

        InstrumentServiceGrpc.InstrumentServiceBlockingStub client = InstrumentServiceGrpc.newBlockingStub(channel);

        Metadata metadata = new Metadata();
        Metadata.Key<String> key = Metadata.Key.of("X-Sender-Name", Metadata.ASCII_STRING_MARSHALLER);
        metadata.put(key, "midascrypto");

        client = MetadataUtils.attachHeaders(client, metadata);

        Instrument instrument = Instrument.newBuilder()
                .setUid("c6abfc9b-c2e1-4d06-8f1b-cf21b07cc4be")
                .setName("Bitcoin")
                .setSymbol("BTC")
                .setLogoUrl("logos/BTC.png")
                .setTryPair(TradingPair.newBuilder()
                        .setUid("c6abfc9b-c2e1-4d06-8f1b-cf21b07cc4be")
                        .setBuyable(true)
                        .setSellable(true)
                        .setStatus(TradingPairStatus.ACTIVE)
                        .setLeft(TradingPairItem.newBuilder()
                                .setUid("c6abfc9b-c2e1-4d06-8f1b-cf21b07cc4be")
                                .setSymbol("BTC")
                                .setDecimalPlaces("8")
                                .build())
                        .setRight(TradingPairItem.newBuilder()
                                .setUid("c6abfc9b-c2e1-4d06-8f1b-cf21b07cc4be")
                                .setSymbol("TRY")
                                .setDecimalPlaces("2")
                                .build())
                        .setThreshold(Threshold.newBuilder()
                                .setMinAmount(50)
                                .setMaxAmount(1000000)
                                .setMinQuantity(0.00001)
                                .setMaxQuantity(1)
                                .build())
                        .build())
                .addLabels("Token")
                .addLabels("Currency")
                .addLabels("NFT")
                .setVersion(1)
                .putMetadata("created_at", ZonedDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .build();

        CreateRequest createReq = CreateRequest.newBuilder()
                .setInstrument(instrument)
                .build();

        try {
            CreateResponse createRes = client.create(createReq);

            GetRequest getReq = GetRequest.newBuilder()
                    .setUid(createRes.getUid())
                    .build();

            GetResponse getRes = client.get(getReq);
            System.out.printf("Created instrument: %s%n", getRes.getInstrument());

        } catch (StatusRuntimeException e) {
            e.printStackTrace();
        } finally {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}
