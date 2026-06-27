package com.amasp.lansha.ui;

import com.amasp.lansha.device.DeviceInfo;
import com.amasp.lansha.util.LanSHAContext;
import java.nio.file.Path;
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
    DefaultListModel<DeviceInfo> model
            = new DefaultListModel<>();

    public MainFrame(LanSHAContext context) {
        initComponents();
        this.context = context;
        listAvailableDevices.setModel(model);
    }

    public void refreshDeviceList() {

        SwingUtilities.invokeLater(() -> {

            model.clear();

            context.getDeviceRegistry()
                    .getAllDevices()
                    .forEach(model::addElement);

        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAvailableDevices = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAvailableDevices = new javax.swing.JList<>();
        buttonConnect = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        buttonChooseFile = new javax.swing.JButton();
        buttonChooseFile1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LanSHA");

        jScrollPane1.setViewportView(listAvailableDevices);

        buttonConnect.setText("Connect");

        javax.swing.GroupLayout panelAvailableDevicesLayout = new javax.swing.GroupLayout(panelAvailableDevices);
        panelAvailableDevices.setLayout(panelAvailableDevicesLayout);
        panelAvailableDevicesLayout.setHorizontalGroup(
            panelAvailableDevicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAvailableDevicesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAvailableDevicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addComponent(buttonConnect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelAvailableDevicesLayout.setVerticalGroup(
            panelAvailableDevicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAvailableDevicesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonConnect, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addContainerGap())
        );

        buttonChooseFile.setText("Choose File");
        buttonChooseFile.addActionListener(this::buttonChooseFileActionPerformed);

        buttonChooseFile1.setText("Send File");
        buttonChooseFile1.addActionListener(this::buttonChooseFile1ActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonChooseFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonChooseFile1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonChooseFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonChooseFile1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelAvailableDevices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 454, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAvailableDevices, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        }
    }//GEN-LAST:event_buttonChooseFileActionPerformed

    private void buttonChooseFile1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChooseFile1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonChooseFile1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonChooseFile;
    private javax.swing.JButton buttonChooseFile1;
    private javax.swing.JButton buttonConnect;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<DeviceInfo> listAvailableDevices;
    private javax.swing.JPanel panelAvailableDevices;
    // End of variables declaration//GEN-END:variables
}
