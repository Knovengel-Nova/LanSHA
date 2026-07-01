package com.amasp.lansha.ui.panels;

import com.amasp.lansha.util.FileUtil;
import com.amasp.lansha.util.metadata.AudioMetaData;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author knovengel
 */
public class AudioPanel extends javax.swing.JPanel {

    private AudioMetaData metaData;

    public AudioPanel() {
        initComponents();

        addPadding(commonDetails);
        addPadding(musicDetails);
        addPadding(technicalDetails);
        commonDetails.setBorder(
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        );

        musicDetails.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 10, 15)
        );

        technicalDetails.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 10, 15)
        );

        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                updateIcon();
            }
        });
    }

    public void setAudioMetaData(AudioMetaData metaData) {
        this.metaData = metaData;
        initUIs();
        updateIcon();
    }

    private void updateIcon() {
        if (metaData == null) {
            return;
        }

        BufferedImage img = metaData.getAlbumArt();

        if (img == null) {
            return;
        }

        int labelWidth = labelImage.getWidth();
        int labelHeight = labelImage.getHeight();

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

        labelImage.setIcon(new ImageIcon(scaled));
    }

    private void initUIs() {

        /* ---------- Common Details ---------- */
        zLabel(labelFileName,
                metaData.getFileName(),
                "File");

        zLabel(labelFileExtentionAndMime,
                metaData.getExtension() + " (" + metaData.getMimeType() + ")",
                "Extension");

        zLabel(labelSize,
                FileUtil.formatSize(metaData.getSize()),
                "Size");

        zLabel(labelPath,
                metaData.getPath(),
                "Path");

        zLabel(labelCreatedAt,
                metaData.getCreatedTime(),
                "Created");

        zLabel(labelModifiedAt,
                metaData.getModifiedTime(),
                "Modified");

        zLabel(labelRWX,
                metaData.getPerms(),
                "Permissions");

        /* ---------- Music Details ---------- */
        zLabel(labelTitle,
                metaData.getTitle(),
                "Title");

        zLabel(labelArtist,
                metaData.getArtist(),
                "Artist");

        zLabel(labelalbumArtist,
                metaData.getAlbumArtist(),
                "Album Artist");

        zLabel(labelAlbum,
                metaData.getAlbum(),
                "Album");

        zLabel(labelGenre,
                metaData.getGenre(),
                "Genre");

        zLabel(labelYear,
                metaData.getYear(),
                "Year");

        /* ---------- Technical Details ---------- */
        zLabel(labelDuration,
                FileUtil.formatDuration(metaData.getDuration()),
                "Duration");

        zLabel(labelBitrate,
                metaData.getBitRate(),
                "Bit Rate");

        zLabel(labelSampleRate,
                metaData.getSampleRate(),
                "Sample Rate");

        zLabel(labelChannels,
                metaData.getChannels(),
                "Channels");

        zLabel(labelEncodingType,
                metaData.getEncodingType(),
                "Encoding");

        zLabel(labelFormat,
                metaData.getFormat(),
                "Format");

        zLabel(labelVariableBitRate,
                metaData.isVariableBitRate() ? "Yes" : "No",
                "Variable Bit Rate");

        zLabel(labelLossless,
                metaData.isLossless() ? "Yes" : "No",
                "Lossless");

        zLabel(labelTrack,
                metaData.getTrack(),
                "Track");

        zLabel(labelDisk,
                metaData.getDisc(),
                "Disc");

        zLabel(labelComposer,
                metaData.getComposer(),
                "Composer");

        zLabel(labelComment,
                metaData.getComment(),
                "Comment");

        /* ---------- Hide Music Section ---------- */
        musicDetails.setVisible(metaData.hasMusicTags());

        /* ---------- Album Art ---------- */
        if (metaData.isHasAlbumArt()) {
            updateIcon();

        } else {
            labelImage.setIcon(null);

        }

    }

    private void addPadding(javax.swing.JPanel panel) {

        for (java.awt.Component c : panel.getComponents()) {

            if (c instanceof JLabel label) {

                label.setBorder(
                        javax.swing.BorderFactory.createEmptyBorder(
                                3, // top
                                10, // left
                                3, // bottom
                                10 // right
                        )
                );

            }
        }
    }

    private void zLabel(JLabel label, Object data, String title) {

        String value;

        if (data == null) {
            value = "N/A";
        } else {
            value = data.toString().trim();
            if (value.isEmpty()) {
                value = "N/A";
            }
        }

        label.setText("<html><b>" + title + ":</b> " + value + "</html>");

        label.setToolTipText(title + ": " + value);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Container = new javax.swing.JPanel();
        imagePanel = new javax.swing.JPanel();
        labelImage = new javax.swing.JLabel();
        scrollPaneDetails = new javax.swing.JScrollPane();
        infoContainer = new javax.swing.JPanel();
        commonDetails = new javax.swing.JPanel();
        labelFileDetailsTitle = new javax.swing.JLabel();
        labelFileName = new javax.swing.JLabel();
        labelFileExtentionAndMime = new javax.swing.JLabel();
        labelSize = new javax.swing.JLabel();
        labelPath = new javax.swing.JLabel();
        labelCreatedAt = new javax.swing.JLabel();
        labelModifiedAt = new javax.swing.JLabel();
        labelRWX = new javax.swing.JLabel();
        musicDetails = new javax.swing.JPanel();
        labelMusicDetailsTitle = new javax.swing.JLabel();
        labelTitle = new javax.swing.JLabel();
        labelArtist = new javax.swing.JLabel();
        labelalbumArtist = new javax.swing.JLabel();
        labelAlbum = new javax.swing.JLabel();
        labelGenre = new javax.swing.JLabel();
        labelYear = new javax.swing.JLabel();
        labelTrack = new javax.swing.JLabel();
        labelDisk = new javax.swing.JLabel();
        labelComposer = new javax.swing.JLabel();
        labelComment = new javax.swing.JLabel();
        technicalDetails = new javax.swing.JPanel();
        labelTechnicalDetailsTitle = new javax.swing.JLabel();
        labelDuration = new javax.swing.JLabel();
        labelBitrate = new javax.swing.JLabel();
        labelSampleRate = new javax.swing.JLabel();
        labelChannels = new javax.swing.JLabel();
        labelEncodingType = new javax.swing.JLabel();
        labelFormat = new javax.swing.JLabel();
        labelVariableBitRate = new javax.swing.JLabel();
        labelLossless = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        Container.setLayout(new java.awt.BorderLayout());

        imagePanel.setPreferredSize(new java.awt.Dimension(400, 200));
        imagePanel.setLayout(new java.awt.BorderLayout());

        labelImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagePanel.add(labelImage, java.awt.BorderLayout.CENTER);

        Container.add(imagePanel, java.awt.BorderLayout.NORTH);

        infoContainer.setLayout(new javax.swing.BoxLayout(infoContainer, javax.swing.BoxLayout.Y_AXIS));

        commonDetails.setLayout(new javax.swing.BoxLayout(commonDetails, javax.swing.BoxLayout.Y_AXIS));

        labelFileDetailsTitle.setFont(new java.awt.Font("Liberation Sans", 3, 18)); // NOI18N
        labelFileDetailsTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelFileDetailsTitle.setText("File Details:");
        commonDetails.add(labelFileDetailsTitle);

        labelFileName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelFileName.setText("jLabel1");
        commonDetails.add(labelFileName);

        labelFileExtentionAndMime.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelFileExtentionAndMime.setText("jLabel1");
        commonDetails.add(labelFileExtentionAndMime);

        labelSize.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelSize.setText("jLabel1");
        commonDetails.add(labelSize);

        labelPath.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelPath.setText("jLabel1");
        commonDetails.add(labelPath);

        labelCreatedAt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelCreatedAt.setText("jLabel1");
        commonDetails.add(labelCreatedAt);

        labelModifiedAt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelModifiedAt.setText("jLabel1");
        commonDetails.add(labelModifiedAt);

        labelRWX.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelRWX.setText("jLabel1");
        commonDetails.add(labelRWX);

        infoContainer.add(commonDetails);

        musicDetails.setLayout(new javax.swing.BoxLayout(musicDetails, javax.swing.BoxLayout.Y_AXIS));

        labelMusicDetailsTitle.setFont(new java.awt.Font("Liberation Sans", 3, 18)); // NOI18N
        labelMusicDetailsTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelMusicDetailsTitle.setText("Music Details:");
        musicDetails.add(labelMusicDetailsTitle);

        labelTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTitle.setText("jLabel1");
        musicDetails.add(labelTitle);

        labelArtist.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelArtist.setText("jLabel1");
        musicDetails.add(labelArtist);

        labelalbumArtist.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelalbumArtist.setText("jLabel1");
        musicDetails.add(labelalbumArtist);

        labelAlbum.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelAlbum.setText("jLabel1");
        musicDetails.add(labelAlbum);

        labelGenre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelGenre.setText("jLabel1");
        musicDetails.add(labelGenre);

        labelYear.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelYear.setText("jLabel1");
        musicDetails.add(labelYear);

        labelTrack.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTrack.setText("jLabel1");
        musicDetails.add(labelTrack);

        labelDisk.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelDisk.setText("jLabel1");
        musicDetails.add(labelDisk);

        labelComposer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelComposer.setText("jLabel1");
        musicDetails.add(labelComposer);

        labelComment.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelComment.setText("jLabel1");
        musicDetails.add(labelComment);

        infoContainer.add(musicDetails);

        technicalDetails.setLayout(new javax.swing.BoxLayout(technicalDetails, javax.swing.BoxLayout.Y_AXIS));

        labelTechnicalDetailsTitle.setFont(new java.awt.Font("Liberation Sans", 3, 18)); // NOI18N
        labelTechnicalDetailsTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTechnicalDetailsTitle.setText("Technical Details:");
        technicalDetails.add(labelTechnicalDetailsTitle);

        labelDuration.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelDuration.setText("jLabel1");
        technicalDetails.add(labelDuration);

        labelBitrate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelBitrate.setText("jLabel1");
        technicalDetails.add(labelBitrate);

        labelSampleRate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelSampleRate.setText("jLabel1");
        technicalDetails.add(labelSampleRate);

        labelChannels.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelChannels.setText("jLabel1");
        technicalDetails.add(labelChannels);

        labelEncodingType.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelEncodingType.setText("jLabel1");
        technicalDetails.add(labelEncodingType);

        labelFormat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelFormat.setText("jLabel1");
        technicalDetails.add(labelFormat);

        labelVariableBitRate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelVariableBitRate.setText("jLabel1");
        technicalDetails.add(labelVariableBitRate);

        labelLossless.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelLossless.setText("jLabel1");
        technicalDetails.add(labelLossless);

        infoContainer.add(technicalDetails);

        scrollPaneDetails.setViewportView(infoContainer);

        Container.add(scrollPaneDetails, java.awt.BorderLayout.CENTER);

        add(Container, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Container;
    private javax.swing.JPanel commonDetails;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JPanel infoContainer;
    private javax.swing.JLabel labelAlbum;
    private javax.swing.JLabel labelArtist;
    private javax.swing.JLabel labelBitrate;
    private javax.swing.JLabel labelChannels;
    private javax.swing.JLabel labelComment;
    private javax.swing.JLabel labelComposer;
    private javax.swing.JLabel labelCreatedAt;
    private javax.swing.JLabel labelDisk;
    private javax.swing.JLabel labelDuration;
    private javax.swing.JLabel labelEncodingType;
    private javax.swing.JLabel labelFileDetailsTitle;
    private javax.swing.JLabel labelFileExtentionAndMime;
    private javax.swing.JLabel labelFileName;
    private javax.swing.JLabel labelFormat;
    private javax.swing.JLabel labelGenre;
    private javax.swing.JLabel labelImage;
    private javax.swing.JLabel labelLossless;
    private javax.swing.JLabel labelModifiedAt;
    private javax.swing.JLabel labelMusicDetailsTitle;
    private javax.swing.JLabel labelPath;
    private javax.swing.JLabel labelRWX;
    private javax.swing.JLabel labelSampleRate;
    private javax.swing.JLabel labelSize;
    private javax.swing.JLabel labelTechnicalDetailsTitle;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JLabel labelTrack;
    private javax.swing.JLabel labelVariableBitRate;
    private javax.swing.JLabel labelYear;
    private javax.swing.JLabel labelalbumArtist;
    private javax.swing.JPanel musicDetails;
    private javax.swing.JScrollPane scrollPaneDetails;
    private javax.swing.JPanel technicalDetails;
    // End of variables declaration//GEN-END:variables
}
