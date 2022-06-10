package com.dsportal.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsportal.qa.base.TestBase;

public class ImplimentationOfQueuePg extends TestBase {
	
	@FindBy(xpath="//a[contains(text(),'Try here>>>')]")
	WebElement tryhere;
	
	//@FindBy(xpath="//pre[@class=' CodeMirror-line ']")
		@FindBy(xpath="//form[@id='answer_form']/div/div/div/textarea")
		WebElement txtarea;
		
		@FindBy(tagName="button")
		WebElement runbtn;
		
		@FindBy(xpath="//div/pre[@id='output']")
		WebElement output;

	
	public ImplimentationOfQueuePg()
	{
		PageFactory.initElements(driver, this);
	}
	
	
			
	public String ImplOfQueueEditor(String code)
	{
		tryhere.click();

		txtarea.sendKeys(code);
		runbtn.click();
		return output.getText();
		
	}
	
	
}
