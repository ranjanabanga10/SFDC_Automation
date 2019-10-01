package com.Salesforce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesforce.qa.Base.TestBase;

public class LoginPage extends TestBase{
	//Page factory--OR
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement login;
	@FindBy(id="username")
	WebElement username;
	@FindBy(id="password")
	WebElement password;
	@FindBy(id="Login")
	WebElement loginbtn;
	@FindBy(xpath="//input[@id='rememberUn']")
	WebElement remembermebx;
	@FindBy(xpath="//header[contains(@class,'container-fluid header-container')]//img[2]")
	WebElement salesforcelogo;
	@FindBy(xpath="//*[@id='forgot_password_link']")
	WebElement forgotpassword;
	@FindBy(id="signup_link")
	WebElement signup;
	
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public void login() {
		login.click();
	}
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateSalesforceImage(){
		return salesforcelogo.isDisplayed();
	}
	public Homepage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();

		return new Homepage();
	}
	public void loginerrMsg(String un) {
		username.sendKeys(un);
		password.clear();
		loginbtn.click();
		
	}
	public void rememberMe() {
		remembermebx.click();
	}
	
	
}
