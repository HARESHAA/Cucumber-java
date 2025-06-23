package StepDefination;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageFactory.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class LoginPageStep {

	WebDriver driver;
	LoginPage lp;
	Properties prop;
	
 @Before
 public void setUp() throws IOException
 {
	 prop = new Properties();
	 FileInputStream file = new FileInputStream("C:\\Users\\suveerab\\eclipse-workspace\\SelPractice\\src\\test\\java\\properties\\LoginData.properties");
	 prop.load(file);
 }
 
	@Given("User opened chrome browser")
	public void user_opened_chrome_browser() {
	    driver = new ChromeDriver();
		lp = new LoginPage(driver);
		
	}

	@When("user opens url")
	public void user_opens_url() throws InterruptedException {
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@And("user enters user id and password")
	public void user_enters_user_id_as_and_password_as() throws InterruptedException{
		Thread.sleep(3000);
		lp.email_Text(prop.getProperty("emailid"));
		System.out.println("email");
	    lp.pwd_Text(prop.getProperty("pwd"));

		System.out.println("pass");
	    
	} 
	
	@Then("user clicks on logout")
	public void user_clicks_on_logout() {

		System.out.println("login");
		lp.login_Button();
		driver.close();
	}

}
