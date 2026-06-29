package com.amasp.lansha.ui;

import com.amasp.lansha.network.transfer.TransferSession;

/**
 *
 * @author knovengel
 */
public class panelTransfer extends javax.swing.JPanel {

    private TransferSession session;

    public panelTransfer(TransferSession session) {
        this.session = session;
        initComponents();
        initUIs();
    }

    private void initUIs() {
        this.labelTransferId.setText("Transfer ID: " + session.getTransferId().toString());
        this.labelRemoteDevice.setText("Remote Device: " + session.getRemoteDeviceName());
        this.labelFileName.setText("File Name: " + session.getFileName());
        this.labelFileSize.setText("File Size: " + Long.toString(session.getFileSize()) + "B");
        this.labelState.setText("State: " + session.getState().toString());
        this.labelProgress.setText("Progress: " + Long.toString((session.getBytesTransferred() / session.getFileSize()) * 100) + "%");
        this.progressBarProgress.setMaximum((int) session.getFileSize());
        this.progressBarProgress.setValue((int) session.getBytesTransferred());
    }

    public void updateProgress() {
        this.labelProgress.setText("Progress: " + Long.toString((session.getBytesTransferred() / session.getFileSize()) * 100) + "%");
        this.progressBarProgress.setMaximum((int) session.getFileSize());
        this.progressBarProgress.setValue((int) session.getBytesTransferred());
    }

    public void updateState() {
        this.labelState.setText("State: " + session.getState().toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progressBarProgress = new javax.swing.JProgressBar();
        buttonCancel = new javax.swing.JButton();
        buttonPause = new javax.swing.JButton();
        labelRemoteDevice = new javax.swing.JLabel();
        labelTransferId = new javax.swing.JLabel();
        labelFileName = new javax.swing.JLabel();
        labelFileSize = new javax.swing.JLabel();
        labelState = new javax.swing.JLabel();
        labelProgress = new javax.swing.JLabel();

        progressBarProgress.setValue(27);

        buttonCancel.setText("X");

        buttonPause.setText("||");

        labelRemoteDevice.setText("Remote Device: ");

        labelTransferId.setText("Transfer ID: ");

        labelFileName.setText("File Name:");

        labelFileSize.setText("File Size:");

        labelState.setText("State: ");

        labelProgress.setText("Progress:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelRemoteDevice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(progressBarProgress, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonPause, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelTransferId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelFileName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelFileSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelState, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelProgress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTransferId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelRemoteDevice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelFileName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFileSize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelState)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelProgress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(buttonPause, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(buttonCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(progressBarProgress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonPause;
    private javax.swing.JLabel labelFileName;
    private javax.swing.JLabel labelFileSize;
    private javax.swing.JLabel labelProgress;
    private javax.swing.JLabel labelRemoteDevice;
    private javax.swing.JLabel labelState;
    private javax.swing.JLabel labelTransferId;
    private javax.swing.JProgressBar progressBarProgress;
    // End of variables declaration//GEN-END:variables
}
