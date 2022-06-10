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
import com.dsportal.qa.pages.ImplimentationOfQueuePg;
import com.dsportal.qa.pages.QueueOperationsPg;
import com.dsportal.qa.pages.QueuePage;
import com.dsportal.qa.pages.SignInPage;

public class QueueOperationsPgTest extends TestBase{
	
	Logger logger=Logger.getLogger("Queue Operations page Test");
	
	GetStartedPage getstart;
	HomePage homepg;
	SignInPage signin;
	QueuePage queuepg;
	QueueOperationsPg queOperationpg;
	
	
	public QueueOperationsPgTest()
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
		queOperationpg= new QueueOperationsPg();
		queOperationpg=queuepg.OpenQueueOperations();
		
		}
	
		
	@Test
	public void QueueOperationEditorTest() throws InterruptedException
	{
		logger.info("Queue operations editor");
		
		txmsg=queOperationpg.QueueOperationEditor(prop.getProperty("code"));
		Thread.sleep(2);
		Assert.assertEquals(txmsg,"Welcome");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}

}
