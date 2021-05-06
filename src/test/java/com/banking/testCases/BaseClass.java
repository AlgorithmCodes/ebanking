package com.banking.testCases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.ebanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readConfig=new ReadConfig();
	public String baseURL=readConfig.getApplicationURL();
	public String username=readConfig.getUsername();
	public String password=readConfig.getPassword();
	public static WebDriver driver;
	public static Logger log;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) {
		
		if(browser.equals("chrome")) {
		
	System.setProperty("webdriver.chrome.driver", readConfig.getChromeDriverPath());
	driver=new ChromeDriver();
		}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.get(readConfig.getApplicationURL());
	
	log=Logger.getLogger("eBanking");
	PropertyConfigurator.configure("log4j.properties");
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void getShot(String filePath) {
		File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(file, new File(filePath));
		
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}

}
