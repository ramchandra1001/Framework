package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider 
{
	Properties pro;
	
	public ConfigDataProvider()
	{
		File configfile= new File("./Config/Config.properties");
		
		try 
		{
			FileInputStream fis= new FileInputStream(configfile);
			
			pro= new Properties();
			pro.load(fis);
		} 
		catch (Exception e) 
		{
			System.out.println("Unable to read config file >> "+e.getMessage());
			
		}
			
	}
	
	public String getBrowser()
	{
		return pro.getProperty("browserName");
	}

	public String getURL()
	{
		return pro.getProperty("appUrl");
	}
	
	public String getValuesByKey(String searchKey)
	{
		return pro.getProperty(searchKey);
	}
}
