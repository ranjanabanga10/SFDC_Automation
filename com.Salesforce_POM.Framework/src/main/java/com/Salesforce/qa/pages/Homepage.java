package com.Salesforce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesforce.qa.Base.TestBase;

public class Homepage extends TestBase {
	
	
	@FindBy(id="userNavLabel")
	WebElement usernameLabel;
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement logout;
	
	// Initializing the Page Objects:
		public Homepage() {
			PageFactory.initElements(driver, this);
		}
		
		
		public boolean validateUserNameLabel(){
				   usernameLabel.click();
			return usernameLabel.isDisplayed();
		}
		public void usernameClick() {
			Actions action = new Actions(driver);
			action.moveToElement(usernameLabel).build().perform();
			usernameLabel.click();
			logout.click();
		}
	
}
