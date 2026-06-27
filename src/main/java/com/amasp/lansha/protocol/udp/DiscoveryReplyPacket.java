package com.amasp.lansha.protocol.udp;

import com.amasp.lansha.protocol.Packet;
import com.amasp.lansha.protocol.PacketType;
import java.util.UUID;

/**
 *
 * @author knovengel
 */
public class DiscoveryReplyPacket extends Packet {
    public DiscoveryReplyPacket(UUID deviceId, String deviceName, int tcpPort) {
        super(PacketType.DISCOVERY_REPLY, deviceId, deviceName, tcpPort);
    }
}
