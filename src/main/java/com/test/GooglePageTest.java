package com.test;

import org.testng.annotations.Test;

import com.page.GmailLoginPage;
import com.page.GooglePage;
import com.properties.Constant;
import com.properties.GeneralConfig;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class GooglePageTest {
	
  private WebDriver driver;
  static final Logger logger = Logger.getLogger(GooglePageTest.class);
  String fileName ="src/main/resources/generalConfig.properties";
	GeneralConfig config = new GeneralConfig(fileName);
	
  @Test
  public void verifyGmailLinkInGoogle() {
	// Set up a simple configuration that logs on the console.
	  GooglePage googlePage=new GooglePage(driver);
	  BasicConfigurator.configure();
	  logger.info("Starting verifyGmailLinkInGoogle() ");	
	  //logger.info("Starting test method in "+GooglePageTest.class);
	  //logger.debug("Starting test method in "+GooglePageTest.class);
	  
	  String search_text = "Gmail";
	  WebElement gmail_link =driver.findElement(By.linkText("Gmail"));
	  logger.info("Link name :"+gmail_link.getText()+"...");
	  Assert.assertEquals(search_text, gmail_link.getText(), "Link not found!");
	  logger.info("End verifyGmailLinkInGoogle() - "+GooglePageTest.class);
	  //logger.debug("End test method in -- "+GooglePageTest.class);
	  //logger.info("End test method in --- "+GooglePageTest.class);
  }
  
  @Test
  public void verifyGmailLogin() { // Gmail Login is Blocked hence unable to automate it

		GooglePage googlePage=new GooglePage(driver);
		
		GmailLoginPage gmailLoginPage=googlePage.clickGmail();
		
	  //GmailLoginPage gmailLoginPage = new GmailLoginPage(driver);
		//String fileName ="src/main/resources/generalConfig.properties";
		//GeneralConfig config = new GeneralConfig(fileName);
		gmailLoginPage.login(config.getGmailEmailId(), config.getGmailPwd());
  }
  
  @Test
  public void VerifyGoogleSearch() {
	  GooglePage googlePage=new GooglePage(driver);
	 // googlePage.searchInGoogle(config.getValue("google.w3schoolsSearchTerm")); one way of retrieving
	  googlePage.searchInGoogle(Constant.w3schoolsSearchTerm);
	  Assert.assertTrue(googlePage.isSearchReturnsResults(), "No results found");
	  Assert.assertTrue(googlePage.isSearchTermLinkDisplayed(Constant.w3schoolsSearchTerm),"No Link with search term");
  }
  
  
  @Test
  public void verifyBrowserFunctionalities() {
	  GooglePage googlePage=new GooglePage(driver);
	  Assert.assertTrue(googlePage.validateRefresh(),"Page Title before and after refresh are not same when performed in Google page");
	  Assert.assertTrue(googlePage.validateBrowserForwardBackFunctions(),"Forward and Backward funtionalities are not working");
	  
  }
  
  @BeforeClass
  public void beforeClass() {
	  logger.info("....................In Google Page test.............................................................");
	  /*
	  System. setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  logger.info("Open Chrome Browser");
	  */
	  driver.get("http://www.google.com");
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
	  logger.info("Quit Browser");
  }
  
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception{
		if(browser.equalsIgnoreCase("firefox")){
			System. setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			logger.info("###################  Open Firefox Browser");			
		}else if(browser.equalsIgnoreCase("ie")){
			
		}else if(browser.equalsIgnoreCase("chrome")){
			System. setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			logger.info("$$$$$$$$$$$$$$$$$$$$    Open Chrome Browser");
		}else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
