package com.amasp.lansha.protocol;

import java.util.UUID;

/**
 *
 * @author knovengel
 */
public class FileAcceptPacket extends Packet {
    public FileAcceptPacket(UUID deviceUID, String deviceName, int tcpPort){
        super(PacketType.FILE_ACCEPT, deviceUID, deviceName, tcpPort);
    }
}
