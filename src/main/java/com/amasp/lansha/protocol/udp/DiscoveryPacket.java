package com.amasp.lansha.protocol.udp;

import com.amasp.lansha.protocol.Packet;
import com.amasp.lansha.protocol.PacketType;
import java.util.UUID;

/**
 *
 * @author knovengel
 */
public class DiscoveryPacket extends Packet {
    public DiscoveryPacket(UUID deviceId, String deviceName, int tcpPort) {
        super(PacketType.DISCOVERY, deviceId, deviceName, tcpPort);
    }
}
