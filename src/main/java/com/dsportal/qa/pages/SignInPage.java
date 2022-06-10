package com.dsportal.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsportal.qa.base.TestBase;

public class SignInPage extends TestBase {
	
	@FindBy(xpath = "//input[@name='username']")
			WebElement usernm;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement pwd;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginbtn;
	
	//Message for invalid inputs
	@FindBy(xpath="//div[@class='alert alert-primary']")
	WebElement msg;
	
		
	public SignInPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String SignInPgValidation()
	{
		return driver.getTitle();
	}
	
	public HomePage UserSignIN(String un, String pw)
	{
		usernm.clear();
		usernm.sendKeys(un);
		pwd.sendKeys(pw);
		loginbtn.click();
		
		return new HomePage();
	}
	
	public String SignInWithInvInput(String un, String pw)
	{
	    usernm.clear();
	    usernm.sendKeys(un);
	    pwd.sendKeys(pw);
	    loginbtn.click();
	    
	    return msg.getText();
	   	
	}
	
	public String SignInWithInvPasswd(String un, String pw)
	{
	    usernm.clear();
	    usernm.sendKeys(un);
	    pwd.sendKeys(pw);
	    loginbtn.click();
	    
	    return msg.getText();
	   		
	}
	
	public String SignInWithBlankFields(String un, String pw)
	{
		usernm.clear();
		usernm.sendKeys(un);
		pwd.clear();
		pwd.sendKeys(pw);
		loginbtn.click();
		if( un.isBlank())
			return usernm.getAttribute("validationMessage");
			
			else if(pw.isBlank())
				return pwd.getAttribute("validationMessage");
		
			else
				return null;
	}


}
