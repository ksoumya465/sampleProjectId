package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.page.Guru99DemoPage;

public class XpathTest{
	private WebDriver webDriver;
	

	
	@Test
	public void testRegister() {
		System.out.println("Entered testRegister() "+XpathTest.class);
		Guru99DemoPage demoPage=new Guru99DemoPage(webDriver);
		String title=webDriver.getTitle();
		System.out.println("title "+title);	
		Assert.assertEquals("Insurance Broker System - Login", title, "Guru99 Demo page title is not matching");
		demoPage.clickRegister();
		System.out.println("Exit testRegister() "+XpathTest.class);
	}
	
	  @BeforeClass
	  public void setup() {
		  System.out.println("opening browser "+XpathTest.class);
		  webDriver = new ChromeDriver();
	  }
	  @AfterClass
	  public void afterClass() {
		  webDriver.close();
		  System.out.println("Closing browser "+XpathTest.class);
		  }

}
