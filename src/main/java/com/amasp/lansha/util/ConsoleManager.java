package com.amasp.lansha.util;

import com.amasp.lansha.network.transfer.TransferSession;
import com.amasp.lansha.network.transfer.TransferState;
import java.util.Scanner;

/**
 *
 * @author knovengel
 */
public class ConsoleManager {
    private final Scanner sc = new Scanner(System.in);

    public boolean promptFileRequest(TransferSession session) {
        System.out.println("FileName: " + session.getFileName());
        System.out.println("FileSize: " + session.getFileSize());

        int ch = sc.nextInt();
        if (ch == 0) {
            session.setState(TransferState.ACCEPTED);
            return true;
        } else {
            session.setState(TransferState.REJECTED);
            return false;
        }
    }

    public void printMsg(String msg) {
        System.out.println(msg);
    }
}
