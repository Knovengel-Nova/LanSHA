package com.amasp.lansha.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 *
 * @author knovengel
 */
public class NetworkUtil {

    public static InetAddress getBroadcastAddress() {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) {

                NetworkInterface networkInterface = interfaces.nextElement();

                if (!networkInterface.isUp()
                        || networkInterface.isLoopback()
                        || networkInterface.isVirtual()) {
                    continue;
                }

                for (InterfaceAddress address : networkInterface.getInterfaceAddresses()) {

                    InetAddress broadcast = address.getBroadcast();

                    if (broadcast != null) {
                        return broadcast;
                    }
                }
            }

        } catch (SocketException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static InetAddress getLocalAddress() {

        try {

            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) {

                NetworkInterface ni = interfaces.nextElement();

                if (!ni.isUp()
                        || ni.isLoopback()
                        || ni.isVirtual()) {
                    continue;
                }

                for (InterfaceAddress ia : ni.getInterfaceAddresses()) {

                    InetAddress address = ia.getAddress();

                    if (address instanceof Inet4Address) {
                        return address;
                    }
                }
            }

        } catch (SocketException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String getHostName() {

        try {
            return InetAddress
                    .getLocalHost()
                    .getHostName();
        } catch (Exception e) {
            return "Unknown Device";
        }
    }
}
