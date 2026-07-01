package com.amasp.lansha.ui.panels;

import com.amasp.lansha.util.FileUtil;
import com.amasp.lansha.util.metadata.VideoMetaData;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author knovengel
 */
public class VideoPanel extends javax.swing.JPanel {

    private VideoMetaData metaData;

    public VideoPanel() {
        initComponents();

        addPadding(commonDetails);
        addPadding(videoDetails);
        addPadding(technicalDetails);
        addPadding(recordingDetails);
        commonDetails.setBorder(
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        );

        videoDetails.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 10, 15)
        );

        technicalDetails.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 10, 15)
        );

        recordingDetails.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 10, 15)
        );

        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                updateIcon();
            }
        });
    }

    public void setMetaData(VideoMetaData metaData) {
        this.metaData = metaData;
        initUIs();
        updateIcon();
    }

    private void updateIcon() {
        if (metaData == null) {
            return;
        }

        BufferedImage img = metaData.getThumbnail();

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

        /* ---------- Video Details ---------- */
        zLabel(labelWidth,
                metaData.getWidth(),
                "Width");

        zLabel(labelHeight,
                metaData.getHeight(),
                "Height");

        zLabel(labelAspectRatio,
                String.format("%.2f : 1", metaData.getAspectRatio()),
                "Aspect Ratio");

        zLabel(labelDuration,
                FileUtil.formatDuration(metaData.getDuration()),
                "Duration");

        zLabel(labelFps,
                metaData.getFrameRate() == 0
                ? null
                : String.format("%.2f FPS", metaData.getFrameRate()),
                "Frame Rate");

        zLabel(labelContainer,
                metaData.getContainer(),
                "Container");

        /* ---------- Technical Details ---------- */
        zLabel(labelVideoCodec,
                metaData.getVideoCodec(),
                "Video Codec");

        zLabel(labelAudioCodec,
                metaData.getAudioCodec(),
                "Audio Codec");

        zLabel(labelVideoBitRate,
                metaData.getVideoBitRate(),
                "Video Bitrate");

        zLabel(labelAudioBitRate,
                metaData.getAudioBitRate(),
                "Audio Bitrate");

        zLabel(labelSampleRate,
                metaData.getSampleRate(),
                "Sample Rate");

        zLabel(labelChannels,
                metaData.getChannels(),
                "Channels");

        zLabel(labelRotation,
                metaData.getRotation(),
                "Rotation");

        /* ---------- Recording Details ---------- */
        zLabel(labelCameraMake,
                metaData.getCameraMake(),
                "Camera Make");

        zLabel(labelCameraModel,
                metaData.getCameraModel(),
                "Camera Model");

        zLabel(labelSoftware,
                metaData.getSoftware(),
                "Software");

        zLabel(labelDateRecorded,
                metaData.getDateRecorded(),
                "Date Recorded");

        /* ---------- Hide Empty Panels ---------- */
        technicalDetails.setVisible(
                metaData.getVideoCodec() != null
                || metaData.getAudioCodec() != null
                || metaData.getVideoBitRate() != null
                || metaData.getAudioBitRate() != null
                || metaData.getSampleRate() != null
                || metaData.getChannels() != null
                || metaData.getRotation() != null
        );

        recordingDetails.setVisible(
                metaData.hasCameraMetaData()
        );

        updateIcon();
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

        } else if (data instanceof Number number && number.doubleValue() == 0) {

            value = "N/A";

        } else {

            value = data.toString();

            if (value.isBlank()) {
                value = "N/A";
            }

        }

        label.setText(
                "<html><b>" + title + ":</b> " + value + "</html>"
        );

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
        videoDetails = new javax.swing.JPanel();
        labelImageDetailsTitle = new javax.swing.JLabel();
        labelWidth = new javax.swing.JLabel();
        labelHeight = new javax.swing.JLabel();
        labelAspectRatio = new javax.swing.JLabel();
        labelDuration = new javax.swing.JLabel();
        labelFps = new javax.swing.JLabel();
        technicalDetails = new javax.swing.JPanel();
        labelTechnicalDetails = new javax.swing.JLabel();
        labelContainer = new javax.swing.JLabel();
        labelVideoCodec = new javax.swing.JLabel();
        labelAudioCodec = new javax.swing.JLabel();
        labelVideoBitRate = new javax.swing.JLabel();
        labelAudioBitRate = new javax.swing.JLabel();
        labelSampleRate = new javax.swing.JLabel();
        labelChannels = new javax.swing.JLabel();
        labelRotation = new javax.swing.JLabel();
        recordingDetails = new javax.swing.JPanel();
        labelRecordingDetails = new javax.swing.JLabel();
        labelCameraMake = new javax.swing.JLabel();
        labelCameraModel = new javax.swing.JLabel();
        labelSoftware = new javax.swing.JLabel();
        labelDateRecorded = new javax.swing.JLabel();

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

        videoDetails.setLayout(new javax.swing.BoxLayout(videoDetails, javax.swing.BoxLayout.Y_AXIS));

        labelImageDetailsTitle.setFont(new java.awt.Font("Liberation Sans", 3, 18)); // NOI18N
        labelImageDetailsTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelImageDetailsTitle.setText("Video Details:");
        videoDetails.add(labelImageDetailsTitle);

        labelWidth.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelWidth.setText("jLabel1");
        videoDetails.add(labelWidth);

        labelHeight.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelHeight.setText("jLabel1");
        videoDetails.add(labelHeight);

        labelAspectRatio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelAspectRatio.setText("jLabel1");
        videoDetails.add(labelAspectRatio);

        labelDuration.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelDuration.setText("jLabel1");
        videoDetails.add(labelDuration);

        labelFps.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelFps.setText("jLabel1");
        videoDetails.add(labelFps);

        infoContainer.add(videoDetails);

        technicalDetails.setLayout(new javax.swing.BoxLayout(technicalDetails, javax.swing.BoxLayout.Y_AXIS));

        labelTechnicalDetails.setFont(new java.awt.Font("Liberation Sans", 3, 18)); // NOI18N
        labelTechnicalDetails.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTechnicalDetails.setText("Technical Details:");
        technicalDetails.add(labelTechnicalDetails);

        labelContainer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelContainer.setText("jLabel1");
        technicalDetails.add(labelContainer);

        labelVideoCodec.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelVideoCodec.setText("jLabel1");
        technicalDetails.add(labelVideoCodec);

        labelAudioCodec.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelAudioCodec.setText("jLabel1");
        technicalDetails.add(labelAudioCodec);

        labelVideoBitRate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelVideoBitRate.setText("jLabel1");
        technicalDetails.add(labelVideoBitRate);

        labelAudioBitRate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelAudioBitRate.setText("jLabel1");
        technicalDetails.add(labelAudioBitRate);

        labelSampleRate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelSampleRate.setText("jLabel1");
        technicalDetails.add(labelSampleRate);

        labelChannels.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelChannels.setText("jLabel1");
        technicalDetails.add(labelChannels);

        labelRotation.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelRotation.setText("jLabel1");
        technicalDetails.add(labelRotation);

        infoContainer.add(technicalDetails);

        recordingDetails.setLayout(new javax.swing.BoxLayout(recordingDetails, javax.swing.BoxLayout.Y_AXIS));

        labelRecordingDetails.setFont(new java.awt.Font("Liberation Sans", 3, 18)); // NOI18N
        labelRecordingDetails.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelRecordingDetails.setText("Recording Details:");
        recordingDetails.add(labelRecordingDetails);

        labelCameraMake.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelCameraMake.setText("jLabel1");
        recordingDetails.add(labelCameraMake);

        labelCameraModel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelCameraModel.setText("jLabel1");
        recordingDetails.add(labelCameraModel);

        labelSoftware.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelSoftware.setText("jLabel1");
        recordingDetails.add(labelSoftware);

        labelDateRecorded.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelDateRecorded.setText("jLabel1");
        recordingDetails.add(labelDateRecorded);

        infoContainer.add(recordingDetails);

        scrollPaneDetails.setViewportView(infoContainer);

        Container.add(scrollPaneDetails, java.awt.BorderLayout.CENTER);

        add(Container, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Container;
    private javax.swing.JPanel commonDetails;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JPanel infoContainer;
    private javax.swing.JLabel labelAspectRatio;
    private javax.swing.JLabel labelAudioBitRate;
    private javax.swing.JLabel labelAudioCodec;
    private javax.swing.JLabel labelCameraMake;
    private javax.swing.JLabel labelCameraModel;
    private javax.swing.JLabel labelChannels;
    private javax.swing.JLabel labelContainer;
    private javax.swing.JLabel labelCreatedAt;
    private javax.swing.JLabel labelDateRecorded;
    private javax.swing.JLabel labelDuration;
    private javax.swing.JLabel labelFileDetailsTitle;
    private javax.swing.JLabel labelFileExtentionAndMime;
    private javax.swing.JLabel labelFileName;
    private javax.swing.JLabel labelFps;
    private javax.swing.JLabel labelHeight;
    private javax.swing.JLabel labelImage;
    private javax.swing.JLabel labelImageDetailsTitle;
    private javax.swing.JLabel labelModifiedAt;
    private javax.swing.JLabel labelPath;
    private javax.swing.JLabel labelRWX;
    private javax.swing.JLabel labelRecordingDetails;
    private javax.swing.JLabel labelRotation;
    private javax.swing.JLabel labelSampleRate;
    private javax.swing.JLabel labelSize;
    private javax.swing.JLabel labelSoftware;
    private javax.swing.JLabel labelTechnicalDetails;
    private javax.swing.JLabel labelVideoBitRate;
    private javax.swing.JLabel labelVideoCodec;
    private javax.swing.JLabel labelWidth;
    private javax.swing.JPanel recordingDetails;
    private javax.swing.JScrollPane scrollPaneDetails;
    private javax.swing.JPanel technicalDetails;
    private javax.swing.JPanel videoDetails;
    // End of variables declaration//GEN-END:variables
}
