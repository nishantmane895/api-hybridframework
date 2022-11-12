package com.vtiger.tests;

import org.testng.annotations.Test;

import com.vtiger.pages.AccountPage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;

public class E2E extends BaseTest {
	
	
	@Test
	public void TC03_createLeadandAccount()
	{
		String TCName = "TC03_createLeadandAccount";
		logger = extent.createTest(TCName);
		LoginPage lp = new LoginPage(driver,logger);
		lp.login(TestData.get(TCName).get("Userid"), TestData.get(TCName).get("Password"));
		LeadPage ldp = new LeadPage(driver,logger);
		ldp.ClickNewLead();
		ldp.createlead(TestData.get(TCName).get("FirstName"), TestData.get(TCName).get("LastName"), TestData.get(TCName).get("Company"), TestData.get(TCName).get("Fax"));
		AccountPage acp = new AccountPage(driver,logger);
		acp.ClickNewAccount();
		acp.createaccount(TestData.get(TCName).get("AccountName"));
		acp.ClickLogout();
		extent.flush();
	}

}
