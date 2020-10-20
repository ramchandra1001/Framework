package com.learnautomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper 
{
	
	//Libraries for Screenshots, alert, Frames, windows, current time stamp.
	
	
	public static String takeScreenShots(WebDriver driver)
	{
		
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath=System.getProperty("user.dir")+"/Screenshots/CRM_"+Helper.getDateTimeInstance()+".png";
		
		try 
		{
			FileUtils.copyFile(src, new File (screenshotPath));
		} 
		catch (IOException e) {
			System.out.println("Unable to take screen shot"+e.getMessage());
		}
		
		return screenshotPath;
	}

	public static String getDateTimeInstance()
	{
		
		DateFormat customFormat= new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date currDate= new Date();
		return customFormat.format(currDate);
	}
	
}
