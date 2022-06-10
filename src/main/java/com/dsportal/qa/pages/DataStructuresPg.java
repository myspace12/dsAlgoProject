package com.dsportal.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsportal.qa.base.TestBase;

public class DataStructuresPg extends TestBase {
	
	@FindBy(xpath="//a[contains(text(),'Time Complexity')]")
	WebElement timecomplexity;
	
	public DataStructuresPg()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String ValidationOfDataStructuresPg()
	{
		return driver.getTitle();
	}
	
	public TimeComplexityPg OpenTimeComplexityPg()
	{
		timecomplexity.click();
		return new TimeComplexityPg();
	}
	
	
}
