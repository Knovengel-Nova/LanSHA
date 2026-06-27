package com.amasp.lansha.device;

import com.amasp.lansha.util.Constants;
import java.net.InetAddress;
import java.time.Instant;
import java.util.UUID;

/**
 *
 * @author knovengel
 */
public class DeviceInfo {

    private String deviceName;
    private final UUID deviceId;
    private InetAddress ipAddress;
    private int tcpPort; // receiving tcp server port
    private Instant lastSeen;
    private DeviceStatus status;

    // no args constructor
    public DeviceInfo() {
        this.deviceName = "NO_NAME";
        this.deviceId = UUID.randomUUID();
        this.ipAddress = InetAddress.getLoopbackAddress();
        this.tcpPort = Constants.TCP_PORT;
        this.lastSeen = Instant.now();
        this.status = DeviceStatus.OFFLINE;
    }

    // all args constructor
    public DeviceInfo(String deviceName, UUID deviceId, InetAddress ipAddress, int tcpPort, Instant lastSeen,
            DeviceStatus status) {
        this.deviceName = deviceName;
        this.deviceId = deviceId;
        this.ipAddress = ipAddress;
        this.tcpPort = tcpPort;
        this.lastSeen = lastSeen;
        this.status = status;
    }

    // Getters and Setters
    public String getDeviceName() {
        return deviceName;
    }

    public UUID getDeviceId() {
        return deviceId;
    }

    public InetAddress getIpAddress() {
        return ipAddress;
    }

    public int getTcpPort() {
        return tcpPort;
    }

    public Instant getLastSeen() {
        return lastSeen;
    }

    public DeviceStatus getStatus() {
        return status;
    }

    public void setIpAddress(InetAddress ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setTcpPort(int tcpPort) {
        this.tcpPort = tcpPort;
    }

    public void setLastSeen(Instant lastSeen) {
        this.lastSeen = lastSeen;
    }

    public void setStatus(DeviceStatus status) {
        this.status = status;
    }

    public void setDeviceName(String name){
        this.deviceName = name;
    }

    @Override
    public String toString() {
        return deviceName;
    }

}
