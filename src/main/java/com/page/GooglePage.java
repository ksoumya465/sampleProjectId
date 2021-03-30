package com.page;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.properties.GeneralConfig;

public class GooglePage extends Page{
	static final Logger logger = Logger.getLogger(GooglePage.class);
	String fileName ="src/main/resources/generalConfig.properties";
	GeneralConfig config = new GeneralConfig(fileName);	
	public GooglePage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
		webDriver.get("http://www.google.com");
		logger.info("Google page constructor");
	}

	
	@FindBy(linkText = "Gmail")
	WebElement gmail_link;
	
	@FindBy(linkText = "Sign in")
	WebElement signIn_link;
	
	@FindBy(xpath = "//input[@type='text']")
	WebElement SearchBox;	
	
	@FindBy(xpath = "//div[@id='result-stats']")
	WebElement results;
	
	
	/** To click Gmail link in Google page.
	 *  
	 * @return Gmail Login Page
	 * @author spandal
	 */
	public GmailLoginPage clickGmail() {
		logger.info("Link name :"+gmail_link.getText()+"...");
		logger.info("Selenium commands : FindBy via linkText - for identifying element via link name");
		gmail_link.click();
		waitForPageLoad(webDriver,5000);
		if(signIn_link.isDisplayed()) {
			signIn_link.click();
			waitForPageLoad(webDriver,10000);
		}
		return new GmailLoginPage(webDriver);
	}
	
	public void searchInGoogle(String searchTerm) {
		logger.info("searchTerm : "+searchTerm);
		logger.info("Selenium commands : sendKeys - for Entering values into textbox");
		logger.info("Selenium commands : FindBy via xpath - for identifying element via xpath");
		SearchBox.sendKeys(searchTerm);
		SearchBox.sendKeys(Keys.ENTER);
	}
	
	/*public static void main(String[] args) {
		logger.info("GooglePage main");
		GooglePage googlePage=new GooglePage();
		openGooglePage();
		clickGmail();
	}*/
	
	public boolean isSearchReturnsResults() {
		return results.isDisplayed();
	}
	
	public boolean isSearchTermLinkDisplayed(String searchTerm) {
		boolean isLinkDisplayed=false;
		waitForPageLoad(this.webDriver,10000);
		logger.info("Selenium commands : To retrieve List of web elements");
		//List<WebElement> searchTermLinks=this.webDriver.findElements(By.xpath("//a[contains(text(),'"+searchTerm+".com')]")); // This also works
		List<WebElement> links=webDriver.findElements(By.linkText(searchTerm+".com"));
		for(WebElement searchTermLink : links) {
			logger.info("link : "+searchTermLink.getText());
			isLinkDisplayed =true;
			break;
		}
		
		logger.info("forEach Lambda expression");
		links.forEach(searchTermLink ->
		logger.info("link : "+searchTermLink.getText())
				);
		
		logger.info("forEach Lambda expression in shortest way");
		links.forEach(System.out::println);
		
		return isLinkDisplayed;
	}
	
	/** This method refreshes Google page and validates page title if same before and after refresh or not
	 * 
	 * @return boolean
	 * @author spandal
	 */
	public boolean validateRefresh() {
		boolean isRefreshFunValidated=false;
		String pageTitle=webDriver.getTitle();
		logger.info(" Current page title name : "+pageTitle);
		webDriver.navigate().refresh();
		logger.info(" After refreshing page title name : "+webDriver.getTitle());
		if(pageTitle.equals(webDriver.getTitle())) {
			isRefreshFunValidated=true;
		}
		logger.info(" isRefreshFunValidated : "+isRefreshFunValidated);
		return isRefreshFunValidated;
	}
	
	/** This method validates Forward and Backward functionality of browsers from Google to Gmail page
	 * 
	 * @return boolean
	 * @author spandal
	 */
	public boolean validateBrowserForwardBackFunctions() {
		boolean isBrowserFunValidated=false;
		String googlePageTitle=webDriver.getTitle();
		//GmailLoginPage gmailPage=clickGmail();
		webDriver.navigate().to(config.getValue("gmail.url"));
		waitForPageLoad(webDriver);
		String gmailPageTitle=webDriver.getTitle();
		waitForPageLoad(webDriver);
		webDriver.navigate().back();
		waitForPageLoad(webDriver);
		logger.info("googlePageTitle : "+googlePageTitle);
		logger.info("gmailPageTitle : "+gmailPageTitle);
		logger.info("Title after navigating to back - "+webDriver.getTitle());
		if(webDriver.getTitle().equals(googlePageTitle)) {
			logger.info("Browser Back functionality is working");
			waitForPageLoad(webDriver,60000);
			webDriver.navigate().forward();
			//waitForPageLoad(webDriver,90000);
			if(webDriver.getTitle().equals(gmailPageTitle)) {
				logger.info("Title after navigating to forward - "+webDriver.getTitle());
				logger.info("Browser Forward functionality is working");
				isBrowserFunValidated=true;
			}else {
				logger.info("Browser Forward functionality is NOT working");
				logger.error("Browser Fack functionality is NOT working");
			}
		}else {
			logger.info("Browser Back functionality is NOT working");
			logger.error("Browser Back functionality is NOT working");
		}
		
		return isBrowserFunValidated;
		
	}
	
	
	
	
	
}
