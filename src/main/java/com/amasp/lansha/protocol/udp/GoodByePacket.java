package com.amasp.lansha.protocol.udp;

import com.amasp.lansha.protocol.Packet;
import com.amasp.lansha.protocol.PacketType;
import java.util.UUID;

/**
 *
 * @author knovengel
 */
public class GoodByePacket extends Packet {
    public GoodByePacket(UUID deviceId, String deviceName, int tcpPort) {
        super(PacketType.GOODBYE, deviceId, deviceName, tcpPort);
    }
}
