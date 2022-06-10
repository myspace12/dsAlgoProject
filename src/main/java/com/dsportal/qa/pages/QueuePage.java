package com.dsportal.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsportal.qa.base.TestBase;

public class QueuePage extends TestBase {
	
		
	@FindBy(xpath="//a[contains(text(),'Implementation of Queue in Python')]")
	WebElement Qbtn1;
	
	@FindBy(xpath="//a[contains(text(),'Implementation using collections.deque')]")
	WebElement Qbtn2;
	
	@FindBy(xpath="//a[contains(text(),'Implementation using array')]")
	WebElement Qbtn3;
	
	@FindBy(xpath="//a[contains(text(),'Queue Operations')]")
	WebElement Qbtn4;
	
	
	
					
	public QueuePage() 
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public String ValidationOfQueuePg()
	{
		return driver.getTitle();
		
	}
	
	public ImplimentationOfQueuePg OpenImplimentationOfQueue()
	{
		Qbtn1.click();
		return new ImplimentationOfQueuePg();
	}
	

	public CollectiondqueuePg OpenCollectiondqueue()
	{
		Qbtn2.click();
		return new CollectiondqueuePg();
	}
	
	public ImplimentationUsingArrayPg OpenImplimentationUsingArray()
	{
		Qbtn3.click();
		return new ImplimentationUsingArrayPg();
	}
	
		
	public QueueOperationsPg OpenQueueOperations()
	{
		Qbtn4.click();
		return new QueueOperationsPg();
	}
	
	

}
