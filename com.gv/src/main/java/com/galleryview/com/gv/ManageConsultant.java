package com.galleryview.com.gv;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageConsultant {
	public ManageConsultant(ChromeDriver driver) {
		ConfigReader config = new ConfigReader();  
		
		String FirstName = config.getProperty("firstName");
    	String LastName = config.getProperty("lastName");
        String MobilePhone = config.getProperty("mobilePhone");
        String EmailAddress = config.getProperty("emailAddress");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		try {
			
			new SideBarAdmin(driver);
		
			WebElement manageConsultantBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Manage Consultants']")));
			manageConsultantBtn.click();
			
			WebElement addConsultant = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='ADD CONSULTANT']")));
			addConsultant.click();
			
			//Your Details Form:
			WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("First_Name")));
			firstName.sendKeys(FirstName);
			
			WebElement lastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastname")));
			lastName.sendKeys(LastName);
			
			WebElement mobilePhn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Mobile_Phone")));
			mobilePhn.sendKeys(MobilePhone);
			
			WebElement emailAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email_Address")));
			emailAddress.sendKeys(EmailAddress);
			
			//Selecting Role:
			WebElement selectRole = driver.findElement(By.xpath("(//span[@class='ant-checkbox']//input)[6]"));
			selectRole.click();
			
			//Selecting Locations:
			WebElement selectLocations = driver.findElement(By.xpath("(//span[@class='ant-checkbox']//input)[8]"));
			selectLocations.click();
			
			//Access Rights
			driver.findElement(By.id("labelAccess")).click();			//Labels
			driver.findElement(By.id("ordersAccess")).click();			//Orders Screen
			driver.findElement(By.id("integrationAccess")).click();		//Access Website Integrations
			driver.findElement(By.id("productsAccess")).click();		//Manage Artwork/Products			
			
			//Select Calendar Color
			WebElement calendarColor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@style,'background-color: rgb(174, 200, 206)')]")));
			calendarColor.click();
			
			//Upload Image
			WebElement profilePic = driver.findElement(By.xpath("//div[contains(@class,'ant-upload-select')]/span/input"));
			profilePic.sendKeys("C:\\Users\\Cloud Analogy\\Downloads\\Walls\\testimage.webp");
			
			//Save Consultant
			WebElement saveBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='SAVE']")));
			saveBtn.click();
			
			
		}catch(Exception e) {
		System.out.print("Error Not Found");
	}
	}
}
