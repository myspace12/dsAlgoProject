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
import com.dsportal.qa.pages.QueuePage;
import com.dsportal.qa.pages.SignInPage;
import com.dsportal.qa.pages.TreePage;

public class TreePageTest extends TestBase {
	
	GetStartedPage getstart;
	HomePage homepg;
	SignInPage signin;
	TreePage treepg;
	
	Logger logger=Logger.getLogger("Tree Page Test");
	
	public TreePageTest()
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
	}
	
	@Test
	public void ValidationOfTreePgTest()
	{
        logger.info("Validating the title of Tree page");
		
		String title=treepg.ValidationOfTreePg();
		Assert.assertEquals(title, "Tree");
	}
	
	@Test
	public void OpenOverViewOfTreesTest() throws InterruptedException
	{
		logger.info("Open Overview of Trees page");
		
		treepg.OpenOverViewOfTrees();
		
		//driver.navigate().back();
	}
	
	@Test
	public void OpenTerminologiesPgTest()
	{
		logger.info("Open Terminologies page");
		
		treepg.OpenTerminologiesPg();
		
		//driver.navigate().back();
	}
	
	@Test
	public void OpenTypesOfTreesTest()
	{
		
		logger.info("Open Types of Trees Page");
		
		treepg.OpenTypesOfTrees();
		
		//driver.navigate().back();
	}
	
	@Test
	public void OpenTreeTraversalsTest()
	{
		logger.info("Open Tree Traversal page");
		
		treepg.OpenTreeTraversals();
		
		//driver.navigate().back();
	}
	
	@Test
	public void OpenTraversalIllustrationTest()
	{
		logger.info("Open Traversl Illustration page");
		
		treepg.OpenTraversalIllustration();
		
		//driver.navigate().back();
	}
	
	@Test
	public void OpenBinaryTreesTest()
	{
		logger.info("Open Binary Trees Test");
		
		treepg.OpenBinaryTrees();
		
		//driver.navigate().back();
	}
	
	@Test
	public void OpenTypesOfBinTreesTest()
	{
		logger.info("Open Types of Binary Trees Test");
		
		treepg.OpenTypesOfBinTrees();
		
		//driver.navigate().back();
	}
	
	@Test
	public void OpenImplmInPythonTest()
	{
		logger.info("Open implementation in python page");
		
		treepg.OpenImplmInPython();
		
		//driver.navigate().back();
	}
	
	@Test
	public void OpenBinTreeTraversalTest()
	{
		logger.info("Open Binary Tree Traversal Page");
		
		treepg.OpenBinTreeTraversal();
		
	//	driver.navigate().back();
	}
	
	@Test
	public void OpenImplmOfBinTreesTest()
	{
		logger.info("Open Implementation of Binary Tree Page");
		
		treepg.OpenImplmOfBinTrees();
		
		//driver.navigate().back();
	}
	
	@Test
	public void OpenAppOfBinTreesTest()
	{
		logger.info("Open Application of Binary Tree Page");
		
		treepg.OpenAppOfBinTrees();
		
		//driver.navigate().back();
	}
	
	@Test
	public void OpenBinSearchTreesTest()
	{
		logger.info("Open Binary Search Tree Page");
		
		treepg.OpenBinSearchTrees();
		
		//driver.navigate().back();
	}
	
	@Test
	public void OpenImplmOfBSTTest()
	{
		logger.info("Open Implementation of BST Page");
		
		treepg.OpenImplmOfBST();
		
		//driver.navigate().back();
	}
	
	@AfterMethod
	public void teardown()
	{
		
		logger.info("Closing the browser");
		driver.close();
	}

}
