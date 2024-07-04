package com.galleryview.com.gv;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClientOrders {

	public ClientOrders(ChromeDriver driver) {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			// Open Side bar
			new SidebarClient(driver);
			WebElement createOrders = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'CREATE ORDER']")));
			createOrders.click();
					
			new CreateOrders(driver);
		}catch(Exception e) {
			System.out.print("");
		}
	}
}