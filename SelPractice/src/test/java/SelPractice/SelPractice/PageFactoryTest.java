package SelPractice.SelPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class PageFactoryTest {
	WebDriver driver;
	Properties prop;
	FileInputStream file;
		
	@BeforeClass
	void setUp() throws InterruptedException, IOException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		prop = new Properties();
		file = new FileInputStream("C:\\Users\\suveerab\\eclipse-workspace\\SelPractice\\src\\test\\java\\SelPractice\\SelPractice\\PageFactory.properties");
		prop.load(file);
		driver.get(prop.getProperty("url"));
		Thread.sleep(3000);
	}
		
	@Test
	public void mainTest() throws InterruptedException
	{
		PageFactoryLocator pf = new PageFactoryLocator(driver);
		pf.username(prop.getProperty("username"));
		pf.password(prop.getProperty("password"));
		pf.login();
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
	}

	@AfterClass
	void tearDown()
	{
		driver.quit();
	}

}
