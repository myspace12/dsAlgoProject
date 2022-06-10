package com.dsportal.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsportal.qa.base.TestBase;

public class PracticeQuePg extends TestBase{

	@FindBy(xpath="//a[contains(text(),'Practice Questions')]")
	WebElement practiceque;
	
	public PracticeQuePg()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String ValidationOfPracticeQuePg()
	{
		txmsg=driver.getTitle();
		return txmsg;
	}
}
