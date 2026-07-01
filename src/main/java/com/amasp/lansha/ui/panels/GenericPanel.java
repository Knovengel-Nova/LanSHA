package com.amasp.lansha.ui.panels;

import com.amasp.lansha.util.FileUtil;
import com.amasp.lansha.util.metadata.FileMetaData;
import com.formdev.flatlaf.extras.FlatSVGIcon;

/**
 *
 * @author knovengel
 */
public class GenericPanel extends javax.swing.JPanel {

    private FileMetaData metaData;

    public GenericPanel(FileMetaData metaData) {
        this.metaData = metaData;
        initComponents();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                updateIcon();
            }
        });

        labelImage.setIcon(new FlatSVGIcon("file.svg"));

        initUIs();
    }

    public GenericPanel() {
        initComponents();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                updateIcon();
            }
        });

        labelImage.setIcon(new FlatSVGIcon("file.svg"));
    }

    public void setMetaData(FileMetaData metaData) {
        this.metaData = metaData;
        initUIs();
    }

    private void initUIs() {
        this.labelFileName.setText(metaData.getFileName());
        this.labelFilePath.setText(metaData.getPath().toString());
        this.labelMime.setText(metaData.getMimeType());
        this.labelSize.setText(FileUtil.formatSize(metaData.getSize()));
        this.labelCreatedAt.setText(metaData.getCreatedTime().toString());
        this.labelModifiedAt.setText(metaData.getModifiedTime().toString());
        this.labelPerms.setText(metaData.getPerms());
    }

    private void updateIcon() {

        int size = (int) (Math.min(labelImage.getWidth(),
                labelImage.getHeight()) * 0.65);

        if (size <= 0) {
            return;
        }

        labelImage.setIcon(new FlatSVGIcon("file.svg", size, size));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagePanel = new javax.swing.JPanel();
        labelImage = new javax.swing.JLabel();
        detailsPanel = new javax.swing.JPanel();
        detailsPan = new javax.swing.JPanel();
        labelFileName = new javax.swing.JLabel();
        labelFilePath = new javax.swing.JLabel();
        labelMime = new javax.swing.JLabel();
        labelSize = new javax.swing.JLabel();
        labelCreatedAt = new javax.swing.JLabel();
        labelModifiedAt = new javax.swing.JLabel();
        labelPerms = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        imagePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        imagePanel.setLayout(new java.awt.BorderLayout());

        labelImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagePanel.add(labelImage, java.awt.BorderLayout.CENTER);

        add(imagePanel, java.awt.BorderLayout.CENTER);

        detailsPan.setLayout(new java.awt.GridLayout(9, 1, 0, 10));

        labelFileName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFileName.setText("Filename: Jumanji.java");
        detailsPan.add(labelFileName);

        labelFilePath.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFilePath.setText("path: /home/movies/");
        detailsPan.add(labelFilePath);

        labelMime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMime.setText("mime: Other");
        detailsPan.add(labelMime);

        labelSize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSize.setText("size: 2.5kB");
        detailsPan.add(labelSize);

        labelCreatedAt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCreatedAt.setText("created at: 21:23:35");
        detailsPan.add(labelCreatedAt);

        labelModifiedAt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelModifiedAt.setText("modified at: 23: 43: 43");
        detailsPan.add(labelModifiedAt);

        labelPerms.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPerms.setText("rwx");
        detailsPan.add(labelPerms);

        detailsPanel.add(detailsPan);

        add(detailsPanel, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel detailsPan;
    private javax.swing.JPanel detailsPanel;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JLabel labelCreatedAt;
    private javax.swing.JLabel labelFileName;
    private javax.swing.JLabel labelFilePath;
    private javax.swing.JLabel labelImage;
    private javax.swing.JLabel labelMime;
    private javax.swing.JLabel labelModifiedAt;
    private javax.swing.JLabel labelPerms;
    private javax.swing.JLabel labelSize;
    // End of variables declaration//GEN-END:variables
}
