package com.amasp.lansha.network;

import com.amasp.lansha.device.DeviceInfo;
import com.amasp.lansha.protocol.udp.HeartBeatPacket;
import com.amasp.lansha.util.Constants;
import com.amasp.lansha.util.LanSHAContext;
import com.amasp.lansha.util.NetworkUtil;
import java.net.InetAddress;

/**
 *
 * @author knovengel
 */
///
/// This will be a Always running thread.
/// Sends a heartbeat every fixed interval to check for online devices.
///
public class HeartBeatSender implements Runnable {

    private LanSHAContext context;
    private HeartBeatPacket packet;
    private long interval = 15000;
    private DeviceInfo self;
    private final InetAddress broadcastAddress;

    private void sendBeat() {
        packet = new HeartBeatPacket(self.getDeviceUID(), self.getDeviceName(), self.getTcpPort());
        context.sendUDPPacket(packet, broadcastAddress);
        System.out.println("HeartBeatSender: HeartBeat Packet Sent on " + broadcastAddress);
    }

    private void startBeats() {
        while (!Thread.currentThread().isInterrupted()) {
            // send a heartbeat
            sendBeat();
            try {
                Thread.sleep(interval); // wait for some time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }

        }
    }

    public HeartBeatSender(LanSHAContext context) {
        this.context = context;
        this.self = context.getDeviceInfo();
        this.interval = 60000L / Constants.HEARTBEAT_BPM;
        this.broadcastAddress = NetworkUtil.getBroadcastAddress();
    }

    @Override
    public void run() {
        System.out.println("HeartBeatSender: Thread Started!");
        startBeats();
    }
}
