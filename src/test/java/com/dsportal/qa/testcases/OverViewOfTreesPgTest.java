package com.dsportal.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dsportal.qa.base.TestBase;
import com.dsportal.qa.pages.GetStartedPage;
import com.dsportal.qa.pages.HomePage;
import com.dsportal.qa.pages.OverViewOfTreesPg;
import com.dsportal.qa.pages.SignInPage;
import com.dsportal.qa.pages.TerminologiesPg;
import com.dsportal.qa.pages.TreePage;

public class OverViewOfTreesPgTest extends TestBase {
	
	GetStartedPage getstart;
	HomePage homepg;
	SignInPage signin;
	TreePage treepg;
	OverViewOfTreesPg overviewoftrees;
	
	public OverViewOfTreesPgTest()
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
	}
	
	
	@Test
	public void OverViewOfTreesEditorTest()
	{
		txmsg= overviewoftrees.OverViewOfTreesEditor(prop.getProperty("code"));
		Assert.assertEquals(txmsg, "Welcome");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}

}

