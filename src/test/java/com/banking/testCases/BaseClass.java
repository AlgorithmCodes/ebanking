package com.banking.testCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	
	public String baseURL="http://demo.guru99.com/V4/";
	public String username="mngr324640";
	public String password="zehYjAj";
	public static WebDriver driver;
	public static Logger log;
	@BeforeClass
	public void setup() {
		
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	
	
	log=Logger.getLogger("eBanking");
	PropertyConfigurator.configure("log4j.properties");
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
