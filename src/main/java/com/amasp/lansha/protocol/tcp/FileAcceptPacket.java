package com.amasp.lansha.protocol.tcp;

import com.amasp.lansha.protocol.Packet;
import com.amasp.lansha.protocol.PacketType;
import java.util.UUID;

/**
 *
 * @author knovengel
 */
public class FileAcceptPacket extends Packet {

    private UUID transferId;// unique id for a particular transfer

    // no args constructor
    public FileAcceptPacket() {
        super();
        packetType = PacketType.FILE_ACCEPT;
    }

    // all args constructor
    public FileAcceptPacket(UUID transferId, UUID deviceId, String deviceName, int tcpPort) {
        super(PacketType.FILE_ACCEPT, deviceId, deviceName, tcpPort);
        this.transferId = transferId;
    }

    // getters and setters
    public UUID getTransferId() {
        return transferId;
    }

    public void setTransferId(UUID transferID) {
        this.transferId = transferID;
    }

}
