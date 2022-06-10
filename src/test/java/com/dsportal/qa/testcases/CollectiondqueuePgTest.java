package com.dsportal.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dsportal.qa.base.TestBase;
import com.dsportal.qa.pages.CollectiondqueuePg;
import com.dsportal.qa.pages.GetStartedPage;
import com.dsportal.qa.pages.HomePage;
import com.dsportal.qa.pages.ImplimentationOfQueuePg;
import com.dsportal.qa.pages.QueuePage;
import com.dsportal.qa.pages.SignInPage;

public class CollectiondqueuePgTest extends TestBase {
	
	Logger logger=Logger.getLogger("Implementation uing collection dqueue Page Test");
	
	GetStartedPage getstart;
	HomePage homepg;
	SignInPage signin;
	QueuePage queuepg;
	CollectiondqueuePg collectiondq;
	
	
	
	public CollectiondqueuePgTest()
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
		collectiondq= new CollectiondqueuePg();
		collectiondq=queuepg.OpenCollectiondqueue();
	}
	
	
	
	@Test
	public void CollectionDqueueEditorTest() 
	
	{
		logger.info("Collections dqueue editor");
		
		txmsg=collectiondq.CollectiondqueueEditor(prop.getProperty("code"));
		Assert.assertEquals(txmsg,"Welcome");
	}
	
	@AfterMethod
	
	public void teardown()
	{
	driver.close();
	}


}
