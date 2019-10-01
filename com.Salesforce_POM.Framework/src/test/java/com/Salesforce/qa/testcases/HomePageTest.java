package com.Salesforce.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Salesforce.qa.Base.TestBase;
import com.Salesforce.qa.pages.Homepage;
import com.Salesforce.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	LoginPage  loginPage;
	Homepage homepage;
	
	
	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		loginPage.login();
		homepage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@Test(priority=1)
	public void validateUserNameLabe() {
		boolean flag=homepage.validateUserNameLabel();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void logout() {
		homepage.usernameClick();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	

}
