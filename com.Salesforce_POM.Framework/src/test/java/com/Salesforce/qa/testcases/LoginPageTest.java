package com.Salesforce.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Salesforce.qa.Base.TestBase;
import com.Salesforce.qa.pages.Homepage;
import com.Salesforce.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage  loginPage;
	Homepage homepage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
			
	}
	@Test(priority=1)
	public void login() {
		loginPage.login();
	}
	
	@Test(priority=2)
	public void loginPageTitle() {
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Salesforce.com: The Customer Success Platform To Grow Your Business");
	}
	
	@Test(priority=3)
	public void salesforceImagelogo() {
		boolean flag=loginPage.validateSalesforceImage();
		Assert.assertTrue(flag);
	}
	@Test(priority=4)
	public void loginerrTest() {
		loginPage.login();
		loginPage.loginerrMsg(prop.getProperty("username"));
	}
	@Test(priority=5)
	public void rememberMe() {
		loginPage.login();
		loginPage.rememberMe();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=6)
	public void loginTest() {
		loginPage.login();
		homepage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	

}
