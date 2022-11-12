package com.vtiger.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends BaseTest {
	
	
	
	
	@Test
	public void TC01_InvalidLogin()
	{
		String TCName = "TC01_InvalidLogin";
		logger = extent.createTest(TCName);
		LoginPage lp = new LoginPage(driver,logger);
		lp.login(TestData.get(TCName).get("Userid"), TestData.get(TCName).get("Password"));
		lp.verifyErrorMsg();
		extent.flush();
	}
	
	@Test
	public void TC02_validLogin()
	{	
		String TCName = "TC02_validLogin";
		logger = extent.createTest(TCName);
		LoginPage lp = new LoginPage(driver,logger);
		lp.login(TestData.get(TCName).get("Userid"), TestData.get(TCName).get("Password"));
		HomePage hp = new HomePage(driver,logger);		
		hp.ClickLogout();
		extent.flush();
		
	}

}
