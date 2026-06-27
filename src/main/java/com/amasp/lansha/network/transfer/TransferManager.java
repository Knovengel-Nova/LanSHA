package com.amasp.lansha.network.transfer;

import com.amasp.lansha.device.DeviceInfo;
import com.amasp.lansha.network.ConnectionHandler;
import com.amasp.lansha.protocol.tcp.ConnectPacket;
import com.amasp.lansha.protocol.tcp.FileAcceptPacket;
import com.amasp.lansha.protocol.tcp.FileDataPacket;
import com.amasp.lansha.protocol.tcp.FileRejectPacket;
import com.amasp.lansha.protocol.tcp.FileRequestPacket;
import com.amasp.lansha.protocol.PacketSerializer;
import com.amasp.lansha.protocol.PacketType;
import com.amasp.lansha.protocol.tcp.TransferCompletePacket;
import com.amasp.lansha.util.LanSHAContext;

import java.io.File;
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

    private final ConcurrentHashMap<UUID, ConnectionHandler> connections; // all active connection: <deviceUID,
                                                                          // ConnectionHandler>
    private final ConcurrentHashMap<UUID, TransferSession> sessions; // all file transfers: <transferUID,
                                                                     // TransferSession>

    public TransferManager(LanSHAContext context) {
        this.context = context;
        connections = new ConcurrentHashMap<>();
        sessions = new ConcurrentHashMap<>();
    }

    public void processPacket(byte data[], ConnectionHandler handler) {
        PacketType type = PacketSerializer.getPacketType(data);
        try {
            switch (type) {
                case CONNECT:
                    ConnectPacket cPacket = PacketSerializer.deserialize(data, ConnectPacket.class);
                    handleConnection(cPacket, handler);
                    break;

                case FILE_REQUEST:
                    FileRequestPacket fRPacket = PacketSerializer.deserialize(data, FileRequestPacket.class);
                    handleFileRequest(fRPacket, handler);
                    break;

                case FILE_ACCEPT:
                    FileAcceptPacket fAPacket = PacketSerializer.deserialize(data, FileAcceptPacket.class);
                    handleFileAccept(fAPacket, handler);
                    break;

                case FILE_REJECT:
                    FileRejectPacket fRJPacket = PacketSerializer.deserialize(data, FileRejectPacket.class);
                    handleFileReject(fRJPacket, handler);
                    break;

                case FILE_DATA:
                    FileDataPacket fDPacket = PacketSerializer.deserialize(data, FileDataPacket.class);
                    handleFileData(fDPacket, handler);
                    break;

                case TRANSFER_COMPLETE:
                    TransferCompletePacket tCPacket = PacketSerializer.deserialize(data, TransferCompletePacket.class);
                    handleTransferComplete(tCPacket, handler);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleConnection(ConnectPacket packet, ConnectionHandler handler) {
        connections.put(packet.getDeviceUID(), handler);
        context.getConsole().printMsg("Device: " + packet.getDeviceName() + " connected.");
    }

    private void handleFileRequest(FileRequestPacket packet, ConnectionHandler handler) {
        TransferSession session = new TransferSession(
                packet.getTransferId(),
                packet.getFileName(),
                packet.getDeviceUID(),
                packet.getFileSize(),
                0,
                TransferState.WAITING_FOR_RESPONSE,
                handler);

        sessions.put(packet.getTransferId(), session);

        SwingUtilities.invokeLater(() -> context.getMainFrame().showFileRequest(session));
    }

    private void handleFileAccept(FileAcceptPacket packet, ConnectionHandler handler) {
        TransferSession session = sessions.get(packet.getTransferId());

        if (session == null) {
            return;
        }

        session.setState(TransferState.ACCEPTED);
        context.getConsole().printMsg("Transfer Accepted.");

        beginTransfer(packet.getTransferId());
    }

    private void handleFileReject(FileRejectPacket packet, ConnectionHandler handler) {
        TransferSession session = sessions.get(packet.getTransferId());

        if (session == null) {
            return;
        }

        session.setState(TransferState.REJECTED);

        context.getConsole().printMsg("Transfer Rejected.");
    }

    private void handleFileData(FileDataPacket packet, ConnectionHandler handler) {
        TransferSession session = sessions.get(packet.getTransferId());

        if (session == null) {
            return;
        }

        session.getReceiver().receive(packet);
    }

    private void handleTransferComplete(TransferCompletePacket packet, ConnectionHandler handler) {
        TransferSession session = sessions.get(packet.getTransferId());

        if (session == null) {
            return;
        }

        session.setState(TransferState.COMPLETED);

        context.getConsole().printMsg("Transfer complete.");

        /// receive ACK then remove

        sessions.remove(packet.getTransferId());
    }

    public void acceptTransfer(UUID transferId) {
        TransferSession session = sessions.get(transferId);

        if (session == null) {
            return;
        }

        try{
            session.setReceiver(new TransferReceiver(session));
        }catch(IOException e){
            e.printStackTrace();
        }

        session.setState(TransferState.ACCEPTED);

        FileAcceptPacket packet = new FileAcceptPacket(transferId, context.getDeviceInfo().getDeviceUID(),
                context.getDeviceInfo().getDeviceName(), context.getDeviceInfo().getTcpPort());

        session.getHandler().send(packet);
    }

    public void rejectTransfer(UUID transferId) {
        TransferSession session = sessions.get(transferId);

        if (session == null) {
            return;
        }

        session.setState(TransferState.REJECTED);

        FileRejectPacket packet = new FileRejectPacket(transferId, context.getDeviceInfo().getDeviceUID(),
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

        TransferSender sender = new TransferSender(session);
        session.setSender(sender);
        new Thread(sender).start();
    }

    public void sendFile(DeviceInfo remoteDevice, Path sourceFile) {
        try {
            ConnectionHandler handler = connections.get(remoteDevice.getDeviceUID());

            if (handler == null) {
                Socket socket = new Socket(remoteDevice.getIpAddress(), remoteDevice.getTcpPort());

                handler = new ConnectionHandler(context, socket);

                context.getConnectionPool().submit(handler);

                ConnectPacket packet = new ConnectPacket(context.getDeviceInfo().getDeviceUID(),
                        context.getDeviceInfo().getDeviceName(), context.getDeviceInfo().getTcpPort());

                handler.send(packet);

                connections.put(remoteDevice.getDeviceUID(), handler);
            }

            UUID transferId = UUID.randomUUID();

            TransferSession session = new TransferSession(
                    transferId,
                    sourceFile.getFileName().toString(),
                    remoteDevice.getDeviceUID(),
                    sourceFile.toFile().length(),
                    0,
                    TransferState.WAITING_FOR_RESPONSE,
                    handler);

            session.setSourcePath(sourceFile);
            sessions.put(transferId, session);

            FileRequestPacket requestPacket = new FileRequestPacket(
                    transferId,
                    context.getDeviceInfo().getDeviceUID(),
                    context.getDeviceInfo().getDeviceName(),
                    context.getDeviceInfo().getTcpPort(),
                    sourceFile.getFileName().toString(),
                    sourceFile.toFile().length());

            handler.send(requestPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cancelTransfer(UUID transferId) {
        TransferSession session = sessions.remove(transferId);

        if (session == null) {
            return;
        }

        session.setState(TransferState.CANCELLED);

        context.getConsole().printMsg("Transfer Cancelled.");
    }
}
