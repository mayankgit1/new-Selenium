package com.galleryview.com.gv;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClientLeads {
	public ClientLeads(ChromeDriver driver) {
		
		try {
			//Open Client for Lead creations
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			new SidebarClient(driver);
			WebElement addLead = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() ='ADD LEAD']")));
			addLead.click();

			System.out.print("Log-1");
			new CreateLeads(driver);
			
			System.out.print("Log-2");
			
		}catch(Exception e) {
			System.out.print("Elements not found, Client Lead error");
			
		}
	}

}
