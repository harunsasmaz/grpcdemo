package com.grpcdemo.instrument.v1.size;

import com.google.protobuf.InvalidProtocolBufferException;
import com.grpcdemo.instrument.v1.proto.instrument.*;
import com.google.protobuf.util.JsonFormat;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Instrument dataObj = Instrument.newBuilder()
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

        try {
            // Serialize to protobuf
            byte[] protoBinary = dataObj.toByteArray();

            // Serialize to JSON
            String jsonBinary = JsonFormat.printer().print(dataObj);

            // Output sizes and data
            System.out.printf("Proto Size: %d, Json Size: %d%n", protoBinary.length, jsonBinary.length());
            System.out.printf("Proto Output: %s%n", new String(protoBinary));
            System.out.printf("Json Output: %s%n", jsonBinary);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
}
