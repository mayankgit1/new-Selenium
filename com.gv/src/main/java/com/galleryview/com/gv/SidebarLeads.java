package com.galleryview.com.gv;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SidebarLeads {
	public SidebarLeads(ChromeDriver driver) {
		
		try {
			
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			new SidebarOpen(driver);
		    
		    //Open Leads
		    WebElement lead = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text() = 'Leads']")));
		    lead.click();
		    
		}catch(Exception e) {
			System.out.print("");
		}
	}
}
