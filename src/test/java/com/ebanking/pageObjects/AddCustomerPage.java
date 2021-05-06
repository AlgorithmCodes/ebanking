package com.ebanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//a[normalize-space()='New Customer']")
	WebElement addCustomerLink;
	@FindBy(how=How.XPATH,using="//input[@name='name']")
	WebElement txtCustomerName;
	@FindBy(how=How.XPATH,using="//input[@value='m']")
	WebElement radGender;
	@FindBy(how=How.XPATH,using="//input[@id='dob']")
	WebElement txtdob;
	@FindBy(how=How.XPATH,using="//textarea[@name='addr']")
	WebElement txtaddress;
	@FindBy(how=How.XPATH,using="//input[@name='city']")
	WebElement txtcity;
	@FindBy(how=How.XPATH,using="//input[@name='state']")
	WebElement txtstate;
	@FindBy(how=How.XPATH,using="//input[@name='pinno']")
	WebElement txtpin;
	@FindBy(how=How.XPATH,using="//input[@name='telephoneno']")
	WebElement txtphone;
	@FindBy(how=How.XPATH,using="//input[@name='emailid']")
	WebElement txtemail;
	@FindBy(how=How.XPATH,using="//input[@name='password']")
	WebElement txtpassword;
	
	@FindBy(how=How.XPATH,using="//input[@name='sub']")
	WebElement submitBtn;
	
	
	public void getAddCustomerLink() {
		addCustomerLink.click();
	}
	
	public void custGender(String cgender) {
		radGender.click();
		
	}
	
	public void custdob(String dd,String mm,String yy) {
		txtdob.sendKeys(dd);
		txtdob.sendKeys(mm);
		txtdob.sendKeys(yy);
		
	}
	
	public void custaddress(String address) {
		txtaddress.sendKeys(address);
	}
	
	
	public void custcity(String city) {
		txtcity.sendKeys(city);
	}
	
	public void custstate(String state) {
		txtstate.sendKeys(state);
	}
	
	public void custpin(String pin) {
		txtpin.sendKeys(pin);
	}
	
	public void custphone(String phone) {
		txtphone.sendKeys(phone);
	}
	public void custemail(String email) {
		txtemail.sendKeys(email);
	}
	
	public void custpassword(String password) {
		txtpassword.sendKeys(password);
	}
	
	public void custSubmit() {
		submitBtn.click();
	}
	
	
	
}
