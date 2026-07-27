package com.amasp.lansha.ui;

import java.awt.Desktop;
import javax.swing.event.HyperlinkEvent;

/**
 *
 * @author knov
 */
public class AboutFrame extends javax.swing.JFrame {

    public AboutFrame() {
        initComponents();

        helpPane.setEditable(false);

        helpPane.addHyperlinkListener(e -> {
            if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                try {
                    if (!Desktop.isDesktopSupported()) {
                        return;
                    }

                    Desktop desktop = Desktop.getDesktop();

                    if ("mailto".equalsIgnoreCase(e.getURL().getProtocol())) {
                        desktop.mail(e.getURL().toURI());
                    } else {
                        desktop.browse(e.getURL().toURI());
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        initializeHelpPane();
        setAboutContent();
    }

    private void initializeHelpPane() {
        helpPane.setContentType("text/html");
        helpPane.setEditable(false);
        helpPane.setCaretPosition(0);
    }

    private void setAboutContent() {
        helpPane.setText("""
        <html>
        <body style='font-family:sans-serif; padding:15px;'>

        <h1>About LanSHA</h1>

        <p>
        <b>LanSHA</b> is a lightweight Local Area Network (LAN) file-sharing
        application developed in Java. It enables fast, direct file transfers
        between devices connected to the same network without relying on cloud
        services or an internet connection.
        </p>

        <p>
        LanSHA focuses on simplicity, reliability, and ease of use while
        providing a modern desktop interface for discovering nearby devices
        and transferring files efficiently.
        </p>

        <hr>

        <h2>Application Information</h2>

        <table cellpadding='4'>
            <tr><td><b>Name</b></td><td>LanSHA</td></tr>
            <tr><td><b>Version</b></td><td>1.0.0</td></tr>
            <tr><td><b>Language</b></td><td>Java</td></tr>
            <tr><td><b>Framework</b></td><td>Java Swing</td></tr>
            <tr><td><b>License</b></td><td>Open Source</td></tr>
        </table>

        <hr>

        <h2>Developer</h2>

        <p>
        <b>Aryan Anand Patil</b><br>
        Computer Engineering Student<br>
        Sardar Patel Institute of Technology (SPIT), Mumbai
        </p>

        <p>
        Passionate about Java development, Computer Networks,
        Operating Systems, Distributed Systems, Linux, Cybersecurity,
        and building high-performance desktop applications.
        </p>

        <p>
        LanSHA was developed as a networking-focused project to explore
        peer-to-peer communication, device discovery, TCP file transfer,
        and modern desktop application development in Java.
        </p>

        <hr>

        <h2>Contact</h2>

        <p>
        <a href="mailto:knovengel@gmail.com">
            <b>knovengel@gmail.com</b>
        </a>
        </p>

        <p>
        <a href="https://github.com/Knovengel-Nova">
        <b>GitHub</b>
        </a>
        </p>

        <p>
        <a href="https://www.linkedin.com/in/aryanpatil-s/">
                <b>LinkedIn</b>
                </a>
        </p>
        <hr>

        <h2>Acknowledgements</h2>

        <ul>
            <li>Java Platform</li>
            <li>Java Swing</li>
            <li>Maven</li>
            <li>Jackson JSON Library</li>
            <li>FlatLaf Look &amp; Feel</li>
        </ul>

        <hr>

        <center>
        <b>Thank you for using LanSHA!</b><br><br>
        © 2026 Aryan Anand Patil
        </center>

        </body>
        </html>
        """);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        helpPane = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About");
        setMinimumSize(new java.awt.Dimension(300, 400));

        mainPanel.setLayout(new java.awt.BorderLayout());

        scrollPane.setViewportView(helpPane);

        mainPanel.add(scrollPane, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane helpPane;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
