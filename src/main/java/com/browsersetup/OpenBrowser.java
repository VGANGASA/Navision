package com.browsersetup;

import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class OpenBrowser {
	
	
	protected static WebDriver driver;

	public static void setInstance(String browserName) {

		browserName = (browserName != null) ? browserName : "firefox";

		switch (Browser.valueOf(browserName.toUpperCase())) {
		case CHROME:
			setChromeDriver();
			break;
		case FIREFOX:
			setFirefoxDriver();
			break;
		default:

			break;
		}
	}

	private enum Browser {
		FIREFOX, CHROME,
	}

	private static WebDriver setChromeDriver() {

		System.setProperty("webdriver.chrome.driver", "../Navision/lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://talent.capgemini.com/uk");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
		return driver;
	}

	private static WebDriver setFirefoxDriver() {

		System.setProperty("webdriver.gecko.driver", "../Navision/lib/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://talent.capgemini.com/uk");
		return driver;
	}

	
	public String getPageTitle() {
		String Title = driver.getTitle();
		return Title;
	}
	
	public String getCurrenturl() {
		String Title = driver.getCurrentUrl();
		return Title;
	}
	
	

}
