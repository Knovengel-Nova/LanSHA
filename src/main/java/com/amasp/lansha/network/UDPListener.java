package com.amasp.lansha.network;

import com.amasp.lansha.protocol.Packet;
import com.amasp.lansha.protocol.PacketSerializer;
import com.amasp.lansha.util.Constants;
import com.amasp.lansha.util.LanSHAContext;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;

/**
 *
 * @author knovengel
 */
///
/// Always running thread
/// Listens for UDP Packets on port 60704
///

public class UDPListener implements Runnable {

    private DatagramSocket listenerSocket;
    private LanSHAContext context;

    public UDPListener(LanSHAContext context) {
        this.context = context;
        try {
            listenerSocket = new DatagramSocket(Constants.UDP_PORT);
            listenerSocket.setBroadcast(true);
        } catch (SocketException e) {
            System.out.println("Error Creating UDP Socket in UDPListener...");
            e.printStackTrace();
        }
    }
    
    public void handleDiscovery(DatagramPacket packet, Packet pkt){
        
    }
    
    public void handleDiscoveryReply(DatagramPacket packet, Packet pkt){
        
    }
    
    public void handleHeartBeat(DatagramPacket packet, Packet pkt){
        
    }
    
    public void handleGoodBye(DatagramPacket packet, Packet pkt){
        
    }

    public void processPacket(DatagramPacket packet) {
        Packet pkt = null;
        byte data[] = Arrays.copyOf(packet.getData(), packet.getLength());

        try {
            pkt = PacketSerializer.deserialize(data, Packet.class);
        } catch (Exception e) {
            System.out.println("exception in UDP listner packet deserilinss/....");
            e.printStackTrace();
        }

        if (pkt == null) {
            return;
        }

        switch (pkt.getPacketType()) {
            case DISCOVERY:
                /// 1 device sent a discover packet.
                /// note the device in the registry and send a discovery reply packet.
                break;

            case DISCOVERY_REPLY:
                /// a device sent a discovery reply packet
                /// note the device in the registry.
                break;

            case HEART_BEAT:
                /// a device is alive.
                /// update the last seen field of the device in the registry
                break;

            case GOODBYE:
                /// a device left
                /// remove the device from the registry
                break;

            default:
                throw new AssertionError();
        }
    }

    @Override
    public void run() {
        DatagramPacket packet;
        byte[] buffer = new byte[Constants.BUFFER_SIZE];
        while (!Thread.currentThread().isInterrupted()) {
            packet = new DatagramPacket(buffer, buffer.length);
            try {
                listenerSocket.receive(packet);
                processPacket(packet);
            } catch (IOException e) {
                System.out.println("IOException in packet in UDPListner...");
                e.printStackTrace();
            }
        }
    }

}
