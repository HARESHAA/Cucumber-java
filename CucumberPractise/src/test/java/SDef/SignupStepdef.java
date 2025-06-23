package SDef;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import PageObject.SignupPO;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class SignupStepdef {

	WebDriver driver;
	SignupPO sp;
	
	@Given("User has Chrome Browser")
	public void user_has_chrome_browser() {
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	    driver.get("https://admin-demo.nopcommerce.com/login");
	    driver.manage().window().maximize();
	    sp = new SignupPO(driver);
	    System .out.print("after browser open");
	}

	@When("User mentions the mailid as {string} and password as {string}")
	public void user_mentions_the_mailid_as_xyz_gmail_com_and_password_as_sudhir(String id, String pd) throws InterruptedException {
		System .out.print("before mail");
	    sp.email_Text(id);
	    Thread.sleep(3000);
	    System .out.print("before pass");
	    sp.pwd_Text(pd);
	    Thread.sleep(3000);
	}

	@When("User hits the Login")
	public void user_hits_the_login() {
		System .out.println("before login");
	    sp.login_Button();
	    System .out.println("after login");
	}

	/* valid /Invalid - loggedin/notLoggedin - pass/Fail*/
	
	@Then("User verifies the {string}")
	public void user_verifies_the_invalid(String sts) throws InterruptedException {
		Thread.sleep(3000);
		System .out.println("before validation");
	   String title = driver.getTitle();
	   System .out.println(title);
	   if(sts.equalsIgnoreCase("valid"))
	   {
		   if(title.equals("Just a moment..."))
		   {
			   //sp.logout_Button();
			   Assert.assertTrue(true);
			}else
		   {
			   Assert.assertTrue(false);
		   }
	   }
	   if(sts.equalsIgnoreCase("Invalid"))
	   {
		   if(title.equals("Dashboard / nopCommerce administration"))
		   {
			   sp.logout_Button();
			   Assert.assertTrue(false);
		   }else
		   {
			   Assert.assertTrue(true);
		   }
	   }
	   System .out.println("after validation");
	   driver.close();
	}

	
	
	
}
