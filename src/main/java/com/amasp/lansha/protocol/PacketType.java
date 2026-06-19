package com.amasp.lansha.protocol;

/**
 *
 * @author knovengel
 */
public enum PacketType {
    DISCOVERY,
    DISCOVERY_REPLY,
    HEART_BEAT,
    GOODBYE,
    
    FILE_REQUEST,
    FILE_ACCEPT,
    FILE_REJECT
}
