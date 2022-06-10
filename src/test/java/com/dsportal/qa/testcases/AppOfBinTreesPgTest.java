package com.dsportal.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dsportal.qa.base.TestBase;
import com.dsportal.qa.pages.AppOfBinTreesPg;
import com.dsportal.qa.pages.GetStartedPage;
import com.dsportal.qa.pages.HomePage;
import com.dsportal.qa.pages.ImplmOfBinTreesPg;
import com.dsportal.qa.pages.SignInPage;
import com.dsportal.qa.pages.TreePage;

public class AppOfBinTreesPgTest extends TestBase{
	
	GetStartedPage getstart;
	HomePage homepg;
	SignInPage signin;
	TreePage treepg;
	AppOfBinTreesPg appofbintrees;
	
	Logger logger=Logger.getLogger("Applications of Binary Trees Test");
	
	public AppOfBinTreesPgTest()
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
		treepg=new TreePage();
		treepg=homepg.OpenTreePage();
		appofbintrees= new AppOfBinTreesPg();
		appofbintrees=treepg.OpenAppOfBinTrees();
	}
	
	
	@Test
	public void AppOfBinTreesEditorTest()
	{
		logger.info("Application Of Binary Trees Editor");
		
		txmsg = appofbintrees.AppOfBinTreesEditor(prop.getProperty("code"));
		Assert.assertEquals(txmsg, "Welcome");
	}
	
	@AfterMethod
	public void teardown()
	{
		
		Logger logger=Logger.getLogger("Closing the browser");
		driver.close();
	}


}
