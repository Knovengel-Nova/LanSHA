package com.amasp.lansha.network.transfer;

import com.amasp.lansha.network.ConnectionHandler;
import java.io.IOException;
import java.nio.file.Files;
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
    
    private String mime;

    private long fileSize;

    private long bytesTransferred;

    private ConnectionHandler handler;

    private TransferReceiver receiver;

    private TransferSender sender;

    private boolean senderTransfer;

    private long transferStartTime;

    private long lastSpeedBytes;
    private long lastSpeedTime;

    private double currentSpeed;

    // all args constructor
    public TransferSession(UUID transferId, String fileName, UUID remoteDevice, String remoteDeviceName, long fileSize, long bytesTransferred,
            TransferState state, ConnectionHandler handler) {
        this.transferId = transferId;
        this.fileName = fileName;
        this.remoteDevice = remoteDevice; // other device
        this.remoteDeviceName = remoteDeviceName;
        this.fileSize = fileSize;
        this.bytesTransferred = bytesTransferred;
        this.state = state;
        this.handler = handler;
        try{
            this.mime = Files.probeContentType(sourceFile);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void startTransferTimer() {
        transferStartTime = System.currentTimeMillis();
        lastSpeedTime = transferStartTime;
        lastSpeedBytes = bytesTransferred;
    }

    public String getFormattedSpeed() {

        long now = System.currentTimeMillis();

        if (now - lastSpeedTime >= 1000) {

            long deltaBytes = bytesTransferred - lastSpeedBytes;
            long deltaTime = now - lastSpeedTime;

            currentSpeed = deltaBytes / (deltaTime / 1000.0);

            lastSpeedBytes = bytesTransferred;
            lastSpeedTime = now;
        }

        double speed = currentSpeed;

        String[] units = {"B/s", "KB/s", "MB/s", "GB/s"};

        int i = 0;

        while (speed >= 1024 && i < units.length - 1) {
            speed /= 1024;
            i++;
        }

        return String.format("%.1f %s", speed, units[i]);
    }

    public String getFormattedETA() {

        if (currentSpeed <= 0) {
            return "--:--";
        }

        long remaining = fileSize - bytesTransferred;

        long seconds = (long) (remaining / currentSpeed);

        long h = seconds / 3600;
        long m = (seconds % 3600) / 60;
        long s = seconds % 60;

        if (h > 0) {
            return String.format("%02d:%02d:%02d", h, m, s);
        }

        return String.format("%02d:%02d", m, s);
    }

    public boolean isSender() {
        return senderTransfer;
    }

    public void setSender(boolean senderTransfer) {
        this.senderTransfer = senderTransfer;
    }

    // getters and setters
    public String getRemoteDeviceName() {
        return remoteDeviceName;
    }

    public Path getSourceFile() {
        return sourceFile;
    }
    
    public String getMime(){
        return mime;
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

        if (state == TransferState.TRANSFERRING) {
            startTransferTimer();
        }

        if (state == TransferState.COMPLETED) {
            bytesTransferred = fileSize;
        }
    }

    public void setHandler(ConnectionHandler handler) {
        this.handler = handler;
    }

}
