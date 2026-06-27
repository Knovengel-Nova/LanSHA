package com.amasp.lansha.protocol.tcp;

import com.amasp.lansha.protocol.Packet;
import com.amasp.lansha.protocol.PacketType;
import java.util.UUID;

/**
 *
 * @author knovengel
 */
public class TransferCompletePacket extends Packet {

    private UUID transferId;

    public TransferCompletePacket() {
        super();
        packetType = PacketType.TRANSFER_COMPLETE;
    }

    public TransferCompletePacket(PacketType type, UUID deviceUID, String deviceName, int tcpPort, UUID transferId) {

        super(type, deviceUID, deviceName, tcpPort);

        this.transferId = transferId;
    }

    public UUID getTransferId() {
        return transferId;
    }

    public void setTransferId(UUID transferId) {
        this.transferId = transferId;
    }
    
    
}
