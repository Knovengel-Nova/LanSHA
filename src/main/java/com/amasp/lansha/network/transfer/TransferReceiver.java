package com.amasp.lansha.network.transfer;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import com.amasp.lansha.protocol.tcp.FileDataPacket;

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
    private final TransferSession session;
    private final BufferedOutputStream out;

    public TransferReceiver(TransferSession session) throws IOException {
        this.session = session;

        this.out = new BufferedOutputStream(Files.newOutputStream(session.getDestinationFile()));
    }

    public void receive(FileDataPacket packet) {
        try {
            byte[] chunk = packet.getData();

            // Decryption

            out.write(chunk);

            session.setBytesTransferred(session.getBytesTransferred() + chunk.length);

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

    //         System.out.println("Transfer Complete.");
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    public void cancel() {
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        session.setState(TransferState.CANCELLED);
    }

}
