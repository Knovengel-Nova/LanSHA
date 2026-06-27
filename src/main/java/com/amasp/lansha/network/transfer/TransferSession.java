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

    private UUID remoteDevice; // other device

    private String remoteDeviceName; // other device name

    private TransferState state;

    private Path sourceFile; // file path if we are sending

    private Path destinationFile; // file path if we are receiving

    private String fileName;

    private long fileSize;

    private long bytesTransferred;

    private ConnectionHandler handler;

    private TransferReceiver receiver;

    private TransferSender sender;

    // all args constructor
    public TransferSession(UUID transferId, String fileName, UUID remoteDevice, long fileSize, long bytesTransferred,
            TransferState state, ConnectionHandler handler) {
        this.transferId = transferId;
        this.fileName = fileName;
        this.remoteDevice = remoteDevice; // other device
        this.fileSize = fileSize;
        this.bytesTransferred = bytesTransferred;
        this.state = state;
        this.handler = handler;
    }

    // getters and setters
    public String getRemoteDeviceName() {
        return remoteDeviceName;
    }

    public Path getSourceFile() {
        return sourceFile;
    }

    public Path getDestinationFile() {
        return destinationFile;
    }

    public TransferReceiver getReceiver() {
        return receiver;
    }

    public TransferSender getSender() {
        return sender;
    }

    public String getFileName() {
        return fileName;
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

    public void setRemoteDeviceName(String name) {
        this.remoteDeviceName = name;
    }

    public void setSourcePath(Path path) {
        this.sourceFile = path;
    }

    public void setDestinationPath(Path path) {
        this.destinationFile = path;
    }

    public void setReceiver(TransferReceiver rec) {
        this.receiver = rec;
    }

    public void setSender(TransferSender sender) {
        this.sender = sender;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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
