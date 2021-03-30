package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailLoginPage extends Page {
	// https://www.edureka.co/community/2137/automate-gmail-login-process-using-selenium-webdriver-java
	//WebElements
	@FindBy(linkText="Sign in")
	private WebElement signIn;
	
	@FindBy(xpath ="//input[@id='identifierId']")
	private WebElement email;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(partialLinkText = "Next")
	private WebElement nextBtn;

	public GmailLoginPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
		webDriver.get("http://www.gmail.com");
		System.out.println("GmailLoginPage page constructor");
	}

	//Methods
	/** Gmail login method.
	 *  Automating this function is blocked by Gmail
	 * @param emailId
	 * @param pwd
	 * @author spandal
	 */
	public void login(String emailId, String pwd){
		waitForPageLoad(webDriver);
		if(webDriver.findElement(By.xpath("//*[@id='identifierId']")).isDisplayed()) {
			System.out.println("Entered into loop");
			webDriver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys(emailId);	
			waitForPageLoad(webDriver,70000);
		}
		if(webDriver.findElement(By.xpath("//div[@id='identifierNext']")).isDisplayed()) {
			
			webDriver.findElement(By.xpath("//div[@id='identifierNext']")).click();
			System.out.println("Entered again into loop");
			waitForPageLoad(webDriver,90000);
			System.out.println("...");
		}
 
		//send password
		 wait = new WebDriverWait(webDriver, 60000);
		 try {
			wait(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 WebElement passwordButton = webDriver.findElement(By.xpath("//input[@name='password']"));
		 if(passwordButton.isDisplayed()) {
			 System.out.println("pwd displayed");
			 waitForPageLoad(webDriver,50000);
			 wait.until(ExpectedConditions.elementToBeClickable(passwordButton));
			 passwordButton.sendKeys(pwd);		 
			 webDriver.findElement(By.xpath("//div[@id='passwordNext']")).click();
		 }
 
 /*
		webDriver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys(emailId);
		System.out.println("emailId : "+emailId);
		waitForPageLoad(webDriver,15000);
		webDriver.findElement(By.xpath("//div[@id='identifierNext']")).click();
		waitForPageLoad(webDriver,15000);
		webDriver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
		System.out.println("pwd : "+pwd);
		waitForPageLoad(webDriver,15000);
		webDriver.findElement(By.xpath("//div[@id='passwordNext']")).click();*/
		/*
		waitForPageLoad(webDriver,10000);
		email.sendKeys(emailId);
		System.out.println("emailId : "+emailId);
		waitForPageLoad(webDriver,10000);
		nextBtn.click();
		
		password.sendKeys(pwd);
		System.out.println("pwd : "+pwd);
		waitForPageLoad(webDriver,5000);
		nextBtn.click();
		*/
		//return new GmailPage(webDriver);
	}

}
