package com.amasp.lansha.util;

import com.amasp.lansha.device.DeviceInfo;
import com.amasp.lansha.device.DeviceRegistry;
import com.amasp.lansha.protocol.Packet;
import com.amasp.lansha.protocol.PacketSerializer;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author knovengel
 */
public class LanSHAContext {

    private final DeviceInfo selfInfo;
    private final DeviceRegistry registry;

    private DatagramSocket udpSenderSocket = null;
    
    public void sendUDPPacket(Packet packet, InetAddress destinationAddress){
        try{
            byte data[] = PacketSerializer.serialize(packet);
            DatagramPacket pkt = new DatagramPacket(data, data.length, destinationAddress, Constants.UDP_PORT);
            udpSenderSocket.send(pkt);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public DeviceInfo getDeviceInfo() {
        return selfInfo;
    }

    public DeviceRegistry getDeviceRegistry() {
        return registry;
    }

    public LanSHAContext(DeviceInfo info, DeviceRegistry reg) {
        this.selfInfo = info;
        this.registry = reg;

        try {
            udpSenderSocket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
