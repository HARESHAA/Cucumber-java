package PageFactory

;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		this.ldriver = rdriver;
		PageFactory.initElements(this.ldriver,this);;
	}
	
	@FindBy(xpath = "//input[@id='Email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement pwd;
	
	@FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button")
	WebElement loginbtn;
	
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
}
