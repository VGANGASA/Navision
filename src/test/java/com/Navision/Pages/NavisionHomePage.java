package com.Navision.Pages;

import static org.junit.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Navision.browserSetup.OpenBrowser;

public class NavisionHomePage extends OpenBrowser {

	
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
	
	@FindBy(xpath = "//img[@src=\"/image/responsive/close-cross.jpg\"]") 
	WebElement homepagePopup;
	
	
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
	
	public WebElement gethomePagePopup() {
		return homepagePopup;
	}
	
	
	
	public void elementToBeClickable(WebElement locator) {
    	try{
    	wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
    	}catch(Exception e){fail(errorMessage);}
    }
	
	public int timeTable(){
		List<WebElement> elements = driver.findElements(By.xpath("//input[@class='Calendar_Tbx']"));
		return elements.size();
	}
	
	public  WebElement timeTabledata(int k){
		WebElement Cal_input = driver.findElement(By.xpath("(//input[@class='Calendar_Tbx'])[" + k + "]"));
		return Cal_input;
	}
	
	
	
}
