package com.amasp.lansha.network;

import com.amasp.lansha.util.Constants;
import com.amasp.lansha.util.LanSHAContext;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author knovengel
 */
public class TCPAcceptor implements Runnable {

    private final LanSHAContext context;
    private ServerSocket serverSocket;

    public TCPAcceptor(LanSHAContext context) {
        this.context = context;
        try {
            serverSocket = new ServerSocket(Constants.TCP_PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void shutDown() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        context.getConnectionPool().shutdownNow();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket socket = serverSocket.accept();
                context.getConnectionPool().submit(new ConnectionHandler(context, socket));
            } catch (IOException e) {
                if (serverSocket.isClosed()) {
                    break;
                }
                e.printStackTrace();
            }
        }
    }

}
