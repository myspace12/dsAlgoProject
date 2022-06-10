package com.dsportal.qa.testcases;

import org.apache.log4j.Logger;
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
@Listeners({AllureListeners.class})

public class GetStartedPageTest extends TestBase{
	GetStartedPage getstart;
	
	Logger logger=Logger.getLogger("GetStartedPageTest");
	
	public GetStartedPageTest()
	{
		//to call TestBase class constructor use super() keyword
		super();
	}
	
	@BeforeMethod
	public void Setup()
	{
		
		initialization();
		getstart= new GetStartedPage();
		
	}
	
	@Test(priority=1)
		
	public void titlevalidation()
	{
		logger.info("Page title validation test started");
		
		String title=getstart.validateGetStartedPage();
		
		Assert.assertEquals(title, "Numpy Ninja");
	}
	
	@Test(priority=2)
	
	public void LandonHomePage() throws InterruptedException {
		logger.info("Click on start button");
		
		getstart.GetStarted();
		Thread.sleep(2000);
	}
	
		
	@AfterMethod
	public void teardown()
	{
		logger.info("Closing the browser");
		driver.close();
	}

}
