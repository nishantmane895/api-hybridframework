package com.vtiger.common;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

public class CommonFunctions {
	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest logger;
	public CommonFunctions(WebDriver driver,ExtentTest logger)
	{
		this.driver=driver;
		this.logger=logger;
		wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	}
	
	//To Enter value in a textbox
	public void EnterValue(WebElement elm,String value,String details)
	{
		try {
			wait.until(ExpectedConditions.visibilityOf(elm));
			elm.clear();			
			elm.sendKeys(value);
			logger.pass(details);
		} catch (Exception e) {		
			e.printStackTrace();
			logger.fail(e.getMessage()+"<span class='label end-time'><a href='"+getscreenshot()+"'>Screenshot</a></span>");
		}
	}
	
	public void SelectVisibleText(WebElement elm,String value,String details)
	{
		try {
			wait.until(ExpectedConditions.visibilityOf(elm));
			Select s = new Select(elm);
			s.selectByVisibleText(value);
			logger.pass(details);
		} catch (Exception e) {		
			e.printStackTrace();
			logger.fail(e.getMessage()+"<span class='label end-time'><a href='"+getscreenshot()+"'>Screenshot</a></span>");
		}
	}
	
	
	
	
	
	public void ClickElement(WebElement elm,String details)
	{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(elm));
			elm.click();
			logger.pass(details);
		} catch (Exception e) {		
			e.printStackTrace();
			logger.fail(e.getMessage()+"<span class='label end-time'><a href='"+getscreenshot()+"'>Screenshot</a></span>");
		}
	}
	
	public void IsElementDisplay(WebElement elm,String details)
	{
		try {
			wait.until(ExpectedConditions.visibilityOf(elm));
			elm.isDisplayed();
			logger.pass(details);
		} catch (Exception e) {		
			e.printStackTrace();
			logger.fail(e.getMessage()+"<span class='label end-time'><a href='"+getscreenshot()+"'>Screenshot</a></span>");
		}
	}
	
	public String getscreenshot() 
	{
		DateFormat f = new SimpleDateFormat("yyyyMMddhhmmss");
		Date d = new Date();
		String str = f.format(d);
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/src/test/java/com/vtiger/reports/screenshots/image"+str+".png";
		//Move image file to new destination
		File DestFile=new File(path);
		//Copy file at destination
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
		
	}

	

}
