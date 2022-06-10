package com.dsportal.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dsportal.qa.base.TestBase;
import com.dsportal.qa.pages.DataStructuresPg;
import com.dsportal.qa.pages.GetStartedPage;
import com.dsportal.qa.pages.HomePage;
import com.dsportal.qa.pages.QueuePage;
import com.dsportal.qa.pages.SignInPage;

public class DataStructuresPgTest extends TestBase {
	
	GetStartedPage getstart;
	HomePage homepg;
	SignInPage signin;
	DataStructuresPg datastructures;
		
	Logger logger=Logger.getLogger("Data Structures Page Test");
	
	public DataStructuresPgTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		getstart=new GetStartedPage();
		homepg=new HomePage();
		homepg=getstart.GetStarted();
		signin=new SignInPage();
		signin=homepg.OpenSignInPage();
		signin.UserSignIN(prop.getProperty("username"), prop.getProperty("Passwd"));
		datastructures = new DataStructuresPg();
		datastructures=homepg.OpenDataStructurePage();
		
	}
	
	@Test(priority=1)
	public void ValidationOfQueuePgTest() 
	{
		logger.info("Data Structures page validation test");
		
		String title=datastructures.ValidationOfDataStructuresPg();
		Assert.assertEquals(title, "Data Structures-Introduction");
	}
	
	@Test(priority=2)
	public void OpenTimeComplexityPgTest()
	{
		logger.info("Click on Time Complexity link");
		
		datastructures.OpenTimeComplexityPg();
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}

}
