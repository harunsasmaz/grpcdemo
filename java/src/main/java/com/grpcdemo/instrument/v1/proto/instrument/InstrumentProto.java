// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: instrument/v1/instrument.proto
// Protobuf Java Version: 4.28.0

package com.grpcdemo.instrument.v1.proto.instrument;

public final class InstrumentProto {
  private InstrumentProto() {}
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 28,
      /* patch= */ 0,
      /* suffix= */ "",
      InstrumentProto.class.getName());
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
    internal_static_instrument_v1_Instrument_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_instrument_v1_Instrument_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_instrument_v1_Instrument_MetadataEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_instrument_v1_Instrument_MetadataEntry_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\036instrument/v1/instrument.proto\022\rinstru" +
      "ment.v1\032 instrument/v1/trading_pair.prot" +
      "o\"\316\003\n\nInstrument\022\020\n\003uid\030\001 \001(\tR\003uid\022\022\n\004na" +
      "me\030\002 \001(\tR\004name\022\026\n\006symbol\030\003 \001(\tR\006symbol\022\031" +
      "\n\010logo_url\030\004 \001(\tR\007logoUrl\0227\n\010try_pair\030\006 " +
      "\001(\0132\032.instrument.v1.TradingPairH\000R\007tryPa" +
      "ir\0229\n\tusdt_pair\030\007 \001(\0132\032.instrument.v1.Tr" +
      "adingPairH\000R\010usdtPair\0227\n\010usd_pair\030\010 \001(\0132" +
      "\032.instrument.v1.TradingPairH\000R\007usdPair\022\026" +
      "\n\006labels\030\t \003(\tR\006labels\022\030\n\007version\030\n \001(\003R" +
      "\007version\022C\n\010metadata\030\013 \003(\0132\'.instrument." +
      "v1.Instrument.MetadataEntryR\010metadata\032;\n" +
      "\rMetadataEntry\022\020\n\003key\030\001 \001(\tR\003key\022\024\n\005valu" +
      "e\030\002 \001(\tR\005value:\0028\001B\006\n\004pairB\257\001\n+com.grpcd" +
      "emo.instrument.v1.proto.instrumentB\017Inst" +
      "rumentProtoP\001Z\032instrument/v1;instrumentv" +
      "1\242\002\003IXX\252\002\rInstrument.V1\312\002\rInstrument\\V1\342" +
      "\002\031Instrument\\V1\\GPBMetadata\352\002\016Instrument" +
      "::V1b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.grpcdemo.instrument.v1.proto.instrument.TradingPairProto.getDescriptor(),
        });
    internal_static_instrument_v1_Instrument_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_instrument_v1_Instrument_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_instrument_v1_Instrument_descriptor,
        new java.lang.String[] { "Uid", "Name", "Symbol", "LogoUrl", "TryPair", "UsdtPair", "UsdPair", "Labels", "Version", "Metadata", "Pair", });
    internal_static_instrument_v1_Instrument_MetadataEntry_descriptor =
      internal_static_instrument_v1_Instrument_descriptor.getNestedTypes().get(0);
    internal_static_instrument_v1_Instrument_MetadataEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_instrument_v1_Instrument_MetadataEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    descriptor.resolveAllFeaturesImmutable();
    com.grpcdemo.instrument.v1.proto.instrument.TradingPairProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
