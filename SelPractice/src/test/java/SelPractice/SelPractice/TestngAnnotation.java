package SelPractice.SelPractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TestngAnnotation {
	WebDriver driver;
	Properties prop;
	
	@BeforeClass
	void setUp() throws IOException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		prop = new Properties();
		FileInputStream file = new FileInputStream("/Users/hareshaa/eclipse-workspace/Automationpraxtise/src/test/java/Automationpractise/Automationpraxtise/details.properties");
		prop.load(file);
	}
	
	@Test
	public void TestLogin() throws InterruptedException
	{
		driver.get(prop.getProperty("url"));
		driver.findElement(By.xpath("//input[@id = 'name']")).sendKeys(prop.getProperty("name"));
		driver.findElement(By.xpath("//input[@placeholder = 'name@example.com']")).sendKeys(prop.getProperty("mail"));
		driver.findElement(By.xpath("//input[@id = 'gender']")).click();
		driver.findElement(By.xpath("//input[@placeholder = 'Enter Mobile Number']")).sendKeys(prop.getProperty("number"));
		driver.findElement(By.id("dob")).sendKeys(prop.getProperty("dob"));
		driver.findElement(By.id("subjects")).sendKeys(prop.getProperty("subject"));
		driver.findElement(By.xpath("(//input[@type = 'checkbox'])[2]")).click();
		driver.findElement(By.xpath("(//input[@type = 'checkbox'])[3]")).click();
		driver.findElement(By.xpath("//textarea[@placeholder = 'Currend Address']")).sendKeys(prop.getProperty("address"));
		Select select1 = new Select(driver.findElement(By.id("state")));
		select1.selectByVisibleText("Uttar Pradesh");
		Select select2 = new Select(driver.findElement(By.id("city")));
		select2.selectByIndex(2);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(prop.getProperty("location"));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		Thread.sleep(3000);
	}
	
	@AfterClass
	void TearUp()
	{
		driver.close();
	}

}
