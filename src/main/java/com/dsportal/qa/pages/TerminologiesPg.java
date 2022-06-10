package com.dsportal.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsportal.qa.base.TestBase;

public class TerminologiesPg extends TestBase {
	@FindBy(xpath="//a[contains(text(),'Try here>>>')]")
	//@FindBy(xpath="//a[@href='/tryEditor']")
	
	//@FindBy(xpath="//a[@class='btn btn-info']")
	WebElement tryhere;
	
	@FindBy(xpath="//form[@id='answer_form']/div/div/div/textarea")
	WebElement txtarea;
		
	@FindBy(tagName="button")
	WebElement runbtn;
		
	@FindBy(xpath="//div/pre[@id='output']")
	WebElement output;
	
	//practice question button 
	@FindBy(xpath="//a[contains(text(),'Practice Questions')]")
	 WebElement practicequebtn;
			
	public TerminologiesPg()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String TerminologiesEditor(String code)
	{
		tryhere.click();
		txtarea.sendKeys(code);
		runbtn.click();
		return output.getText();
		
	}
	public TreePracticeQuePg OpenPracticeQuestionPg()
	{
		practicequebtn.click();
		
		return new TreePracticeQuePg();
	}

}
