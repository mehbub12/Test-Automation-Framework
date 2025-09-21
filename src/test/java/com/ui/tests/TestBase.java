package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.testng.annotations.BeforeMethod;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;

public class TestBase {
	protected HomePage homepage;

	@BeforeMethod(description = "Load the browser")
	public void setup() {
		homepage = new HomePage(Browser.CHROME,true);
	}
	
	public BrowserUtility getInstance() {
		return homepage;
	}
}
