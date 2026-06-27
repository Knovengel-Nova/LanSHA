package com.amasp.lansha.network;

import com.amasp.lansha.network.transfer.TransferManager;
import com.amasp.lansha.protocol.Packet;
import com.amasp.lansha.protocol.PacketSerializer;
import com.amasp.lansha.util.LanSHAContext;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author knovengel
 */
public class ConnectionHandler implements Runnable {

    private final LanSHAContext context;
    private Socket socket; // other device socket

    private TransferManager transferManager;// will manage all transfers with the 1 other connected device (socket)

    private DataInputStream in;
    private DataOutputStream out;

    private volatile boolean running = true;

    // all args constructor
    public ConnectionHandler(LanSHAContext context, Socket socket) throws IOException {
        this.context = context;
        this.socket = socket;
        this.transferManager = context.getTransferManager();

        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
    }

    public synchronized void send(Packet packet) {

        try {

            byte[] data = PacketSerializer.serialize(packet);

            out.writeInt(data.length);

            out.write(data);

            out.flush();

        } catch (IOException e) {
            System.out.println("ConnectionHandler: Error in send()");
            close();

        } catch (Exception e) {
            System.out.println("ConnectionHandler: Error in send()");
            e.printStackTrace();

        }

    }

    // release all resources
    private void close() {
        if (!running) {
            return;
        }

        running = false;

        try {
            in.close();
        } catch (IOException ignored) {
        }

        try {
            out.close();
        } catch (IOException ignored) {
        }

        try {
            socket.close();
        } catch (IOException ignored) {
        }
    }

    // getter
    public LanSHAContext getContext() {
        return context;
    }

    @Override
    public void run() {
        while (running) {
            try {
                int size = in.readInt(); // get the size of incomming buffer
                byte data[] = in.readNBytes(size);// read the buffer
                transferManager.processPacket(data, this);// process the packet

            } catch (Exception e) {
                System.out.println("ConnectionHandler: Error in run()");
                close();
            }
        }
    }

}
