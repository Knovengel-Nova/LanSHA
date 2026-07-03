package com.amasp.lansha.network.transfer;

import com.amasp.lansha.device.DeviceInfo;
import com.amasp.lansha.network.ConnectionHandler;
import com.amasp.lansha.protocol.PacketSerializer;
import com.amasp.lansha.protocol.PacketType;
import com.amasp.lansha.protocol.tcp.ConnectPacket;
import com.amasp.lansha.protocol.tcp.FileAcceptPacket;
import com.amasp.lansha.protocol.tcp.FileDataPacket;
import com.amasp.lansha.protocol.tcp.FileRejectPacket;
import com.amasp.lansha.protocol.tcp.FileRequestPacket;
import com.amasp.lansha.protocol.tcp.TransferCompletePacket;
import com.amasp.lansha.util.LanSHAContext;
import java.io.IOException;
import java.net.Socket;
import java.nio.file.Path;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.SwingUtilities;

/**
 *
 * @author knovengel
 */
public class TransferManager {

    LanSHAContext context;

    // all connected devices with us
    private final ConcurrentHashMap<UUID, ConnectionHandler> connections; // all active connection: <deviceId,
                                                                          // ConnectionHandler>
    // all transfers belonging to us and all connected devices
    private final ConcurrentHashMap<UUID, TransferSession> sessions; // all file transfers: <transferId,
                                                                     // TransferSession>

    // all args constructor
    public TransferManager(LanSHAContext context) {
        this.context = context;
        connections = new ConcurrentHashMap<>();
        sessions = new ConcurrentHashMap<>();
    }

