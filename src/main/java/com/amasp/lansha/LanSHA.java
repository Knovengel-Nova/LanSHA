package com.amasp.lansha;

import com.amasp.lansha.device.DeviceInfo;
import com.amasp.lansha.device.DeviceRegistry;
import com.amasp.lansha.device.DeviceStatus;
import com.amasp.lansha.network.DiscoveryService;
import com.amasp.lansha.network.HeartBeatSender;
import com.amasp.lansha.network.UDPListener;
import com.amasp.lansha.util.Constants;
import com.amasp.lansha.util.LanSHAContext;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Instant;
import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author knovengel
 */

///
/// LanSHA will be the main class and the entry point of the overall Application
///
/// Responsibilities:
///     1.  Start UI
///     2.  Start Network Services
///     3.  Initialize Registries
///     4.  Initialize Transfer Manager
///

public class LanSHA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter device Name: ");
        String devName = sc.nextLine();
        
        DeviceInfo selfInfo = null;
        DeviceRegistry registry = new DeviceRegistry();
        
        try{
            selfInfo = new DeviceInfo(devName, UUID.randomUUID(), InetAddress.getLocalHost(), Constants.TCP_PORT, Instant.now(), DeviceStatus.ONLINE);
        }catch(UnknownHostException e){
            System.out.println("Error in selfInfo");
            e.printStackTrace();
        }
        
        
        
        LanSHAContext context = new LanSHAContext(selfInfo, registry);
        
        
        /// start UDPListener Thread
        UDPListener udpListner = new UDPListener(context);
        new Thread(udpListner).start();
        
        /// Start DiscoveryService (send a discovery packet)
        DiscoveryService discoveryService = new DiscoveryService(context);        
        discoveryService.broadcastDiscovery();
        
        HeartBeatSender heartBeatSender = new HeartBeatSender(context);
        new Thread(heartBeatSender).start();
        
        
        System.out.println("Hello World!");
    }
}
