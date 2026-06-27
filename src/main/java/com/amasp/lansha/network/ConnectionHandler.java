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

    private LanSHAContext context;
    private Socket socket; // other device socket

    private TransferManager transferManager;

    private DataInputStream in;
    private DataOutputStream out;

    private volatile boolean running = true;

    public ConnectionHandler(LanSHAContext context, Socket socket) throws IOException {
        this.context = context;
        this.socket = socket;
        this.transferManager = context.getTransferManager();

        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
    }

    public LanSHAContext getContext() {
        return context;
    }

    public synchronized void send(Packet packet) {

        try {

            byte[] data = PacketSerializer.serialize(packet);

            out.writeInt(data.length);

            out.write(data);

            out.flush();

        } catch (IOException e) {

            close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

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

    @Override
    public void run() {
        while (running) {
            try {
                int size = in.readInt();
                byte data[] = in.readNBytes(size);
                transferManager.processPacket(data, this);

            } catch (Exception e) {
                close();
            }
        }
    }

}
