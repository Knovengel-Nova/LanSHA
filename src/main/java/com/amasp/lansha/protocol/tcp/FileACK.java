package com.amasp.lansha.protocol.tcp;

import com.amasp.lansha.protocol.Packet;
import com.amasp.lansha.protocol.PacketType;

/**
 *
 * @author knovengel
 */
public class FileACK extends Packet {
    // no args constructor
    public FileACK() {
        super();
        this.packetType = PacketType.ACK;
    }
}
