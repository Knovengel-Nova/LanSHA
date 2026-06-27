package com.amasp.lansha.protocol.tcp;

import com.amasp.lansha.protocol.Packet;
import com.amasp.lansha.protocol.PacketType;
import java.util.UUID;

/**
 *
 * @author knovengel
 */
public class FileAcceptPacket extends Packet {
    private UUID transferID;

    public UUID getTransferId() {
        return transferID;
    }

    public FileAcceptPacket(UUID transferID, UUID deviceUID, String deviceName, int tcpPort) {
        super(PacketType.FILE_ACCEPT, deviceUID, deviceName, tcpPort);
        this.transferID = transferID;
    }
    
    public FileAcceptPacket(){
        super();
        packetType = PacketType.FILE_ACCEPT;
    }
}
