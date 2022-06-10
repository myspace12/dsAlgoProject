package com.dsportal.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dsportal.qa.base.TestBase;
import com.dsportal.qa.pages.CollectiondqueuePg;
import com.dsportal.qa.pages.GetStartedPage;
import com.dsportal.qa.pages.HomePage;
import com.dsportal.qa.pages.ImplimentationUsingArrayPg;
import com.dsportal.qa.pages.QueuePage;
import com.dsportal.qa.pages.SignInPage;

public class ImplimentationUsingArrayPgTest extends TestBase {
	
	Logger logger=Logger.getLogger("Implementation using array Test");
	
	GetStartedPage getstart;
	HomePage homepg;
	SignInPage signin;
	QueuePage queuepg;
	ImplimentationUsingArrayPg implarray;
	
	public ImplimentationUsingArrayPgTest()
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
		implarray= new ImplimentationUsingArrayPg();
		implarray=queuepg.OpenImplimentationUsingArray();
	}
      

@Test
public void ImplOfQueueEditorTest() 
{
	logger.info("Implementation using array editor ");
	
	txmsg=implarray.ImplUsingArrayEditor(prop.getProperty("code"));
	Assert.assertEquals(txmsg,"Welcome");
}

@AfterMethod

public void teardown()
{
driver.close();
}



}
