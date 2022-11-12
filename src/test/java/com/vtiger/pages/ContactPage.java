package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

public class ContactPage extends HeaderPage
{

	public ContactPage(WebDriver driver, ExtentTest logger)
	{
		super(driver, logger);
		PageFactory.initElements(driver, this);
		
	}

	
	@FindBy(name="salutationtype")
	WebElement dd_salutation;
	
	@FindBy(name="firstname")
	WebElement tb_firstname;
	
	@FindBy(name="lastname")
	WebElement tb_lastname;
	
	@FindBy(xpath="(//input[contains(@type,'submit')])[2]")
	WebElement btn_save;
	
	@FindBy(xpath="//td[@class='moduleTitle']")
	WebElement txt_contact;
	
	@FindBy(name="fax")
	WebElement tb_fax;
	
	
	
	
	public void CreateNewContact(String slt, String fname, String lname, String cnt)
	{
		EnterSalutation(slt);
		EnterFirstName(fname);
		EnterLastName(lname);
		ClickOnSave();
		VerifyNewContact(cnt);
		
	}
	
	
	public void EnterSalutation(String slt)
	{
		cf.SelectVisibleText(dd_salutation, slt, slt+"Slutation entered successfully");
	}
	
	public void EnterFirstName(String fname)
	{
		cf.EnterValue(tb_firstname, fname, fname+"Firstname Entered Successfully");
	}
	
	public void EnterLastName(String lname)
	{
		cf.EnterValue(tb_lastname, lname, lname+"Lastname Entered Successfully");
	}
	
	public void ClickOnSave()
	{
		cf.ClickElement(btn_save, "New Contact Saved Successfully");
	}
	
	public void VerifyNewContact(String cnt)
	{
		String txt = txt_contact.getText();
		
		if (txt.equalsIgnoreCase(cnt))
		{
			System.out.println("New contact is verified");
		}
		else
		{
			System.out.println("Contact is not added");
		}

	}
	
	public void EnterFax(String fax)
	{
		cf.EnterValue(tb_fax, fax, fax+" Fax no Entered successfully");
	}
	
	
}
