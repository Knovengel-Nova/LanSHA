package com.amasp.lansha.ui;

import com.amasp.lansha.network.transfer.TransferSession;
import java.awt.Dimension;

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
        packPanel();

    }

    private void initUIs() {

        labelFileName.setText(session.getFileName());
        progressBarProgress.setMinimum(0);
        progressBarProgress.setMaximum(100);
        progressBarProgress.setStringPainted(true);

        refresh();
    }

    public void refresh() {

        int progress = (int) (100.0
                * session.getBytesTransferred()
                / session.getFileSize());

        progressBarProgress.setValue(progress);
        progressBarProgress.setStringPainted(true);
        progressBarProgress.setString(progress + "%");

        labelProgress.setText(
                formatSize(session.getBytesTransferred())
                + " / "
                + formatSize(session.getFileSize()));

        labelReceivingFromOrSendingTo.setText(
                session.isSender()
                ? "Sending to " + session.getRemoteDeviceName()
                : "Receiving from " + session.getRemoteDeviceName());

        labelSpeed.setText(session.getFormattedSpeed());

        switch (session.getState()) {

            case WAITING_FOR_RESPONSE ->
                labelEta.setText("Waiting...");

            case ACCEPTED ->
                labelEta.setText("Preparing...");

            case TRANSFERRING ->
                labelEta.setText(session.getFormattedETA());

            case COMPLETED -> {
                buttonPause.setEnabled(false);
                buttonCancel.setEnabled(false);
                labelEta.setText("Completed");
                progressBarProgress.setValue(100);
                progressBarProgress.setString("100%");
            }

            case FAILED -> {
                buttonPause.setEnabled(false);
                buttonCancel.setEnabled(false);
                labelEta.setText("Failed");
            }

            case CANCELLED -> {
                buttonPause.setEnabled(false);
                buttonCancel.setEnabled(false);
                labelEta.setText("Cancelled");
            }

            default -> {
            }
        }
    }

    private void packPanel() {
        revalidate();
        doLayout();

        Dimension d = getPreferredSize();

        // Width expands to fill parent, height stays fixed to preferred height
        setPreferredSize(new Dimension(0, d.height));
        setMinimumSize(new Dimension(0, d.height));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, d.height));

        revalidate();
    }

    private String formatSize(long bytes) {
        double value = bytes;
        String[] units = {"B", "KB", "MB", "GB", "TB"};

        int i = 0;
        while (value >= 1024 && i < units.length - 1) {
            value /= 1024;
            i++;
        }

        return String.format("%.1f %s", value, units[i]);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progressBarProgress = new javax.swing.JProgressBar();
        buttonCancel = new javax.swing.JButton();
        buttonPause = new javax.swing.JButton();
        labelFileName = new javax.swing.JLabel();
        labelReceivingFromOrSendingTo = new javax.swing.JLabel();
        labelProgress = new javax.swing.JLabel();
        labelSpeed = new javax.swing.JLabel();
        labelEta = new javax.swing.JLabel();

        progressBarProgress.setValue(27);

        buttonCancel.setText("X");

        buttonPause.setText("||");

        labelReceivingFromOrSendingTo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelReceivingFromOrSendingTo.setText("Receiving from Knov");

        labelProgress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelProgress.setText("progress:");

        labelSpeed.setText("Speed:");

        labelEta.setText("ETA:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(progressBarProgress, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonPause, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelFileName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelReceivingFromOrSendingTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelProgress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelEta, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelFileName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelReceivingFromOrSendingTo)
                .addGap(24, 24, 24)
                .addComponent(labelProgress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(buttonPause, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(progressBarProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSpeed)
                    .addComponent(labelEta)))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonPause;
    private javax.swing.JLabel labelEta;
    private javax.swing.JLabel labelFileName;
    private javax.swing.JLabel labelProgress;
    private javax.swing.JLabel labelReceivingFromOrSendingTo;
    private javax.swing.JLabel labelSpeed;
    private javax.swing.JProgressBar progressBarProgress;
    // End of variables declaration//GEN-END:variables
}
