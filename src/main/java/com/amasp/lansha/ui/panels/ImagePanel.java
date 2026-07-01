package com.amasp.lansha.ui.panels;

import com.amasp.lansha.util.FileUtil;
import com.amasp.lansha.util.metadata.ImageMetaData;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author knovengel
 */
public class ImagePanel extends javax.swing.JPanel {

    private ImageMetaData metaData;

    public ImagePanel() {
        initComponents();

        addPadding(commonDetails);
        addPadding(imageDetails);
        addPadding(cameraDetails1);
        addPadding(gpsDetails);
        commonDetails.setBorder(
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        );

        imageDetails.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 10, 15)
        );

        cameraDetails1.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 10, 15)
        );

        gpsDetails.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 10, 15)
        );

        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                updateIcon();
            }
        });
    }

    public void setMetaData(ImageMetaData metaData) {
        this.metaData = metaData;
        initUIs();
        updateIcon();
    }

    private void updateIcon() {
        if (metaData == null) {
            return;
        }

        BufferedImage img = metaData.getImage();

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


        /* ---------- Image Details ---------- */
        zLabel(labelWidth,
                metaData.getWidth(),
                "Width");

        zLabel(labelHeight,
                metaData.getHeight(),
                "Height");

        zLabel(labelAspectRatio,
                String.format("%.2f : 1", metaData.getAspectRatio()),
                "Aspect Ratio");

        zLabel(labelHasAlpha,
                metaData.isHasAlpha() ? "Yes" : "No",
                "Alpha Channel");

        zLabel(labelColorComponents,
                metaData.getColorComponents(),
                "Color Components");

        zLabel(labelBitsPerPx,
                metaData.getBitsPerPixel(),
                "Bits / Pixel");


        /* ---------- Camera Details ---------- */
        zLabel(labelCameraMake,
                metaData.getCameraMake(),
                "Camera Make");

        zLabel(labelCameraModel,
                metaData.getCameraModel(),
                "Camera Model");

        zLabel(labelLensModel,
                metaData.getLensModel(),
                "Lens");

        zLabel(labelDateTaken,
                metaData.getDateTaken(),
                "Date Taken");

        zLabel(labelExposureTime,
                metaData.getExposureTime(),
                "Exposure");

        zLabel(labelShutterSpeed,
                metaData.getShutterSpeed(),
                "Shutter Speed");

        zLabel(labelAperture,
                metaData.getAperture(),
                "Aperture");

        zLabel(labelIso,
                metaData.getIso() == 0 ? null : metaData.getIso(),
                "ISO");

        zLabel(labelFocalLength,
                metaData.getFocalLength(),
                "Focal Length");

        zLabel(labelWb,
                metaData.getWhiteBalance(),
                "White Balance");


        /* ---------- GPS ---------- */
        zLabel(labelLatitude,
                metaData.getLatitude(),
                "Latitude");

        zLabel(labelLongitude,
                metaData.getLongitude(),
                "Longitude");

        zLabel(labelAltitude,
                metaData.getAltitude(),
                "Altitude");

        zLabel(labelOrientation,
                metaData.getOrientation() == 0 ? null : metaData.getOrientation(),
                "Orientation");

        if (metaData.getCameraModel() == null
                && metaData.getCameraMake() == null
                && metaData.getLensModel() == null) {

            cameraDetails1.setVisible(false);

        } else {

            cameraDetails1.setVisible(true);

        }

        if (metaData.getLatitude() == null
                && metaData.getLongitude() == null) {

            gpsDetails.setVisible(false);

        } else {

            gpsDetails.setVisible(true);

        }
    }

