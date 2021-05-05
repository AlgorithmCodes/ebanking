package com.banking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ebanking.pageObjects.LoginPage;
import com.ebanking.utilities.ExcelReader;

public class TC_LoginTestDDT_002 extends BaseClass {
	
	@Test(dataProvider="getData")
	public void loginTestDDT(String usrname,String pwd) {
		
		//System.out.println(username+" "+password);
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(usrname);
		log.info("usename is entered");
		lp.setPassword(pwd);
		log.info("password is entered");
		lp.clickLoginBtn();
		log.info("Clicked login button");
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		else {
			lp.clickLogoutBtn();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
		public boolean isAlertPresent(){
			try {
				driver.switchTo().alert();
				return true;
			}catch(NoAlertPresentException e) {
				return false;
			}
		
		
		
	}
	
	@DataProvider
	public String[][] getData() throws IOException {
		
		String filePath="B:\\april\\eBanking\\src\\test\\java\\com\\ebanking\\testData\\TestData.xlsx";
		
		ExcelReader er=new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\java\\com\\ebanking\\testData\\TestData.xlsx", "loginData");
		int rowCount=er.getRowCount();
		int colCount=er.getColumnCount();
		
		String loginData[][]=new String[rowCount][colCount];
		
		for (int i = 1; i <=rowCount; i++) {
			
			for (int j = 0; j < colCount; j++) {
				loginData[i-1][j]=er.getCellData(i, j);
			}
			
		}
		
		return loginData;
		
	}

}
