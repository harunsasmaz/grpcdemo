// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: instrument/v1/service.proto
// Protobuf Java Version: 4.28.0

package com.grpcdemo.instrument.v1.proto.instrument;

public final class ServiceProto {
  private ServiceProto() {}
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 28,
      /* patch= */ 0,
      /* suffix= */ "",
      ServiceProto.class.getName());
  }
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_instrument_v1_CreateRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_instrument_v1_CreateRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_instrument_v1_CreateResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_instrument_v1_CreateResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_instrument_v1_GetRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_instrument_v1_GetRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_instrument_v1_GetResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_instrument_v1_GetResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\033instrument/v1/service.proto\022\rinstrumen" +
      "t.v1\032\036instrument/v1/instrument.proto\"J\n\r" +
      "CreateRequest\0229\n\ninstrument\030\001 \001(\0132\031.inst" +
      "rument.v1.InstrumentR\ninstrument\"\"\n\016Crea" +
      "teResponse\022\020\n\003uid\030\001 \001(\tR\003uid\"\036\n\nGetReque" +
      "st\022\020\n\003uid\030\001 \001(\tR\003uid\"H\n\013GetResponse\0229\n\ni" +
      "nstrument\030\001 \001(\0132\031.instrument.v1.Instrume" +
      "ntR\ninstrument2\230\001\n\021InstrumentService\022E\n\006" +
      "Create\022\034.instrument.v1.CreateRequest\032\035.i" +
      "nstrument.v1.CreateResponse\022<\n\003Get\022\031.ins" +
      "trument.v1.GetRequest\032\032.instrument.v1.Ge" +
      "tResponseB\254\001\n+com.grpcdemo.instrument.v1" +
      ".proto.instrumentB\014ServiceProtoP\001Z\032instr" +
      "ument/v1;instrumentv1\242\002\003IXX\252\002\rInstrument" +
      ".V1\312\002\rInstrument\\V1\342\002\031Instrument\\V1\\GPBM" +
      "etadata\352\002\016Instrument::V1b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.grpcdemo.instrument.v1.proto.instrument.InstrumentProto.getDescriptor(),
        });
    internal_static_instrument_v1_CreateRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_instrument_v1_CreateRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_instrument_v1_CreateRequest_descriptor,
        new java.lang.String[] { "Instrument", });
    internal_static_instrument_v1_CreateResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_instrument_v1_CreateResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_instrument_v1_CreateResponse_descriptor,
        new java.lang.String[] { "Uid", });
    internal_static_instrument_v1_GetRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_instrument_v1_GetRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_instrument_v1_GetRequest_descriptor,
        new java.lang.String[] { "Uid", });
    internal_static_instrument_v1_GetResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_instrument_v1_GetResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_instrument_v1_GetResponse_descriptor,
        new java.lang.String[] { "Instrument", });
    descriptor.resolveAllFeaturesImmutable();
    com.grpcdemo.instrument.v1.proto.instrument.InstrumentProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
