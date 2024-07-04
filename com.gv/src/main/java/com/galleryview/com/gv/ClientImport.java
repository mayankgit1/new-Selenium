package com.galleryview.com.gv;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClientImport {
	
		public ClientImport (ChromeDriver driver) {

			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				new SideBarAdmin(driver);			
			
				//Click to Import Clients
				WebElement importClient = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Import/Export Clients')]")));
				importClient.click();
				
				// Locate the file input element
				WebElement selectFile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@type, 'file')]")));
				selectFile.sendKeys("C:\\Users\\Cloud Analogy\\Downloads\\Excel Sheet\\Live Clients.csv");
	
				WebElement clientImp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'IMPORT CLIENTS')]")));
				clientImp.click();
				
				}catch (NoSuchElementException e) {
			        System.out.println("Element not found: " + e.getMessage());
			        e.printStackTrace();
			    } 
	}
}