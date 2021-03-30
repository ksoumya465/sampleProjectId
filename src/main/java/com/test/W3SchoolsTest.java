package com.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class W3SchoolsTest {
	
  private WebDriver driver;
  static final Logger logger = Logger.getLogger(W3SchoolsTest.class);
  
	
  @Test
  public void verifyTitle() {
	// Verify Headers in W3Schools page
	 String w3schoolsTitle="W3Schools Online Web Tutorials";
	  System.out.println("Starting test method in "+W3SchoolsTest.class);	
	  driver.get("https://www.w3schools.com/");
	  //BasicConfigurator.configure();
	  logger.info("driver.getTitle() --- "+driver.getTitle());
	  Assert.assertEquals(w3schoolsTitle,driver.getTitle(),"It is not W3schools home page");
	  System.out.println("End test method in - "+W3SchoolsTest.class);
	  logger.debug("End test method in -- "+W3SchoolsTest.class);
	  logger.info("End test method in --- "+W3SchoolsTest.class);
  }
  
  @Test
  public void verifyLeftNavigationHeaders() {
	  List<String> leftNavList = new ArrayList<String>( 
			  Arrays.asList("HTML and CSS","JavaScript","Server Side","Programming","Artificial Intelligence","Web Building","XML Tutorials","References","Exercises")); 
	  logger.info("Entered verifyLeftNavigationHeaders()");
	  System.out.println("Entered verifyLeftNavigationHeaders()");
	  WebElement leftNavigationHeader ;
	  for (int i=1; i<10; i++) {
		  System.out.println(i );
		   leftNavigationHeader =driver.findElement(By.xpath("/html/body/nav[1]/div/div["+i+"]/h4"));
		   System.out.println(i+" header name : "+leftNavigationHeader.getText()+" , assert : "+(leftNavList.contains(leftNavigationHeader.getText())));
		   Assert.assertTrue(leftNavList.contains(leftNavigationHeader.getText()));
	  }
	//capture the screenshot  
	  //File scrFile = ((TakeScreenshot)driver).getScreenshotAs(OutputType.FILE);  
	  // paste the screenshot in the desired location  
	  //FileUtils.copyFile(scrFile, new File("C:\\Screenshot\\Scr.jpg")) ;
	  
	  System.out.println("Exit verifyLeftNavigationHeaders()");
	  logger.info("Exit verifyLeftNavigationHeaders()");
  }

  
  
  @BeforeClass
  public void beforeClass() {
	  driver = new ChromeDriver();
	  System.out.println("Open Chrome Browser");
	  logger.info("Open Chrome Browser "+W3SchoolsTest.class);
	  driver.get("https://www.w3schools.com/");
	  //BasicConfigurator.configure();
	  logger.info("driver.getTitle() --- "+driver.getTitle());
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
	  System.out.println("Quit Browser");
	  logger.info("Quit Chrome Browser "+W3SchoolsTest.class);
  }

}
