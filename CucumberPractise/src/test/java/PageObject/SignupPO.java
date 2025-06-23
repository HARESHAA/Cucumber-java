package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPO {

	WebDriver ldriver;
	
	public SignupPO(WebDriver rdriver)
	{
		this.ldriver = rdriver;
		PageFactory.initElements(this.ldriver, this);
	}
	
	@FindBy(xpath = "//input[@id='Email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement pwd;
	
	@FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button")
	WebElement loginbtn;
	
	/*@FindBy(xpath = "//img[@alt = 'logo.png']")
	WebElement title;*/
	
	@FindBy(xpath = "//a[]@class = 'nav-link'")
	WebElement logoutbtn;
	
	public void email_Text(String mail)
	{
		email.clear();
		System.out.println(mail);
		email.sendKeys(mail);
	}
	
	public void pwd_Text(String wpwd)
	{
		pwd.clear();
		pwd.sendKeys(wpwd);
	}
	
	public void login_Button()
	{
		loginbtn.click();
	}
	
	public void logout_Button()
	{
		logoutbtn.click();
	}
	
	/*public String title_check()
	{
		String heading = title.getText();
		return heading;
	}*/
	
	
	
}
	