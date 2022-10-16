package com.mycompany.app.Testartifact;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import Utilities.Excelutil;
import io.github.bonigarcia.wdm.WebDriverManager;
public class AppTest {
	
	WebDriver driver;
	@Parameters({"url"})
	@BeforeMethod
	public void loginpage(String url) {
		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get(url);
	}
	@DataProvider(name = "Data")
	public Object[][] shipmentData() throws IOException, InvalidFormatException {
		Object[][] object = null;
//		Excelutil file = new Excelutil();
		FileInputStream file = new FileInputStream(new File("/Users/jag_diya/Selenium/Testartifact/src/Datasheet.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		// Read keyword sheet
		Sheet sheet = workbook.getSheet("Sheet1");
//		Sheet sheet = file.readExcel("/Users/jag_diya/Selenium/Testartifact/src/Datasheet.xlsx",
//				"//", "Sheet1");
		// Find number of rows in excel file
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		object = new Object[rowCount][2];
		for (int i = 0; i < rowCount; i++) {
			// Loop over all the rows
			Row row = sheet.getRow(i + 1);
			// Create a loop to print cell values in a row
			for (int j = 0; j < row.getLastCellNum(); j++) {
				// Print excel data in console
				object[i][j] = row.getCell(j).toString();
				System.out.println(object[i][j]);
			}
		}
		return object;
	}
    @Test(dataProvider="Data")
	public void login (String username, String password) {
//    	driver.findElement(By.xpath("//input[@name='accept']")).click();
				
        driver.findElement(By.xpath("//span[normalize-space()='Account & Lists']")).click();
    
		
		driver.findElement(By.xpath("//input[@type='email']")).click();
		
		driver.findElement(By.xpath("//input[@type='email']")).clear();
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(username);
	
       driver.findElement(By.xpath("//input[@id='continue']")).click();
       
       driver.findElement(By.xpath("//input[@type='password']")).click();
       
       driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
       
       driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
      
//        ca
	}
  
    
    @AfterMethod
	public void logout() 
    {		
		driver.quit();
	}
    
}
   