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
// Always running thread listening for incomming TCP requests.
// send them to ConnectionHandler
// Acts as a server
public class TCPAcceptor implements Runnable {

    private final LanSHAContext context;
    private ServerSocket serverSocket;

    // all args constructor
    public TCPAcceptor(LanSHAContext context) {
        this.context = context;
        try {
            serverSocket = new ServerSocket(Constants.TCP_PORT);
        } catch (IOException e) {
            context.print("TCPAcceptor: Error in constructor()");
            e.printStackTrace();
        }
    }

    public void shutDown() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            context.print("TCPAcceptor: Error in shutDown()");
            e.printStackTrace();
        }

        // close the connectionpool
        context.getConnectionPool().shutdownNow();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket socket = serverSocket.accept();
                context.getConnectionPool().submit(new ConnectionHandler(context, socket));
                context.print("TCPAcceptor: "+socket.getInetAddress()+" Connected");
            } catch (IOException e) {
                if (serverSocket.isClosed()) {
                    break;
                }
                context.print("TCPAcceptor: Error in run()");
                e.printStackTrace();
            }
        }
    }

}
