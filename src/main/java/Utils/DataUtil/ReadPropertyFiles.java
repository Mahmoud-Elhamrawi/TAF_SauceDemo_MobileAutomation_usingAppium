package Utils.DataUtil;

import Utils.LogUtil.LogClass;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;

public class ReadPropertyFiles {

    protected static String propertyFilePath = "src/main/resources/";


    //load property file
    public static Properties loadPropertyFile() {
        try {
            Properties properties = new Properties();
            Collection<File> collectionFile;
            collectionFile = FileUtils.listFiles(new File(propertyFilePath), new String[]{"properties"}, true);
            collectionFile.forEach(
                    file -> {
                        try {
                            properties.load(new FileInputStream(file));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        properties.putAll(System.getProperties());
                        System.getProperties().putAll(properties);
                    });
            LogClass.info("property file loaded");
            return properties;


        } catch (Exception e) {
            LogClass.error("failed to load property file" + e.getMessage());
            return null;
        }
    }


    // get property key
    public static String getProperty(String key) {
        try {
            return System.getProperty(key);
        } catch (Exception e) {
            System.out.println("Exception is " + e.getMessage());
            return null;
        }


    }


}
