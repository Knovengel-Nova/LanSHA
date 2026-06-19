package com.amasp.lansha.protocol;

import java.util.UUID;

/**
 *
 * @author knovengel
 */
public class GoodByePacket extends Packet {
    public GoodByePacket(UUID deviceUID, String deviceName, int tcpPort){
        super(PacketType.GOODBYE, deviceUID, deviceName, tcpPort);
    }
}
