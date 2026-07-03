package com.amasp.lansha.ui.panels;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.BorderLayout;
import javax.swing.JLabel;

/**
 *
 * @author knovengel
 */
public class EmptyFilePanel extends javax.swing.JPanel {

    public EmptyFilePanel() {
        initComponents();

        setLayout(new BorderLayout());

        add(labelImage, BorderLayout.CENTER);

        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                updateIcon();
            }
        });

        labelImage.setIcon(new FlatSVGIcon("ImagesFiles/pixel/outbox.svg"));
        labelImage.setHorizontalAlignment(JLabel.CENTER);
        labelImage.setVerticalAlignment(JLabel.CENTER);
    }

    private void updateIcon() {

        int size = (int) (Math.min(labelImage.getWidth(),
                labelImage.getHeight()) * 0.65);

        if (size <= 0) {
            return;
        }

        labelImage.setIcon(new FlatSVGIcon("ImagesFiles/pixel/outbox.svg", size, size));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelImage = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        labelImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(labelImage, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelImage;
    // End of variables declaration//GEN-END:variables
}