    // process packet sent by other device, handler is our handler
    public void processPacket(byte data[], ConnectionHandler handler) {
        PacketType type = PacketSerializer.getPacketType(data);

        try {
            switch (type) {
                case CONNECT -> {
                    ConnectPacket cPacket = PacketSerializer.deserialize(data, ConnectPacket.class);
                    handleConnection(cPacket, handler);
                }

                case FILE_REQUEST -> {
                    FileRequestPacket fRPacket = PacketSerializer.deserialize(data, FileRequestPacket.class);
                    handleFileRequest(fRPacket, handler);
                }

                case FILE_ACCEPT -> {
                    FileAcceptPacket fAPacket = PacketSerializer.deserialize(data, FileAcceptPacket.class);
                    handleFileAccept(fAPacket, handler);
                }

                case FILE_REJECT -> {
                    FileRejectPacket fRJPacket = PacketSerializer.deserialize(data, FileRejectPacket.class);
                    handleFileReject(fRJPacket, handler);
                }

                case FILE_DATA -> {
                    FileDataPacket fDPacket = PacketSerializer.deserialize(data, FileDataPacket.class);
                    handleFileData(fDPacket, handler);
                }

                case TRANSFER_COMPLETE -> {
                    TransferCompletePacket tCPacket = PacketSerializer.deserialize(data, TransferCompletePacket.class);
                    handleTransferComplete(tCPacket, handler);
                }
                default -> {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // other device wants to connect with us, he sent us his ConnectionPacket to our
    // Handler
    private void handleConnection(ConnectPacket packet, ConnectionHandler handler) {
        connections.put(packet.getDeviceId(), handler);
        context.print("Device: " + packet.getDeviceName() + " connected.");
    }

    // other device wants to send us a file (sent his file request packet) on our
    // handler
    private void handleFileRequest(FileRequestPacket packet, ConnectionHandler handler) {
        // create a transfer session for this file
        TransferSession session = new TransferSession(
                packet.getTransferId(), // fixed transferId for a file
                packet.getFileName(), // file that he wants to send us
                packet.getDeviceId(), // his deviceId (remote device)
                packet.getDeviceName(),
                packet.getFileSize(), // file size in B
                0, // initially 0 Bs transferred
                TransferState.WAITING_FOR_RESPONSE, // currently he is waiting for approval
                handler);// our handler

        session.setAmISender(false);

        sessions.put(packet.getTransferId(), session);
        context.getMainFrame().addTransfer(session);

        // ask for our approval on UI
        SwingUtilities.invokeLater(() -> context.getMainFrame().showFileRequest(session));
        context.print(packet.getDeviceName() + "is Asking for file approval for <" + packet.getFileName() + ">("
                + packet.getFileSize() + "B)");
    }

    private void handleFileAccept(FileAcceptPacket packet, ConnectionHandler handler) {
        // other accepted the file transfer and now we want to begin transfer(sending)
        TransferSession session = sessions.get(packet.getTransferId());

        if (session == null) {
            return;
        }

        session.setState(TransferState.ACCEPTED);
        context.print("Transfer Accepted.");

        // begin transfer
        beginTransfer(packet.getTransferId());
    }

    private void handleFileReject(FileRejectPacket packet, ConnectionHandler handler) {
        // other rejected the file transfer
        TransferSession session = sessions.get(packet.getTransferId());

        if (session == null) {
            return;
        }

        session.setState(TransferState.REJECTED);
        context.print("Transfer Rejected.");
    }

    private void handleFileData(FileDataPacket packet, ConnectionHandler handler) {
        // we got a fileDataPacket and now we process this packet by making the
        // respective transfer session to receive this packet
        TransferSession session = sessions.get(packet.getTransferId());

        if (session == null) {
            return;
        }

        session.getReceiver().receive(packet);
    }

    private void handleTransferComplete(TransferCompletePacket packet, ConnectionHandler handler) {
        // the fileData transfer was complete and now we got the transfer complete
        // packet.
        TransferSession session = sessions.get(packet.getTransferId());

        if (session == null) {
            return;
        }

        session.setState(TransferState.COMPLETED);

        context.getMainFrame().updateTransfer(session);

        context.print("Transfer complete.");

        /// receive ACK then remove

        sessions.remove(packet.getTransferId());
    }

    // public APIs
    public void acceptTransfer(UUID transferId) {
        // we accept the transfer for a particular transferSession
        TransferSession session = sessions.get(transferId);

        if (session == null) {
            return;
        }
        session.setAmISender(false);
        try {
            session.setReceiver(new TransferReceiver(context, session));// set the receiver for this transferSession
        } catch (IOException e) {
            context.print("TransferManager: Error in acceptTransfer()");
            e.printStackTrace();
        }

        session.setState(TransferState.ACCEPTED);

        // send a fileAccept packet to other device who wants to transfer so that he can
        // begin trnsfer
        FileAcceptPacket packet = new FileAcceptPacket(transferId, context.getDeviceInfo().getDeviceId(),
                context.getDeviceInfo().getDeviceName(), context.getDeviceInfo().getTcpPort());

        session.getHandler().send(packet);
    }

    public void rejectTransfer(UUID transferId) {
        // we rejected the transfer from other device
        TransferSession session = sessions.get(transferId);

        if (session == null) {
            return;
        }

        session.setState(TransferState.REJECTED);

        // send a fileReject packet to the sender to let him know that we rejected his
        // transfer request
        FileRejectPacket packet = new FileRejectPacket(transferId, context.getDeviceInfo().getDeviceId(),
                context.getDeviceInfo().getDeviceName(), context.getDeviceInfo().getTcpPort());

        session.getHandler().send(packet);

        sessions.remove(transferId);
    }

    public void beginTransfer(UUID transferId) {

        TransferSession session = sessions.get(transferId);

        if (session == null) {
            return;
        }

        session.setState(TransferState.TRANSFERRING);
        session.setAmISender(true);

        TransferSender sender = new TransferSender(context, session);
        session.setSender(sender);
        new Thread(sender).start();
    }

    // actually this is just crafting a filerequest packet and then sending it to
    // the remote device
    public void sendFile(DeviceInfo remoteDevice, Path sourceFile) {
        // we want to send a local file to the remote (other/server) connected device
        // if not connected to him, connect to the remotedevices' socket
        try {
            ConnectionHandler handler = connections.get(remoteDevice.getDeviceId()); // our handler associated(his
                                                                                     // socket) to him

            if (handler == null) {
                Socket socket = new Socket(remoteDevice.getIpAddress(), remoteDevice.getTcpPort());

                handler = new ConnectionHandler(context, socket);

                context.getConnectionPool().submit(handler);

                ConnectPacket packet = new ConnectPacket(context.getDeviceInfo().getDeviceId(),
                        context.getDeviceInfo().getDeviceName(), context.getDeviceInfo().getTcpPort());

                handler.send(packet);

                connections.put(remoteDevice.getDeviceId(), handler);
            }

            // make a transfer session

            UUID transferId = UUID.randomUUID(); // generate a unique uid for our transfer

            TransferSession session = new TransferSession(
                    transferId,
                    sourceFile.getFileName().toString(),
                    remoteDevice.getDeviceId(),
                    remoteDevice.getDeviceName(),
                    sourceFile.toFile().length(),
                    0,
                    TransferState.WAITING_FOR_RESPONSE,
                    handler);

            session.setSourcePath(sourceFile);
            sessions.put(transferId, session);
            context.getMainFrame().addTransfer(session);

            // send a filerequest packet to him first
            FileRequestPacket requestPacket = new FileRequestPacket(
                    transferId,
                    context.getDeviceInfo().getDeviceId(),
                    context.getDeviceInfo().getDeviceName(),
                    context.getDeviceInfo().getTcpPort(),
                    sourceFile.getFileName().toString(),
                    sourceFile.toFile().length());

            handler.send(requestPacket);
        } catch (IOException e) {
            context.print("TransferManager: Error in sendFile()");
            e.printStackTrace();
        }
    }

    public void cancelTransfer(UUID transferId) {
        // we cancelled the transfer
        TransferSession session = sessions.remove(transferId);

        if (session == null) {
            return;
        }

        session.setState(TransferState.CANCELLED);

        context.print("Transfer Cancelled.");
    }

    public void pauseTransfer(UUID transferId) {
        // we cancelled the transfer
        TransferSession session = sessions.get(transferId);

        if (session == null) {
            return;
        }

        session.setState(TransferState.PAUSED);

        context.print("Transfer Cancelled.");
    }
}
