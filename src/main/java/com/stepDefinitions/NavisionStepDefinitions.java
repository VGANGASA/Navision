package com.stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.browsersetup.OpenBrowser;
import com.navisionPages.NavisionHomePage;
import org.apache.poi.xssf.usermodel.XSSFCell;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NavisionStepDefinitions extends OpenBrowser {

	public XSSFCell Cell;
	public String CellData;
	
	@Given("^user navigate to the URL https://talent\\.capgemini\\.com/uk$")
	public void user_navigate_to_the_URL_https_talent_capgemini_com_uk() throws Throwable {
		OpenBrowser.setInstance("CHROME");

	}

	@Given("^user should see the home page$")
	public void user_should_see_the_home_page() throws Throwable {
		String homepageTitle = driver.getTitle();
		Assert.assertEquals("United Kingdom Homepage | Talent Capgemini", homepageTitle);
		System.out.println("homepageTitle:: " + homepageTitle);

	}

	@When("^user should navigate to the Navision page$")
	public void user_should_navigate_to_the_Navision_page() throws Throwable {
		NavisionHomePage homepage = new NavisionHomePage();
		// homepage.elementToBeClickable(homepage.gethomepageBU());
		homepage.gethomepageBU().click();
		homepage.gethomepageSogetiUK().click();
		homepage.getnavision().click();
		System.out.println("NavisionPage title :: " + getPageTitle());
		Assert.assertEquals("Sogeti UK | Talent Capgemini", getPageTitle());

	}

	@When("^user should see the Navision page$")
	public void user_should_see_the_Navision_page() throws Throwable {
		NavisionHomePage homepage = new NavisionHomePage();

		String mainW = driver.getWindowHandle();
		System.out.println("Main window handle is : " + mainW);
		Set<String> str = driver.getWindowHandles();
		System.out.println("window handles are : " + str);
		Iterator<String> i1 = str.iterator();
		while (i1.hasNext()) {
			String childW = i1.next();
			System.out.println("Child window : " + childW);
			if (!mainW.equalsIgnoreCase(childW)) {
				driver.switchTo().window(childW);
				System.out.println("Child window url : " + getCurrenturl());
			}
		}
		homepage.getactivityList().click();
	}

	@Then("^user should able to enter the data into rows$")
	public void user_shouls_able_to_enter_the_data_into_rows() throws Throwable {
		NavisionHomePage homepage = new NavisionHomePage();

		try {
			File file = new File("../Navision/testData/Data.xls"); 
			FileInputStream inputStream = new FileInputStream(file);
			XSSFWorkbook wbook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = wbook.getSheetAt(0);
			
			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
			for (int i = 1; i < rowCount + 1; i++) {
				Row row = sheet.getRow(i);
				for (int j = 0; j < row.getLastCellNum(); j++) {
					Cell = sheet.getRow(i).getCell(j);
					CellType type = Cell.getCellTypeEnum();
					
					if(type == CellType.STRING) {
						CellData = Cell.getStringCellValue();
						System.out.println("Cell value 1 :: " + CellData);
					}else if(type == CellType.STRING.NUMERIC) {
						CellData = new Double(Cell.getNumericCellValue()).toString();
						System.out.println("Cell value 2 :: " + CellData);
					}
				
				List<WebElement> element = driver.findElements(By.xpath("//*[@id=\"TableCalendarLeft\"]//td"));
				int tablesize = element.size();
				System.out.println("Calander table size is : " + tablesize);

				if (tablesize > 1) {
					for (int k = 4; k <= tablesize; k++) {
						WebElement Cal_input = driver.findElement(By.xpath("//*[@id='Tbx_Calendar" +k+ "']"));
						
						Cal_input.sendKeys(String.valueOf(CellData));
					}
				}
			}
		}

			wbook.close();
			inputStream.close();
		} catch (FileNotFoundException ff) {
			ff.printStackTrace();
		}
	}

	/*
	 * @After public void close() { driver.close(); driver.quit(); }
	 */
}
