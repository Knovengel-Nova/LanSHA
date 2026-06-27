package com.amasp.lansha.protocol.tcp;

import com.amasp.lansha.protocol.Packet;
import com.amasp.lansha.protocol.PacketType;
import java.util.UUID;

/**
 *
 * @author knovengel
 */
public class ConnectPacket extends Packet {

    public ConnectPacket() {
        super();
        packetType = PacketType.CONNECT;
    }

    public ConnectPacket(UUID deviceUID, String deviceName, int tcpPort) {
        super(PacketType.CONNECT, deviceUID, deviceName, tcpPort);
    }
}
