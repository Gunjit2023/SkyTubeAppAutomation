package utils.Properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppConfig {
    public static String getAppPath() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(fis);
            return properties.getProperty("app.path");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config file", e);
        }
    }
}
