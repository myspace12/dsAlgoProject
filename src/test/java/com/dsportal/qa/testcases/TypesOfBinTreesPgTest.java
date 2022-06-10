package com.dsportal.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dsportal.qa.base.TestBase;
import com.dsportal.qa.pages.BinaryTreesPg;
import com.dsportal.qa.pages.GetStartedPage;
import com.dsportal.qa.pages.HomePage;
import com.dsportal.qa.pages.SignInPage;
import com.dsportal.qa.pages.TreePage;
import com.dsportal.qa.pages.TypesOfBinTreesPg;

public class TypesOfBinTreesPgTest extends TestBase {
	
	GetStartedPage getstart;
	HomePage homepg;
	SignInPage signin;
	TreePage treepg;
	TypesOfBinTreesPg typesofbintrees;
	
	public TypesOfBinTreesPgTest()
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
		typesofbintrees= new TypesOfBinTreesPg();
		typesofbintrees=treepg.OpenTypesOfBinTrees();
	}

		@Test
	public void BinaryTreesEditorTest()
	{
		txmsg = typesofbintrees.TypesOfBinTreesEditor(prop.getProperty("code"));
		Assert.assertEquals(txmsg, "Welcome");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}

	

}
