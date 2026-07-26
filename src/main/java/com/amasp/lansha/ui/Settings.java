package com.amasp.lansha.ui;

import com.amasp.lansha.util.Constants;
import com.amasp.lansha.util.LanSHAContext;
import com.amasp.lansha.util.NetworkUtil;
import com.amasp.lansha.util.Saver;
import com.amasp.lansha.util.SettingsData;

/**
 *
 * @author knovengel
 */
public class Settings extends javax.swing.JFrame {

    LanSHAContext context;

    public Settings(LanSHAContext context) {
        this.context = context;
        initComponents();
        updateUIs();
    }

    private void updateUIs() {
        SettingsData data = null;
        data = Saver.retrieveSettingsData();

        if (data != null) {
            this.textDeviceName.setText(data.getDeviceName());
            this.textUdpPort.setText(Integer.toString(data.getUdpPort()));
            this.textTcpPort.setText(Integer.toString(data.getTcpPort()));
            this.spinnerDeviceTimeout.getModel().setValue(data.getDeviceTimeoutInterval());
            this.spinnerJanitor.getModel().setValue(data.getJanitorInterval());
            this.spinnerHeartBeat.getModel().setValue(data.getHeartBeatBpm());
            this.spinnerChunkSize.getModel().setValue(data.getChunkSize());
            this.labelPath.setText(data.getSavePath());
            this.labelPath.setToolTipText(data.getSavePath());
        } else {
            this.textDeviceName.setText(NetworkUtil.getHostName());
            this.spinnerChunkSize.getModel().setValue(Constants.CHUNK_SIZE);
            this.spinnerJanitor.getModel().setValue(Constants.DEVICE_CLEANING_INTERVAL);
            this.spinnerDeviceTimeout.getModel().setValue(Constants.DEVICE_TIMEOUT);
            this.spinnerHeartBeat.getModel().setValue(Constants.HEARTBEAT_BPM);
            this.textUdpPort.setText(Integer.toString(Constants.UDP_PORT));
            this.textTcpPort.setText(Integer.toString(Constants.TCP_PORT));
            this.labelPath.setText("/");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        uiPanel = new javax.swing.JPanel();
        labelNetworkPorts = new javax.swing.JLabel();
        labelUdpPort = new javax.swing.JLabel();
        textUdpPort = new javax.swing.JTextField();
        labelTcpPort = new javax.swing.JLabel();
        textTcpPort = new javax.swing.JTextField();
        sep0 = new javax.swing.JSeparator();
        labelTimings = new javax.swing.JLabel();
        labelHeartBeat = new javax.swing.JLabel();
        labelDeviceTimeout = new javax.swing.JLabel();
        spinnerDeviceTimeout = new javax.swing.JSpinner();
        spinnerJanitor = new javax.swing.JSpinner();
        labelJanitor = new javax.swing.JLabel();
        sep1 = new javax.swing.JSeparator();
        labelFile = new javax.swing.JLabel();
        labelChunkSize = new javax.swing.JLabel();
        spinnerChunkSize = new javax.swing.JSpinner();
        labelSaveLocation = new javax.swing.JLabel();
        buttonLocation = new javax.swing.JButton();
        labelDeviceName = new javax.swing.JLabel();
        textDeviceName = new javax.swing.JTextField();
        spinnerHeartBeat = new javax.swing.JSpinner();
        labelPath = new javax.swing.JLabel();
        buttonDefaults = new javax.swing.JButton();
        buttonApply = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Settings");

        labelNetworkPorts.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        labelNetworkPorts.setText("Network");

        labelUdpPort.setText("UDP Listener Port");

        textUdpPort.setText("60704");

        labelTcpPort.setText("TCP Server Port");

        textTcpPort.setText("60407");
        textTcpPort.addActionListener(this::textTcpPortActionPerformed);

        labelTimings.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        labelTimings.setText("Timings");

        labelHeartBeat.setText("HeartBeat BPM");

        labelDeviceTimeout.setText("Device Timeout");

        labelJanitor.setText("Janitor Interval");

        labelFile.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        labelFile.setText("File");

        labelChunkSize.setText("Chunk Size");

        labelSaveLocation.setText("Save Location");

        buttonLocation.setText("Choose");
        buttonLocation.addActionListener(this::buttonLocationActionPerformed);

        labelDeviceName.setText("Device Name");

        textDeviceName.setText("Knovengel");
        textDeviceName.addActionListener(this::textDeviceNameActionPerformed);

        labelPath.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        labelPath.setText("/home/knov/testingLanSHA/");

        javax.swing.GroupLayout uiPanelLayout = new javax.swing.GroupLayout(uiPanel);
        uiPanel.setLayout(uiPanelLayout);
        uiPanelLayout.setHorizontalGroup(
            uiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(uiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(uiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(uiPanelLayout.createSequentialGroup()
                        .addGroup(uiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(uiPanelLayout.createSequentialGroup()
                                .addComponent(labelTcpPort, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textTcpPort, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(uiPanelLayout.createSequentialGroup()
                                .addComponent(labelDeviceTimeout, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinnerDeviceTimeout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(uiPanelLayout.createSequentialGroup()
                                .addComponent(labelHeartBeat, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinnerHeartBeat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(uiPanelLayout.createSequentialGroup()
                                .addComponent(labelChunkSize, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinnerChunkSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(uiPanelLayout.createSequentialGroup()
                                .addComponent(labelSaveLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonLocation)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(labelPath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(uiPanelLayout.createSequentialGroup()
                        .addGroup(uiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sep0)
                            .addGroup(uiPanelLayout.createSequentialGroup()
                                .addGroup(uiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelNetworkPorts, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(uiPanelLayout.createSequentialGroup()
                                        .addComponent(labelUdpPort, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textUdpPort, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(labelFile, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelTimings, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(uiPanelLayout.createSequentialGroup()
                                        .addComponent(labelDeviceName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textDeviceName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(uiPanelLayout.createSequentialGroup()
                                        .addComponent(labelJanitor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spinnerJanitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(sep1))
                        .addContainerGap())))
        );
        uiPanelLayout.setVerticalGroup(
            uiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(uiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNetworkPorts, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(uiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelUdpPort, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textUdpPort, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(uiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTcpPort, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textTcpPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(uiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textDeviceName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDeviceName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sep0, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTimings, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(uiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDeviceTimeout, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerDeviceTimeout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(uiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelJanitor, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerJanitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(uiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelHeartBeat, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerHeartBeat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sep1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFile, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(uiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelChunkSize, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerChunkSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(uiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSaveLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelPath)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonDefaults.setText("Defaults");
        buttonDefaults.addActionListener(this::buttonDefaultsActionPerformed);

        buttonApply.setText("Apply");
        buttonApply.addActionListener(this::buttonApplyActionPerformed);

        buttonCancel.setText("Cancel");
        buttonCancel.addActionListener(this::buttonCancelActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(uiPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonApply, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDefaults, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(uiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonDefaults, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonApply, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void textTcpPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTcpPortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTcpPortActionPerformed

    private void buttonLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLocationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonLocationActionPerformed

    private void textDeviceNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDeviceNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDeviceNameActionPerformed

    private void buttonDefaultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDefaultsActionPerformed
        this.textDeviceName.setText(NetworkUtil.getHostName());
        this.spinnerChunkSize.getModel().setValue(Constants.CHUNK_SIZE);
        this.spinnerJanitor.getModel().setValue(Constants.DEVICE_CLEANING_INTERVAL);
        this.spinnerDeviceTimeout.getModel().setValue(Constants.DEVICE_TIMEOUT);
        this.spinnerHeartBeat.getModel().setValue(Constants.HEARTBEAT_BPM);
        this.textUdpPort.setText(Integer.toString(Constants.UDP_PORT));
        this.textTcpPort.setText(Integer.toString(Constants.TCP_PORT));
        this.labelPath.setText("/");
        applySettings();
    }//GEN-LAST:event_buttonDefaultsActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonApplyActionPerformed
        // TODO add your handling code here:
        applySettings();
    }//GEN-LAST:event_buttonApplyActionPerformed

    private void applySettings() {
        SettingsData data = new SettingsData();
        data.setDeviceId(context.getDeviceInfo().getDeviceId());
        data.setUdpPort(Integer.parseInt(textUdpPort.getText()));
        data.setTcpPort(Integer.parseInt(textTcpPort.getText()));
        data.setDeviceName(textDeviceName.getText());
        data.setDeviceTimeoutInterval((int) spinnerDeviceTimeout.getValue());
        data.setJanitorInterval((int) spinnerJanitor.getValue());
        data.setHeartBeatBpm((int) spinnerHeartBeat.getValue());
        data.setChunkSize((int) spinnerChunkSize.getValue());

        Saver.saveSettingsData(data);
        dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonApply;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonDefaults;
    private javax.swing.JButton buttonLocation;
    private javax.swing.JLabel labelChunkSize;
    private javax.swing.JLabel labelDeviceName;
    private javax.swing.JLabel labelDeviceTimeout;
    private javax.swing.JLabel labelFile;
    private javax.swing.JLabel labelHeartBeat;
    private javax.swing.JLabel labelJanitor;
    private javax.swing.JLabel labelNetworkPorts;
    private javax.swing.JLabel labelPath;
    private javax.swing.JLabel labelSaveLocation;
    private javax.swing.JLabel labelTcpPort;
    private javax.swing.JLabel labelTimings;
    private javax.swing.JLabel labelUdpPort;
    private javax.swing.JSeparator sep0;
    private javax.swing.JSeparator sep1;
    private javax.swing.JSpinner spinnerChunkSize;
    private javax.swing.JSpinner spinnerDeviceTimeout;
    private javax.swing.JSpinner spinnerHeartBeat;
    private javax.swing.JSpinner spinnerJanitor;
    private javax.swing.JTextField textDeviceName;
    private javax.swing.JTextField textTcpPort;
    private javax.swing.JTextField textUdpPort;
    private javax.swing.JPanel uiPanel;
    // End of variables declaration//GEN-END:variables
}
