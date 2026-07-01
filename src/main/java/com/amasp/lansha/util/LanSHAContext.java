package com.amasp.lansha.util;

import com.amasp.lansha.device.DeviceInfo;
import com.amasp.lansha.device.DeviceRegistry;
import com.amasp.lansha.network.transfer.TransferManager;
import com.amasp.lansha.protocol.Packet;
import com.amasp.lansha.protocol.PacketSerializer;
import com.amasp.lansha.ui.Console;
import com.amasp.lansha.ui.UIFrame;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author knovengel
 */
public class LanSHAContext {

    private final DeviceInfo selfInfo;
    private final DeviceRegistry registry;
    private final ExecutorService connectionPool;
    private TransferManager transferManager;
    private Console console;
    private UIFrame mainFrame;
    private DatagramSocket udpSenderSocket = null;

    // all args constructor
    public LanSHAContext(DeviceInfo info, DeviceRegistry reg) {
        this.selfInfo = info;
        this.registry = reg;
        this.connectionPool = Executors.newCachedThreadPool();
        this.transferManager = new TransferManager(this);
        this.console = new Console();
        console.setVisible(true);

        try {
            udpSenderSocket = new DatagramSocket();
        } catch (SocketException e) {
            print("LanSHAContext: Error in counstructor()");
            e.printStackTrace();
        }
    }

    public void print(String message) {
        System.out.println(message);
        console.appendMessage(message);
    }

    // send a packet to other device from our device's one UDP sending socket
    public void sendUDPPacket(Packet packet, InetAddress destinationAddress) {
        try {
            byte data[] = PacketSerializer.serialize(packet);
            DatagramPacket pkt = new DatagramPacket(data, data.length, destinationAddress, Constants.UDP_PORT);
            udpSenderSocket.send(pkt);
        } catch (Exception e) {
            print("LanSHAContext: Error in sendUDPPacket");
            e.printStackTrace();
        }
    }

    // getters and setters
    public UIFrame getMainFrame() {
        return mainFrame;
    }

    public DeviceInfo getDeviceInfo() {
        return selfInfo;
    }

    public TransferManager getTransferManager() {
        return transferManager;
    }

    public DeviceRegistry getDeviceRegistry() {
        return registry;
    }

    public ExecutorService getConnectionPool() {
        return connectionPool;
    }

    public void setMainFrame(UIFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

}
