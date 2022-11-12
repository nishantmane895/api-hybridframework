package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class AccountPage extends HeaderPage {

	public AccountPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="accountname")
	WebElement tb_accountname;
	
	@FindBy(name="button")
	WebElement btn_button;
	
	public void createaccount(String accountName)
	{
		setAccountName(accountName);
		clickSave();
	}
	
	public void setAccountName(String accountName)
	{
		cf.EnterValue(tb_accountname, accountName, accountName+" has been entered");
	}
	public void clickSave()
	{
		cf.ClickElement(btn_button, "save button clicked");
	}
	
	

}
