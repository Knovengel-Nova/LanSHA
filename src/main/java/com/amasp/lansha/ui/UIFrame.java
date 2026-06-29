package com.amasp.lansha.ui;

import com.formdev.flatlaf.FlatDarkLaf;

/**
 *
 * @author knovengel
 */
public class UIFrame extends javax.swing.JFrame {

    public UIFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFileInput = new javax.swing.JPanel();
        panelAvailableDevice = new javax.swing.JPanel();
        panelTransfers = new javax.swing.JPanel();
        menuBarUiFrame = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuItemSettings = new javax.swing.JMenuItem();
        menuItemQuit = new javax.swing.JMenuItem();
        menuTheme = new javax.swing.JMenu();
        menuItemDarkTheme = new javax.swing.JMenuItem();
        menuItemLightTheme = new javax.swing.JMenuItem();
        menuItemMoreThemes = new javax.swing.JMenuItem();
        menuTransfers = new javax.swing.JMenu();
        menuItemTransferHistory = new javax.swing.JMenuItem();
        menuItemPendingTransfers = new javax.swing.JMenuItem();
        menuHelp = new javax.swing.JMenu();
        menuItemHelp = new javax.swing.JMenuItem();
        menuItemAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LanSHA - Knovengel@AMASP");
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        panelFileInput.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelFileInput.setLayout(new java.awt.CardLayout());
        getContentPane().add(panelFileInput);

        panelAvailableDevice.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelAvailableDevice.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelAvailableDevice);

        panelTransfers.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTransfers.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelTransfers);

        menuFile.setText("File");

        menuItemSettings.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuItemSettings.setText("Settings");
        menuFile.add(menuItemSettings);

        menuItemQuit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuItemQuit.setText("Quit");
        menuFile.add(menuItemQuit);

        menuBarUiFrame.add(menuFile);

        menuTheme.setText("Theme");

        menuItemDarkTheme.setText("Dark Theme");
        menuTheme.add(menuItemDarkTheme);

        menuItemLightTheme.setText("Light Theme");
        menuTheme.add(menuItemLightTheme);

        menuItemMoreThemes.setText("More Themes");
        menuTheme.add(menuItemMoreThemes);

        menuBarUiFrame.add(menuTheme);

        menuTransfers.setText("Transfers");

        menuItemTransferHistory.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuItemTransferHistory.setText("Transfer History");
        menuTransfers.add(menuItemTransferHistory);

        menuItemPendingTransfers.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuItemPendingTransfers.setText("Pending/Paused Transfers");
        menuTransfers.add(menuItemPendingTransfers);

        menuBarUiFrame.add(menuTransfers);

        menuHelp.setText("Help");

        menuItemHelp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuItemHelp.setText("Help");
        menuHelp.add(menuItemHelp);

        menuItemAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuItemAbout.setText("About");
        menuHelp.add(menuItemAbout);

        menuBarUiFrame.add(menuHelp);

        setJMenuBar(menuBarUiFrame);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        FlatDarkLaf.setup();
        java.awt.EventQueue.invokeLater(() -> new UIFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar menuBarUiFrame;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JMenuItem menuItemAbout;
    private javax.swing.JMenuItem menuItemDarkTheme;
    private javax.swing.JMenuItem menuItemHelp;
    private javax.swing.JMenuItem menuItemLightTheme;
    private javax.swing.JMenuItem menuItemMoreThemes;
    private javax.swing.JMenuItem menuItemPendingTransfers;
    private javax.swing.JMenuItem menuItemQuit;
    private javax.swing.JMenuItem menuItemSettings;
    private javax.swing.JMenuItem menuItemTransferHistory;
    private javax.swing.JMenu menuTheme;
    private javax.swing.JMenu menuTransfers;
    private javax.swing.JPanel panelAvailableDevice;
    private javax.swing.JPanel panelFileInput;
    private javax.swing.JPanel panelTransfers;
    // End of variables declaration//GEN-END:variables
}
