package com.vtiger.tests;

import org.testng.annotations.Test;

import com.vtiger.pages.ContactPage;
import com.vtiger.pages.HeaderPage;
import com.vtiger.pages.LoginPage;

public class NewContactSave extends BaseTest
{
	@Test
	public void TC_04_CreateNewContact()
	{
		String TCName = "TC_04_CreateNewContact";
		logger = extent.createTest(TCName);
		LoginPage lp = new LoginPage(driver,logger);
		lp.login(TestData.get(TCName).get("Userid"), TestData.get(TCName).get("Password"));
		ContactPage cp = new ContactPage(driver,logger);
		cp.ClickNewContact();
		cp.EnterSalutation(TestData.get(TCName).get("SalutationType"));
		cp.EnterFirstName(TestData.get(TCName).get("FirstName"));
		cp.EnterLastName(TestData.get(TCName).get("LastName"));
		cp.EnterFax(TestData.get(TCName).get("Fax"));
		cp.ClickOnSave();
		cp.VerifyNewContact(TestData.get(TCName).get("ContactVerify"));
		cp.ClickLogout();
		extent.flush();
	}
	
	@Test
	public void TC_05_CreateNewContactwithmandatoryFields()
	{
		String TCName = "TC_05_CreateNewContactwithmandatoryFields";
		logger = extent.createTest(TCName);
		LoginPage lp = new LoginPage(driver,logger);
		lp.login(TestData.get(TCName).get("Userid"), TestData.get(TCName).get("Password"));
		ContactPage cp = new ContactPage(driver,logger);
		cp.ClickNewContact();
		cp.CreateNewContact(TestData.get(TCName).get("SalutationType"), TestData.get(TCName).get("FirstName"), TestData.get(TCName).get("LastName"), TestData.get(TCName).get("ContactVerify"));
		cp.ClickLogout();
		extent.flush();
		
	}

}
