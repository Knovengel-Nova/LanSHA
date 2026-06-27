package com.amasp.lansha.protocol.tcp;

import com.amasp.lansha.protocol.Packet;
import com.amasp.lansha.protocol.PacketType;
import java.util.UUID;

/**
 *
 * @author knovengel
 */
public class FileAcceptPacket extends Packet {

    private UUID transferId;

    public UUID getTransferId() {
        return transferId;
    }

    public FileAcceptPacket(UUID transferId, UUID deviceUID, String deviceName, int tcpPort) {
        super(PacketType.FILE_ACCEPT, deviceUID, deviceName, tcpPort);
        this.transferId = transferId;
    }

    public FileAcceptPacket() {
        super();
        packetType = PacketType.FILE_ACCEPT;
    }

    public UUID getTransferID() {
        return transferId;
    }

    public void setTransferID(UUID transferID) {
        this.transferId = transferID;
    }

}
