package com.ebanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	public Properties prop;
	public ReadConfig() {
		File file=new File("./configuration/config.properties");
		try {
			FileInputStream fis=new FileInputStream(file);
			prop=new Properties();
			prop.load(fis);
		}
		catch(IOException e) {
			System.out.println("The exception is"+e.getMessage());
		}
	}
	
	public String getApplicationURL() {
		String url=prop.getProperty("baseURL");
		return url;
	}
	
	public String getChromeDriverPath() {
		String chromeDriverPath=prop.getProperty("chromeDriverPath");
		return chromeDriverPath;
	}
	
	
	public String getUsername() {
		String username=prop.getProperty("username");
		return username;
	}
	
	
	public String getPassword() {
		String password=prop.getProperty("password");
		return password;
	}

}
