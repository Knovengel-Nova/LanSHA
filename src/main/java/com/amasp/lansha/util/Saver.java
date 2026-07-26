package com.amasp.lansha.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author knovengel
 */
public class Saver {

    public static void saveSettingsFile(SettingsData file) {
        String folderPath = "saves/";
        new java.io.File(folderPath).mkdirs();

        String fileName = "_Settings_DATA.ser";

        try {
            FileOutputStream fos = new FileOutputStream(folderPath + "/" + fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(file);
            System.out.println(fileName + " Succesfully saved in " + folderPath);

            fos.close();
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SettingsData retrieveStudentDataFile() {
        String folderPath = "saves/";
        String fileName = "_Settings_DATA.ser";

        SettingsData data = null;

        try {
            FileInputStream fis = new FileInputStream(folderPath + "/" + fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);

            SettingsData temp = (SettingsData) ois.readObject();
            System.out.println(fileName + " Retrieved Successfully!");

            data = temp;

            fis.close();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}
