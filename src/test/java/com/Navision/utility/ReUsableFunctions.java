package com.Navision.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.Navision.browserSetup.OpenBrowser;

public class ReUsableFunctions extends OpenBrowser {

	JavascriptExecutor js;

	// public ReUsableFunctions() {
	// this.driver = driver;
	// PageFactory.initElements(driver, this);
	// }

	public void Click(WebElement element) {
		try {
			waitForPageLoad();
			fliuentWait(element);
			element.click();
		} catch (NoSuchElementException exception) {
			fail(errorMessage + element);
		}
	}

	public String getText(WebElement element) {
		String text = "";
		try {
			// elementToBeVisible(element);
			text = element.getText();
		} catch (Exception e) {
			fail(errorMessage + element);
		}
		return text;
	}

	public boolean isDisplayed(WebElement element) {
		boolean isDisplayed = false;
		try {
			waitForPageLoad();
			scrollIntoView(element);
			isDisplayed = element.isDisplayed();
		} catch (Exception e) {
			fail(errorMessage + element);
		}
		return isDisplayed;
	}

	protected void scrollIntoView(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void waitForPageLoad() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			pause(1);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(expectation);
		} catch (Throwable error) {
			fail(errorMessage + error);
			// Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}

	public void fliuentWait(WebElement locator) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(60, TimeUnit.SECONDS).pollingEvery(3, TimeUnit.SECONDS)
				.until(ExpectedConditions.elementToBeClickable(locator));
		wait.ignoring(NoSuchElementException.class);

	}

	public void pause(int seconds) {

		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
		}
	}
	
	public void windowSwitch() {
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

	}

	public void fail(String errorMessage) {
		System.out.println("[-FAILED BECAUSE OF] " + errorMessage);
		Assert.assertTrue(false);
	}

}
