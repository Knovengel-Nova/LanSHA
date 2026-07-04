package com.amasp.lansha.util.metadata.reader;

import com.amasp.lansha.util.metadata.VideoMetaData;
import java.awt.image.BufferedImage;
import java.nio.file.Path;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.jcodec.api.FrameGrab;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.model.Picture;
import org.jcodec.scale.AWTUtil;
import org.xml.sax.ContentHandler;

public class VideoMetaDataReader {

    public static VideoMetaData read(Path path) {

        VideoMetaData metaData = new VideoMetaData(path);

        readThumbnail(metaData);
        readTikaMetadata(metaData);

        return metaData;
    }

    private static void readThumbnail(VideoMetaData metaData) {

        try {

            FrameGrab grab = FrameGrab.createFrameGrab(
                    NIOUtils.readableChannel(metaData.getPath().toFile()));

            Picture picture = grab.getNativeFrame();

            if (picture != null) {

                BufferedImage img = AWTUtil.toBufferedImage(picture);

                metaData.setThumbnail(img);
                metaData.setWidth(img.getWidth());
                metaData.setHeight(img.getHeight());
            }

        } catch (Exception e) {
            // Ignore. Thumbnail is optional.
        }

    }

    private static void readTikaMetadata(VideoMetaData metaData) {

        try {

            AutoDetectParser parser = new AutoDetectParser();

            Metadata metadata = new Metadata();

            ContentHandler handler = new BodyContentHandler();

            ParseContext context = new ParseContext();

            parser.parse(
                    java.nio.file.Files.newInputStream(metaData.getPath()),
                    handler,
                    metadata,
                    context);

            metaData.setContainer(metadata.get("Content-Type"));

            metaData.setVideoCodec(first(
                    metadata.get("xmpDM:videoCompressor"),
                    metadata.get("Video Codec")));

            metaData.setAudioCodec(first(
                    metadata.get("xmpDM:audioCompressor"),
                    metadata.get("Audio Codec")));

            metaData.setDuration(parseDuration(
                    metadata.get("xmpDM:duration")));

            metaData.setFrameRate(parseDouble(
                    metadata.get("xmpDM:videoFrameRate")));

            metaData.setVideoBitRate(first(
                    metadata.get("xmpDM:videoBitrate"),
                    metadata.get("Video Bitrate")));

            metaData.setAudioBitRate(first(
                    metadata.get("xmpDM:audioBitrate"),
                    metadata.get("Audio Bitrate")));

            metaData.setSampleRate(first(
                    metadata.get("xmpDM:audioSampleRate"),
                    metadata.get("Sample Rate")));

            metaData.setChannels(first(
                    metadata.get("channels"),
                    metadata.get("Audio Channels")));

            metaData.setRotation(first(
                    metadata.get("Rotation"),
                    metadata.get("tiff:Orientation")));

            metaData.setCameraMake(metadata.get("tiff:Make"));
            metaData.setCameraModel(metadata.get("tiff:Model"));
            metaData.setSoftware(metadata.get("tiff:Software"));

            String date = metadata.get(TikaCoreProperties.CREATED);

            if (date == null) {
                date = metadata.get("Creation-Date");
            }

            metaData.setDateRecorded(date);

        } catch (Exception e) {
            // Ignore metadata failures.
        }

    }

    private static String first(String... values) {

        for (String s : values) {

            if (s != null && !s.isBlank()) {
                return s;
            }

        }

        return null;
    }

    private static double parseDouble(String value) {

        if (value == null || value.isBlank()) {
            return 0;
        }

        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0;
        }

    }

    private static double parseDuration(String value) {

        if (value == null || value.isBlank()) {
            return 0;
        }

        try {

            return Double.parseDouble(value) / 1000.0;

        } catch (NumberFormatException e) {

            return 0;

        }

    }
    
    public static BufferedImage getThumbnail(Path path){
        BufferedImage image = null;
        
        try {

            FrameGrab grab = FrameGrab.createFrameGrab(
                    NIOUtils.readableChannel(path.toFile()));

            Picture picture = grab.getNativeFrame();

            if (picture != null) {

                image = AWTUtil.toBufferedImage(picture);
            }

        } catch (Exception e) {
            // Ignore. Thumbnail is optional.
        }
        
        return image;
    }

}
