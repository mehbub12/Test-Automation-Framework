package com.ui.tests;

import static com.constants.Browser.*;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojos.User;
import com.utility.LoggerUtility;


@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest3 extends TestBase {
	
	
	@Test(description="Verify the valid login scenario",groups= {"E2E","Sanity"}, dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginData")
	public void loginTest(User user) {
		
		assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Roman Reigns");
	}
	
	//@Test(description="Verify the valid login scenario",groups= {"E2E","Sanity"}, dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginCSVData",retryAnalyzer=com.ui.listeners.MyRetryAnalyzer.class)
	//public void loginCSVTest(User user) {
		
	//	assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Roman Reigns");
	//}
	@Test(description="Verify the valid login scenario",groups= {"E2E","Sanity"}, dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginExcelData",retryAnalyzer=com.ui.listeners.MyRetryAnalyzer.class)
	public void loginExcelTest(User user) {
		assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Roman Reigns");
		}

}
