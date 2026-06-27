package com.amasp.lansha.ui;

import com.amasp.lansha.network.transfer.TransferSession;

/**
 *
 * @author knovengel
 */
public class FileRequestFrame extends javax.swing.JFrame {
    
    private TransferSession session;
    
    public FileRequestFrame(TransferSession session) {
        this.session = session;
        initComponents();
        initUIs();
    }
    
    private void initUIs(){
        labelSenderName.setText(session.getHandler().getContext().getDeviceInfo().getDeviceName());
        labelFileName.setText("Name: "+session.getFileName());
        labelFileSize.setText("Size: "+Long.toString(session.getFileSize()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelSenderName = new javax.swing.JLabel();
        labelFileName = new javax.swing.JLabel();
        labelFileSize = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        buttonAccept = new javax.swing.JButton();
        buttonReject = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("File Request");
        setResizable(false);

        labelSenderName.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        labelSenderName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSenderName.setText("Knov");

        labelFileName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFileName.setText("Name: Jumanji.mp4");

        labelFileSize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFileSize.setText("Size: 3.4GB");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("File From");

        buttonAccept.setText("Accept");
        buttonAccept.addActionListener(this::buttonAcceptActionPerformed);

        buttonReject.setText("Reject");
        buttonReject.addActionListener(this::buttonRejectActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonReject, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelSenderName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelFileName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelFileSize, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(9, 9, 9)
                .addComponent(labelSenderName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(labelFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelFileSize, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonReject, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAcceptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonAcceptActionPerformed

    private void buttonRejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRejectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonRejectActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAccept;
    private javax.swing.JButton buttonReject;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelFileName;
    private javax.swing.JLabel labelFileSize;
    private javax.swing.JLabel labelSenderName;
    // End of variables declaration//GEN-END:variables
}
