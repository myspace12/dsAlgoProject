package com.dsportal.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dsportal.qa.base.TestBase;
import com.dsportal.qa.pages.BinTreeTraversalPg;
import com.dsportal.qa.pages.GetStartedPage;
import com.dsportal.qa.pages.HomePage;
import com.dsportal.qa.pages.ImplmInPythonPg;
import com.dsportal.qa.pages.SignInPage;
import com.dsportal.qa.pages.TreePage;

public class BinTreeTraversalPgTest extends TestBase{
	
	GetStartedPage getstart;
	HomePage homepg;
	SignInPage signin;
	TreePage treepg;
	BinTreeTraversalPg bintreetraversal;
	
	public BinTreeTraversalPgTest()
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
		bintreetraversal= new BinTreeTraversalPg();
		bintreetraversal=treepg.OpenBinTreeTraversal();
	}
	
		
	@Test
	public void BinaryTreeTraversalEditorTest()
	{
		txmsg = bintreetraversal.BinTreeTraversalPgEditor(prop.getProperty("code"));
		Assert.assertEquals(txmsg, "Welcome");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}


}
