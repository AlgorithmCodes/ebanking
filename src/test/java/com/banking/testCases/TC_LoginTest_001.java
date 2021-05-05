package com.banking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ebanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws InterruptedException {
		driver.get(baseURL);
		log.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		log.info("usename is entered");
		lp.setPassword(password);
		log.info("password is entered");
		lp.clickLoginBtn();
		log.info("Clicked login button");
		Thread.sleep(3000);
		System.out.println(driver.getTitle());

		if(driver.getTitle().trim().equalsIgnoreCase("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

}
