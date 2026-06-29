package com.amasp.lansha.ui.panels;

/**
 *
 * @author knovengel
 */
public class transferCardPanel extends javax.swing.JPanel {

    public transferCardPanel() {
        initComponents();
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonCross = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        labelETA = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        buttonPause = new javax.swing.JButton();
        labelSpeed = new javax.swing.JLabel();
        labelFileName = new javax.swing.JLabel();
        labelRemoteDevice = new javax.swing.JLabel();
        labelProgress = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonCross.setText("X");

        buttonCancel.setText("x");

        labelETA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelETA.setText("ETA: --:--");

        buttonPause.setText("p");

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
                        .addComponent(labelFileName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonCross))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelSpeed)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelETA))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelRemoteDevice)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelProgress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                            .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonPause)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCross)
                    .addComponent(labelFileName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelRemoteDevice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(labelProgress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonPause, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSpeed)
                    .addComponent(labelETA))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonCross;
    private javax.swing.JButton buttonPause;
    private javax.swing.JLabel labelETA;
    private javax.swing.JLabel labelFileName;
    private javax.swing.JLabel labelProgress;
    private javax.swing.JLabel labelRemoteDevice;
    private javax.swing.JLabel labelSpeed;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}
