package com.Navision.stepDefinitions;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.Navision.Pages.OpenRolesPage;
import com.Navision.utility.ReUsableFunctions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class OpenRolesStepDefinitions extends ReUsableFunctions {

	OpenRolesPage openRolepage = new OpenRolesPage();
	NavisionStepDefinitions ns = new NavisionStepDefinitions();
		

	@When("^user clicked on the Sogeti UK should see BUSINESS UNITS$")
	public void user_clicked_on_the_Sogeti_UK_should_see_BUSINESS_UNITS() throws Throwable {
		OpenRolesPage openRolepage = new OpenRolesPage();
		Assert.assertEquals(isDisplayed(openRolepage.getBusinesUnits()), true);
	}

	@And("^user should able to click delivery$")
	public void user_should_able_to_click_delivery() throws Throwable {
		OpenRolesPage openRolepage = new OpenRolesPage();
		Click(openRolepage.getDelivery());
	}

	@And("^user should able to click open roles$")
	public void user_should_able_to_click_open_roles() throws Throwable {		
		Click(openRolepage.getOpenRoles());		
	}

	@Then("^user should see Open Roles$")
	public void user_should_see_Open_Roles() throws Throwable {
		Assert.assertEquals("Open Roles | Talent Capgemini", getPageTitle());
		System.out.println("Open roles have seen");
		
	}

	@And("^user able to click on here$")
	public void user_able_to_click_on_here() throws Throwable {
		Click(openRolepage.getHere());
	}

	@Then("^user should able to see Open Roles in new window$")
	public void user_should_able_to_see_Open_Roles_in_new_window() throws Throwable {
		windowSwitch();
		System.out.println("window has been switched ::: " + getText(openRolepage.getopenRolesMessage()));
	}

	@Then("^user should able to find the suitable role$")
	public void user_shoild_able_to_find_the_suitable_role() throws Throwable {
		Assert.assertEquals(isDisplayed(openRolepage.getWelcomeMessage()), true);
		System.out.println("open roles tr size :: " + openRolepage.getopenRolesTable_tr_size());
		System.out.println("open roles td size :: " + openRolepage.getopenRolesTable_td_size());
		
		if(openRolepage.getopenRolesTable_tr_size() > 1) {
			for(int i = 0; i<openRolepage.getopenRolesTable_tr_size(); i++) {
				for(WebElement element : openRolepage.getopenRolesLevel()) {
					String tagName = getText(element);
					if(!tagName.equals(null)){
					System.out.println("tag Name is ::: " + tagName);
						element.click();
						break;
					}else {
						System.out.println("tag name is null :: " + element);
					}
				}
				
			}
		}	
	}
}
