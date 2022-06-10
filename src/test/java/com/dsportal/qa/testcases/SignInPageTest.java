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
import com.dsportal.qa.pages.RegistrationPage;
import com.dsportal.qa.pages.SignInPage;
import com.dsportal.qa.util.ExcelUtils;

public class SignInPageTest extends TestBase {
	GetStartedPage getstart;
	HomePage homepg;
	SignInPage signin;
	
	Logger logger=Logger.getLogger("Sign In Page Test");
	
	public SignInPageTest()
	{
		//calling parent class ie. TestBase class
		super();
	}
	
	@BeforeMethod
	public void Setup()
	{
		initialization();
		getstart= new GetStartedPage();
		getstart.GetStarted();
		homepg = new HomePage();
		homepg.OpenSignInPage();
		signin= new SignInPage();
		
				
	}
	
	@Test(priority=1)
	public void SignInPgValidationTest()
	{
		logger.info("Sign in page validation test");
		
		String title= signin.SignInPgValidation();
		Assert.assertEquals(title, "Login");
	}
	
	@Test
	
		public void UserSignInWithInvalidInputTest()
		{
		
		logger.info("Sign in Functionality test with providing invalid inputs through Excel sheet");
		   		
			ExcelUtils read= new ExcelUtils("C:\\Users\\rupal\\eclipse-workspace\\dsalgoproject\\src\\main\\java\\com\\dsportal\\qa\\testdata\\InvalidSignInData.xlsx");
		
           int row=read.getRowCount("sheet1");
			
			for(int i=2;i<=row;i++)
			{
				txmsg=signin.SignInWithInvInput(read.getCellData("sheet1","usernm", i), read.getCellData("sheet1","passwd", i));
				System.out.println(txmsg);
				
				Assert.assertEquals(txmsg, "Invalid Username and Password");
											
			}
			
					
		}
	
	@Test(priority=2)
	public void SignInWithBlankFieldsTest()
	{
		logger.info("Sign in with all blank fields test");
		
		txmsg=signin.SignInWithBlankFields(prop.getProperty("UN_blank"), prop.getProperty("PWD_blank"));
		Assert.assertEquals(txmsg, "Please fill out this field.");
	}
	
	
	@Test(priority=3)
	public void SignInWithUsernmBlankTest()
	{
		logger.info("Sign in with blank username field test");
		
		txmsg=signin.SignInWithBlankFields(prop.getProperty("UN_blank"), prop.getProperty("Passwd"));
		Assert.assertEquals(txmsg, "Please fill out this field.");
	}
	
	
	@Test(priority=4)
	public void SignInWithPwdBlankTest()
	{
		logger.info("Sign in with blank password field test");
		
		txmsg=signin.SignInWithBlankFields(prop.getProperty("username"), prop.getProperty("PWD_blank"));
		Assert.assertEquals(txmsg, "Please fill out this field.");
	}
	
	
	
		
	@Test(priority=7)
	public void UserSignIn() 
	{
		logger.info("Sign in with valid username and password test");
		
		signin.UserSignIN(prop.getProperty("username"), prop.getProperty("Passwd"));
		
	}
	
	
	@AfterMethod
	public void teardown()
	{
		logger.info("Close the browser");
		
		driver.close();
	}

}
