package com.ui.pages;

import org.openqa.selenium.By;


import com.constants.Browser;

import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;

import static com.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility {
	private static final By SIGN_IN_LOCATOR=By.xpath("//a[contains(text(),'Sign in')]");
	
	public HomePage(Browser browserName,boolean isHeadless){
		super(browserName,true);
		//goToWebsite(readProperty(QA, "URL"));
		goToWebsite(JSONUtility.readJSON(QA));
		maximizeWindow();
	}
	
	public LoginPage goToLoginPage() {
		clickOn(SIGN_IN_LOCATOR);
		return new LoginPage(getDriver());
	}
}
