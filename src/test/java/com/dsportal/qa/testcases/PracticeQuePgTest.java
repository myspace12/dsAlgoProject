package com.dsportal.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dsportal.qa.base.TestBase;
import com.dsportal.qa.pages.GetStartedPage;
import com.dsportal.qa.pages.HomePage;
import com.dsportal.qa.pages.PracticeQuePg;
import com.dsportal.qa.pages.QueueOperationsPg;
import com.dsportal.qa.pages.QueuePage;
import com.dsportal.qa.pages.SignInPage;



public class PracticeQuePgTest extends TestBase {
	
	GetStartedPage getstart;
	HomePage homepg;
	SignInPage signin;
	QueuePage queuepg;
	PracticeQuePg practiceque;
	QueueOperationsPg queOperationPg;
	
	Logger logger=Logger.getLogger("Practice Questions page Test");
	
	public PracticeQuePgTest()
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
		queuepg=new QueuePage();
		queuepg=homepg.OpenQueuePg();
		queOperationPg = new QueueOperationsPg();
		queOperationPg=queuepg.OpenQueueOperations();
		practiceque=new PracticeQuePg();
		practiceque=queOperationPg.OpenPracticeQuestionPg();
		
	}
	
	@Test
	
	public void ValidationOfPracticeQuePgTest()
	{
		logger.info("Validating the title of practice question page");
		
		String title=practiceque.ValidationOfPracticeQuePg();
		Assert.assertEquals(title, "Practice Questions");
	}
	
	@AfterMethod
	public void teardown()
	{
		Logger logger=Logger.getLogger("Closing the browser");
		
		driver.close();
	}

}
