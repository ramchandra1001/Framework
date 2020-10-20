package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass 
{
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider cdp;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setUpExcel()
	{
		excel= new ExcelDataProvider();
		cdp=new ConfigDataProvider();
		ExtentHtmlReporter reporter= new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/CRM_"+Helper.getDateTimeInstance()+".html"));
		System.out.println("Dir Path: "+System.getProperty("os.dir"));
		report= new ExtentReports();
		report.attachReporter(reporter);

	}


	@BeforeClass
	public void setUp()
	{
		driver=BrowserFactory.startApplication(driver, cdp.getBrowser(), cdp.getURL());
		System.out.println("Title: "+driver.getTitle());
	}


	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}

	@AfterMethod
	public void teadDownAfterMethod(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("Login failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.takeScreenShots(driver)).build());

			//Helper.takeScreenShots(driver);
		}

		if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Login successful", MediaEntityBuilder.createScreenCaptureFromPath(Helper.takeScreenShots(driver)).build());

			//Helper.takeScreenShots(driver);
			
		}

		report.flush();

	}


}
