package com.learnautomation.testcases;
import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class LoginTestCRM extends BaseClass
{

	@Test
	public void launchApp() throws InterruptedException
	{
		
		Reporter.log("Starting the test", true);
		logger=report.createTest("Login to CRM");
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		logger.info("Logging to the application");
		loginpage.logintoCRM(excel.getStringData("Login", 0, 0), excel.getStringData(0, 0, 1));
		logger.pass("Login is successful");
		Reporter.log("Test Completed", true);
		
	}
	@Test 
	public void launchApp2() throws InterruptedException, IOException
	{
		Reporter.log("Starting the test 2", true);
		logger=report.createTest("Login to CRM 2");
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		logger.info("Logging to the application");
		loginpage.logintoCRM(excel.getStringData("Login", 0, 0), excel.getStringData(0, 0, 1));
		logger.fail("Login failed");
		Reporter.log("Test 2 Completed", true);
		
	}
}
