package com.dsportal.qa.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dsportal.qa.base.AllureListeners;
import com.dsportal.qa.base.TestBase;
import com.dsportal.qa.pages.GetStartedPage;
import com.dsportal.qa.pages.HomePage;
import com.dsportal.qa.pages.RegistrationPage;
import com.dsportal.qa.pages.SignInPage;

@Listeners({AllureListeners.class})
public class HomePageTest extends TestBase {
	HomePage homepg;
	GetStartedPage getstarted;
	SignInPage signin;
	RegistrationPage register;
	
	Logger logger=Logger.getLogger("Home Page Test");
	public HomePageTest()
	{
		//to call TestBase class constructor use super() keyword
		super();
	}
	
	@BeforeMethod
	
	public void Setup()
	{
		initialization();
		
		getstarted=new GetStartedPage();
		getstarted.GetStarted();
		homepg= new HomePage();
		signin= new SignInPage();
		register= new RegistrationPage(); 
	}
	
	@Test(priority=1)
	public void HomepgtitleValidationTest()
	{
		logger.info("Home Page title validation test");
	
		String title=homepg.validateHomePage();
		Assert.assertEquals(title, "NumpyNinja");
	}
	
	@Test(priority=2)
	public void clickonDropdownTest()
	{
		logger.info("Drop Down Items count test");
		
		int size=homepg.clickonDropDown();
		System.out.println(size);
		Assert.assertEquals(size, 6);
		
	}
	 
	@Test(priority=3)
	public void ClickWithoutLoginTest()
	{
		logger.info("Click on any button without login test");
		
		String txmsg=homepg.ClickWithoutLogin();
		Assert.assertEquals(txmsg, "You are not logged in");
	}
		
	@Test(priority=4)
		public void OpenRegPageTest()
	{
		logger.info("Open Registration Page test");
		homepg.OpenRegPage();
	}
	
	@Test (priority =5)
	public void ConfirmRegitrationTest()
	{
		logger.info("Confirm registration test");
		
		homepg.OpenRegPage();
		register.RegisterValidUser(prop.getProperty("username"), prop.getProperty("Passwd"),prop.getProperty("Passwd"));
		Assert.assertEquals(homepg.ConirmRegitration(),"New Account Created. You are logged in as "+prop.getProperty("username") );
	
		//homepg.signout();
	}
	
			
	@Test(priority=6)
	public void OpenSignInPageTest()
	{
		logger.info("Open Sign in Page test");
		
		homepg.OpenSignInPage();
				
	}
	
	@Test(priority =7)
	public void UserSigninValidationTest()
	{
		logger.info("Sign in with valid inputs test");
		
		homepg.OpenSignInPage();
		signin.UserSignIN(prop.getProperty("username"), prop.getProperty("Passwd"));
		Assert.assertEquals(homepg.UserSigninValidation(),"You are logged in");
		
	}
	
	
	
	@Test(priority=8)
	public void VerifyUsernameTest()
	{
		logger.info("Verify username after valid login ");
		
		homepg.OpenSignInPage();
		signin.UserSignIN(prop.getProperty("username"), prop.getProperty("Passwd"));
		
		Assert.assertEquals(homepg.VerifyUsername(),prop.getProperty("username"));
	}
	
	
			
	@Test(priority=9)
	public void OpenQueuePgTest()
	{
		logger.info("After login Open Queue Page test");
		
		homepg.OpenSignInPage();
		signin.UserSignIN(prop.getProperty("username"), prop.getProperty("Passwd"));
		homepg.OpenQueuePg();
		driver.navigate().back();
	}
	
	@Test(priority=10)
	public void OpenTreePgTest()
	{
logger.info("After login Open Tree Page test");
		
		homepg.OpenSignInPage();
		signin.UserSignIN(prop.getProperty("username"), prop.getProperty("Passwd"));
		homepg.OpenTreePage();
	}
	
	
	@AfterMethod
	public void teardown()
	{
		logger.info("Close The Browser");
		driver.close();
	}

}
