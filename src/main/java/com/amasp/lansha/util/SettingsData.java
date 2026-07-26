package com.amasp.lansha.util;

import java.util.UUID;

/**
 *
 * @author knovengel
 */
public class SettingsData {
    private UUID deviceId;
    private String deviceName;
    private int udpPort;
    private int tcpPort;
    
    private int deviceTimeoutInterval;
    private int janitorInterval;
    private int heartBeatBpm;
    private int chunkSize;
    
    private String savePath;

    public UUID getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(UUID deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getUdpPort() {
        return udpPort;
    }

    public void setUdpPort(int udpPort) {
        this.udpPort = udpPort;
    }

    public int getTcpPort() {
        return tcpPort;
    }

    public void setTcpPort(int tcpPort) {
        this.tcpPort = tcpPort;
    }

    public int getDeviceTimeoutInterval() {
        return deviceTimeoutInterval;
    }

    public void setDeviceTimeoutInterval(int deviceTimeoutInterval) {
        this.deviceTimeoutInterval = deviceTimeoutInterval;
    }

    public int getJanitorInterval() {
        return janitorInterval;
    }

    public void setJanitorInterval(int janitorInterval) {
        this.janitorInterval = janitorInterval;
    }

    public int getHeartBeatBpm() {
        return heartBeatBpm;
    }

    public void setHeartBeatBpm(int heartBeatBpm) {
        this.heartBeatBpm = heartBeatBpm;
    }

    public int getChunkSize() {
        return chunkSize;
    }

    public void setChunkSize(int chunkSize) {
        this.chunkSize = chunkSize;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }
    
    
}
