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

    public static void saveSettingsData(SettingsData data) {
        
        String folderPath;
        String fileName;

        //  save data
        folderPath = "saves/";
        new java.io.File(folderPath).mkdirs();

        //      DATA_MODEL file save
        fileName = "_SETTINGS_DATA.ser";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(folderPath + "/" + fileName))) {
            oos.writeObject(data);
            System.out.println(fileName + " saved successfully in " + folderPath);
        } catch (Exception e) {
            System.out.println("Error saving "+fileName+" in "+folderPath);
        }
    }

    public static SettingsData retrieveSettingsData() {
        String folderPath = "saves/";
        String fileName = "_SETTINGS_DATA.ser";

        SettingsData data = null;

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(folderPath + "/"+fileName))){
            data = (SettingsData)ois.readObject();
        }catch(Exception e){
            System.out.println("Can't find or access "+fileName+" in path: "+folderPath);
            return null;
        }

        return data;
    }
}
