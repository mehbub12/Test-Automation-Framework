package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility {
	
	private static final By EMIAIL_ADDRESS_LOCATOR=By.id("email");
	private static final By PASSWORD_LOCATOR=By.id("passwd");
	private static final By SUBMIT_LOCATOR=By.id("SubmitLogin");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public MyAccount doLoginWith(String username,String password) {
		enterText(EMIAIL_ADDRESS_LOCATOR, username);
		enterText(PASSWORD_LOCATOR, password);
		clickOn(SUBMIT_LOCATOR);
		return new MyAccount(getDriver());
	}

}
