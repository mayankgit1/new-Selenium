package com.galleryview.com.gv;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SideBarManageArtwork {
	public SideBarManageArtwork(ChromeDriver driver) {
		
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			new SidebarOpen(driver);
			WebElement manageArtProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Manage Artwork/Products']")));
			manageArtProduct.click();
			
			//Add New Artwork Product
			
		}catch(Exception e) {
			System.out.print("System Error");
		}
	}

}
