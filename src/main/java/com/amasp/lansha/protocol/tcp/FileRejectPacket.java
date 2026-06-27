package com.amasp.lansha.protocol.tcp;

import com.amasp.lansha.protocol.Packet;
import com.amasp.lansha.protocol.PacketType;
import java.util.UUID;

/**
 *
 * @author knovengel
 */
public class FileRejectPacket extends Packet {

    private UUID transferId;

    // no args constructor
    public FileRejectPacket() {
        super();
        this.packetType = PacketType.FILE_REJECT;
    }

    // all args constructor
    public FileRejectPacket(UUID transferId, UUID deviceId, String deviceName, int tcpPort) {
        super(PacketType.FILE_REJECT, deviceId, deviceName, tcpPort);
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
