package com.amasp.lansha.protocol.tcp;

import com.amasp.lansha.protocol.Packet;
import com.amasp.lansha.protocol.PacketType;
import java.util.UUID;

/**
 *
 * @author knovengel
 */
public class FileRequestPacket extends Packet {

    private String fileName;
    private long fileSize;
    private UUID transferId;

    public FileRequestPacket(UUID transferId, UUID deviceUID, String deviceName, int tcpPort, String fileName, long fileSize) {
        super(PacketType.FILE_REQUEST, deviceUID, deviceName, tcpPort);
        this.transferId = transferId;
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    public FileRequestPacket() {
        super();
        packetType = PacketType.FILE_REQUEST;
    }

    public UUID getTransferId() {
        return transferId;
    }

    public String getFileName() {
        return fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setTransferUid(UUID transferUid) {
        this.transferId = transferUid;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public void setTransferId(UUID transferId) {
        this.transferId = transferId;
    }

}
