package com.amasp.lansha.ui.panels;

import com.amasp.lansha.util.FileUtil;
import com.amasp.lansha.util.metadata.DocumentMetaData;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author knovengel
 */
public class DocumentPanel extends javax.swing.JPanel {

    private DocumentMetaData metaData;

    public DocumentPanel() {
        initComponents();

        addPadding(commonDetails);
        addPadding(documentDetails);
        addPadding(technicalDetails);
        addPadding(statsDetails);
        commonDetails.setBorder(
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        );

        documentDetails.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 10, 15)
        );

        technicalDetails.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 10, 15)
        );

        statsDetails.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 10, 15)
        );

        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                updateIcon();
            }
        });
    }

    public void setMetaData(DocumentMetaData metaData) {
        this.metaData = metaData;
        initUIs();
        updateIcon();
    }

    private void updateIcon() {
        if (metaData == null) {
            return;
        }

        BufferedImage img = metaData.getPreview();

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


        /* ---------- Document Details ---------- */
        zLabel(labelTitle,
                metaData.getTitle(),
                "Title");

        zLabel(labelAuthor,
                metaData.getAuthor(),
                "Author");

        zLabel(labelSubject,
                metaData.getSubject(),
                "Subject");

        zLabel(labelKeywords,
                metaData.getKeywords(),
                "Keywords");

        zLabel(labelLanguage,
                metaData.getLanguage(),
                "Language");

        zLabel(labelDescription,
                metaData.getDescription(),
                "Description");


        /* ---------- Statistics ---------- */
        zLabel(labelPageCount,
                metaData.getPageCount(),
                "Pages");

        zLabel(labelWordCount,
                metaData.getWordCount(),
                "Words");

        zLabel(labelCharacterCount,
                metaData.getCharacterCount(),
                "Characters");

        zLabel(labelLineCount,
                metaData.getLineCount(),
                "Lines");

        zLabel(labelParagraphCount,
                metaData.getParagraphCount(),
                "Paragraphs");


        /* ---------- Technical ---------- */
        zLabel(labelApplication,
                metaData.getApplication(),
                "Application");

        zLabel(labelCreator,
                metaData.getCreator(),
                "Creator");

        zLabel(labelProducer,
                metaData.getProducer(),
                "Producer");

        zLabel(labelCompany,
                metaData.getCompany(),
                "Company");

        zLabel(labelVersion,
                metaData.getVersion(),
                "Version");

        zLabel(labelEncrypted,
                metaData.getEncrypted(),
                "Encrypted");


        /* ---------- Hide Empty Sections ---------- */
        if (!metaData.hasDocumentMetaData()) {

            documentDetails.setVisible(false);

        } else {

            documentDetails.setVisible(true);

        }

        if (metaData.getPageCount() == null
                && metaData.getWordCount() == null
                && metaData.getCharacterCount() == null
                && metaData.getLineCount() == null
                && metaData.getParagraphCount() == null) {

            statsDetails.setVisible(false);

        } else {

            statsDetails.setVisible(true);

        }

        if (metaData.getApplication() == null
                && metaData.getCreator() == null
                && metaData.getProducer() == null
                && metaData.getCompany() == null
                && metaData.getVersion() == null
                && metaData.getEncrypted() == null) {

            technicalDetails.setVisible(false);

        } else {

            technicalDetails.setVisible(true);

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

        } else if (data instanceof Boolean b) {

            value = b ? "Yes" : "No";

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
        documentDetails = new javax.swing.JPanel();
        labelDocumentDetails = new javax.swing.JLabel();
        labelTitle = new javax.swing.JLabel();
        labelAuthor = new javax.swing.JLabel();
        labelSubject = new javax.swing.JLabel();
        labelKeywords = new javax.swing.JLabel();
        labelLanguage = new javax.swing.JLabel();
        labelDescription = new javax.swing.JLabel();
        statsDetails = new javax.swing.JPanel();
        labelStatsDetails = new javax.swing.JLabel();
        labelPageCount = new javax.swing.JLabel();
        labelWordCount = new javax.swing.JLabel();
        labelCharacterCount = new javax.swing.JLabel();
        labelLineCount = new javax.swing.JLabel();
        labelParagraphCount = new javax.swing.JLabel();
        technicalDetails = new javax.swing.JPanel();
        labelTechnicalDetails = new javax.swing.JLabel();
        labelApplication = new javax.swing.JLabel();
        labelCreator = new javax.swing.JLabel();
        labelProducer = new javax.swing.JLabel();
        labelCompany = new javax.swing.JLabel();
        labelVersion = new javax.swing.JLabel();
        labelEncrypted = new javax.swing.JLabel();

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

        documentDetails.setLayout(new javax.swing.BoxLayout(documentDetails, javax.swing.BoxLayout.Y_AXIS));

        labelDocumentDetails.setFont(new java.awt.Font("Liberation Sans", 3, 18)); // NOI18N
        labelDocumentDetails.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelDocumentDetails.setText("Document Details:");
        documentDetails.add(labelDocumentDetails);

        labelTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTitle.setText("jLabel1");
        documentDetails.add(labelTitle);

        labelAuthor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelAuthor.setText("jLabel1");
        documentDetails.add(labelAuthor);

        labelSubject.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelSubject.setText("jLabel1");
        documentDetails.add(labelSubject);

        labelKeywords.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelKeywords.setText("jLabel1");
        documentDetails.add(labelKeywords);

        labelLanguage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelLanguage.setText("jLabel1");
        documentDetails.add(labelLanguage);

        labelDescription.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelDescription.setText("jLabel1");
        documentDetails.add(labelDescription);

        infoContainer.add(documentDetails);

        statsDetails.setLayout(new javax.swing.BoxLayout(statsDetails, javax.swing.BoxLayout.Y_AXIS));

        labelStatsDetails.setFont(new java.awt.Font("Liberation Sans", 3, 18)); // NOI18N
        labelStatsDetails.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelStatsDetails.setText("Statistics:");
        statsDetails.add(labelStatsDetails);

        labelPageCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelPageCount.setText("jLabel1");
        statsDetails.add(labelPageCount);

        labelWordCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelWordCount.setText("jLabel1");
        statsDetails.add(labelWordCount);

        labelCharacterCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelCharacterCount.setText("jLabel1");
        statsDetails.add(labelCharacterCount);

        labelLineCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelLineCount.setText("jLabel1");
        statsDetails.add(labelLineCount);

        labelParagraphCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelParagraphCount.setText("jLabel1");
        statsDetails.add(labelParagraphCount);

        infoContainer.add(statsDetails);

        technicalDetails.setLayout(new javax.swing.BoxLayout(technicalDetails, javax.swing.BoxLayout.Y_AXIS));

        labelTechnicalDetails.setFont(new java.awt.Font("Liberation Sans", 3, 18)); // NOI18N
        labelTechnicalDetails.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTechnicalDetails.setText("Technical Details:");
        technicalDetails.add(labelTechnicalDetails);

        labelApplication.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelApplication.setText("jLabel1");
        technicalDetails.add(labelApplication);

        labelCreator.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelCreator.setText("jLabel1");
        technicalDetails.add(labelCreator);

        labelProducer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelProducer.setText("jLabel1");
        technicalDetails.add(labelProducer);

        labelCompany.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelCompany.setText("jLabel1");
        technicalDetails.add(labelCompany);

        labelVersion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelVersion.setText("jLabel1");
        technicalDetails.add(labelVersion);

        labelEncrypted.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelEncrypted.setText("jLabel1");
        technicalDetails.add(labelEncrypted);

        infoContainer.add(technicalDetails);

        scrollPaneDetails.setViewportView(infoContainer);

        Container.add(scrollPaneDetails, java.awt.BorderLayout.CENTER);

        add(Container, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Container;
    private javax.swing.JPanel commonDetails;
    private javax.swing.JPanel documentDetails;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JPanel infoContainer;
    private javax.swing.JLabel labelApplication;
    private javax.swing.JLabel labelAuthor;
    private javax.swing.JLabel labelCharacterCount;
    private javax.swing.JLabel labelCompany;
    private javax.swing.JLabel labelCreatedAt;
    private javax.swing.JLabel labelCreator;
    private javax.swing.JLabel labelDescription;
    private javax.swing.JLabel labelDocumentDetails;
    private javax.swing.JLabel labelEncrypted;
    private javax.swing.JLabel labelFileDetailsTitle;
    private javax.swing.JLabel labelFileExtentionAndMime;
    private javax.swing.JLabel labelFileName;
    private javax.swing.JLabel labelImage;
    private javax.swing.JLabel labelKeywords;
    private javax.swing.JLabel labelLanguage;
    private javax.swing.JLabel labelLineCount;
    private javax.swing.JLabel labelModifiedAt;
    private javax.swing.JLabel labelPageCount;
    private javax.swing.JLabel labelParagraphCount;
    private javax.swing.JLabel labelPath;
    private javax.swing.JLabel labelProducer;
    private javax.swing.JLabel labelRWX;
    private javax.swing.JLabel labelSize;
    private javax.swing.JLabel labelStatsDetails;
    private javax.swing.JLabel labelSubject;
    private javax.swing.JLabel labelTechnicalDetails;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JLabel labelVersion;
    private javax.swing.JLabel labelWordCount;
    private javax.swing.JScrollPane scrollPaneDetails;
    private javax.swing.JPanel statsDetails;
    private javax.swing.JPanel technicalDetails;
    // End of variables declaration//GEN-END:variables
}
