package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class HomePage extends HeaderPage {
	

	
	public HomePage(WebDriver driver,ExtentTest logger)
	{
		super(driver,logger);		
		PageFactory.initElements(driver, this);
	}
	
	//By username = By.name("user_name");
	
	@FindBy(name="pipeline")
	WebElement map_pipeline;
	
	public void verifyPipelineMap()
	{
		cf.IsElementDisplay(map_pipeline,"Pipeline graph is displayed successfully");
	}
	
	

}
