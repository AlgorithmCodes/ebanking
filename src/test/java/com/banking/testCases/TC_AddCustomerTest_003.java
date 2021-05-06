package com.banking.testCases;

import org.testng.annotations.Test;

import com.ebanking.pageObjects.AddCustomerPage;
import com.ebanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addCustomer() {
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickLoginBtn();
		
		AddCustomerPage acp=new AddCustomerPage(driver);
		acp.getAddCustomerLink();
		acp.custGender("male");
		acp.custdob("21", "12", "1992");
		acp.custaddress("hyd");
		acp.custcity("hyd");
		acp.custstate("TG");
		acp.custpin("521111");
		acp.custphone("987463210");
		acp.custemail("test@gmail.com");
		acp.custpassword("bhhgjjjg");
		acp.custSubmit();
		
		
		
		
		
	}

}
