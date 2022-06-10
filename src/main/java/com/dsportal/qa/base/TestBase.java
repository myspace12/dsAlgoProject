package com.dsportal.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.dsportal.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static String txmsg;
	
	public TestBase()
	
		       {
		
			
		
	try
	{
		prop=new Properties();
		FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/dsportal/qa/config/config.properties");
		prop.load(ip);
		
	}catch(FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
}
	
	
	@Parameters("browser")		
	public static void initialization()
	{
		
		Logger logger = Logger.getLogger("initialization");
		PropertyConfigurator.configure("Log4j.properties");
		
		String browserName=prop.getProperty("browser");
		 if(browserName.equalsIgnoreCase("chrome")) 
		  {
			 logger.info("Chrome Browser Opened");
		  //initializing and starting the Chromebrowser
			//  System.setProperty("webdriver.chrome.driver","C:\\Users\\rupal\\eclipse-workspace\\dsalgoproject\\src\\main\\resources\\drivers\\chromedriver.exe");
			
			 WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
	}
		// String browserName1=prop.getProperty("browser1");
		 if(browserName.equalsIgnoreCase("firefox")) 
		  {
			 logger.info("FF Browser Opened");
		  //initializing and starting the Firefoxbrowser
			 // System.setProperty("webdriver.gecko.driver","C:\\Users\\rupal\\eclipse-workspace\\dsalgoproject\\src\\main\\resources\\drivers\\geckodriver.exe");
				
			 WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
}
		 
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT ,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICUT_WAIT ,TimeUnit.SECONDS);
	
	
	logger.info("Browser Opened");
	driver.get(prop.getProperty("url"));
	
		
	}
	
	
	
	
}
