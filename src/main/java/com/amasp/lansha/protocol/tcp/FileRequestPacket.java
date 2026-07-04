package com.amasp.lansha.protocol.tcp;

import com.amasp.lansha.protocol.Packet;
import com.amasp.lansha.protocol.PacketType;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;
import javax.imageio.ImageIO;

/**
 *
 * @author knovengel
 */
public class FileRequestPacket extends Packet {

    private String fileName;
    private long fileSize;
    private UUID transferId;
//    private BufferedImage preview;
    private byte[] preview;

    // no args constructor
    public FileRequestPacket() {
        super();
        packetType = PacketType.FILE_REQUEST;
    }

    // all args constructor
    public FileRequestPacket(UUID transferId, UUID deviceUID, String deviceName, int tcpPort, String fileName,
            long fileSize) {
        super(PacketType.FILE_REQUEST, deviceUID, deviceName, tcpPort);
        this.transferId = transferId;
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    public void setPreview(BufferedImage img) {

        if (img == null) {
            preview = null;
            return;
        }

        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ImageIO.write(img, "png", out);
            preview = out.toByteArray();
        } catch (IOException e) {
            preview = null;
        }
    }

    public byte[] getPreview() {
        return preview;
    }

    // getters and setters
    public UUID getTransferId() {
        return transferId;
    }

    public String getFileName() {
        return fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setTransferId(UUID transferId) {
        this.transferId = transferId;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

}