//    private void zLabel(JLabel label, Object data, String placeHolder) {
//        String value = (data == null || data.toString().isBlank())
//                ? "N/A"
//                : data.toString();
//
//        label.setText(placeHolder + ": " + value);
//        label.setToolTipText(placeHolder + ": " + value);
//    }
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

        String value = (data == null || data.toString().isBlank())
                ? "N/A"
                : data.toString();

        label.setText(
                "<html><b>" + title + ":</b> " + value + "</html>"
        );

        label.setToolTipText(value);
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
        imageDetails = new javax.swing.JPanel();
        labelImageDetailsTitle = new javax.swing.JLabel();
        labelWidth = new javax.swing.JLabel();
        labelHeight = new javax.swing.JLabel();
        labelAspectRatio = new javax.swing.JLabel();
        labelHasAlpha = new javax.swing.JLabel();
        labelColorComponents = new javax.swing.JLabel();
        labelBitsPerPx = new javax.swing.JLabel();
        cameraDetails1 = new javax.swing.JPanel();
        labelCameraDetailsTitle1 = new javax.swing.JLabel();
        labelCameraMake = new javax.swing.JLabel();
        labelCameraModel = new javax.swing.JLabel();
        labelLensModel = new javax.swing.JLabel();
        labelDateTaken = new javax.swing.JLabel();
        labelExposureTime = new javax.swing.JLabel();
        labelShutterSpeed = new javax.swing.JLabel();
        labelAperture = new javax.swing.JLabel();
        labelIso = new javax.swing.JLabel();
        labelFocalLength = new javax.swing.JLabel();
        labelWb = new javax.swing.JLabel();
        gpsDetails = new javax.swing.JPanel();
        labelGpsDetailsTitle = new javax.swing.JLabel();
        labelLatitude = new javax.swing.JLabel();
        labelLongitude = new javax.swing.JLabel();
        labelAltitude = new javax.swing.JLabel();
        labelOrientation = new javax.swing.JLabel();

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

        imageDetails.setLayout(new javax.swing.BoxLayout(imageDetails, javax.swing.BoxLayout.Y_AXIS));

        labelImageDetailsTitle.setFont(new java.awt.Font("Liberation Sans", 3, 18)); // NOI18N
        labelImageDetailsTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelImageDetailsTitle.setText("Image Details:");
        imageDetails.add(labelImageDetailsTitle);

        labelWidth.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelWidth.setText("jLabel1");
        imageDetails.add(labelWidth);

        labelHeight.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelHeight.setText("jLabel1");
        imageDetails.add(labelHeight);

        labelAspectRatio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelAspectRatio.setText("jLabel1");
        imageDetails.add(labelAspectRatio);

        labelHasAlpha.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelHasAlpha.setText("jLabel1");
        imageDetails.add(labelHasAlpha);

        labelColorComponents.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelColorComponents.setText("jLabel1");
        imageDetails.add(labelColorComponents);

        labelBitsPerPx.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelBitsPerPx.setText("jLabel1");
        imageDetails.add(labelBitsPerPx);

        infoContainer.add(imageDetails);

        cameraDetails1.setLayout(new javax.swing.BoxLayout(cameraDetails1, javax.swing.BoxLayout.Y_AXIS));

        labelCameraDetailsTitle1.setFont(new java.awt.Font("Liberation Sans", 3, 18)); // NOI18N
        labelCameraDetailsTitle1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelCameraDetailsTitle1.setText("Camera Details:");
        cameraDetails1.add(labelCameraDetailsTitle1);

        labelCameraMake.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelCameraMake.setText("jLabel1");
        cameraDetails1.add(labelCameraMake);

        labelCameraModel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelCameraModel.setText("jLabel1");
        cameraDetails1.add(labelCameraModel);

        labelLensModel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelLensModel.setText("jLabel1");
        cameraDetails1.add(labelLensModel);

        labelDateTaken.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelDateTaken.setText("jLabel1");
        cameraDetails1.add(labelDateTaken);

        labelExposureTime.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelExposureTime.setText("jLabel1");
        cameraDetails1.add(labelExposureTime);

        labelShutterSpeed.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelShutterSpeed.setText("jLabel1");
        cameraDetails1.add(labelShutterSpeed);

        labelAperture.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelAperture.setText("jLabel1");
        cameraDetails1.add(labelAperture);

        labelIso.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelIso.setText("jLabel1");
        cameraDetails1.add(labelIso);

        labelFocalLength.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelFocalLength.setText("jLabel1");
        cameraDetails1.add(labelFocalLength);

        labelWb.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelWb.setText("jLabel1");
        cameraDetails1.add(labelWb);

        infoContainer.add(cameraDetails1);

        gpsDetails.setLayout(new javax.swing.BoxLayout(gpsDetails, javax.swing.BoxLayout.Y_AXIS));

        labelGpsDetailsTitle.setFont(new java.awt.Font("Liberation Sans", 3, 18)); // NOI18N
        labelGpsDetailsTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelGpsDetailsTitle.setText("GPS Details:");
        gpsDetails.add(labelGpsDetailsTitle);

        labelLatitude.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelLatitude.setText("jLabel1");
        gpsDetails.add(labelLatitude);

        labelLongitude.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelLongitude.setText("jLabel1");
        gpsDetails.add(labelLongitude);

        labelAltitude.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelAltitude.setText("jLabel1");
        gpsDetails.add(labelAltitude);

        labelOrientation.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelOrientation.setText("jLabel1");
        gpsDetails.add(labelOrientation);

        infoContainer.add(gpsDetails);

        scrollPaneDetails.setViewportView(infoContainer);

        Container.add(scrollPaneDetails, java.awt.BorderLayout.CENTER);

        add(Container, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Container;
    private javax.swing.JPanel cameraDetails1;
    private javax.swing.JPanel commonDetails;
    private javax.swing.JPanel gpsDetails;
    private javax.swing.JPanel imageDetails;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JPanel infoContainer;
    private javax.swing.JLabel labelAltitude;
    private javax.swing.JLabel labelAperture;
    private javax.swing.JLabel labelAspectRatio;
    private javax.swing.JLabel labelBitsPerPx;
    private javax.swing.JLabel labelCameraDetailsTitle1;
    private javax.swing.JLabel labelCameraMake;
    private javax.swing.JLabel labelCameraModel;
    private javax.swing.JLabel labelColorComponents;
    private javax.swing.JLabel labelCreatedAt;
    private javax.swing.JLabel labelDateTaken;
    private javax.swing.JLabel labelExposureTime;
    private javax.swing.JLabel labelFileDetailsTitle;
    private javax.swing.JLabel labelFileExtentionAndMime;
    private javax.swing.JLabel labelFileName;
    private javax.swing.JLabel labelFocalLength;
    private javax.swing.JLabel labelGpsDetailsTitle;
    private javax.swing.JLabel labelHasAlpha;
    private javax.swing.JLabel labelHeight;
    private javax.swing.JLabel labelImage;
    private javax.swing.JLabel labelImageDetailsTitle;
    private javax.swing.JLabel labelIso;
    private javax.swing.JLabel labelLatitude;
    private javax.swing.JLabel labelLensModel;
    private javax.swing.JLabel labelLongitude;
    private javax.swing.JLabel labelModifiedAt;
    private javax.swing.JLabel labelOrientation;
    private javax.swing.JLabel labelPath;
    private javax.swing.JLabel labelRWX;
    private javax.swing.JLabel labelShutterSpeed;
    private javax.swing.JLabel labelSize;
    private javax.swing.JLabel labelWb;
    private javax.swing.JLabel labelWidth;
    private javax.swing.JScrollPane scrollPaneDetails;
    // End of variables declaration//GEN-END:variables
}
