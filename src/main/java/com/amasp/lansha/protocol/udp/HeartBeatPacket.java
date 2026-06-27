package com.amasp.lansha.protocol.udp;

import com.amasp.lansha.protocol.Packet;
import com.amasp.lansha.protocol.PacketType;
import java.util.UUID;

/**
 *
 * @author knovengel
 */
public class HeartBeatPacket extends Packet {
    public HeartBeatPacket(UUID deviceId, String deviceName, int tcpPort) {
        super(PacketType.HEART_BEAT, deviceId, deviceName, tcpPort);
    }
}
