package com.galleryview.com.gv;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public Properties properties;
    public final String propertyFilePath = "src/main/resources/config.properties"; // Update the path accordingly
    public Properties artworkfile;
    public final String artworkFilePath = "src/main/resources/artwork.properties"; // Update the path accordingly
    public Properties productfile;
    public final String productFilePath = "src/main/resources/product.properties"; // Update the path accordingly
   

    public ConfigReader() {
    	
        properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream(propertyFilePath);
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration properties file cannot be found at " + propertyFilePath);
        }

        artworkfile = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream(artworkFilePath);
            artworkfile.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration properties file cannot be found at " + artworkFilePath);
        }
        
        productfile = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream(productFilePath);
            productfile.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration properties file cannot be found at " + productFilePath);
        }
        
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    } 
    public String getArtwork(String key) {
        return artworkfile.getProperty(key);
    }
    
    public String getProduct(String key) {
        return productfile.getProperty(key);
    } 
    }
