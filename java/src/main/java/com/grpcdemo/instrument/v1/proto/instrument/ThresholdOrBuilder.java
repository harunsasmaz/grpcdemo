// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: instrument/v1/threshold.proto
// Protobuf Java Version: 4.28.0

package com.grpcdemo.instrument.v1.proto.instrument;

public interface ThresholdOrBuilder extends
    // @@protoc_insertion_point(interface_extends:instrument.v1.Threshold)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>double min_amount = 1 [json_name = "minAmount"];</code>
   * @return The minAmount.
   */
  double getMinAmount();

  /**
   * <code>double max_amount = 2 [json_name = "maxAmount"];</code>
   * @return The maxAmount.
   */
  double getMaxAmount();

  /**
   * <code>double min_quantity = 3 [json_name = "minQuantity"];</code>
   * @return The minQuantity.
   */
  double getMinQuantity();

  /**
   * <code>double max_quantity = 4 [json_name = "maxQuantity"];</code>
   * @return The maxQuantity.
   */
  double getMaxQuantity();
}
