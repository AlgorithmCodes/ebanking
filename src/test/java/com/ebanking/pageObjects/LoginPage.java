package com.ebanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	 WebDriver driver;
	 
	 public LoginPage(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver,this);	 
	 }
	 
	 @FindBy(xpath="//input[@name='uid']")
	 WebElement txtUsername;
	 @FindBy(xpath="//td/input[@type='password']")
	 WebElement txtPassword;
	 @FindBy(xpath="//input[@name='btnLogin']")
	 WebElement loginBtn;
	 @FindBy(xpath="//a[normalize-space()='Log out']")
	 WebElement logoutBtn;
	 
	 public void setUserName(String username) {
		 txtUsername.sendKeys(username);
	 }
	 
	 public void setPassword(String password) {
		 txtPassword.sendKeys(password);
	 }
	 
	 public void clickLoginBtn() {
		 loginBtn.click();
	 }
	 public void clickLogoutBtn() {
		 logoutBtn.click();
	 }
	 

}
