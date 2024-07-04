package com.galleryview.com.gv;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GalleryLocations {
	public GalleryLocations(ChromeDriver driver) {
		ConfigReader config = new ConfigReader();
		
		String Locationname = config.getProperty("locationname");
    	String Street = config.getProperty("street");
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));			
			new SideBarAdmin(driver);
			
			//Gallery Location Button
			WebElement galleryLocations = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Gallery Locations']")));
			galleryLocations.click();
			
			//Location Name
			WebElement locationName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='locationName']")));
			locationName.sendKeys(Locationname);
			
			//Street Name
			WebElement street = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='street']")));
			street.sendKeys(Street);
			
			//Submit Button
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']"))).click();
			
			WebElement closeBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='CLOSE']")));
			closeBtn.click();
			
		}catch(Exception e) {
			System.out.print("System Error");
		}
	}
}
