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
import com.dsportal.qa.pages.SignInPage;
import com.dsportal.qa.pages.TraversalIllustrationPg;
import com.dsportal.qa.pages.TreePage;
import com.dsportal.qa.pages.TreeTravarsalsPg;

public class TraversalIllustrationPgTest extends TestBase {
	
	GetStartedPage getstart;
	HomePage homepg;
	SignInPage signin;
	TreePage treepg;
	TraversalIllustrationPg traversalillus;
	
	public TraversalIllustrationPgTest()
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
		traversalillus= new TraversalIllustrationPg();
		traversalillus=treepg.OpenTraversalIllustration();
	}
	

		
	@Test
	public void TreeTravarsalEditorTest()
	{
		txmsg = traversalillus.TraversalIllusEditor(prop.getProperty("code"));
		Assert.assertEquals(txmsg, "Welcome");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}

	

}
