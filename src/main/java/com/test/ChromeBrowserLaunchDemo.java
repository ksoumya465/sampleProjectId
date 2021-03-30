package com.test;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;


public class ChromeBrowserLaunchDemo {

    public static void main(String[] args) {
        
        //Creating a driver object referencing WebDriver interface
         WebDriver driver;
        
        //Setting the webdriver.chrome.driver property to its executable's location
        //System.setProperty("webdriver.chrome.driver", "/lib/chromeDriver/chromedriver.exe");
	
        //Instantiating driver object
        driver = new ChromeDriver();
        
        //Using get() method to open a webpage
        driver.get("https://artoftesting.com");
       // WebDriverWait myWaitVar = new WebDriverWait(driver,5);
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Closing the browser
        driver.quit();
 
    }
    

 
}
