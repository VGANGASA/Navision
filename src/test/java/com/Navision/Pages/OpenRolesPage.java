package com.Navision.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenRolesPage {

	
	@FindBy(xpath = "//*[contains(text(), 'Business Units')]")
	WebElement businessUnit; 
	
	@FindBy(css ="#nacb_left_menu > li > ul > li:nth-child(1) > span > span > a")
	WebElement delivery;
	
	@FindBy (xpath = "//a[@class='nav_as' and text()='Open Roles']")
	WebElement openRoles;
	
	@FindBy (xpath = "//a[contains(text(),'here')]")
	WebElement here;
	
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
}
