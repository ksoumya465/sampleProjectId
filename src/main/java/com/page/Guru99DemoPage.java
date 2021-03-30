package com.page;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Guru99DemoPage extends Page {
	
	public Guru99DemoPage(WebDriver webDriver) {
		super(webDriver);
		waitForPageLoad(webDriver);
		PageFactory.initElements(webDriver, this);
		webDriver.get("http://demo.guru99.com/insurance/v1/index.php");
		System.out.println("Opened Guru99 Demo site "+Guru99DemoPage.class);
		
	}
	
	//@FindBy(linkText="Register")
	//@FindBy(xpath = "//a[contains(text(),'Register')]")
	@FindBy(xpath = "//a[contains(.,'Register')]" , linkText="Register")
	WebElement registerBtn;
	
	@FindBy(id="user_title")
	WebElement title;
	
	@FindBy(id="user_firstname")
	WebElement firstName;
	
	@FindBy(name="lastname")
	WebElement lastName;
	
	@FindBy(id="user_phone")
	WebElement mobileNum;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(id="user_dateofbirth_1i")
	WebElement dob_year;
	
	@FindBy(id="user_dateofbirth_2i")
	WebElement dob_month;
	
	@FindBy(id="user_dateofbirth_3i")
	WebElement dob_date;
	
	@FindBy(name="licencetype")
	List<WebElement> licenceTypeList;
	
	@FindBy(id="resetform")
	WebElement reset_Btn;
	
	public void login() {
		System.out.println("Entered Login method "+Guru99DemoPage.class);
		
		System.out.println("Exit Login method "+Guru99DemoPage.class);
	}
	

	public void clickRegister() {
		
		
		System.out.println("Entered Register method "+Guru99DemoPage.class);

		System.out.println("Already waited for page with title :"+webDriver.getTitle());
		//System.out.println("isDisplayed : "+registerBtn);
		//System.out.println("isDisplayed : "+webDriver.findElement(By.xpath("//a[contains(.,'Register')]")).isDisplayed());
		registerBtn.click();
		System.out.println("Exit Register method "+Guru99DemoPage.class);
		resetRegistrationDetails() ;
	}
	
	public void resetRegistrationDetails() {
		System.out.println("Enter registration details");
		Select titleDropDown = new Select(title);
		titleDropDown.getOptions().get(3).click();;
		System.out.println("title "+titleDropDown.getOptions().get(3));
		firstName.sendKeys("firstName");
		lastName.sendKeys("lastName");
		mobileNum.sendKeys("1234567890");
		email.sendKeys("abc@gmail.com");
		
		Select year_dropDown= new Select(dob_year);
		year_dropDown.selectByValue("1990");
		
		Select month_dropDown = new Select (dob_month);
		month_dropDown.selectByVisibleText("April");
		
		Select date_dropDown=new Select(dob_date);
		date_dropDown.selectByIndex(3);
		
		for(WebElement licenceTypeRadio : licenceTypeList) {
			if(!licenceTypeRadio.isSelected()) {
				licenceTypeRadio.click();
				break;
			}
		}
		
		System.out.println("firstName :"+firstName.getText()+" , lastName :"+lastName.getText()+" , mobileNum :"+mobileNum.getText()+" , email :"+email.getText()); 
		try {
			Thread.sleep(10000);
		
		reset_Btn.click();
		Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	

	
}
