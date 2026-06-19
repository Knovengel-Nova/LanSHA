package com.amasp.lansha.protocol;

import java.util.UUID;

/**
 *
 * @author knovengel
 */
public class FileRejectPacket extends Packet {
    public FileRejectPacket(UUID deviceUID, String deviceName, int tcpPort){
        super(PacketType.FILE_REJECT, deviceUID, deviceName, tcpPort);
    }
}
