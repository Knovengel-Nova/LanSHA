package com.amasp.lansha.util.metadata;

import java.awt.image.BufferedImage;
import java.nio.file.Path;

/**
 *
 * @author knovengel
 */
public class VideoMetaData extends FileMetaData {

    /* ---------- Preview ---------- */
    private BufferedImage thumbnail;

    /* ---------- Video Details ---------- */
    private int width;
    private int height;
    private double aspectRatio;
    private double duration;          // seconds
    private double frameRate;

    /* ---------- Technical ---------- */
    private String container;   
    private String videoCodec;
    private String audioCodec;
    private String videoBitRate;
    private String audioBitRate;
    private String sampleRate;
    private String channels;
    private String rotation;

    /* ---------- Optional Recording Metadata ---------- */
    private String cameraMake;
    private String cameraModel;
    private String software;
    private String dateRecorded;

    public VideoMetaData(Path path) {
        super(path);
    }

    /* ---------- Helper Methods ---------- */
    public boolean hasCameraMetaData() {
        return cameraMake != null
                || cameraModel != null
                || dateRecorded != null;
    }

    /* ---------- Getters / Setters ---------- */
    public BufferedImage getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(BufferedImage thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
        updateAspectRatio();
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
        updateAspectRatio();
    }

    public double getAspectRatio() {
        return aspectRatio;
    }

    private void updateAspectRatio() {
        if (height > 0) {
            aspectRatio = (double) width / height;
        }
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(double frameRate) {
        this.frameRate = frameRate;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getVideoCodec() {
        return videoCodec;
    }

    public void setVideoCodec(String videoCodec) {
        this.videoCodec = videoCodec;
    }

    public String getAudioCodec() {
        return audioCodec;
    }

    public void setAudioCodec(String audioCodec) {
        this.audioCodec = audioCodec;
    }

    public String getVideoBitRate() {
        return videoBitRate;
    }

    public void setVideoBitRate(String videoBitRate) {
        this.videoBitRate = videoBitRate;
    }

    public String getAudioBitRate() {
        return audioBitRate;
    }

    public void setAudioBitRate(String audioBitRate) {
        this.audioBitRate = audioBitRate;
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

    public String getRotation() {
        return rotation;
    }

    public void setRotation(String rotation) {
        this.rotation = rotation;
    }

    public String getCameraMake() {
        return cameraMake;
    }

    public void setCameraMake(String cameraMake) {
        this.cameraMake = cameraMake;
    }

    public String getCameraModel() {
        return cameraModel;
    }
    
    public String getSoftware(){
        return software;
    }
    
    public void setSoftware(String software){
        this.software = software;
    }

    public void setCameraModel(String cameraModel) {
        this.cameraModel = cameraModel;
    }

    public String getDateRecorded() {
        return dateRecorded;
    }

    public void setDateRecorded(String dateRecorded) {
        this.dateRecorded = dateRecorded;
    }

}
