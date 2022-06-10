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
import com.dsportal.qa.pages.QueuePage;
import com.dsportal.qa.pages.SignInPage;

public class QueuePageTest extends TestBase {
	GetStartedPage getstart;
	HomePage homepg;
	SignInPage signin;
	QueuePage queuepg;
	
	Logger logger=Logger.getLogger("Queue Page Test");
		
	public QueuePageTest()
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
	}
	
	@Test(priority=1)
	public void ValidationOfQueuePgTest() 
	{
		logger.info("Queue page validation test");
		
		String title=queuepg.ValidationOfQueuePg();
		Assert.assertEquals(title, "Queue");
	}
	
	@Test(priority=2)
	public void OpenImplimentationOfQueueTest()
	{
		logger.info("Click on the Implementation of Queue ");
		
		queuepg.OpenImplimentationOfQueue();
		
		//driver.navigate().back();
	}
	
	@Test(priority=3)
	public void OpenCollectiondqueueTest()
	{
		logger.info("Click on the Implementation using collections.dqueue ");
		
		queuepg.OpenCollectiondqueue();
		
		//driver.navigate().back();
	}
	
	@Test(priority=4)
	public void OpenImplimentationUsingArrayTest()
	{
		logger.info("Click on the Implementation using Array ");
		
		queuepg.OpenImplimentationUsingArray();
		
		//driver.navigate().back();
	}
	
	@Test(priority=5)
	public void OpenQueueOperationsTest()
	{
		logger.info("Click on the Queue Operations  ");
		
		queuepg.OpenQueueOperations();
		
		//driver.navigate().back();
	}
		
	@AfterMethod
	public void teardown()
	{
		
		logger.info("Close the browser ");
		driver.close();
	}
	
	}
