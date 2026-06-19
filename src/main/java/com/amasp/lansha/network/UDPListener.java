package com.amasp.lansha.network;

import com.amasp.lansha.protocol.Packet;
import com.amasp.lansha.protocol.PacketSerializer;
import com.amasp.lansha.protocol.PacketType;
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

    DatagramSocket listenerSocket;

    public UDPListener() {
        try {
            listenerSocket = new DatagramSocket(60704);
            listenerSocket.setBroadcast(true);
        } catch (SocketException e) {
            System.out.println("Error Creating UDP Socket in UDPListener...");
            e.printStackTrace();
        }
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

        switch (pkt.getPacketType()) {
            case DISCOVERY:

                break;

            case DISCOVERY_REPLY:

                break;

            case HEART_BEAT:

                break;

            case GOODBYE:

                break;

            default:
                throw new AssertionError();
        }
    }

    @Override
    public void run() {
        DatagramPacket packet;
        byte[] buffer = new byte[2048];
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
