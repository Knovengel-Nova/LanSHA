package com.amasp.lansha.ui.panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author knovengel
 */
public class GenericPanel extends javax.swing.JPanel {

    public GenericPanel() {
        initComponents();
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 0, 10));

        buttonPanel.add(buttonChooseAnotherFile);
        buttonPanel.add(buttonSendFile);

        setLayout(new BorderLayout());

        add(panelDetails, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDetails = new javax.swing.JPanel();
        buttonChooseAnotherFile = new javax.swing.JButton();
        buttonSendFile = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelDetailsLayout = new javax.swing.GroupLayout(panelDetails);
        panelDetails.setLayout(panelDetailsLayout);
        panelDetailsLayout.setHorizontalGroup(
            panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelDetailsLayout.setVerticalGroup(
            panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 532, Short.MAX_VALUE)
        );

        add(panelDetails, java.awt.BorderLayout.CENTER);

        buttonChooseAnotherFile.setText("choose another file");
        buttonChooseAnotherFile.addActionListener(this::buttonChooseAnotherFileActionPerformed);
        add(buttonChooseAnotherFile, java.awt.BorderLayout.PAGE_START);

        buttonSendFile.setText("send file");
        add(buttonSendFile, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonChooseAnotherFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChooseAnotherFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonChooseAnotherFileActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonChooseAnotherFile;
    private javax.swing.JButton buttonSendFile;
    private javax.swing.JPanel panelDetails;
    // End of variables declaration//GEN-END:variables
}
