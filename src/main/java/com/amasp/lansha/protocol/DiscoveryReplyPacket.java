package com.amasp.lansha.protocol;

import java.util.UUID;

/**
 *
 * @author knovengel
 */
public class DiscoveryReplyPacket extends Packet {
    public DiscoveryReplyPacket(UUID deviceUID, String deviceName, int tcpPort){
        super(PacketType.DISCOVERY_REPLY, deviceUID, deviceName, tcpPort);
    }
}
