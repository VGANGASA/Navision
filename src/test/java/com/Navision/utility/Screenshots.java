package com.Navision.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
//import org.apache.commons.io.FileUtils;
import com.Navision.browserSetup.OpenBrowser;






public class Screenshots  {

	
	private WebDriver driver;

	public Screenshots(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	public void takeScreenShot(ITestResult testResult) throws IOException 
//	{
//	if (testResult.getStatus() == ITestResult.FAILURE) 
//	{
//	snapScreenShot("failure", testResult.getName());
//	}
//	else if (testResult.getStatus() == ITestResult.SUCCESS) 
//	{
//	snapScreenShot("passed", testResult.getName());
//	} 
//	else if (testResult.getStatus() == ITestResult.SKIP) 
//	{
//	snapScreenShot("skipped", testResult.getName());
//	}
//	}
	
//	public void snapScreenShot(String folder, String name) throws IOException 
//	{
//	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);              //container.getDriver()
//	String fileName = "\\Snapshots\\" + folder + "\\" + name + "_" + new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date()) + ".jpg";
//	String filePath = System.getProperties().get("user.dir") + fileName;
//	FileUtils.copyFile(scrFile, new File(filePath));
//	}
	
	public String captureScreenshot(WebDriver driver, String screenshotName){
		
		try {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);    
			String filedest = "../Navision/target/ScreenShots" + screenshotName +".png" ;
			File destination = new File(filedest);
			FileUtils.copyFile(scrFile, destination);
			return filedest;
		} catch (IOException e) {
			return e.getMessage();
			 
		}
		
	}
	
}
