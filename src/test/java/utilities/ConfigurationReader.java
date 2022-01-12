package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    static Properties properties;
    static {
        String filePath = "configuration.properties";

        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            properties= new Properties();
            properties.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        return value;
    }
}
