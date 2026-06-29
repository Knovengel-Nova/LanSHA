package com.amasp.lansha.network.transfer;

import com.amasp.lansha.protocol.tcp.FileDataPacket;
import com.amasp.lansha.util.LanSHAContext;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;

/**
 *
 * @author knovengel
 */

/// receive filedatapacket
/// decrypt
/// write chunk to a file
/// update transfer session
/// wait for next chunk or transfercomplete

public class TransferReceiver {
    private LanSHAContext context;
    private final TransferSession session;
    private final BufferedOutputStream out; // to write received file in our file system

    public TransferReceiver(LanSHAContext context, TransferSession session) throws IOException {
        this.session = session;
        this.context = context;
        this.out = new BufferedOutputStream(Files.newOutputStream(session.getDestinationFile()));
    }

    public void receive(FileDataPacket packet) {
        try {
            byte[] chunk = packet.getData();

            // Decryption

            out.write(chunk);

            session.setBytesTransferred(session.getBytesTransferred() + chunk.length);
            context.getMainFrame().updateTransfer(session);context.getMainFrame().updateTransfer(session);

            System.out.printf(
                    "Received %d/%d chunk.%n",
                    packet.getChunkNumber() + 1,
                    packet.getTotalChunks());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // public void finish() {
    //     try {
    //         out.flush();
    //         out.close();

    //         session.setState(TransferState.COMPLETED);

    //         context.print("Transfer Complete.");
    //     } catch (IOException e) {
//            context.print("TransferReceiver: Error in finish()");

    //         e.printStackTrace();
    //     }
    // }

    public void cancel() {
        try {
            out.close();
        } catch (IOException e) {
            context.print("TransferReceiver: Error in cancel()");
            e.printStackTrace();
        }

        session.setState(TransferState.CANCELLED);
    }

}
