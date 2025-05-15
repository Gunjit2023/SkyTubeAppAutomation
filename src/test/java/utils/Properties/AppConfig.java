package utils.Properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AppConfig {
	public static Properties properties;
	public final static String filePath = "./src/test/resources/utilities/config.properties";
	
	public static void loadConfig() throws Throwable {
		try {
			FileInputStream fis;
			fis = new FileInputStream(filePath);
			properties = new Properties();
			try {
				properties.load(fis);
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + filePath);
		}	
	}	
	
    public static String getAppPath() {		    	
        String basePath = properties.getProperty("app.path");
        if(basePath != null) return basePath;
        else throw new RuntimeException("basePath not specified in the config.properties file.");
    	}
    
    public static String getExcelPath() {
        String excelPath = properties.getProperty("excelreader");
        System.out.println("excel path = " + excelPath);
        if(excelPath != null) return excelPath;
        else throw new RuntimeException("excelPath not specified in the config.properties file."); 
    }
}
