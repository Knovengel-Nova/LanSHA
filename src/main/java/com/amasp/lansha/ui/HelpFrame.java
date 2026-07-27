package com.amasp.lansha.ui;

import javax.swing.JTextPane;

/**
 *
 * @author knov
 */
public class HelpFrame extends javax.swing.JFrame {

    public HelpFrame() {
        initComponents();

        initializeHelpPane();
        setHelpContent();
    }

    private void initializeHelpPane() {
        helpPane = new JTextPane();
        helpPane.setContentType("text/html");
        helpPane.setEditable(false);
        helpPane.setCaretPosition(0);

        scrollPane.setViewportView(helpPane);
    }

    private void setHelpContent() {
        helpPane.setText("""
            <html>
            <body style='font-family:sans-serif; padding:15px;'>

            <h1>Help</h1>

            <h2>Welcome to LanSHA</h2>

            <p>
            LanSHA is a local network file-sharing application that allows you to quickly transfer files between devices connected to the same Local Area Network (LAN). No internet connection is required—both devices simply need to be on the same network.
            </p>

            <hr>

            <h2>Getting Started</h2>

            <p>Before sending or receiving files, ensure that:</p>

            <ul>
                <li>Both devices are connected to the same Wi-Fi or Ethernet network.</li>
                <li>LanSHA is running on both devices.</li>
                <li>Your firewall allows LanSHA to communicate over the network.</li>
                <li>Both devices appear in the <b>Available Devices</b> list.</li>
            </ul>

            <p>
            If a device does not appear, wait a few seconds or ensure both devices are connected to the same network.
            </p>

            <hr>

            <h2>Sending Files</h2>

            <ol>
                <li>Click <b>Select File</b>.</li>
                <li>Choose the file you want to share.</li>
                <li>Wait for the file information to load.</li>
                <li>Select a device from the <b>Available Devices</b> panel.</li>
                <li>Click <b>Send</b>.</li>
                <li>Wait for the recipient to accept the transfer request.</li>
            </ol>

            <p>The transfer will begin automatically once the receiver accepts.</p>

            <hr>

            <h2>Receiving Files</h2>

            <p>When another device wants to send you a file:</p>

            <ol>
                <li>A transfer request will appear.</li>
                <li>Review the file details.</li>
                <li>Click <b>Accept</b> to receive the file.</li>
                <li>Choose <b>Reject</b> if you do not wish to receive it.</li>
            </ol>

            <p>Accepted files will be saved to the configured download location.</p>

            <hr>

            <h2>Transfer Progress</h2>

            <p>During a transfer you can view:</p>

            <ul>
                <li>Current transfer progress</li>
                <li>Transfer speed</li>
                <li>Estimated time remaining (if available)</li>
                <li>File size</li>
                <li>Transfer status</li>
            </ul>

            <p>Completed transfers will be marked as <b>Finished</b>.</p>

            <hr>

            <h2>Device Discovery</h2>

            <p>LanSHA automatically discovers nearby devices running the application.</p>

            <p>Devices may disappear if:</p>

            <ul>
                <li>The application is closed.</li>
                <li>The device disconnects from the network.</li>
                <li>The device becomes unreachable.</li>
            </ul>

            <p>No manual refresh is normally required.</p>

            <hr>

            <h2>File Information</h2>

            <p>Before sending a file, LanSHA displays available information such as:</p>

            <ul>
                <li>File name</li>
                <li>File size</li>
                <li>File type</li>
                <li>Preview (when supported)</li>
                <li>Additional media information (for supported formats)</li>
            </ul>

            <p>This helps verify that the correct file has been selected.</p>

            <hr>

            <h2>Troubleshooting</h2>

            <h3>No devices found</h3>

            <ul>
                <li>Verify both devices are on the same network.</li>
                <li>Ensure LanSHA is running on both devices.</li>
                <li>Check firewall or antivirus settings.</li>
                <li>Wait a few seconds for device discovery.</li>
            </ul>

            <h3>Transfer request not received</h3>

            <ul>
                <li>Confirm the receiver is online.</li>
                <li>Verify the selected device is correct.</li>
                <li>Ensure the network connection is stable.</li>
            </ul>

            <h3>Transfer failed</h3>

            <p>Possible reasons include:</p>

            <ul>
                <li>Network interruption</li>
                <li>Receiver rejected the transfer</li>
                <li>Receiver disconnected</li>
                <li>File became unavailable</li>
                <li>Firewall blocked the connection</li>
            </ul>

            <p>Simply reconnect and try again.</p>

            <h3>Slow transfer speed</h3>

            <p>Transfer speed depends on:</p>

            <ul>
                <li>Wi-Fi signal strength</li>
                <li>Network congestion</li>
                <li>Ethernet vs. wireless connection</li>
                <li>File size</li>
                <li>Device performance</li>
            </ul>

            <p>Using a wired Ethernet connection generally provides the fastest and most stable transfers.</p>

            <hr>

            <h2>Privacy</h2>

            <p>
            LanSHA only transfers files between devices on your local network.
            </p>

            <p>
            Your files are not uploaded to cloud storage or external servers.
            </p>

            <p>
            Only devices connected to the same network can discover each other.
            </p>

            <hr>

            <h2>Tips</h2>

            <ul>
                <li>Keep both devices awake during transfers.</li>
                <li>Avoid disconnecting from Wi-Fi while transferring files.</li>
                <li>Large files may take longer depending on network speed.</li>
                <li>Ensure sufficient storage space on the receiving device.</li>
            </ul>

            <hr>

            <h2>Frequently Asked Questions</h2>

            <h3>Does LanSHA require an internet connection?</h3>

            <p>No. LanSHA works entirely over your local network.</p>

            <h3>Can I transfer folders?</h3>

            <p>
            Only if folder transfer is supported by your current version. Otherwise, compress the folder into a ZIP file before sending.
            </p>

            <h3>What file types are supported?</h3>

            <p>LanSHA can transfer any file type, including:</p>

            <ul>
                <li>Images</li>
                <li>Videos</li>
                <li>Audio</li>
                <li>Documents</li>
                <li>Archives</li>
                <li>Executables</li>
                <li>Other binary files</li>
            </ul>

            <h3>Is there a file size limit?</h3>

            <p>
            There is no fixed software limit. The practical limit depends on available storage, system resources, and network stability.
            </p>

            <h3>Why can't I see another device?</h3>

            <p>Ensure both devices:</p>

            <ul>
                <li>Are connected to the same network.</li>
                <li>Have LanSHA running.</li>
                <li>Are not blocked by firewall or network restrictions.</li>
            </ul>

            <h3>Can I cancel a transfer?</h3>

            <p>
            If supported by your version, you can cancel an active transfer from the Transfers panel.
            </p>

            <hr>

            <h2>Need More Help?</h2>

            <p>
            If you continue experiencing issues, verify your network connection,
            restart LanSHA on both devices, and try the transfer again. Most
            connectivity issues are resolved by ensuring both devices are on the
            same local network and that firewalls allow LanSHA to communicate.
            </p>

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

        mainPanel.setLayout(new java.awt.BorderLayout());

        scrollPane.setViewportView(helpPane);

        mainPanel.add(scrollPane, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
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
