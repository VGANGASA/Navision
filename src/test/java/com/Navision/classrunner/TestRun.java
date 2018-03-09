package com.Navision.classrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "NavisionFeatures", glue = { "com.Navision.stepDefinitions" })

public class TestRun extends AbstractTestNGCucumberTests {

	public TestRun() {

	}

}