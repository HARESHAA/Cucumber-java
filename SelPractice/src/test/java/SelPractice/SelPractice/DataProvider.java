package SelPractice.SelPractice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DataProvider {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\suveerab\\eclipse-workspace\\SelPractice\\src\\test\\java\\SelPractice\\SelPractice\\data.properties");
		prop.load(file);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
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
		driver.close();

	}

}
