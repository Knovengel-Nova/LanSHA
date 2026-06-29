package com.amasp.lansha.ui;

/**
 *
 * @author knovengel
 */
public class Console extends javax.swing.JFrame {
    
    public Console() {
        initComponents();
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonClose = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaConsole = new javax.swing.JTextArea();
        buttonClear = new javax.swing.JButton();

        setUndecorated(true);
        setResizable(false);

        buttonClose.setText("Close");
        buttonClose.addActionListener(this::buttonCloseActionPerformed);

        textAreaConsole.setColumns(20);
        textAreaConsole.setLineWrap(true);
        textAreaConsole.setRows(5);
        textAreaConsole.setEnabled(false);
        jScrollPane1.setViewportView(textAreaConsole);

        buttonClear.setText("Clear");
        buttonClear.addActionListener(this::buttonClearActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonClose))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonClose)
                    .addComponent(buttonClear))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void appendMessage(String message){
        textAreaConsole.append(">"+message+"\n");
    }
    
    private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_buttonCloseActionPerformed

    private void buttonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearActionPerformed
        // TODO add your handling code here:
        textAreaConsole.setText("");
    }//GEN-LAST:event_buttonClearActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClear;
    private javax.swing.JButton buttonClose;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textAreaConsole;
    // End of variables declaration//GEN-END:variables
}
