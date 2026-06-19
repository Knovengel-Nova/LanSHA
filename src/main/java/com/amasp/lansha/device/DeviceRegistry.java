package com.amasp.lansha.device;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author knovengel
 */
public class DeviceRegistry {
    private final ConcurrentHashMap<UUID, DeviceInfo> registry = new ConcurrentHashMap<>();
    
    public void addOrUpdateDevice(DeviceInfo device){
        registry.put(device.getDeviceUID(), device);
    }
    
    public void removeDevice(UUID deviceUID){
        registry.remove(deviceUID);
    }
    
    public DeviceInfo getDevice(UUID deviceUID){
        return registry.get(deviceUID);
    }
    
    public Collection<DeviceInfo> getAllDevices(){
        return registry.values();
    }
    
    public int size(){
        return registry.size();
    }
    
    public boolean containsDevice(UUID deviceUID){
        return registry.containsKey(deviceUID);
    }
}
