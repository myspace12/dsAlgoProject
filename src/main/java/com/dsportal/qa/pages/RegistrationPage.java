package com.dsportal.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsportal.qa.base.TestBase;

public class RegistrationPage extends TestBase {
	
	@FindBy(xpath= "//input[@name='username']")
	WebElement usernm;
	
	
	@FindBy(xpath= "//input[@id='id_password1']")
	WebElement pwd1;
	

	@FindBy(xpath= "//input[@id='id_password2']")
	WebElement pwd2;
	
	@FindBy(xpath= "//input[@value='Register']")
	WebElement btn;
	
	//invalid password msg
	@FindBy(xpath= "//div[@class='alert alert-primary']")
	WebElement invpwdmsg;
	
	//confirm registration
	@FindBy(xpath="//div[@class='alert alert-primary']")
	WebElement registerconfirm;
	
	
	//initializing the page object
	public RegistrationPage()
	{
		//following method will initialize page factory. here this shows current class object
		PageFactory.initElements(driver, this);
	}
	
	public String RegPageValidation()
	{
		return driver.getTitle();
	}
	
		
	public String RegWithBlankFields(String usrnm, String pwd, String pswd)
	{
		usernm.clear();
		usernm.sendKeys(usrnm);
		pwd1.sendKeys(pwd);
		pwd2.sendKeys(pswd);
		btn.click();
		if( usrnm.isBlank())
			return usernm.getAttribute("validationMessage");
			
			else if(pwd.isBlank())
				return pwd1.getAttribute("validationMessage");
		
			else if(pswd.isBlank())
				return pwd2.getAttribute("validationMessage");
		
			else
				return null;
			
	}
	public String InvUsernm(String usrnm, String pwd, String pswd)
	{
		usernm.clear();
		usernm.sendKeys(usrnm);
		pwd1.clear();
		pwd1.sendKeys(pwd);
	    pwd2.clear();
		pwd2.sendKeys(pswd);
		btn.click();
		txmsg =invpwdmsg.getText();
		
		return txmsg;
	}
	
	public String RegisterWithPasswdNumbers(String usrnm, String pwd, String pswd)
	{
		usernm.clear();
		usernm.sendKeys(usrnm);
		pwd1.clear();
		pwd1.sendKeys(pwd);
		pwd2.clear();
		pwd2.sendKeys(pswd);
		btn.click();
			
		txmsg =invpwdmsg.getText();
		return txmsg;
			
	}
	
	public HomePage RegisterValidUser(String usrnm, String pwd ,String pswd)
	{
		usernm.clear();
		usernm.sendKeys(usrnm);
		pwd1.clear();
		pwd1.sendKeys(pwd);
		pwd2.clear();	
		pwd2.sendKeys(pswd);
		btn.click();
		
		System.out.println(registerconfirm.getText());
	
		return new HomePage();
		
	}
	
	
	}


