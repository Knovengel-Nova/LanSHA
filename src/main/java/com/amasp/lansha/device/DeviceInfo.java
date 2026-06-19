package com.amasp.lansha.device;

import java.net.InetAddress;
import java.time.Instant;
import java.util.UUID;

/**
 *
 * @author knovengel
 */
public class DeviceInfo {

    private final String deviceName;
    private final UUID deviceUID;
    private InetAddress ipAddress;
    private int tcpPort;
    private Instant lastSeen;
    private DeviceStatus status;

    public DeviceInfo(String deviceName, UUID deviceUID, InetAddress ipAddress, int tcpPort, Instant lastSeen, DeviceStatus status) {
        this.deviceName = deviceName;
        this.deviceUID = deviceUID;
        this.ipAddress = ipAddress;
        this.tcpPort = tcpPort;
        this.lastSeen = lastSeen;
        this.status = status;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public UUID getDeviceUID() {
        return deviceUID;
    }

    public InetAddress getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(InetAddress ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getTcpPort() {
        return tcpPort;
    }

    public void setTcpPort(int tcpPort) {
        this.tcpPort = tcpPort;
    }

    public Instant getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Instant lastSeen) {
        this.lastSeen = lastSeen;
    }

    public DeviceStatus getStatus() {
        return status;
    }

    public void setStatus(DeviceStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format(
                "%s [%s] (%s:%d)",
                deviceName,
                deviceUID,
                ipAddress.getHostAddress(),
                tcpPort
        );
    }

}
