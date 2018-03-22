package com.Navision.stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import com.Navision.Pages.NavisionHomePage;
import com.Navision.browserSetup.OpenBrowser;
import com.Navision.utility.ExcelFunction;
import com.Navision.utility.ReUsableFunctions;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NavisionStepDefinitions extends OpenBrowser {

	public XSSFCell Cell;
	public String CellData;
	
	ReUsableFunctions reusable = new ReUsableFunctions();



	@Given("^user navigate to the URL https://talent\\.capgemini\\.com/uk$")
	public void user_navigate_to_the_URL_https_talent_capgemini_com_uk() throws Throwable {
		OpenBrowser.setInstance("CHROME");
	}

	@And("^user should see the home page$")
	public void user_should_see_the_home_page() throws Throwable {  
		Assert.assertEquals("United Kingdom Homepage | Talent Capgemini", reusable.getPageTitle());
		System.out.println("homepageTitle:: " + reusable.getPageTitle());		
	}
	@And("^user click on the BUs$")
	public void user_click_on_the_BUs() throws Throwable {
		NavisionHomePage homepage = new NavisionHomePage();
//		reusable.fliuentWait(homepage.gethomepageBU());
		homepage.gethomepageBU().click();

	}
	@And("^user click on the Sogeti UK$")
	public void user_click_on_the_Sogeti_UK() throws Throwable {
		NavisionHomePage homepage = new NavisionHomePage();
		homepage.gethomepageSogetiUK().click();
	}
	@When("^user is on Navision page then click on Navision$")
	public void user_is_on_Navision_page_then_click_on_Navision() throws Throwable {
		NavisionHomePage homepage = new NavisionHomePage();
		homepage.getnavision().click();
		System.out.println("NavisionPage title :: " + reusable.getPageTitle());
		Assert.assertEquals("Sogeti UK | Talent Capgemini", reusable.getPageTitle());
	}
	@And("^user should see the Navision page$")
	public void user_should_see_the_Navision_page() throws Throwable {
		NavisionHomePage homepage = new NavisionHomePage();
		
		String mainW = driver.getWindowHandle();
//		System.out.println("Main window handle is : " + mainW);
		Set<String> str = driver.getWindowHandles();
//		System.out.println("window handles are : " + str);
		Iterator<String> i1 = str.iterator();
		while (i1.hasNext()) {
			String childW = i1.next();
//			System.out.println("Child window : " + childW);
			if (!mainW.equalsIgnoreCase(childW)) {
				driver.switchTo().window(childW);
//				System.out.println("Child window url : " +reusable.getCurrenturl());
			}
		}
		homepage.getactivityList().click();
	}

	@Then("^user should able to enter the data into rows$")
	public void user_shouls_able_to_enter_the_data_into_rows() throws Throwable {
		ExcelFunction ef = new ExcelFunction();
		NavisionHomePage nh = new NavisionHomePage();

		String data[][] = ef.readData1("../Navision/testData/", "Data.xlsx", "sheet1");

		int j = 0;

		for (int k = 1; k <= nh.timeTable(); k++) {
			nh.timeTabledata(k).sendKeys(String.valueOf(data[1][j]));
			if (j == ((data[0].length) - 1)) {
				j = 0;
				break;
			} else {
				j++;
			}
		}
	}

	@After (order = 0)
	public void close() {
		driver.close();
//		 driver.quit();
	}
	
	@Before
	public void beforeScenario(Scenario scenario) {
	    Reporter.assignAuthor("Vijay");
	}
	
	@After(order = 1)
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				
				File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
				Files.copy(sourcePath, destinationPath);   
 				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			} catch (IOException e) {
			} 
		}
	}
	
	
	
	
	
}
