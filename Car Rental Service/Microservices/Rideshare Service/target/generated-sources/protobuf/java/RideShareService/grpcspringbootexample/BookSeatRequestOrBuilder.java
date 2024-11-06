// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Rideshare.proto

package RideShareService.grpcspringbootexample;

public interface BookSeatRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:BookSeatRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * CRS_ID (reference to available_rideshare)
   * </pre>
   *
   * <code>string rideId = 1;</code>
   * @return The rideId.
   */
  java.lang.String getRideId();
  /**
   * <pre>
   * CRS_ID (reference to available_rideshare)
   * </pre>
   *
   * <code>string rideId = 1;</code>
   * @return The bytes for rideId.
   */
  com.google.protobuf.ByteString
      getRideIdBytes();

  /**
   * <pre>
   * CRS_ID (reference to Customer Table)
   * </pre>
   *
   * <code>string userId = 2;</code>
   * @return The userId.
   */
  java.lang.String getUserId();
  /**
   * <pre>
   * CRS_ID (reference to Customer Table)
   * </pre>
   *
   * <code>string userId = 2;</code>
   * @return The bytes for userId.
   */
  com.google.protobuf.ByteString
      getUserIdBytes();

  /**
   * <pre>
   * CRS_ADDRESS
   * </pre>
   *
   * <code>string startlocation = 3;</code>
   * @return The startlocation.
   */
  java.lang.String getStartlocation();
  /**
   * <pre>
   * CRS_ADDRESS
   * </pre>
   *
   * <code>string startlocation = 3;</code>
   * @return The bytes for startlocation.
   */
  com.google.protobuf.ByteString
      getStartlocationBytes();

  /**
   * <pre>
   * CRS_ADDRESS
   * </pre>
   *
   * <code>string endlocation = 4;</code>
   * @return The endlocation.
   */
  java.lang.String getEndlocation();
  /**
   * <pre>
   * CRS_ADDRESS
   * </pre>
   *
   * <code>string endlocation = 4;</code>
   * @return The bytes for endlocation.
   */
  com.google.protobuf.ByteString
      getEndlocationBytes();

  /**
   * <pre>
   * CRS_CURRENCY (customer price)
   * </pre>
   *
   * <code>float price = 5;</code>
   * @return The price.
   */
  float getPrice();
}
