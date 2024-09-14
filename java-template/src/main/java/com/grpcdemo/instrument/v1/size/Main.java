package com.grpcdemo.instrument.v1.size;

import com.google.protobuf.InvalidProtocolBufferException;
import com.grpcdemo.instrument.v1.proto.instrument.*;
import com.google.protobuf.util.JsonFormat;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        // TODO: create a new instrument object

        try {
            // TODO: marshal to proto binary

            // TODO: marshal to json

            // TODO: log the size diff
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
}
