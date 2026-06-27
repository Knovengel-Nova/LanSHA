package com.amasp.lansha;

import com.amasp.lansha.device.DeviceInfo;
import com.amasp.lansha.device.DeviceRegistry;
import com.amasp.lansha.device.DeviceStatus;
import com.amasp.lansha.network.DiscoveryService;
import com.amasp.lansha.network.HeartBeatSender;
import com.amasp.lansha.network.Janitor;
import com.amasp.lansha.network.TCPAcceptor;
import com.amasp.lansha.network.UDPListener;
import com.amasp.lansha.ui.MainFrame;
import com.amasp.lansha.util.Constants;
import com.amasp.lansha.util.LanSHAContext;
import com.amasp.lansha.util.NetworkUtil;
import java.time.Instant;
import java.util.UUID;

/**
 *
 * @author knovengel
 */
///
/// LanSHA will be the main class and the entry point of the overall Application
///
/// Responsibilities:
/// 1. Start UI
/// 2. Start Network Services
/// 3. Initialize Registries
/// 4. Initialize Transfer Manager
///

public class LanSHA {

    public static void main(String[] args) {
        DeviceInfo selfInfo;
        DeviceRegistry registry = new DeviceRegistry();

        selfInfo = new DeviceInfo(NetworkUtil.getHostName(), UUID.randomUUID(), NetworkUtil.getLocalAddress(),
                Constants.TCP_PORT, Instant.now(), DeviceStatus.ONLINE);

        LanSHAContext context = new LanSHAContext(selfInfo, registry);

        MainFrame mf = new MainFrame(context);
        context.setMainFrame(mf);
        mf.setVisible(true);

        /// Start DiscoveryService (send a discovery packet)
        DiscoveryService discoveryService = new DiscoveryService(context);
        discoveryService.broadcastDiscovery();

        /// start UDPListener Thread
        UDPListener udpListner = new UDPListener(context);
        new Thread(udpListner).start();

        /// Start HeartBeat sender Thread
        HeartBeatSender heartBeatSender = new HeartBeatSender(context);
        new Thread(heartBeatSender).start();

        /// Start the Janitor Thread
        Janitor janitor = new Janitor(context);
        new Thread(janitor).start();

        // Start the TCP Acceptor Thread
        TCPAcceptor acceptorThread = new TCPAcceptor(context);
        new Thread(acceptorThread).start();

        System.out.println("LanSHA: Hello World!");

    }
}
