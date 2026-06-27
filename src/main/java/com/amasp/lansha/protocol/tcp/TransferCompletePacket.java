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

    // no args constructor
    public TransferCompletePacket() {
        super();
        packetType = PacketType.TRANSFER_COMPLETE;
    }

    // all args constructor
    public TransferCompletePacket(PacketType type, UUID deviceId, String deviceName, int tcpPort, UUID transferId) {

        super(type, deviceId, deviceName, tcpPort);

        this.transferId = transferId;
    }

    // getters and setters
    public UUID getTransferId() {
        return transferId;
    }

    public void setTransferId(UUID transferId) {
        this.transferId = transferId;
    }

}
