package com.dsportal.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsportal.qa.base.TestBase;

public class TreePage extends TestBase {
	
	@FindBy(xpath="//a[contains(text(),'Overview of Trees')]")
	WebElement overviewoftrees;
	
	@FindBy(xpath="//a[contains(text(),'Terminologies')]")
	WebElement terminologies;
	
	@FindBy(xpath="//a[contains(text(),'Types of Trees')]")
	WebElement typesoftrees;
	
	@FindBy(linkText="Tree Traversals")
	WebElement treetraversals;
	
	@FindBy(xpath="//a[contains(text(),'Traversals-Illustration')]")
	WebElement traversill;
	
	@FindBy(linkText="Binary Trees")
	WebElement bintree;
	
	@FindBy(xpath="//a[contains(text(),'Types of Binary Trees')]")
	WebElement typesofbintree;
	
	@FindBy(xpath="//a[contains(text(),'Implementation in Python')]")
	WebElement implmInpython;
	
	@FindBy(xpath="//a[contains(text(),'Binary Tree Traversals')]")
	WebElement bintreetraversal;
	
	@FindBy(xpath="//a[contains(text(),'Implementation of Binary Trees')]")
	WebElement implofbintrees;
	
	@FindBy(xpath="//a[contains(text(),'Applications of Binary trees')]")
	WebElement appofbintrees;
	
	@FindBy(xpath="//a[contains(text(),'Binary Search Trees')]")
	WebElement binsearchtrees;
	
	@FindBy(xpath="//a[contains(text(),'Implementation Of BST')]")
	WebElement implofbst;
	
	
		
	public TreePage()
{
		PageFactory.initElements(driver, this);
}

	public String ValidationOfTreePg()
	{
		return driver.getTitle();
		
	}
	
	public OverViewOfTreesPg OpenOverViewOfTrees() throws InterruptedException
	{
		overviewoftrees.click();
		Thread.sleep(2000);
		return new OverViewOfTreesPg();
	}
	
	public TerminologiesPg OpenTerminologiesPg()
	{
		terminologies.click();
		return new TerminologiesPg();
	}
	
	public TypesOfTreesPg OpenTypesOfTrees()
	{
		typesoftrees.click();
		return new TypesOfTreesPg();
	}
	
	public TreeTravarsalsPg OpenTreeTraversals()
	{
		treetraversals.click();
		return new TreeTravarsalsPg();
	}
	
	public TraversalIllustrationPg OpenTraversalIllustration()
	{
		traversill.click();
		return new TraversalIllustrationPg();
	}
	
	public BinaryTreesPg OpenBinaryTrees()
	{
		bintree.click();
		return new BinaryTreesPg();
	}
	
	public TypesOfBinTreesPg OpenTypesOfBinTrees()
	{
		typesofbintree.click();
		return new TypesOfBinTreesPg();
	}

	public ImplmInPythonPg OpenImplmInPython()
	{
		implmInpython.click();
		return new ImplmInPythonPg();
	}
	
	public BinTreeTraversalPg OpenBinTreeTraversal()
	{
		bintreetraversal.click();
		return new BinTreeTraversalPg();
	}
	
	public ImplmOfBinTreesPg OpenImplmOfBinTrees()
	{
		implofbintrees.click();
		return new ImplmOfBinTreesPg();
	}
	
	public AppOfBinTreesPg OpenAppOfBinTrees()
	{
		appofbintrees.click();
		return new AppOfBinTreesPg();
	}
	
	public BinSearchTreesPg OpenBinSearchTrees()
	{
		binsearchtrees.click();
		return new BinSearchTreesPg();
	}
	
	public ImplmOfBSTPg OpenImplmOfBST()
	{
		implofbst.click();
		return new ImplmOfBSTPg();
	}
}
