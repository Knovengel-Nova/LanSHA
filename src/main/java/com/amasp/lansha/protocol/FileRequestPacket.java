package com.amasp.lansha.protocol;

import java.util.UUID;

/**
 *
 * @author knovengel
 */
public class FileRequestPacket extends Packet {

    private String fileName;
    private long fileSize;

    public FileRequestPacket(UUID deviceUID, String deviceName, int tcpPort, String fileName, long fileSize) {
        super(PacketType.FILE_REQUEST, deviceUID, deviceName, tcpPort);

        this.fileName = fileName;
        this.fileSize = fileSize;
    }
}
