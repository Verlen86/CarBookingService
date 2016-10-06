package CarRent.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ApplicationConfig {
	
	private String carListFilePath; 
	private final static String CONFIG_FILE_LOCATION="config.properties";
	
    private static final ApplicationConfig INSTANCE = new ApplicationConfig();
    private ApplicationConfig() {
    	Properties prop=new Properties();
    	ClassLoader classLoader = getClass().getClassLoader();
        try (FileReader f = new FileReader(classLoader.getResource(CONFIG_FILE_LOCATION).getFile())) {
        	prop.load(f);
        } catch (FileNotFoundException ex) {
        	throw new RuntimeException("File not found" + ex);
        } catch (IOException ex) {
        	throw new RuntimeException("I/O error" + ex);
        }
        carListFilePath=prop.getProperty("product.file.path");

    }
    

    
    public String getCarListFilePath(){
    	
    	return carListFilePath;
    }

    public static ApplicationConfig getInstance() {
        return INSTANCE;
    }
}

