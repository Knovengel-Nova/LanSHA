package com.amasp.lansha.util.metadata;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author knovengel
 */
public class ImageMetaData extends FileMetaData {

    private ImageIcon preview;
    private BufferedImage image;

    
    private int width;
    private int height;
    private double aspectRatio;

    private boolean hasAlpha;
    private int colorComponents;
    private int bitsPerPixel;
//    private String colorModel;

    
    private String cameraMake;
    private String cameraModel;
    private String lensModel;
    private String software;

    private String dateTaken;

    private String exposureTime;
    private String shutterSpeed;
    private String aperture;
    private int iso;
    private String focalLength;
    private String flash;
    private String whiteBalance;
    

    private Double latitude;
    private Double longitude;
    private Double altitude;

    private int orientation;

    public ImageMetaData(Path selectedFile) {
        super(selectedFile);

        try {
            image = ImageIO.read(getPath().toFile());

            if (image != null) {

                preview = new ImageIcon(image);

                width = image.getWidth();
                height = image.getHeight();

                aspectRatio = (double) width / height;

                hasAlpha = image.getColorModel().hasAlpha();
                colorComponents = image.getColorModel().getNumColorComponents();
                bitsPerPixel = image.getColorModel().getPixelSize();
//                colorModel = image.getColorModel().toString();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ImageIcon getPreview() {
        return preview;
    }

    public void setPreview(ImageIcon preview) {
        this.preview = preview;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(double aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public boolean isHasAlpha() {
        return hasAlpha;
    }

    public void setHasAlpha(boolean hasAlpha) {
        this.hasAlpha = hasAlpha;
    }

    public int getColorComponents() {
        return colorComponents;
    }

    public void setColorComponents(int colorComponents) {
        this.colorComponents = colorComponents;
    }

    public int getBitsPerPixel() {
        return bitsPerPixel;
    }

    public void setBitsPerPixel(int bitsPerPixel) {
        this.bitsPerPixel = bitsPerPixel;
    }

//    public String getColorModel() {
//        return colorModel;
//    }
//
//    public void setColorModel(String colorModel) {
//        this.colorModel = colorModel;
//    }

    public String getCameraMake() {
        return cameraMake;
    }

    public void setCameraMake(String cameraMake) {
        this.cameraMake = cameraMake;
    }

    public String getCameraModel() {
        return cameraModel;
    }

    public void setCameraModel(String cameraModel) {
        this.cameraModel = cameraModel;
    }

    public String getLensModel() {
        return lensModel;
    }

    public void setLensModel(String lensModel) {
        this.lensModel = lensModel;
    }

    public String getSoftware() {
        return software;
    }

    public void setSoftware(String software) {
        this.software = software;
    }

    public String getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(String dateTaken) {
        this.dateTaken = dateTaken;
    }

    public String getExposureTime() {
        return exposureTime;
    }

    public void setExposureTime(String exposureTime) {
        this.exposureTime = exposureTime;
    }

    public String getShutterSpeed() {
        return shutterSpeed;
    }

    public void setShutterSpeed(String shutterSpeed) {
        this.shutterSpeed = shutterSpeed;
    }

    public String getAperture() {
        return aperture;
    }

    public void setAperture(String aperture) {
        this.aperture = aperture;
    }

    public int getIso() {
        return iso;
    }

    public void setIso(int iso) {
        this.iso = iso;
    }

    public String getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(String focalLength) {
        this.focalLength = focalLength;
    }

    public String getFlash() {
        return flash;
    }

    public void setFlash(String flash) {
        this.flash = flash;
    }

    public String getWhiteBalance() {
        return whiteBalance;
    }

    public void setWhiteBalance(String whiteBalance) {
        this.whiteBalance = whiteBalance;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }
}
