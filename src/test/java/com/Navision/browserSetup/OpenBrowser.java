package com.Navision.browserSetup;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import com.Navision.dataProvider.ConfigFileReader;
import com.Navision.utility.Screenshots;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;



public class OpenBrowser {
	
	Screenshots ss = new Screenshots(driver);
	protected static WebDriver driver;
	
	public String errorMessage = "no such element exception: ";
	
	public ExtentReports report;
	public ExtentTest logger;
	
	
	
    /*public void capturescreenshot(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){		
			String ss_path = ss.captureScreenshot(driver, result.getName());
			String image = logger.addScreenCapture(ss_path);
			System.out.println("value for logger is : " + logger);
			logger.log(LogStatus.FAIL, "Title Verification",image);
			
		} else if (result.getStatus() == ITestResult.SKIP){
			String ss_path = ss.captureScreenshot(driver, result.getName());
			String image = logger.addScreenCapture(ss_path);
			logger.log(LogStatus.SKIP, "Title Verification",image);
			
		}else if(result.getStatus() == ITestResult.SUCCESS){
			String ss_path = ss.captureScreenshot(driver, result.getName());
			String image = logger.addScreenCapture(ss_path);
			logger.log(LogStatus.PASS, "Title Verification",image);
		}
		
		report.endTest(logger);
		report.flush();
	}
    
    public void startTest(){
		report = new ExtentReports("../Navision/target/extentreport.html");		
		
//		report = new ExtentReports(System.getProperty("user.dir")+ "/test-output/coreproduct.html",true); 
		report.addSystemInfo("Host Name", "Navision DevOps")
		.addSystemInfo("Environment","https://talent.capgemini.com/uk")
		.addSystemInfo("User Name", "Vijay");
		
//		report.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
	} 
	*/
    
   

	public static void setInstance(String browserName) {

		browserName = (browserName != null) ? browserName : "firefox";

		switch (Browser.valueOf(browserName.toUpperCase())) {
		case CHROME:
			setChromeDriver();
			break;
		case FIREFOX:
			setFirefoxDriver();
			break;
		default:
			break;
		}
	}

	private enum Browser {
		FIREFOX, CHROME,
	}

	private static WebDriver setChromeDriver() {
		
		System.setProperty("webdriver.chrome.driver", "../Navision/lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://talent.capgemini.com/uk");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return driver;
	}

	private static WebDriver setFirefoxDriver() {

		System.setProperty("webdriver.gecko.driver", "../Navision/lib/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://talent.capgemini.com/uk");
		return driver;
	}


    

}
