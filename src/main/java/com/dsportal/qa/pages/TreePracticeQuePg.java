package com.dsportal.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsportal.qa.base.TestBase;

public class TreePracticeQuePg extends TestBase {
	
	@FindBy(xpath="//a[contains(text(),'Practice Questions')]")
	WebElement practiceque;
	
	public TreePracticeQuePg()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String ValidationOfPracticeQuePg()
	{
		txmsg=driver.getTitle();
		return txmsg;
	}

}
