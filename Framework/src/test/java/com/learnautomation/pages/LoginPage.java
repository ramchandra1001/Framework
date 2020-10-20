package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {


	WebDriver driver;

	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;

	}

	@FindBy (name="email") WebElement user_name;
	@FindBy (name="password") WebElement pwd;
	@FindBy (xpath ="//div[1]/div/div/form/div/div[3]") WebElement loginBtn;
	@FindBy(className = "user-display") WebElement loggedUser;

	public void logintoCRM(String user, String pass)
	{
		user_name.sendKeys(user);
		pwd.sendKeys(pass);
		loginBtn.click();

	}
	
	public String checkLogin()
	{
		String userStr=loggedUser.getText();
		System.out.println("Logged User: "+userStr);
		return userStr;
	}


}
