package com.amasp.lansha.network.transfer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import com.amasp.lansha.protocol.PacketType;
import com.amasp.lansha.protocol.tcp.FileDataPacket;
import com.amasp.lansha.protocol.tcp.TransferCompletePacket;
import com.amasp.lansha.util.Constants;

/**
 *
 * @author knovengel
 */

/// open a file
/// read 64KB
/// encrypt it
/// create filedatapacket
/// handler.send
/// repeat
/// send transfercompletepacket

public class TransferSender implements Runnable {

    private final TransferSession session;

    private volatile boolean cancelled = false;

    // all args constructor
    public TransferSender(TransferSession session) {
        this.session = session;
    }

    public void cancel() {
        cancelled = true;
    }

    @Override
    public void run() {
        byte buffer[] = new byte[Constants.CHUNK_SIZE];

        int bytesRead;
        int chunkNumber = 0;

        int totalChunks = (int) Math.ceil((double) session.getFileSize() / Constants.CHUNK_SIZE);

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(session.getSourceFile().toFile()))) {
            while (!cancelled && (bytesRead = in.read(buffer)) != -1) {
                byte[] chunk = Arrays.copyOf(buffer, bytesRead);

                /// encryption

                FileDataPacket packet = new FileDataPacket(PacketType.FILE_DATA,
                        session.getHandler().getContext().getDeviceInfo().getDeviceId(),
                        session.getHandler().getContext().getDeviceInfo().getDeviceName(),
                        session.getHandler().getContext().getDeviceInfo().getTcpPort(), session.getTransferId(),
                        chunkNumber, totalChunks, chunk);
                session.getHandler().send(packet);

                chunkNumber++;

                session.setBytesTransferred(session.getBytesTransferred() + bytesRead);

                System.out.printf(
                        "sent %d/%d chunks %n",
                        chunkNumber,
                        totalChunks);
            }

            if (!cancelled) {
                TransferCompletePacket packet = new TransferCompletePacket(
                        PacketType.TRANSFER_COMPLETE, session.getHandler().getContext().getDeviceInfo().getDeviceId(),
                        session.getHandler().getContext().getDeviceInfo().getDeviceName(),
                        session.getHandler().getContext().getDeviceInfo().getTcpPort(), session.getTransferId());
                session.getHandler().send(packet);

                session.setState(TransferState.COMPLETED);
                System.out.println("Transfer Complete.");
            }
        } catch (IOException e) {
            System.out.println("TransferSender: Error in run()");
            session.setState(TransferState.FAILED);
            e.printStackTrace();
        }
    }

}
