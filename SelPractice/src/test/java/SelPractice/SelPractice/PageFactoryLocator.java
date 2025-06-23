package SelPractice.SelPractice;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PageFactoryLocator {
WebDriver driver;
	
	
	PageFactoryLocator(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	// Locaters
	@FindBy(xpath = "//input[@placeholder = 'Username']")
	WebElement username_text;
	
	@FindBy(xpath = "//input[@placeholder = 'Password']")
	WebElement password_text;
	
	@FindBy(xpath = "//button[@type = 'submit']")
	WebElement submit_button;
	
	
	//Action methods
	public void username(String username1)
	{
		username_text.sendKeys(username1);
	}
	
	public void password(String password1)
	{
		password_text.sendKeys(password1);
	}
	
	public void login()
	{
		submit_button.click();
	}

}
