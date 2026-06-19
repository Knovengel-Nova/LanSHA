package com.amasp.lansha.protocol;

import java.util.UUID;

/**
 *
 * @author knovengel
 */
public class HeartBeatPacket extends Packet {
    public HeartBeatPacket(UUID deviceUID, String deviceName, int tcpPort){
        super(PacketType.HEART_BEAT, deviceUID, deviceName, tcpPort);
    }
}
