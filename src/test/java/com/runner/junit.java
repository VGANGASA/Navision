package com.testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


public class TestRunner {
	

@RunWith(Cucumber.class)
@CucumberOptions (features = "features",glue = "com.stepDefinitions" ,plugin = {"html:target/NavisionTestResult"})


//plugin = {"html:target//cucumber-html-report"}

//	plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
//			"junit:target/cucumber-reports/Cucumber.xml",
//			"html:target/cucumber-reports"},
//	format = {"pretty","html:C:/Users/Symbox Spare Account/AutomationProject/CoreProductAutomation/target/loginreports"}
	
	




	public class Runner {

	}
	
}
