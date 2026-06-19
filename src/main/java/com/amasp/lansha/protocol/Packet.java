package com.amasp.lansha.protocol;

import java.util.UUID;

/**
 *
 * @author knovengel
 */
public class Packet {
    protected PacketType packetType;
    protected UUID deviceUID;
    protected String deviceName;
    protected int tcpPort;

    public Packet() {
    }

    public Packet(PacketType packetType, UUID deviceUID, String deviceName, int tcpPort) {
        this.packetType = packetType;
        this.deviceUID = deviceUID;
        this.deviceName = deviceName;
        this.tcpPort = tcpPort;
    }

    public PacketType getPacketType() {
        return packetType;
    }

    public UUID getDeviceUID() {
        return deviceUID;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public int getTcpPort() {
        return tcpPort;
    }
    
    
}
