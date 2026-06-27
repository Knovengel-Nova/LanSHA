package com.amasp.lansha.network.transfer;

import com.amasp.lansha.network.ConnectionHandler;
import java.nio.file.Path;
import java.util.UUID;

/**
 *
 * @author knovengel
 */
public class TransferSession {

    private UUID transferId;

    private UUID remoteDevice;

    private TransferState state;

    private Path sourceFile;

    private Path destinationFile;

    private String fileName;

    private long fileSize;

    private long bytesTransferred;

    private ConnectionHandler handler;

    private TransferReceiver receiver;

    private TransferSender sender;

    public TransferSession(UUID transferId, String fileName, UUID remoteDevice, long fileSize, long bytesTransferred,
            TransferState state, ConnectionHandler handler) {
        this.transferId = transferId;
        this.fileName = fileName;
        this.remoteDevice = remoteDevice;
        this.fileSize = fileSize;
        this.bytesTransferred = bytesTransferred;
        this.state = state;
        this.handler = handler;
    }

    public void setSourcePath(Path path) {
        this.sourceFile = path;
    }

    public void setDestinationPath(Path path) {
        this.destinationFile = path;
    }

    public Path getSourceFile() {
        return sourceFile;
    }

    public Path getDestinationFile() {
        return destinationFile;
    }

    public void setReceiver(TransferReceiver rec) {
        this.receiver = rec;
    }

    public void setSender(TransferSender sender) {
        this.sender = sender;
    }

    public TransferReceiver getReceiver() {
        return receiver;
    }

    public TransferSender getSender() {
        return sender;
    }

    public TransferSession() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public TransferSession(UUID transferId, UUID remoteDevice, TransferState state, ConnectionHandler handler) {
        this.transferId = transferId;
        this.remoteDevice = remoteDevice;
        this.state = state;
        this.handler = handler;
    }

    public UUID getTransferId() {
        return transferId;
    }

    public UUID getRemoteDevice() {
        return remoteDevice;
    }

    public long getFileSize() {
        return fileSize;
    }

    public long getBytesTransferred() {
        return bytesTransferred;
    }

    public TransferState getState() {
        return state;
    }

    public ConnectionHandler getHandler() {
        return handler;
    }

    public void setTransferId(UUID transferId) {
        this.transferId = transferId;
    }

    public void setRemoteDevice(UUID remoteDevice) {
        this.remoteDevice = remoteDevice;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public void setBytesTransferred(long bytesTransferred) {
        this.bytesTransferred = bytesTransferred;
    }

    public void setState(TransferState state) {
        this.state = state;
    }

    public void setHandler(ConnectionHandler handler) {
        this.handler = handler;
    }

}
