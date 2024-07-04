package com.galleryview.com.gv;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SideBarAdmin {
	public SideBarAdmin(ChromeDriver driver) {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			// Open Side bar
			new SidebarOpen(driver);
			
			//Open Admin Section
			WebElement admin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Admin')]")));
			admin.click();
			
			
		}catch(Exception e) {
			System.out.print("Element Error Not Found");
			
		}
	}

}
