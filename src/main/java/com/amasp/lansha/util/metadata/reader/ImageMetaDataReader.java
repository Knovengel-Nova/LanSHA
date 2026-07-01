package com.amasp.lansha.util.metadata.reader;

import com.amasp.lansha.util.metadata.ImageMetaData;
import com.drew.imaging.ImageMetadataReader;
import com.drew.lang.GeoLocation;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.exif.GpsDirectory;
import java.nio.file.Path;

/**
 *
 * @author knovengel
 */
public class ImageMetaDataReader {

    public static ImageMetaData read(Path path) {

        ImageMetaData imageMetaData = new ImageMetaData(path);

        try {

            Metadata metadata = ImageMetadataReader.readMetadata(path.toFile());

            /* Camera Information */
            ExifIFD0Directory ifd0
                    = metadata.getFirstDirectoryOfType(ExifIFD0Directory.class);

            if (ifd0 != null) {

                imageMetaData.setCameraMake(
                        ifd0.getString(ExifIFD0Directory.TAG_MAKE));

                imageMetaData.setCameraModel(
                        ifd0.getString(ExifIFD0Directory.TAG_MODEL));

                imageMetaData.setSoftware(
                        ifd0.getString(ExifIFD0Directory.TAG_SOFTWARE));

                Integer orientation
                        = ifd0.getInteger(ExifIFD0Directory.TAG_ORIENTATION);

                if (orientation != null) {
                    imageMetaData.setOrientation(orientation);
                }
            }

            /* Image Details */
            ExifSubIFDDirectory subIFD
                    = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);

            if (subIFD != null) {

                imageMetaData.setDateTaken(
                        subIFD.getString(
                                ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL));

                Integer iso
                        = subIFD.getInteger(
                                ExifSubIFDDirectory.TAG_ISO_EQUIVALENT);

                if (iso != null) {
                    imageMetaData.setIso(iso);
                }

                imageMetaData.setExposureTime(
                        subIFD.getDescription(
                                ExifSubIFDDirectory.TAG_EXPOSURE_TIME));

                imageMetaData.setShutterSpeed(
                        subIFD.getDescription(
                                ExifSubIFDDirectory.TAG_SHUTTER_SPEED));

                imageMetaData.setAperture(
                        subIFD.getDescription(
                                ExifSubIFDDirectory.TAG_FNUMBER));

                imageMetaData.setFocalLength(
                        subIFD.getDescription(
                                ExifSubIFDDirectory.TAG_FOCAL_LENGTH));

                imageMetaData.setFlash(
                        subIFD.getDescription(
                                ExifSubIFDDirectory.TAG_FLASH));

                imageMetaData.setWhiteBalance(
                        subIFD.getDescription(
                                ExifSubIFDDirectory.TAG_WHITE_BALANCE));

                imageMetaData.setLensModel(
                        subIFD.getString(
                                ExifSubIFDDirectory.TAG_LENS_MODEL));
            }

            /* GPS */
            GpsDirectory gps
                    = metadata.getFirstDirectoryOfType(GpsDirectory.class);

            if (gps != null) {

                GeoLocation location = gps.getGeoLocation();

                if (location != null) {
                    imageMetaData.setLatitude(location.getLatitude());
                    imageMetaData.setLongitude(location.getLongitude());
                }

                if (gps.containsTag(GpsDirectory.TAG_ALTITUDE)) {
                    imageMetaData.setAltitude(
                            gps.getDoubleObject(GpsDirectory.TAG_ALTITUDE));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return imageMetaData;
    }
}
