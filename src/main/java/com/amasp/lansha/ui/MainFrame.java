package com.amasp.lansha.ui;

import com.amasp.lansha.device.DeviceInfo;
import com.amasp.lansha.network.transfer.TransferSession;
import com.amasp.lansha.util.LanSHAContext;
import java.nio.file.Path;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

/**
 *
 * @author knovengel
 */
public class MainFrame extends javax.swing.JFrame {

    private Path selectedFile;
    private String fileName;
    private LanSHAContext context;

    private final Map<UUID, ad> transferPanels
            = new ConcurrentHashMap<>();

    DefaultListModel<DeviceInfo> model
            = new DefaultListModel<>();

    public MainFrame(LanSHAContext context) {
        initComponents();

        this.context = context;

        listAvailableDevices.setModel(model);

        panelTransfers.setLayout(
                new BoxLayout(panelTransfers, BoxLayout.Y_AXIS));

        panelTransfers.setAlignmentX(LEFT_ALIGNMENT);
        panelTransfers.setOpaque(false);

        jScrollPane3.getVerticalScrollBar().setUnitIncrement(16);
    }

    public void refreshDeviceList() {

        SwingUtilities.invokeLater(() -> {

            model.clear();

            context.getDeviceRegistry()
                    .getAllDevices()
                    .forEach(model::addElement);

        });

    }

    public void showFileRequest(TransferSession session) {
        SwingUtilities.invokeLater(() -> {
            FileRequestFrame frame
                    = new FileRequestFrame(context, session);
            frame.setVisible(true);
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAvailableDevices = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAvailableDevices = new javax.swing.JList<DeviceInfo>();
        jPanel1 = new javax.swing.JPanel();
        buttonChooseFile = new javax.swing.JButton();
        buttonSendFile = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaFileInfo = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        panelTransfers = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuEdit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LanSHA");

        jScrollPane1.setViewportView(listAvailableDevices);

        javax.swing.GroupLayout panelAvailableDevicesLayout = new javax.swing.GroupLayout(panelAvailableDevices);
        panelAvailableDevices.setLayout(panelAvailableDevicesLayout);
        panelAvailableDevicesLayout.setHorizontalGroup(
            panelAvailableDevicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAvailableDevicesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelAvailableDevicesLayout.setVerticalGroup(
            panelAvailableDevicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAvailableDevicesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                .addContainerGap())
        );

        buttonChooseFile.setText("Choose File");
        buttonChooseFile.addActionListener(this::buttonChooseFileActionPerformed);

        buttonSendFile.setText("Send File");
        buttonSendFile.addActionListener(this::buttonSendFileActionPerformed);

        textAreaFileInfo.setColumns(20);
        textAreaFileInfo.setLineWrap(true);
        textAreaFileInfo.setRows(5);
        textAreaFileInfo.setText("No preview Available.\nPlease Select a File first...");
        jScrollPane2.setViewportView(textAreaFileInfo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonChooseFile, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addComponent(buttonSendFile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonChooseFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSendFile)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelTransfersLayout = new javax.swing.GroupLayout(panelTransfers);
        panelTransfers.setLayout(panelTransfersLayout);
        panelTransfersLayout.setHorizontalGroup(
            panelTransfersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 409, Short.MAX_VALUE)
        );
        panelTransfersLayout.setVerticalGroup(
            panelTransfersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(panelTransfers);

        menuFile.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Settings");
        jMenuItem1.addActionListener(this::jMenuItem1ActionPerformed);
        menuFile.add(jMenuItem1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem3.setText("View Transfer History");
        menuFile.add(jMenuItem3);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Quit");
        jMenuItem2.addActionListener(this::jMenuItem2ActionPerformed);
        menuFile.add(jMenuItem2);

        jMenuBar1.add(menuFile);

        menuEdit.setText("Edit");
        jMenuBar1.add(menuEdit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelAvailableDevices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAvailableDevices, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonChooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChooseFileActionPerformed
        JFileChooser chooser = new JFileChooser();
        int res = chooser.showOpenDialog(this);
        if (res == JFileChooser.APPROVE_OPTION) {
            selectedFile = chooser.getSelectedFile().toPath();
            fileName = selectedFile.getFileName().toString();
            //  send file
            String textFileName = "Name: " + fileName + "\n\n";
            String textFileSize = "Size: " + selectedFile.toFile().length() + "B\n\n";
            String textFilePath = "Path: " + selectedFile.toFile().getAbsolutePath() + "\n\n";

            textAreaFileInfo.setText(textFileName + textFileSize + textFilePath);

        }
    }//GEN-LAST:event_buttonChooseFileActionPerformed

    private void buttonSendFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSendFileActionPerformed
        // TODO add your handling code here:
        if (selectedFile == null) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Please choose a file first.");
            return;
        }

        DeviceInfo device = listAvailableDevices.getSelectedValue();

        if (device == null) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Please select a device.");
            return;
        }

        context.getTransferManager().sendFile(device, selectedFile);
    }//GEN-LAST:event_buttonSendFileActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public void addTransfer(TransferSession session) {

        SwingUtilities.invokeLater(() -> {

            ad panel = new ad(session);

            transferPanels.put(session.getTransferId(), panel);

            panelTransfers.add(panel);

            panelTransfers.revalidate();
            panelTransfers.repaint();
        });
    }

    public void updateTransfer(TransferSession session) {

        SwingUtilities.invokeLater(() -> {

            ad panel = transferPanels.get(session.getTransferId());

            if (panel != null) {
                panel.refresh();
            }

        });
    }

    public void removeTransfer(UUID transferId) {

        SwingUtilities.invokeLater(() -> {

            ad panel = transferPanels.remove(transferId);

            if (panel != null) {
                panelTransfers.remove(panel);
                panelTransfers.revalidate();
                panelTransfers.repaint();
            }
        });
    }

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        SettingsFrame sf = new SettingsFrame(context);
        sf.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonChooseFile;
    private javax.swing.JButton buttonSendFile;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<DeviceInfo> listAvailableDevices;
    private javax.swing.JMenu menuEdit;
    private javax.swing.JMenu menuFile;
    private javax.swing.JPanel panelAvailableDevices;
    private javax.swing.JPanel panelTransfers;
    private javax.swing.JTextArea textAreaFileInfo;
    // End of variables declaration//GEN-END:variables
}
