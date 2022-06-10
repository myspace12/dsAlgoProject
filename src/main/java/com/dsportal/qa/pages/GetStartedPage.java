package com.dsportal.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsportal.qa.base.TestBase;

public class GetStartedPage extends TestBase {
	
	//Page Factory (OR)

	@FindBy(tagName ="button")
	WebElement btn;

//initializing the page object
public GetStartedPage()
{
	PageFactory.initElements(driver, this);
}

//Actions:
public String validateGetStartedPage()
{
	
	return driver.getTitle();
}

public HomePage GetStarted()
{
	btn.click();
	return new HomePage();
}

}