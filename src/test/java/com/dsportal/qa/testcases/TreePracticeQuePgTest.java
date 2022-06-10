package com.dsportal.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dsportal.qa.base.TestBase;
import com.dsportal.qa.pages.GetStartedPage;
import com.dsportal.qa.pages.HomePage;
import com.dsportal.qa.pages.OverViewOfTreesPg;
import com.dsportal.qa.pages.PracticeQuePg;
import com.dsportal.qa.pages.QueueOperationsPg;
import com.dsportal.qa.pages.QueuePage;
import com.dsportal.qa.pages.SignInPage;
import com.dsportal.qa.pages.TreePage;
import com.dsportal.qa.pages.TreePracticeQuePg;

public class TreePracticeQuePgTest extends TestBase {

	GetStartedPage getstart;
	HomePage homepg;
	SignInPage signin;
	TreePage treepg;
	TreePracticeQuePg treepracticeque;
	OverViewOfTreesPg overviewoftrees;
		
	Logger logger=Logger.getLogger("Tree Practice Questions page Test");
	
	
	public TreePracticeQuePgTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialization();
		getstart=new GetStartedPage();
		homepg=new HomePage();
		homepg=getstart.GetStarted();
		signin=new SignInPage();
		signin=homepg.OpenSignInPage();
		signin.UserSignIN(prop.getProperty("username"), prop.getProperty("Passwd"));
		treepg=new TreePage();
		treepg=homepg.OpenTreePage();
		overviewoftrees= new OverViewOfTreesPg();
		overviewoftrees=treepg.OpenOverViewOfTrees();
		treepracticeque=new TreePracticeQuePg();
		treepracticeque= overviewoftrees.OpenTreePracticeQuePg();
		
		}
	@Test
	public void ValidateTreePracticeQuePg()
	{
		logger.info("Practice questions page is open");
		
		String title=treepracticeque.ValidationOfPracticeQuePg();
					
		Assert.assertEquals(title, "Practice Questions");
	}
	
	@AfterMethod
	public void teardown()
	{
		logger.info("Closing the driver");
		
		driver.close();
	}
}
