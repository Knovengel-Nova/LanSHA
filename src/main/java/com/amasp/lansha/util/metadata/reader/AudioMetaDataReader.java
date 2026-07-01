package com.amasp.lansha.util.metadata.reader;

import com.amasp.lansha.util.metadata.AudioMetaData;
import java.io.ByteArrayInputStream;
import java.nio.file.Path;
import javax.imageio.ImageIO;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.images.Artwork;

/**
 *
 * @author knovengel
 */
public class AudioMetaDataReader {

    public static AudioMetaData read(Path path) {

        AudioMetaData audioMetaData = new AudioMetaData(path);

        try {

            AudioFile audioFile = AudioFileIO.read(path.toFile());

            Tag tag = audioFile.getTag();

            if (tag != null) {

                audioMetaData.setTitle(clean(tag.getFirst(FieldKey.TITLE)));
                audioMetaData.setArtist(clean(tag.getFirst(FieldKey.ARTIST)));
                audioMetaData.setAlbumArtist(clean(tag.getFirst(FieldKey.ALBUM_ARTIST)));
                audioMetaData.setAlbum(clean(tag.getFirst(FieldKey.ALBUM)));
                audioMetaData.setGenre(clean(tag.getFirst(FieldKey.GENRE)));
                audioMetaData.setYear(clean(tag.getFirst(FieldKey.YEAR)));
                audioMetaData.setTrack(clean(tag.getFirst(FieldKey.TRACK)));
                audioMetaData.setDisc(clean(tag.getFirst(FieldKey.DISC_NO)));
                audioMetaData.setComposer(clean(tag.getFirst(FieldKey.COMPOSER)));
                audioMetaData.setComment(clean(tag.getFirst(FieldKey.COMMENT)));

                Artwork artwork = tag.getFirstArtwork();

                if (artwork != null) {

                    audioMetaData.setAlbumArt(
                            ImageIO.read(
                                    new ByteArrayInputStream(
                                            artwork.getBinaryData()
                                    )
                            )
                    );

                    audioMetaData.setHasAlbumArt(true);

                } else {

                    audioMetaData.setHasAlbumArt(false);

                }
            }

            AudioHeader header = audioFile.getAudioHeader();

            if (header != null) {

                audioMetaData.setDuration(header.getTrackLength());

                audioMetaData.setBitRate(header.getBitRate());

                audioMetaData.setSampleRate(header.getSampleRate());

                audioMetaData.setChannels(header.getChannels());

                audioMetaData.setEncodingType(header.getEncodingType());

                audioMetaData.setFormat(header.getFormat());

                audioMetaData.setVariableBitRate(header.isVariableBitRate());

                audioMetaData.setLossless(header.isLossless());

            }

            /*
             * If the file has no title tag, use the filename.
             */
            if (audioMetaData.getTitle() == null) {

                audioMetaData.setTitle(audioMetaData.getFileName());

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return audioMetaData;

    }

    /**
     * Converts empty strings to null.
     */
    private static String clean(String value) {

        if (value == null) {
            return null;
        }

        value = value.trim();

        return value.isEmpty() ? null : value;

    }

}
