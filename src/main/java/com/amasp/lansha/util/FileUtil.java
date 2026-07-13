package com.amasp.lansha.util;

import com.amasp.lansha.util.metadata.DocumentType;
import com.amasp.lansha.util.metadata.FileMetaData;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.attribute.FileTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;

/**
 *
 * @author knovengel
 */
public class FileUtil {

    public static DocumentType getDocumentType(FileMetaData metaData) {

        String mime = metaData.getMimeType();

        if (mime == null) {
            return DocumentType.OTHER;
        }

        switch (mime) {

            case "application/pdf":
                return DocumentType.PDF;

            case "application/msword":
            case "application/vnd.openxmlformats-officedocument.wordprocessingml.document":
                return DocumentType.WORD;

            case "application/vnd.ms-excel":
            case "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet":
                return DocumentType.EXCEL;

            case "application/vnd.ms-powerpoint":
            case "application/vnd.openxmlformats-officedocument.presentationml.presentation":
                return DocumentType.POWERPOINT;

            case "application/vnd.oasis.opendocument.text":
            case "application/vnd.oasis.opendocument.spreadsheet":
            case "application/vnd.oasis.opendocument.presentation":
                return DocumentType.OPENDOCUMENT;

            default:

                if (mime.startsWith("text/")) {
                    return DocumentType.TEXT;
                }

                return DocumentType.OTHER;
        }
    }
    
    public static byte[] getPreviewBytes(BufferedImage img){
        byte[] preview;
        if (img == null) {
            preview = null;
        }

        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ImageIO.write(img, "png", out);
            preview = out.toByteArray();
        } catch (IOException e) {
            preview = null;
        }
        
        return preview;
    }

    public static String formatSize(long bytes) {
        if (bytes < 0) {
            throw new IllegalArgumentException("Size cannot be negative.");
        }

        if (bytes < 1024) {
            return bytes + " B";
        }

        final String[] units = {"KB", "MB", "GB", "TB", "PB"};
        double size = bytes;
        int unitIndex = -1;

        do {
            size /= 1024.0;
            unitIndex++;
        } while (size >= 1024 && unitIndex < units.length - 1);

        return String.format("%.2f %s", size, units[unitIndex]);
    }

    public static String formatTime(FileTime time) {
        return DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm")
                .format(time.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime());
    }

    public static String formatDuration(double seconds) {

        int totalSeconds = (int) Math.round(seconds);

        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int secs = totalSeconds % 60;

        if (hours > 0) {
            return String.format("%dh %02dm %02ds", hours, minutes, secs);
        }

        if (minutes > 0) {
            return String.format("%dm %02ds", minutes, secs);
        }

        return secs + " s";
    }

    public static String formatDuration(int seconds) {

        int hrs = seconds / 3600;
        int mins = (seconds % 3600) / 60;
        int secs = seconds % 60;

        if (hrs > 0) {
            return String.format("%d:%02d:%02d", hrs, mins, secs);
        }

        return String.format("%d:%02d", mins, secs);

    }

    public static String formatResolution(int width, int height) {
        return width + " × " + height;
    }
}
