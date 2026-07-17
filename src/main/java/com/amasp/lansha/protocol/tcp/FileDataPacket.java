package com.amasp.lansha.protocol.tcp;

import com.amasp.lansha.protocol.Packet;
import com.amasp.lansha.protocol.PacketType;
import java.util.UUID;

/**
 *
 * @author knovengel
 */
public class FileDataPacket extends Packet {

    private UUID transferId; // fixed transferId for a particular transfer

    private int chunkNumber;// current chunk

    private byte[] data; // buffer (actual file data)

    // no args constructor
    public FileDataPacket() {
        super();
        packetType = PacketType.FILE_DATA;
    }

    // all args constructor
    public FileDataPacket(PacketType type, UUID deviceId, String deviceName, int tcpPort, UUID transferId,
            int chunkNumber, byte[] data) {

        super(type, deviceId, deviceName, tcpPort);

        this.transferId = transferId;
        this.chunkNumber = chunkNumber;
        this.data = data;
    }

    // getters abd setters
    public UUID getTransferId() {
        return transferId;
    }

    public byte[] getData() {
        return data;
    }

    public int getChunkNumber() {
        return chunkNumber;
    }

    public void setTransferId(UUID transferId) {
        this.transferId = transferId;
    }

    public void setChunkNumber(int chunkNumber) {
        this.chunkNumber = chunkNumber;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

}
