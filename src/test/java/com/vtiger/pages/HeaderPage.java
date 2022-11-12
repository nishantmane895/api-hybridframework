package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.CommonFunctions;

public class HeaderPage {
	
public WebDriver driver;
public CommonFunctions cf;
ExtentTest logger;
	
	public HeaderPage(WebDriver driver,ExtentTest logger)
	{
		this.driver = driver;
		this.logger=logger;
		PageFactory.initElements(driver, this);
		cf = new CommonFunctions(driver,logger);
	}
	
	
	
	@FindBy(linkText="Leads")
	WebElement lnk_Leads;
	
	@FindBy(linkText="New Lead")
	WebElement lnk_NewLead;
	
	@FindBy(linkText="Logout")
	WebElement lnk_Logout;
	
	@FindBy(linkText="New Account")
	WebElement lnk_NewAccount;
	
	@FindBy(linkText="Accounts")
	WebElement lnk_Accounts;
	
	@FindBy(linkText="New Contact")
	WebElement lnk_newContact;
	
	
	
	public void verifyLogout()
	{
		cf.IsElementDisplay(lnk_Logout,"Logout link displayed successfully");
	}
	
	public void ClickLogout()
	{
		cf.ClickElement(lnk_Logout,"Logout link clicked successfully");
	}
	
	public void ClickNewLead()
	{
		cf.ClickElement(lnk_NewLead,"New Lead link clicked successfully");
	}
	
	public void ClickNewAccount()
	{
		cf.ClickElement(lnk_NewAccount,"New Account link clicked successfully");
	}
	
	public void ClickNewContact()
	{
		cf.ClickElement(lnk_newContact,"New Contact link clicked successfully");
	}
	
	

}
