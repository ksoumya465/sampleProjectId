package com.page;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
//import leaf.qa.keywords.Screenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.test.GooglePageTest;

/*
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

//	public Screenshot screenshot;
	
	public WebDriverWait wait;
	static final Logger logger = Logger.getLogger(Page.class);
	
	protected WebDriver webDriver;

	protected Page(WebDriver webDriver) {
		this.webDriver = webDriver;
//		this.screenshot = new Screenshot(webDriver);
		this.wait = new WebDriverWait(webDriver, 60);
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public String getTitle() {
		return webDriver.getTitle();
	}
	
	public void waitForPageLoad(WebDriver webDriver) {
		webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		this.wait = new WebDriverWait(webDriver, 16000);
	}
	
	public void waitForPageLoad(WebDriver webDriver,long milliSec) {
		System.out.println("waiting for page "+milliSec+" ms");
		this.wait = new WebDriverWait(webDriver, milliSec);
		webDriver.manage().timeouts().implicitlyWait(milliSec, TimeUnit.MILLISECONDS);
		
	}
	
	public void waitForElement(WebDriver webDriver,WebElement element) {
		this.wait = new WebDriverWait(webDriver, 10);
		System.out.println("Waiting for element");
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	@BeforeClass
	public void beforeClass() {
		 logger.info(" Entered in to Page class");
		
	}
	
	@AfterClass
	public void afterClass() {
		webDriver.quit();
		  logger.info("Quit Browser from page class");
	}
	


}
