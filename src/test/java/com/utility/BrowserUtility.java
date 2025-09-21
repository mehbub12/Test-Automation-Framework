package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public abstract class BrowserUtility {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
		;
	}

	public BrowserUtility(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		} else if (browser.equalsIgnoreCase("Edge")) {
			driver.set(new EdgeDriver());
		} else {
			System.err.println("Invalid browser...Please select chrome or edge");
		}
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
	    if (browserName == Browser.CHROME) {
	        ChromeOptions options = new ChromeOptions();
	        if (isHeadless) {
	            options.addArguments("--headless=new");  // Or "--headless=old" for older Chrome
	            options.addArguments("--window-size=1920,1080");
	        }
	        driver.set(new ChromeDriver(options));

	    } else if (browserName == Browser.EDGE) {
	        EdgeOptions options = new EdgeOptions();
	        if (isHeadless) {
	            options.addArguments("--headless=new");
	            options.addArguments("--window-size=1920,1080");
	        }
	        driver.set(new EdgeDriver(options));

	    } else if (browserName == Browser.FIREFOX) {
	        FirefoxOptions options = new FirefoxOptions();
	        if (isHeadless) {
	            options.addArguments("--headless"); // Firefox only needs this
	        }
	        driver.set(new FirefoxDriver(options));
	    }
	}

	public void goToWebsite(String url) {
		driver.get().get(url);
	}

	public void maximizeWindow() {
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		WebElement element = driver.get().findElement(locator);
		element.click();
	}

	public void enterText(By locator, String text) {
		WebElement element = driver.get().findElement(locator);
		element.sendKeys(text);
	}

	public String getVisibleText(By locator) {
		WebElement element = driver.get().findElement(locator);
		return element.getText();
	}

	public WebDriver getDriver() {
		return driver.get();
	}

	public String takeScreenShot(String fileName) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();

		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String path = System.getProperty("user.dir") + "//screenshots//" + fileName + " " + timeStamp + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
}
