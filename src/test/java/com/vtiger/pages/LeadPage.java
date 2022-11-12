package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class LeadPage extends HeaderPage {

	public LeadPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="firstname")
	WebElement tb_firstname;
	
	@FindBy(name="lastname")
	WebElement tb_lastname;
	
	@FindBy(name="company")
	WebElement tb_company;
	
	@FindBy(name="fax")
	WebElement tb_fax;
	
	@FindBy(name="button")
	WebElement btn_button;
	
	
	public void createlead(String fname,String lname,String comp, String fax)
	{
		setFirstName(fname);
		setLastName(lname);
		setCompany(comp);
		EnterFaxNumber(fax);
		clickSave();		
	}
	
	public void setFirstName(String fname)
	{
		cf.EnterValue(tb_firstname, fname, fname+" has been entered");
	}
	
	public void setLastName(String lname)
	{
		cf.EnterValue(tb_lastname, lname, lname+" has been entered");
	}
	
	public void setCompany(String comp)
	{
		cf.EnterValue(tb_company, comp, comp+" has been entered");
	}
	
	public void EnterFaxNumber(String fax)
	{
		cf.EnterValue(tb_company, fax, fax+" has been entered");
	}
	
	public void clickSave()
	{
		cf.ClickElement(btn_button, "save button clicked");
	}
	
	
	
	

}
