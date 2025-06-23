package Testng_DataProvider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.SignupPO;
import Utilities.ExcelData;

public class ExceldataProvider {
	
	WebDriver driver;
	SignupPO sp;

	/*@BeforeClass
	public void setUp() throws InterruptedException
	{
		driver = new ChromeDriver();
		
	    driver.manage().window().maximize();
	   
	    Thread.sleep(3000);
	}*/
	
	@BeforeMethod
	public void beforeTest() throws InterruptedException 
	{
		driver = new ChromeDriver();
		
	    driver.manage().window().maximize();
	   
	    Thread.sleep(3000);
		driver.get("https://admin-demo.nopcommerce.com/login");
		sp = new SignupPO(driver);
		Thread.sleep(3000);
	}
	
	@Test(dataProvider = "Field Data", dataProviderClass = ExcelData.class)
	public void Login(String Mail, String pwd, String result) throws InterruptedException
	{
		
		sp.email_Text(Mail);
		Thread.sleep(3000);
		sp.pwd_Text(pwd);
		Thread.sleep(3000);
		sp.login_Button();
		String title = driver.getTitle();
		if(result.equalsIgnoreCase("valid"))
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
		   if(result.equalsIgnoreCase("Invalid"))
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
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
