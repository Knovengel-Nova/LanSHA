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
    
    public FileRejectPacket(){
        super();
        this.packetType = PacketType.FILE_REJECT;
    }

    public FileRejectPacket(UUID transferId, UUID deviceUID, String deviceName, int tcpPort) {
        super(PacketType.FILE_REJECT, deviceUID, deviceName, tcpPort);
        this.transferId = transferId;
    }

    public UUID getTransferId() {
        return transferId;
    }
}
