package com.amasp.lansha.network;

import com.amasp.lansha.device.DeviceInfo;
import com.amasp.lansha.device.DeviceRegistry;
import com.amasp.lansha.util.Constants;
import com.amasp.lansha.util.LanSHAContext;
import java.time.Instant;
import java.util.Collection;

/**
 *
 * @author knovengel
 */
public class Janitor implements Runnable {

    private LanSHAContext context;
    private final DeviceRegistry reg;

    // all args constructor
    public Janitor(LanSHAContext context) {
        this.reg = context.getDeviceRegistry();
        this.context = context;
    }

    private void scanAndClean() {
        // scan the entire registry and remove inactive devices
        boolean changed = false;

        System.out.println("Janitor: Scanning And Cleaning...");
        Instant cutoff = Instant.now().minusMillis(Constants.DEVICE_TIMEOUT);

        Collection<DeviceInfo> devs = reg.getAllDevices();

        for (DeviceInfo dev : devs) {
            if (dev.getLastSeen().isBefore(cutoff)) {
                reg.removeDevice(dev.getDeviceId());
                System.out.println("Janitor: Device " + dev + " removed due to inactivity");
                changed = true;
            }
        }
        if (changed == true) { // update UI if registry changed
            context.getMainFrame().refreshDeviceList();
        }
    }

    private void startCleaning() {
        while (!Thread.currentThread().isInterrupted()) {
            scanAndClean();

            try {
                Thread.sleep(Constants.DEVICE_CLEANING_INTERVAL);
            } catch (InterruptedException e) {
                System.out.println("Janitor: Error in startCleaning()");
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    @Override
    public void run() {
        System.out.println("Janitor: Thread Started!");
        startCleaning();
    }

}
