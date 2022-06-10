package com.dsportal.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dsportal.qa.base.TestBase;
import com.dsportal.qa.pages.GetStartedPage;
import com.dsportal.qa.pages.HomePage;
import com.dsportal.qa.pages.RegistrationPage;

public class RegPageTest extends TestBase {
	GetStartedPage getstart;
	HomePage homepg;
	RegistrationPage reg;
	
	Logger logger=Logger.getLogger("Registration Page Test");
	
	public RegPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void Setup()
	{
		initialization();
		getstart= new GetStartedPage();
		getstart.GetStarted();
		homepg = new HomePage();
		homepg.OpenRegPage();
		reg= new RegistrationPage();
	}
	
	@Test(priority=1)
	public void RegPgTitleValidationTest()	
	{
		logger.info("Registration page title validation test");
		
	String title=reg.RegPageValidation();
	Assert.assertEquals(title, "Registration");
		
	}
	
	@Test(priority=2)
	public void RegWithoutInputTest()
	{
		logger.info("Try to Register with all fields empty");
		
		txmsg=reg.RegWithBlankFields(prop.getProperty("UN_blank"),prop.getProperty("PWD_blank"),prop.getProperty("PWD_blank"));
		
		Assert.assertEquals(txmsg, "Please fill out this field.");
	}
	
	@Test(priority=3)
	public void RegWithUsernmOnlyTest()
	{
		logger.info("Try to register with username only ");
		
		txmsg=reg.RegWithBlankFields(prop.getProperty("username"),prop.getProperty("PWD_blank"),prop.getProperty("PWD_blank"));
		
		Assert.assertEquals(txmsg, "Please fill out this field.");
	
	}
	
	@Test(priority=4)
	public void InvUsernmTest()
	{
		logger.info("Register with invalid username test");
		
		//The user enters a name with characters other than Letters, digits and @/./+/-/_
		
		String tx= reg.InvUsernm(prop.getProperty("Invusrnm"),prop.getProperty("Invpwd"),prop.getProperty("Passwd"));
		Assert.assertEquals(tx,"password_mismatch:The two password fields didn’t match.");
	    
	}

	@Test(priority=5)
	public void RegisterWithPasswdNumbersTest()
	{
		logger.info("Try to Register with using only digits in password field");
		
		txmsg=reg.RegisterWithPasswdNumbers(prop.getProperty("username"), prop.getProperty("Invpwd"), prop.getProperty("Invpwd"));
		Assert.assertEquals(txmsg,"password_mismatch:The two password fields didn’t match.");
	}
	
	@Test(priority=6)
	public void RegisterValidUserTest()
	{
		logger.info("Register with valid inputs test");
		
		reg.RegisterValidUser(prop.getProperty("username"), prop.getProperty("Passwd"), prop.getProperty("Passwd"));
		
		homepg.ConirmRegitration();
		Assert.assertEquals(homepg.ConirmRegitration(),"New Account Created. You are logged in as "+prop.getProperty("username") );
	}
	
	
	@AfterMethod
	public void teardown()
	{
		logger.info("Close the browser");
		
		driver.close();
	}

}
