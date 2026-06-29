/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.amasp.lansha.ui;

import com.amasp.lansha.util.Constants;
import com.amasp.lansha.util.LanSHAContext;

/**
 *
 * @author knovengel
 */
public class SettingsFrame extends javax.swing.JFrame {
    
    private LanSHAContext context;
    
    public SettingsFrame(LanSHAContext context) {
        this.context = context;
        initComponents();
        initUIs();
    }
    
    private void initUIs(){
        this.textDeviceName.setText(context.getDeviceInfo().getDeviceName());
        this.textUdpPort.setText(Integer.toString(Constants.UDP_PORT));
        this.textTcpPort.setText(Integer.toString(Constants.TCP_PORT));
        this.spinnerChunkSize.setValue(Constants.CHUNK_SIZE/1024);
        this.spinnerDeviceTimeoutInterval.setValue(Constants.DEVICE_TIMEOUT/1000);
        this.spinnerHeartBeatBpm.setValue(Constants.HEARTBEAT_BPM);
        this.spinnerJanitor.setValue(Constants.DEVICE_CLEANING_INTERVAL/1000);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitleNetworkPorts = new javax.swing.JLabel();
        labelUdpPort = new javax.swing.JLabel();
        labelTcpPort = new javax.swing.JLabel();
        textUdpPort = new javax.swing.JTextField();
        textTcpPort = new javax.swing.JTextField();
        separator1 = new javax.swing.JSeparator();
        labelTitleTimings = new javax.swing.JLabel();
        labelHeartBeatBpm = new javax.swing.JLabel();
        spinnerHeartBeatBpm = new javax.swing.JSpinner();
        labelDeviceTimeoutInterval = new javax.swing.JLabel();
        spinnerDeviceTimeoutInterval = new javax.swing.JSpinner();
        labelJanitor = new javax.swing.JLabel();
        spinnerJanitor = new javax.swing.JSpinner();
        labelTitleFile = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        spinnerChunkSize = new javax.swing.JSpinner();
        labelChunkSize = new javax.swing.JLabel();
        labelSaveLocation = new javax.swing.JLabel();
        buttonChangeLocation = new javax.swing.JButton();
        labelTitleMisc = new javax.swing.JLabel();
        labelDeviceName = new javax.swing.JLabel();
        textDeviceName = new javax.swing.JTextField();
        labelTheme = new javax.swing.JLabel();
        comboTheme = new javax.swing.JComboBox<>();
        labelEnableConsole = new javax.swing.JLabel();
        checkEnableConsole = new javax.swing.JCheckBox();
        jSeparator3 = new javax.swing.JSeparator();
        buttonCancel = new javax.swing.JButton();
        buttonApply = new javax.swing.JButton();
        buttonReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Settings");

        labelTitleNetworkPorts.setText("Network Ports");

        labelUdpPort.setText("UDP Listener Port:");

        labelTcpPort.setText("TCP Server Port:");

        textUdpPort.setText("60704");
        textUdpPort.addActionListener(this::textUdpPortActionPerformed);

        textTcpPort.setText("60407");
        textTcpPort.addActionListener(this::textTcpPortActionPerformed);

        labelTitleTimings.setText("Timings");

        labelHeartBeatBpm.setText("HeartBeat BPM:");

        labelDeviceTimeoutInterval.setText("Device Timeout Interval:");

        labelJanitor.setText("Janitor Scaning Interval:");

        labelTitleFile.setText("File");

        labelChunkSize.setText("Chunk Size(kB): ");

        labelSaveLocation.setText("Save Location:");

        buttonChangeLocation.setText("Loc");
        buttonChangeLocation.addActionListener(this::buttonChangeLocationActionPerformed);

        labelTitleMisc.setText("Misc");

        labelDeviceName.setText("Device Name:");

        textDeviceName.setText("Knov");
        textDeviceName.addActionListener(this::textDeviceNameActionPerformed);

        labelTheme.setText("Theme:");

        comboTheme.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Light", "Dark" }));

        labelEnableConsole.setText("Enable Console:");

        buttonCancel.setText("Cancel");
        buttonCancel.addActionListener(this::buttonCancelActionPerformed);

        buttonApply.setText("Apply");
        buttonApply.addActionListener(this::buttonApplyActionPerformed);

        buttonReset.setText("Reset to Defaults");
        buttonReset.addActionListener(this::buttonResetActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelTitleNetworkPorts, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelUdpPort, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(labelTcpPort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textTcpPort, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textUdpPort, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(labelTitleTimings, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelDeviceTimeoutInterval, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(labelHeartBeatBpm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinnerHeartBeatBpm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerDeviceTimeoutInterval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelJanitor, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(spinnerJanitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelTitleFile, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelChunkSize, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelSaveLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spinnerChunkSize)
                            .addComponent(buttonChangeLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addComponent(jSeparator2)
                    .addComponent(separator1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTitleMisc, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelDeviceName, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textDeviceName, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelTheme, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboTheme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelEnableConsole, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(checkEnableConsole)))
                        .addGap(90, 90, 90))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator3)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonApply)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonReset)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTitleNetworkPorts, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTitleMisc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textUdpPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelUdpPort)
                            .addComponent(textDeviceName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDeviceName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textTcpPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTcpPort)
                            .addComponent(labelTheme)
                            .addComponent(comboTheme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(separator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelEnableConsole)
                        .addComponent(checkEnableConsole)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTitleTimings, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerHeartBeatBpm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelHeartBeatBpm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerDeviceTimeoutInterval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDeviceTimeoutInterval))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerJanitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelJanitor))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelTitleFile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spinnerChunkSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelChunkSize))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelSaveLocation)
                            .addComponent(buttonChangeLocation))
                        .addContainerGap(84, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonReset)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(buttonCancel)
                                .addComponent(buttonApply)))
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void textUdpPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textUdpPortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textUdpPortActionPerformed

    private void textTcpPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTcpPortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTcpPortActionPerformed

    private void textDeviceNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDeviceNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDeviceNameActionPerformed

    private void buttonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonResetActionPerformed

    private void buttonApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonApplyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonApplyActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonChangeLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChangeLocationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonChangeLocationActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonApply;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonChangeLocation;
    private javax.swing.JButton buttonReset;
    private javax.swing.JCheckBox checkEnableConsole;
    private javax.swing.JComboBox<String> comboTheme;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel labelChunkSize;
    private javax.swing.JLabel labelDeviceName;
    private javax.swing.JLabel labelDeviceTimeoutInterval;
    private javax.swing.JLabel labelEnableConsole;
    private javax.swing.JLabel labelHeartBeatBpm;
    private javax.swing.JLabel labelJanitor;
    private javax.swing.JLabel labelSaveLocation;
    private javax.swing.JLabel labelTcpPort;
    private javax.swing.JLabel labelTheme;
    private javax.swing.JLabel labelTitleFile;
    private javax.swing.JLabel labelTitleMisc;
    private javax.swing.JLabel labelTitleNetworkPorts;
    private javax.swing.JLabel labelTitleTimings;
    private javax.swing.JLabel labelUdpPort;
    private javax.swing.JSeparator separator1;
    private javax.swing.JSpinner spinnerChunkSize;
    private javax.swing.JSpinner spinnerDeviceTimeoutInterval;
    private javax.swing.JSpinner spinnerHeartBeatBpm;
    private javax.swing.JSpinner spinnerJanitor;
    private javax.swing.JTextField textDeviceName;
    private javax.swing.JTextField textTcpPort;
    private javax.swing.JTextField textUdpPort;
    // End of variables declaration//GEN-END:variables
}
