package com.dsportal.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.dsportal.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(linkText="Register")
	WebElement register;
	
	@FindBy(linkText="Sign in")
	WebElement SignIn;
	
	@FindBy(xpath="//a[1][@href='data-structures-introduction']")
	WebElement btn1;
	
	@FindBy(xpath="//a[contains(text(),'Data Structures')]")
	WebElement DSDropdown;
	

	@FindBy(xpath="//a[@href='tree']")
	WebElement treebtn;
	
	@FindBys(@FindBy(className="dropdown-item"))
	public List <WebElement> li;
	
	@FindBy(xpath="//div[@class='alert alert-primary']")
	WebElement txt_alert;
	
	//you are logged in msg validation
	@FindBy(xpath="//div[@role='alert']")
	WebElement txt;
	
	//username after logged in
	@FindBy(xpath="//div[@id='navbarCollapse']//ul/a[2]")
	WebElement user;
	
		
	@FindBy(xpath="//div[3]/div[5]//a[1][@href='queue']")
	WebElement qbtn;
	
	//Registration confirmation message
	@FindBy(xpath="//div[@class='alert alert-primary']")
	WebElement registerconfirm;
	
	//Sign out button
	@FindBy(xpath="//ul/a[3][@href='/logout']")
	WebElement signout;
		
//initializing the page object
public HomePage()
{
	PageFactory.initElements(driver, this);
}

public String validateHomePage()
{
	return driver.getTitle();
}


public int clickonDropDown()
{
	DSDropdown.click();
	System.out.println(li.size());
	return li.size();
}

public String ClickWithoutLogin()
{
	btn1.click();
	return txt_alert.getText();
	
}

public RegistrationPage OpenRegPage()
{
	register.click();
	return new RegistrationPage();
}

public String ConirmRegitration()
{
	txmsg=registerconfirm.getText();
	return txmsg;
	
}

public HomePage signout()
{
	signout.click();
	return new HomePage();
}

public SignInPage OpenSignInPage()
{
	SignIn.click();
	return new SignInPage();
			
}

public String UserSigninValidation()
{
	return txt.getText();
}

public String VerifyUsername()
{
	String name=user.getText();
	System.out.println("User Name is "+name);
	return name;
	//return user.isDisplayed();
}
	
public QueuePage OpenQueuePg()
{
	qbtn.click();
	return new QueuePage();
}

public TreePage OpenTreePage()
{
	treebtn.click();
	return new TreePage();
}

public DataStructuresPg OpenDataStructurePage()
{
	btn1.click();
	return new DataStructuresPg();
}

}