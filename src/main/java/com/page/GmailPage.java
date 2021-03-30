package com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GmailPage extends Page{

	public GmailPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
		
	}

}
