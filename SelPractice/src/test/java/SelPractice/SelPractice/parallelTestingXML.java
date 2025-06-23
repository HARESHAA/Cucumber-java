package SelPractice.SelPractice;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class parallelTestingXML {
	WebDriver driver;
	@BeforeMethod
	@BeforeClass
	void setUp()
	{
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	}
	
	@Test
	@Parameters({"name", "mail", "number"})
	public void form_Test(String name, String mail, String number) throws InterruptedException
	{
		driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm\n");
		driver.findElement(By.xpath("//input[@id = 'name']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@placeholder = 'name@example.com']")).sendKeys(mail);
		driver.findElement(By.xpath("//input[@id = 'gender']")).click();
		driver.findElement(By.xpath("//input[@placeholder = 'Enter Mobile Number']")).sendKeys(number);
		driver.findElement(By.id("dob")).sendKeys("02/05/2025");
		driver.findElement(By.id("subjects")).sendKeys("Maths");
		driver.findElement(By.xpath("(//input[@type = 'checkbox'])[2]")).click();
		driver.findElement(By.xpath("(//input[@type = 'checkbox'])[3]")).click();
		driver.findElement(By.xpath("//textarea[@placeholder = 'Currend Address']")).sendKeys("xyz UP");
		Select select1 = new Select(driver.findElement(By.id("state")));
		select1.selectByVisibleText("Uttar Pradesh");
		Select select2 = new Select(driver.findElement(By.id("city")));
		select2.selectByIndex(2);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\suveerab\\Downloads\\images.png");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		Thread.sleep(3000);
	}
	
	@AfterMethod
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}

}
