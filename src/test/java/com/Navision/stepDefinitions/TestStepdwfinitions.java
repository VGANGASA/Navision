package com.Navision.stepDefinitions;

import cucumber.api.java.en.Given;

public class TestStepdwfinitions {

	
	@Given("^user should enter the ([^\"]*) and ([^\"]*)$")
	public void user_should_enter_the_tester_and_helo(String UserName, String Passowrd) throws Throwable {
		
		
		System.out.println(UserName + " and "+ Passowrd);  
	}

}
