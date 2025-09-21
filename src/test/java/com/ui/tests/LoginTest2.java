package com.ui.tests;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.utility.BrowserUtility;

public class LoginTest2 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		
		HomePage homepage=new HomePage(driver);
		LoginPage loginPage=homepage.goToLoginPage();
		loginPage.doLoginWith("mettokauzaugre-5693@yopmail.com", "Password");
		
		//File file=new File(System.getProperty("user.dir")+"\\config\\")
	}

}
