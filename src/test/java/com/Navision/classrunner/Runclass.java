package com.Navision.classrunner;

import java.io.File;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.Navision.manager.FileReaderManager;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "NavisionFeatures/Navision.feature", glue = {"com.Navision.stepDefinitions"},
                 plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
                 monochrome = true)
 
public class Runclass {

	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
//		Reporter.setSystemInfo("User Name", System.getProperty("user.dir"));
//		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
//	    Reporter.setSystemInfo("Machine Name", 	"Windows 10" + "64 Bit");
//	    Reporter.setSystemInfo("Selenium Version", "3.7.0");
//	    Reporter.setSystemInfo("Maven Version", "3.5.2");
//	    Reporter.setSystemInfo("Java Version", "1.8.0_151");	
	}
}


/*plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
monochrome = true
*/


//format = {"pretty","html:target/NavisionTestResult" }