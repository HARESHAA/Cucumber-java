package SelPractice.SelPractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicAnnotation {
	@BeforeClass
	void setUp() {
		System.out.println("Before class");
	}
	
	@BeforeMethod
	void befTest()
	{
		System.out.println("This is before Method");
	}
	
	@Test(priority = 3, dependsOnMethods = {"Test_3"})
	public void Test_1()
	{
		System.out.println("This is Test1");
	}
	
	@Test(priority = 1)
	public void Test_2() {
		System.out.println("This is Test2");
	}
	
	@Test(priority = 2)
	public void Test_3() {
		System.out.println("This is Test3");
	}
	
	@AfterMethod
	void close_1() {
		System.out.println("this is AfterMethod");
	}
	
	@AfterClass
	void close_2()
	{
		System.out.println("this is Afterclass");
	}

}
