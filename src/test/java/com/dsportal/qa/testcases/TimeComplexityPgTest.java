package com.dsportal.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dsportal.qa.base.TestBase;
import com.dsportal.qa.pages.DataStructuresPg;
import com.dsportal.qa.pages.GetStartedPage;
import com.dsportal.qa.pages.HomePage;
import com.dsportal.qa.pages.QueueOperationsPg;
import com.dsportal.qa.pages.QueuePage;
import com.dsportal.qa.pages.SignInPage;
import com.dsportal.qa.pages.TimeComplexityPg;

public class TimeComplexityPgTest extends TestBase {
	
Logger logger=Logger.getLogger("Time Complexity page Test");
	
	GetStartedPage getstart;
	HomePage homepg;
	SignInPage signin;
	DataStructuresPg datastructures;
	TimeComplexityPg timecomplpg;
	
	
	public TimeComplexityPgTest()
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
		datastructures=new DataStructuresPg();
		datastructures=homepg.OpenDataStructurePage();
		timecomplpg=new TimeComplexityPg();
		timecomplpg=datastructures.OpenTimeComplexityPg();
				
		}
	@Test(priority=1)
	public void TimeComplexityEditorTest()
	{
    logger.info("Time Complexity editor");
		
		txmsg=timecomplpg.TimeComplexityEditor(prop.getProperty("code"));
		
		Assert.assertEquals(txmsg,"Welcome");
	}
	
	@Test(priority=2)
	public void OpenPracticeQPgTest()
	{
		timecomplpg.OpenTimeCompPracticeQuestionPg();
	}
	@AfterMethod
	public void teardown()
	{
		
		logger.info("Closing the browser");
		driver.close();
	}

}
