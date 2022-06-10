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
import com.dsportal.qa.pages.ImplmInPythonPg;
import com.dsportal.qa.pages.SignInPage;
import com.dsportal.qa.pages.TreePage;
import com.dsportal.qa.pages.TypesOfBinTreesPg;

public class ImplmInPythonPgTest extends TestBase {
	

	GetStartedPage getstart;
	HomePage homepg;
	SignInPage signin;
	TreePage treepg;
	ImplmInPythonPg implminpython;
	
	Logger logger=Logger.getLogger("Implementation in Python Page Test");
	
	public ImplmInPythonPgTest()
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
		implminpython= new ImplmInPythonPg();
		implminpython=treepg.OpenImplmInPython();
	}
	
		
	@Test
	public void ImplmInPythonEditorTest()
	{
		Logger logger=Logger.getLogger("Implementation inpython editor ");
		
		txmsg = implminpython.ImplmInPythonPgEditor(prop.getProperty("code"));
		Assert.assertEquals(txmsg, "Welcome");
	}
	
	@AfterMethod
	public void teardown()
	{
		Logger logger=Logger.getLogger("Closing the browser");
		driver.close();
	}


}
