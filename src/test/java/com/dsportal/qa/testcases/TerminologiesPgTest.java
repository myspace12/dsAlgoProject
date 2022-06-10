package com.dsportal.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dsportal.qa.base.TestBase;
import com.dsportal.qa.pages.GetStartedPage;
import com.dsportal.qa.pages.HomePage;
import com.dsportal.qa.pages.QueueOperationsPg;
import com.dsportal.qa.pages.QueuePage;
import com.dsportal.qa.pages.SignInPage;
import com.dsportal.qa.pages.TerminologiesPg;
import com.dsportal.qa.pages.TreePage;

public class TerminologiesPgTest extends TestBase {
	GetStartedPage getstart;
	HomePage homepg;
	SignInPage signin;
	TreePage tree;
	TerminologiesPg trmnpg;
	
		
	public TerminologiesPgTest()
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
		tree=new TreePage();
		tree=homepg.OpenTreePage();
		tree.OpenTerminologiesPg();
		trmnpg= new TerminologiesPg();
		trmnpg=tree.OpenTerminologiesPg();		
		}
	
		
	@Test(priority=1)
	public void TerminologiesEditorTest()
	{
		txmsg = trmnpg.TerminologiesEditor(prop.getProperty("code"));
		Assert.assertEquals(txmsg, "Welcome");
	}
	
	
	@Test(priority=2)
	public void OpenPracticeQuestionPgTest() 
	{
		trmnpg.OpenPracticeQuestionPg();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}


}
