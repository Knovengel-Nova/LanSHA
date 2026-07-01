package com.amasp.lansha.util.metadata.reader;

import com.amasp.lansha.util.metadata.FileMetaData;
import java.nio.file.Path;

/**
 *
 * @author knovengel
 */
public class FileMetaDataReader {
    
    public static FileMetaData read(Path selectedFile){
        return new FileMetaData(selectedFile);
    }
    
}
