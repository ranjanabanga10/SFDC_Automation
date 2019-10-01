package com.Salesforce.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Salesforce.qa.util.TestUtil;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;

	public TestBase(){

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/Salesforce/qa/config/config.properties");

			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	public static void initialization(){
		String browserName = prop.getProperty("browser");

		if(browserName.equals("chrome")){
			String ProjectPath=System.getProperty("user.dir");
			System.out.println("ProjectPath: "+ProjectPath);
			
			System.setProperty("webdriver.chrome.driver", ProjectPath+"/Drivers/ChromeDriver/chromedriver");
			driver=new ChromeDriver();
			 
		}
		else if(browserName.equals("FF")){
			String ProjectPath=System.getProperty("user.dir");
			System.out.println("ProjectPath: "+ProjectPath);
			
			System.setProperty("webdriver.gecko.driver",ProjectPath+"/Drivers/GeickoDriver/geckodriver");	
			driver = new FirefoxDriver(); 
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));







	}
	}
