package com.amasp.lansha.ui.panels;

import com.amasp.lansha.network.transfer.TransferSession;
import com.amasp.lansha.util.FileUtil;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Dimension;

/**
 *
 * @author knovengel
 */
public class TransferCardPanel extends javax.swing.JPanel {

    private TransferSession session;
    private boolean isPaused = false;

    public TransferCardPanel(TransferSession session) {
        this.session = session;
        initComponents();

        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        progressBar.setStringPainted(true);

        initUIs();
        packPanel();
    }

    private void initUIs() {
        labelFileName.setText(session.getFileName());
        labelProgress.setText(FileUtil.formatSize(session.getBytesTransferred()) + "/" + FileUtil.formatSize(session.getFileSize()));
        FlatSVGIcon icon;
        String type = session.getMime().substring(0, session.getMime().indexOf("/"));
        StringBuilder str = new StringBuilder();
        if (session.isSender()) {
            str.append("Sending to ");
        } else {
            str.append("Receiving from ");
        }
        str.append(session.getRemoteDeviceName());

        labelRemoteDevice.setText(str.toString());
        switch (type) {
            case "image":
                icon = new FlatSVGIcon("ImagesFiles/pixel/image.svg");
                break;

            case "video":
                icon = new FlatSVGIcon("ImagesFiles/pixel/video.svg");
                break;

            case "audio":
                icon = new FlatSVGIcon("ImagesFiles/pixel/music.svg");
                break;

            default:
                icon = new FlatSVGIcon("ImagesFiles/pixel/file.svg");

        }
        labelIcon.setIcon(new FlatSVGIcon(icon));

        buttonPause.setIcon(new FlatSVGIcon("ImagesFiles/pixel/pausecircle.svg"));
        buttonCancel.setIcon(new FlatSVGIcon("ImagesFiles/pixel/crosscircle.svg"));
        buttonCross.setIcon(new FlatSVGIcon("ImagesFiles/pixel/crosssquare.svg"));
        buttonInfo.setIcon(new FlatSVGIcon("ImagesFiles/pixel/infocircle.svg"));
        refresh();
    }

    public void refresh() {
        int progress = (int) (100.0
                * session.getBytesTransferred()
                / session.getFileSize());

        progressBar.setValue(progress);
        progressBar.setStringPainted(true);
        progressBar.setString(progress + "%");

        labelProgress.setText(FileUtil.formatSize(session.getBytesTransferred()) + "/" + FileUtil.formatSize(session.getFileSize()));

        labelSpeed.setText(session.getFormattedSpeed());
        labelETA.setText(session.getFormattedETA());

        switch (session.getState()) {

            case WAITING_FOR_RESPONSE ->
                labelETA.setText("Waiting...");

            case ACCEPTED ->
                labelETA.setText("Preparing...");

            case TRANSFERRING ->
                labelETA.setText(session.getFormattedETA());

            case COMPLETED -> {
                buttonPause.setEnabled(false);
                buttonCancel.setEnabled(false);
                labelETA.setText("Completed");
                progressBar.setValue(100);
                progressBar.setString("100%");
            }

            case REJECTED -> {
                buttonPause.setEnabled(false);
                buttonCancel.setEnabled(false);

                labelSpeed.setText("");
                labelETA.setText("Rejected");

                progressBar.setString("Rejected");
            }

            case FAILED -> {
                buttonPause.setEnabled(false);
                buttonCancel.setEnabled(false);
                labelETA.setText("Failed");
            }

            case CANCELLED -> {
                buttonPause.setEnabled(false);
                buttonCancel.setEnabled(false);
                labelETA.setText("Cancelled");
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonCross = new javax.swing.JButton();
        labelETA = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        buttonPause = new javax.swing.JButton();
        labelSpeed = new javax.swing.JLabel();
        labelFileName = new javax.swing.JLabel();
        labelRemoteDevice = new javax.swing.JLabel();
        labelProgress = new javax.swing.JLabel();
        labelIcon = new javax.swing.JLabel();
        buttonCancel = new javax.swing.JButton();
        buttonInfo = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelETA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelETA.setText("ETA: --:--");

        buttonPause.addActionListener(this::buttonPauseActionPerformed);

        labelSpeed.setText("Speed: 7.8 mBps");

        labelFileName.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        labelFileName.setText("Jumanji.mp4");

        labelRemoteDevice.setFont(new java.awt.Font("Liberation Sans", 2, 15)); // NOI18N
        labelRemoteDevice.setText("From Knov");

        labelProgress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelProgress.setText("Progress: 4.5kB/5.1mB");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelSpeed)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelProgress, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                                .addGap(51, 51, 51))
                            .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(buttonPause, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelETA)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelRemoteDevice)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelFileName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonCross, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCross, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelRemoteDevice)
                    .addComponent(buttonInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelProgress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonPause, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(progressBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSpeed)
                    .addComponent(labelETA))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPauseActionPerformed
        // TODO add your handling code here:
        if (isPaused) {// unpause the transfer
            buttonPause.setIcon(new FlatSVGIcon("ImagesFiles/pixel/pausecircle.svg"));
        } else {//pause the transfer
            buttonPause.setIcon(new FlatSVGIcon("ImagesFiles/pixel/playcircle.svg"));
        }
    }//GEN-LAST:event_buttonPauseActionPerformed

    public void makePaused(boolean state) {
        this.isPaused = state;
    }

    public boolean isPaused() {
        return isPaused;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonCross;
    private javax.swing.JButton buttonInfo;
    private javax.swing.JButton buttonPause;
    private javax.swing.JLabel labelETA;
    private javax.swing.JLabel labelFileName;
    private javax.swing.JLabel labelIcon;
    private javax.swing.JLabel labelProgress;
    private javax.swing.JLabel labelRemoteDevice;
    private javax.swing.JLabel labelSpeed;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}
