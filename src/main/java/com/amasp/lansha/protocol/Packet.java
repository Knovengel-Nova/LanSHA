package com.amasp.lansha.protocol;

import java.util.UUID;

/**
 *
 * @author knovengel
 */
public class Packet {

    protected PacketType packetType;
    protected UUID deviceId;
    protected String deviceName;
    protected int tcpPort;

    // no arg constructor for jackson
    public Packet() {
    }

    // all args constructor
    public Packet(PacketType packetType, UUID deviceId, String deviceName, int tcpPort) {
        this.packetType = packetType;
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.tcpPort = tcpPort;
    }

    // getters and setters
    public PacketType getPacketType() {
        return packetType;
    }

    public UUID getDeviceId() {
        return deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public int getTcpPort() {
        return tcpPort;
    }

    public void setPacketType(PacketType packetType) {
        this.packetType = packetType;
    }

    public void setDeviceId(UUID deviceId) {
        this.deviceId = deviceId;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setTcpPort(int tcpPort) {
        this.tcpPort = tcpPort;
    }

}
