package com.Navision.stepDefinitions;

import org.testng.Assert;

import com.Navision.Pages.NavisionHomePage;
import com.Navision.Pages.OpenRolesPage;
import com.Navision.utility.ReUsableFunctions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OpenRolesStepDefinitions extends ReUsableFunctions {

	
	@Given("^user navigate to the url$")
	public void user_navigate_to_the_url() throws Throwable {
	   
	}

	@Given("^verify the homepage title$")
	public void verify_the_homepage_title() throws Throwable {
	    
	}

	@Given("^user able click on the BUs$")
	public void user_able_click_on_the_BUs() throws Throwable {
		NavisionHomePage homepage = new NavisionHomePage();
		Click(homepage.gethomepageBU());
		
	}

	@Given("^user able click on the SogetiUK$")
	public void user_able_click_on_the_SogetiUK() throws Throwable {
		NavisionHomePage homepage = new NavisionHomePage();
		Click(homepage.gethomepageSogetiUK());
	}

	@When("^user clicked on the Sogeti UK should see BUSINESS UNITS$")
	public void user_clicked_on_the_Sogeti_UK_should_see_BUSINESS_UNITS() throws Throwable {
		OpenRolesPage openRolepage = new OpenRolesPage();
		Assert.assertEquals(isDisplayed(openRolepage.getBusinesUnits()), true);
	}

	@When("^user should able to click delivery$")
	public void user_should_able_to_click_delivery() throws Throwable {
		OpenRolesPage openRolepage = new OpenRolesPage();
		Click(openRolepage.getDelivery());
	}

	@When("^user should able to click open roles$")
	public void user_should_able_to_click_open_roles() throws Throwable {
		OpenRolesPage openRolepage = new OpenRolesPage();
		Click(openRolepage.getOpenRoles());
		Click(openRolepage.getHere());
	}

	@Then("^user should see Open Roles$")
	public void user_should_see_Open_Roles() throws Throwable {
	    
	}

	@Then("^user able to click on here$")
	public void user_able_to_click_on_here() throws Throwable {
	    
	}

	@Then("^user should able to see Open Roles in new window$")
	public void user_should_able_to_see_Open_Roles_in_new_window() throws Throwable {
	 
	}

	@Then("^user shoild able to find the suitable role$")
	public void user_shoild_able_to_find_the_suitable_role() throws Throwable {
	 
	}

	
}
