package com.amasp.lansha.network;

import com.amasp.lansha.device.DeviceInfo;
import com.amasp.lansha.device.DeviceStatus;
import com.amasp.lansha.protocol.Packet;
import com.amasp.lansha.protocol.PacketSerializer;
import com.amasp.lansha.protocol.udp.DiscoveryReplyPacket;
import com.amasp.lansha.util.Constants;
import com.amasp.lansha.util.LanSHAContext;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.time.Instant;
import java.util.Arrays;

/**
 *
 * @author knovengel
 */
///
/// Always running thread
/// Only Listens for incomming UDP Packets on port 60704(Constants.UDP_PORT)
///

public class UDPListener implements Runnable {

    private DatagramSocket listenerSocket; // one listener socket(server) for entire application
    private LanSHAContext context;

    // all args constructor
    public UDPListener(LanSHAContext context) {
        this.context = context;
        // set up listener socket
        try {
            listenerSocket = new DatagramSocket(Constants.UDP_PORT);
            listenerSocket.setBroadcast(true);
        } catch (SocketException e) {
            System.out.println("Error Creating UDP Socket in UDPListener...");
            e.printStackTrace();
        }
    }

    private void handleDiscovery(DatagramPacket packet, Packet pkt) {
        // packet is from other device.
        // he sent startup discovery packet
        System.out.println(
                "UDPListner: Discovery Packet Received from " + pkt.getDeviceName() + "[" + packet.getAddress() + "]");

        // add the device to our registry
        DeviceInfo newDevice = new DeviceInfo(pkt.getDeviceName(), pkt.getDeviceId(), packet.getAddress(),
                pkt.getTcpPort(), Instant.now(), DeviceStatus.ONLINE);

        // update Registry
        context.getDeviceRegistry().addOrUpdateDevice(newDevice);

        // update UI
        context.getMainFrame().refreshDeviceList();

        /// create and send the discoveryReply Packet to the new device to acknowledge
        /// with our information
        DiscoveryReplyPacket drPkt = new DiscoveryReplyPacket(context.getDeviceInfo().getDeviceId(),
                context.getDeviceInfo().getDeviceName(), context.getDeviceInfo().getTcpPort());

        context.sendUDPPacket(drPkt, packet.getAddress());
    }

    private void handleDiscoveryReply(DatagramPacket packet, Packet pkt) {
        // Packet is from other device
        // he sent this to acknowledge our discovery packet.
        System.out.println("UDPListner: DiscoveryReply Packet Received from " + pkt.getDeviceName() + "["
                + packet.getAddress() + "]");

        /// add the new device to our registry
        DeviceInfo newDevice = new DeviceInfo(pkt.getDeviceName(), pkt.getDeviceId(), packet.getAddress(),
                pkt.getTcpPort(), Instant.now(), DeviceStatus.ONLINE);

        // update Registry
        context.getDeviceRegistry().addOrUpdateDevice(newDevice);

        // update UI
        context.getMainFrame().refreshDeviceList();
    }

    private void handleHeartBeat(DatagramPacket packet, Packet pkt) {
        System.out.println(
                "UDPListner: HeartBeat Packet Received from " + pkt.getDeviceName() + "[" + packet.getAddress() + "]");

        // update the device if present or add the device to our registry if new device
        DeviceInfo device = new DeviceInfo(
                pkt.getDeviceName(),
                pkt.getDeviceId(),
                packet.getAddress(),
                pkt.getTcpPort(),
                Instant.now(),
                DeviceStatus.ONLINE);

        context.getDeviceRegistry().addOrUpdateDevice(device);

        // update UI
        context.getMainFrame().refreshDeviceList();
    }

    private void handleGoodBye(DatagramPacket packet, Packet pkt) {
        System.out.println(
                "UDPListner: GoodBye Packet Received from " + pkt.getDeviceName() + "[" + packet.getAddress() + "]");

        /// remove the device from our registry
        context.getDeviceRegistry().removeDevice(pkt.getDeviceId());

        // update UI
        context.getMainFrame().refreshDeviceList();
    }

    private void processPacket(DatagramPacket packet) {
        Packet pkt = null;
        byte data[] = Arrays.copyOf(packet.getData(), packet.getLength());

        try {
            pkt = PacketSerializer.deserialize(data, Packet.class);
        } catch (Exception e) {
            System.out.println("UDPListener: Error in processPacket()");
            e.printStackTrace();
        }

        // ignore packets sent by us
        if (pkt.getDeviceId().equals(context.getDeviceInfo().getDeviceId())) {
            return;
        }

        switch (pkt.getPacketType()) {
            case DISCOVERY -> // other device sent a discovery packet.
                handleDiscovery(packet, pkt);

            case DISCOVERY_REPLY -> // other device sent a discovery reply for our discorvery packet
                handleDiscoveryReply(packet, pkt);

            case HEART_BEAT -> // other device sent a heartbeat.
                handleHeartBeat(packet, pkt);

            case GOODBYE -> // other device left
                handleGoodBye(packet, pkt);

            default -> throw new AssertionError();
        }
    }

    @Override
    public void run() {
        System.out.println("UDPListner: Thread Started!");

        DatagramPacket packet;
        byte[] buffer = new byte[Constants.BUFFER_SIZE];

        while (!Thread.currentThread().isInterrupted()) {
            packet = new DatagramPacket(buffer, buffer.length);
            try {
                listenerSocket.receive(packet); // listen for incomming packets from other devices
                processPacket(packet);
            } catch (IOException e) {
                System.out.println("UDPListener: Error in run()");
                e.printStackTrace();
            }
        }
    }

}
