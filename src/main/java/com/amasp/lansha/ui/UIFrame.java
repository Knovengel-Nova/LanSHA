package com.amasp.lansha.ui;

import com.amasp.lansha.device.DeviceInfo;
import com.amasp.lansha.network.transfer.TransferSession;
import com.amasp.lansha.ui.panels.AudioPanel;
import com.amasp.lansha.ui.panels.DocumentPanel;
import com.amasp.lansha.ui.panels.EmptyFilePanel;
import com.amasp.lansha.ui.panels.GenericPanel;
import com.amasp.lansha.ui.panels.ImagePanel;
import com.amasp.lansha.ui.panels.TransferCardPanel;
import com.amasp.lansha.ui.panels.VideoPanel;
import com.amasp.lansha.util.FileUtil;
import com.amasp.lansha.util.LanSHAContext;
import com.amasp.lansha.util.metadata.AudioMetaData;
import com.amasp.lansha.util.metadata.DocumentMetaData;
import com.amasp.lansha.util.metadata.DocumentType;
import com.amasp.lansha.util.metadata.FileMetaData;
import com.amasp.lansha.util.metadata.ImageMetaData;
import com.amasp.lansha.util.metadata.VideoMetaData;
import com.amasp.lansha.util.metadata.reader.AudioMetaDataReader;
import com.amasp.lansha.util.metadata.reader.DocumentMetaDataReader;
import com.amasp.lansha.util.metadata.reader.ImageMetaDataReader;
import com.amasp.lansha.util.metadata.reader.VideoMetaDataReader;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.file.Path;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

/**
 *
 * @author knovengel
 */
public class UIFrame extends javax.swing.JFrame {

    private LanSHAContext context;

    private final Map<UUID, TransferCardPanel> transferPanels
            = new ConcurrentHashMap<>();

    DefaultListModel<DeviceInfo> model
            = new DefaultListModel<>();

    private EmptyFilePanel emptyfilePanel = new EmptyFilePanel();
    private GenericPanel genericPanel = new GenericPanel();
    private ImagePanel imagePanel = new ImagePanel();
    private AudioPanel audioPanel = new AudioPanel();
    private VideoPanel videoPanel = new VideoPanel();
    private DocumentPanel documentPanel = new DocumentPanel();

    private FileMetaData metaData;

    private Path selectedFile;

    public UIFrame(LanSHAContext context) {
        this.context = context;

        initComponents();

        listAvailableDevices.setModel(model);

        initUIs();
    }

    public void refreshDeviceList() {

        SwingUtilities.invokeLater(() -> {

            model.clear();

            context.getDeviceRegistry()
                    .getAllDevices()
                    .forEach(model::addElement);

        });

    }

    public void showFileRequest(TransferSession session) {
        SwingUtilities.invokeLater(() -> {
            FileRequestFrame frame
                    = new FileRequestFrame(context, session);
            frame.setVisible(true);
        });
    }

    public void addTransfer(TransferSession session) {

        SwingUtilities.invokeLater(() -> {

            TransferCardPanel panel = new TransferCardPanel(session);

            transferPanels.put(session.getTransferId(), panel);

            transferListPanel.add(panel);

            panelTransfers.revalidate();
            panelTransfers.repaint();
        });
    }

    public void updateTransfer(TransferSession session) {

        SwingUtilities.invokeLater(() -> {

            TransferCardPanel panel = transferPanels.get(session.getTransferId());

            if (panel != null) {
                panel.refresh();
            }

        });
    }

    public void removeTransfer(UUID transferId) {

        SwingUtilities.invokeLater(() -> {

            TransferCardPanel panel = transferPanels.remove(transferId);

            if (panel != null) {
                panelTransfers.remove(panel);
                panelTransfers.revalidate();
                panelTransfers.repaint();
            }
        });
    }

    private void initUIs() {
        setMinimumSize(new Dimension(1000, 600));

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        setSize(
                (int) (screen.width * 0.67),
                (int) (screen.height * 0.67)
        );

        setLocationRelativeTo(null);

        panelDetails.add(emptyfilePanel, "EMPTY");
        panelDetails.add(imagePanel, "IMAGE");
        panelDetails.add(audioPanel, "AUDIO");
        panelDetails.add(videoPanel, "VIDEO");
        panelDetails.add(genericPanel, "GENERIC");
        panelDetails.add(documentPanel, "DOCUMENT");

        showDetails("EMPTY");

        buttonChooseFile.setVisible(true);
        buttonSendFile.setVisible(false);
    }

    private void showDetails(String card) {

        CardLayout cl = (CardLayout) panelDetails.getLayout();

        cl.show(panelDetails, card);
    }

