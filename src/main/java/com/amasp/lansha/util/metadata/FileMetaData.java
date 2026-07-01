package com.amasp.lansha.util.metadata;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

/**
 *
 * @author knovengel
 */
public class FileMetaData {

    private Path path;
    private String fileName;
    private String extension;
    private String mimeType;
    private long size;
    private FileTime createdTime;
    private FileTime modifiedTime;
    private boolean isHidden;
    private boolean isReadable;
    private boolean isWritable;
    private boolean isExecutable;

    public FileMetaData(Path path) {
        this.path = path;
        extractMetaData();
    }

    private void extractMetaData() {
        try {
            BasicFileAttributes attrs
                    = Files.readAttributes(path, BasicFileAttributes.class);

            size = attrs.size();
            createdTime = attrs.creationTime();
            modifiedTime = attrs.lastModifiedTime();

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.fileName = path.getFileName().toString();
        int dot = fileName.lastIndexOf(".");

        if (dot > 0) {
            this.extension = fileName.substring(dot + 1).toLowerCase();
        }else{
            this.extension = "idk";
        }

        try {
            this.mimeType = Files.probeContentType(path);
        } catch (IOException e) {
            this.mimeType = "xyz";
            e.printStackTrace();
        }

        this.isHidden = path.toFile().isHidden();
        this.isReadable = path.toFile().canRead();
        this.isWritable = path.toFile().canWrite();
        this.isExecutable = path.toFile().canExecute();

    }
    
    public String getPerms(){
        StringBuilder resp = new StringBuilder();
        
        if(isReadable)
            resp.append("Rd");
        else
            resp.append('-');
        
        if(isWritable)
            resp.append("Wr");
        else
            resp.append('-');
        
        if(isExecutable)
            resp.append("Ex");
        else
            resp.append('-');
        
        return resp.toString();
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public FileTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(FileTime createdTime) {
        this.createdTime = createdTime;
    }

    public FileTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(FileTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

}
