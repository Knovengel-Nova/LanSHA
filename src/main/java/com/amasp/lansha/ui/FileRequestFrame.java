package com.amasp.lansha.ui;

import com.amasp.lansha.network.transfer.TransferSession;
import com.amasp.lansha.util.FileUtil;
import com.amasp.lansha.util.LanSHAContext;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.nio.file.Path;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author knovengel
 */
public class FileRequestFrame extends javax.swing.JFrame {

    private LanSHAContext context;
    private TransferSession session;

    public FileRequestFrame(LanSHAContext context, TransferSession session) {
        this.context = context;
        this.session = session;

        initComponents();
        initUIs();

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                updateIcon();
            }
        });
    }

    private void initUIs() {
        labelSender.setText("File from " + session.getRemoteDeviceName());
        labelFileName.setText(session.getFileName());
        labelFileSize.setText(FileUtil.formatSize(session.getFileSize()));
        updateIcon();
    }

    private void updateIcon() {

        BufferedImage img = session.getPreview();

        if (img == null) {
            return;
        }

        int labelWidth = labelPreview.getWidth();
        int labelHeight = labelPreview.getHeight();

        if (labelWidth <= 0 || labelHeight <= 0) {
            return;
        }

        int imageWidth = img.getWidth();
        int imageHeight = img.getHeight();

        double scale = Math.min(
                (double) labelWidth / imageWidth,
                (double) labelHeight / imageHeight
        );

        int scaledWidth = (int) (imageWidth * scale);
        int scaledHeight = (int) (imageHeight * scale);

        java.awt.Image scaled = img.getScaledInstance(
                scaledWidth,
                scaledHeight,
                java.awt.Image.SCALE_SMOOTH);

        labelPreview.setIcon(new ImageIcon(scaled));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelUI = new javax.swing.JPanel();
        fileFromInfo1 = new javax.swing.JPanel();
        container1 = new javax.swing.JPanel();
        labelIncomingTransfer = new javax.swing.JLabel();
        labelProfile = new javax.swing.JLabel();
        labelSender = new javax.swing.JLabel();
        fileInfo = new javax.swing.JPanel();
        container = new javax.swing.JPanel();
        labelPreview = new javax.swing.JLabel();
        labelFileName = new javax.swing.JLabel();
        labelFileSize = new javax.swing.JLabel();
        buttons = new javax.swing.JPanel();
        container2 = new javax.swing.JPanel();
        buttonAccept = new javax.swing.JButton();
        padding = new javax.swing.JPanel();
        buttonReject = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Incomming File Request");
        setMinimumSize(new java.awt.Dimension(350, 400));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        panelUI.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelUI.setMinimumSize(new java.awt.Dimension(350, 400));
        panelUI.setPreferredSize(new java.awt.Dimension(450, 525));
        panelUI.setLayout(new javax.swing.BoxLayout(panelUI, javax.swing.BoxLayout.Y_AXIS));

        container1.setLayout(new java.awt.BorderLayout());

        labelIncomingTransfer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIncomingTransfer.setText("Incoming Transfer");
        container1.add(labelIncomingTransfer, java.awt.BorderLayout.NORTH);

        labelProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelProfile.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelProfile.setMaximumSize(new java.awt.Dimension(50, 50));
        labelProfile.setMinimumSize(new java.awt.Dimension(50, 50));
        labelProfile.setPreferredSize(new java.awt.Dimension(100, 100));
        container1.add(labelProfile, java.awt.BorderLayout.CENTER);

        labelSender.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSender.setText("File from AMASP");
        container1.add(labelSender, java.awt.BorderLayout.SOUTH);

        fileFromInfo1.add(container1);

        panelUI.add(fileFromInfo1);

        container.setLayout(new java.awt.BorderLayout());

        labelPreview.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPreview.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelPreview.setMaximumSize(new java.awt.Dimension(50, 50));
        labelPreview.setMinimumSize(new java.awt.Dimension(50, 50));
        labelPreview.setPreferredSize(new java.awt.Dimension(250, 150));
        container.add(labelPreview, java.awt.BorderLayout.NORTH);

        labelFileName.setText("jumanji");
        container.add(labelFileName, java.awt.BorderLayout.LINE_START);

        labelFileSize.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelFileSize.setText("546kB");
        container.add(labelFileSize, java.awt.BorderLayout.LINE_END);

        fileInfo.add(container);

        panelUI.add(fileInfo);

        container2.setLayout(new java.awt.BorderLayout());

        buttonAccept.setText("Accept");
        buttonAccept.addActionListener(this::buttonAcceptActionPerformed);
        container2.add(buttonAccept, java.awt.BorderLayout.LINE_START);

        padding.setPreferredSize(new java.awt.Dimension(25, 10));
        container2.add(padding, java.awt.BorderLayout.CENTER);

        buttonReject.setText("Reject");
        buttonReject.addActionListener(this::buttonRejectActionPerformed);
        container2.add(buttonReject, java.awt.BorderLayout.LINE_END);

        buttons.add(container2);

        panelUI.add(buttons);

        getContentPane().add(panelUI);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAcceptActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (chooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }

        Path folder = chooser.getSelectedFile().toPath();

        session.setDestinationPath(folder.resolve(session.getFileName()));

        context.getTransferManager().acceptTransfer(session.getTransferId());

        dispose();
    }//GEN-LAST:event_buttonAcceptActionPerformed

    private void buttonRejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRejectActionPerformed
        // TODO add your handling code here:
        context.getTransferManager()
                .rejectTransfer(session.getTransferId());

        dispose();
    }//GEN-LAST:event_buttonRejectActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAccept;
    private javax.swing.JButton buttonReject;
    private javax.swing.JPanel buttons;
    private javax.swing.JPanel container;
    private javax.swing.JPanel container1;
    private javax.swing.JPanel container2;
    private javax.swing.JPanel fileFromInfo1;
    private javax.swing.JPanel fileInfo;
    private javax.swing.JLabel labelFileName;
    private javax.swing.JLabel labelFileSize;
    private javax.swing.JLabel labelIncomingTransfer;
    private javax.swing.JLabel labelPreview;
    private javax.swing.JLabel labelProfile;
    private javax.swing.JLabel labelSender;
    private javax.swing.JPanel padding;
    private javax.swing.JPanel panelUI;
    // End of variables declaration//GEN-END:variables
}
