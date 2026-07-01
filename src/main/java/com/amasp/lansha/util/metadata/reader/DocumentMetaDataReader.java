package com.amasp.lansha.util.metadata.reader;

import com.amasp.lansha.util.metadata.DocumentMetaData;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;

public class DocumentMetaDataReader {

    public static DocumentMetaData read(Path path) {

        DocumentMetaData metaData = new DocumentMetaData(path);

        try {

            AutoDetectParser parser = new AutoDetectParser();
            Metadata metadata = new Metadata();
            ContentHandler handler = new BodyContentHandler(-1);
            ParseContext context = new ParseContext();

            try (InputStream is = Files.newInputStream(path)) {
                parser.parse(is, handler, metadata, context);
            }

            /* ---------- General ---------- */
            metaData.setTitle(metadata.get(TikaCoreProperties.TITLE));
            metaData.setAuthor(metadata.get(TikaCoreProperties.CREATOR));
            metaData.setSubject(metadata.get(TikaCoreProperties.SUBJECT));
            metaData.setKeywords(metadata.get("Keywords"));
            metaData.setLanguage(metadata.get(TikaCoreProperties.LANGUAGE));
            metaData.setDescription(metadata.get(TikaCoreProperties.DESCRIPTION));

            /* ---------- Statistics ---------- */
            metaData.setPageCount(
                    parseInteger(metadata.get("xmpTPg:NPages")));

            metaData.setWordCount(
                    parseInteger(metadata.get("meta:word-count")));

            metaData.setCharacterCount(
                    parseInteger(metadata.get("meta:character-count")));

            metaData.setLineCount(
                    parseInteger(metadata.get("meta:line-count")));

            metaData.setParagraphCount(
                    parseInteger(metadata.get("meta:paragraph-count")));

            /* ---------- Technical ---------- */
            metaData.setApplication(
                    metadata.get("Application-Name"));

            metaData.setCreator(
                    metadata.get("creator"));

            metaData.setProducer(
                    metadata.get("producer"));

            metaData.setCompany(
                    metadata.get("Company"));

            metaData.setVersion(
                    metadata.get("pdf:PDFVersion"));

            String encrypted = metadata.get("pdf:encrypted");

            if (encrypted != null) {
                metaData.setEncrypted(Boolean.parseBoolean(encrypted));
            }

            /* ---------- Preview ---------- */
            // PDF preview can be added later using PDFBox.
            // DOCX/PPTX/XLSX previews are intentionally left null.
            BufferedImage preview = null;
            metaData.setPreview(preview);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return metaData;
    }

    private static Integer parseInteger(String value) {

        if (value == null || value.isBlank()) {
            return null;
        }

        try {
            return Integer.parseInt(value.trim());
        } catch (Exception e) {
            return null;
        }
    }
}