    private void updateFileChosenPanel() {
        String mime = metaData.getMimeType();

        if (mime == null) {
            genericPanel.setMetaData(metaData);
            showDetails("GENERIC");
        } else if (mime.startsWith("image/")) {
            ImageMetaData imgMetaData = ImageMetaDataReader.read(selectedFile);
            imagePanel.setMetaData(imgMetaData);
            showDetails("IMAGE");
        } else if (mime.startsWith("video/")) {
            VideoMetaData vidMetaData = VideoMetaDataReader.read(selectedFile);
            videoPanel.setMetaData(vidMetaData);
            showDetails("VIDEO");
        } else if (mime.startsWith("audio/")) {
            AudioMetaData audMetaData = AudioMetaDataReader.read(selectedFile);
            audioPanel.setAudioMetaData(audMetaData);
            showDetails("AUDIO");
        } else {
            DocumentType type = FileUtil.getDocumentType(metaData);

            switch (type) {
                case PDF:
                case EXCEL:
                case WORD:
                case POWERPOINT:
                case OPENDOCUMENT:
                case TEXT:
                    DocumentMetaData docMetaData = DocumentMetaDataReader.read(selectedFile);
                    documentPanel.setMetaData(docMetaData);
                    showDetails("DOCUMENT");
                    break;

                default:
                    genericPanel.setMetaData(metaData);
                    showDetails("GENERIC");
                    break;

            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFileInput = new javax.swing.JPanel();
        panelDetails = new javax.swing.JPanel();
        wrapperPanel = new javax.swing.JPanel();
        buttonPanel = new javax.swing.JPanel();
        buttonChooseFile = new javax.swing.JButton();
        buttonSendFile = new javax.swing.JButton();
        panelAvailableDevice = new javax.swing.JPanel();
        scrollPaneAvailableDevices = new javax.swing.JScrollPane();
        listAvailableDevices = new javax.swing.JList<>();
        panelTransfers = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        transferListPanel = new javax.swing.JPanel();
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
        panelFileInput.setLayout(new java.awt.BorderLayout());

        panelDetails.setLayout(new java.awt.CardLayout());
        panelFileInput.add(panelDetails, java.awt.BorderLayout.CENTER);

        buttonPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 10));

        buttonChooseFile.setText("Choose File");
        buttonChooseFile.addActionListener(this::buttonChooseFileActionPerformed);
        buttonPanel.add(buttonChooseFile);

        buttonSendFile.setText("Send File");
        buttonSendFile.addActionListener(this::buttonSendFileActionPerformed);
        buttonPanel.add(buttonSendFile);

        wrapperPanel.add(buttonPanel);

        panelFileInput.add(wrapperPanel, java.awt.BorderLayout.SOUTH);

        getContentPane().add(panelFileInput);

        panelAvailableDevice.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelAvailableDevice.setLayout(new java.awt.BorderLayout());

        scrollPaneAvailableDevices.setViewportView(listAvailableDevices);

        panelAvailableDevice.add(scrollPaneAvailableDevices, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelAvailableDevice);

        panelTransfers.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTransfers.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        transferListPanel.setLayout(new javax.swing.BoxLayout(transferListPanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(transferListPanel);

        panelTransfers.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelTransfers);

        menuFile.setText("File");

        menuItemSettings.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuItemSettings.setText("Settings");
        menuFile.add(menuItemSettings);

        menuItemQuit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuItemQuit.setText("Quit");
        menuItemQuit.addActionListener(this::menuItemQuitActionPerformed);
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

    private void buttonChooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChooseFileActionPerformed
        JFileChooser chooser = new JFileChooser();
        int res = chooser.showOpenDialog(this);
        if (res == JFileChooser.APPROVE_OPTION) {

            selectedFile = chooser.getSelectedFile().toPath();

            // check file type etc.
            metaData = new FileMetaData(selectedFile);

            updateFileChosenPanel();

            buttonChooseFile.setText("Change File");
            buttonSendFile.setVisible(true);
        }
    }//GEN-LAST:event_buttonChooseFileActionPerformed

    private void buttonSendFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSendFileActionPerformed

        if (selectedFile == null) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Please choose a file first.");
            return;
        }

        DeviceInfo device = listAvailableDevices.getSelectedValue();

        if (device == null) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Please select a device.");
            return;
        }

        context.getTransferManager().sendFile(device, selectedFile);

        buttonChooseFile.setText("Choose File");
        buttonSendFile.setVisible(false);
    }//GEN-LAST:event_buttonSendFileActionPerformed

    private void menuItemQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemQuitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuItemQuitActionPerformed

//    public static void main(String args[]) {
//        FlatDarkLaf.setup();
//        java.awt.EventQueue.invokeLater(() -> new UIFrame().setVisible(true));
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonChooseFile;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton buttonSendFile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<DeviceInfo> listAvailableDevices;
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
    private javax.swing.JPanel panelDetails;
    private javax.swing.JPanel panelFileInput;
    private javax.swing.JPanel panelTransfers;
    private javax.swing.JScrollPane scrollPaneAvailableDevices;
    private javax.swing.JPanel transferListPanel;
    private javax.swing.JPanel wrapperPanel;
    // End of variables declaration//GEN-END:variables
}
