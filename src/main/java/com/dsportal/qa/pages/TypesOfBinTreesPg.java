package com.dsportal.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsportal.qa.base.TestBase;

public class TypesOfBinTreesPg extends TestBase {
	@FindBy(xpath="//a[contains(text(),'Try here>>>')]")
	WebElement tryhere;
	
	@FindBy(xpath="//form[@id='answer_form']/div/div/div/textarea")
	WebElement txtarea;
		
	@FindBy(tagName="button")
	WebElement runbtn;
		
	@FindBy(xpath="//div/pre[@id='output']")
	WebElement output;
	
	
	public TypesOfBinTreesPg()
	{
		PageFactory.initElements(driver, this);
	}
	
		
	public String TypesOfBinTreesEditor(String code)
	{
		tryhere.click();
		txtarea.sendKeys(code);
		runbtn.click();
		return output.getText();
	}


}
