package com.amasp.lansha.network;

import com.amasp.lansha.device.DeviceInfo;
import com.amasp.lansha.device.DeviceStatus;
import com.amasp.lansha.protocol.udp.DiscoveryReplyPacket;
import com.amasp.lansha.protocol.Packet;
import com.amasp.lansha.protocol.PacketSerializer;
import com.amasp.lansha.util.Constants;
import com.amasp.lansha.util.LanSHAContext;
import com.amasp.lansha.util.NetworkUtil;
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
/// Only Listens for UDP Packets on port 60704
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

    private void handleDiscovery(DatagramPacket packet, Packet pkt) {
        System.out.println(
                "UDPListner: Discovery Packet Received from " + pkt.getDeviceName() + "[" + packet.getAddress() + "]");

        /// add the device to our registry
        DeviceInfo newDevice = new DeviceInfo(pkt.getDeviceName(), pkt.getDeviceUID(), packet.getAddress(),
                pkt.getTcpPort(), Instant.now(), DeviceStatus.ONLINE);
        context.getDeviceRegistry().addOrUpdateDevice(newDevice);

        /// create and send the discoveryReply Packet to the new device
        DiscoveryReplyPacket drPkt = new DiscoveryReplyPacket(context.getDeviceInfo().getDeviceUID(),
                context.getDeviceInfo().getDeviceName(), context.getDeviceInfo().getTcpPort());

        context.sendUDPPacket(drPkt, packet.getAddress());
    }

    private void handleDiscoveryReply(DatagramPacket packet, Packet pkt) {
        System.out.println("UDPListner: DiscoveryReply Packet Received from " + pkt.getDeviceName() + "["
                + packet.getAddress() + "]");

        /// add the new device to our registry
        DeviceInfo newDevice = new DeviceInfo(pkt.getDeviceName(), pkt.getDeviceUID(), packet.getAddress(),
                pkt.getTcpPort(), Instant.now(), DeviceStatus.ONLINE);
        context.getDeviceRegistry().addOrUpdateDevice(newDevice);
    }

    private void handleHeartBeat(DatagramPacket packet, Packet pkt) {
        System.out.println(
                "UDPListner: HeartBeat Packet Received from " + pkt.getDeviceName() + "[" + packet.getAddress() + "]");

        /// if the device is present in our registry update its last seen to current
        /// time
        DeviceInfo oldDevice = context.getDeviceRegistry().getDevice(pkt.getDeviceUID());
        if (oldDevice != null) {
            oldDevice.setLastSeen(Instant.now());
        }
    }

    private void handleGoodBye(DatagramPacket packet, Packet pkt) {
        System.out.println(
                "UDPListner: GoodBye Packet Received from " + pkt.getDeviceName() + "[" + packet.getAddress() + "]");

        /// remove the device from our registry
        context.getDeviceRegistry().removeDevice(pkt.getDeviceUID());
    }

    private void processPacket(DatagramPacket packet) {
        Packet pkt = null;
        byte data[] = Arrays.copyOf(packet.getData(), packet.getLength());

        try {
            pkt = PacketSerializer.deserialize(data, Packet.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // ignore packets sent by us
        if (pkt == null || pkt.getDeviceName().equals(NetworkUtil.getHostName())) {
            return;
        }

        switch (pkt.getPacketType()) {
            case DISCOVERY:
                /// 1 device sent a discover packet.
                handleDiscovery(packet, pkt);
                break;

            case DISCOVERY_REPLY:
                /// a device sent a discovery reply packet
                handleDiscoveryReply(packet, pkt);
                break;

            case HEART_BEAT:
                /// a device is alive.
                handleHeartBeat(packet, pkt);
                break;

            case GOODBYE:
                /// a device left
                handleGoodBye(packet, pkt);
                break;

            default:
                throw new AssertionError();
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
                listenerSocket.receive(packet);
                processPacket(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
