package com.galleryview.com.gv.SuperAdminuser;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaders {

	//SuperAdmin File Config
    public Properties adminFile;
    public final String superAdminFilePath = "src/main/resources/admin.properties"; // Update the path accordingly


    public ConfigReaders() {
    	
        adminFile = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream(superAdminFilePath);
            adminFile.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration properties file cannot be found at " + superAdminFilePath);
        }
    }

    public String getSuperAdmin(String key) {
        return adminFile.getProperty(key);
    } 
}
