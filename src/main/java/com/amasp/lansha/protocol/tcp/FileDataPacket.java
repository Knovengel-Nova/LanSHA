package com.amasp.lansha.protocol.tcp;

import com.amasp.lansha.protocol.Packet;
import com.amasp.lansha.protocol.PacketType;
import java.util.UUID;

/**
 *
 * @author knovengel
 */
public class FileDataPacket extends Packet {

    private UUID transferId;

    private int chunkNumber;

    private int totalChunks;

    private byte[] data;

    public FileDataPacket() {
        super();
        packetType = PacketType.FILE_DATA;
    }

    public FileDataPacket(PacketType type, UUID deviceUID, String deviceName, int tcpPort, UUID transferId,
            int chunkNumber, int totalChunks, byte[] data) {

        super(type, deviceUID, deviceName, tcpPort);

        this.transferId = transferId;
        this.chunkNumber = chunkNumber;
        this.totalChunks = totalChunks;
        this.data = data;
    }

    public UUID getTransferId() {
        return transferId;
    }

    public void setTransferId(UUID transferId) {
        this.transferId = transferId;
    }

    public int getChunkNumber() {
        return chunkNumber;
    }

    public void setChunkNumber(int chunkNumber) {
        this.chunkNumber = chunkNumber;
    }

    public int getTotalChunks() {
        return totalChunks;
    }

    public void setTotalChunks(int totalChunks) {
        this.totalChunks = totalChunks;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
