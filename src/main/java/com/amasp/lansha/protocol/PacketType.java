package com.amasp.lansha.protocol;

/**
 *
 * @author knovengel
 */
public enum PacketType {
    // UDP Packet PacketTypes
    DISCOVERY,
    DISCOVERY_REPLY,
    HEART_BEAT,
    GOODBYE,

    // TCP Packet PacketTypes
    CONNECT,
    FILE_REQUEST,
    FILE_ACCEPT,
    FILE_REJECT,
    FILE_DATA,
    ACK,
    TRANSFER_COMPLETE
}
