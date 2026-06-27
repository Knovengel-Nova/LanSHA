package com.amasp.lansha.network;

import com.amasp.lansha.protocol.udp.DiscoveryPacket;
import com.amasp.lansha.util.LanSHAContext;
import com.amasp.lansha.util.NetworkUtil;

/**
 *
 * @author knovengel
 */

///
/// send a discovery packet only once when we start the application for the
/// first time
public class DiscoveryService {
    private LanSHAContext context;

    // all args constructor
    public DiscoveryService(LanSHAContext context) {
        this.context = context;
    }

    public void broadcastDiscovery() {
        // craft Discovery Packet and send it to everyone...
        DiscoveryPacket pkt = new DiscoveryPacket(context.getDeviceInfo().getDeviceId(),
                context.getDeviceInfo().getDeviceName(), context.getDeviceInfo().getTcpPort());

        context.sendUDPPacket(pkt, NetworkUtil.getBroadcastAddress());
        System.out.println("DiscoveryService: Discovery Packet Sent!");
    }
}
