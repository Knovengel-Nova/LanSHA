package com.amasp.lansha.network;

import com.amasp.lansha.protocol.DiscoveryPacket;
import com.amasp.lansha.util.LanSHAContext;
import com.amasp.lansha.util.NetworkUtil;

/**
 *
 * @author knovengel
 */
public class DiscoveryService {
    private LanSHAContext context;
    
    public DiscoveryService(LanSHAContext context){
        this.context = context;
    }
    
    public void broadcastDiscovery(){
        // craft Discovery Packet and send it to everyone...
        DiscoveryPacket pkt = new DiscoveryPacket(context.getDeviceInfo().getDeviceUID(), context.getDeviceInfo().getDeviceName(), context.getDeviceInfo().getTcpPort());
        
        context.sendUDPPacket(pkt, NetworkUtil.getBroadcastAddress());    
        System.out.println("DiscoveryService: Discovery Packet Sent!");
    }
}
