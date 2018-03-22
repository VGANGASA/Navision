package com.Navision.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Navision.browserSetup.OpenBrowser;

public class OpenRolesPage extends OpenBrowser {

	
	@FindBy(xpath = "(//*[contains(text(), 'Business Units')])[2]")
	WebElement businessUnit; 
	
	@FindBy(css ="#nacb_left_menu > li > ul > li:nth-child(1) > span > span > a")
	WebElement delivery;
	
	@FindBy (xpath = "//a[@class='nav_as' and text()='Open Roles']")
	WebElement openRoles;
	
	@FindBy (xpath = "//a[contains(text(),'here')]")
	WebElement here;
	
	@FindBy (xpath = "//*[@id=\"layoutsTable\"]/tbody/tr/td[1]/div/div/span[2]")
	WebElement welcomeMessage;
	
	@FindBy (xpath = "(//table[@class='s4-wpTopTable']//tbody)[3]")
	WebElement openRolesTable;
	
	@FindBy(tagName = "td")
	WebElement openTableTag_td;
	
	@FindBy (css = "#layoutsTable > tbody > tr > td:nth-child(1) > div > div > div > div:nth-child(2) > span:nth-child(1) > strong")
	WebElement openRolesMessage;
	
	@FindBy(xpath = "//*[@class='ms-vb2']")
	 List<WebElement> openRolesLevel;
	
	public OpenRolesPage() {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getBusinesUnits() {
		return businessUnit;		
	}
	
	public WebElement getDelivery() {
		return delivery;		
	}
	
	public WebElement getOpenRoles() {
		return openRoles;
	}
	
	public WebElement getHere() {
		return here;
	}
	
	public WebElement getWelcomeMessage() {
		return welcomeMessage;
	}
	
	public WebElement getOpenRolesTable() {
		return openRolesTable;
	}
	
	public WebElement getOpenRolesTable_tg() {
		return openTableTag_td;
	}
	
	public int getopenRolesTable_tr_size() {
		List<WebElement> tr = getOpenRolesTable().findElements(By.tagName("tr"));
		return tr.size();		
	}
	
	public int getopenRolesTable_td_size() {
		List<WebElement> td = getOpenRolesTable().findElements(By.tagName("td"));
		return td.size();		
	}
	
	public WebElement getopenRolesMessage() {
		return openRolesMessage;
	}
	
	public List<WebElement> getopenRolesLevel() {
		return openRolesLevel;
	}
	
}
