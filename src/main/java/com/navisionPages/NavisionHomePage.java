package com.navisionPages;

import static org.junit.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.browsersetup.OpenBrowser;

public class NavisionHomePage extends OpenBrowser {

	public String errorMessage = "no such element exception: ";
	WebDriverWait wait;
	
	@FindBy(xpath = "//a[@class='megamenu_primary page  carets' and text()='BUs']")
	WebElement homepageBU; 

	@FindBy(xpath = "(//a[text()='Sogeti UK'])[1]")
	WebElement homepageSogetiUK;

	@FindBy(xpath = "//*[text()='Navision']") 
	WebElement navision;

	@FindBy(id = "ctl00_MenuForm1_Hl_CardActivity") 
	WebElement activityCard;
	
	@FindBy(id = "TableCalendarLeft") 
	WebElement activityCardTable;
	
	
	public NavisionHomePage() {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement gethomepageBU() {
		return homepageBU;
	}

	public WebElement gethomepageSogetiUK() {
		return homepageSogetiUK;
	}

	public WebElement getnavision() {
		return navision;
	}
	public WebElement getactivityList() {
		return activityCard;
	}
	public WebElement getactivityCardTable() {
		return activityCardTable;
	}
	
	
	
	public void elementToBeClickable(WebElement locator) {
    	try{
    	wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
    	}catch(Exception e){fail(errorMessage);}
    }
	
	
	
	
}
