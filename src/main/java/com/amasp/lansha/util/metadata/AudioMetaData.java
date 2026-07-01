package com.amasp.lansha.util.metadata;

import java.awt.image.BufferedImage;
import java.nio.file.Path;

/**
 *
 * @author knovengel
 */
public class AudioMetaData extends FileMetaData {

    /* ---------- Music Tags ---------- */
    private String title;
    private String artist;
    private String albumArtist;
    private String album;
    private String genre;
    private String year;
    private String track;
    private String disc;
    private String composer;
    private String comment;

    /* ---------- Technical ---------- */
    private int duration;                 // seconds
    private String bitRate;
    private String sampleRate;
    private String channels;
    private String encodingType;
    private String format;
    private boolean variableBitRate;
    private boolean lossless;

    /* ---------- Artwork ---------- */
    private boolean hasAlbumArt;
    private BufferedImage albumArt;

    public AudioMetaData(Path path) {
        super(path);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbumArtist() {
        return albumArtist;
    }

    public void setAlbumArtist(String albumArtist) {
        this.albumArtist = albumArtist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getBitRate() {
        return bitRate;
    }

    public void setBitRate(String bitRate) {
        this.bitRate = bitRate;
    }

    public String getSampleRate() {
        return sampleRate;
    }

    public void setSampleRate(String sampleRate) {
        this.sampleRate = sampleRate;
    }

    public String getChannels() {
        return channels;
    }

    public void setChannels(String channels) {
        this.channels = channels;
    }

    public String getEncodingType() {
        return encodingType;
    }

    public void setEncodingType(String encodingType) {
        this.encodingType = encodingType;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public boolean isVariableBitRate() {
        return variableBitRate;
    }

    public void setVariableBitRate(boolean variableBitRate) {
        this.variableBitRate = variableBitRate;
    }

    public boolean isLossless() {
        return lossless;
    }

    public void setLossless(boolean lossless) {
        this.lossless = lossless;
    }

    public boolean isHasAlbumArt() {
        return hasAlbumArt;
    }

    public void setHasAlbumArt(boolean hasAlbumArt) {
        this.hasAlbumArt = hasAlbumArt;
    }

    public BufferedImage getAlbumArt() {
        return albumArt;
    }

    public void setAlbumArt(BufferedImage albumArt) {
        this.albumArt = albumArt;
    }

    public boolean hasMusicTags() {
        return title != null
                || artist != null
                || album != null
                || albumArtist != null
                || genre != null
                || composer != null
                || year != null;
    }
}
